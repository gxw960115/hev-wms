package com.haier.hevwms.report.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
/**
* @Company: 青鸟软通
* @Title: SalesReturnReportService.java
* @Package com.haier.hevwms.report.service
* @author YanFengdan
* @date 2015-12-1 下午4:10:05
 */
public interface SalesReturnReportService {

	public Pager<SalesReturnReportDTO> searchSalesReturnReportInfos(Pager<SalesReturnReportDTO> pager,
			SalesReturnReportDTO salesReturnReportDTO);

	public List<SalesReturnReportDTO> getSalesReturnReportInfos(
			SalesReturnReportDTO salesReturnReportDTO);

	public Long getExportAmount(SalesReturnReportDTO dto);
}
