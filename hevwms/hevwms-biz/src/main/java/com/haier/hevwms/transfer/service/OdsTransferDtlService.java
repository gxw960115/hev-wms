package com.haier.hevwms.transfer.service;

import java.util.List;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;

/**  
 * @Title:  OdsTransferDtlService.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:14:23   
 * @version V1.0 
 */  
public interface OdsTransferDtlService {

	/**  
	* @Title: searchTransferDtls  
	* @Description: TODO(查询列表信息)  
	* @author zhangll
	* @param pager
	* @param odsTransferDtlDTO
	* @return Pager<OdsTransferDtlDTO>
	* @throws  
	*/
	public Pager<OdsTransferDtlDTO> searchOdsTransferDtls(Pager<OdsTransferDtlDTO> pager, OdsTransferDtlDTO odsTransferDtlDTO);

	/**  
	* @Title: searchOdsTransferDtlsCount  
	* @Description: TODO(统计数量)  
	* @author zhangll
	* @param odsTransferDtlDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsTransferDtlsCount(OdsTransferDtlDTO odsTransferDtlDTO);

	/**  
	* @Title: getListByParams  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param info
	* @return List<OdsCustomerScanInfoDTO>
	* @throws  
	*/
	public List<OdsTransferDtlDTO> getListByParams(OdsTransferDtlDTO info);

	/**  
	* @Title: orderOgp  
	* @Description: 一句话描述这个方法的作用
	* @author: ZhangLL
	* @param in
	* @return WmsOrderIgpOut
	* @throws  
	*/
	public WmsOrderIgpOut orderOgp(WmsOrderIgpIn in);

	/**  
	* @Title: scanTransfer  
	* @Description: 扫描
	* @author: ZhangLL
	* @param inpara
	* @return OrderUploadOutDTO
	* @throws  
	*/
	public OrderUploadOutDTO scanTransfer(OrderUploadInDTO inpara);

	/**  
	* @Title: orderDelete  
	* @Description: 删除订单
	* @author: ZhangLL
	* @param in
	* @return OrderDeleteOutDTO
	* @throws  
	*/
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in);

	/**  
	* @Title: scanStatus  
	* @Description: 检测订单扫描状态
	* @author: ZhangLL
	* @param orno
	* @return long
	* @throws  
	*/
	public long scanStatus(String orno);

	/**  
	* @Title: updateSapInfo  
	* @Description: 更改信息
	* @author: ZhangLL
	* @param inpara void
	* @throws  
	*/
	public void updateSapInfo(OrderIgpInDTO inpara);
}
