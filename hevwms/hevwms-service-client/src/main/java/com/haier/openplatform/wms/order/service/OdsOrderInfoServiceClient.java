/**
 * @Company
 * @Title: OdsOrderInfoServiceClient.java
 * @Package com.haier.openplatform.wms.order.service
 * @author Administrator
 * @date 2015-11-11 
 * @version V1.0
 */
package com.haier.openplatform.wms.order.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**
 * @ClassName: OdsOrderInfoServiceClient
 * @Description: Order信息
 * 
 */

public interface OdsOrderInfoServiceClient {

    public Pager<OdsOrderInfoDTO> searchOdsOrderInfo(
            Pager<OdsOrderInfoDTO> pager, OdsOrderInfoDTO dto);
    public Pager<OdsOrderInfoDTO> searchOIGPOrderInfo(Pager<OdsOrderInfoDTO> pager, OdsOrderInfoDTO dto);

    public String createOdsOrderInfo(OdsOrderInfoDTO dto);

    public String deleteOdsOrderInfo(String ids);

    /**
     * 
     * 方法描述：参数描述：返回值描述
     * 
     * @author sunyanfei
     * @param
     * @return
     */
    public Pager<OdsOrderInfoDTO> searchOdsOrderInfoDTOs(Long page, Long rows,
            OdsOrderInfoDTO odsOrderInfoDTO);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 2015-11-23 孙艳飞 sto detail preScan 单据号grid
	 * @param
	 * @return\
	 */
	public Pager<OdsOrderInfoDTO> searchOrderNos(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * added by gaozhaomei 2016-11-7
	 * @param
	 * @return
	 */
	public Pager<OdsOrderInfoDTO> searchStoDNDetail(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo);
	
	public Pager<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNo(Pager<OdsOrderInfoDtlDTO> pager,
			OdsOrderInfoDtlDTO odsOrderInfoDtl);
	
	public List<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNoList(OdsOrderInfoDtlDTO odsOrderInfoDtl);

    /**
     * @Title: getListByParams
     * @Description: 导出功能查询
     * @param @param odsOrderInfo
     * @param @return
     * @return List<OdsOrderInfoDTO>
     * @throws
     */
    public List<OdsOrderInfoDTO> getListByParams(OdsOrderInfoDTO odsOrderInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 2015-11-23 孙艳飞 sto detail preScan 
	 * @param
	 * @return
	 */
	public List<OdsOrderInfoDTO> getOdsOrderInfos(OdsOrderInfoDTO odsOrderInfo);
	
	public void saveOdsInfoDtls(String msg);
	
	public ExecuteResult<OdsOrderInfoDTO> savePreScan(String msg, String postingDate);
	
	public void deleteOdsOrderInfoDtlByNo(String msg);
	
	public void updateFinishQty(String msg);

	/**
	 * 过账失败的是单据重新过账
	 *  ogp igp info posting sunyanfei2015-11-25
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	public String postOrder(String orderNo, String userName) throws Exception;
	/**
	 * 
	* @Title: getOrderNo
	* @Description: TODO (孙艳飞  ogp info add按钮生成OGP/IGP NO:)
	* @param @param msg
	* @param @return
	* @return String
	* @throws
	 */
	@Export(paramNames={"msg"})
	public String getOrderNo(String msg);
	
	/**
	 *    ogp/igp直接出入库
	 */
	@Export(paramNames={"orderNo","orderType"})
	public String inOutWarehouse(String orderNo,String orderType);
	
	/**
	 * 取消汇总sjk
	 * @param odsOrderInfo
	 * @return
	 */
	public OrderIgpOutDTO iogpCancel(OdsOrderInfoDTO odsOrderInfo);
	
	public Long getExportAmount(OdsOrderInfoDTO odsOrderInfo);
}
