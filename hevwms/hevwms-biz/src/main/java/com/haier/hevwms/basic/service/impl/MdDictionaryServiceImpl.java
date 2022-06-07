package com.haier.hevwms.basic.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.haier.hevwms.basic.dao.MdDictionaryDAO;
import com.haier.hevwms.basic.domain.MdDictionary;
import com.haier.hevwms.basic.service.MdDictionaryService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;

/**
 * @author liujiazhen
 * @ClassName: MdDictionaryServiceImpl
 * @Description: 字典维护service实现类，实现字典操作接口
 */

public class MdDictionaryServiceImpl implements MdDictionaryService {
    /**
     * 注入字典维护的dao
     */
    private MdDictionaryDAO mdDictionaryDAO;

    /**
     * @return mdDictionaryDAO
     * @Description: 属性 mdDictionaryDAO 的get方法
     */
    public MdDictionaryDAO getMdDictionaryDAO() {
        return mdDictionaryDAO;
    }

    /**
     * 属性 mdDictionaryDAO 的set方法 mdDictionaryDAO
     */
    public void setMdDictionaryDAO(MdDictionaryDAO mdDictionaryDAO) {
        this.mdDictionaryDAO = mdDictionaryDAO;
    }

    /**
     * <p>Title: createMdDictionary</p>
     * <p>Description:添加字典维护信息 </p>
     *
     * @param mdDictionaryDTO
     * @return
     */
    @Override
    public ExecuteResult<MdDictionary> createMdDictionary(MdDictionaryDTO mdDictionaryDTO) {
        ExecuteResult<MdDictionary> executeResult = new ExecuteResult<MdDictionary>();

        MdDictionary mdDictionary = new MdDictionary();
        try {
            BeanUtils.copyProperties(mdDictionary, mdDictionaryDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        mdDictionaryDAO.save(mdDictionary);
        executeResult.setResult(mdDictionary);
        return executeResult;
    }

    /**
     * <p>Title: updateMdDictionary</p>
     * <p>Description: 修改字典维护信息</p>
     *
     * @param mdDictionaryDTO
     * @return
     */
    @Override
    public ExecuteResult<MdDictionary> updateMdDictionary(MdDictionaryDTO mdDictionaryDTO) {
        ExecuteResult<MdDictionary> executeResult = new ExecuteResult<MdDictionary>();
        MdDictionary mdDictionary = new MdDictionary();
        try {
            BeanUtils.copyProperties(mdDictionary, mdDictionaryDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        mdDictionaryDAO.update(mdDictionary);
        executeResult.setResult(mdDictionary);
        return executeResult;
    }

    /**
     * <p>Title: deleteMdDictionary</p>
     * <p>Description: 删除单条字典维护信息</p>
     *
     * @param mdDictionaryId
     * @return
     */
    @Override
    public ExecuteResult<MdDictionary> deleteMdDictionary(Long mdDictionaryId) {
        ExecuteResult<MdDictionary> executeResult = new ExecuteResult<MdDictionary>();
        mdDictionaryDAO.delete(mdDictionaryId);
        return executeResult;
    }

    /**
     * <p>Title: deleteMdDictionaryAll</p>
     * <p>Description:删除多条字典维护信息 </p>
     *
     * @param idList
     * @return
     */
    @Override
    public ExecuteResult<MdDictionary> deleteMdDictionaryAll(List<Long> idList) {
        ExecuteResult<MdDictionary> executeResult = new ExecuteResult<MdDictionary>();
        mdDictionaryDAO.deleteAll(idList);
        return executeResult;
    }

    /**
     * <p>Title: searchMdDictionarys</p>
     * <p>Description:查询字典维护信息 </p>
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public Pager<MdDictionaryDTO> searchAllMdDictionarys(Long page, Long rows, MdDictionaryDTO mdDictionaryDTO) {

        Pager<MdDictionary> pager = new Pager<MdDictionary>();
        pager.setPageSize(rows);
        pager.setCurrentPage(page);

        MdDictionary mdDictionary = new MdDictionary();
        try {
            BeanUtils.copyProperties(mdDictionary, mdDictionaryDTO);
        } catch (IllegalAccessException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        Pager<MdDictionaryDTO> pagerDTO = new Pager<MdDictionaryDTO>();
        List<MdDictionary> mdDictionarysList = mdDictionaryDAO.searchMdDictionarys(pager, mdDictionary);
        long totalSize = mdDictionaryDAO.searchMdDictionarysCount(mdDictionary);
        List<MdDictionaryDTO> mdDictionaryDTOList = new ArrayList<MdDictionaryDTO>();
        for (MdDictionary md : mdDictionarysList) {
            MdDictionaryDTO dto = new MdDictionaryDTO();
            try {
                BeanUtils.copyProperties(dto, md);
                mdDictionaryDTOList.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(mdDictionaryDTOList);
        pagerDTO.setTotalRecords(totalSize);
        // return Pager.cloneFromPager(pDTO, totalSize, mdDictionaryDTOList);
        return pagerDTO;
    }

    @Override
    /**
     * <p>Title: getMdDictionaryById</p>
     * <p>Description:根据id查询一条字典信息 </p>
     * @param mdDictionaryId
     * @return
     */
    public MdDictionary getMdDictionaryById(Long mdDictionaryId) {
        return mdDictionaryDAO.get(mdDictionaryId);
    }

    @Override
    /**
     * <p>Title: getMdDictionarys</p>
     * <p>Description: 得到所有的字典信息</p>
     * @return
     */
    public List<MdDictionary> getMdDictionarys() {
        return mdDictionaryDAO.getAll();
    }

    /**
     * <p>Title: findAllKind</p>
     * <p>Description: 查询所有的type</p>
     *
     * @return
     */
    @Override
    public List<MdDictionary> findAllKind(String type) {
        List<MdDictionary> dictionarys = mdDictionaryDAO.findAll(type);
        return dictionarys;
    }

    /**
     * <p>Title: findAll</p>
     * <p>Description:根据kind_code进行查询，返回所有的值为division的值 </p>
     *
     * @param type
     * @return
     */
    @Override
    public List<MdDictionary> findAll(String type) {
        List<MdDictionary> dictionarys = mdDictionaryDAO.findAll(type);
        return dictionarys;
    }

    /**
     * @return
     * @Title: findAllKindType
     * @Description: 查询类型
     * @version: v1.0.0
     */
    @Override
    public List<MdDictionary> findAllKindType() {
        return mdDictionaryDAO.findAllKind();
    }

    /**
     * @param pager
     * @param mdDictionary
     * @return
     * @Title: searchMdDictionarys
     * @Description:
     * @version: v1.0.0
     */
    @Override
    public Pager<MdDictionaryDTO> searchMdDictionarys(Pager<MdDictionaryDTO> pager, MdDictionaryDTO mdDictionary) {

        return null;
    }

    /**
     * @param idList
     * @return
     * @Title: deleteDictionarys
     * @Description:删除字典信息
     * @version: v1.0.0
     */
    @Override
    public String deleteDictionarys(List<Long> idList) {
        try {
            mdDictionaryDAO.deleteAll(idList);
        } catch (Exception e) {
            return "Fail";
        }
        return "Success";
    }

    /**
     * @param code
     * @param name
     * @return
     * @Title: getDictionaryByCodeOrName
     * @Description:
     * @version: v1.0.0
     */
    @Override
    public List<MdDictionary> getDictionaryByCodeOrName(String code, String name) {
        return mdDictionaryDAO.getDictionaryByCodeOrName(code, name);
    }

    /**
     * @param code
     * @param name
     * @param id
     * @return
     * @Title: getIfCodeOrNameExist
     * @Description:
     * @version: v1.0.0
     */
    @Override
    public List<MdDictionary> getIfCodeOrNameExist(String code, String name, long id) {
        return mdDictionaryDAO.getIfCodeOrNameExist(code, name, id);
    }

}
