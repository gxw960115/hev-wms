package com.haier.openplatform.wms.po.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import com.haier.hevwms.interfacePc.webinterface.PostDNFromIndiaWMSToGVSRF;
import com.haier.hevwms.interfacePc.webinterface.PostSTODNReceiveToGVSRF;
import com.haier.hevwms.po.service.OdsOrderInfoDtlService;
import com.haier.openplatform.showcase.util.Paging;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.openplatform.wms.po.service.OdsOrderInfoDtlServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderDirectDispatchOutDTO;

/**
 * @ClassName: OdsOrderInfoDtlServiceClientImpl
 * @Description: Po detail
 *
 */
public class OdsOrderInfoDtlServiceClientImpl implements OdsOrderInfoDtlServiceClient{
    /**  
     * @Fields field:field:{todo}(odsOrderInfoDtlService)  
     */  
    private OdsOrderInfoDtlService odsOrderInfoDtlService;
    
    /**  
     * @Title: getOdsOrderInfoDtlService  
     * @Description: get
     * @return
     * @return OdsOrderInfoDtlService 
     * @throws  
     */  
    public OdsOrderInfoDtlService getOdsOrderInfoDtlService() {
        return odsOrderInfoDtlService;
    }

    /**  
     * @Title: setOdsOrderInfoDtlService  
     * @Description: set
     * @param odsOrderInfoDtlService
     * @return void 
     * @throws  
     */  
    public void setOdsOrderInfoDtlService(
            OdsOrderInfoDtlService odsOrderInfoDtlService) {
        this.odsOrderInfoDtlService = odsOrderInfoDtlService;
    }

    /** (non-Javadoc)  
     * <p>Title: searchOdsOrderDtls</p>  
     * <p>Description:分页查询 </p>  
     * @param page
     * @param rows
     * @param odsOrderInfoDtlDTO
     * @return  
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoDtlServiceClient#searchOdsOrderDtls(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.order.dto.OdsOrderInfoDtlDTO)  
     */
    @Override
	public Pager<OdsOrderInfoDtlDTO> searchOdsOrderDtls(Long page, Long rows,
			OdsOrderInfoDtlDTO odsOrderInfoDtlDTO) {
		Pager<OdsOrderInfoDtlDTO> pager2 = new Pager<OdsOrderInfoDtlDTO>();
		pager2.setCurrentPage(page);
		pager2.setPageSize(rows);
		pager2 = odsOrderInfoDtlService.searchOdsOrderInfoDtls(pager2, odsOrderInfoDtlDTO);
		return pager2;
	}
    
    /** (non-Javadoc)  
     * <p>Title: getExportAmount</p>  
     * <p>Description:查询导出数量 </p>  
     * @param odsOrderInfoDtl
     * @return  
     * @see com.haier.openplatform.wms.order.service.OdsOrderInfoDtlServiceClient#getExportAmount(com.haier.openplatform.wms.order.dto.OdsOrderInfoDtlDTO)  
     */
    @Override
    public Long getExportAmount(OdsOrderInfoDtlDTO odsOrderInfoDtl) {
    	return odsOrderInfoDtlService.getExportAmount(odsOrderInfoDtl);
    }

	/** (non-Javadoc)  
	 * <p>Title: serchOdsOrderDtlsBy</p>  
	 * <p>Description:根据单号查询 </p>  
	 * @param no
	 * @param materialNo
	 * @param createDateStart
	 * @param createDateEnd
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoDtlServiceClient#serchOdsOrderDtlsBy(java.lang.String, java.lang.String, java.util.Date, java.util.Date)  
	 */
	@Override
	public Paging<OdsOrderInfoDtlDTO> serchOdsOrderDtlsBy(String no,
			String materialNo, Date createDateStart, Date createDateEnd) {
		return null;
	}

	/** (non-Javadoc)  
	 * <p>Title: getOdsOrderInfoDtls</p>  
	 * <p>Description:查询明细 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoDtlServiceClient#getOdsOrderInfoDtls(com.haier.openplatform.wms.order.dto.OdsOrderInfoDtlDTO)  
	 */
	@Override
	public List<OdsOrderInfoDtlDTO> getOdsOrderInfoDtls(OdsOrderInfoDtlDTO dto) {
		return odsOrderInfoDtlService.getOdsOrderInfoDtls(dto);
	}


	/* (非 Javadoc)
	 * <p>Title: directDispatch</p>
	 * <p>Description: </p>
	 * @param stodnNo
	 * @param dnNo
	 * @param userName
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @see com.haier.openplatform.wms.order.service.OdsOrderInfoDtlServiceClient#directDispatch(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public OrderDirectDispatchOutDTO directDispatch(String stodnNo, String dnNo, String userName)
			throws IllegalAccessException, InvocationTargetException {

		String stoPostStatus = "";
		String dnPostStatus = "";
		//汇总
		OrderDirectDispatchOutDTO out = new OrderDirectDispatchOutDTO();
		out = odsOrderInfoDtlService.directDispatchCollect(stodnNo, dnNo, userName);

		if ("0".equals(out.getStatus())) {
			//过账
			try {
				PostSTODNReceiveToGVSRF stoDn = new PostSTODNReceiveToGVSRF(out.getIgpOrderNo(), userName);
				stoPostStatus = stoDn.exchangeWithSap();
			}catch (Exception e) {
				e.printStackTrace();
				out.setStatus("F");
				out.setMsg("stodn posting error, please contact with administrator.");
			}

			if ("S".equals(stoPostStatus)) {
				try {
					PostDNFromIndiaWMSToGVSRF dn = new PostDNFromIndiaWMSToGVSRF(out.getOgpOrderNo(), userName);
					dnPostStatus = dn.exchangeWithSap();
				} catch(Exception e){
					e.printStackTrace();
					out.setStatus("F");
					out.setMsg("dn posting error, please contact with administrator.");
				}
				if ("S".equals(dnPostStatus)) {
					out.setStatus("S");
					out.setMsg("SUCCESS");
				} else {
					out.setStatus("F");
					out.setMsg(dnPostStatus);
				}
			} else {
				out.setStatus("F");
				out.setMsg(stoPostStatus);
			}
		}
		return out;
	}
}
