package com.haier.hevwms.basic.service.impl;

import java.util.Date;
import java.util.List;

import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.basic.dao.CdWhInfoDAO;
import com.haier.hevwms.basic.service.CdLocInfoService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

/**
 * @author liujiazhen
 * @description 增加类注释
 */

public class CdLocInfoServiceImpl implements CdLocInfoService {
    private CdLocInfoDAO cdLocInfoDAO;
    private CdWhInfoDAO cdWhInfoDAO;

    public void setCdLocInfoDAO(CdLocInfoDAO cdLocInfoDAO) {
        this.cdLocInfoDAO = cdLocInfoDAO;
    }

    public CdLocInfoDAO getCdLocInfoDAO() {
        return cdLocInfoDAO;
    }

    public CdWhInfoDAO getCdWhInfoDAO() {
        return cdWhInfoDAO;
    }

    public void setCdWhInfoDAO(CdWhInfoDAO cdWhInfoDAO) {
        this.cdWhInfoDAO = cdWhInfoDAO;
    }

    @Override
    public List<CdLocInfoDTO> getCdLocInfosByParentId(Long parentId) {
        List<CdLocInfoDTO> allList = cdLocInfoDAO.getCdLocInfosByParentIdIsNull(parentId);
        List<CdLocInfoDTO> list = cdLocInfoDAO.getCdLocInfosByParentIdNotnull(parentId, "");
        for (CdLocInfoDTO cdLocInfo : list) {
            cdLocInfo.setChecked(true);
        }
        allList.addAll(list);
        return allList;
    }

    @Override
    public void saveOrUpdate(CdLocInfoDTO obj) {
        CdWhInfoDTO cdInfo = new CdWhInfoDTO();
        cdInfo.setCode(obj.getWhCode());
        CdWhInfoDTO cdWhInfo = cdWhInfoDAO.searchCdWh(cdInfo);
        if (cdWhInfo == null) {
            obj.setParentId(null);
        } else {
            obj.setParentId(cdWhInfo.getRowId());
        }
        CdLocInfoDTO cdLocInfo = cdLocInfoDAO.searchCdLocation(obj);
        if (cdLocInfo != null) {
            cdLocInfo.setCode(obj.getCode());
            cdLocInfo.setName(obj.getName());
            cdLocInfo.setParentId(obj.getParentId());
            cdLocInfo.setRemark(obj.getRemark());
            cdLocInfo.setLocationType(obj.getLocationType());
            cdLocInfoDAO.update(cdLocInfo);
        } else {
            cdLocInfoDAO.save(obj);
        }
    }

    /**
     * @discription 导入
     * @author fanrong bu
     * @date 2015-11-25
     */
    @Override
    public String saveOrUpdate2(List<CdLocInfoDTO> list, BaseUser user) {
        int failsize = 0;
        int updatesize = 0;
        int addsize = 0;
        String userName = user.getName();
        for (CdLocInfoDTO obj : list) {
            CdWhInfoDTO cdInfo = new CdWhInfoDTO();
            cdInfo.setCode(obj.getWhCode());
            CdWhInfoDTO cdWhInfo = cdWhInfoDAO.searchCdWhByCode(cdInfo);
            //如果查到记录，就将父id 置为仓库rowId，否则置为空
            if (cdWhInfo == null) {
                obj.setParentId(null);
            } else {
                obj.setParentId(cdWhInfo.getRowId());
            }
            CdLocInfoDTO cdLocInfo = cdLocInfoDAO.searchCdLocByCode(obj);
            try {
                //存在记录就更新该记录
                if (cdLocInfo != null) {
                    cdLocInfo.setModifyBy(userName);
                    cdLocInfo.setModifyDate(new Date());
                    cdLocInfo.setCode(obj.getCode());
                    cdLocInfo.setName(obj.getName());
                    cdLocInfo.setParentId(obj.getParentId());
                    cdLocInfo.setRemark(obj.getRemark());
                    cdLocInfo.setLocationType(obj.getLocationType());
                    cdLocInfoDAO.update(cdLocInfo);
                    updatesize++;
                } else {
                    obj.setCreateBy(userName);
                    obj.setCreateDate(new Date());
                    //否则 新增
                    cdLocInfoDAO.save(obj);
                    addsize++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                failsize++;
            }
        }
        return "Import Success;Add Size:"
                + addsize + ",Update Size:" + updatesize + ",Failure Size:"
                + failsize;
    }

    @Override
    public List<CdLocInfoDTO> findCdLocByCityName(CdLocInfoDTO cdLocInfo) {
        return cdLocInfoDAO.findCdLocByCityName(cdLocInfo);
    }

    @Override
    public List<CdLocInfoDTO> getCdTreeByParentId(Long parentId, String locType) {
        return cdLocInfoDAO.getCdLocInfosByParentIdNotnull(parentId, locType);
    }

    /**
     * <p>Title: createCdLocInfo</p>
     * <p>Description: </p>
     *
     * @param dto
     * @return
     */
    @Override
    public String createCdLocInfo(CdLocInfoDTO dto) {
        try {
            String userName = UserUtil.getCurrentUser().getName();
            dto.setCreateBy(userName);
            dto.setModifyBy(userName);
            Date date = new Date();
            dto.setCreateDate(date);
            dto.setModifyDate(date);
            cdLocInfoDAO.save(dto);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    /**
     * <p>Title: updateCdLocInfo</p>
     * <p>Description: </p>
     *
     * @param cdLocInfo
     * @return
     */
    @Override
    public String updateCdLocInfo(CdLocInfoDTO cdLocInfo) {
        try {
            cdLocInfo.setModifyBy(UserUtil.getCurrentUser().getName());
            cdLocInfo.setModifyDate(new Date());
            cdLocInfoDAO.updateById(cdLocInfo);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    /**
     * <p>Title: deleteCdLocInfo</p>
     * <p>Description: </p>
     *
     * @param cdLocInfoId
     * @return
     */
    @Override
    public ExecuteResult<CdLocInfoDTO> deleteCdLocInfo(Long cdLocInfoId) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * <p>Title: deleteCdLocInfoAll</p>
     * <p>Description: </p>
     *
     * @param idList
     * @return
     */
    @Override
    public String updateFlag(List<Long> idList) {
        try {
            cdLocInfoDAO.updateFlag(idList);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @Override
    public Pager<CdLocInfoDTO> searchCdLocInfos(Pager<CdLocInfoDTO> pager, CdLocInfoDTO cdLocInfo) {
        List<CdLocInfoDTO> list = cdLocInfoDAO.searchCdLocInfos(pager, cdLocInfo);
        long size = cdLocInfoDAO.searchCdLocInfosCount(cdLocInfo);
        return Pager.cloneFromPager(pager, size, list);
    }

    /**
     * 查询库存地点
     */
    @Override
    public Pager<CdLocInfoDTO> searchCdLocInfoByCondition(Long rows, Long page, CdLocInfoDTO cdLocInfo) {
        Pager<CdLocInfoDTO> pager = new Pager<CdLocInfoDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        List<CdLocInfoDTO> list = cdLocInfoDAO.searchCdLocInfos(pager, cdLocInfo);
        long size = cdLocInfoDAO.searchCdLocInfosCount(cdLocInfo);
        return Pager.cloneFromPager(pager, size, list);

    }

    @Override
    public List<CdLocInfoDTO> searchCdLocInfoByConditionBc() {
        return cdLocInfoDAO.searchCdLocInfo();
    }

    @Override
    public CdLocInfoDTO getCdLocInfoById(Long cdLocInfoId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CdLocInfoDTO> getCdLocInfos() {
        return cdLocInfoDAO.getAll();
    }

    @Override
    public List<CdLocInfoDTO> selectCdLocTree(long parentId, String locType) {
        List<CdLocInfoDTO> temp = cdLocInfoDAO.searchCdLocationTree(parentId, locType);
        return temp;
    }

    @Override
    public List<CdLocInfoDTO> selectCdLocTreeWithType(CdLocInfoDTO cdLocInfoDTO) {
        return cdLocInfoDAO.searchCdLocationTreeWithType(cdLocInfoDTO);
    }

    @Override
    public List<CdLocInfoDTO> selectCdLocTreeWithLocation(CdLocInfoDTO cdLocInfoDTO) {
        return cdLocInfoDAO.searchCdLocationTreeWithLocation(cdLocInfoDTO);
    }

    @Override
    public List<CdLocInfoDTO> getCdLocInfoListByCode(String codes) {
        return cdLocInfoDAO.getCdLocInfoListByCode(codes);
    }

    @Override
    public String deleteCdLocInfoAll(List<Long> idList) {
        try {
            cdLocInfoDAO.deleteAll(idList);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

    @Override
    public List<CdLocInfoDTO> findCdLocInfosByWarehouse(String whCode) {
        return cdLocInfoDAO.findCdLocByWarehouse(whCode);
    }

    @Override
    public List<CdLocInfoDTO> selectPhysicalLocTree(long parentId) {
        List<CdLocInfoDTO> temp = cdLocInfoDAO.searchCdLocationTree(parentId, "");
        return temp;
    }

    @Override
    public List<CdLocInfoDTO> getCdLocInfoManyColumn(CdLocInfoDTO dto) {
        return cdLocInfoDAO.getCdLocInfoManyColumn(dto);
    }
}
