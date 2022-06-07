package com.haier.openplatform.wms.report.service.impl;

import java.util.List;

import com.haier.hevwms.report.service.StoIntransitReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
import com.haier.openplatform.wms.report.service.StoIntransitReportServiceClient;
/**
* @Company: 青鸟软通
* @Title: StoIntransitReportServiceClientImpl.java
* @Package com.haier.openplatform.wms.report.service.impl
* @author YanFengdan
* @date 2015-12-2 上午10:49:16
 */
public class StoIntransitReportServiceClientImpl implements StoIntransitReportServiceClient{

	private StoIntransitReportService stoIntransitReportService;
	@Override
	public Pager<StoIntransitReportDTO> searchStoIntransitReport(
			Pager<StoIntransitReportDTO> pager,
			StoIntransitReportDTO stoIntransitReportDTO) {
		return stoIntransitReportService.searchStoIntransitReportInfos(pager, stoIntransitReportDTO);
	}

	@Override
	public List<StoIntransitReportDTO> getStoIntransitPsiReportInfos(
			StoIntransitReportDTO stoIntransitReportDTO) {
		return stoIntransitReportService.getStoIntransitReportInfos(stoIntransitReportDTO);
	}
	
	public Long getExportAmount(StoIntransitReportDTO dto) {
		return stoIntransitReportService.getExportAmount(dto);
	}

	public StoIntransitReportService getStoIntransitReportService() {
		return stoIntransitReportService;
	}

	public void setStoIntransitReportService(
			StoIntransitReportService stoIntransitReportService) {
		this.stoIntransitReportService = stoIntransitReportService;
	}

}
