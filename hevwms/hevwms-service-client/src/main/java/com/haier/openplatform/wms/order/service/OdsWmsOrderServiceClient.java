/**
* @Company ������ͨ
* @Title: OdsWmsOrderServiceClient.java
* @Package com.haier.openplatform.wms.order.service
* @author Administrator
* @date 2015-11-6 ����10:39:08
* @version V1.0
*/
package com.haier.openplatform.wms.order.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.order.dto.OdsWmsOrderDTO;

/**
 * @ClassName: OdsWmsOrderServiceClient
 * @Description: 
 *
 */
public interface OdsWmsOrderServiceClient {
    @Export(paramNames={"pager","dto"})
    public Pager<OdsWmsOrderDTO> searchOdsWmsOrders(Pager<OdsWmsOrderDTO> pager,OdsWmsOrderDTO dto);
    
    /**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * @author sunyanfei
	 * @param
	 * @return
	 */
	@Export(paramNames={"odsWmsOrderDTO"})
	public ExecuteResult<OdsWmsOrderDTO> createOdsWmsOrder(OdsWmsOrderDTO odsWmsOrderDTO);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	@Export(paramNames={"odsWmsOrderDTO"})
	public ExecuteResult<OdsWmsOrderDTO> updateOdsWmsOrder(OdsWmsOrderDTO odsWmsOrderDTO);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	@Export(paramNames={"odsWmsOrderId"})
	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrder(Long odsWmsOrderId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	@Export(paramNames={"idList"})
	public ExecuteResult<OdsWmsOrderDTO> deleteOdsWmsOrderAll(List<Long> idList);

	

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public OdsWmsOrderDTO getOdsWmsOrderById(Long odsWmsOrderId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsWmsOrderDTO> getOdsWmsOrders();

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	
	public ExecuteResult<OdsWmsOrderDTO> deltGfOrder(OdsWmsOrderDTO odsWmsOrderDTO);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	@Export(paramNames={"odsWmsOrderDTO","ids"})
	public ExecuteResult<OdsWmsOrderDTO> saveScrapOrder(OdsWmsOrderDTO odsWmsOrderDTO,
			String ids);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	@Export(paramNames={"odsWmsOrderDTO"})
	public ExecuteResult<OdsWmsOrderDTO> updateScrapOrder(OdsWmsOrderDTO odsWmsOrderDTO);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	@Export(paramNames={"odsWmsOrderDTO"})
	public ExecuteResult<OdsWmsOrderDTO> deleteScrapOrder(OdsWmsOrderDTO odsWmsOrderDTO);

	/**
	 * 查询odsWmsOrder
	 * 
	 * @param odsWmsOrder
	 * @return
	 */
	public List<OdsWmsOrderDTO> getOdsWmsOrder(OdsWmsOrderDTO odsWmsOrderDTO);
	
	/**
	 * 查询scrap order的条码
	 * 
	 * @param odsWmsOrder
	 * @return
	 */
	@Export(paramNames={"pager","odsInventoryInfoDtlDTO"})
	public Pager<OdsInventoryInfoDtlDTO> searchScrapBarcodeDtl(Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
    
}
