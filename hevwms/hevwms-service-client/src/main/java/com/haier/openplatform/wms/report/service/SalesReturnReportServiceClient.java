package com.haier.openplatform.wms.report.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
/**
* @Company: 青鸟软通
* @Title: SalesReturnReportServiceClient.java
* @Package com.haier.openplatform.wms.report.service
* @author YanFengdan
* @date 2015-12-1 下午3:30:39
 */
public interface SalesReturnReportServiceClient {

	public Pager<SalesReturnReportDTO> searchSalesReturnReport(Pager<SalesReturnReportDTO> pager,
			SalesReturnReportDTO salesReturnReportDTO);

	public List<SalesReturnReportDTO> getSalesReturnReportInfos(
			SalesReturnReportDTO dto);

	public Long getExportAmount(SalesReturnReportDTO dto);
}
