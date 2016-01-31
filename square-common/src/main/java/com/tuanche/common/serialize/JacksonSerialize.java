package com.tuanche.common.serialize;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;



/**
 * <p>Json与Entity互相转化</p>
 * 
 * <PRE
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * <PRE>
 * 
 * @editor wanghl
 * @since 1.0
 * @version 1.0
 * @from afi
 */

public class JacksonSerialize {

	private static ObjectMapper mapper = new ObjectMapper();
	
	static{
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	/**
	 * 
	 * 将json转换成Entity
	 *
	 * @author afi
	 * @param json	要转换的json数据
	 * @param clazz	目标实体
	 * @return	Entity	转换后的实体对象
	 * @throws BusinessException	类型转换异常
	 */
	public static <T> T json2Entity(final String json, final Class<T> clazz) {//throws BusinessException {
		T entity = null;
		try {
			entity = mapper.readValue(json, clazz);
		} catch (final IOException e) {
			//throw new BusinessException("Json转换成Entity时出现异常。", e);
		}
		return entity;
	}

	
	/**
	 * 
	 * 将自定义对象转json
	 *
	 * @author afi
	 *
	 * @param o
	 * @return	json	转换后的json数据
	 * @throws BusinessException	类型转换异常
	 */
	public static String Object2Json(final Object o) {//throws BusinessException {
		final StringWriter writer = new StringWriter();
		try {
			mapper.writeValue(writer, o);
		} catch (final IOException e) {
			//throw new BusinessException("Entity转换成Json时出现异常。", e);
		}
		return writer.toString();
	}
	
	

	/**
	 * 
	 * 将Json转换成List类型集合
	 *
	 * @author afi
	 *
	 * @param json	要转换的json数据
	 * @param clazz	转换后的实体类型
	 * @return	转换后的实体集合
	 * @throws BusinessException	类型转换异常
	 */
	public static <T> List<T> json2List(final String json, final Class<T> clazz) {//throws BusinessException {
		final JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
		List<T> list  =  null;
		try {
			list  = mapper.readValue(json, javaType);
		} catch (final JsonParseException e) {
			//throw new BusinessException("Json转换成List<T>异常。", e);
		} catch (final JsonMappingException e) {
			//throw new BusinessException("Json转换成List<T>异常。", e);
		} catch (final IOException e) {
			//throw new BusinessException("Json转换成List<T>异常。", e);
		}
		
		return list;
		
	}


	/**
	 * 
	 * 将json数据转换成Map
	 *
	 * @author afi
	 *
	 * @param json	要转换的json数据
	 * @return	Map 转换后的结果
	 * @throws BusinessException	类型转换异常
	 */
	public static Map<?, ?> json2Map(final String json) {//throws BusinessException {
		if (json == null || json.length() == 0) {
			return null;
		}
		Map<?, ?> result = null;
		try {
			result = mapper.readValue(json, Map.class);
		} catch (final IOException e) {
			
			//throw new BusinessException("Json转换成Map时出现异常。", e);
		}
		return result;
	}



	/**
	 * 根据字段名称，获取jsonNode
	 * @param jsonStr
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static JsonNode getField(final String jsonStr, final String fieldName) throws Exception {

		if (jsonStr == null) {
			return null;
		}
		if (fieldName == null) {
			return null;
		}
		JsonNode rootNode = json2Entity(jsonStr, JsonNode.class);
		if (rootNode == null) {
			return null;
		}
		for (final String thisFN : fieldName.split("\\.")) {
			rootNode = rootNode.get(thisFN);
		}
		return rootNode;
	}

	/**
	 * 根据字段名称，获取json字符串
	 * @param jsonStr
	 * @param fieldName
	 * @return
	 * @throws Exception
	 */
	public static String getFieldString(final String jsonStr, final String fieldName) throws Exception {
		if (jsonStr == null) {
			return null;
		}
		final JsonNode rootNode = json2Entity(jsonStr, JsonNode.class);
		if (rootNode == null) {
			return null;
		}
		final JsonNode path = rootNode.path(fieldName);
		if (!path.isMissingNode()) {
			return path.toString();
		} else {
			return null;
		}
	}
	
	public static void main(String args[]){
		/*Map<String,String> map = new HashMap<String,String>();
		map.put("jsonMap1","jsonMap1");
		map.put("jsonMap2","jsonMap2");
		map.put("jsonMap3","jsonMap3");
		List<Map> list = new ArrayList<Map>();
		list.add(map);
		list.add(map);
		list.add(map);
		
		
		List<String> listString = new ArrayList<String>();
		listString.add("jsonString1");
		listString.add("jsonString2");
		listString.add("jsonString3");
		Map<String,List> mapList = new HashMap<String,List>();
		mapList.put("mapList1", listString);
		mapList.put("mapList2", listString);
		mapList.put("mapList3", listString);
		
		
		Map<String,String> mapObject =  new HashMap<String,String>();
		mapObject.put("map1", "map1");
		mapObject.put("map2", "map2");
		mapObject.put("map3", "map3");
		
		Map<String,Map> maps =  new HashMap<String,Map>();
		maps.put("maps1", mapObject);
		maps.put("maps2", mapObject);
		maps.put("maps3", mapObject);
		
		
		//实体类转化json
		String listJson = JacksonSerialize.Object2Json(list);
		System.out.println(listJson);
		String mapJson = JacksonSerialize.Object2Json(mapList);
		System.out.println(mapJson);
		String mapsJson = JacksonSerialize.Object2Json(maps);
		System.out.println(mapsJson);
		//json转化List
		List<Map> listEntity =  JacksonSerialize.json2List(listJson, Map.class);
		System.out.println(listEntity.get(0).get("jsonMap1"));
		Map<String,List> mapListEntity  = (Map<String, List>) JacksonSerialize.json2Map(mapJson);
		System.out.println(mapListEntity.get("mapList1").get(0));
		Map<String,Map> mapsEntity  = (Map<String, Map>) JacksonSerialize.json2Map(mapsJson);
		System.out.println(mapsEntity.get("maps1").get("map1"));
		//获取json字段
		try {
			String stringName = JacksonSerialize.getFieldString(mapsJson, "maps3");
			System.out.println(stringName);
			JsonNode StringNode =  JacksonSerialize.getField(mapsJson, "maps3");
			System.out.println(StringNode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
}
