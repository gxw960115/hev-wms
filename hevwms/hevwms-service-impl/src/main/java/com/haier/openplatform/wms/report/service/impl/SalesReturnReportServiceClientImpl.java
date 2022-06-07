package com.haier.openplatform.wms.report.service.impl;

import java.util.List;

import com.haier.hevwms.report.service.SalesReturnReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
import com.haier.openplatform.wms.report.service.SalesReturnReportServiceClient;

public class SalesReturnReportServiceClientImpl implements SalesReturnReportServiceClient{

	private SalesReturnReportService salesReturnReportService;
	/**
	* <p>Title: searchSalesReturnReport</p>
	* <p>Description:查询 </p>
	* @param pager
	* @param salesReturnReportDTO
	* @return
	* @see com.haier.openplatform.wms.report.service.SalesReturnReportServiceClient#searchSalesReturnReport(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.report.dto.SalesReturnReportDTO)
	 */
	@Override
	public Pager<SalesReturnReportDTO> searchSalesReturnReport(
			Pager<SalesReturnReportDTO> pager, SalesReturnReportDTO salesReturnReportDTO) {
		return salesReturnReportService.searchSalesReturnReportInfos(pager, salesReturnReportDTO);
	}
	/**
	* <p>Title: getSalesReturnReportInfos</p>
	* <p>Description:导出 </p>
	* @param salesReturnReportDTO
	* @return
	* @see com.haier.openplatform.wms.report.service.SalesReturnReportServiceClient#getSalesReturnReportInfos(com.haier.openplatform.wms.report.dto.SalesReturnReportDTO)
	 */
	@Override
	public List<SalesReturnReportDTO> getSalesReturnReportInfos(
			SalesReturnReportDTO salesReturnReportDTO) {
		return salesReturnReportService.getSalesReturnReportInfos(salesReturnReportDTO);
	}
	
	@Override
	public Long getExportAmount(SalesReturnReportDTO dto) {
		return salesReturnReportService.getExportAmount(dto);
	}

	public SalesReturnReportService getSalesReturnReportService() {
		return salesReturnReportService;
	}

	public void setSalesReturnReportService(
			SalesReturnReportService salesReturnReportService) {
		this.salesReturnReportService = salesReturnReportService;
	}
}
