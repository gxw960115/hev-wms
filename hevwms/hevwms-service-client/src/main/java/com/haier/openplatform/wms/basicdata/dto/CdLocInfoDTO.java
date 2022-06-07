package com.haier.openplatform.wms.basicdata.dto;

import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.util.Date;

public class CdLocInfoDTO implements Serializable{
    /**
    * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;

    /**
     * @author Liujian
     */
    private Long rowId;

    /** 名称 */
    @FormParam("name")
    private String name;

    /** 代码 */
    @FormParam("code")
    private String code;
    
    private String nameFat;

    /** 父id 库存地点的上级仓库 */

    private Long parentId;

    /** 创建人 */

    private String createBy;

    /** 创建日期 */

    private java.util.Date createDate;

    /** 修改人 */

    private String modifyBy;

    /** 修改日期 */

    private java.util.Date modifyDate;

    /** 有效标记 0-有效 1-失效 */

    private java.lang.String flag;

    /** 版本号 */

    private Long version;

    private String whCode;
    
    private String whName;
    
    private String cityCode;
    
    private String cityName;
    
    /** 备注 */
    private String remark;
    
    /** 有效面积 */
    private Float validArea;
    
    /** 高度*/
    private Float height;
    
    /** 租金*/
    private Float rentFee;
    
    /** 仓库地点类型 */
    private String locationType;
    
    
    private String chkDisabled="false";

    private boolean checked = false;

    private String address;
    private String tel;
	/**  
	* @Title: isChecked  
	* @Description: 
	* @return 
	* @return boolean
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:39:52 
	*/ 
	public boolean isChecked() {
		return checked;
	}

	/**  
	* @Title: setChecked  
	* @Description: 
	* @param checked 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:39:47 
	*/ 
	public void setChecked(boolean checked) {
		this.checked = checked;
	}


	/**  
	* @Title: getRowId  
	* @Description: 
	* @return 
	* @return Long
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:39:44 
	*/ 
	public Long getRowId() {
        return rowId;
    }


    /**  
    * @Title: setRowId  
    * @Description: 
    * @param rowId 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:41 
    */ 
    public void setRowId(Long rowId) {
        this.rowId = rowId;
    }


    /**  
    * @Title: getName  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:37 
    */ 
    public String getName() {
        return name;
    }


    /**  
    * @Title: setName  
    * @Description: 
    * @param name 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:33 
    */ 
    public void setName(String name) {
        this.name = name;
    }


    /**  
    * @Title: getCode  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:30 
    */ 
    public String getCode() {
        return code;
    }


    /**  
    * @Title: setCode  
    * @Description: 
    * @param code 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:28 
    */ 
    public void setCode(String code) {
        this.code = code;
    }

    /**  
    * @Title: getNameFat  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:10 
    */ 
    public String getNameFat() {
        if (name != null && code != null) {
            nameFat = code + "(" + name + ")";
        }
        return nameFat;
    }

    /**  
    * @Title: setNameFat  
    * @Description: 
    * @param nameFat 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:18 
    */ 
    public void setNameFat(String nameFat) {
        this.nameFat = nameFat;
    }


    /**  
    * @Title: getParentId  
    * @Description: 
    * @return 
    * @return Long
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:39:01 
    */ 
    public Long getParentId() {
        return parentId;
    }


    /**  
    * @Title: setParentId  
    * @Description: 
    * @param parentId 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:59 
    */ 
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    /**  
    * @Title: getCreateBy  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:55 
    */ 
    public String getCreateBy() {
        return createBy;
    }


    /**  
    * @Title: setCreateBy  
    * @Description: 
    * @param createBy 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:53 
    */ 
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**  
    * @Title: getModifyBy  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:50 
    */ 
    public String getModifyBy() {
        return modifyBy;
    }


    /**  
    * @Title: setModifyBy  
    * @Description: 
    * @param modifyBy 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:48 
    */ 
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**  
    * @Title: getFlag  
    * @Description: 
    * @return 
    * @return java.lang.String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:45 
    */ 
    public java.lang.String getFlag() {
        return flag;
    }


    /**  
    * @Title: setFlag  
    * @Description: 
    * @param flag 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:42 
    */ 
    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }


    /**  
    * @Title: getVersion  
    * @Description: 
    * @return 
    * @return Long
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:38 
    */ 
    public Long getVersion() {
        return version;
    }


    /**  
    * @Title: setVersion  
    * @Description: 
    * @param version 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:35 
    */ 
    public void setVersion(Long version) {
        this.version = version;
    }


    /**  
    * @Title: getWhCode  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:33 
    */ 
    public String getWhCode() {
        return whCode;
    }


    /**  
    * @Title: setWhCode  
    * @Description: 
    * @param whCode 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:30 
    */ 
    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }


    /**  
    * @Title: getWhName  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:27 
    */ 
    public String getWhName() {
        return whName;
    }


    /**  
    * @Title: setWhName  
    * @Description: 
    * @param whName 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:25 
    */ 
    public void setWhName(String whName) {
        this.whName = whName;
    }


    /**  
    * @Title: getCityCode  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:23 
    */ 
    public String getCityCode() {
        return cityCode;
    }


    /**  
    * @Title: setCityCode  
    * @Description: 
    * @param cityCode 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:20 
    */ 
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


    /**  
    * @Title: getCityName  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:18 
    */ 
    public String getCityName() {
        return cityName;
    }


    /**  
    * @Title: setCityName  
    * @Description: 
    * @param cityName 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:15 
    */ 
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


    /**  
    * @Title: getRemark  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:13 
    */ 
    public String getRemark() {
        return remark;
    }


    /**  
    * @Title: setRemark  
    * @Description: 
    * @param remark 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:11 
    */ 
    public void setRemark(String remark) {
        this.remark = remark;
    }


    /**  
    * @Title: getValidArea  
    * @Description: 
    * @return 
    * @return Float
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:08 
    */ 
    public Float getValidArea() {
        return validArea;
    }


    /**  
    * @Title: setValidArea  
    * @Description: 
    * @param validArea 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:05 
    */ 
    public void setValidArea(Float validArea) {
        this.validArea = validArea;
    }


    /**  
    * @Title: getHeight  
    * @Description: 
    * @return 
    * @return Float
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:03 
    */ 
    public Float getHeight() {
        return height;
    }


    /**  
    * @Title: setHeight  
    * @Description: 
    * @param height 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:38:00 
    */ 
    public void setHeight(Float height) {
        this.height = height;
    }


    /**  
    * @Title: getRentFee  
    * @Description: 
    * @return 
    * @return Float
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:37:57 
    */ 
    public Float getRentFee() {
        return rentFee;
    }


    /**  
    * @Title: setRentFee  
    * @Description: 
    * @param rentFee 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:37:54 
    */ 
    public void setRentFee(Float rentFee) {
        this.rentFee = rentFee;
    }


    /**  
    * @Title: getLocationType  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:37:52 
    */ 
    public String getLocationType() {
        return locationType;
    }


    /**  
    * @Title: setLocationType  
    * @Description: 
    * @param locationType 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:37:50 
    */ 
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }


    /**  
    * @Title: getChkDisabled  
    * @Description: 
    * @return 
    * @return String
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:37:47 
    */ 
    public String getChkDisabled() {
        return chkDisabled;
    }


    /**  
    * @Title: setChkDisabled  
    * @Description: 
    * @param chkDisabled 
    * @return void
    * @throws  
    * @version: v1.0.0
    * @author: SJK
    * @date: 2018年6月4日 下午1:37:44 
    */ 
    public void setChkDisabled(String chkDisabled) {
        this.chkDisabled = chkDisabled;
    }

	/**  
	* @Title: getCreateDate  
	* @Description: 
	* @return 
	* @return java.util.Date
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:37:38 
	*/ 
	public java.util.Date getCreateDate() {
		if (createDate == null){
			return null;
		} else {
			return (Date) createDate.clone();
		}
	}
	/**  
	* @Title: setCreateDate  
	* @Description: 
	* @param value 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:37:35 
	*/ 
	public void setCreateDate(java.util.Date value) {
		if (value == null){
			this.createDate = null;
		} else {
			this.createDate = (Date) value.clone();
		}
	}
	/**  
	* @Title: getModifyDate  
	* @Description: 
	* @return 
	* @return java.util.Date
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:37:32 
	*/ 
	public java.util.Date getModifyDate() {
		if (modifyDate == null){
			return null;
		} else {
			return (Date) modifyDate.clone();
		}
	}
	/**  
	* @Title: setModifyDate  
	* @Description: 
	* @param value 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年6月4日 下午1:37:27 
	*/ 
	public void setModifyDate(java.util.Date value) {
		if (value == null){
			this.modifyDate = null;
		} else {
			this.modifyDate = (Date) value.clone();
		}
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
