package com.haier.openplatform.wms.order.impl;

import java.util.List;

import com.haier.hevwms.order.service.StgInboundDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.openplatform.wms.order.service.StgInboundDownServiceClient;

/**  
 * @ClassName: StgInboundDownServiceClientImpl  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author sunyanfei
 * @date 2015-11-25
 */ 
public class StgInboundDownServiceClientImpl implements
		StgInboundDownServiceClient {
	/**  
	 * @Fields field:field:{}(stgInboundDownService)  
	 */  
	private StgInboundDownService stgInboundDownService;

	/** (non-Javadoc)  
	 * <p>Title: searchStgInboundDowns</p>  
	 * <p>Description:查询 </p>  
	 * @param pager
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgInboundDownServiceClient#searchStgInboundDowns(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.StgInboundDownDTO)  
	 */
	@Override
	public Pager<StgInboundDownDTO> searchStgInboundDowns(
			Pager<StgInboundDownDTO> pager, StgInboundDownDTO dto) {
		return stgInboundDownService.searchStgInboundDowns(pager, dto);
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getStgInboundDownByParam</p>  
	 * <p>Description:查询 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgInboundDownServiceClient#getStgInboundDownByParam(com.haier.openplatform.wms.order.dto.StgInboundDownDTO)  
	 */
	@Override
	public List<StgInboundDownDTO> getStgInboundDownByParam(
			StgInboundDownDTO dto) {
		return stgInboundDownService.getStgInboundDownByParam(dto);
	}
	
	/** (non-Javadoc)  
	 * <p>Title: getExportAmount</p>  
	 * <p>Description:查询数量 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.StgInboundDownServiceClient#getExportAmount(com.haier.openplatform.wms.order.dto.StgInboundDownDTO)  
	 */
	@Override
	public Long getExportAmount(StgInboundDownDTO dto) {
		return stgInboundDownService.getExportAmount(dto);
	}

	/**  
	 * @Title: getStgInboundDownService  
	 * @Description: (get)  
	 * @return
	 * @return StgInboundDownService 
	 * @throws  
	 */  
	public StgInboundDownService getStgInboundDownService() {
		return stgInboundDownService;
	}

	/**  
	 * @Title: setStgInboundDownService  
	 * @Description: (set)  
	 * @param stgInboundDownService
	 * @return void 
	 * @throws  
	 */  
	public void setStgInboundDownService(
			StgInboundDownService stgInboundDownService) {
		this.stgInboundDownService = stgInboundDownService;
	}
}
