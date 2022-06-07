package com.haier.openplatform.wms.security.domain.enu;

import java.util.HashMap;
import java.util.Map;

import com.haier.openplatform.security.LoginContextHolder;

/**
 * 用户状态枚举
 * @author WangXuzheng
 *
 */
public enum UserStatusEnum {
	ACTIVE(1,new HashMap<String,String>()),INACTIVE(0,new HashMap<String,String>()),EXPIRED(2,new HashMap<String,String>());
	static{
		ACTIVE.getDescMap().put("zh_CN", "正常");
		ACTIVE.getDescMap().put("en_US", "Active");
		INACTIVE.getDescMap().put("zh_CN", "锁定");
		INACTIVE.getDescMap().put("en_US", "Locking");
		EXPIRED.getDescMap().put("zh_CN", "过期");
		EXPIRED.getDescMap().put("en_US", "Expired");
	}
	private static final Map<Integer, UserStatusEnum> CACHE = new HashMap<Integer, UserStatusEnum>(){
		private static final long serialVersionUID = -8986866330615001847L;
		{
			for(UserStatusEnum enu : UserStatusEnum.values()){
				put(enu.getStatus(), enu);
			}
		}
	};
	private Integer status;
	private Map<String,String> descMap;
	private UserStatusEnum(Integer status, Map<String,String> descMap) {
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
	public static UserStatusEnum toEnum(Integer status){
		return CACHE.get(status);
	}
}
