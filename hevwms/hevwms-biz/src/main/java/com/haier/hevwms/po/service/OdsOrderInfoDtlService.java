package com.haier.hevwms.po.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;

public interface OdsOrderInfoDtlService {   

    public Pager<OdsOrderInfoDtlDTO> searchOdsOrderInfoDtls(Pager<OdsOrderInfoDtlDTO> pager,OdsOrderInfoDtlDTO odsOrderInfoDtlDTO);
    
    
//	public ExecuteResult<OdsOrderInfoDtl> createOdsOrderInfoDtl(OdsOrderInfoDtl odsOrderInfoDtl);  
//	
//	public ExecuteResult<OdsOrderInfoDtl> updateOdsOrderInfoDtl(OdsOrderInfoDtl odsOrderInfoDtl);
//	
//	public ExecuteResult<OdsOrderInfoDtl> deleteOdsOrderInfoDtl(Long odsOrderInfoDtlId);
//	public ExecuteResult<OdsOrderInfoDtl> deleteOdsOrderInfoDtlAll(List<Long> idList);
	
	
//	public OdsOrderInfoDtl getOdsOrderInfoDtlById(Long odsOrderInfoDtlId);
//	
//	public List<OdsOrderInfoDtl> getOdsOrderInfoDtls();
//	/**
//	 * 查询鸣谢导出
//	 * @param odsOrderInfoDtl
//	 * @return
//	 */
//	public List<OdsOrderInfoDtl> getOdsOrderInfoDtls(
//			OdsOrderInfoDtl odsOrderInfoDtl);
	
    
	
	public OdsOrderInfoDtlDTO getOdsOrderInfoDtlById(Long odsOrderInfoDtlId);
	
	public void save(OdsOrderInfoDtlDTO odsOrderInfoDtlDTO);
	public List<OdsOrderInfoDtlDTO> getOdsOrderInfoDtls();
	/**
	 * 查询鸣谢导出
	 * @param odsOrderInfoDtl
	 * @return
	 */
	public List<OdsOrderInfoDtlDTO> getOdsOrderInfoDtls(
			OdsOrderInfoDtlDTO odsOrderInfoDtlDTO);

	public Long getExportAmount(OdsOrderInfoDtlDTO odsOrderInfoDtl);


	public OrderDirectDispatchOutDTO directDispatchCollect(String stodnNo, String dnNo, String userName);
}
