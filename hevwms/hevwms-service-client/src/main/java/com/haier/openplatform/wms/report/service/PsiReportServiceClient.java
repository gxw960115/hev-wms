package com.haier.openplatform.wms.report.service;

import java.util.List;
import java.util.Map;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;

/**
 * PSI Report查询、导出
* @Company: 青鸟软通
* @Title: PsiReportServiceClient.java
* @Package com.haier.openplatform.wms.report.service
* @author YanFengdan
* @date 2015-12-1 下午2:21:55
 */
public interface PsiReportServiceClient {

	Pager<PsiReportDTO> searchPsiReport(Pager<PsiReportDTO> pager,
			PsiReportDTO psiReportDTO);


	List<PsiReportDTO> getPsiReportInfos(PsiReportDTO psiReportDTO);
	
	public byte[] generatePsiReport(String filePath, Map<String, Object> parameters);

	public PsiReportDTO conn() ;


	public Long getExportAmount(PsiReportDTO dto);
	
}
