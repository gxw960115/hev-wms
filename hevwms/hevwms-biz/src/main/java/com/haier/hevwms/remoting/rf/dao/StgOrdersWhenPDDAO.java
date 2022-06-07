package com.haier.hevwms.remoting.rf.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.BaseDAO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.StgOrdersWhenPDDTO;

/** * @author  作者 :sunyanfei 
 * @date 创建时间：2016-3-25 上午11:43:39
 * @version 1.0
 * @parameter
 * @since
 * @return 
 */
public interface StgOrdersWhenPDDAO extends BaseDAO<StgOrdersWhenPDDTO, Serializable>{
    public Long searchOrderCount(@Param("orderNo")String orderNo,@Param("orderType")String orderType
	    					,@Param("docTpye")String docTpye);
    
    public List<StgOrdersWhenPDDTO> getOrders(@Param("orderNo")String orderNo
	    		,@Param("orderType")String orderType,@Param("docTpye")String docTpye);
    
    public List<String> getOrdersLocation(@Param("orderNo")String orderNo
		,@Param("orderType")String orderType,@Param("docTpye")String docTpye);
    public Long getOrderCountNotFinish(@Param("in")OrderUploadInDTO in);
    
    public void updateInoutFlag(@Param("in")OrderUploadInDTO in);
    
}
