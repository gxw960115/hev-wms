package com.haier.hevwms.remoting.rf.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.BaseDAO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.StgInoutBarcodeWhenPDDTO;

/** * @author  作者 :sunyanfei 
 * @date 创建时间：2016-3-25 上午11:40:45
 * @version 1.0
 * @parameter
 * @since
 * @return 
 */
public interface StgInoutBarcodeWhenPDDAO extends BaseDAO<StgInoutBarcodeWhenPDDTO, Serializable> {
    public List<StgInoutBarcodeWhenPDDTO> getByOrderNoAndType(@Param("orderNo")String orderNo
	    							,@Param("orderType")String orderType);
    public Long updateInoutFlag(@Param("in")OrderUploadInDTO in);
    
    public List<StgInoutBarcodeWhenPDDTO> getAllBarcodeOut();
    
    public List<StgInoutBarcodeWhenPDDTO> getAllBarcodeIn();
}
