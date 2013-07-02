package com.match.cp.utils;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

/**使用jackson处理JSON数据的工具类，其他有要转换成JSON格式数据，或者解析JSON格式数据的方法都可以在这里添加
 * @author zhengfc
 *
 */
@SuppressWarnings("rawtypes")
public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();
	/**
	 * Jackson: json data into Map
	 * @param json
	 * @return
	 */
	public static Map jsonToMap(String json){
		try {
			return objectMapper.readValue(json, Map.class);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static String mapToJson(Map map){
		try {
			return objectMapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**Jackson: List <Model> data into json string
	 * @param list
	 * @return json:[{},{},{}]
	 * zhengfc,2012-07-31
	 */
	public static String listToJson(List list){
		try {
			return objectMapper.writeValueAsString(list);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	

}
