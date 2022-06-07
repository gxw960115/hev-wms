package com.haier.hevwms.remoting.rf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.order.dto.StgInboundDownDTO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderCheckIn;

/** 
* @ClassName: OtcwmsOrderCheckDAO 
* @Description: TODO(手持单据校验) 
* @author Song Yinglong // Nicholas
* @date 2015-11-2 下午3:15:55 
* @param 
*/ 
public interface OtcwmsOrderCheckDAO extends CommonDAO<Object, Long>{
	
	/** 
	* @Title: orderCheck 
	* @Description: TODO(单据校验) 
	* @param @param in
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	String orderCheck(@Param("parmin")WmsOrderCheckIn in);
	
	String orderCheckByAvailableWh(@Param("parmin")WmsOrderCheckIn in, @Param("userId") Long userId);
	
	List<StgInboundDownDTO> getInbdByOrderNo(@Param("parmin")WmsOrderCheckIn in);
	
	String getPoByOrderNoItem(@Param("stgInboundDown")StgInboundDownDTO stgInboundDown);
	String getPoByAvailableWh(@Param("stgInboundDown")StgInboundDownDTO stgInboundDown, @Param("userId") Long userId);
	
	List<String> getPdLocation(@Param("orderNo")String orderNo);
	
	List<String> getProcessPdLocation(@Param("orderNo")String orderNo);
	
	/** l
	* @Title: getDnSapFlag 
	* @Description: TODO(获取dn sapflag 来验证dn是否已在PC端先完成过账 add by sunyanfei 2016-1-27) 
	* @param @param in
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
	String checkDnSapFlag(@Param("parmin")WmsOrderCheckIn in);

	//获取手持端需要扫描的总数量
	String getRequiredTotalQty(@Param("parmin")WmsOrderCheckIn in);

	List<String> getPdMat(@Param("orderNo")String orderNo, @Param("string")String string);
	
	void updateCurrentScanner(@Param("orderNo") String orderNo,@Param("docType") String docType, @Param("userId") Long userId);
	
	String orderCheckScannerInbound(@Param("orderNo") String orderNo, @Param("userId") Long userId);

}
