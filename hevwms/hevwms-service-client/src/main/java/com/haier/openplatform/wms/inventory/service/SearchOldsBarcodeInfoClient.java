package com.haier.openplatform.wms.inventory.service;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;

/**
 * @ClassName: SearchOldsBarcodeInfoClient
 * @Description:条码历史信息的dubbo接口
 * 
 */
public interface SearchOldsBarcodeInfoClient {

    /**
     * @Title: SearchOdsInventoryInfo
     * @Description:条码历史查询方法
     * @param @param pager
     * @param @param odsBarcodeHistoryDTO
     * @param @return
     * @return Pager<OdsBarcodeHistoryDTO>
     * @throws
     */
    public Pager<OdsBarcodeHistoryDTO> searchOdsBarcodeInfo(
            Pager<OdsBarcodeHistoryDTO> pager,
            OdsBarcodeHistoryDTO odsBarcodeHistoryDTO);

    /** 
    * @Title: getOdsBarcodeInfoByParams 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<OdsBarcodeHistoryDTO>    返回类型 
    * @throws 
    */
    public List<OdsBarcodeHistoryDTO> getOdsBarcodeInfoByParams(
            OdsBarcodeHistoryDTO dto);

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
	public Long getExportAmount(OdsBarcodeHistoryDTO dto);

}
