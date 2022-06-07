package com.haier.hevwms.customer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.customer.dto.OdsCustomerScanInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/**  
 * @Title:  OdsCustomerScanInfoDAO.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月11日 上午11:07:05   
 * @version V1.0 
 */  
public interface OdsCustomerScanInfoDAO extends CommonDAO<OdsCustomerScanInfoDTO, Long> {
	
	/**  
	* @Title: searchOdsCustomerScanInfos  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param pager
	* @param odsCustomerScanInfo
	* @return List<OdsCustomerScanInfo>
	* @throws  
	*/
	public List<OdsCustomerScanInfoDTO> searchOdsCustomerScanInfos(@Param("pager") Pager<OdsCustomerScanInfoDTO> pager,
			@Param("odsCustomerScanInfo") OdsCustomerScanInfoDTO odsCustomerScanInfoDTO);
	
	/**  
	* @Title: searchOdsCustomerScanInfosCount  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param odsCustomerScanInfoDTO
	* @return Long
	* @throws  
	*/
	public Long searchOdsCustomerScanInfosCount(@Param("odsCustomerScanInfo") OdsCustomerScanInfoDTO odsCustomerScanInfoDTO);
	
	/**  
	* @Title: getListByParams  
	* @Description: 手持查询详细列表
	* @author: ZhangLL
	* @param odsCustomerScanInfo
	* @return List<OdsCustomerScanInfoDTO>
	* @throws  
	*/
	public List<OdsCustomerScanInfoDTO> getListByParams(@Param("odsCustomerScanInfo") OdsCustomerScanInfoDTO odsCustomerScanInfo);
	
	/**  
	* @Title: scanCustomer  
	* @Description: 手持扫描
	* @author: ZhangLL
	* @param inpara
	* @param result void
	* @throws  
	*/
	public void scanCustomer(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
	
	/**  
	* @Title: deleteCustomerByBarcode  
	* @Description: 手持根据条码删除
	* @author: ZhangLL
	* @param inpara
	* @param result void
	* @throws  
	*/
	public void deleteScanInfoByBarcode(@Param("in") WmsOrderDeleteIn in,@Param("out") OrderDeleteOutDTO out);
	
	/**  
	* @Title: orderOgp  
	* @Description: 出库
	* @author: ZhangLL
	* @param in
	* @param out void
	* @throws  
	*/
	public void orderOgp(@Param("in") WmsOrderIgpIn in,@Param("out") WmsOrderIgpOut out);
	
}