package com.haier.openplatform.bank.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.basic.domain.MdDictionary;
import com.haier.hevwms.order.domain.OdsOrderInfoDtl;

public interface BarcodeValidationDao extends CommonDAO<OdsOrderInfoDtl,Long>{
	public List<OdsOrderInfoDtl> findBillDtlByBarcode(@Param("barcode")String barcode);
	
	public List<OdsOrderInfoDtl> findBillDtlByBarcodes(@Param("barcodes")List barcodes);
    
}
