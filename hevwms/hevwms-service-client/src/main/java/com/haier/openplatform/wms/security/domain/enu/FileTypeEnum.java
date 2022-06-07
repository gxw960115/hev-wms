package com.haier.openplatform.wms.security.domain.enu;

import java.util.HashMap;
import java.util.Map;

import com.haier.openplatform.security.LoginContextHolder;

public enum FileTypeEnum {

	FILE_SYSTEM(1,new HashMap<String,String>()),MONGODB(2,new HashMap<String,String>());
	static{
		FILE_SYSTEM.getDescMap().put("zh_CN", "文件系统");
		FILE_SYSTEM.getDescMap().put("en_US", "File System");
		MONGODB.getDescMap().put("zh_CN", "mongodb");
		MONGODB.getDescMap().put("en_US", "mongodb");
	}
	private static final Map<Integer, FileTypeEnum> CACHE = new HashMap<Integer, FileTypeEnum>(){

		private static final long serialVersionUID = -2450871211426704996L;

		{
			for(FileTypeEnum enu : FileTypeEnum.values()){
				put(enu.getType(), enu);
			}
		}
	};
	private Integer type;
	private Map<String,String> descMap;
	
	private FileTypeEnum(Integer type,Map<String,String> descMap){
		this.type = type;
		this.descMap = descMap;
	}

	public Integer getType() {
		return type;
	}

	public Map<String,String> getDescMap(){
		return descMap;
	}
	
	public String getDesc() {
		return descMap.get(LoginContextHolder.get().getLanguage());
	}
	public static FileTypeEnum toEnum(Integer status){
		return CACHE.get(status);
	}
}
