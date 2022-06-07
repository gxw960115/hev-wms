package com.haier.openplatform.wms.security.service;

import java.util.List;

import io.terminus.pampas.client.Export;

import com.haier.openplatform.showcase.util.Paging;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.openplatform.wms.security.dto.PlantDTO;

/**
* @ClassName: PlantServiceClient
* @Description: TODO(这里用一句话描述这个类的作用)
* @author linzongxiao
* @Date 2015-10-23 下午2:14:34
*/
public interface PlantServiceClient {
	
	/** 
	* @Title: searchPlantByParams 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param page
	* @param @param rows
	* @param @param plantDTO
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Pager<PlantDTO>    返回类型 
	* @throws 
	*/
	public Pager<PlantDTO> searchPlantByParams(Long page, Long rows, PlantDTO plantDTO);

    /** 
    * @Title: searchPlant 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param page
    * @param @param rows
    * @param @param plantDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<PlantDTO>    返回类型 
    * @throws 
    */
    public Pager<PlantDTO> searchPlant(Long page, Long rows, PlantDTO plantDTO);

    /** 
    * @Title: addPlant 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param plantDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"plantDTO"})
    public String addPlant(PlantDTO plantDTO);
    /** 
    * @Title: updatePlant 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param plantDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"plantDTO"})
    public String updatePlant(PlantDTO plantDTO);
    /** 
    * @Title: deletePlant 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param rowId
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"rowId"})
    public String deletePlant(String rowId);
    
    /** 
    * @Title: deletePlantsByIds 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids"})
    public String deletePlantsByIds(String ids);
    
    /** 
    * @Title: searchPlantByCodeAndName 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param plantCode
    * @param @param plantName
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Paging<PlantDTO>    返回类型 
    * @throws 
    */
    public Paging<PlantDTO> searchPlantByCodeAndName(String plantCode,String plantName);
  
    /** 
    * @Title: searchAll 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<CdFactoryDTO>    返回类型 
    * @throws 
    */
    List<CdFactoryDTO> searchAll();

}