package com.haier.hevwms.transfer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.transfer.dto.OdsTransferDtlDTO;

/**  
 * @Title:  OdsTransferInfoDAO.java   
 * @Description:TODO(用一句话描述该文件做什么)   
 * @author: zhangll
 * @date:   2018年11月7日 下午4:19:34   
 * @version V1.0 
 */  
public interface OdsTransferDtlDAO extends CommonDAO<OdsTransferDtlDTO, Long> {

	/**  
	* @Title: deleteAll  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param idList void
	* @throws  
	*/
	public void deleteAll(@Param("idList") List<Long> idList);
	
	/**  
	* @Title: searchOdsTransferDtls  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param pager
	* @param odsTransferInfo
	* @return List<OdsTransferInfo>
	* @throws  
	*/
	public List<OdsTransferDtlDTO> searchOdsTransferDtls(@Param("pager") Pager<OdsTransferDtlDTO> pager,
			@Param("odsTransferDtl") OdsTransferDtlDTO odsTransferDtlDTO);
	
	/**  
	* @Title: searchOdsTransferDtlsCount  
	* @Description: TODO(这里用一句话描述这个方法的作用)  
	* @author zhangll
	* @param odsTransferDtl
	* @return Long
	* @throws  
	*/
	public Long searchOdsTransferDtlsCount(@Param("odsTransferDtl") OdsTransferDtlDTO odsTransferDtlDTO);

	/**  
	* @Title: getListByParams  
	* @Description: 手持查询详细列表
	* @author: ZhangLL
	* @param odsCustomerScanInfo
	* @return List<OdsCustomerScanInfoDTO>
	* @throws  
	*/
	public List<OdsTransferDtlDTO> getListByParams(@Param("odsTransferDtl") OdsTransferDtlDTO odsTransferDtlDTO);
	
	/**  
	* @Title: scanTransfer  
	* @Description: 手持扫描
	* @author: ZhangLL
	* @param inpara
	* @param result void
	* @throws  
	*/
	public void scanTransfer(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
	
	/**  
	* @Title: deleteScanInfoByBarcode  
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
	
	/**  
	* @Title: scanStatus  
	* @Description: 检测扫描状态
	* @author: ZhangLL
	* @param orno
	* @return long
	* @throws  
	*/
	public long scanStatus(@Param("orderNo") String orno);

	/**  
	* @Title: updateSapInfo  
	* @Description: 更改信息
	* @author: ZhangLL
	* @param inpara void
	* @throws  
	*/
	public void updateSapInfo(@Param("order") OrderIgpInDTO inpara);
}