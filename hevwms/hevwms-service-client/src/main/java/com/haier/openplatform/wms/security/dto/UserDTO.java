package com.haier.openplatform.wms.security.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.haier.openplatform.domain.BaseDomain;

/**
 * @author WangXuzheng
 *
 */
public class UserDTO extends BaseDomain<Long> {
	private static final long serialVersionUID = -112280423769600328L;
//	private Long id;
	private String name;
	private String password;
	private Integer status;
	private String email;
	private Integer type;
	private String nickName;
	private String lastLoginIp;
	private String currentLoginIp;
	private Date lastLoginTime;
	private Integer loginAttemptTimes;
	private Integer passwordModifiedFlag;
	private Date passwordExpireTime;
	private Date loginFaildTime;
	private String whLocs;
//	private String createBy;
//	private Date gmtCreate;
	private String groupId;
    /**
     * 最后修改者
     */
//    private String lastModifiedBy;
	private String groupName;
	private Set<UserWarehouseDTO> userWarehouses=new HashSet<UserWarehouseDTO>();
	private Set<UserPrdSeriesDTO> userPrdSeriess=new HashSet<UserPrdSeriesDTO>();
	private Set<UserCustomerDTO> userCustomers=new HashSet<UserCustomerDTO>();
	private String encode;
	private Date expiredTime;
	private String rfSign;
	private String dutyType;
	private String productDivision;
//	private Date gmtModified;
//	public String getCreateBy() {
//        return createBy;
//    }
//    public void setCreateBy(String createBy) {
//        this.createBy = createBy;
//    }
//    public String getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//    public void setLastModifiedBy(String lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
    private String statusDesc;
	
	public String getDutyType() {
		return dutyType;
	}
	public void setDutyType(String dutyType) {
		this.dutyType = dutyType;
	}
	public String getRfSign() {
		return rfSign;
	}
	public void setRfSign(String rfSign) {
		this.rfSign = rfSign;
	}
	public Date getExpiredTime() {
		if (expiredTime == null){
			return null;
		} else {
			return (Date) expiredTime.clone();
		}
	}
	public void setExpiredTime(Date expiredTime) {
		if (expiredTime == null){
			this.expiredTime = null;
		} else {
			this.expiredTime = (Date) expiredTime.clone();
		}
	}
	public String getEncode() {
		return encode;
	}
	public void setEncode(String encode) {
		this.encode = encode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCurrentLoginIp() {
		return currentLoginIp;
	}
	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getLastLoginTime() {
		if (lastLoginTime == null){
			return null;
		} else {
			return (Date) lastLoginTime.clone();
		}
	}
	public void setLastLoginTime(Date lastLoginTime) {
		if (lastLoginTime == null){
			this.lastLoginTime = null;
		} else {
			this.lastLoginTime = (Date) lastLoginTime.clone();
		}
	}
	public Integer getLoginAttemptTimes() {
		return loginAttemptTimes;
	}
	public void setLoginAttemptTimes(Integer loginAttemptTimes) {
		this.loginAttemptTimes = loginAttemptTimes;
	}
	public Date getLoginFaildTime() {
		if (loginFaildTime == null){
			return null;
		} else {
			return (Date) loginFaildTime.clone();
		}
	}
	public void setLoginFaildTime(Date loginFaildTime) {
		if (loginFaildTime == null){
			this.loginFaildTime = null;
		} else {
			this.loginFaildTime = (Date) loginFaildTime.clone();
		}
	}
	public Integer getPasswordModifiedFlag() {
		return passwordModifiedFlag;
	}
	public void setPasswordModifiedFlag(Integer passwordModifiedFlag) {
		this.passwordModifiedFlag = passwordModifiedFlag;
	}
	public Date getPasswordExpireTime() {
		if (passwordExpireTime == null){
			return null;
		} else {
			return (Date) passwordExpireTime.clone();
		}
	}
	public void setPasswordExpireTime(Date passwordExpireTime) {
		if (passwordExpireTime == null){
			this.passwordExpireTime = null;
		} else {
			this.passwordExpireTime = (Date) passwordExpireTime.clone();
		}
	}
	public String getWhLocs() {
		return whLocs;
	}
	public void setWhLocs(String whLocs) {
		this.whLocs = whLocs;
	}
	public String getProductDivision() {
		return productDivision;
	}
	public void setProductDivision(String productDivision) {
		this.productDivision = productDivision;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
    public Set<UserWarehouseDTO> getUserWarehouses() {
        return userWarehouses;
    }
    public void setUserWarehouses(Set<UserWarehouseDTO> userWarehouses) {
        this.userWarehouses = userWarehouses;
    }
    public Set<UserPrdSeriesDTO> getUserPrdSeriess() {
        return userPrdSeriess;
    }
    public void setUserPrdSeriess(Set<UserPrdSeriesDTO> userPrdSeriess) {
        this.userPrdSeriess = userPrdSeriess;
    }
    public Set<UserCustomerDTO> getUserCustomers() {
        return userCustomers;
    }
    public void setUserCustomers(Set<UserCustomerDTO> userCustomers) {
        this.userCustomers = userCustomers;
    }
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
//    public Date getGmtModified() {
//    	if (gmtModified == null){
//    		return null;
//    	} else {
//    		return (Date) gmtModified.clone();
//    	}
//    }
//    public void setGmtModified(Date gmtModified) {
//    	if (gmtModified == null){
//    		this.gmtModified = null;
//    	} else {
//    		this.gmtModified = (Date) gmtModified.clone();
//    	}
//    }
//    public Date getGmtCreate() {
//    	if (gmtCreate == null){
//    		return null;
//    	} else {
//    		return (Date) gmtCreate.clone();
//    	}
//    }
//    public void setGmtCreate(Date gmtCreate) {
//    	if (gmtCreate == null){
//    		this.gmtCreate = null;
//    	} else {
//    		this.gmtCreate = (Date) gmtCreate.clone();
//    	}
//    }
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
}
