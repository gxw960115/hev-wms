package com.haier.hevwms.security.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.security.domain.UploadFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileUploadDAO extends CommonDAO<UploadFile, Long>{

	/**
	 * 查询文件
	 * @param model
	 * @return
	 */
	List<UploadFile> getFileByStatusAndType(UploadFile file);
	/**
	 * 查询文件总条数
	 * @param model
	 * @return
	 */
	Long getFileByStatusAndTypeCount(UploadFile file);
	/**
	 * 保存
	 * @param uploadFile
	 */
	@Override
	void save(UploadFile uploadFile);
	/**
	 *
	* @Title: getfileNameShow
	* @Description: portal页面得到文件列表
	* @param @param status
	* @param @return
	* @return List<UploadFile>
	* @throws
	 */
	public List<UploadFile> getfileNameShow(@Param("status") Integer status);
	/**
	 *
	* @Title: deleteFileByName
	* @Description: 根据文件名进行删除
	* @param @param uploadFile
	* @return void
	* @throws
	 */
	void deleteFileByName(UploadFile uploadFile);
	/**
	 *
	* @Title: getPdaFileInfo
	* @Description: 得到手持文件信息
	* @param @return
	* @return UploadFile
	* @throws
	 */
	public UploadFile getPdaFileInfo();

	public UploadFile getAppVersion(@Param("name")String name, @Param("version")String version);
}
