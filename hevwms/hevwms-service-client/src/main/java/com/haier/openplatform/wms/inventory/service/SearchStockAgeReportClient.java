package com.haier.openplatform.wms.inventory.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

public interface SearchStockAgeReportClient {

    /**
     * @Title: getStockAgeReport
     * @Description: 库存报表详情 (这里用一句话描述这个类的作用)
     * @param @param pager
     * @param @param dto
     * @param @return
     * @return Pager<OdsInventoryInfoDtlDTO>
     * @throws
     */
    public Pager<OdsInventoryInfoDtlDTO> getStockAgeReport(
            Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO dto);

    /** 
    * @Title: getInventoryInfoDtlByParams 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<OdsInventoryInfoDtlDTO>    返回类型 
    * @throws 
    */
    public List<OdsInventoryInfoDtlDTO> getInventoryInfoDtlByParams(
            OdsInventoryInfoDtlDTO dto);
    /**
     * 
    * @Title: sapQtyDetail
    * @Description:  (这里用一句话描述这个类的作用)
    * @param @param pager
    * @param @param dto
    * @param @return
    * @return Pager<OdsInventoryInfoDtlDTO>
    * @throws
     */
    public Pager<OdsInventoryInfoDtlDTO> sapQtyDetail(
            Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO dto);
    
  	/** 
  	* @Title: barcodeRemarkUpdate 
  	* @Description: TODO(这里用一句话描述这个方法的作用) 
  	* @param @param odsInventoryInfoDtlDTO
  	* @param @return    设定文件 
  	* @author SJK
  	* @date 2019年3月18日
  	* @return String    返回类型 
  	* @throws 
  	*/
  	@Export(paramNames={"odsInventoryInfoDtlDTO"})
  	public String barcodeRemarkUpdate(OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);
  	
  	/** 
  	* @Title: updateBarcodeStatus 
  	* @Description: TODO(这里用一句话描述这个方法的作用) 
  	* @param @param list
  	* @param @param status    设定文件 
  	* @author SJK
  	* @date 2019年3月18日
  	* @return void    返回类型 
  	* @throws 
  	*/
  	public void updateBarcodeStatus(List<OdsInventoryInfoDtlDTO> list,String status);
  	
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
	public Long getExportAmount(OdsInventoryInfoDtlDTO dto);
    
}
