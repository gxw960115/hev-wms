package com.haier.hevwms.basic.service.impl;

import io.terminus.pampas.common.BaseUser;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.basic.service.MdMatInfoService;
import com.haier.hevwms.security.dao.OperationLogDAO;
import com.haier.hevwms.security.domain.OperationLogSaveModel;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

/**
 * @author liujiazhen
 * @ClassName: MdMatInfoServiceImpl
 * @Description: 物料基础数据业务层实现方法
 */
public class MdMatInfoServiceImpl implements MdMatInfoService {
    Logger logger = Logger.getLogger(MdMatInfoServiceImpl.class);
    String flag = "true";
    private MdMatInfoDAO mdMatInfoDAO;
    private OperationLogDAO operationLogDAO;

    /**
     * Title: createMdMatInfo
     * Description:增加物料信息
     *
     * @param mdMatInfo
     * @return
     */
    @Override
    public String createMdMatInfo(MdMatInfoDTO mdMatInfo) {
        try {
            flag = "true";
            MdMatInfoDTO dto = new MdMatInfoDTO();
            dto.setMaterialNo(mdMatInfo.getMaterialNo());
            long matSize = mdMatInfoDAO.checkMdMatExists(dto.getMaterialNo());
            // 物料号存在时，不允许添加 add by孙艳飞
            if (matSize > 0) {
                flag = "This Material No has existed!";
                return flag;
            }
            mdMatInfoDAO.save(mdMatInfo);

        } catch (Exception e) {
            flag = "false";
            return flag;
        }
        return flag;
    }

    /**
     * Title: updateMdMatInfo
     * Description:修改物料信息
     *
     * @param mdMatInfo
     * @return
     */
    @Override
    public String updateMdMatInfo(MdMatInfoDTO mdMatInfo) {
        logger.debug("Entering updateMdMatInfo...");
        flag = "true";
        Date date = new Date();
        MdMatInfoDTO dto = new MdMatInfoDTO();
        dto.setRowId(mdMatInfo.getRowId());
        dto.setMaterialNo(mdMatInfo.getMaterialNo());
        long count = mdMatInfoDAO.getCountByMaterialNoExceptSelf(dto);
        if (count > 0) {
            return "This Material No has existed!";
        }
        mdMatInfo.setModifyDate(date);
        mdMatInfoDAO.updateWithDivisionName(mdMatInfo);
        return flag;
    }

    /**
     * Title: deleteMdMatInfo
     * Description:通过ID删除物料信息
     *
     * @param mdMatInfoId
     * @return
     * @see com.haier.hevwms.basic.service.MdMatInfoService#deleteMdMatInfo(java.lang.Long)
     */
    @Override
    public ExecuteResult<MdMatInfoDTO> deleteMdMatInfo(Long mdMatInfoId) {
        ExecuteResult<MdMatInfoDTO> executeResult = new ExecuteResult<MdMatInfoDTO>();
        mdMatInfoDAO.delete(mdMatInfoId);
        return executeResult;
    }

    /**
     * Title: deleteMdMatInfoAll
     * Description:删除所有物料信息
     *
     * @param idList
     * @return
     * @see com.haier.hevwms.basic.service.MdMatInfoService#deleteMdMatInfoAll(java.util.List)
     */
    @Override
    public String deleteMdMatInfoAll(List<Long> idList) {
        try {
            mdMatInfoDAO.deleteAll(idList);
        } catch (Exception e) {
            flag = "false";
            return flag;
        }
        flag = "true";
        return flag;
    }

    /**
     * Title: searchMdMatInfos
     * Description:查询所有物料信息
     *
     * @param pager
     * @param mdMatInfo
     * @return
     */
    @Override
    public Pager<MdMatInfoDTO> searchMdMatInfos(Pager<MdMatInfoDTO> pager, MdMatInfoDTO mdMatInfo) {

        List<MdMatInfoDTO> mdMatInfos = mdMatInfoDAO.searchMdMatInfos(pager, mdMatInfo);

        long size = mdMatInfoDAO.searchMdMatInfosCount(mdMatInfo);

        return Pager.cloneFromPager(pager, size, mdMatInfos);
    }

    /**
     * Title: getMdMatInfoById
     * Description:通过ID查询物料信息
     *
     * @param mdMatInfoId
     * @return
     */
    @Override
    public MdMatInfoDTO getMdMatInfoById(Long mdMatInfoId) {
        return mdMatInfoDAO.get(mdMatInfoId);
    }

    /**
     * @return
     * @Title: getMdMatInfos
     * @Description:
     * @version: v1.0.0
     * @see com.haier.hevwms.basic.service.MdMatInfoService#getMdMatInfos()
     */
    @Override
    public List<MdMatInfoDTO> getMdMatInfos() {
        return mdMatInfoDAO.getAll();
    }

    /**
     * @param mdMatInfo
     * @return
     * @Title: getMdMatInfoByParam
     * @Description:
     * @version: v1.0.0
     * @see com.haier.hevwms.basic.service.MdMatInfoService#getMdMatInfoByParam(com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO)
     */
    @Override
    public List<MdMatInfoDTO> getMdMatInfoByParam(MdMatInfoDTO mdMatInfo) {
        return mdMatInfoDAO.getMdMatInfoByParam(mdMatInfo);
    }

    /**
     * Title: saveOrUpdate
     * Description:导入信息保存方法
     *
     * @param mdMatInfos
     * @return
     */
    @Override
    public String saveOrUpdate(List<MdMatInfoDTO> mdMatInfos, BaseUser user) {
        logger.debug("Entering saveOrUpdate...");
        int addsize = 0;
        int updatesize = 0;
        int failsize = 0;

        MdMatInfoDTO oldData = new MdMatInfoDTO();
        OperationLogSaveModel log = new OperationLogSaveModel();
        for (MdMatInfoDTO mdMatInfo : mdMatInfos) {
            try {
                MdMatInfoDTO mdInfo = mdMatInfoDAO.getMdMatInfoByMaterialNo(mdMatInfo.getMaterialNo());
                if (mdInfo != null) {
                    BeanUtils.copyProperties(oldData, mdInfo);
                    logger.debug("Update existed material " + mdMatInfo.getMaterialNo());
                    mdInfo.setMaterialDesp(mdMatInfo.getMaterialDesp());
                    mdInfo.setMatScanType(mdMatInfo.getMatScanType());
                    mdInfo.setDivision(mdMatInfo.getDivision());
                    mdInfo.setExternalMatGroup(mdMatInfo.getExternalMatGroup());
                    mdInfo.setRemark(mdMatInfo.getRemark());
                    mdInfo.setActivestate(mdMatInfo.getActivestate());
                    mdInfo.setProduceAttribute(mdMatInfo.getProduceAttribute());
                    mdInfo.setCustomerModel(mdMatInfo.getCustomerModel());
                    mdInfo.setPlant(mdMatInfo.getPlant());
                    mdInfo.setGrossWeight(mdMatInfo.getGrossWeight());
                    mdInfo.setNetWeight(mdMatInfo.getNetWeight());
                    mdInfo.setSizeDimension(mdMatInfo.getSizeDimension());
                    mdInfo.setBasicUnit(mdMatInfo.getBasicUnit());
                    mdInfo.setLength(mdMatInfo.getLength());
                    mdInfo.setWidth(mdMatInfo.getWidth());
                    mdInfo.setHigth(mdMatInfo.getHigth());
                    mdInfo.setMeasureUnit(mdMatInfo.getMeasureUnit());
                    mdInfo.setVolume(mdMatInfo.getVolume());
                    mdInfo.setVolumeUnit(mdMatInfo.getVolumeUnit());
                    mdInfo.setModifyBy(mdMatInfo.getModifyBy());
                    mdInfo.setModifyDate(mdMatInfo.getModifyDate());
                    mdInfo.setMrpCode(mdMatInfo.getMrpCode());
                    mdInfo.setOldMat(mdMatInfo.getOldMat());
                    mdMatInfoDAO.update(mdInfo);
                    log.setAppName("md_mat_info_update");
                    log.setOriginalData(oldData.toString());
                    log.setActualData(mdMatInfo.toString());
                    operationLogDAO.save(log);
                    updatesize++;
                } else {
                    logger.debug("Create new material " + mdMatInfo.getMaterialNo());
                    mdMatInfo.setCreatedBy(mdMatInfo.getModifyBy());
                    mdMatInfo.setCreatedDate(mdMatInfo.getModifyDate());
                    mdMatInfoDAO.save(mdMatInfo);

                    log.setAppName("md_mat_info_create");
                    log.setActualData(mdMatInfo.toString());
                    operationLogDAO.save(log);
                    addsize++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                failsize++;
            }
        }

        String resultMsg = "Success! Total: " + mdMatInfos.size() + ", add: "
                + addsize + ", update: " + updatesize + ", failure: " + failsize;
        logger.debug("Exiting saveOrUpdate with result: " + resultMsg);
        return resultMsg;
    }

    public void setMdMatInfoDAO(MdMatInfoDAO mdMatInfoDAO) {
        this.mdMatInfoDAO = mdMatInfoDAO;
    }

    public MdMatInfoDAO getMdMatInfoDAO() {
        return mdMatInfoDAO;
    }

    /**
     * @return operationLogDAO
     * @Description: 属性 operationLogDAO 的get方法
     */
    public OperationLogDAO getOperationLogDAO() {
        return operationLogDAO;
    }

    /**
     * @Description: 属性 operationLogDAO 的set方法
     * operationLogDAO
     */
    public void setOperationLogDAO(OperationLogDAO operationLogDAO) {
        this.operationLogDAO = operationLogDAO;
    }
}
