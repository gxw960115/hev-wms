package com.haier.openplatform.wms.remoting.service.impl;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import com.haier.hevwms.customer.service.OdsCustomerOrderService;
import com.haier.hevwms.customer.service.OdsCustomerScanInfoService;
import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.hevwms.remoting.rf.service.OtcwmsLoginService;
import com.haier.hevwms.remoting.rf.service.OtcwmsLogoutService;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderCheckService;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderConfirmService;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderDeleteService;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderIgpService;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderMoveService;
import com.haier.hevwms.remoting.rf.service.OtcwmsOrderUploadService;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.sto.service.StgStoDownService;
import com.haier.hevwms.takestock.service.OdsPdInfoService;

/**
 * @ClassName: RfWsBase
 * @Description:
 * @author Song Yinglong // Nicholas
 * @date 2015-11-5 下午3:57:33
 * @param
 */
public class RfWsBase {
	@Resource
	protected WebServiceContext context;
	protected OtcwmsLoginService otcwmsLoginService;
	protected OtcwmsLogoutService otcwmsLogoutService;
	protected OtcwmsOrderCheckService otcwmsOrderCheckService;
	protected OtcwmsOrderDeleteService otcwmsOrderDeleteService;
	protected OtcwmsOrderUploadService otcwmsOrderUploadService;
	protected OtcwmsOrderIgpService otcwmsOrderIgpService;
	protected OtcwmsOrderConfirmService otcwmsOrderConfirmService;
	protected OtcwmsOrderMoveService otcwmsOrderMoveService;
	protected RfWsService rfWsService;
	protected StgPoDownService stgPoDownService;
	protected StgStoDownService stgStoDownService;
	protected OdsPdInfoService odsPdInfoService;
	protected OdsCustomerOrderService odsCustomerOrderService;
	protected OdsCustomerScanInfoService odsCustomerScanInfoService;
	
	public OdsPdInfoService getOdsPdInfoService() {
		return odsPdInfoService;
	}

	public void setOdsPdInfoService(OdsPdInfoService odsPdInfoService) {
		this.odsPdInfoService = odsPdInfoService;
	}

	// protected OdsTgPlanService odsTgPlanService;
	public WebServiceContext getContext() {
		return context;
	}

	public void setContext(WebServiceContext context) {
		this.context = context;
	}

	public OtcwmsLoginService getOtcwmsLoginService() {
		return otcwmsLoginService;
	}

	public void setOtcwmsLoginService(OtcwmsLoginService otcwmsLoginService) {
		this.otcwmsLoginService = otcwmsLoginService;
	}

	public OtcwmsLogoutService getOtcwmsLogoutService() {
		return otcwmsLogoutService;
	}

	public void setOtcwmsLogoutService(OtcwmsLogoutService otcwmsLogoutService) {
		this.otcwmsLogoutService = otcwmsLogoutService;
	}

	public OtcwmsOrderCheckService getOtcwmsOrderCheckService() {
		return otcwmsOrderCheckService;
	}

	public void setOtcwmsOrderCheckService(
			OtcwmsOrderCheckService otcwmsOrderCheckService) {
		this.otcwmsOrderCheckService = otcwmsOrderCheckService;
	}

	public OtcwmsOrderDeleteService getOtcwmsOrderDeleteService() {
		return otcwmsOrderDeleteService;
	}

	public void setOtcwmsOrderDeleteService(
			OtcwmsOrderDeleteService otcwmsOrderDeleteService) {
		this.otcwmsOrderDeleteService = otcwmsOrderDeleteService;
	}

	public OtcwmsOrderUploadService getOtcwmsOrderUploadService() {
		return otcwmsOrderUploadService;
	}

	public void setOtcwmsOrderUploadService(
			OtcwmsOrderUploadService otcwmsOrderUploadService) {
		this.otcwmsOrderUploadService = otcwmsOrderUploadService;
	}

	public OtcwmsOrderIgpService getOtcwmsOrderIgpService() {
		return otcwmsOrderIgpService;
	}

	public void setOtcwmsOrderIgpService(
			OtcwmsOrderIgpService otcwmsOrderIgpService) {
		this.otcwmsOrderIgpService = otcwmsOrderIgpService;
	}

	public OtcwmsOrderConfirmService getOtcwmsOrderConfirmService() {
		return otcwmsOrderConfirmService;
	}

	public void setOtcwmsOrderConfirmService(
			OtcwmsOrderConfirmService otcwmsOrderConfirmService) {
		this.otcwmsOrderConfirmService = otcwmsOrderConfirmService;
	}

	public OtcwmsOrderMoveService getOtcwmsOrderMoveService() {
		return otcwmsOrderMoveService;
	}

	public void setOtcwmsOrderMoveService(
			OtcwmsOrderMoveService otcwmsOrderMoveService) {
		this.otcwmsOrderMoveService = otcwmsOrderMoveService;
	}

	public RfWsService getRfWsService() {
		return rfWsService;
	}

	public void setRfWsService(RfWsService rfWsService) {
		this.rfWsService = rfWsService;
	}

	public StgPoDownService getStgPoDownService() {
		return stgPoDownService;
	}

	public void setStgPoDownService(StgPoDownService stgPoDownService) {
		this.stgPoDownService = stgPoDownService;
	}

	public StgStoDownService getStgStoDownService() {
		return stgStoDownService;
	}

	public void setStgStoDownService(StgStoDownService stgStoDownService) {
		this.stgStoDownService = stgStoDownService;
	}

	public OdsCustomerOrderService getOdsCustomerOrderService() {
		return odsCustomerOrderService;
	}

	public void setOdsCustomerOrderService(OdsCustomerOrderService odsCustomerOrderService) {
		this.odsCustomerOrderService = odsCustomerOrderService;
	}

	public OdsCustomerScanInfoService getOdsCustomerScanInfoService() {
		return odsCustomerScanInfoService;
	}

	public void setOdsCustomerScanInfoService(OdsCustomerScanInfoService odsCustomerScanInfoService) {
		this.odsCustomerScanInfoService = odsCustomerScanInfoService;
	}

}
