package com.haier.openplatform.wms.report.service.impl;

import java.util.List;

import com.haier.hevwms.report.service.ConsignmentReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.openplatform.wms.report.service.ConsignmentReportServiceClient;
/**
* @Company: 青鸟软通
* @Title: ConsignmentReportServiceClientImpl.java
* @Package com.haier.openplatform.wms.report.service.impl
* @author YanFengdan
* @date 2015-12-2 上午10:28:56
 */
public class ConsignmentReportServiceClientImpl implements ConsignmentReportServiceClient{

	private ConsignmentReportService consignmentReportService;
	@Override
	public Pager<ConsignmentReportDTO> searchConsignmentReport(
			Pager<ConsignmentReportDTO> pager,
			ConsignmentReportDTO consignmentReportDTO) {
		return consignmentReportService.searchConsignmentReportInfos(pager, consignmentReportDTO);
	}

	@Override
	public List<ConsignmentReportDTO> getConsignmentReportInfos(
			ConsignmentReportDTO consignmentReportDTO) {
		return consignmentReportService.getConsignmentReportInfos(consignmentReportDTO);
	}
	
	@Override
	public Long getExportAmount(ConsignmentReportDTO dto) {
		return consignmentReportService.getExportAmount(dto);
	}

	public ConsignmentReportService getConsignmentReportService() {
		return consignmentReportService;
	}

	public void setConsignmentReportService(
			ConsignmentReportService consignmentReportService) {
		this.consignmentReportService = consignmentReportService;
	}
}
