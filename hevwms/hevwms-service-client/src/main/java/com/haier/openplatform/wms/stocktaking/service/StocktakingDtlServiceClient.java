package com.haier.openplatform.wms.stocktaking.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDtlDTO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface StocktakingDtlServiceClient {
    /**
    * @Title: searchStocktakingOrderDtl
    * @Description: 查询 库存盘点明细 记录
    * @param @param page 当前页
    * @param @param rows 每页的记录数
    * @param @param odsPdInfoDtlDTO
    * @param @return
    * @return Pager<OdsPdInfoDtlDTO>
    * @throws
    */
    public Pager<OdsPdInfoDtlDTO> searchStocktakingOrderDtl(long page,long rows,OdsPdInfoDtlDTO odsPdInfoDtlDTO);
    
    /**
    * @Title: searchStocktakingOrderDtlSum
    * @Description: 库存盘点单明细 汇总 查询
    * @param @param page
    * @param @param rows
    * @param @param odsPdInfoDtlDTO
    * @param @return
    * @return Pager<OdsPdInfoDtlDTO>
    * @throws
    */
    public Pager<OdsPdInfoDtlDTO> searchStocktakingOrderDtlSum(long page,long rows,OdsPdInfoDtlDTO odsPdInfoDtlDTO);
    
    /**
    * @Title: getOdsPdInfoDtls
    * @Description: Excel导出时，查询所有记录并以List集合形式返回
    * @param @param odsPdInfoDtlDTO
    * @param @return
    * @return List<OdsPdInfoDtlDTO>
    * @throws
    */
    public List<OdsPdInfoDtlDTO> getOdsPdInfoDtls(OdsPdInfoDtlDTO odsPdInfoDtlDTO);
    /**
     * @Title: searchStocktakingOrderDtlSum
     * @Description: 库存盘点单明细 汇总 查询
     * @param @param page
     * @param @param rows
     * @param @param odsPdInfoDtlDTO
     * @param @return
     * @return Pager<OdsPdInfoDtlDTO>
     * @throws
     */
     public List<OdsPdInfoDtlDTO> searchStocktakingOrderDtlSumList(OdsPdInfoDtlDTO odsPdInfoDtlDTO);

     /** 
    * @Title: getPdQtyDetail 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param page
    * @param @param rows
    * @param @param odsPdInfoDtlDTO
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<OdsPdInfoDtlDTO>    返回类型 
    * @throws 
    */
    public Pager<OdsPdInfoDtlDTO>  getPdQtyDetail(Long page,Long rows,
            OdsPdInfoDtlDTO odsPdInfoDtlDTO);

	/** 
	* @Title: getPdExportAmount 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long getPdExportAmount(OdsPdInfoDtlDTO dto);

	/** 
	* @Title: searchOdsPdInfoDtlsCountBySum 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param dto
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return Long    返回类型 
	* @throws 
	*/
	public Long searchOdsPdInfoDtlsCountBySum(OdsPdInfoDtlDTO dto);

	/**  
	* @Title: orderDelete  
	* @Description: 删除盘点
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderDeleteOutDTO
	* @throws  
	*/
	public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

	/**
	* @Title: orderDelete
	* @Description: 删除盘点
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderDeleteOutDTO
	* @throws
	*/
	public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException;

	/**  
	* @Title: orderScan  
	* @Description: 盘点单扫描
	* @author: ZhangLL
	* @param inpara
	* @param version
	* @return OrderUploadOutDTO
	* @throws  
	*/
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException ;

	/**  
	* @Title: barcodeList  
	* @Description: 条码列表
	* @author: ZhangLL
	* @param inpara
	* @return WmsOrderDelListOutDTO
	* @throws  
	*/
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara);
}
