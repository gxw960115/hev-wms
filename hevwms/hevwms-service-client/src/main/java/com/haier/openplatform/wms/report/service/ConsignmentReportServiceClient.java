package com.haier.openplatform.wms.report.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;

public interface ConsignmentReportServiceClient {

	public Pager<ConsignmentReportDTO> searchConsignmentReport(
			Pager<ConsignmentReportDTO> pager,
			ConsignmentReportDTO consignmentReportDTO);

	public List<ConsignmentReportDTO> getConsignmentReportInfos(
			ConsignmentReportDTO dto);

	public Long getExportAmount(ConsignmentReportDTO dto);

}
