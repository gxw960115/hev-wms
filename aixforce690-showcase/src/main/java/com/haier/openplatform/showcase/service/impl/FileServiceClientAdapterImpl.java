package com.haier.openplatform.showcase.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.haier.openplatform.hfs.client.dto.FileRequest;
import com.haier.openplatform.hfs.client.dto.FileResult;
import com.haier.openplatform.hfs.client.service.FileServiceClient;
import com.haier.openplatform.showcase.service.FileServiceClientAdapter;

public class FileServiceClientAdapterImpl implements FileServiceClientAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceClientAdapterImpl.class);
	private FileServiceClient fileServiceClient;
	private String storeSystemAddress;
	
	public FileResult saveFile(String appName,byte[] files,String fileName){
		FileResult result = null;
		try{
			FileRequest request = generalCommonRequest(appName,storeSystemAddress);
			request.setBytes(files);
			request.setFileName(fileName);
			result = fileServiceClient.saveFile(request);
		}catch(Exception e){
			LOGGER.error("saveFile error,fileName=" + fileName,e);
			result = new FileResult();
			result.setSuccess(false);
			result.setMsg(e.toString());
		}
		return result;
	}
	
	@Override
	public FileResult saveFileToFtp(String ip,String user,String pwd,String directory,MultipartFile file){
		FileResult result = new FileResult();
		FTPClient ftpClient = null; 
		result.setSuccess(false);
        try { 
        	ftpClient = getFtpClient(ip,user,pwd);
            //设置上传目录 
        	directory = new String(directory.getBytes("GBK"), "ISO-8859-1");
            ftpClient.changeWorkingDirectory(directory); 
            //如果缺省该句 传输txt正常 但图片和其他格式的文件传输出现乱码
            String saveFileName = UUID.randomUUID().toString() + "." + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
            saveFileName = new String(saveFileName.getBytes("GBK"),"ISO-8859-1");  
            result.setSuccess(ftpClient.storeFile(saveFileName, file.getInputStream())); 
            result.setFileUUID(saveFileName);
        } catch (IOException e) { 
            throw new RuntimeException("FTP客户端出错！", e); 
        } finally { 
            try { 
            	if (ftpClient != null){
            		ftpClient.disconnect(); 
            	}
            } catch (IOException e) { 
//                throw new RuntimeException("关闭FTP连接发生异常！", e); 
            	LOGGER.error("close FTP connection error", e);
            } 
        } 
		return result;
	}
	
	public FileResult findFile(String appName,String uuid){
		FileResult result = null;
		try{
			FileRequest request = generalCommonRequest(appName,storeSystemAddress);
			request.setFileId(uuid);
			result = fileServiceClient.findFileByUUID(request);
		}catch(Exception e){
			LOGGER.error("findFile error,uuid=" + uuid,e);
			result = new FileResult();
			result.setSuccess(false);
		}
		return result;
	}
	
	public FileResult findFileFromFtp(String ip,String user,String pwd,String directory,String uuid){
		FileResult result = new FileResult();
		FTPClient ftpClient = null; 

        try { 
            ftpClient = getFtpClient(ip,user,pwd);
            ftpClient.changeWorkingDirectory(directory);
            InputStream inputStream = ftpClient.retrieveFileStream(uuid);
            result.setFileBytes(IOUtils.toByteArray(inputStream));
            result.setSuccess(true);
        } catch (IOException e) { 
            throw new RuntimeException("FTP客户端出错！", e); 
        } finally { 
            try { 
            	if (ftpClient != null){
            		ftpClient.disconnect(); 
            	}
            } catch (IOException e) { 
//                throw new RuntimeException("关闭FTP连接发生异常！", e); 
            	LOGGER.error("close FTP connection error", e);
            } 
        } 
		return result;
	}

	public FileResult deleteFile(String appName,String uuid){
		FileResult result = null;
		try{
			FileRequest request = generalCommonRequest(appName,storeSystemAddress);
			request.setFileId(uuid);
			result = fileServiceClient.deleteFileByUID(request);
		}catch(Exception e){
			LOGGER.error("deleteFile error,uuid=" + uuid,e);
			result = new FileResult();
			result.setSuccess(false);
		}
		return result;
	}
	
	public FileResult deleteFileFromFtp(String ip,String user,String pwd,String directory,String uuid){
		FileResult result = new FileResult();
		FTPClient ftpClient = null; 

        try { 
        	ftpClient = getFtpClient(ip,user,pwd);
            ftpClient.changeWorkingDirectory(directory);//转移到指定FTP服务器目录  
            result.setSuccess(ftpClient.deleteFile(uuid));
        } catch (IOException e) { 
            throw new RuntimeException("FTP客户端出错！", e); 
        } finally { 
            try { 
            	if (ftpClient != null){
            		ftpClient.disconnect(); 
            	} 
            } catch (IOException e) { 
//                throw new RuntimeException("关闭FTP连接发生异常！", e); 
            	LOGGER.error("close FTP connection error", e);
            } 
        } 
		return result;
	}
	
	public FileRequest generalCommonRequest(String appName,String storeSystemAddress){
		FileRequest request = new FileRequest();
		request.setAppName(appName);
		request.setStoreSystemAddress(storeSystemAddress);
		return request;
	}
	
	private FTPClient getFtpClient(String ip,String user,String pwd) throws SocketException, IOException{
		FTPClient ftpClient = new FTPClient(); 
		ftpClient.connect(ip); 
        ftpClient.login(user, pwd);
        ftpClient.setBufferSize(1024); 
        ftpClient.setControlEncoding("GBK"); 
        //设置文件类型（二进制） 
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
        return ftpClient;
	}
	
	public void setFileServiceClient(FileServiceClient fileServiceClient) {
		this.fileServiceClient = fileServiceClient;
	}

	public void setStoreSystemAddress(String storeSystemAddress) {
		this.storeSystemAddress = storeSystemAddress;
	}
}
