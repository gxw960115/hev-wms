package com.haier.openplatform.wms.dictionary.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;

/**
 * 
* @ClassName: MdDictionaryServiceClient
* @Description: 字典维护相关操作dubbo接口
*
 */
public interface MdDictionaryServiceClient {
	
	/**
	 * 
	* @Title: getDictionaryMtData
	* @Description: 字典维护查询数据
	* @param @param type
	* @param @param typeDes
	* @param @return
	* @return JSONObject
	* @throws
	 */
	public Pager<MdDictionaryDTO> getMdDictionarys(Pager<MdDictionaryDTO> pager,MdDictionaryDTO mdDictionary);

	/** 
	* @Title: getAllMdDictionarys 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param mdDictionaryDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<MdDictionaryDTO>    返回类型 
	* @throws 
	*/
	public Pager<MdDictionaryDTO> getAllMdDictionarys(Long page, Long rows,MdDictionaryDTO mdDictionaryDTO);
	
	/** 
	* @Title: deleteDictionarys 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"idList"})
	public String deleteDictionarys(List<Long> idList);

	/** 
	* @Title: deleteMdDictionarys 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param idList    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return void    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"idList"})
	public void deleteMdDictionarys(List<Long> idList);
	
	/**
	 * 
	* @Title: addMdDictionarys
	* @Description: 添加字典维护数据
	* @param @param json
	* @return void
	* @throws
	 */
	@Export(paramNames = {"mdDictionaryDTO"})
	public String addMdDictionarys(MdDictionaryDTO mdDictionaryDTO);
	
	/**
	 * 
	* @Title: updateMdDictionary
	* @Description: 更新字典维护数据
	* @param @param json
	* @return void
	* @throws
	 */
	@Export(paramNames = {"mdDictionaryDTO"})
	public String updateMdDictionary(MdDictionaryDTO mdDictionaryDTO);

    /** 
    * @Title: searchAllDictionInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<MdDictionaryDTO>    返回类型 
    * @throws 
    */
    public List<MdDictionaryDTO> searchAllDictionInfo();

    /** 
    * @Title: searchAllDictionInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param type
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<MdDictionaryDTO>    返回类型 
    * @throws 
    */
    List<MdDictionaryDTO> searchAllDictionInfo(String type);
    
    
    /**
    * @Title: findDivisions
    * @Description: 
    * add by Linzx@20151112
    * 返回表MD_DICTIONARY所有的kind_code=division的值
    * @param @return
    * @return List<MdDictionaryDTO>
    * @throws
    */
    List<MdDictionaryDTO> findDivisions();

	/** 
	* @Title: findAllKindType 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<MdDictionaryDTO>    返回类型 
	* @throws 
	*/
	public List<MdDictionaryDTO> findAllKindType();

}
