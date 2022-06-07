package com.haier.hevwms.remoting.rf.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/** * @author  作者 :sunyanfei 
 * @date 创建时间：2016-3-25 上午11:10:51
 * @version 1.0
 * @parameter
 * @since
 * @return 
 */
public interface RfScanWhenPDService {
    public OrderIgpOutDTO orderCkeck(OrderCheckInDTO in);
    
    public OrderIgpOutDTO orderDownLoad(OrderCheckInDTO in);
    
    public OrderUploadOutDTO orderScan(OrderUploadInDTO in);
    
    public OrderUploadOutDTO orderDelete(OrderUploadInDTO in);
    
    public WmsOrderDelListOutDTO barcodeDetail(OrderUploadInDTO in);
    
    public OrderUploadOutDTO orderIogp(OrderUploadInDTO in);
    
    public Map<String , String> offlineScan(List<OrderUploadInDTO> paramsIn);
}
