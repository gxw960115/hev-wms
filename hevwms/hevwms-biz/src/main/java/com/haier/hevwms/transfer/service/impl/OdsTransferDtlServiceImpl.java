package com.haier.hevwms.transfer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.transfer.dao.OdsTransferDtlDAO;
import com.haier.hevwms.transfer.service.OdsTransferDtlService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;

/**  
 * @Title:  OdsTransferDtlServiceImpl.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:17:33   
 * @version V1.0 
 */  
public class OdsTransferDtlServiceImpl implements OdsTransferDtlService {

	/**  
	* @Fields field:field:{todo}(日志)  
	*/
	private static final Logger log = LoggerFactory.getLogger(OdsTransferDtlServiceImpl.class);
	
	private OdsTransferDtlDAO odsTransferDtlDAO;

	public OdsTransferDtlDAO getOdsTransferDtlDAO() {
		return odsTransferDtlDAO;
	}

	public void setOdsTransferDtlDAO(OdsTransferDtlDAO odsTransferDtlDAO) {
		this.odsTransferDtlDAO = odsTransferDtlDAO;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferDtlService#searchTransferDtls(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO)
	 */
	@Override
	public Pager<OdsTransferDtlDTO> searchOdsTransferDtls(Pager<OdsTransferDtlDTO> pager,OdsTransferDtlDTO odsTransferDtlDTO) {
		List<OdsTransferDtlDTO> odsTransDTO = odsTransferDtlDAO.searchOdsTransferDtls(pager, odsTransferDtlDTO);
		long size = odsTransferDtlDAO.searchOdsTransferDtlsCount(odsTransferDtlDTO);
		return Pager.cloneFromPager(pager, size, odsTransDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferDtlService#searchOdsTransferInfosCount(com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO)
	 */
	@Override
	public Long searchOdsTransferDtlsCount(OdsTransferDtlDTO odsTransferDtlDTO) {
		return odsTransferDtlDAO.searchOdsTransferDtlsCount(odsTransferDtlDTO);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferDtlService#getListByParams(com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO)
	 */
	@Override
	public List<OdsTransferDtlDTO> getListByParams(OdsTransferDtlDTO info) {
		return odsTransferDtlDAO.getListByParams(info);
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferDtlService#orderOgp(com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn)
	 */
	@Override
	public WmsOrderIgpOut orderOgp(WmsOrderIgpIn in) {
		WmsOrderIgpOut out = new WmsOrderIgpOut();
		odsTransferDtlDAO.orderOgp(in, out);
		return out;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferDtlService#scanTransfer(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO)
	 */
	@Override
	public OrderUploadOutDTO scanTransfer(OrderUploadInDTO inpara) {
		log.debug("Scan Customer start--order no:"+inpara.getOrno()+", barcode:"+inpara.getBarcode());
	    OrderUploadOutDTO result = new OrderUploadOutDTO();
	    odsTransferDtlDAO.scanTransfer(inpara, result);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.haier.hevwms.transfer.service.OdsTransferDtlService#orderDelete(com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn)
	 */
	@Override
	public OrderDeleteOutDTO orderDelete(WmsOrderDeleteIn in) {
		OrderDeleteOutDTO out = new OrderDeleteOutDTO();
		odsTransferDtlDAO.deleteScanInfoByBarcode(in, out);
		if("0".equals(out.getStatus())){
			out.setStatus("S");
		} else		{
			out.setStatus("F");
		}
		return out;
	}
	/* (non-Javadoc)
	 * @see com.haier.hevwms.scrap.service.ScrapPDAService#scanStatus(java.lang.String)
	 */
	@Override
	public long scanStatus(String orno) {
		return odsTransferDtlDAO.scanStatus(orno);
	}
	
	/* (non-Javadoc)
	 * @see com.haier.hevwms.scrap.service.ScrapPDAService#updateSapInfo(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO)
	 */
	@Override
	public void updateSapInfo(OrderIgpInDTO inpara) {
		odsTransferDtlDAO.updateSapInfo(inpara);
	}
}
