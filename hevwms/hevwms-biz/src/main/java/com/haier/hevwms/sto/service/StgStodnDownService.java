package com.haier.hevwms.sto.service;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGiGrDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;

import java.util.List;

/**
 * @Company 青鸟软通
 * @Title: StgStodnDownService
 * @Package com.haier.hevwms.order.service
 * @author 孙艳飞
 * @date 2015-11-24
 * @version V1.0
 */

public interface StgStodnDownService {

	/**
	 * @Title: searchStgStodnDowns
	 * @Description: (查询stgstodndown分页)
	 * @param @param pager
	 * @param @param dto
	 * @param @return
	 * @return Pager<StgStodnDownDTO>
	 * @throws
	 */
	public Pager<StgStodnDownDTO> searchStgStodnDowns(
			Pager<StgStodnDownDTO> pager, StgStodnDownDTO dto);

	/**
	 * @Title: getStgStodnDowns
	 * @Description: (查询stgstodndown列表)
	 * @param @param dto
	 * @param Pager
	 * @return List<StgStodnDownDTO>
	 * @throws
	 */
	public List<StgStodnDownDTO> getStgStodnDownListByParm(StgStodnDownDTO dto);

	/**
	 * @Title: postStnDn
	 * @Description: (todn posting By 孙艳飞 2015-12-4 ps:若String userName =
	 *               LoginContextHolder.get().getUserName();在dubbo中 可用
	 *               可直接走dubbo)
	 * @param @param stoDnNo
	 * @param @param userName
	 * @param @return
	 * @return String
	 * @throws
	 */
	public String postStnDn(String stoDnNo, String userName);

	/**
	 * @author Sun Yanfei 根据stodn号和物料关联sto查询是否是来自9990工厂的sto
	 * @param stoDnNo
	 * @param materialNo
	 * @return
	 */
	public int getStoDnCountByParam(String stoDnNo, String materialNo);

	// 获取查询出来数据的总量
	public Long getExportAmount(StgStodnDownDTO dto);
	
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
	 *
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
	 * @param stgStoDnDTO
	 * @return
	 */
	public Pager<StgStoDnDTO> searchStgStoDn(Pager<StgStoDnDTO> pager, StgStoDnDTO stgStoDnDTO);

	/**
	 * STODN 扫描详情分页查询
	 * @param pager
	 * @param stgStoDnDTO
	 * @return
	 */
	public Pager<StgStoDnDTO> searchScanDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO stgStoDnDTO);

	/**
	 * STODN 过账信息分页查询
	 * @param pager
	 * @param stgStoDnDTO
	 * @return
	 */
	public Pager<StgStoDnDTO> searchPostDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO stgStoDnDTO);

	public InterfaceOutDTO postStodn(String orderNo, String orderType, String userName);

	public InterfaceOutDTO stoDnGoodsDelivery(StgStoDnDTO stgStoDnDTO);
	public InterfaceOutDTO stoDnGoodsReceive(StgStoDnDTO stgStoDnDTO);

	public OrderGiGrDTO saveStodnGiGrInfo(StgStoDnDTO stgStoDnDTO);

}
