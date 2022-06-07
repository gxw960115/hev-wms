package com.haier.openplatform.wms.stocktaking.service;

import java.util.List;

import io.terminus.pampas.client.Export;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;

public interface StocktakingDiffServiceClient {

    /** 
    * @Title: searchStocktakingDiff 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param page
    * @param @param rows
    * @param @param odsPdDiffDtlDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<OdsPdDiffDtlDTO>    返回类型 
    * @throws 
    */
    public Pager<OdsPdDiffDtlDTO> searchStocktakingDiff(long page,long rows,OdsPdDiffDtlDTO odsPdDiffDtlDTO);
    
    /** 
    * @Title: processDiff 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param ids
    * @param @param processFlag
    * @param @param processReason
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"ids","processFlag","processReason"})
    public String processDiff(String ids,String processFlag,String processReason);
    
    
    /**
    * @Title: getOdsPdDiffInfo
    * @Description: 页面导出时用到的查询 @20151114
    * @param @param odsPdDiffDtlDTO
    * @param @return
    * @return List<OdsPdDiffDtlDTO>
    * @throws
    */
    public List<OdsPdDiffDtlDTO> getOdsPdDiffInfo(
            OdsPdDiffDtlDTO odsPdDiffDtlDTO);

	/** 
	* @Title: searchOdsPdDiffDtlsCount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long searchOdsPdDiffDtlsCount(OdsPdDiffDtlDTO dto);

	/** 
	* @Title: lockAndUnlock 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param ids
	* @param @param processFlag
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String lockAndUnlock(String ids, String processFlag);
}
