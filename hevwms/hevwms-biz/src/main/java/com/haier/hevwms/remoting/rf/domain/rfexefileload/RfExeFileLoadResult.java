package com.haier.hevwms.remoting.rf.domain.rfexefileload;

/**
 * 
 * <p>Description: [RF程序更新]</p>
 * Created on 2013-11-22
 * @version 1.0
 */
public class RfExeFileLoadResult {
	private String status; // 接口调用标示
	private String msg; // 接口调用信息
	private String serialId; // 版本号
	private int filelength; // 文件长度
	private byte[] exefile;//文件流

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public int getFilelength() {
		return filelength;
	}

	public void setFilelength(int filelength) {
		this.filelength = filelength;
	}

	public byte[] getExefile() {
		if (exefile == null){
			return null;
		} else {
			return exefile.clone();
		}
	}

	public void setExefile(byte[] exefile) {
		this.exefile = exefile.clone();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
