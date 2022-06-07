package com.haier.hevwms.remoting.rf.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveList;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveListIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcList;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcListIn;

/**
 * <p>Description: [RF移库接口]</p>
 * Created on 2013-10-16
 * @version 1.0
 */
public interface OtcwmsOrderMoveService {
	/**
	 * <p>Discription:[RF移库接口]</p>
	 * @param loginPara
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderMoveStoOut otcwmsOrderMoveSto(WmsOrderMoveStoIn in);
	/**
	 * <p>Discription:[RF移库完成]</p>
	 * @param loginPara
	 * @return
	 * @author:[lichunhui]
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	WmsOrderMoveDoneOut otcwmsOrderMoveDone(WmsOrderMoveDoneIn in);
	/**
	 * <p>Discription:[先进先出列表查询]</p>
	 * @param WmsOrderXjxcListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	 List<WmsOrderXjxcList> getXjxcList(WmsOrderXjxcListIn in);
	 /**
	 * <p>Discription:[移库列表查询]</p>
	 * @param WmsOrderMoveListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	 List<WmsOrderMoveList> getMoveList(@Param("in")WmsOrderMoveListIn in);
}
