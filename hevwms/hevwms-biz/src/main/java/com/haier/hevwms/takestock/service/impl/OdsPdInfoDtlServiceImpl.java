package com.haier.hevwms.takestock.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.takestock.dao.OdsPdInfoDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.hevwms.takestock.service.OdsPdInfoDtlService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
* @ClassName: OdsPdInfoDtlServiceImpl
* @Description: 库存盘点明细 相关 功能实现
* @author songyinglong
* @Date 2015-10-30 下午3:23:43
*/
public class OdsPdInfoDtlServiceImpl implements OdsPdInfoDtlService{
	
	/**  
	 * @Fields log: 用一句话描述该文件做什么
	 */
	private static final Logger log = LoggerFactory.getLogger(OdsPdInfoDtlServiceImpl.class);
	
	private OdsPdInfoDtlDAO odsPdInfoDtlDAO;
	
	/**
	* <p>Title: createOdsPdInfoDtl</p>
	* <p>Description:创建 库存盘点明细 记录 </p>
	* @param odsPdInfoDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#createOdsPdInfoDtl(com.haier.hevwms.takestock.domain.OdsPdInfoDtl)
	*/
	@Override
	public ExecuteResult<OdsPdInfoDtl> createOdsPdInfoDtl(OdsPdInfoDtl odsPdInfoDtl){
		ExecuteResult<OdsPdInfoDtl> executeResult = new ExecuteResult<OdsPdInfoDtl>();
		
		odsPdInfoDtlDAO.save(odsPdInfoDtl);
		executeResult.setResult(odsPdInfoDtl);
		return executeResult;
	}
	
	/**
	* <p>Title: updateOdsPdInfoDtl</p>
	* <p>Description: 更新 库存盘点明细</p>
	* @param odsPdInfoDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#updateOdsPdInfoDtl(com.haier.hevwms.takestock.domain.OdsPdInfoDtl)
	*/
	public ExecuteResult<OdsPdInfoDtl> updateOdsPdInfoDtl(OdsPdInfoDtl odsPdInfoDtl){
		ExecuteResult<OdsPdInfoDtl> executeResult = new ExecuteResult<OdsPdInfoDtl>();
		
		odsPdInfoDtlDAO.update(odsPdInfoDtl);
		executeResult.setResult(odsPdInfoDtl);
		return executeResult;
	}
	
	/**
	* <p>Title: deleteOdsPdInfoDtl</p>
	* <p>Description: 删除 库存盘点明细 记录 </p>
	* @param odsPdInfoDtlId
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#deleteOdsPdInfoDtl(java.lang.Long)
	*/
	public ExecuteResult<OdsPdInfoDtl> deleteOdsPdInfoDtl(Long odsPdInfoDtlId){
		ExecuteResult<OdsPdInfoDtl> executeResult = new ExecuteResult<OdsPdInfoDtl>();
		
		odsPdInfoDtlDAO.delete(odsPdInfoDtlId);
		return executeResult;
	}
	
	/**
	* <p>Title: deleteOdsPdInfoDtlAll</p>
	* <p>Description: 删除全部的 库存盘点明细 记录</p>
	* @param idList
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#deleteOdsPdInfoDtlAll(java.util.List)
	*/
	public ExecuteResult<OdsPdInfoDtl> deleteOdsPdInfoDtlAll(List<Long> idList){
		ExecuteResult<OdsPdInfoDtl> executeResult = new ExecuteResult<OdsPdInfoDtl>();
		
		odsPdInfoDtlDAO.deleteAll(idList);
		return executeResult;
	}
	
	/**
	* <p>Title: searchOdsPdInfoDtls</p>
	* <p>Description: 查询 库存盘点明细 记录</p>
	* @param pager
	* @param odsPdInfoDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#searchOdsPdInfoDtls(com.haier.openplatform.util.Pager, com.haier.hevwms.takestock.domain.OdsPdInfoDtl)
	*/
	public Pager<OdsPdInfoDtl> searchOdsPdInfoDtls(Pager<OdsPdInfoDtl> pager, OdsPdInfoDtl odsPdInfoDtl){
		List<OdsPdInfoDtl> odsPdInfoDtls = odsPdInfoDtlDAO.searchOdsPdInfoDtls(pager, odsPdInfoDtl);
		long size = odsPdInfoDtlDAO.searchOdsPdInfoDtlsCount(odsPdInfoDtl);
		return Pager.cloneFromPager(pager, size, odsPdInfoDtls);
	}
	/**
	* <p>Title: searchOdsPdInfoDtlsBySum</p>
	* <p>Description: 根据实际盘点数量  查询 库存盘点明细 记录</p>
	* @param pager
	* @param odsPdInfoDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#searchOdsPdInfoDtlsBySum(com.haier.openplatform.util.Pager, com.haier.hevwms.takestock.domain.OdsPdInfoDtl)
	*/
	public Pager<OdsPdInfoDtl> searchOdsPdInfoDtlsBySum(Pager<OdsPdInfoDtl> pager, OdsPdInfoDtl odsPdInfoDtl){
//	    	String plant=odsPdInfoDtlDAO.getPlantByOrderNo(odsPdInfoDtl.getOrderNo());
//	    	odsPdInfoDtl.setPlant(plant);
		List<OdsPdInfoDtl> odsPdInfoDtls = odsPdInfoDtlDAO.searchOdsPdInfoDtlsBySum(pager, odsPdInfoDtl);
		long size = odsPdInfoDtlDAO.searchOdsPdInfoDtlsCountBySum(odsPdInfoDtl);
		return Pager.cloneFromPager(pager, size, odsPdInfoDtls);
	}
	
	
	@Override
	public List<OdsPdInfoDtl> searchOdsPdInfoDtlsBySum2(
			OdsPdInfoDtl odsPdInfoDtl) {
		return odsPdInfoDtlDAO.searchOdsPdInfoDtlsBySum2(odsPdInfoDtl);
	}

	/**
	* <p>Title: getOdsPdInfoDtlById</p>
	* <p>Description: 根据 单号，查询 库存盘点明细 记录</p>
	* @param odsPdInfoDtlId
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#getOdsPdInfoDtlById(java.lang.Long)
	*/
	public OdsPdInfoDtl getOdsPdInfoDtlById(Long odsPdInfoDtlId){
		return odsPdInfoDtlDAO.get(odsPdInfoDtlId);
	}
	
	/**
	* <p>Title: getOdsPdInfoDtls</p>
	* <p>Description:返回  库存盘点明细 对象 集合 </p>
	* @param odsPdInfoDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#getOdsPdInfoDtls(com.haier.hevwms.takestock.domain.OdsPdInfoDtl)
	*/
	public List<OdsPdInfoDtl> getOdsPdInfoDtls(OdsPdInfoDtl odsPdInfoDtl){
		return odsPdInfoDtlDAO.getListByParams(odsPdInfoDtl);
	}
	
	/**
	 * 
	* <p>Title: pdQtyDetail</p>
	* <p>Description: </p>
	* @param pager
	* @param odsPdInfoDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#pdQtyDetail(com.haier.openplatform.util.Pager, com.haier.hevwms.takestock.domain.OdsPdInfoDtl)
	 */
	@Override
	public Pager<OdsPdInfoDtl> pdQtyDetail(Pager<OdsPdInfoDtl> pager,
		OdsPdInfoDtl odsPdInfoDtl) {
	    List<OdsPdInfoDtl> odsPdInfoDtls = odsPdInfoDtlDAO.pdQtyDetail(pager, odsPdInfoDtl);
	    long size = odsPdInfoDtlDAO.pdQtyDetailCount(odsPdInfoDtl);
	    return Pager.cloneFromPager(pager, size, odsPdInfoDtls);
	}
	
	@Override
	public Long getPdExportAmount(OdsPdInfoDtl dtl) {
		return odsPdInfoDtlDAO.searchOdsPdInfoDtlsCount(dtl);
	}
	
	@Override
	public Long searchOdsPdInfoDtlsCountBySum(OdsPdInfoDtl dtl) {
		return odsPdInfoDtlDAO.searchOdsPdInfoDtlsCountBySum(dtl);
	}

	/**
	* @Title: setOdsPdInfoDtlDAO
	* @Description: setter方法
	* @param @param odsPdInfoDtlDAO
	* @return void
	* @throws
	*/
	public void setOdsPdInfoDtlDAO(OdsPdInfoDtlDAO odsPdInfoDtlDAO){
		this.odsPdInfoDtlDAO = odsPdInfoDtlDAO;
	}
	/**
	* @Title: getOdsPdInfoDtlDAO
	* @Description: getter方法
	* @param @return
	* @return OdsPdInfoDtlDAO
	* @throws
	*/
	public OdsPdInfoDtlDAO getOdsPdInfoDtlDAO(){
		return odsPdInfoDtlDAO;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#orderDelete(com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn)
	 */
	@Override
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		odsPdInfoDtlDAO.deleteInfoDtlByBarcode(in, out);
		if("0".equals(out.getStatus())){
			out.setStatus("S");
		} else		{
			out.setStatus("F");
		}
		return out;
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.takestock.service.OdsPdInfoDtlService#scanStockTaking(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO)
	 */
	@Override
	public OrderUploadOutDTO scanStockTaking(OrderUploadInDTO inpara) {
		log.debug("Scan StockTaking start--order no:"+inpara.getOrno()+", barcode:"+inpara.getBarcode());
	    OrderUploadOutDTO result = new OrderUploadOutDTO();
	    odsPdInfoDtlDAO.scanStockTaking(inpara, result);
		return result;
	}
}
