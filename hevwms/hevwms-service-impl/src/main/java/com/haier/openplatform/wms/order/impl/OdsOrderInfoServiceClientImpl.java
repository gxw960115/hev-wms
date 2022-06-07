package com.haier.openplatform.wms.order.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.order.service.OdsOrderInfoService;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO;
import com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**  
 * @ClassName: OdsOrderInfoServiceClientImpl  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2018-4-20  
 */ 
@Path("OdsOrderInfoServiceClientImpl")
@Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 参数类型
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 返回值类型
public class OdsOrderInfoServiceClientImpl implements OdsOrderInfoServiceClient {
    Logger logger = Logger.getLogger(OdsOrderInfoServiceClientImpl.class);

    /**  
     * @Fields field:field:{}(odsOrderInfoService)  
     */  
    private OdsOrderInfoService odsOrderInfoService;

    /**  
     * @Title: setOdsOrderInfoService  
     * @Description: (set)  
     * @param odsOrderInfoService
     * @return void 
     * @throws  
     */  
    public void setOdsOrderInfoService(OdsOrderInfoService odsOrderInfoService) {
        this.odsOrderInfoService = odsOrderInfoService;
    }

    /**
     * Title: SearchStgStoDown
     * Description:
     * @param pager
     * @param dto
     * @return
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#SearchStgStoDown(com.haier.openplatform.util.Pager,
     *      com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)
     */
    @Override
    public Pager<OdsOrderInfoDTO> searchOdsOrderInfo(
            Pager<OdsOrderInfoDTO> pager, OdsOrderInfoDTO dto) {
        return odsOrderInfoService.searchOdsOrderInfos(pager, dto);
    }

    /** (non-Javadoc)  
     * <p>Title: createOdsOrderInfo</p>  
     * <p>Description:创建 </p>  
     * @param dto
     * @return  
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#createOdsOrderInfo(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
     */
    @Override
    public String createOdsOrderInfo(OdsOrderInfoDTO dto) {
        return odsOrderInfoService.createOdsOrderInfo(dto);
    }

    /**
     * <p>
     * Title: deleteOdsOrderInfo
     * </p>
     * <p>
     * Description:
     * </p>
     * 
     * @param ids
     * @return
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#deleteOdsOrderInfo(java.lang.String)
     */
    @Override
    public String deleteOdsOrderInfo(String ids) {
        //  Auto-generated method stub
        return null;
    }

    /** (non-Javadoc)  
     * <p>Title: searchOdsOrderInfoDTOs</p>  
     * <p>Description:查询 </p>  
     * @param page
     * @param rows
     * @param odsOrderInfoDTO
     * @return  
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#searchOdsOrderInfoDTOs(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
     */
    @Override
    public Pager<OdsOrderInfoDTO> searchOdsOrderInfoDTOs(Long page, Long rows,
            OdsOrderInfoDTO odsOrderInfoDTO) {
        Pager<OdsOrderInfoDTO> pager = new Pager<OdsOrderInfoDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        pager = odsOrderInfoService.searchOdsOrderInfos(pager, odsOrderInfoDTO);
        return pager;
      }

	/** (non-Javadoc)  
	 * <p>Title: searchOrderNos</p>  
	 * <p>Description:查询 </p>  
	 * @param pager
	 * @param odsOrderInfo
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#searchOrderNos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
	 */
	@Override
	public Pager<OdsOrderInfoDTO> searchOrderNos(Pager<OdsOrderInfoDTO> pager,
			OdsOrderInfoDTO odsOrderInfo) {
		return odsOrderInfoService.searchOrderNos(pager, odsOrderInfo);
	}

	/** (non-Javadoc)  
	 * <p>Title: getOdsOrderInfos</p>  
	 * <p>Description:查询 </p>  
	 * @param odsOrderInfo
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#getOdsOrderInfos(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
	 */
	@Override
	public List<OdsOrderInfoDTO> getOdsOrderInfos(OdsOrderInfoDTO odsOrderInfo) {
		return odsOrderInfoService.getOdsOrderInfos(odsOrderInfo);
	}

	/** (non-Javadoc)  
	 * <p>Title: searchStoDNDetail</p>  
	 * <p>Description:查询 </p>  
	 * @param pager
	 * @param odsOrderInfo
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#searchStoDNDetail(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
	 */
	@Override
	public Pager<OdsOrderInfoDTO> searchStoDNDetail(Pager<OdsOrderInfoDTO> pager,
				OdsOrderInfoDTO odsOrderInfo) {
			return odsOrderInfoService.searchStoDNDetail(pager, odsOrderInfo);
	}
	
	/** (non-Javadoc)  
	 * <p>Title: searchOgpDetailsByStodnNo</p>  
	 * <p>Description:查询 </p>  
	 * @param pager
	 * @param odsOrderInfoDtl
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#searchOgpDetailsByStodnNo(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.OdsOrderInfoDtlDTO)  
	 */
	@Override
	public Pager<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNo(Pager<OdsOrderInfoDtlDTO> pager,
			OdsOrderInfoDtlDTO odsOrderInfoDtl) {
			return odsOrderInfoService.searchOgpDetailsByStodnNo(pager, odsOrderInfoDtl);
	}
	
	/** (non-Javadoc)  
	 * <p>Title: searchOgpDetailsByStodnNoList</p>  
	 * <p>Description:查询 </p>  
	 * @param odsOrderInfoDtl
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#searchOgpDetailsByStodnNoList(com.haier.openplatform.wms.order.dto.OdsOrderInfoDtlDTO)  
	 */
	@Override
	public List<OdsOrderInfoDtlDTO> searchOgpDetailsByStodnNoList(OdsOrderInfoDtlDTO odsOrderInfoDtl) {
			return odsOrderInfoService.searchOgpDetailsByStodnNoList(odsOrderInfoDtl);
	}
		
	/** (non-Javadoc)  
	 * <p>Title: saveOdsInfoDtls</p>  
	 * <p>Description: </p>  
	 * @param msg  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#saveOdsInfoDtls(java.lang.String)  
	 */
	@Override
	public void saveOdsInfoDtls(String msg) {
		odsOrderInfoService.saveOdsInfoDtls(msg);
	}

	/** (non-Javadoc)  
	 * <p>Title: savePreScan</p>  
	 * <p>Description: </p>  
	 * @param msg
	 * @param postingDate
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#savePreScan(java.lang.String, java.lang.String)  
	 */
	@Override
	public ExecuteResult<OdsOrderInfoDTO> savePreScan(String msg,
			String postingDate) {
		return odsOrderInfoService.savePreScan(msg, postingDate);
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteOdsOrderInfoDtlByNo</p>  
	 * <p>Description:删除 </p>  
	 * @param msg  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#deleteOdsOrderInfoDtlByNo(java.lang.String)  
	 */
	@Override
	public void deleteOdsOrderInfoDtlByNo(String msg) {
		odsOrderInfoService.deleteOdsOrderInfoDtlByNo(msg);
	}

	/** (non-Javadoc)  
	 * <p>Title: updateFinishQty</p>  
	 * <p>Description:修改完成数量 </p>  
	 * @param msg  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#updateFinishQty(java.lang.String)  
	 */
	@Override
	public void updateFinishQty(String msg) {
		odsOrderInfoService.updateFinishQty(msg);
	}

    /**
     * <p>
     * Title: getListByParams
     * </p>
     * <p>
     * Description:导出功能查询实现
     * </p>
     * 
     * @param odsOrderInfo
     * @return
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#getListByParams(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)
     */
    @Override
    public List<OdsOrderInfoDTO> getListByParams(OdsOrderInfoDTO odsOrderInfo) {
        //  Auto-generated method stub
        return odsOrderInfoService.getListByName(odsOrderInfo);
    }

	/** (non-Javadoc)  
	 * <p>Title: postOrder</p>  
	 * <p>Description:过账 </p>  
	 * @param orderNo
	 * @param userName
	 * @return
	 * @throws Exception  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#postOrder(java.lang.String, java.lang.String)  
	 */
	@Override
	public String postOrder(String orderNo, String userName) throws Exception {
	    logger.debug("Entering postOrder, orderN: " + orderNo + ", userName: " + userName);
		return odsOrderInfoService.postOrder(orderNo, userName);
	}

    /** (non-Javadoc)  
     * <p>Title: getOrderNo</p>  
     * <p>Description:获取单号 </p>  
     * @param msg
     * @return  
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#getOrderNo(java.lang.String)  
     */
    @Override
    public String getOrderNo(String msg) {
        return odsOrderInfoService.createOrderNo(msg);
    }

    /** (non-Javadoc)  
     * <p>Title: inOutWarehouse</p>  
     * <p>Description:出入库 </p>  
     * @param orderNo
     * @param orderType
     * @return  
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#inOutWarehouse(java.lang.String, java.lang.String)  
     */
    @Override
    public String inOutWarehouse(String orderNo,String orderType) {
		String userName=UserUtil.getCurrentUser().getName();
		return odsOrderInfoService.inOutWarehouse(orderNo, orderType, userName);
    }
    
	/** (non-Javadoc)  
	 * <p>Title: iogpCancel</p>  
	 * <p>Description:取消汇总sjk </p>  
	 * @param odsOrderInfo
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#iogpCancel(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
	 */
	public OrderIgpOutDTO iogpCancel(OdsOrderInfoDTO odsOrderInfo){
		WmsOrderIgpOut out = odsOrderInfoService.iogpCancel(odsOrderInfo);
		OrderIgpOutDTO outDto = new OrderIgpOutDTO();
		BeanUtils.copyProperties(out, outDto);
		return outDto;
	}

	/** (non-Javadoc)  
	 * <p>Title: searchOIGPOrderInfo</p>  
	 * <p>Description:查询 </p>  
	 * @param pager
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#searchOIGPOrderInfo(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
	 */
	@Override
	public Pager<OdsOrderInfoDTO> searchOIGPOrderInfo(
			Pager<OdsOrderInfoDTO> pager, OdsOrderInfoDTO dto) {
		
		return odsOrderInfoService.searchOIGPOrderInfo(pager, dto);
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getExportAmount</p>  
	 * <p>Description:查询导出数量 </p>  
	 * @param odsOrderInfo
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoServiceClient#getExportAmount(com.haier.openplatform.wms.order.dto.OdsOrderInfoDTO)  
	 */
	public Long getExportAmount(OdsOrderInfoDTO odsOrderInfo) {
		return odsOrderInfoService.getExportAmount(odsOrderInfo);
	}
}
