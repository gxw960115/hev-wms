package com.haier.hevwms.report.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
/**
* @Company: 青鸟软通
* @Title: ConsignmentReportService.java
* @Package com.haier.hevwms.report.service
* @author YanFengdan
* @date 2015-12-2 上午10:29:17
 */
public interface ConsignmentReportService {

	public Pager<ConsignmentReportDTO> searchConsignmentReportInfos(
			Pager<ConsignmentReportDTO> pager,
			ConsignmentReportDTO consignmentReportDTO);

	public List<ConsignmentReportDTO> getConsignmentReportInfos(
			ConsignmentReportDTO consignmentReportDTO);

	public Long getExportAmount(ConsignmentReportDTO dto);

}
