package com.haier.openplatform.showcase.security.domain.enu;

import java.util.HashMap;
import java.util.Map;

import com.haier.openplatform.security.LoginContextHolder;

/**
 * 资源类型枚举
 * @author WangXuzheng
 * 
 */
public enum ResourceTypeEnum {
	URL_RESOURCE(0,new HashMap<String,String>()),COMPONENT_RESOURCE(1,new HashMap<String,String>());
	static{
		URL_RESOURCE.getDescMap().put("zh_CN", "URL资源");
		URL_RESOURCE.getDescMap().put("en_US", "URL Resource");
		COMPONENT_RESOURCE.getDescMap().put("zh_CN", "组件资源");
		COMPONENT_RESOURCE.getDescMap().put("en_US", "Module Resource");
	}
	private static final Map<Integer,ResourceTypeEnum> CACHE = new HashMap<Integer,ResourceTypeEnum>(){
		private static final long serialVersionUID = 2334886698187804809L;
		{
			for(ResourceTypeEnum typeEnum : ResourceTypeEnum.values()){
				put(typeEnum.getType(), typeEnum);
			}
		}
	};
	private Integer type;
	private Map<String,String> descMap;
	private ResourceTypeEnum(int type,String description){
	}
	private ResourceTypeEnum(int type,Map<String,String> descMap){
		this.type = type;
		this.descMap = descMap;
	}
	public int getType() {
		return type;
	}
	public Map<String,String> getDescMap(){
		return descMap;
	}
	public String getDescription() {
		return descMap.get(LoginContextHolder.get().getLanguage());
	}
	
	public static ResourceTypeEnum toEnum(Integer type){
		return CACHE.get(type);
	}
	
	public static boolean isValidType(Integer type){
		return toEnum(type)!= null;
	}
}
