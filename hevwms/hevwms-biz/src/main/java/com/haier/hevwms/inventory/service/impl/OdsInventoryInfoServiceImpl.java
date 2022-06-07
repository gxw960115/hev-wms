package com.haier.hevwms.inventory.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsBarcodeHistory;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoService;
import com.haier.hevwms.takestock.dao.OdsPdDiffDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.HOPException;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;


/**
* @ClassName: OdsInventoryInfoServiceImpl
* @Description: 库存信息实现类(这里用一句话描述这个类的作用)
*
*/
public class OdsInventoryInfoServiceImpl implements OdsInventoryInfoService {
	private Logger logger = Logger.getLogger(OdsInventoryInfoServiceImpl.class);
    
	private OdsInventoryInfoDAO odsInventoryInfoDAO;
    private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
    private OdsBarcodeHistoryDAO odsBarcodeHistoryDAO;
    private OdsPdDiffDtlDAO odsPdDiffDtlDAO;
    private MdMatInfoDAO mdMatInfoDAO;
    private CdLocInfoDAO cdLocInfoDAO ;
    
    public OdsInventoryInfoDAO getOdsInventoryInfoDAO() {
        return odsInventoryInfoDAO;
    }

    public void setOdsInventoryInfoDAO(OdsInventoryInfoDAO odsInventoryInfoDAO) {
        this.odsInventoryInfoDAO = odsInventoryInfoDAO;
    }

    /* (非 Javadoc) 
    * <p>Title: searchOdsInventoryInfos</p> 
    * <p>Description: </p> 
    * @param pager
    * @param odsInventoryInfo
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#searchOdsInventoryInfos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO) 
    */
    @Override
    public Pager<OdsInventoryInfoDTO> searchOdsInventoryInfos(Pager<OdsInventoryInfoDTO> pager,OdsInventoryInfoDTO odsInventoryInfo) {
        List<OdsInventoryInfoDTO> odsInventoryInfos = odsInventoryInfoDAO.searchOdsInventoryInfos(pager, odsInventoryInfo);
        long size = odsInventoryInfoDAO.searchOdsInventoryInfosCount(odsInventoryInfo);
        return Pager.cloneFromPager(pager, size, odsInventoryInfos);
    }


    /* (非 Javadoc) 
    * <p>Title: searchOdsInventoryBinInfos</p> 
    * <p>Description: </p> 
    * @param pager
    * @param odsInventoryInfoDtlDTO
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#searchOdsInventoryBinInfos(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
    */
    @Override
    public Pager<OdsInventoryInfoDtlDTO> searchOdsInventoryBinInfos(Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {

        List<OdsInventoryInfoDtlDTO> list = new ArrayList<OdsInventoryInfoDtlDTO>();
        long size = 0;
        String statisticsFlag = odsInventoryInfoDtlDTO.getStatisticsFlag();
        if (StringUtils.isEmpty(statisticsFlag) || "1".equals(statisticsFlag)){
            list = odsInventoryInfoDtlDAO.searchOdsInventoryInfos(pager,odsInventoryInfoDtlDTO);
            size = odsInventoryInfoDtlDAO.searchOdsInventoryInfosCount(odsInventoryInfoDtlDTO);
        } else if ("2".equals(statisticsFlag)){
            list = odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfos(pager,odsInventoryInfoDtlDTO);
            size = odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfosCount(odsInventoryInfoDtlDTO);
        } else if ("3".equals(statisticsFlag)){
            list = odsInventoryInfoDtlDAO.searchOdsInventoryBinInfos(pager,odsInventoryInfoDtlDTO);
            size = odsInventoryInfoDtlDAO.searchOdsInventoryBinInfosCount(odsInventoryInfoDtlDTO);
        }
        return Pager.cloneFromPager(pager, size, list);
    }

    /* (非 Javadoc) 
    * <p>Title: searchOdsInventoryBinList</p> 
    * <p>Description: </p> 
    * @param pager
    * @param odsInventoryInfoDtlDTO
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#searchOdsInventoryBinList(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
    */
    @Override
    public List<OdsInventoryInfoDtlDTO> searchOdsInventoryBinList(Pager<OdsInventoryInfoDtlDTO> pager,OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
        List<OdsInventoryInfoDtlDTO> list = new ArrayList<OdsInventoryInfoDtlDTO>();
        String statisticsFlag = odsInventoryInfoDtlDTO.getStatisticsFlag();
        if (StringUtils.isEmpty(statisticsFlag) || "1".equals(statisticsFlag)){
            list = odsInventoryInfoDtlDAO.searchOdsInventoryInfos(pager,odsInventoryInfoDtlDTO);
        } else if ("2".equals(statisticsFlag)){
            list = odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfos(pager,odsInventoryInfoDtlDTO);
        } else if ("3".equals(statisticsFlag)){
            list = odsInventoryInfoDtlDAO.searchOdsInventoryBinInfos(pager,odsInventoryInfoDtlDTO);
        }
        return list;
    }

    /* (非 Javadoc) 
    * <p>Title: getOdsInventoryInfoByParams</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#getOdsInventoryInfoByParams(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO) 
    */
    @Override
    public List<OdsInventoryInfoDTO> getOdsInventoryInfoByParams(
            OdsInventoryInfoDTO dto) {
        return odsInventoryInfoDAO.getOdsInventoryInfoByParam(dto);
    }
    
    /* (非 Javadoc) 
    * <p>Title: updateProcessDiff</p> 
    * <p>Description: </p> 
    * @param odsPdDiffDtl
    * @param ids
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#updateProcessDiff(com.haier.hevwms.takestock.domain.OdsPdDiffDtl, java.lang.String) 
    */
    @Override
    public ExecuteResult<OdsPdDiffDtl> updateProcessDiff(OdsPdDiffDtl odsPdDiffDtl, String ids) {
	
        ExecuteResult<OdsPdDiffDtl> executeResult = new ExecuteResult<OdsPdDiffDtl>();
        int total = 0;
        int proSize = 0;
        int failSize = 0;
        try {
            for (String str : ids.split(",")) {
                total++;
                OdsPdDiffDtl diff = new OdsPdDiffDtl();
                diff.setRowId(Long.parseLong(str));
                diff.setProcessReason(odsPdDiffDtl.getProcessReason());
                OdsPdDiffDtl temp = odsPdDiffDtlDAO.get(Long.parseLong(str));
                String orderNo = temp.getOrderNo();
                
                MdMatInfoDTO mat = mdMatInfoDAO.getMdMatInfoByMaterialNo(temp.getMaterialNo());
                Map<String, String> resultMap = new HashMap<String, String>();
                resultMap.put("warehouse", temp.getPlant());
                resultMap.put("location", temp.getLocation());
                
                String locType = cdLocInfoDAO.getTypeByCode(temp.getLocation());
                // 记录历史信息
                if ("0".equals(odsPdDiffDtl.getProcessFlag())) {
                    //差异处理时更新差异处理原因
                    odsPdDiffDtlDAO.updateProcessReason(diff);
                    OdsBarcodeHistory history = new OdsBarcodeHistory();
                    history.setBarcode(temp.getBarcode());
                    history.setCreateBy(odsPdDiffDtl.getCreateBy());
                    history.setCreateDate(new Date());
                    history.setCustomerModel(temp.getCustomerModel());
                    history.setLocation(temp.getLocation());
                    history.setMaterialDesp(temp.getMaterialDesp());
                    history.setMaterialNo(temp.getMaterialNo());
                    history.setPlant(temp.getPlant());
                    history.setQty(temp.getQty());
                    history.setSubLocation(temp.getSubLocation());
                    history.setUnit(temp.getUnit());
                    history.setDocTpye("ST");
                    history.setOrderNo(temp.getOrderNo());
                    history.setInoutDate(new Date());
                    history.setModifyDate(new Date());
                    // 盘盈
                    if ("0".equals(temp.getDiffType())) {
                    	//CBU
                    	if (!"SKU".equalsIgnoreCase(mat.getMatScanType())){
                    		// 如果库存中存在不作处理
                            OdsInventoryInfoDtl tempDtl = odsInventoryInfoDtlDAO.getByBarcode(temp.getBarcode());
                            
                            if (tempDtl == null) {
                                OdsInventoryInfoDtl dtl = new OdsInventoryInfoDtl();
                                dtl.setBarcode(temp.getBarcode());
                                dtl.setCreateBy(odsPdDiffDtl.getCreateBy());
                                dtl.setCreateDate(new Date());
                                dtl.setModifyDate(new Date());
                                dtl.setCustomerModel(temp.getCustomerModel());                 
                                dtl.setMaterialDesp(temp.getMaterialDesp());
                                dtl.setMaterialNo(temp.getMaterialNo());
                                dtl.setPlant(resultMap.get("warehouse"));
                                dtl.setLocation(resultMap.get("location"));
                                dtl.setQty(temp.getQty());
                                dtl.setUseQty(0L);
                                dtl.setSubLocation(resultMap.get("location"));
                                dtl.setUnit(temp.getUnit());
                                dtl.setDocTpye("ST");
                                dtl.setOrderNo(temp.getOrderNo());
                                dtl.setSapOrderNo(temp.getOrderNo());
                                dtl.setLockFlag("0");
                                if ("1".equals(locType)){
                                	dtl.setCustomerFlag("1");
                                }
                                dtl.setFirstInDate(new Date());
                                odsInventoryInfoDtlDAO.save(dtl);
                                history.setInoutType("1");
                            } else {
                            	logger.info(orderNo+"==>Profit==>CBU==>BarCode already exists,please check inventory!");
                                executeResult.addErrorMessage("BarCode already exists,please check inventory!");
                                failSize++;
                                continue;
                            }
                        //SKU
                    	}else {
                    		OdsInventoryInfoDtl param = new OdsInventoryInfoDtl();
                    		param.setBarcode(temp.getBarcode());
                    		param.setPlant(resultMap.get("warehouse"));
                    		param.setLocation("'"+resultMap.get("location")+"'");
                    		List<OdsInventoryInfoDtl> list = odsInventoryInfoDtlDAO.getOdsInventoryInfoDtlByParam(param) ;
                    		if (list == null||list.size() == 0){
                    			OdsInventoryInfoDtl dtl = new OdsInventoryInfoDtl();
                                dtl.setBarcode(temp.getBarcode());
                                dtl.setCreateBy(odsPdDiffDtl.getCreateBy());
                                dtl.setCreateDate(new Date());
                                dtl.setModifyDate(new Date());
                                dtl.setCustomerModel(temp.getCustomerModel());                 
                                dtl.setMaterialDesp(temp.getMaterialDesp());
                                dtl.setMaterialNo(temp.getMaterialNo());
                                dtl.setPlant(resultMap.get("warehouse"));
                                dtl.setLocation(resultMap.get("location"));
                                dtl.setQty(temp.getQty());
                                dtl.setUseQty(0L);
                                dtl.setSubLocation(resultMap.get("location"));
                                dtl.setUnit(temp.getUnit());
                                dtl.setDocTpye("ST");
                                dtl.setOrderNo(temp.getOrderNo());
                                dtl.setSapOrderNo(temp.getOrderNo());
                                dtl.setLockFlag("0");
                                if ("1".equals(locType)){
                                	dtl.setCustomerFlag("1");
                                }
                                dtl.setFirstInDate(new Date());
                                odsInventoryInfoDtlDAO.save(dtl);
                                history.setInoutType("1");
                    		} else if (list.size() == 1){
                    			odsInventoryInfoDtlDAO.updateQtyInfo(list.get(0).getRowId(), list.get(0).getQty()+temp.getQty(), list.get(0).getUseQty());
                    			history.setInoutType("1");
                    		} else {
                    			logger.info(orderNo+"==>Profit==>SKU==>Repeat barcode in one location!"+temp.getBarcode());
                    			executeResult.addErrorMessage("Repeat barcode in one location!"+temp.getBarcode());
		                        failSize++;
		                        continue;
                    		}
                    	}
                    //盘亏
                    } else if ("1".equals(temp.getDiffType())) {
                    	//CBU
                    	if (!"SKU".equalsIgnoreCase(mat.getMatScanType())){
                    		// 如果库存中存在不作处理
                            OdsInventoryInfoDtl tempDtl = odsInventoryInfoDtlDAO.getByBarcode(temp.getBarcode());
                            if (tempDtl == null) {
                            	logger.info(orderNo+"==>Loss==>CUB==>BarCode not in warehouse,please check inventory!");
                                executeResult.addErrorMessage("BarCode not in warehouse,please check inventory!");
                                failSize++;
                                continue;
                            } else {
                                if (tempDtl.getUseQty() > 0) {
                                	logger.info(orderNo+"==>Loss==>CUB==>BarCode is using,please check inventory!");
                                    executeResult.addErrorMessage("BarCode is using,please check inventory!");
                                    failSize++;
                                    continue;
                                } else {
                                    // 盘亏 处理 出库
                                    odsInventoryInfoDtlDAO.deleteByBarcode(temp.getBarcode());
                                    history.setInoutType("2");
                                }
                            }
                        //SKU
                    	}else{
                    		OdsInventoryInfoDtl param = new OdsInventoryInfoDtl();
                    		param.setBarcode(temp.getBarcode());
                    		param.setPlant(resultMap.get("warehouse"));
                    		param.setLocation("'"+resultMap.get("location")+"'");
                    		List<OdsInventoryInfoDtl> list = odsInventoryInfoDtlDAO.getOdsInventoryInfoDtlByParam(param) ;
                    		if (list == null||list.size()==0){
                    			logger.info(orderNo+"==>Loss==>SKU==>BarCode not in warehouse,please check inventory!");
                    			executeResult.addErrorMessage("BarCode not in warehouse,please check inventory!");
		                        failSize++;
		                        continue;
                    		} else if (list.size()== 1){
                    			if (list.get(0).getQty().longValue() == temp.getQty().longValue()){
                    				odsInventoryInfoDtlDAO.delete(list.get(0).getRowId());
                    				history.setInoutType("2");
                    			} else if (list.get(0).getQty() > temp.getQty()) {
                    				if (list.get(0).getUseQty() > list.get(0).getQty()-temp.getQty()){
                    					logger.info(orderNo+"==>Loss==>SKU==>Used qty is larger than stocktaking qty,please check inventory!");
                    					executeResult.addErrorMessage("Used qty is larger than stocktaking qty,please check inventory!");
    			                        failSize++;
    			                        continue;
                    				}
                    				odsInventoryInfoDtlDAO.updateQtyInfo(list.get(0).getRowId(),list.get(0).getQty()-temp.getQty(), list.get(0).getUseQty());
                        			history.setInoutType("2");
                    			} else {
                    				logger.info(orderNo+"==>Loss==>SKU==>Qty is not enough,please check inventory!");
                    				executeResult.addErrorMessage("Qty is not enough,please check inventory!");
			                        failSize++;
			                        continue;
                    			}
                    		}else {
                    			logger.info(orderNo+"==>Loss==>SKU==>Repeat barcode in one location!"+temp.getBarcode());
                    			executeResult.addErrorMessage("Repeat barcode in one location!"+temp.getBarcode());
		                        failSize++;
		                        continue;
                    		}
                    	}
                    //BIN位不对
                    } else if("2".equals(temp.getDiffType())) {
                    	odsInventoryInfoDtlDAO.updateInventoryDtlBin(temp.getBarcode(),temp.getOrderNo());
                    }
                    odsBarcodeHistoryDAO.save(history);
                }
                proSize++;
                odsInventoryInfoDAO.updatePdFlag(temp.getRowId(),odsPdDiffDtl.getCreateBy());
            }
            executeResult.setSuccessMessage("Total:" + total + ",Process:" + proSize + ",Failure:" + failSize);
        } catch (Exception e) {
        	logger.info("Exception:"+e.getMessage());
            executeResult.addErrorMessage("Exception:"+e.getMessage());
            throw new HOPException("exception:" + OdsInventoryInfoServiceImpl.class, e);
        }
        return executeResult;
    }

    /* (非 Javadoc) 
    * <p>Title: wmsQtyDetail</p> 
    * <p>Description: </p> 
    * @param pager
    * @param odsInventoryInfo
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#wmsQtyDetail(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO) 
    */
    @Override
    public Pager<OdsInventoryInfoDTO> wmsQtyDetail(Pager<OdsInventoryInfoDTO> pager,OdsInventoryInfoDTO odsInventoryInfo) {
	List<OdsInventoryInfoDTO> odsInventoryInfos = odsInventoryInfoDAO.wmsQtyDetail(pager, odsInventoryInfo);
        long size = odsInventoryInfoDAO.wmsQtyDetailCount(odsInventoryInfo);
        return Pager.cloneFromPager(pager, size, odsInventoryInfos);
    }
    
    /* (非 Javadoc) 
    * <p>Title: getExportAmount</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#getExportAmount(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO) 
    */
    @Override
	public Long getExportAmount(OdsInventoryInfoDTO dto) {
		return odsInventoryInfoDAO.searchOdsInventoryInfosCount(dto);
	}

    @Override
	public Long getExportBinAmount(OdsInventoryInfoDtlDTO dto) {
        long size = 0;
        String statisticsFlag = dto.getStatisticsFlag();
        if (StringUtils.isEmpty(statisticsFlag) || "1".equals(statisticsFlag)){
            size = odsInventoryInfoDtlDAO.searchOdsInventoryInfosCount(dto);
        } else if ("2".equals(statisticsFlag)){
            size = odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfosCount(dto);
        } else if ("3".equals(statisticsFlag)){
            size = odsInventoryInfoDtlDAO.searchOdsInventoryBinInfosCount(dto);
        }
        return size;
	}

    /* (非 Javadoc) 
    * <p>Title: updateStocktakingDiffStatus</p> 
    * <p>Description: </p> 
    * @param id
    * @param processFlag 
    * @see com.haier.hevwms.inventory.service.OdsInventoryInfoService#updateStocktakingDiffStatus(java.lang.String, java.lang.String) 
    */
    @Override
    public void updateStocktakingDiffStatus(String id, String processFlag) {
        odsPdDiffDtlDAO.updateProcessFlag(id,processFlag);
    }

    public OdsInventoryInfoDtlDAO getOdsInventoryInfoDtlDAO() {
        return odsInventoryInfoDtlDAO;
    }

    public void setOdsInventoryInfoDtlDAO( OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO) {
        this.odsInventoryInfoDtlDAO = odsInventoryInfoDtlDAO;
    }

    public OdsBarcodeHistoryDAO getOdsBarcodeHistoryDAO() {
        return odsBarcodeHistoryDAO;
    }

    public void setOdsBarcodeHistoryDAO(OdsBarcodeHistoryDAO odsBarcodeHistoryDAO) {
        this.odsBarcodeHistoryDAO = odsBarcodeHistoryDAO;
    }

    public OdsPdDiffDtlDAO getOdsPdDiffDtlDAO() {
        return odsPdDiffDtlDAO;
    }

    public void setOdsPdDiffDtlDAO(OdsPdDiffDtlDAO odsPdDiffDtlDAO) {
        this.odsPdDiffDtlDAO = odsPdDiffDtlDAO;
    }

	public MdMatInfoDAO getMdMatInfoDAO() {
		return mdMatInfoDAO;
	}

	public void setMdMatInfoDAO(MdMatInfoDAO mdMatInfoDAO) {
		this.mdMatInfoDAO = mdMatInfoDAO;
	}

	public CdLocInfoDAO getCdLocInfoDAO() {
		return cdLocInfoDAO;
	}

	public void setCdLocInfoDAO(CdLocInfoDAO cdLocInfoDAO) {
		this.cdLocInfoDAO = cdLocInfoDAO;
	}

}
