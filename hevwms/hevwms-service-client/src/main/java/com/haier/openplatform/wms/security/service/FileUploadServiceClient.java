package com.haier.openplatform.wms.security.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.wms.security.domain.UploadFile;

public interface FileUploadServiceClient {
    /**
    * @Title: getFileInputStreams
    * @Description:根据id获取文件流
    * @param @param id
    * @param @return
    * @return InputStream
    * @throws
    */
    public UploadFile getFileInputStreams(Long id);
    
    /**
     * @Title: getFileInputStreams
     * @Description:根据id获取文件流
     * @param @param id
     * @param @return
     * @return InputStream
     * @throws
     */
     public UploadFile getLatestApp(String name, String version);
    
	/** 
	* @Title: searchFileUploadBySwf 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param file
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<UploadFile>    返回类型 
	* @throws 
	*/
	public List<UploadFile> searchFileUploadBySwf(UploadFile file);
	
	/** 
	* @Title: deletefiles 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"ids"})
	public String deletefiles(String ids);

    /** 
    * @Title: getfileNameShow 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param status
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<UploadFile>    返回类型 
    * @throws 
    */
    @Export(paramNames = {"status"})
    public List<UploadFile> getfileNameShow(Integer status);
    
    /**
     * 
    * @Title: fileUploadBySwf
    * @Description: 安全管理--文件上传
    * @param @param fileInput
    * @param @param status
    * @param @return
    * @return String
    * @throws
     */
    public boolean fileUploadBySwf(UploadFile uploadFile);
    /**
     * 
    * @Title: deleteFileByName
    * @Description: 根据文件名进行删除
    * @param @param uploadFile
    * @param @return
    * @return boolean
    * @throws
     */
    public boolean deleteFileByName(UploadFile uploadFile);
}
