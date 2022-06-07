package com.haier.openplatform.wms.report.service.impl;

import java.util.List;
import java.util.Map;

import com.haier.hevwms.report.service.PsiReportService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
/**
 * PSI Report查询、导出
* @Company: 青鸟软通
* @Title: PsiReportServiceClientImpl.java
* @Package com.haier.openplatform.wms.report.service.impl
* @author YanFengdan
* @date 2015-11-30 下午3:08:37
 */
public class PsiReportServiceClientImpl implements PsiReportServiceClient{

	private PsiReportService psiReportService;
	
	@Override
	public Pager<PsiReportDTO> searchPsiReport(Pager<PsiReportDTO> pager,
			PsiReportDTO psiReportDTO) {
		return psiReportService.searchPsiReportInfos(pager,psiReportDTO);
	}

	@Override
	public List<PsiReportDTO> getPsiReportInfos(PsiReportDTO psiReportDTO) {
		return psiReportService.getPsiReportInfos(psiReportDTO);
	}

	public PsiReportService getPsiReportService() {
		return psiReportService;
	}

	public void setPsiReportService(PsiReportService psiReportService) {
		this.psiReportService = psiReportService;
	}
	
	public byte[] generatePsiReport(String filePath, Map<String, Object> parameters) {
	    return this.psiReportService.generatePsiReport(filePath, parameters);
	}

    @Override
    public PsiReportDTO  conn()  {
        return psiReportService.getConnection();
    }

	@Override
	public Long getExportAmount(PsiReportDTO dto) {
		return psiReportService.getExportAmount(dto);
	}

}
