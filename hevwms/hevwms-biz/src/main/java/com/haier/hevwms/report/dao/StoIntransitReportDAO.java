package com.haier.hevwms.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;
/**
* @Company: 青鸟软通
* @Title: StoIntransitReportDAO.java
* @Package com.haier.hevwms.report.dao
* @author YanFengdan
* @date 2015-12-2 上午10:54:35
 */
public interface StoIntransitReportDAO extends CommonDAO<StoIntransitReportDTO, Long>{

	public List<StoIntransitReportDTO> getStoIntransitReportInfos(
			@Param("stoIntransitReportDTO") StoIntransitReportDTO stoIntransitReportDTO);

	public List<StoIntransitReportDTO> searchStoIntransitReportInfos(
			@Param("pager") Pager<StoIntransitReportDTO> pager,
			@Param("stoIntransitReportDTO") StoIntransitReportDTO stoIntransitReportDTO);

	public Long searchStoIntransitReportInfosCount(
			@Param("stoIntransitReportDTO") StoIntransitReportDTO stoIntransitReportDTO);

}
