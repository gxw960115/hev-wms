package com.haier.hevwms.basic.service;

import java.util.List;

import com.haier.hevwms.basic.domain.MdDictionary;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
/**
 * 
* @ClassName: MdDictionaryService
* @Description: 字典维护service接口，实现字典操作相关
*
 */
public interface MdDictionaryService {
    /**
     * 
    * @Title: createMdDictionary
    * @Description: 添加字典信息
    * @param @param mdDictionary
    * @param @return
    * @return ExecuteResult<MdDictionary>
    * @throws
     */
	public ExecuteResult<MdDictionary> createMdDictionary(MdDictionaryDTO mdDictionary);
	/**
	 * 
	* @Title: updateMdDictionary
	* @Description: 更新字典信息
	* @param @param mdDictionary
	* @param @return
	* @return ExecuteResult<MdDictionary>
	* @throws
	 */
	public ExecuteResult<MdDictionary> updateMdDictionary(MdDictionaryDTO mdDictionary);
	/**
	 * 
	* @Title: deleteMdDictionary
	* @Description: 单条删除字典信息
	* @param @param mdDictionaryId
	* @param @return
	* @return ExecuteResult<MdDictionary>
	* @throws
	 */
	public ExecuteResult<MdDictionary> deleteMdDictionary(Long mdDictionaryId);

	/**
	 * 
	* @Title: deleteMdDictionaryAll
	* @Description: 批量删除字典信息
	* @param @param idList
	* @param @return
	* @return ExecuteResult<MdDictionary>
	* @throws
	 */
	public ExecuteResult<MdDictionary> deleteMdDictionaryAll(List<Long> idList);
	
	/**@discription 删除 字典数据
	 * @author fanrong bu
	 * @date 2015-11-24
	 */
	public String deleteDictionarys(List<Long> idList);
	/**
	 * 
	* @Title: searchMdDictionarys
	* @Description: 字典信息查询分页
	* @param @param pager
	* @param @param mdDictionary
	* @param @return
	* @return Pager<MdDictionaryDTO>
	* @throws
	 */
	public Pager<MdDictionaryDTO> searchMdDictionarys(Pager<MdDictionaryDTO> pager,MdDictionaryDTO mdDictionary);
	
	/**@discription查询字典数据
	 * @author fanrong bu
	 * @date 2015-11-23
	 */
	public Pager<MdDictionaryDTO> searchAllMdDictionarys(Long page,   Long rows, MdDictionaryDTO mdDictionary);
	/**
	 * 
	* @Title: getMdDictionaryById
	* @Description: 根据id查询
	* @param @param mdDictionaryId
	* @param @return
	* @return MdDictionary
	* @throws
	 */
	public MdDictionary getMdDictionaryById(Long mdDictionaryId);
	
	/**
	 * 
	* @Title: getMdDictionarys
	* @Description: 查询
	* @param @return
	* @return List<MdDictionary>
	* @throws
	 */
	public List<MdDictionary> getMdDictionarys();

	
	/**
	 * 
	* @Title: findAll
	* @Description: 字典下拉列表
	* @param @param type
	* @param @return
	* @return List<MdDictionary>
	* @throws
	 */
	public List<MdDictionary> findAll(String type);
   
	public List<MdDictionary> findAllKind(String type);
	
	
	/**@discription 查询所有的类型
	 * @author fanrong bu 
	 * @date 2015-11-20
	 */
	public List<MdDictionary> findAllKindType();
	
    public List<MdDictionary> getDictionaryByCodeOrName(String code,String name);
    public List<MdDictionary> getIfCodeOrNameExist(String code,String name,long id);
}
