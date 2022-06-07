package com.haier.hevwms.security.service;
import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.domain.UploadFile;

public interface FilesUploadService {

    /**
     * @Title: getFileInputStream
     * @Description:下载根据id查询
     * @param @param id
     * @param @return
     * @return UploadFileDTO
     * @throws
     */
    UploadFile getFileInputStream(Long id);
    
    /**
     * @Title: getFileInputStream
     * @Description:下载根据id查询
     * @param @param id
     * @param @return
     * @return UploadFileDTO
     * @throws
     */
    UploadFile getLatestApp(String name, String version);
    
    /**
     * 附件上传信息查询
     *ZhangYing@jbinfo.cn
     * 2015-12-8
     */
    List<UploadFile> getFileByStatusAndType(UploadFile file);
	
	//ExecuteResult<UploadFile> fileUpload(File fileInput,String fileInputFileName,String userName) throws IOException;
	
    /**
     * 删除附件信息
     *ZhangYing@jbinfo.cn
     * 2015-12-9
     */
	ExecuteResult<String> deleteFileByIds(String ids);
	String deleteFileById(Long id);
	
    /**
     * 
    * @Title: getfileNameShow
    * @Description: portal页面得到文件列表
    * @param @param status
    * @param @return
    * @return List<UploadFile>
    * @throws
     */
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
