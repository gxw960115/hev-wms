package com.haier.openplatform.wms.security.service.impl;

import java.util.List;

import com.haier.hevwms.security.service.FilesUploadService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.service.FileUploadServiceClient;


public class FileUploadServiceClientImpl implements FileUploadServiceClient {
    
    private FilesUploadService fileUploadService;
    
    /**
    * <p>Title: getFileInputStreams</p>
    * <p>Description:根据id查询下载内容 </p>
    * @param id
    * @return
    * @see com.haier.openplatform.wms.security.service.FileUploadServiceClient#getFileInputStreams(java.lang.Long)
    */
    @Override
    public UploadFile getFileInputStreams(Long id) {
        // TODO Auto-generated method stub
        return fileUploadService.getFileInputStream(id);
    }
    
    @Override
	public UploadFile getLatestApp(String name, String version) {
    	// TODO Auto-generated method stub
        return fileUploadService.getLatestApp(name, version);
	}

    /**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-8
	 */
	@Override
	public List<UploadFile> searchFileUploadBySwf(UploadFile file) {
        return fileUploadService.getFileByStatusAndType(file);
	}

	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-9
	 */
	@Override
	public String deletefiles(String ids) {
		
		ExecuteResult<String> result=fileUploadService.deleteFileByIds(ids);
		if (!result.isSuccess()){
		    return result.getErrorMessages().get(0);
		}
		return "SUCCESS";
	}

    @Override
    public List<UploadFile> getfileNameShow(Integer status) {
        return fileUploadService.getfileNameShow(status);
    }

    @Override
    public boolean fileUploadBySwf(UploadFile uploadFile) {
        return fileUploadService.fileUploadBySwf(uploadFile);
    }

    @Override
    public boolean deleteFileByName(UploadFile uploadFile) {
        return fileUploadService.deleteFileByName(uploadFile);
    }
   
    public FilesUploadService getFileUploadService() {
        return fileUploadService;
    }

    public void setFileUploadService(FilesUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

	
}
