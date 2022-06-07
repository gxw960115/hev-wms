package com.haier.openplatform.wms.dictionary.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/**
 * 
* @ClassName: MdDictionaryDTO
* @Description: 字典维护DTO
*
 */
public class MdDictionaryDTO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 默认序列
     */
	/**
     * id
     */
	private long id;
	/**
	 * 编码 
	 */
	private String code;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 名称格式
	 */
	private String nameFat;
	/**
	 * 类型
	 */
	private String kindCode;
	/**
	 * 类型描述
	 */
	private String kindDescription;
	/**
	 * 显示排序
	 */
	private String sort;

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @Description: 属性 id 的get方法
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @Description: 属性 id 的set方法
	 * id
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
     * @Description: 属性 code 的get方法
     * @return code
     */
	public String getCode() {
		return code;
	}
	/**
	 * @Description: 属性 code 的set方法
	 * code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
     * @Description: 属性 name 的get方法
     * @return name
     */
	public String getName() {
		return name;
	}
	/**
	 * @Description: 属性 name 的set方法
	 * name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
     * @Description: 属性 nameFat 的get方法
     * @return nameFat
     */
	public String getNameFat() {
		return nameFat;
	}
	/**
	 * @Description: 属性 nameFat 的set方法
	 * nameFat
	 */
	public void setNameFat(String nameFat) {
		this.nameFat = nameFat;
	}
	/**
     * @Description: 属性 kindCode 的get方法
     * @return kindCode
     */
	public String getKindCode() {
		return kindCode;
	}
	/**
	 * @Description: 属性 kindCode 的set方法
	 * kindCode
	 */
	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}
	/**
     * @Description: 属性 kindDescription 的get方法
     * @return kindDescription
     */
	public String getKindDescription() {
		return kindDescription;
	}
	/**
	 * @Description: 属性 kindDescription 的set方法
	 * kindDescription
	 */
	public void setKindDescription(String kindDescription) {
		this.kindDescription = kindDescription;
	}
	/**
     * @Description: 属性 sort 的get方法
     * @return sort
     */
	public String getSort() {
		return sort;
	}
	/**
	 * @Description: 属性 sort 的set方法
	 * sort
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
}
