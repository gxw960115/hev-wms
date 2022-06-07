package com.haier.hevwms.sto.service;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;

import java.util.List;

/**
 * @Package: com.haier.hevwms.sto.service
 * @Description: 用一句话描述该文件做什么
 * @Author: ZhangLL
 * @Date: 2018/12/18
 * @Version: V1.0
 */
public interface OdsStoCustScanInfoService {
	Pager<OdsStoCustScanInfoDTO> searchOdsStoCustScanInfoByPage(Pager<OdsStoCustScanInfoDTO> pager, OdsStoCustScanInfoDTO dto);
	Long getExportAmount(OdsStoCustScanInfoDTO dto);
	List<OdsStoCustScanInfoDTO> getOdsStoCustScanInfos(OdsStoCustScanInfoDTO dto);

	/**
	 * @Title: getListByParams
	 * @Description: 查询手持详细列表信息
	 * @author: ZhangLL
	 * @param odsCustomerScanInfo
	 * @return List<OdsStoCustScanInfoDTO>
	 * @throws
	 */
	public List<OdsStoCustScanInfoDTO> getListByParams(OdsStoCustScanInfoDTO odsStoCustScanInfoDTO);

	/**
	 * @Title: orderScan
	 * @Description: 用户sto订单信息扫描
	 * @author: ZhangLL
	 * @param inpara
	 * @return OrderUploadOutDTO
	 * @throws
	 */
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara);

	/**
	 * @Title: orderDelete
	 * @Description: 删除扫描信息
	 * @author: ZhangLL
	 * @param in
	 * @return WmsOrderDeleteOut
	 * @throws
	 */
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in);

}
