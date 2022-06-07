package com.haier.hevwms.remoting.rf.service.impl;

import javax.xml.ws.WebServiceContext;

import com.alibaba.fastjson.JSON;
import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.dao.RfLogDAO;
import com.haier.hevwms.remoting.rf.domain.RfLog;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.RfResult;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.security.service.FileServiceClientAdapter;
import com.haier.hevwms.util.FileConstants;
import com.haier.hevwms.util.WsIpUtil;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;




/**
 * <p>Description: [手持接口 - 校验签名、日志记录]</p>
 * Created on 2013-8-1
 * @version 1.0
 */
public class RfWsServiceImpl implements RfWsService {
	private WmsLoginDAO loginDAO;
	private RfLogDAO rfLogDAO;
	private FileUploadDAO fileUploadDAO;
    private FileConstants fileConstants;
    private FileServiceClientAdapter fileServiceClientAdapter;

	public void setLoginDAO(WmsLoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public void setRfLogDAO(RfLogDAO rfLogDAO) {
		this.rfLogDAO = rfLogDAO;
	}

	@Override
	public RfResult execute(String userCode, Object content) {
		return null;
	}
	
	

	/**
	 * 
	 * <p>Discription:[手持签名校验]</p>
	 * @param userName
	 * @param sign
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public RfLogResult checkSign(String userName, String sign,String version) {
		RfLogResult rfLogResult = new RfLogResult();
		UserDTO user = loginDAO.getRfUserByName(userName);
		//首先检查版本号
		UploadFile pdaFile= fileUploadDAO.getPdaFileInfo();
		if(!pdaFile.getVersions().equals(version)){
		    rfLogResult.setStatus("FF");
            rfLogResult.setMsg(pdaFile.getVersions());
            return rfLogResult;
		}
		if (null != user) {
//			if (sign.equals(user.getRfSign())) {
//			    //检查版本号
//			   // UploadFile files=fileUploadDAO.get(id);
//			    
//				rfLogResult.setStatus("S");
//				rfLogResult.setMsg("SUCCESS");
//			}else{
//				rfLogResult.setStatus("F");
//				rfLogResult.setMsg("The user has logining on the other device. Please login again.");
//			}
			
			rfLogResult.setStatus("S");
			rfLogResult.setMsg("SUCCESS");
		}else{
			rfLogResult.setStatus("F");
			rfLogResult.setMsg("The user does not exist");
		}
		return rfLogResult;
	}

	/**
	 * <p>Discription:[手持日志记录]</p>
	 * @param user
	 * @param type
	 * @param sign
	 * @param context
	 * @param status
	 * @param dydate
	 * @param fhdate
	 * @param rcnr
	 * @param ccnr
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@Override
	public void writeLog(String user, String type, String sign, WebServiceContext context, String status,
			String dydate, String fhdate, Object rcnr, Object ccnr) {
		RfLog rfLog = new RfLog();
		rfLog.setUserId(user);
		rfLog.setType(type);
		rfLog.setSign(sign);
		if(context != null) {
			rfLog.setIp(WsIpUtil.getRemoteIp(context));
		}
		rfLog.setStatus(status);
		rfLog.setDydate(dydate);
		rfLog.setFhdate(fhdate);
		rfLog.setRcnr(JSON.toJSONString(rcnr));
		rfLog.setCcnr(JSON.toJSONString(ccnr));
		rfLogDAO.writeLog(rfLog);
	}
	/**
	 * 
	 * <p>Discription:[检查手持程序版本]</p>
	 * @return
	 * @author:[李春晖]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
//	@Override
//	public RfExeFileLoadResult checkExeFile() {
//		RfExeFileLoadResult rfExeFileLoadResult = new RfExeFileLoadResult();
//		UploadFile uploadFile = fileUploadDAO.get(Long.valueOf("-1"));
//		if (uploadFile == null) {
//			rfExeFileLoadResult.setStatus("F");
//			rfExeFileLoadResult.setMsg("获取文件信息失败");
//			return rfExeFileLoadResult;
//		}
//		InputStream is = null;
//		if (FileTypeEnum.FILE_SYSTEM.getType().equals(uploadFile.getType())) {
//			try {
//				File file = new File(fileConstants.getFileSavePath() + File.separator + uploadFile.getSaveFileName());
//				is = new FileInputStream(file);
//			} catch (FileNotFoundException e) {
//				rfExeFileLoadResult.setStatus("F");
//				rfExeFileLoadResult.setMsg("no file error!");
//				return rfExeFileLoadResult;
//			}
//		} else {
//			FileResult result = fileServiceClientAdapter.findFile(uploadFile.getSaveFileName());
//			is = result.getInputStream();
//		}
//
//		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
//		byte imgdata[] = null;
//		try {
//			int ch;
//			while ((ch = is.read()) != -1) {
//				bytestream.write(ch);
//			}
//			imgdata = bytestream.toByteArray();
//			bytestream.close();
//		} catch (Exception e) {
//			rfExeFileLoadResult.setStatus("F");
//			rfExeFileLoadResult.setMsg("no file error!");
//			return rfExeFileLoadResult;
//		}
//		rfExeFileLoadResult.setStatus("S");
//		rfExeFileLoadResult.setMsg("SUCCESS");
//		rfExeFileLoadResult.setFilelength(imgdata.length);
//		rfExeFileLoadResult.setSerialId(uploadFile.getVersions());
//		return rfExeFileLoadResult;
//	}

	/**
	 * 
	 * <p>Discription:[获取手持程序]</p>
	 * @return
	 * @author:[韩林]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
//	@Override
//	public RfExeFileLoadResult getExeFile() {
//		RfExeFileLoadResult rfExeFileLoadResult = new RfExeFileLoadResult();
//		UploadFile uploadFile = fileUploadDAO.get(Long.valueOf("-1"));
//		if (uploadFile == null) {
//			rfExeFileLoadResult.setStatus("F");
//			rfExeFileLoadResult.setMsg("获取文件信息失败");
//			return rfExeFileLoadResult;
//		}
//		InputStream is = null;
//		if (FileTypeEnum.FILE_SYSTEM.getType().equals(uploadFile.getType())) {
//			try {
//				File file = new File(fileConstants.getFileSavePath() + File.separator + uploadFile.getSaveFileName());
//				is = new FileInputStream(file);
//			} catch (FileNotFoundException e) {
//				rfExeFileLoadResult.setStatus("F");
//				rfExeFileLoadResult.setMsg("获取文件信息失败");
//				return rfExeFileLoadResult;
//			}
//		} else {
//			FileResult result = fileServiceClientAdapter.findFile(uploadFile.getSaveFileName());
//			is = result.getInputStream();
//		}
//
//		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
//		byte imgdata[] = null;
//		try {
//			int ch;
//			while ((ch = is.read()) != -1) {
//				bytestream.write(ch);
//			}
//			imgdata = bytestream.toByteArray();
//			bytestream.close();
//		} catch (Exception e) {
//			rfExeFileLoadResult.setStatus("F");
//			rfExeFileLoadResult.setMsg("获取文件信息失败");
//			return rfExeFileLoadResult;
//		}
//		rfExeFileLoadResult.setStatus("S");
//		rfExeFileLoadResult.setMsg("获取文件信息成功");
//		rfExeFileLoadResult.setFilelength(imgdata.length);
//		rfExeFileLoadResult.setSerialId(uploadFile.getVersions());
//		rfExeFileLoadResult.setExefile(imgdata);
//		return rfExeFileLoadResult;
//	}

    public FileUploadDAO getFileUploadDAO() {
        return fileUploadDAO;
    }

    public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
        this.fileUploadDAO = fileUploadDAO;
    }

    public FileConstants getFileConstants() {
        return fileConstants;
    }

    public void setFileConstants(FileConstants fileConstants) {
        this.fileConstants = fileConstants;
    }

    public FileServiceClientAdapter getFileServiceClientAdapter() {
        return fileServiceClientAdapter;
    }

    public void setFileServiceClientAdapter(
            FileServiceClientAdapter fileServiceClientAdapter) {
        this.fileServiceClientAdapter = fileServiceClientAdapter;
    }

   

	


}
