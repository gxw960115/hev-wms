package com.haier.openplatform.showcase.service;

import org.springframework.web.multipart.MultipartFile;

import com.haier.openplatform.hfs.client.dto.FileResult;

public interface FileServiceClientAdapter {

	public FileResult saveFile(String appName,byte[] files,String fileName);
	
	public FileResult saveFileToFtp(String ip,String user,String pwd,String directory,MultipartFile file);
	
	public FileResult findFile(String appName,String uuid);
	
	public FileResult findFileFromFtp(String ip,String user,String pwd,String directory,String uuid);
	
	public FileResult deleteFile(String appName,String uuid);
	
	public FileResult deleteFileFromFtp(String ip,String user,String pwd,String directory,String uuid);
}
