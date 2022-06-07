package com.haier.openplatform.showcase.security.domain.enu;

import java.util.HashMap;
import java.util.Map;

import com.haier.openplatform.security.LoginContextHolder;

/**
 * 资源状态枚举
 * @author lupeng
 * 2012-1-6
 */
public enum ResourceStatusEnum {
	
	ACTIVE(1,new HashMap<String,String>()),INACTIVE(0,new HashMap<String,String>());
	static{
		ACTIVE.getDescMap().put("zh_CN", "显示");
		ACTIVE.getDescMap().put("en_US", "Display");
		INACTIVE.getDescMap().put("zh_CN", "隐藏");
		INACTIVE.getDescMap().put("en_US", "Hide");
	}
	private static final Map<Integer, ResourceStatusEnum> CACHE = new HashMap<Integer, ResourceStatusEnum>(){
		private static final long serialVersionUID = -8986866330615001847L;
		{
			for(ResourceStatusEnum enu : ResourceStatusEnum.values()){
				put(enu.getStatus(), enu);
			}
		}
	};
	
	private Integer status;
	private Map<String,String> descMap;
	
	private ResourceStatusEnum(Integer status,String desc){
		
	}
	
	private ResourceStatusEnum(Integer status, Map<String,String> descMap) {
		this.status = status;
		this.descMap = descMap;
	}
	public Integer getStatus() {
		return status;
	}
	public Map<String,String> getDescMap() {
		return descMap;
	}
	public String getDescription(){
		return descMap.get(LoginContextHolder.get().getLanguage());
	}
	public static ResourceStatusEnum toEnum(Integer status){
		return CACHE.get(status);
	}
}
