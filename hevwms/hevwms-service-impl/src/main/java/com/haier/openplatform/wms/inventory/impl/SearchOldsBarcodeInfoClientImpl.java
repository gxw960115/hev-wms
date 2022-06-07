package com.haier.openplatform.wms.inventory.impl;

import java.util.List;

import com.haier.hevwms.inventory.service.OdsBarcodeHistoryService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO;
import com.haier.openplatform.wms.inventory.service.SearchOldsBarcodeInfoClient;

/**
 * @Company 青鸟软通
 * @Title:查询历史条码实现类
 * @Package com.haier.openplatform.wms.inventory
 * @author sunhaoyu
 * @date 2015/10/29
 * @version V1.0
 */
public class SearchOldsBarcodeInfoClientImpl implements SearchOldsBarcodeInfoClient {

    private OdsBarcodeHistoryService odsBarcodeHistoryService;

    /**
     * @Description: 属性 odsBarcodeHistoryService 的get方法
     * @return odsBarcodeHistoryService
     */
    public OdsBarcodeHistoryService getOdsBarcodeHistoryService() {
        return odsBarcodeHistoryService;
    }

    /**
     * @Description: 属性 odsBarcodeHistoryService 的set方法
     * 
     */
    public void setOdsBarcodeHistoryService(
            OdsBarcodeHistoryService odsBarcodeHistoryService) {
        this.odsBarcodeHistoryService = odsBarcodeHistoryService;
    }

    /**
     * Title: SearchOdsInventoryInfo Description:条码历史查询实现方法
     * 
     * @param pager
     * @param odsBarcodeHistoryDTO
     * @return
     */
    @Override
    public Pager<OdsBarcodeHistoryDTO> searchOdsBarcodeInfo(
            Pager<OdsBarcodeHistoryDTO> pager,
            OdsBarcodeHistoryDTO odsBarcodeHistoryDTO) {
        return odsBarcodeHistoryService.searchOdsBarcodeHistorys(pager,
                odsBarcodeHistoryDTO);

    }

    /* (非 Javadoc) 
    * <p>Title: getOdsBarcodeInfoByParams</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.SearchOldsBarcodeInfoClient#getOdsBarcodeInfoByParams(com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO) 
    */
    @Override
    public List<OdsBarcodeHistoryDTO> getOdsBarcodeInfoByParams(
            OdsBarcodeHistoryDTO dto) {
        return odsBarcodeHistoryService.getOdsBarcodeHistoryByParam(dto);
    }

	/* (非 Javadoc) 
	* <p>Title: getExportAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.SearchOldsBarcodeInfoClient#getExportAmount(com.haier.openplatform.wms.inventory.dto.OdsBarcodeHistoryDTO) 
	*/
	@Override
	public Long getExportAmount(OdsBarcodeHistoryDTO dto) {
		return odsBarcodeHistoryService.getExportAmount(dto);
	}

}
