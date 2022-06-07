package com.haier.hevwms.report.service.impl;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
import com.haier.hevwms.report.dao.ConsignmentReportDAO;
import com.haier.hevwms.report.service.ConsignmentReportService;
/**
* @Company: 青鸟软通
* @Title: ConsignmentReportServiceImpl.java
* @Package com.haier.hevwms.report.service.impl
* @author YanFengdan
* @date 2015-12-2 上午10:30:39
 */
public class ConsignmentReportServiceImpl implements ConsignmentReportService{

	private ConsignmentReportDAO consignmentReportDAO;
	@Override
	public Pager<ConsignmentReportDTO> searchConsignmentReportInfos(
			Pager<ConsignmentReportDTO> pager,
			ConsignmentReportDTO consignmentReportDTO) {
		List<ConsignmentReportDTO> dto = consignmentReportDAO.searchConsignmentReportInfos(pager, consignmentReportDTO);
		Long size = consignmentReportDAO.searchConsignmentReportInfosCount(consignmentReportDTO);
		return Pager.cloneFromPager(pager, size, dto);
	}
	
	@Override
	public List<ConsignmentReportDTO> getConsignmentReportInfos(
			ConsignmentReportDTO consignmentReportDTO) {
		return consignmentReportDAO.getConsignmentReportInfos(consignmentReportDTO);
	}
	
	@Override
	public Long getExportAmount(ConsignmentReportDTO dto) {
		return consignmentReportDAO.searchConsignmentReportInfosCount(dto);
	}

	public ConsignmentReportDAO getConsignmentReportDAO() {
		return consignmentReportDAO;
	}

	public void setConsignmentReportDAO(ConsignmentReportDAO consignmentReportDAO) {
		this.consignmentReportDAO = consignmentReportDAO;
	}
}
