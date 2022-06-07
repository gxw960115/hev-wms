package com.haier.hevwms.takestock.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;

public interface OdsPdDiffDtlService {
	public ExecuteResult<OdsPdDiffDtl> createOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl);
	
	public ExecuteResult<OdsPdDiffDtl> updateOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl);
	
	public ExecuteResult<OdsPdDiffDtl> deleteOdsPdDiffDtl(Long odsPdDiffDtlId);
	public ExecuteResult<OdsPdDiffDtl> deleteOdsPdDiffDtlAll(List<Long> idList);
	
	public Pager<OdsPdDiffDtl> searchOdsPdDiffDtls(Pager<OdsPdDiffDtl> pager,OdsPdDiffDtl odsPdDiffDtl);
	
	public OdsPdDiffDtl getOdsPdDiffDtlById(Long odsPdDiffDtlId);
	
	public List<OdsPdDiffDtl> getOdsPdDiffDtls();
	/**
	 * 查询盘点差异信息
	 * @param odsPdDiffDtl
	 * @return
	 */
	public List<OdsPdDiffDtl> getOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl);

	public Long searchOdsPdDiffDtlsCount(OdsPdDiffDtl dtl);
	
}
