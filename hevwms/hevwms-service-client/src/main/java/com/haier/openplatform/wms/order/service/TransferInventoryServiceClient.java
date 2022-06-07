package com.haier.openplatform.wms.order.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**
 * 311移库Client
 * @author Yan Fengdan
 * @version 2017-11-10 下午2:28:28
 */
public interface TransferInventoryServiceClient {
    
    //获取sequence值，11位编码，eg.T1711100001，T1711100002
    @Export
    public String getTransferInventoryOrderNo();
    
    @Export(paramNames={"OdsTransferInventoryDTO","msg"})
    public String addTranferInventoryOrders(OdsTransferInventoryDTO odsTransferInventoryDTO,
            List<OdsTransferInventoryDTO> msg);
    
    //页面加载时  查询所有 库存盘点单 明细
    public Pager<OdsTransferInventoryDTO> searchTransInventoryOrder(long page,long rows,OdsTransferInventoryDTO odsTransferInventoryDTO);
    
    //导出时候的查询
    public List<OdsTransferInventoryDTO> getOdsTransInfo(OdsTransferInventoryDTO odsTransferInventoryDTO);
    
    @Export(paramNames ={"odsTransferInventoryDTO"})
    public String deleteTranferInventoryOrder(OdsTransferInventoryDTO odsTransferInventoryDTO);
    

	public Long getExportAmount(OdsTransferInventoryDTO dto);
   
}
