package com.haier.hevwms.po.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsPoGrInfoDTO;

public interface OdsPoGrInfoDAO extends CommonDAO<OdsPoGrInfoDTO, Long> {

	/**
	 * @title: searchOdsPoGrInfoListByPage
	 * @description: 条件分页查询 
	 * @author: LJZ
	 * @date: 2018年11月14日 上午11:12:50 
	 * @param pager
	 * @param OdsPoGrInfo
	 * @return: List<OdsPoGrInfoDTO>
	 */
	public List<OdsPoGrInfoDTO> searchOdsPoGrInfoListByPage(
			@Param("pager") Pager<OdsPoGrInfoDTO> pager,
			@Param("odsPoGrInfo") OdsPoGrInfoDTO OdsPoGrInfo);

	/**
	 * @title: searchOdsPoGrInfoCount
	 * @description: 条件统计 
	 * @author: LJZ
	 * @date: 2018年11月14日 上午11:13:07 
	 * @param OdsPoGrInfo
	 * @return: Long
	 */
	public Long searchOdsPoGrInfoCount(
			@Param("odsPoGrInfo") OdsPoGrInfoDTO OdsPoGrInfo);

	/**
	 * @title: deleteAll
	 * @description: 通过ID删除 
	 * @author: LJZ
	 * @date: 2018年11月14日 上午11:13:30 
	 * @param idList
	 * @return: void
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	 * @title: searchList
	 * @description: 
	 * @author: 未知
	 * @date: 2018年11月14日 上午11:16:13 
	 * @param OdsPoGrInfo
	 * @return: List<OdsPoGrInfoDTO>
	 */
	public List<OdsPoGrInfoDTO> searchList(@Param("odsPoGrInfo") OdsPoGrInfoDTO OdsPoGrInfo);
	
	/**
	 * @title: updatePostResult
	 * @description: 
	 * @author: 未知
	 * @date: 2018年11月14日 上午11:16:26 
	 * @param OdsPoGrInfo
	 * @return: void
	 */
	public void updatePostResult(@Param("odsPoGrInfo") OdsPoGrInfoDTO OdsPoGrInfo);
	
	/**
	 * @title: updatePostResult
	 * @description: 
	 * @author: 未知
	 * @date: 2018年11月14日 上午11:16:26 
	 * @param OdsPoGrInfo
	 * @return: void
	 */
	public void updateReverseResult(@Param("odsPoGrInfo") OdsPoGrInfoDTO OdsPoGrInfo);
}