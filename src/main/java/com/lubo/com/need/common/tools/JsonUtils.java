package com.lubo.com.need.common.tools;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lubo.com.need.common.domian.pojo.UserInfo;

/**
 * 
 * @author liangyuyang
 * @date 2014年3月19日下午12:15:49
 * @Description 对象与json字符串的互转
 */
public class JsonUtils {
	public static ObjectMapper mapper = new ObjectMapper();

	/**
	 * 
	 * @author highjet.liangyuyang
	 * @date 2014年3月19日下午2:58:17
	 * @Description List转化成json字符串
	 * @param list
	 *            泛型的List集合
	 * @return json字符串
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public static <T> String ListToJson(List<T> list) throws JsonProcessingException {
		return JsonUtils.mapper.writeValueAsString(list);
	}

	/**
	 * 
	 * @author highjet.liangyuyang
	 * @date 2014年3月19日下午3:02:55
	 * @Description Object对象转化成json字符串
	 * @param t
	 *            泛型的实体对象
	 * @return json字符串
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	public static <T> String ObjectToJson(T t) throws JsonProcessingException {
		return JsonUtils.mapper.writeValueAsString(t);
	}

	/**
	 * 
	 * @author highjet.liangyuyang
	 * @date 2014年3月19日下午3:13:47
	 * @Description 将Map转化成json字符串
	 * @param map
	 *            Map对象
	 * @return json字符串
	 * @throws JsonProcessingException
	 */
	public static <T> String MapToJson(Map<String, Object> map) throws JsonProcessingException {
		String jsonStr = JsonUtils.mapper.writeValueAsString(map);
		return jsonStr;
	}

	/**
	 * 
	 * @author highjet.liangyuyang
	 * @date 2014年3月19日下午2:47:35
	 * @Description 将json字符串转成List<T>集合
	 * @param jsonStr
	 *            json字符串
	 * @param t
	 *            数组集合
	 * @return List<T>集合
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> JsonToList(String jsonStr, T[] t)
			throws JsonParseException, JsonMappingException, IOException {
		T[] codeArray = (T[]) JsonUtils.mapper.readValue(jsonStr, t.getClass());
		return Arrays.asList(codeArray);

	}

	/**
	 * 
	 * @author highjet.liangyuyang
	 * @date 2014年3月19日下午2:40:36
	 * @Description json字符串转成对象
	 * @param jsonStr
	 *            json字符串
	 * @param t
	 *            转化的对象
	 * @return 对象
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T JsonToObject(String jsonStr, T t) throws JsonParseException, JsonMappingException, IOException {
		Object object = JsonUtils.mapper.readValue(jsonStr, t.getClass());
		return (T) object;
	}

	/**
	 * 
	 * @author highjet.liangyuyang
	 * @date 2014年3月19日下午3:26:42
	 * @Description 将json字符串转成Map集合
	 * @param jsonStr
	 *            json字符串
	 * @return Map集合
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> JsonToMap(String jsonStr)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, Object> map = JsonUtils.mapper.readValue(jsonStr, Map.class);
		return map;
	}

	public static void main(String[] args) throws Exception {
		UserInfo userInfo = new UserInfo();
		userInfo = JsonUtils.JsonToObject(
				"{\"openid\":\"oves8waXMhxdD9uFVBaFrOTjaH3c\",\"nickname\":\"博爱无涯\",\"sex\":1,\"language\":\"zh_CN\",\"city\":\"广州\",\"province\":\"广东\",\"country\":\"中国\",\"headimgurl\":\"\",\"privilege\":[],\"unionid\":\"osxjh0WPE-tW-M6PfRrqpxKarB2k\"}",
				userInfo);
		System.out.println(userInfo);
	}
}
