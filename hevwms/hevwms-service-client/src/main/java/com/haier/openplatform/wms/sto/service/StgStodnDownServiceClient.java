package com.haier.openplatform.wms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import io.terminus.pampas.client.Export;

import java.util.List;

/**
* @Company 青鸟软通
* @Title: StgStodnDownServiceClient
* @Package com.haier.openplatform.wms.order.service
* @author 孙艳飞
* @date 2015-11-24
* @version V1.0
*/
public interface StgStodnDownServiceClient {

    /**
     * @title: searchStgStodnDowns
     * @description: 条件分页查询 
     * @author: LJZ
     * @version: v1.0.0
     * @date: 2018年11月14日 下午3:54:08
     * @param dto
     * @return: Pager<StgStodnDownDTO>
     */
	public Pager<StgStodnDownDTO> searchStgStodnDowns(Long page, Long rows, StgStodnDownDTO dto);

	/**
	 * @title: getExportAmount
	 * @description: 统计
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年11月14日 下午6:45:52 
	 * @param dto
	 * @return: Long
	 */
	public Long getExportAmount(StgStodnDownDTO dto);
	
	/**
	 * @title: getStgStodnDowns
	 * @description: 查询stgstodn 列表
	 * @author: LJZ
	 * @date: 2018年11月14日 下午3:55:15 
	 * @param dnDownDTO
	 * @return: List<StgStodnDownDTO>
	 */
	public List<StgStodnDownDTO> getStgStodnDownListByParm(StgStodnDownDTO dnDownDTO);
	
	/**
	* @Title: postStnDn
	* @Description:  (todn posting 孙艳飞 2015-12-4
	                  ps:若String userName = LoginContextHolder.get().getUserName();在dubbo中
	                                       可用 可直接走dubbo)
	* @param @param stoDnNo
	* @param @param userName
	* @param @return
	* @return String
	* @throws
	 */
	@Export(paramNames={"stoDnNo","userName"})
	public String postStnDn(String stoDnNo,String userName);

    /**
     * @param stoNo
     * @param stodnNo
     * @param userName
     * @return
     */
	public InterfaceOutDTO downloadStodn(String stoNo, String stodnNo, String userName);

	/**
	 * TMS STODN 推送
	 * @param stgStoDnDTO
	 * @return
	 */
	public InterfaceOutDTO downloadStodnFromTMS(StgStoDnDTO stgStoDnDTO);

	/**
	 * stodn物料信息检查获取
	 * @param stoDnNo
	 * @return
	 */
	public InterfaceOutDTO checkStoDnNo(String stoDnNo);

	/**
	 * 根据stodnNo查询LocationName
	 * @param stodnNo
	 * @return
	 */
	List<String> getGrLocationNameListByStodnNo(String stodnNo);


	/**
	 * 直发派遣列表查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<StgStodnDownDTO> searchStgStoDnDownsFromFactory(Pager<StgStodnDownDTO> pager,
																 StgStodnDownDTO dto);

	/**
	 * STODN 分页查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<StgStoDnDTO> searchStgStoDn(Pager<StgStoDnDTO> pager, StgStoDnDTO dto);

	/**
	 * STODN 扫描详情分页查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<StgStoDnDTO> searchScanDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO dto);

	/**
	 * STODN 过账信息分页查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	public Pager<StgStoDnDTO> searchPostDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO dto);

	/**
	 * STODN 过账
	 * @param orderNo
	 * @param orderType
	 * @param userName
	 * @return
	 */
	public OrderIgpOutDTO postStodn(String orderNo, String orderType, String userName);

	public OrderIgpOutDTO stodnGiGr(StgStoDnDTO stgStoDnDTO) ;
}
