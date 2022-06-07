package com.haier.hevwms.sto.service.impl;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.sto.dao.OdsStoCustScanInfoDAO;
import com.haier.hevwms.sto.service.OdsStoCustScanInfoService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @Title:  OdsStoCustScanInfoServiceImpl.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0
 */
public class OdsStoCustScanInfoServiceImpl implements OdsStoCustScanInfoService {

	/**
	 * @Fields log: 日志处理
	 */
	private static final Logger log = LoggerFactory.getLogger(OdsStoCustScanInfoServiceImpl.class);

	private OdsStoCustScanInfoDAO odsStoCustScanInfoDAO;

	public OdsStoCustScanInfoDAO getOdsStoCustScanInfoDAO() {
		return odsStoCustScanInfoDAO;
	}

	public void setOdsStoCustScanInfoDAO(OdsStoCustScanInfoDAO odsStoCustScanInfoDAO) {
		this.odsStoCustScanInfoDAO = odsStoCustScanInfoDAO;
	}

	@Override
	public Pager<OdsStoCustScanInfoDTO> searchOdsStoCustScanInfoByPage(Pager<OdsStoCustScanInfoDTO> pager, OdsStoCustScanInfoDTO dto) {
		List<OdsStoCustScanInfoDTO> result = odsStoCustScanInfoDAO.searchOdsStoCustScanInfoByPage(pager, dto);
		Long size = odsStoCustScanInfoDAO.searchOdsStoCustScanInfoCount(dto);
		return Pager.cloneFromPager(pager, size, result);
	}

	@Override
	public Long getExportAmount(OdsStoCustScanInfoDTO dto) {
		return odsStoCustScanInfoDAO.searchOdsStoCustScanInfoCount(dto);
	}

	@Override
	public List<OdsStoCustScanInfoDTO> getOdsStoCustScanInfos(OdsStoCustScanInfoDTO dto) {
		return odsStoCustScanInfoDAO.getListByParam(dto);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#getListByParams(com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO)
	 */
	@Override
	public List<OdsStoCustScanInfoDTO> getListByParams(OdsStoCustScanInfoDTO odsStoCustScanInfoDTO) {
		return odsStoCustScanInfoDAO.getListByParam(odsStoCustScanInfoDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#scanCustomer(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO)
	 */
	@Override
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara) {
		log.debug("Scan Customer start--order no:"+inpara.getOrno()+", barcode:"+inpara.getBarcode());
		OrderUploadOutDTO result = new OrderUploadOutDTO();
		if ("1".equals(inpara.getOrdertype())){
			odsStoCustScanInfoDAO.orderScanIn(inpara, result);
		} else if ("2".equals(inpara.getOrdertype())){
			odsStoCustScanInfoDAO.orderScanOut(inpara, result);
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.customer.service.OdsCustomerScanInfoService#orderDelete(com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn)
	 */
	@Override
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		odsStoCustScanInfoDAO.deleteScanInfoByBarcode(in, out);
		if("0".equals(out.getStatus())){
			out.setStatus("S");
		} else		{
			out.setStatus("F");
		}
		return out;
	}
	
}
