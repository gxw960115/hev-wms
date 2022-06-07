package com.haier.openplatform.showcase.security.model;

import com.haier.openplatform.log.domain.OperationLog;
import com.haier.openplatform.util.SearchModel;

/**
 * @author WangXuzheng
 *
 */
public class OperationLogSearchModel extends SearchModel<OperationLog> {
	private static final long serialVersionUID = 208816674592883680L;
	/**
	 * 查询开始时间
	 */
	private String from;
	/**
	 * 查询结束时间
	 */
	private String to;
	private OperationLog operationLog = new OperationLog();
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public OperationLog getOperationLog() {
		return operationLog;
	}
	public void setOperationLog(OperationLog operationLog) {
		this.operationLog = operationLog;
	}
}
