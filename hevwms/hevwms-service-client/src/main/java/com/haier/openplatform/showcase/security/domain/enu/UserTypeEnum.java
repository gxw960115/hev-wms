package com.haier.openplatform.showcase.security.domain.enu;

import java.util.HashMap;
import java.util.Map;

import com.haier.openplatform.security.LoginContextHolder;

/**
 * 用户账号类型
 * @author WangXuzheng
 *
 */
public enum UserTypeEnum {
	ACTIVE(1,new HashMap<String,String>()),INACTIVE(0,new HashMap<String,String>());
	static{
		//域账号   普通用户
		ACTIVE.getDescMap().put("zh_CN", "域账号");
		ACTIVE.getDescMap().put("en_US", "Domain account");
		INACTIVE.getDescMap().put("zh_CN", "普通用户");
		INACTIVE.getDescMap().put("en_US", "Ordinary users");
	}
	private static final Map<Integer, UserTypeEnum> CACHE = new HashMap<Integer, UserTypeEnum>(){
		private static final long serialVersionUID = -8986866330615001847L;
		{
			for(UserTypeEnum enu : UserTypeEnum.values()){
				put(enu.getStatus(), enu);
			}
		}
	};
	private Integer status;
	private Map<String,String> descMap;
	private UserTypeEnum(Integer status, Map<String,String> descMap) {
		this.status = status;
		this.descMap = descMap;
	}
	public Integer getStatus() {
		return status;
	}
	public Map<String,String> getDescMap(){
		return descMap;
	}
	public String getDescription() {
		return descMap.get(LoginContextHolder.get().getLanguage());
	}
	public static UserTypeEnum toEnum(Integer status){
		return CACHE.get(status);
	}
}
