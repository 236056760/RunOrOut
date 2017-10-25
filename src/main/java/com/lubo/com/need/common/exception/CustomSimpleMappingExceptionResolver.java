package com.lubo.com.need.common.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author liangyuyang
 * @date 2014年12月30日下午2:15:26
 * @description 当在系统应用中出现普通异常时，根据是系统异常还是应用异常，跳到相应的界面，
 *              ajax请求出现异常时，在ajax的success中可直接获得异常信息。普通的异常我们都配置好了界面，系统会自动跳转
 */
@Slf4j
public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// 输出到错误日志
		log.error("", ex);
		BusinessException businessException = getBusinessException(ex);

		String viewName = determineViewName(ex, request);
		if (viewName != null) {// JSP格式返回
			if (!(request.getHeader("accept").indexOf("application/json") > -1
					|| (request.getHeader("X-Requested-With") != null
							&& request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
				// 如果不是异步请求
				Integer statusCode = determineStatusCode(request, viewName);
				if (statusCode != null) {
					applyStatusCodeIfPossible(request, response, statusCode);
				}
				return getModelAndView(viewName, businessException, request);
			} else {// JSON格式返回
				try {
					PrintWriter pw = response.getWriter();
					pw.write(businessException.getMessage());
					pw.close();
				} catch (IOException e) {
					log.error("", e);
				}
				return null;
			}
		} else {
			return null;
		}
	}

	// 这里要获取到最内层的异常
	@SuppressWarnings("unused")
	private static Throwable parseException(Throwable e) {
		Throwable tmp = e;
		int breakPoint = 0;
		while (tmp.getCause() != null) {
			if (tmp.equals(tmp.getCause())) {
				break;
			}
			tmp = tmp.getCause();
			breakPoint++;
			if (breakPoint > 1000) {
				break;
			}
		}
		return tmp;
	}

	private BusinessException getBusinessException(Throwable e) {
		if (e instanceof MaxUploadSizeExceededException) {
			return new BusinessException("上传文件超过限定大小10M");
		} else if (e instanceof RuntimeException) {
			return new BusinessException(e);
		}
		return new BusinessException("程序内部发生错误，操作失败");
	}
}
