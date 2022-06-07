package com.haier.hevwms.order.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.openplatform.wms.po.dto.OdsOrderInfoDtlDTO;
import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.order.dao.OdsOrderInfoDAO;
import com.haier.hevwms.order.dao.OdsTransferInventoryDAO;
import com.haier.hevwms.order.service.OdsTransferInventoryService;
import com.haier.hevwms.po.dao.OdsOrderInfoDtlDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;

/**
 * 311移库
 * @author Yan Fengdan
 * @version 2017-11-10 下午2:35:05
 */
public class OdsTransferInventoryServiceImpl implements OdsTransferInventoryService {
    Logger logger = Logger.getLogger(OdsTransferInventoryServiceImpl.class);
	private OdsTransferInventoryDAO odsTransferInventoryDAO;//311移库单
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	private OdsOrderInfoDtlDAO odsOrderInfoDtlDAO;
	private OdsOrderInfoDAO odsOrderInfoDAO;
	private OdsBarcodeHistoryDAO odsBarcodeHistoryDAO;
	
	//获取移库单号 length=10 ，从1开始自增 ，左侧 零 补位
    @Override
    public String selectTransferInventoryOrderNo() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        String sequence=odsTransferInventoryDAO.selectTransferInventoryOrderNo(dateString);
        sequence=sequence.substring(sequence.length()-4,sequence.length());//截取返回的sequence值的后三位
        return dateString+sequence;//当前天+sequence eg.1711100001
    }
    
	@Override
	public String createOdsTransInventoryInfo(OdsTransferInventoryDTO odsTransferInventoryDTO) {
		odsTransferInventoryDAO.save(odsTransferInventoryDTO);
		return "SUCCESS";
	}
	
	public Pager<OdsTransferInventoryDTO> searchTransInventoryInfos(Pager<OdsTransferInventoryDTO> pager,
			OdsTransferInventoryDTO odsTransferInventoryDTO) {
		List<OdsTransferInventoryDTO> odsTransDTO = odsTransferInventoryDAO.searchTransInventoryInfos(pager,
				odsTransferInventoryDTO);
		long size = odsTransferInventoryDAO.searchOdsTransInfosCount(odsTransferInventoryDTO);
		return Pager.cloneFromPager(pager, size, odsTransDTO);
	}

	@Override
	public ExecuteResult<OdsTransferInventoryDTO> deleteOrder(
			OdsTransferInventoryDTO odsTransferInventoryDTO) {
		ExecuteResult<OdsTransferInventoryDTO> executeResult = new ExecuteResult<OdsTransferInventoryDTO>();
		
		List<OdsOrderInfoDtlDTO> orderDtl = odsOrderInfoDtlDAO.searchOrderDtlBySapOrderNo(odsTransferInventoryDTO.getTransOrderNo());
		for (OdsOrderInfoDtlDTO tempDtl:orderDtl) {
			//查找出库库位是否存在物理库位
            Map<String, String> map = new HashMap<String, String>();
            map.put("warehouse", tempDtl.getPlant());
            map.put("location", tempDtl.getLocation());
            
            String invenPlant = map.get("warehouse");
            String invenLocation = map.get("location");
            
            OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
            odsInventoryInfoDtl.setPlant(invenPlant);
            odsInventoryInfoDtl.setLocation(invenLocation);
            odsInventoryInfoDtl.setBarcode(tempDtl.getBarcode());
            odsInventoryInfoDtl.setModifyBy(UserUtil.getCurrentUser().getName());
            
            //更新ods_inventory_info_dtl中的use_qty数量
            odsInventoryInfoDtlDAO.updateUseQtyBySapOrderNo(odsInventoryInfoDtl,tempDtl.getQty());
		}
		
		odsTransferInventoryDTO.setModifyDate(new Date());
		odsTransferInventoryDTO.setModifyBy(UserUtil.getCurrentUser().getName());
		odsTransferInventoryDTO.setItemDel("1");//0无效 1删除
		odsTransferInventoryDAO.updateTransOrderStatus(odsTransferInventoryDTO);//对 移库单 进行逻辑删除
		
		//从ods_order_info_dtl中将扫描的信息删除
		odsOrderInfoDtlDAO.deleteOrderDtlBySapOrderNo(odsTransferInventoryDTO.getTransOrderNo());
		
		//从ods_order_info中将已经汇总的信息删除
		odsOrderInfoDAO.deleteOrderBySapOrderNo(odsTransferInventoryDTO.getTransOrderNo());
		
		//从ods_barcode_history中将记录的信息删除
		odsBarcodeHistoryDAO.deleteBacodeInfoBySapOrderNo(odsTransferInventoryDTO.getTransOrderNo());
		
		executeResult.setSuccessMessage("success");
		executeResult.setResult(odsTransferInventoryDTO);
		
		return executeResult;
	}

	
	@Override
	public List<OdsTransferInventoryDTO> getList(OdsTransferInventoryDTO odsTransferInventoryDTO) {
		return odsTransferInventoryDAO.getList(odsTransferInventoryDTO);
	}
	
	@Override
	public Long getExportAmount(OdsTransferInventoryDTO dto) {
		return odsTransferInventoryDAO.searchOdsTransInfosCount(dto);
	}
	
	public OdsTransferInventoryDAO getOdsTransferInventoryDAO() {
		return odsTransferInventoryDAO;
	}

	public void setOdsTransferInventoryDAO(
			OdsTransferInventoryDAO odsTransferInventoryDAO) {
		this.odsTransferInventoryDAO = odsTransferInventoryDAO;
	}

	public OdsInventoryInfoDtlDAO getOdsInventoryInfoDtlDAO() {
		return odsInventoryInfoDtlDAO;
	}

	public void setOdsInventoryInfoDtlDAO(
			OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO) {
		this.odsInventoryInfoDtlDAO = odsInventoryInfoDtlDAO;
	}

	public OdsOrderInfoDtlDAO getOdsOrderInfoDtlDAO() {
		return odsOrderInfoDtlDAO;
	}

	public void setOdsOrderInfoDtlDAO(OdsOrderInfoDtlDAO odsOrderInfoDtlDAO) {
		this.odsOrderInfoDtlDAO = odsOrderInfoDtlDAO;
	}

	public OdsOrderInfoDAO getOdsOrderInfoDAO() {
		return odsOrderInfoDAO;
	}

	public void setOdsOrderInfoDAO(OdsOrderInfoDAO odsOrderInfoDAO) {
		this.odsOrderInfoDAO = odsOrderInfoDAO;
	}

	public OdsBarcodeHistoryDAO getOdsBarcodeHistoryDAO() {
		return odsBarcodeHistoryDAO;
	}

	public void setOdsBarcodeHistoryDAO(OdsBarcodeHistoryDAO odsBarcodeHistoryDAO) {
		this.odsBarcodeHistoryDAO = odsBarcodeHistoryDAO;
	}
}
