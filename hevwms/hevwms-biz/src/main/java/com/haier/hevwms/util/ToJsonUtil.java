package com.haier.hevwms.util;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class ToJsonUtil {
	/**
	 * 	生成json时，过滤值为null的属性
	 * @return
	 */
	public static JsonConfig getConfig(){
		JsonConfig config = new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter() {
			@Override
			public boolean apply(Object object, String name, Object value) {
				if (value == null) {
					return true;
				}
				return false;
			}
		});
		config.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
		return config;
	}
	/**
	 *   分页封装的jsonobject
	 * @param list
	 * @param size
	 * @return
	 */
	public static JSONObject getJsonObject(List list, long size) {
		JsonConfig config = getConfig();
		JSONObject json = new JSONObject();
		json.put("rows", JSONArray.fromObject(list, config));
		json.put("total", size);
		return json;
	}
	/**
	 * 	将list封装成json
	 * @param list
	 * @return
	 */
	public static JSONArray getJsonArray(List list){
		JsonConfig config = getConfig();
		JSONArray array=JSONArray.fromObject(list,config);
		return array;
	}

}
