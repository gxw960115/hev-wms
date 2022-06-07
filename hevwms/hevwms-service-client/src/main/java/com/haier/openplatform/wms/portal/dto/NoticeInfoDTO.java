package com.haier.openplatform.wms.portal.dto;

import java.io.Serializable;
import java.util.Date;

public class NoticeInfoDTO implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 4896967826836305469L;
    /** */
    private Long id;
    /** 取序列 */
    private Long noticeId;
    /** 公共PUBLIC或者应用代码如HLES */
    private String appCode;
    /** 标题 */
    private String title;
    /** 有效标记：空:失效，0:创建未发布，1:发布/生效，失效标志需要作业处理 */
    private String status;
    /** 生效时间 */
    private Date validTime;
    /** 失效日期 */
    private Date invalidTime;
    /** 发布人id */
    private String publisherId;
    /** 发布时间即生效时间 */
    private Date publishedTime;
    /** 创建时间 */
    private Date createdTime;
    /** 创建人 */
    private String creatorId;
    /** 是否需要审批,1需要审批,0不需审批 */
    private String isAppoved;
    /** 审批人 */
    private String approverCode;
    /** 审批结果 */
    private String approveResult;
    /** 公告类型：10通知，20公告，30广告 */
    private Integer noticeType;
    /** 公告分类 */
    private String noticeClass;
    /** 置顶标志:1置顶，0:不置顶 */
    private String topFlag;
    /** 附件数,大于0有附件 */
    private Integer attachCnt;
    /** 阅读回执,1需要回执，0不需要回执 */
    private String readFlag;
    /** 公告内容 */
    private String content;
    private Date gmtCreate;
	private Date gmtModified;
	private String createBy;
	private String lastModifiedBy;
    
    public Long getNoticeId() {
        return noticeId;
    }
    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }
    public String getAppCode() {
        return appCode;
    }
    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Date getValidTime() {
    	if (validTime == null){
    		return null;
    	} else {
    		return (Date) validTime.clone();
    	}
    }
    public void setValidTime(Date validTime) {
    	if (validTime == null){
    		this.validTime = null;
    	} else {
    		this.validTime = (Date) validTime.clone();
    	}
    }
    public Date getInvalidTime() {
    	if (invalidTime == null){
    		return null;
    	} else {
    		return (Date) invalidTime.clone();
    	}
    }
    public void setInvalidTime(Date invalidTime) {
    	if (invalidTime == null){
    		this.invalidTime = null;
    	} else {
    		this.invalidTime = (Date) invalidTime.clone();
    	}
    }
    public String getPublisherId() {
        return publisherId;
    }
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    public Date getPublishedTime() {
    	if (publishedTime == null){
    		return null;
    	} else {
    		return (Date) publishedTime.clone();
    	}
    }
    public void setPublishedTime(Date publishedTime) {
    	if (publishedTime == null){
    		this.publishedTime = null;
    	} else {
    		this.publishedTime = (Date) publishedTime.clone();
    	}
    }
    public Date getCreatedTime() {
    	if (createdTime == null){
    		return null;
    	} else {
    		return (Date) createdTime.clone();
    	}
    }
    public void setCreatedTime(Date createdTime) {
    	if (createdTime == null){
    		this.createdTime = null;
    	} else {
    		this.createdTime = (Date) createdTime.clone();
    	}
    }
    public String getCreatorId() {
        return creatorId;
    }
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }
    public String getIsAppoved() {
        return isAppoved;
    }
    public void setIsAppoved(String isAppoved) {
        this.isAppoved = isAppoved;
    }
    public String getApproverCode() {
        return approverCode;
    }
    public void setApproverCode(String approverCode) {
        this.approverCode = approverCode;
    }
    public String getApproveResult() {
        return approveResult;
    }
    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }
    public Integer getNoticeType() {
        return noticeType;
    }
    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }
    public String getNoticeClass() {
        return noticeClass;
    }
    public void setNoticeClass(String noticeClass) {
        this.noticeClass = noticeClass;
    }
    public String getTopFlag() {
        return topFlag;
    }
    public void setTopFlag(String topFlag) {
        this.topFlag = topFlag;
    }
    public Integer getAttachCnt() {
        return attachCnt;
    }
    public void setAttachCnt(Integer attachCnt) {
        this.attachCnt = attachCnt;
    }
    public String getReadFlag() {
        return readFlag;
    }
    public void setReadFlag(String readFlag) {
        this.readFlag = readFlag;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
	public Date getGmtCreate() {
		if (gmtCreate == null){
			return null;
		} else {
			return (Date) gmtCreate.clone();
		}
	}
	public void setGmtCreate(Date gmtCreate) {
		if (gmtCreate == null){
			this.gmtCreate = null;
		} else {
			this.gmtCreate = (Date) gmtCreate.clone();
		}
	}
	public Date getGmtModified() {
		if (gmtModified == null){
			return null;
		} else {
			return (Date) gmtModified.clone();
		}
	}
	public void setGmtModified(Date gmtModified) {
		if (gmtModified == null){
			this.gmtModified = null;
		} else {
			this.gmtModified = (Date) gmtModified.clone();
		}
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
}
