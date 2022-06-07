package com.haier.hevwms.basic.service;

import io.terminus.pampas.common.BaseUser;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;

public interface MdMatInfoService {
    /**
     * 创建物料信息
     * 
     * @param mdMatInfo
     * @return
     */
    public String createMdMatInfo(MdMatInfoDTO mdMatInfo);

    /**
     * 更新物料信息
     * 
     * @param mdMatInfo
     * @return
     */
    public String updateMdMatInfo(MdMatInfoDTO mdMatInfo);

    /**
     * 通过id删除物料信息
     * 
     * @param mdMatInfo
     * @return
     */
    public ExecuteResult<MdMatInfoDTO> deleteMdMatInfo(Long mdMatInfoId);

    /**
     * 删除所有物料信息
     * 
     * @param mdMatInfo
     * @return
     */
    public String deleteMdMatInfoAll(List<Long> idList);

    /**
     * 查询物料信息
     * 
     * @param mdMatInfo
     * @return
     */
    public Pager<MdMatInfoDTO> searchMdMatInfos(Pager<MdMatInfoDTO> pager,
            MdMatInfoDTO mdMatInfo);

    public MdMatInfoDTO getMdMatInfoById(Long mdMatInfoId);

    public List<MdMatInfoDTO> getMdMatInfos();

    /**
     * 查询导出
     * 
     * @param mdMatInfo
     * @return
     */
    public List<MdMatInfoDTO> getMdMatInfoByParam(MdMatInfoDTO mdMatInfo);

    /**
     * excel 导入
     * 
     * @param mdMatInfo
     */
    public String saveOrUpdate(List<MdMatInfoDTO> mdMatInfos, BaseUser user);
    

}
