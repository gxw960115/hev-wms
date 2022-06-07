package com.haier.hevwms.so.dao;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OdsSoGrInfoDAO extends CommonDAO<OdsSoGrInfoDTO, Long> {

	public List<OdsSoGrInfoDTO> searchOdsSoGrInfoListByPage(
			@Param("pager") Pager<OdsSoGrInfoDTO> pager,
			@Param("odsSoGrInfo") OdsSoGrInfoDTO odsSoGrInfo);

	public Long searchOdsSoGrInfoCount(
			@Param("odsSoGrInfo") OdsSoGrInfoDTO odsSoGrInfo);

	public void deleteAll(@Param("idList") List<Long> idList);

	public List<OdsSoGrInfoDTO> getOdsSoGrInfoListByParm(@Param("odsSoGrInfo") OdsSoGrInfoDTO odsSoGrInfo);
	
	public List<OdsSoGrInfoDTO> getOdsSoGrInfoListByOGP(@Param("odsSoGrInfo") OdsSoGrInfoDTO odsSoGrInfo);

	/**
	 * STODN 出入库过账查询
	 * @param odsSoGrInfo
	 */
	public OdsSoGrInfoDTO getOdsSoGrGiInfoByOGPOrIGP(@Param("odsSoGrInfo") OdsSoGrInfoDTO odsSoGrInfo);

	/**
	 * 获取stodn扫描物料信息
	 * @param stodnNo
	 * @return
	 */
	public List<OdsSoGrInfoDTO> getMatListByStodn(@Param("stodnNo") String stodnNo, @Param("orderType") String orderType);

	public void updatePostResult(@Param("odsSoGrInfo") OdsSoGrInfoDTO odsSoGrInfo);

	/**
	 * 修改改订单状态
	 * @param flag
	 * @param msg
	 */
	public void updateFlag(@Param("flag") String flag, @Param("msg") String msg,
						   @Param("orderNo") String orderNo, @Param("stodnNo") String stodnNo, @Param("userName") String userName);

	public void updateGiGrFlag(@Param("flag") String flag, @Param("msg") String msg,
						   @Param("orderNo") String orderNo, @Param("stodnNo") String stodnNo, @Param("userName") String userName);
}