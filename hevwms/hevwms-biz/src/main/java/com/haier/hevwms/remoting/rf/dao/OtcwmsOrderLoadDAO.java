package com.haier.hevwms.remoting.rf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.remoting.rf.domain.login.Location;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderLoadIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderLoadOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderWlList;
import com.haier.hevwms.remoting.rf.domain.order.SubLocation;

/**
 * 
 * <p>Description: [手持单据下载]</p>
 * Created on 2013-8-12
 * @version 1.0
 */
public interface OtcwmsOrderLoadDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[手持单据下载]</p>
	 * @param OtcwmsOrderLoadIn,OtcwmsOrderLoadOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void orderLoad(@Param("in")WmsOrderLoadIn in,@Param("out")WmsOrderLoadOut out);
	/**
	 * <p>Discription:[手持盘点单下载获取location]</p>
	 * @param 
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	List<Location> orderLoadPd(@Param("orderno")String orderno);
	/**
	 * <p>Discription:[rf sublocation 下载]</p>
	 * @param WmsOrderLoadIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	List<SubLocation> otcwmsGetSubLocation(@Param("location")String location);
	/**
	 * <p>Discription:[rf wl下载]</p>
	 * @param WmsOrderLoadIn
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	List<WmsOrderWlList> otcwmsGetWlList(@Param("loadIn")WmsOrderLoadIn in);
}
