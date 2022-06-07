package com.haier.hevwms.remoting.rf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveDoneOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveList;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveListIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderMoveStoOut;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcList;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderXjxcListIn;

/**
 * 
 * <p>Description: [移库管理]</p>
 * Created on 2013-8-12
 * @version 1.0
 */
public interface OtcwmsOrderMoveStoDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[移库上传接口]</p>
	 * @param OtcwmsOrderMoveStoIn,OtcwmsOrderMoveStoOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void moveStoUpload(@Param("in")WmsOrderMoveStoIn in,@Param("out")WmsOrderMoveStoOut out);
	/**
	 * <p>Discription:[移库完成接口]</p>
	 * @param OtcwmsOrderMoveDoneIn,OtcwmsOrderMoveDoneOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void moveStoDone(@Param("in")WmsOrderMoveDoneIn in,@Param("out")WmsOrderMoveDoneOut out);
	/**
	 * <p>Discription:[移库完成验证接口]</p>
	 * @param OtcwmsOrderMoveDoneIn,OtcwmsOrderMoveDoneOut
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	void moveStoDoneCheck(@Param("in")WmsOrderMoveDoneIn in,@Param("out")WmsOrderMoveDoneOut out);
	
	/**
	 * <p>Discription:[先进先出列表查询]</p>
	 * @param WmsOrderXjxcListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	List<WmsOrderXjxcList> getXjxcList(@Param("parmxjxcin")WmsOrderXjxcListIn in);
	/**
	 * <p>Discription:[移库列表查询]</p>
	 * @param WmsOrderMoveListIn
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	List<WmsOrderMoveList> getMoveList(@Param("parmin")WmsOrderMoveListIn in);

}
