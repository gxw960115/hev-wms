package com.haier.hevwms.remoting.rf.dao;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.remoting.rf.domain.Returnentity;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;

/**
 * 
 * <p>Description: [手持单据过账]</p>
 * Created on 2013-8-12
 * @version 1.0
 */
public interface OtcwmsOrderIgpDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[手持单据过账 入库]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderIgp(@Param("in")WmsOrderIgpIn in,@Param("out")WmsOrderIgpOut out);
	/**
	 * <p>Discription:[手持单据过账 入库]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderOgp(@Param("in")WmsOrderIgpIn in,@Param("out")WmsOrderIgpOut out);
	/**
	 * <p>Discription:[手持单据过账 入库]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void dnOrderIgp(@Param("in")WmsOrderIgpIn in,@Param("out")WmsOrderIgpOut out);
	
	/**
	 * <p>Discription:[手持单据过账 生成库存]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderMakeStorageIn(@Param("in")WmsOrderIgpIn in,@Param("out")Returnentity out);
	/**
	 * <p>Discription:[手持单据过账 生成库存 出库]</p>
	 * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderMakeStorageOut(@Param("in")WmsOrderIgpIn in,@Param("out")Returnentity out);
	/**
     * <p>Discription:孙艳飞stodn 预扫描</p>
     * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
     * @return
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    void stodnOrderOgp(@Param("in")WmsOrderIgpIn in,@Param("out")WmsOrderIgpOut out);
    /**
     * <p>Discription:孙艳飞手持billing 出库汇总</p>
     * @param OtcwmsOrderCheckIn,OtcwmsOrderUploadOut
     * @return
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    void billingOgp(@Param("in")WmsOrderIgpIn in,@Param("out")WmsOrderIgpOut out);
}
