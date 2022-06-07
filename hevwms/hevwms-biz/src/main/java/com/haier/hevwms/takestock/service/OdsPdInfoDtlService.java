package com.haier.hevwms.takestock.service;

import java.util.List;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

public interface OdsPdInfoDtlService {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfoDtl> createOdsPdInfoDtl(OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfoDtl> updateOdsPdInfoDtl(OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfoDtl> deleteOdsPdInfoDtl(Long odsPdInfoDtlId);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsPdInfoDtl> deleteOdsPdInfoDtlAll(List<Long> idList);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	
	public Pager<OdsPdInfoDtl> searchOdsPdInfoDtls(Pager<OdsPdInfoDtl> pager,OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public OdsPdInfoDtl getOdsPdInfoDtlById(Long odsPdInfoDtlId);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> getOdsPdInfoDtls(OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public Pager<OdsPdInfoDtl> searchOdsPdInfoDtlsBySum(Pager<OdsPdInfoDtl> pager,OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> searchOdsPdInfoDtlsBySum2(OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 */
	public Pager<OdsPdInfoDtl> pdQtyDetail(Pager<OdsPdInfoDtl> pager,OdsPdInfoDtl odsPdInfoDtl);
	public Long getPdExportAmount(OdsPdInfoDtl dtl);
	public Long searchOdsPdInfoDtlsCountBySum(OdsPdInfoDtl dtl);
	/**  
	* @Title: orderDelete  
	* @Description: 删除盘点信息
	* @author: ZhangLL
	* @param in
	* @return OrderDeleteOutDTO
	* @throws  
	*/
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in);
	
	/**  
	* @Title: scanStockTaking  
	* @Description: 盘点扫描
	* @author: ZhangLL
	* @param inpara
	* @return OrderUploadOutDTO
	* @throws  
	*/
	public OrderUploadOutDTO scanStockTaking(OrderUploadInDTO inpara);
}
