package com.haier.hevwms.basic.service;

import java.util.List;

import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**
 * <p>Description: [基础数据手工生成条码表的service类]</p>
 * Created on 2013-10-30
 * @author  <a href="mailto: zh-fan@neusoft.com">张帆</a>
 * @version 1.0
 */
public interface MdBarcodeService {
	/**
	 * <p>Discription:创建手工生成条码表信息</p>
	 * @param mdBarcode
	 * @return ExecuteResult<MdBarcode>
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public ExecuteResult<MdBarcode> createMdBarcode(List<MdBarcode> mdBarcodeList);

	/**
	 * <p>Discription:修改手工生成条码表信息</p>
	 * @return ExecuteResult<MdBarcode>
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public ExecuteResult<MdBarcode> updateMdBarcode(List<Long> idList, String stNo);

	/**
	 * <p>Discription:分布查询手工生成条码表信息</p>
	 * @param pager,mdBarcode
	 * @return Pager<MdBarcode>
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public Pager<MdBarcode> searchMdBarcodes(Pager<MdBarcode> pager, MdBarcode mdBarcode);
	
	/**
	 * <p>Discription:分布查询手工生成条码表信息</p>
	 * @param pager,mdBarcode
	 * @return Pager<MdBarcode>
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public Pager<GiftBarcodeDTO> searchGiftBarcodes(Pager<GiftBarcodeDTO> pager, GiftBarcodeDTO mdBarcode);

	/**
	 * <p>Discription:[获取流水号stNo]</p>
	 * @param mdBarcode
	 * @return
	 * @author:[张帆]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public Long searchMdBarcodesStNo();

	/**
	 * <p>Discription:[查询条码累计生成数量]</p>
	 * @return
	 * @author:[张帆]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public Integer searchMdBarcodesHisNum();

	/**
	 * <p>Discription:更新条码累计生成数量</p>
	 * @param idList
	 * @return void
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public Integer updateBarcodesHisNum(Integer hisNum, Integer sumNum);
	
	/**
	 * @param userId
	 * @return
	 */
	public List<MdBarcode> searchById(String userId);

	/** 
	* @Title: addNewBarcodes
	* @Description: TODO(根据输入的信息批量生成新条码) 
	* @param @param mdBarcode
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	public String addNewBarcodes(MdBarcode mdBarcode);  //addGiftBarcode
	
	public String addGiftBarcode(GiftBarcodeDTO giftBarcode); 
	 
	//在指定目录下，生成对应条码
    public String createMdBarcode1D(String resource,String barcode);
    
    //创建临时文件夹、临时文件
    public String createTempDir(String fileName);
    
    public boolean existBarcode(String barcode);
    
    public void insert(String barcode, String userName);

    /**
     * @Author ZhangLL
     * @Description 修改bin
     * @Date 2018/12/25
     * @Param 
     * @return 
     */
    public OrderUploadOutDTO modifyBarcodeBin(OrderUploadInDTO inpara);

    /**
     * @Author ZhangLL
     * @Description 初始化plant和location
     * @Date 2018/12/25
     * @Param
     * @return
     */
    public OrderUploadOutDTO initUserPlantAndLoc(OrderUploadInDTO inpara);
}
