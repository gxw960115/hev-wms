package com.haier.hevwms.report.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;

/**
 * PSI Report查询、导出
* @Company: 青鸟软通
* @Title: PsiReportService.java
* @Package com.haier.hevwms.report.service
* @author YanFengdan
* @date 2015-12-1 下午2:23:29
 */
public interface PsiReportService {

	public Pager<PsiReportDTO> searchPsiReportInfos(Pager<PsiReportDTO> pager,
			PsiReportDTO psiReportDTO);

	public List<PsiReportDTO> getPsiReportInfos(PsiReportDTO psiReportDTO);
	
	public byte[] generatePsiReport(String filePath, Map<String, Object> parameters);

    public PsiReportDTO getConnection();

	public Long getExportAmount(PsiReportDTO dto);

}
