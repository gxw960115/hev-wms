package com.haier.hevwms.report.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
/**
* @Company: 青鸟软通
* @Title: StoIntransitReportService.java
* @Package com.haier.hevwms.report.service
* @author YanFengdan
* @date 2015-12-2 上午10:51:21
 */
public interface StoIntransitReportService {

	public Pager<StoIntransitReportDTO> searchStoIntransitReportInfos(
			Pager<StoIntransitReportDTO> pager,
			StoIntransitReportDTO stoIntransitReportDTO);

	public List<StoIntransitReportDTO> getStoIntransitReportInfos(
			StoIntransitReportDTO stoIntransitReportDTO);

	public Long getExportAmount(StoIntransitReportDTO stoIntransitReportDTO);

}
