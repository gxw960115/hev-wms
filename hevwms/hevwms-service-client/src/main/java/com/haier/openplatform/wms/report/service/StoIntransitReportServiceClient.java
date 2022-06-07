package com.haier.openplatform.wms.report.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
/**
* @Company: 青鸟软通
* @Title: StoIntransitReportServiceClient.java
* @Package com.haier.openplatform.wms.report.service
* @author YanFengdan
* @date 2015-12-2 上午10:41:38
 */
public interface StoIntransitReportServiceClient {

	public Pager<StoIntransitReportDTO> searchStoIntransitReport(
			Pager<StoIntransitReportDTO> pager,
			StoIntransitReportDTO stoIntransitReportDTO);

	public List<StoIntransitReportDTO> getStoIntransitPsiReportInfos(
			StoIntransitReportDTO dto);

	public Long getExportAmount(StoIntransitReportDTO dto);

}
