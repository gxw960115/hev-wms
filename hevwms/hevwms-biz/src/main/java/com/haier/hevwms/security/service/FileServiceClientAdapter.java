package com.haier.hevwms.security.service;

import java.io.File;

import com.haier.openplatform.hfs.client.dto.FileResult;

public interface FileServiceClientAdapter {

	public FileResult saveFile(File file,String fileName);
	
	public FileResult findFile(String uuid);
	
	public FileResult deleteFile(String uuid);
}
