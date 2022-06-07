package com.haier.openplatform.wms.inventory.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.StgSapStockDTO;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;

/**
 * @Company 青鸟软通
 * @Title:SAP库存查询
 * @Package com.haier.openplatform.wms.inventory.service;
 * @author sunhaoyu
 * @date 2015/10/29
 * @version V1.0
 */
public interface StgSapStockServiceClient {

    /** 
    * @Title: searchStgSapStockInfo 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<StgSapStockDTO>    返回类型 
    * @throws 
    */
    public Pager<StgSapStockDTO> searchStgSapStockInfo(Pager<StgSapStockDTO> pager,
            StgSapStockDTO dto);

    /** 
    * @Title: getStgSapInfoInfoByParams 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<StgSapStockDTO>    返回类型 
    * @throws 
    */
    public List<StgSapStockDTO> getStgSapInfoInfoByParams(StgSapStockDTO dto);

    /** 
    * @Title: downInventoryFromSap 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param plant
    * @param @param locations
    * @param @param userName
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return InterfaceOutDTO    返回类型 
    * @throws 
    */
    public InterfaceOutDTO downInventoryFromSap(String plant, String locations, String userName);
    
    /** 
    * @Title: searchActualStockGap 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<StgSapStockDTO>    返回类型 
    * @throws 
    */
    public Pager<StgSapStockDTO> searchActualStockGap(Pager<StgSapStockDTO> pager, StgSapStockDTO dto);
    
    /** 
    * @Title: searchActualStockGapList 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<StgSapStockDTO>    返回类型 
    * @throws 
    */
    public List<StgSapStockDTO> searchActualStockGapList(StgSapStockDTO dto);

    /** 
    * @Title: downAllInventoryFromSap 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param     设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return void    返回类型 
    * @throws 
    */
    public void downAllInventoryFromSap();

	/** 
	* @Title: getExportAmount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long getExportAmount(StgSapStockDTO dto);
}
