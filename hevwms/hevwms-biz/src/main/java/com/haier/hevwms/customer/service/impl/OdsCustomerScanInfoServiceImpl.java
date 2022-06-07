package com.haier.hevwms.customer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.customer.dao.OdsCustomerScanInfoDAO;
import com.haier.hevwms.customer.service.OdsCustomerScanInfoService;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**  
 * @Title:  OdsCustomerScanInfoServiceImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 上午11:12:11   
 * @version V1.0 
 */  
public class OdsCustomerScanInfoServiceImpl implements OdsCustomerScanInfoService{
	
	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsCustomerScanInfoServiceImpl.class);
	
	private OdsCustomerScanInfoDAO odsCustomerScanInfoDAO;

	public OdsCustomerScanInfoDAO getOdsCustomerScanInfoDAO() {
		return odsCustomerScanInfoDAO;
	}

	public void setOdsCustomerScanInfoDAO(OdsCustomerScanInfoDAO odsCustomerScanInfoDAO) {
		this.odsCustomerScanInfoDAO = odsCustomerScanInfoDAO;
	}
	
	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#searchOdsCustomerScanInfos(long, long, com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO)
	 */
	@Override
	public Pager<OdsCustomerScanInfoDTO> searchOdsCustomerScanInfos(Pager<OdsCustomerScanInfoDTO> pager,OdsCustomerScanInfoDTO odsCustomerScanInfoDTO) {
		List<OdsCustomerScanInfoDTO> dtoList = odsCustomerScanInfoDAO.searchOdsCustomerScanInfos(pager, odsCustomerScanInfoDTO);
		long size = odsCustomerScanInfoDAO.searchOdsCustomerScanInfosCount(odsCustomerScanInfoDTO);
		return Pager.cloneFromPager(pager, size, dtoList);
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.customer.service.OdsCustomerScanInfoServiceClient#searchOdsCustomerScanInfosCount(com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO)
	 */
	@Override
	public Long searchOdsCustomerScanInfosCount(OdsCustomerScanInfoDTO odsCustomerScanInfoDTO) {
		return odsCustomerScanInfoDAO.searchOdsCustomerScanInfosCount(odsCustomerScanInfoDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#getListByParams(com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO)
	 */
	@Override
	public List<OdsCustomerScanInfoDTO> getListByParams(OdsCustomerScanInfoDTO odsCustomerScanInfo) {
		return odsCustomerScanInfoDAO.getListByParams(odsCustomerScanInfo);
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#scanCustomer(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO)
	 */
	@Override
	public OrderUploadOutDTO scanCustomer(OrderUploadInDTO inpara) {
		log.debug("Scan Customer start--order no:"+inpara.getOrno()+", barcode:"+inpara.getBarcode());
	    OrderUploadOutDTO result = new OrderUploadOutDTO();
	    odsCustomerScanInfoDAO.scanCustomer(inpara, result);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#orderDelete(com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn)
	 */
	@Override
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		odsCustomerScanInfoDAO.deleteScanInfoByBarcode(in, out);
		if("0".equals(out.getStatus())){
			out.setStatus("S");
		} else		{
			out.setStatus("F");
		}
		return out;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#orderOgp(com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn)
	 */
	@Override
	public WmsOrderIgpOut orderOgp(WmsOrderIgpIn in) {
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		odsCustomerScanInfoDAO.orderOgp(in, out);
		return out;
	}
}
