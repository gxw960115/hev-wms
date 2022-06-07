package com.haier.hevwms.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;
/**
* @Company: 青鸟软通
* @Title: SalesReturnReportDAO.java
* @Package com.haier.hevwms.report.dao
* @author YanFengdan
* @date 2015-12-1 下午4:13:06
 */
public interface SalesReturnReportDAO extends CommonDAO<SalesReturnReportDTO, Long>{

	public List<SalesReturnReportDTO> searchSalesReturnReportInfos(@Param("pager") Pager<SalesReturnReportDTO> pager,
			@Param("salesReturnReportDTO") SalesReturnReportDTO salesReturnReportDTO);

	public List<SalesReturnReportDTO> getSalesReturnReportInfos(
			@Param("salesReturnReportDTO") SalesReturnReportDTO salesReturnReportDTO);

	public Long searchSalesReturnReportInfosCount(
			@Param("salesReturnReportDTO") SalesReturnReportDTO salesReturnReportDTO);

}
