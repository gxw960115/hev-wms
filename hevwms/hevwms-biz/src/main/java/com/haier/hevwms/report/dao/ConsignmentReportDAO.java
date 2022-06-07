package com.haier.hevwms.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;
/**
* @Company: 青鸟软通
* @Title: ConsignmentReportDAO.java
* @Package com.haier.hevwms.report.dao
* @author YanFengdan
* @date 2015-12-2 上午10:34:24
 */
public interface ConsignmentReportDAO extends CommonDAO<ConsignmentReportDTO, Long>{

	public List<ConsignmentReportDTO> searchConsignmentReportInfos(
			@Param("pager") Pager<ConsignmentReportDTO> pager,
			@Param("consignmentReportDTO") ConsignmentReportDTO consignmentReportDTO);

	public Long searchConsignmentReportInfosCount(
			@Param("consignmentReportDTO") ConsignmentReportDTO consignmentReportDTO);

	public List<ConsignmentReportDTO> getConsignmentReportInfos(
			@Param("consignmentReportDTO") ConsignmentReportDTO consignmentReportDTO);

}
