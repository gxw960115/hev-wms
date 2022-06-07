package com.haier.hevwms.basic.service;

import io.terminus.pampas.common.BaseUser;

import java.util.HashMap;
import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;


public interface CdWhInfoService {
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String createCdWhInfo(CdWhInfoDTO cdWhInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String updateCdWhInfo(CdWhInfoDTO cdWhInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String deleteCdWhInfo(Long cdWhInfoId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public String deleteCdWhInfoAll(List<Long> idList);

	/**@discription 逻辑删除
	 * @author fanrong bu
	 * @date 2015-11-27
	 */
	public String updateWhFlag(List<Long> idList);
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public Pager<CdWhInfoDTO> searchCdWhInfos(Pager<CdWhInfoDTO> pager,CdWhInfoDTO cdWhInfo);
	
	/**@discription 查询仓库信息
	 * @author fanrong bu
	 * @date 2015-11-27
	 */
	public Pager<CdWhInfoDTO> searchCdWhInfosByConditions(Long page, Long rows,CdWhInfoDTO cdWhInfo);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public CdWhInfoDTO getCdWhInfoById(Long cdWhInfoId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<CdWhInfoDTO> getCdWhInfos();
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<CdWhInfoDTO> getPhysicalWhInfos();

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<HashMap<String, Object>> findWhLocTree(String userType,
			Long userId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public HashMap<String, String> findUserWhLoc(String userType, Long userId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<CdWhInfoDTO> findCdWhInfoByUserId(String userType, Long userId);

	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */

	public List<Long> findCdUserLoc(String userType, Long userId);
	/**
	 * 导入warehouse
	 * @param obj
	 */
	public void saveOrUpdate(CdWhInfoDTO obj);
	
	/**@discription 批量导入仓库信息
	 * @author fanrong bu
	 * @date 2015-11-27
	 */
	public String saveOrUpdate2(List<CdWhInfoDTO> list, BaseUser user);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<CdWhInfoDTO> findAvailableWhInfos(Long userId);
	
	/**
	 * 
	 * 方法描述：参数描述：返回值描述
	 * 
	 * @param
	 * @return
	 */
	public List<CdWhInfoDTO> findAvailablePhyWhInfos(Long userId);

	
}
