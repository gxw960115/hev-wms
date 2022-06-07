package com.haier.hevwms.report.service.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.openplatform.showcase.util.PlantInfo;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;
import com.haier.hevwms.report.dao.PsiReportDAO;
import com.haier.hevwms.report.service.PsiReportService;

import net.sf.jasperreports.engine.JasperRunManager;

public class PsiReportServiceImpl implements PsiReportService{
    Logger logger = Logger.getLogger(PsiReportServiceImpl.class);

	private PsiReportDAO psiReportDAO;
	
	/**
	 * PSI Report查询
	* <p>Title: searchPsiReportInfos</p>
	* <p>Description: </p>
	* @param pager
	* @param psiReportDTO
	* @return
	* @see com.haier.hevwms.report.service.PsiReportService#searchPsiReportInfos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.report.dto.PsiReportDTO)
	 */
	@Override
	public Pager<PsiReportDTO> searchPsiReportInfos(Pager<PsiReportDTO> pager,
			PsiReportDTO psiReportDTO) {
		List<PsiReportDTO> dto = psiReportDAO.searchPsiReportInfos(pager,psiReportDTO);
		Long size = psiReportDAO.searchPsiReportInfosCount(psiReportDTO);
		return Pager.cloneFromPager(pager, size, dto);
	}
	/**
	 * PSI Report导出
	* <p>Title: getPsiReportInfos</p>
	* <p>Description: </p>
	* @param psiReportDTO
	* @return
	* @see com.haier.hevwms.report.service.PsiReportService#getPsiReportInfos(com.haier.openplatform.wms.report.dto.PsiReportDTO)
	 */
	@Override
	public List<PsiReportDTO> getPsiReportInfos(PsiReportDTO psiReportDTO) {
		return psiReportDAO.getPsiReportInfos(psiReportDTO);
	}

	public PsiReportDAO getPsiReportDAO() {
		return psiReportDAO;
	}

	public void setPsiReportDAO(PsiReportDAO psiReportDAO) {
		this.psiReportDAO = psiReportDAO;
	}
	
	/**
	* @Title: generatePsiReport
	* @Description: generate Psi Report
	* @param @param filePath
	* @param @param parameters
	* @param @return
	* @return byte[]
	* @throws
	 */
	public byte[] generatePsiReport(String filePath, Map<String, Object> parameters) {
	    logger.debug("Entering generatePsiReport, filePath = " + filePath);
	    byte[] bytes = null;
	    Connection conn = null;
	    try {
	        DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
	        conn = datasource.getConnection();
	        if (conn == null) {
	            logger.error("DB Connection is null, return!");
	            return bytes;
	        }
	        
	        if(parameters.get("plant")!=null&&!"".equals(parameters.get("plant"))){
	        	List<String> info=PlantInfo.getPlantInfo(parameters.get("plant").toString());
	        	parameters.put("plant", info.get(0));
	        	parameters.put("address", info.get(1));
//	        	parameters.put("telPhone", info.get(2));
	        }
	        bytes = JasperRunManager.runReportToPdf(filePath,parameters, conn);
	        conn.close();
	    } catch (Exception e) {
	        logger.error("Catch Unknown Exception: " + e.getMessage());
	        try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	        e.printStackTrace();
	        
	    } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
	    
	    logger.debug("Exiting generatePsiReport...");
	    return bytes;
	}
	
	@Override
	public PsiReportDTO getConnection(){
	        PsiReportDTO prd=new PsiReportDTO();
	        DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
           
           if(datasource.getUsername()!=null){
               prd.setUserName(datasource.getUsername());
           }
           if( datasource.getPassword()!=null){
               prd.setPassWord(datasource.getPassword());
           }
           if( datasource.getUrl()!=null){
               prd.setUrl(datasource.getUrl());
           }
           if(datasource.getDriverClassName()!=null){
               prd.setDriverClassName(datasource.getDriverClassName());
           };
        return prd;
                    
	}
	@Override
	public Long getExportAmount(PsiReportDTO dto) {
		return psiReportDAO.searchPsiReportInfosCount(dto);
	}

}
