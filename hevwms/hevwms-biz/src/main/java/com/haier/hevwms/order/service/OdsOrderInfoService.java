package com.haier.hevwms.order.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.hevwms.order.domain.OdsOrderInfo;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;

public interface OdsOrderInfoService {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String createOdsOrderInfo(OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsOrderInfoDTO> saveInOrder(OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */

	public ExecuteResult<OdsOrderInfoDTO> updateOdsOrderInfo(
			OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsOrderInfoDTO> deleteOdsOrderInfo(Long odsOrderInfoId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsOrderInfoDTO> deleteOdsOrderInfoAll(List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsOrderInfoDTO> searchOdsOrderInfos(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo);
	public Pager<OdsOrderInfoDTO> searchOIGPOrderInfo(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public OdsOrderInfoDTO getOdsOrderInfoById(Long odsOrderInfoId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> getOdsOrderInfos(OdsOrderInfoDTO odsOrderInfo);
	
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsOrderInfoDTO> searchOrderNos(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsOrderInfoDTO> searchStoDNDetail(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo);
	
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNo(Pager<OdsOrderInfoDtlDTO> pager,
			OdsOrderInfoDtlDTO odsOrderInfoDtl);
	
	/**
	 * 
	 * 根据查询条件，获取所有
	 * 
	 * @param odsOrderInfoDtl
	 * @return
	 */
	public List<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNoList(
			OdsOrderInfoDtlDTO odsOrderInfoDtl);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void saveOdsInfoDtls(String msg);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> findCarList(OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsOrderInfoDTO> savePreScan(String msg,
			String postingDate);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteOdsOrderInfoDtlByNo(String msg);

	/**
	 * 过账失败的是单据重新过账
	 * 
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public String postOrder(String orderNo, String userName) throws Exception;
	public String postOrderPlus(String orderNo, String userName) throws Exception;

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String createOrderNo(String inOut);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public ExecuteResult<OdsOrderInfoDTO> deltGfOrder(OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void saveOdsInfoDtlsByInvetory(String msg, String orderNo);

	public void updateFinishQty(String stoNo);
	
	/**
	 * 查询导出
	 * @param odsOrderInfo
	 * @return
	 */
	public List<OdsOrderInfoDTO> getListByParam(OdsOrderInfo odsOrderInfo);

    public List<OdsOrderInfoDTO> getListByName(OdsOrderInfoDTO odsOrderInfo);
    
    /**
     * ogp/igp直接出入库
     */
    public String inOutWarehouse(String orderNo,String orderType,String userName);
    
    /**
     * ogp/igp取消
     */
    public WmsOrderIgpOut iogpCancel(OdsOrderInfoDTO odsOrderInfo);
    
    public Long getExportAmount(OdsOrderInfoDTO odsOrderInfo);
}
