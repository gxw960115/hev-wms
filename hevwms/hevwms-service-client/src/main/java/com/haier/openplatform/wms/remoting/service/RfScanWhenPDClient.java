package com.haier.openplatform.wms.remoting.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/** * @author  作者 :sunyanfei 
 * @date 创建时间：2016-3-25 上午11:03:01
 * @version 1.0
 * @parameter
 * @since
 * @return 
 */
public interface RfScanWhenPDClient {
    /** 
    * @Title: orderCheck 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param in
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return OrderIgpOutDTO    返回类型 
    * @throws 
    */
    public OrderIgpOutDTO orderCheck(OrderCheckInDTO in);
    
    /** 
    * @Title: orderDownLoad 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param in
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return OrderIgpOutDTO    返回类型 
    * @throws 
    */
    public OrderIgpOutDTO orderDownLoad(OrderCheckInDTO in);
    
    /** 
    * @Title: orderScan 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param in
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return OrderUploadOutDTO    返回类型 
    * @throws 
    */
    public OrderUploadOutDTO orderScan(OrderUploadInDTO in);
    
    /** 
    * @Title: offlineScan 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param paramsIn
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Map<String,String>    返回类型 
    * @throws 
    */
    public Map<String, String> offlineScan(List<OrderUploadInDTO> paramsIn);
    
    /** 
    * @Title: orderDelete 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param in
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return OrderUploadOutDTO    返回类型 
    * @throws 
    */
    public OrderUploadOutDTO orderDelete(OrderUploadInDTO in);
    
    /** 
    * @Title: barcodeDetail 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param in
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return WmsOrderDelListOutDTO    返回类型 
    * @throws 
    */
    public WmsOrderDelListOutDTO barcodeDetail(OrderUploadInDTO in);
    
    /** 
    * @Title: orderIogp 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param in
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return OrderUploadOutDTO    返回类型 
    * @throws 
    */
    public OrderUploadOutDTO orderIogp(OrderUploadInDTO in);
}
