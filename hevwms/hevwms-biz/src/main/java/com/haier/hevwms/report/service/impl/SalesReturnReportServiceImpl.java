package com.haier.hevwms.report.service.impl;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
import com.haier.hevwms.report.dao.SalesReturnReportDAO;
import com.haier.hevwms.report.service.SalesReturnReportService;

public class SalesReturnReportServiceImpl implements SalesReturnReportService{

	private SalesReturnReportDAO salesReturnReportDAO;
	/**
	* <p>Title: searchSalesReturnReportInfos</p>
	* <p>Description: </p>
	* @param pager
	* @param salesReturnReportDTO
	* @return
	* @see com.haier.hevwms.report.service.SalesReturnReportService#searchSalesReturnReportInfos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.report.dto.SalesReturnReportDTO)
	 */
	@Override
	public Pager<SalesReturnReportDTO> searchSalesReturnReportInfos(
			Pager<SalesReturnReportDTO> pager, SalesReturnReportDTO salesReturnReportDTO) {
		List<SalesReturnReportDTO> dto = salesReturnReportDAO.searchSalesReturnReportInfos(pager, salesReturnReportDTO);
		Long size = salesReturnReportDAO.searchSalesReturnReportInfosCount(salesReturnReportDTO);
		return Pager.cloneFromPager(pager, size, dto);
	}
	/**
	* <p>Title: getSalesReturnReportInfos</p>
	* <p>Description:导出 </p>
	* @param salesReturnReportDTO
	* @return
	* @see com.haier.hevwms.report.service.SalesReturnReportService#getSalesReturnReportInfos(com.haier.openplatform.wms.report.dto.SalesReturnReportDTO)
	 */
	@Override
	public List<SalesReturnReportDTO> getSalesReturnReportInfos(
			SalesReturnReportDTO salesReturnReportDTO) {
		return salesReturnReportDAO.getSalesReturnReportInfos(salesReturnReportDTO);
	}
	
	@Override
	public Long getExportAmount(SalesReturnReportDTO dto) {
		return salesReturnReportDAO.searchSalesReturnReportInfosCount(dto);
	}

	public SalesReturnReportDAO getSalesReturnReportDAO() {
		return salesReturnReportDAO;
	}

	public void setSalesReturnReportDAO(SalesReturnReportDAO salesReturnReportDAO) {
		this.salesReturnReportDAO = salesReturnReportDAO;
	}
}
