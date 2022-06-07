package com.haier.hevwms.report.service.impl;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
import com.haier.hevwms.report.dao.StoIntransitReportDAO;
import com.haier.hevwms.report.service.StoIntransitReportService;
/**
* @Company: 青鸟软通
* @Title: StoIntransitReportServiceImpl.java
* @Package com.haier.hevwms.report.service.impl
* @author YanFengdan
* @date 2015-12-2 上午10:51:41
 */
public class StoIntransitReportServiceImpl implements StoIntransitReportService{

	private StoIntransitReportDAO stoIntransitReportDAO;
	@Override
	public Pager<StoIntransitReportDTO> searchStoIntransitReportInfos(
			Pager<StoIntransitReportDTO> pager,
			StoIntransitReportDTO stoIntransitReportDTO) {
		List<StoIntransitReportDTO> dto = stoIntransitReportDAO.searchStoIntransitReportInfos(pager, stoIntransitReportDTO);
		Long size = stoIntransitReportDAO.searchStoIntransitReportInfosCount(stoIntransitReportDTO);
		return Pager.cloneFromPager(pager, size, dto);
	}

	@Override
	public List<StoIntransitReportDTO> getStoIntransitReportInfos(
			StoIntransitReportDTO stoIntransitReportDTO) {
		return stoIntransitReportDAO.getStoIntransitReportInfos(stoIntransitReportDTO);
	}
	
	public Long getExportAmount(StoIntransitReportDTO dto){
		return stoIntransitReportDAO.searchStoIntransitReportInfosCount(dto);
	}

	public StoIntransitReportDAO getStoIntransitReportDAO() {
		return stoIntransitReportDAO;
	}

	public void setStoIntransitReportDAO(StoIntransitReportDAO stoIntransitReportDAO) {
		this.stoIntransitReportDAO = stoIntransitReportDAO;
	}

}
