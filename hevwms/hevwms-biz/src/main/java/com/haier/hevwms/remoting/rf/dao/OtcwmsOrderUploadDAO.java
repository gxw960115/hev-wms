package com.haier.hevwms.remoting.rf.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderUploadOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcOut;

/**
 * 
 * <p>Description: [手持单据条码上传]</p>
 * Created on 2013-8-12
 * @version 1.0
 */
public interface OtcwmsOrderUploadDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[手持单据条码上传]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderUpload(@Param("in")WmsOrderUploadIn in,@Param("out")WmsOrderUploadOut out);
	/**
	 * <p>Discription:[盘点手持单据条码上传]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderUploadPD(@Param("in")WmsOrderUploadIn in,@Param("out")WmsOrderUploadOut out);
	/**
	 * <p>Discription:[先进先出 出库验证]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderXjxcChcek(@Param("in")WmsOrderXjxcIn in,@Param("out")WmsOrderXjxcOut out);
	
}
