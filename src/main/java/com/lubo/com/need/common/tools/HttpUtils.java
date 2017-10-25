package com.lubo.com.need.common.tools;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 * @author Administrator
 *
 */
@Slf4j
public class HttpUtils {
	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	private static OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
			.readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).build();

	public static String okhttpGet(String url, Map<String, String> params) {
		url += "?";
		for (Entry<String, String> entry : params.entrySet()) {
			url += entry.getKey() + "=" + entry.getValue() + "&";
		}
		return okhttpGet(url.substring(0, url.length() - 1));
	}

	public static String okhttpGet(String url) {
		String result = "";
		try {
			Request request = new Request.Builder().url(url).build();
			Response response = okHttpClient.newCall(request).execute();
			if (response.isSuccessful()) {
				result = response.body().string();
			}
		} catch (IOException e) {
			log.error("", e);
		}
		return result;
	}

	public static String okhttpPost(String url, Map<String, String> params) {
		String result = "";
		try {
			Builder builder = new FormBody.Builder();
			for (String key : params.keySet()) {
				builder.add(key, params.get(key));
			}
			RequestBody formBody = builder.build();

			Request request = new Request.Builder().url(url).post(formBody).build();
			Response response = okHttpClient.newCall(request).execute();
			if (response.isSuccessful()) {
				result = response.body().toString();
			}
		} catch (Exception e) {
			log.error("", e);
		}
		return result;
	}

	public static void okhttpPostAsync(String url, Map<String, String> params) {
		try {
			Builder builder = new FormBody.Builder().add("no-use", "");
			for (String key : params.keySet()) {
				builder.add(key, params.get(key));
			}
			RequestBody formBody = builder.build();

			Request request = new Request.Builder().url(url).post(formBody).build();
			okHttpClient.newCall(request).enqueue(new Callback() {

				@Override
				public void onResponse(Call arg0, Response response) throws IOException {
					if (!response.isSuccessful()) {
						log.info(new StringBuffer("http异步请求成功，响应消息 [").append(response.body().toString()).append("]")
								.toString());
					}
				}

				@Override
				public void onFailure(Call arg0, IOException e) {
					log.error("http异步请求失败");
				}
			});
		} catch (Exception e) {
			log.error("", e);
		}
	}

	public static void main(String[] args) {
	}
}
