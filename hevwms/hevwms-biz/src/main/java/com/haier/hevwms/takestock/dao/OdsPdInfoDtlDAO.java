package com.haier.hevwms.takestock.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.takestock.domain.OdsPdInfo;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

public interface OdsPdInfoDtlDAO extends CommonDAO<OdsPdInfoDtl, Long> {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> searchOdsPdInfoDtls(
			@Param("pager") Pager<OdsPdInfoDtl> pager,
			@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchOdsPdInfoDtlsCount(
			@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public void deleteAll(@Param("idList") List<Long> idList);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> getListByParams(
			@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> searchOdsPdInfoDtlsBySum(
			@Param("pager") Pager<OdsPdInfoDtl> pager,
			@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> searchOdsPdInfoDtlsBySum2(
			@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Long searchOdsPdInfoDtlsCountBySum(
			@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<OdsPdInfoDtl> getDiff(@Param("pd") OdsPdInfo pd);
	/**
	 * 对盘点明细进行逻辑删除，根据订单号
	* @Title: updateStatus
	* @Description:
	* @param @param odsPdInfoDtl
	* @return integer
	* @throws
	 */
    public Integer updateStatus(@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);
    /**
     * 查询盘点数量明细 分页
     */
    public List<OdsPdInfoDtl> pdQtyDetail(@Param("pager") Pager<OdsPdInfoDtl> pager,@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);
    /**
     * 盘点数量明细总数
     */
    public Long pdQtyDetailCount(@Param("odsPdInfoDtl") OdsPdInfoDtl odsPdInfoDtl);
    
    public String getPlantByOrderNo(String orderNo);

	/**  
	* @Title: deleteInfoDtlByBarcode  
	* @Description: 根据条码删除信息
	* @author: ZhangLL
	* @param in
	* @param out void
	* @throws  
	*/
	public void deleteInfoDtlByBarcode(@Param("in") WmsOrderDeleteIn in,@Param("out") OrderDeleteOutDTO out);

	/**  
	* @Title: scanStockTaking  
	* @Description: 盘点扫描
	* @author: ZhangLL
	* @param inpara
	* @param result void
	* @throws  
	*/
	public void scanStockTaking(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
}