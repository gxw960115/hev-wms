package com.haier.hevwms.remoting.rf.dao;

import java.io.Serializable;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

/** * @author  作者 :sunyanfei 
 * @date 创建时间：2016-3-28 下午4:05:20
 * @version 1.0
 * @parameter
 * @since
 * @return 
 */
public interface ScanAndIOGPWhenPD extends CommonDAO<Object, Serializable>{
    void orderScan (@Param("in")OrderUploadInDTO in,@Param("out")OrderUploadOutDTO out);
    
    void orderDelete(@Param("in")OrderUploadInDTO in,@Param("out")OrderUploadOutDTO out);
}
