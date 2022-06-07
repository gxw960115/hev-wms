package com.haier.hevwms.takestock.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;

public interface OdsPdDiffDtlDAO extends CommonDAO<OdsPdDiffDtl, Long> {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdDiffDtl> searchOdsPdDiffDtls(
			@Param("pager") Pager<OdsPdDiffDtl> pager,
			@Param("odsPdDiffDtl") OdsPdDiffDtl odsPdDiffDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchOdsPdDiffDtlsCount(
			@Param("odsPdDiffDtl") OdsPdDiffDtl odsPdDiffDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteByPdNo(@Param("pdNo") String pdNo);
	/**
	 * 查询盘点差异明细信息
	 * @param odsPdDiffDtl
	 * @return
	 */
	public List<OdsPdDiffDtl> getOdsPdDiffDtl(@Param("odsPdDiffDtl")OdsPdDiffDtl odsPdDiffDtl);
	
	public void updateProcessReason(@Param("odsPdDiffDtl")OdsPdDiffDtl odsPdDiffDtl);

    public void updateProcessFlag(@Param("id") String id, @Param("processFlag") String processFlag);
}