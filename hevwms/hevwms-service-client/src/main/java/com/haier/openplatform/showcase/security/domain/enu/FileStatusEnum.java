package com.haier.openplatform.showcase.security.domain.enu;

import java.util.HashMap;
import java.util.Map;

import com.haier.openplatform.security.LoginContextHolder;

public enum FileStatusEnum {

	VALID(1,new HashMap<String,String>()),INVALID(2,new HashMap<String,String>());
	static{
		VALID.getDescMap().put("zh_CN", "有效");
		VALID.getDescMap().put("en_US", "valid");
		INVALID.getDescMap().put("zh_CN", "无效");
		INVALID.getDescMap().put("en_US", "invalid");
	}
	private static final Map<Integer, FileStatusEnum> CACHE = new HashMap<Integer, FileStatusEnum>(){
		private static final long serialVersionUID = 1802140338455124215L;

		{
			for(FileStatusEnum enu : FileStatusEnum.values()){
				put(enu.getStatus(), enu);
			}
		}
	};
	private Integer status;
	private Map<String,String> descMap;
	
	private FileStatusEnum(Integer status,Map<String,String> descMap){
		this.status = status;
		this.descMap = descMap;
	}

	public Integer getStatus() {
		return status;
	}

	public Map<String,String> getDescMap(){
		return descMap;
	}
	
	public String getDesc() {
		return descMap.get(LoginContextHolder.get().getLanguage());
	}
	public static FileStatusEnum toEnum(Integer status){
		return CACHE.get(status);
	}
}
