package com.haier.hevwms.basic.service;

import java.util.List;

import com.haier.hevwms.basic.domain.CdLocInfo;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;

import io.terminus.pampas.common.BaseUser;

public interface CdLocInfoService {
    /**
     * 方法描述：创建 库存地点信息
     *
     * @param dto
     * @return
     */
    public String createCdLocInfo(CdLocInfoDTO dto);

    /**
     * 方法描述： 修改 库存地点信息
     *
     * @param cdLocInfo
     * @return
     */
    public String updateCdLocInfo(CdLocInfoDTO cdLocInfo);

    /**
     * 方法描述：删除库存地点信息 单条
     *
     * @param cdLocInfoId
     * @return
     */
    public ExecuteResult<CdLocInfoDTO> deleteCdLocInfo(Long cdLocInfoId);

    /**
     * 方法描述：删除库存地点信息 多条
     *
     * @param idList
     * @return
     */
    public String deleteCdLocInfoAll(List<Long> idList);

    /**
     * @discription
     * @author fanrong bu
     * @date 2015-11-26
     */
    public String updateFlag(List<Long> idList);

    /**
     * 方法描述： 分页查询
     *
     * @param pager
     * @param cdLocInfo
     * @return
     */
    public Pager<CdLocInfoDTO> searchCdLocInfos(Pager<CdLocInfoDTO> pager, CdLocInfoDTO cdLocInfo);


    /**
     * @discription 查询库存地点
     * @author fanrong bu
     * @date 2015-11-25
     */
    public Pager<CdLocInfoDTO> searchCdLocInfoByCondition(Long rows, Long page, CdLocInfoDTO cdLocInfo);

    /**
     * @discription 查询库存地点
     * @author fanrong bu
     * @date 2015-11-25
     */
    public List<CdLocInfoDTO> searchCdLocInfoByConditionBc();

    /**
     * 方法描述：获取单条记录
     *
     * @param cdLocInfoId
     * @return
     */
    public CdLocInfoDTO getCdLocInfoById(Long cdLocInfoId);

    /**
     * 方法描述：返回全部数据 不分页
     *
     * @param
     * @return
     */
    public List<CdLocInfoDTO> getCdLocInfos();

    /**
     * 方法描述：根据 父id  查询  库存地点 列表 或者 父id  为空的
     *
     * @param parentId
     * @return
     */
    public List<CdLocInfoDTO> getCdLocInfosByParentId(Long parentId);

    public List<CdLocInfoDTO> findCdLocInfosByWarehouse(String whCode);

    /**
     * 方法描述：参数描述：返回值描述
     *
     * @param
     * @return
     */
    public List<CdLocInfoDTO> getCdTreeByParentId(Long parentId, String locType);

    /**
     * 方法描述：根据参数返回 需要的数据
     *
     * @param
     * @return
     */
    public List<CdLocInfoDTO> findCdLocByCityName(CdLocInfoDTO cdLocInfo);

    /**
     * 导入excel
     *
     * @param obj
     */
    public void saveOrUpdate(CdLocInfoDTO obj);

    /**
     * @discription 导入仓库地点
     * @author fanrong bu
     * @date 2015-11-26
     */
    public String saveOrUpdate2(List<CdLocInfoDTO> list, BaseUser user);


    public List<CdLocInfoDTO> selectCdLocTree(long parentId, String locType);

    /**
     * @param parentId
     * @return List<CdLocInfoDTO>
     * @throws
     * @Title: selectPhysicalLocTree
     * @Description: 获取某个仓库下所有的实体库位。盘点单和移库单只能选择这些库位
     * @author zhangll
     */
    public List<CdLocInfoDTO> selectPhysicalLocTree(long parentId);

    public List<CdLocInfoDTO> selectCdLocTreeWithType(CdLocInfoDTO cdLocInfoDTO);

    public List<CdLocInfoDTO> selectCdLocTreeWithLocation(CdLocInfoDTO cdLocInfoDTO);

    public List<CdLocInfoDTO> getCdLocInfoListByCode(String codes);

    /**
     * 获取location,作为页面Location查询条件
     *
     * @return
     * @author LJZ
     */
    List<CdLocInfoDTO> getCdLocInfoManyColumn(CdLocInfoDTO dto);
}
