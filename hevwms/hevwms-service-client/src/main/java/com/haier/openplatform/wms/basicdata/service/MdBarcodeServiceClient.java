package com.haier.openplatform.wms.basicdata.service;

import io.terminus.pampas.client.Export;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;
import com.haier.openplatform.wms.basicdata.dto.MdBarcodeDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/** 
* @ClassName: MdBarcodeServiceClient 
* @Description: 关于条码查询以及生成打印功能
* @author Song Yinglong // Nicholas
* @date 2015-10-26 下午2:12:30 
* @param 
*/ 
public interface MdBarcodeServiceClient {
	
	/** 
	* @Title: searchBarcodes 
	* @Description: (查询barcode 并且分页) 
	* @param @param pager
	* @param @param mdBarcodeDTO
	* @param @return    设定文件 
	* @return Pager<MdBarcodeDTO>    返回类型 
	* @throws 
	*/ 
	public Pager<MdBarcodeDTO> searchBarcodes(Pager<MdBarcodeDTO> pager,MdBarcodeDTO mdBarcodeDTO);
	
	/** 
	* @Title: searchGiftBarcodes 
	* @Description: (查询barcode 并且分页) 
	* @param @param pager
	* @param @param mdBarcodeDTO
	* @param @return    设定文件 
	* @return Pager<MdBarcodeDTO>    返回类型 
	* @throws 
	*/ 
	public Pager<GiftBarcodeDTO> searchGiftBarcodes(Pager<GiftBarcodeDTO> pager,GiftBarcodeDTO mdBarcodeDTO);
	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException  
	* @Title: createBarcodes 
	* @Description: (这里用一句话描述这个方法的作用) 
	* @param @param mdBarcode    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	public String createBarcodes (MdBarcodeDTO mdBarcodeDTO) throws IllegalAccessException, InvocationTargetException;
	
	/** 
	* @Title: createGiftBarcode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param mdBarcodeDTO
	* @param @return
	* @param @throws IllegalAccessException
	* @param @throws InvocationTargetException    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return String    返回类型 
	* @throws 
	*/
	public String createGiftBarcode (GiftBarcodeDTO mdBarcodeDTO) throws IllegalAccessException, InvocationTargetException;
	
	/** 
	* @Title: create1DBarcode 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param barcode
	* @param @return    设定文件 
	* @author SJK
	* @date 2019年3月18日
	* @return List<String>    返回类型 
	* @throws 
	*/
	@Export(paramNames = {"barcode"})
	public List<String> create1DBarcode(String barcode);
	
    /** 
    * @Title: searchMdBarcode 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param page
    * @param @param rows
    * @param @param dto
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return Pager<MdBarcodeDTO>    返回类型 
    * @throws 
    */
    public Pager<MdBarcodeDTO> searchMdBarcode(Long page, Long rows,
            MdBarcodeDTO dto);
    
    /** 
    * @Title: existBarcode 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param barcode
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return boolean    返回类型 
    * @throws 
    */
    public boolean existBarcode(String barcode);
    
    /** 
    * @Title: insert 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param barcode
    * @param @param userName    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return void    返回类型 
    * @throws 
    */
    public void insert(String barcode, String userName);

    /**
     * @Author ZhangLL
     * @Description 修改条码bin
     * @Date 2018/12/25
     * @Param
     * @return
     */
    public OrderUploadOutDTO modifyBarcodeBin(OrderUploadInDTO inpara);

    /**
     * @Author ZhangLL
     * @Description 初始化Plant和Location
     * @Date 2018/12/25
     * @Param
     * @return
     */
    public OrderUploadOutDTO initUserPlantAndLoc(OrderUploadInDTO inpara);
}
