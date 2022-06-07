package com.haier.hevwms.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;
/**
 * PSI Report查询、导出
* @Company: 青鸟软通
* @Title: PsiReportDAO.java
* @Package com.haier.hevwms.report.dao
* @author YanFengdan
* @date 2015-12-1 下午2:24:41
 */
public interface PsiReportDAO extends CommonDAO<PsiReportDTO, Long>{

	public Long searchPsiReportInfosCount(@Param("psiReportDTO") PsiReportDTO psiReportDTO);

	public List<PsiReportDTO> searchPsiReportInfos(@Param("pager") Pager<PsiReportDTO> pager,
			@Param("psiReportDTO") PsiReportDTO psiReportDTO);

	public List<PsiReportDTO> getPsiReportInfos(@Param("psiReportDTO") PsiReportDTO psiReportDTO);

}
