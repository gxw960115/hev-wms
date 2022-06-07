package com.haier.openplatform.wms.inventory.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;

import java.util.List;

public interface InventoryInfoServiceClient {

    /**
     * @Title: SearchMdmaInfo
     * @Description: 库存查询的接口
     * @param @param pager
     * @param @param mdMathInfoDTO
     * @param @return
     * @return Pager<MdMatInfoDTO>
     * @throws
     */
    public Pager<OdsInventoryInfoDTO> searchOdsInventoryInfo(
            Pager<OdsInventoryInfoDTO> pager,
            OdsInventoryInfoDTO odsInventoryInfoDTO);

    /**
     * @Title: SearchMdmaInfo
     * @Description: 库存查询的接口
     * @param @param pager
     * @param @param mdMathInfoDTO
     * @param @return
     * @return Pager<MdMatInfoDTO>
     * @throws
     */
    public Pager<OdsInventoryInfoDtlDTO> searchOdsInventoryBinInfo(Pager<OdsInventoryInfoDtlDTO> pager,OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

    /** 
    * @Title: searchOdsInventoryBinList 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param row
    * @param @param page
    * @param @param odsInventoryInfoDtlDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return List<OdsInventoryInfoDtlDTO>    返回类型 
    * @throws 
    */
    public List<OdsInventoryInfoDtlDTO> searchOdsInventoryBinList(long row,long page,OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO);

    /**
     * @Title: getOdsInventoryInfoByParam
     * @Description: 查询导出数据 (这里用一句话描述这个类的作用)
     * @param @param dto
     * @param @return
     * @return List<OdsInventoryInfoDTO>
     * @throws
     */
    public List<OdsInventoryInfoDTO> getInventoryInfoByParams(OdsInventoryInfoDTO dto);

    /** 
    * @Title: wmsQtyDetail 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param pager
    * @param @param odsInventoryInfoDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<OdsInventoryInfoDTO>    返回类型 
    * @throws 
    */
    public Pager<OdsInventoryInfoDTO> wmsQtyDetail(
            Pager<OdsInventoryInfoDTO> pager,
            OdsInventoryInfoDTO odsInventoryInfoDTO);

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
	public Long getExportAmount(OdsInventoryInfoDTO dto);

	/** 
	* @Title: getExportBinAmount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long getExportBinAmount(OdsInventoryInfoDtlDTO dto);
}
