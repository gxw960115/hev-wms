package com.haier.openplatform.wms.dictionary.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.haier.hevwms.basic.domain.MdDictionary;
import com.haier.hevwms.basic.service.MdDictionaryService;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient;

/**
 * 
 * @ClassName: MdDictionaryServiceClientImpl
 * @Description: 字典维护接口实现类
 * 
 */

public class MdDictionaryServiceClientImpl implements MdDictionaryServiceClient {
    /**
     * 注入字典维护的service类;
     */
    private MdDictionaryService mdDictionaryService;

    /**
     * @Description: 属性 mdDictionaryService 的get方法
     * @return mdDictionaryService
     */
    public MdDictionaryService getMdDictionaryService() {
        return mdDictionaryService;
    }

    /**
     * @Description: 属性 mdDictionaryService 的set方法 mdDictionaryService
     */
    public void setMdDictionaryService(MdDictionaryService mdDictionaryService) {
        this.mdDictionaryService = mdDictionaryService;
    }

    
    /**
     * 
     * <p>Title: getMdDictionarys</p>
     * <p>Description: 得到所有字典信息并分页</p>
     * @param pager
     * @param mdDictionary
     * @return
     * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#getMdDictionarys(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO)
     */
     @Override
    public Pager<MdDictionaryDTO> getMdDictionarys(
            Pager<MdDictionaryDTO> pager, MdDictionaryDTO mdDictionary) {
    	return mdDictionaryService.searchMdDictionarys(pager, mdDictionary);
    }

    /* (非 Javadoc) 
    * <p>Title: getAllMdDictionarys</p> 
    * <p>Description: </p> 
    * @param page
    * @param rows
    * @param mdDictionary
    * @return 
    * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#getAllMdDictionarys(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO) 
    */
    @Override
    public Pager<MdDictionaryDTO> getAllMdDictionarys(
    		Long page,   Long rows, MdDictionaryDTO mdDictionary) {
    	return mdDictionaryService.searchAllMdDictionarys(page,rows, mdDictionary);
    }

    @Override
    /**
     * 
     * <p>Title: addMdDictionarys</p>
     * <p>Description: 添加字典信息</p>
     * @param mdDictionary
     * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#addMdDictionarys(com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO)
     */
    public String addMdDictionarys(MdDictionaryDTO mdDictionary) {
        //检测code、name是否已存在
        String code=mdDictionary.getCode();
        String name=mdDictionary.getName();
        List<MdDictionary> list=mdDictionaryService.getDictionaryByCodeOrName(code,name);
    	if(list.size()>0){
    	    return "Save Fail,the "+code+" or "+name+" must be unique";
    	}
        ExecuteResult<MdDictionary> executeResult = mdDictionaryService.createMdDictionary(mdDictionary);
		if(!executeResult.isSuccess()){
			code  = executeResult.getResult().getCode();
			return code + " Save Fail";
		}else{
			return "Success";
		}
    	
    }

    /**
     * 
     * <p>Title: updateMdDictionary</p>
     * <p>Description: 修改字典信息</p>
     * @param mdDictionary
     * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#updateMdDictionary(com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO)
     */
    @Override
    public String updateMdDictionary(MdDictionaryDTO mdDictionary) {
        String code=mdDictionary.getCode();
        String name=mdDictionary.getName();
        long id=mdDictionary.getId();
        List<MdDictionary> list=mdDictionaryService.getIfCodeOrNameExist(code,name,id);
        if(list.size()>0){
            return "update Fail,the "+code+" or "+name+" must be unique";
        }
    	 ExecuteResult<MdDictionary> executeResult = mdDictionaryService.updateMdDictionary(mdDictionary);
    	 if(!executeResult.isSuccess()){
    		 return "Fail";
    	 }else{
    		 return "Success";
    	 }
    }

    /* (非 Javadoc) 
    * <p>Title: deleteDictionarys</p> 
    * <p>Description: </p> 
    * @param idList
    * @return 
    * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#deleteDictionarys(java.util.List) 
    */
    @Override
    public String deleteDictionarys(List<Long> idList) {
    	return mdDictionaryService.deleteDictionarys(idList);
    }
    
    /**
     * 
     * <p>Title: deleteMdDictionarys</p>
     * <p>Description:删除多条字典信息 </p>
     * @param idList
     * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#deleteMdDictionarys(java.util.List)
     */
    @Override
    public void deleteMdDictionarys(List<Long> idList) {
    	mdDictionaryService.deleteMdDictionaryAll(idList);
    }

    /**
    * <p>Title: searchAllDictionInfo</p>
    * <p>Description:查询数据字典 </p>
    * @param type
    * @return
    * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#searchAllDictionInfo(java.lang.String)
    */
    @Override
    public List<MdDictionaryDTO> searchAllDictionInfo(String type) {
        List<MdDictionary> list = mdDictionaryService.findAllKind(type);
        List<MdDictionaryDTO> row = new ArrayList<MdDictionaryDTO>();
        if (list.size() > 0) {
            for (MdDictionary md : list) {
                MdDictionaryDTO mdt = new MdDictionaryDTO();
                try {
                    BeanUtilEx.copyProperties(mdt, md);
                    row.add(mdt);
                } catch (InvocationTargetException e) {

                    e.printStackTrace();
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                }
            }

        }
        return row;
    }
    
    /* (非 Javadoc) 
    * <p>Title: searchAllDictionInfo</p> 
    * <p>Description: </p> 
    * @return 
    * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#searchAllDictionInfo() 
    */
    @Override
    public List<MdDictionaryDTO> searchAllDictionInfo() {
        //  Auto-generated method stub
        return null;
    }
    
    /**
     * <p>Title: findDivisions</p>
     * <p>Description: 
     * add by Linzx@20151112
     * 返回表MD_DICTIONARY所有的kind_code=division的值
     * </p>
     * @return
     * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#findDivisions()
     */
     @Override
     public List<MdDictionaryDTO> findDivisions() {
         List<MdDictionary> temp=mdDictionaryService.findAll("division");
         List<MdDictionaryDTO> list=new ArrayList<MdDictionaryDTO>();//该函数的返回值
         for(MdDictionary md:temp) {
             MdDictionaryDTO dto=new MdDictionaryDTO();
             try {
                 BeanUtils.copyProperties(dto, md);
             } catch (IllegalAccessException e) {
                 
                 e.printStackTrace();
             } catch (InvocationTargetException e) {
                 
                 e.printStackTrace();
             }
             list.add(dto);
         }
         return list;
     }

	/* (non-Javadoc) 查询所有的有效类型
	 * @see com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient#findAllKindType()
	 */
	@Override
	public List<MdDictionaryDTO> findAllKindType() {
		List<MdDictionary> temp = mdDictionaryService.findAllKindType();
		List<MdDictionaryDTO> list = new ArrayList<MdDictionaryDTO>();//该函数的返回值
		for(MdDictionary md : temp){
			 MdDictionaryDTO dto=new MdDictionaryDTO();
			 try {
				BeanUtils.copyProperties(dto, md);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			 list.add(dto);
		}
		return list;
	}

}