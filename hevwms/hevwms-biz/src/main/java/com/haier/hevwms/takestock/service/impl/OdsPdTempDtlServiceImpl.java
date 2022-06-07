package com.haier.hevwms.takestock.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdTempDtlDTO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.takestock.dao.OdsPdTempDAO;
import com.haier.hevwms.takestock.dao.OdsPdTempDtlDAO;
import com.haier.hevwms.takestock.service.OdsPdTempDtlService;
import com.haier.hevwms.util.ToJsonUtil;

import io.terminus.pampas.common.UserUtil;
import net.sf.json.JSONObject;

public class OdsPdTempDtlServiceImpl implements OdsPdTempDtlService {

	private Logger log=Logger.getLogger(OdsPdTempDtlServiceImpl.class);
	private OdsPdTempDtlDAO odsPdTempDtlDao;
	
	private OdsPdTempDAO odsPdTempDAO;
	
	private OdsInventoryInfoDtlDAO inventoryInfoDtlDAO;
	
	public void setOdsPdTempDtlDao(OdsPdTempDtlDAO odsPdTempDtlDao) {
		this.odsPdTempDtlDao = odsPdTempDtlDao;
	}
	
	public void setOdsPdTempDAO(OdsPdTempDAO odsPdTempDAO) {
		this.odsPdTempDAO = odsPdTempDAO;
	}

	public void setInventoryInfoDtlDAO(OdsInventoryInfoDtlDAO inventoryInfoDtlDAO) {
		this.inventoryInfoDtlDAO = inventoryInfoDtlDAO;
	}

	@Override
	public Long getScanQty(String orderNo) {
		return odsPdTempDtlDao.getScanQty(orderNo);
	}

	@Override
	public String barcodeCheck(String orderNo, String barcode) {
		OdsPdTempDtlDTO dto=new OdsPdTempDtlDTO();
		dto.setOrderNo(orderNo);
		dto.setBarcode(barcode);
		List<OdsPdTempDtlDTO> list=odsPdTempDtlDao.getListByparam(dto);
		if (null == list || list.size()==0){
			return "S";
		}else if (list.size()>1) {
			return "this barcode have existed more than one,please check at Stock Audit Temp Detail.";
		}
		else {
			dto=list.get(0);
			String status=dto.getStatus();
			if ("0".equals(status)) {
				return "this barcode has been scanned.";
			} else if ("1".equals(status)) {
				return "this barcode has been processed";
			} else if ("2".equals(status)) {
				return "this barcode is locked,you can unlock at Stock Audit Temp Detail.";
			} else {
				return "operate failed pls contact the admin.";
			}
		}
	}

	@Override
	public Map<String , String> add(OdsPdTempDtlDTO dto) {
		Map<String , String> result=new HashMap<String, String>();
		String MaterialNo=dto.getBarcode().substring(0,10);
		dto.setMaterialNo(MaterialNo.substring(0,9));
		result.put("matno", MaterialNo.substring(0,9));
		String cusModel=odsPdTempDtlDao.cusModel(MaterialNo);
		result.put("matdesc", cusModel);
		int num=odsPdTempDtlDao.materialExisted(MaterialNo);
		if (num<1) {
			result.put("status", "Material not existe");
		}
		else {
			OdsPdTempDTO odsPdTempDTO=new OdsPdTempDTO();
			odsPdTempDTO.setOrderNo(dto.getOrderNo());
			List<OdsPdTempDTO> pdTemps=odsPdTempDAO.searchOdsPdTempDTOs(odsPdTempDTO, 0L, 1L);
			if(pdTemps!= null && pdTemps.size()>0){
				odsPdTempDTO=pdTemps.get(0);
				dto.setPlant(odsPdTempDTO.getPlant());
				dto.setLocation(odsPdTempDTO.getLocation());
			}
			if (null == dto.getQty()|| dto.getQty().longValue()==0){
				dto.setQty(1L);
			}
			int succNum=odsPdTempDtlDao.add(dto);
			if (succNum <1 ){
				result.put("status", "Save Barcode Failed,pls try again");
			}
			else {
				result.put("status", "S");
			}
		}
		return result;
	}

	@Override
	public String orderDelete(OdsPdTempDtlDTO dto) {
		OdsPdTempDtlDTO condition=new OdsPdTempDtlDTO();
		condition.setBarcode(dto.getBarcode());
		condition.setOrderNo(dto.getOrderNo());
		List<OdsPdTempDtlDTO> list =odsPdTempDtlDao.getListByparam(condition);
		if (list ==null || list.size()<1) {
			return "Barcode not existed,barcode:"+dto.getBarcode();
		} else {
			condition=list.get(0);
			String status=condition.getStatus();
			if ("1".equals(status)){
				return "Barcode has been process,barcode:"+dto.getBarcode();
			}else if("2".equals(status)) {
				return "Barcode is locked,can't delete,barcode"+dto.getBarcode();
			}else {
				int num =odsPdTempDtlDao.deleteById(condition.getRowId());
				if (num>0 ){
					return "S";
				}else {
					return "Delete Failed,barcode"+dto.getBarcode();
				}
			}
		}
	}

	@Override
	public List<OdsPdTempDtlDTO> orderDetail(OdsPdTempDtlDTO dto) {
		return odsPdTempDtlDao.getListByparam(dto);
	}

	@Override
	public JSONObject searchOdsPdTemps(OdsPdTempDtlDTO pdTempDtlDTO, Long rows,
			Long page) {
		long firstResult=rows*(page-1);
		List<OdsPdTempDtlDTO> list=odsPdTempDtlDao.searchOdsPdTempDtlDTOs(pdTempDtlDTO, firstResult, rows);
		long size=odsPdTempDtlDao.searchOdsPdTempDtlDTOsCount(pdTempDtlDTO);
		return ToJsonUtil.getJsonObject(list, size);
	}

	@Override
	public String moveBarcode(Long rowId) {
		OdsPdTempDtlDTO dto=odsPdTempDtlDao.getById(rowId);
		if ("1".equals(dto.getStatus())) {
			return "<br/>&nbsp;&nbsp;&nbsp;Barcode:"+dto.getBarcode()+",has been processed by:"+
					dto.getModifyBy();
		} else if ( "2".equals(dto.getStatus())){
			return "<br/>&nbsp;&nbsp;&nbsp;Barcode:"+dto.getBarcode()+",has been locked by:"+
					dto.getModifyBy();
		} else if ( "3".equals(dto.getStatus())) {
			return "<br/>&nbsp;&nbsp;&nbsp;Barcode:"+dto.getBarcode()+",has been deleted by:"+
					dto.getModifyBy();
		}
		OdsInventoryInfoDtl dtl=new OdsInventoryInfoDtl();
		dtl.setBarcode(dto.getBarcode());
		List list=inventoryInfoDtlDAO.getOdsInventoryInfoDtlByParam(dtl);
		if (list!=null && list.size()>0){
			OdsInventoryInfoDtl inventoryInfoDtl=(OdsInventoryInfoDtl)list.get(0);
			return "<br/>&nbsp;&nbsp;&nbsp;Barcode:"+dto.getBarcode()+",has existed in inventory.plant:"
					+inventoryInfoDtl.getPlant()+",Location:"+inventoryInfoDtl.getLocation();
		}
		String unit=odsPdTempDtlDao.getUnit(dto.getMaterialNo());
		dtl.setPlant(dto.getPlant());
		dtl.setLocation(dto.getLocation());
		dtl.setMaterialNo(dto.getMaterialNo());
		dtl.setQty(dto.getQty());
		dtl.setSapOrderNo(dto.getOrderNo());
		dtl.setUnit(unit);
		try {
			dtl.setCreateBy(UserUtil.getCurrentUser().getName());
			dto.setModifyBy(UserUtil.getCurrentUser().getName());
		} catch (Exception e) {
			log.debug("get login user error:"+e.toString());
		}
		inventoryInfoDtlDAO.save(dtl);
		dto.setStatus("1");
		int num=odsPdTempDtlDao.updateOrderStatus(dto);
		if (num >0){
			return "S";
		}else {
			return "Failed.";
		}
	}

	@Override
	public String updateBarcodeStatus(Long id, String status) {
		OdsPdTempDtlDTO dto=odsPdTempDtlDao.getById(id);
		dto.setStatus(status);
		try {
			dto.setModifyBy(UserUtil.getCurrentUser().getName());
		} catch (Exception e) {
			log.debug("get login user error:"+e.toString());
		}
		int num=odsPdTempDtlDao.updateOrderStatus(dto);
		if (num >0){
			return "S";
		}else {
			return "Failed";
		}
	}

}
