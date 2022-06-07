package com.haier.openplatform.wms.basicdata.dto;

import java.io.Serializable;

public class LocTreeDTO implements Serializable {
    /**
    * @Fields serialVersionUID : (用一句话描述这个变量表示什么)
    */
    private static final long serialVersionUID = 1L;
    private String id;
    private String text;
    
    private boolean checked = false;//默认不选中
    
    
    /**
	 * @return the checked
	 */
	public boolean isChecked() {
		return checked;
	}
	/**
	 * @param checked the checked to set
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    
}
