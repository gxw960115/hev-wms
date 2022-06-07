package com.haier.hevwms.order.service;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;

public interface OdsTransferInventoryService {
    
    //获取系统中生成的  stocktakingOrderNo
    public String selectTransferInventoryOrderNo();
    
    public String createOdsTransInventoryInfo(OdsTransferInventoryDTO odsTransferInventoryDTO);
    
    public Pager<OdsTransferInventoryDTO> searchTransInventoryInfos(Pager<OdsTransferInventoryDTO> pager,
    		OdsTransferInventoryDTO odsTransferInventoryDTO);
    
    public ExecuteResult<OdsTransferInventoryDTO> deleteOrder(OdsTransferInventoryDTO odsTransferInventoryDTO);


	public List<OdsTransferInventoryDTO> getList(OdsTransferInventoryDTO odsTransferInventoryDTO);

	public Long getExportAmount(OdsTransferInventoryDTO dto);

}
