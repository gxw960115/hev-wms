package com.haier.openplatform.wms.sto.impl;

import com.haier.hevwms.sto.service.StgStodnDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGiGrDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;
import com.haier.openplatform.wms.sto.dto.StgStoDnDTO;
import com.haier.openplatform.wms.sto.dto.StgStodnDownDTO;
import com.haier.openplatform.wms.sto.service.StgStodnDownServiceClient;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Company 青鸟软通
 * @Title: StgStodnDownServiceClientImpl
 * @author 孙艳飞
 * @date 2015-11-24
 * @version V1.0
 */

public class StgStodnDownServiceClientImpl implements StgStodnDownServiceClient {

	Logger logger = Logger.getLogger(StgStodnDownServiceClientImpl.class);

	private StgStodnDownService stgStodnDownService;

	public void setStgStodnDownService(StgStodnDownService stgStodnDownService) {
		this.stgStodnDownService = stgStodnDownService;
	}

	/**
	 * 查询stgstodn 分页
	 *
	 * @Title: searchStgStodnDowns
	 * @param @param pager
	 */
	@Override
	public Pager<StgStodnDownDTO> searchStgStodnDowns(Long page, Long rows, StgStodnDownDTO dto) {
		Pager<StgStodnDownDTO> pager = new Pager<StgStodnDownDTO>();
		pager.setCurrentPage(page);
		pager.setPageSize(rows);
		return stgStodnDownService.searchStgStodnDowns(pager, dto);
	}

	/**
	 * 条件查询
	 * @param dto
	 * @return
	 */
	@Override
	public List<StgStodnDownDTO> getStgStodnDownListByParm(StgStodnDownDTO dto) {
		return stgStodnDownService.getStgStodnDownListByParm(dto);
	}

	/**
	 * @Title: postStnDn
	 * @Description:
	 */
	@Override
	public String postStnDn(String stoDnNo, String userName) {
		return stgStodnDownService.postStnDn(stoDnNo, userName);
	}

	@Override
	public Long getExportAmount(StgStodnDownDTO dto) {
		return stgStodnDownService.getExportAmount(dto);
	}

	@Override
	public InterfaceOutDTO downloadStodn(String stoNo, String stodnNo, String userName) {
		return stgStodnDownService.downloadStodn(stoNo, stodnNo, userName);
	}

	/**
	 * TMS STODN 推送
	 * @param stgStoDnDTO
	 * @return
	 */
	@Override
	public InterfaceOutDTO downloadStodnFromTMS(StgStoDnDTO stgStoDnDTO) {
		return stgStodnDownService.downloadStodnFromTMS(stgStoDnDTO);
	}

	/**
	 * stodn物料信息检查获取
	 * @param stoDnNo
	 * @return
	 */
	@Override
	public InterfaceOutDTO checkStoDnNo(String stoDnNo) {
		InterfaceOutDTO dto = stgStodnDownService.checkStoDnNo(stoDnNo);
		return dto;
	}

	/**
	 * 根据stodnNo查询LocationName
	 *
	 * @author LiuJiazhen
	 * @param stodnNo
	 * @return
	 */
	@Override
	public List<String> getGrLocationNameListByStodnNo(String stodnNo) {
		return stgStodnDownService.getGrLocationNameListByStodnNo(stodnNo);
	}

	/**
	 * 直发派遣列表查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	@Override
	public Pager<StgStodnDownDTO> searchStgStoDnDownsFromFactory(
			Pager<StgStodnDownDTO> pager, StgStodnDownDTO dto) {
		Pager<StgStodnDownDTO> page = stgStodnDownService.searchStgStoDnDownsFromFactory(pager, dto);
		return page;
	}

	/**
	 * STODN 分页查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	@Override
	public Pager<StgStoDnDTO> searchStgStoDn(Pager<StgStoDnDTO> pager, StgStoDnDTO dto) {
		return stgStodnDownService.searchStgStoDn(pager, dto);
	}

	/**
	 * STODN 扫描详情分页查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	@Override
	public Pager<StgStoDnDTO> searchScanDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO dto) {
		return stgStodnDownService.searchScanDetail(pager, dto);
	}

	/**
	 * STODN 过账信息分页查询
	 * @param pager
	 * @param dto
	 * @return
	 */
	@Override
	public Pager<StgStoDnDTO> searchPostDetail(Pager<StgStoDnDTO> pager, StgStoDnDTO dto) {
		return stgStodnDownService.searchPostDetail(pager, dto);
	}


	/**
	 * STODN 过账
	 * @param orderNo
	 * @param orderType
	 * @param userName
	 * @return
	 */
	@Override
	public OrderIgpOutDTO postStodn(String orderNo, String orderType, String userName) {
		logger.info("Post Stodn start with orderNo: " + orderNo);
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		//STODN 过账
		InterfaceOutDTO result = stgStodnDownService.postStodn(orderNo, orderType, userName);
		//过账成功后需要删除库存
		if(result != null && "1".equals(result.getStatus())) {
			StgStoDnDTO stgStoDnDTO = new StgStoDnDTO();
			stgStoDnDTO.setOrderType(orderType);
			stgStoDnDTO.setOrderNo(orderNo);
			stgStoDnDTO.setCreateBy(userName);
			//入库添加库存
			if("1".equals(stgStoDnDTO.getOrderType())) {
				InterfaceOutDTO outDTO = stgStodnDownService.stoDnGoodsReceive(stgStoDnDTO);
				outResult.setStatus(outDTO.getStatus());
				outResult.setMsg(outDTO.getMsg());
				if(!"0".equals(outDTO.getStatus())) {
					return outResult;
				}
			//出库删除库存
			}else if("2".equals(stgStoDnDTO.getOrderType())) {
				InterfaceOutDTO outDTO = stgStodnDownService.stoDnGoodsDelivery(stgStoDnDTO);
				outResult.setStatus(outDTO.getStatus());
				outResult.setMsg(outDTO.getMsg());
				if(!"0".equals(outDTO.getStatus())) {
					return outResult;
				}
			//未知错误
			}else {
				outResult.setStatus("1");
				outResult.setMsg("unknown mistake!");
			}
		}else {
			outResult.setStatus(result.getStatus());
			outResult.setMsg(result.getMsg());
		}
		return outResult;
	}

	/**
	 * STODN 过账
	 * @param stgStoDnDTO
	 * @return
	 */
	@Override
	public OrderIgpOutDTO stodnGiGr(StgStoDnDTO stgStoDnDTO) {
		//生成过账信息
		OrderGiGrDTO out = stgStodnDownService.saveStodnGiGrInfo(stgStoDnDTO);
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		InterfaceOutDTO result = new InterfaceOutDTO();
		//汇总生成成功进行过账操作
		if("0".equals(out.getStatus())) {
			logger.info("Post Stodn start with orderNo: " + out.getOrderNo());
			stgStoDnDTO.setOrderNo(out.getOrderNo());
			result = stgStodnDownService.postStodn(out.getOrderNo(), stgStoDnDTO.getOrderType(), stgStoDnDTO.getCreateBy());
			//过账成功后需要删除库存
			if(result != null && "1".equals(result.getStatus())) {
				if("1".equals(stgStoDnDTO.getOrderType())) {
					InterfaceOutDTO outDTO = stgStodnDownService.stoDnGoodsReceive(stgStoDnDTO);
					outResult.setStatus(outDTO.getStatus());
					outResult.setMsg(outDTO.getMsg());
					if(!"0".equals(outDTO.getStatus())) {
						return outResult;
					}
				}else if("2".equals(stgStoDnDTO.getOrderType())) {
					InterfaceOutDTO outDTO = stgStodnDownService.stoDnGoodsDelivery(stgStoDnDTO);
					outResult.setStatus(outDTO.getStatus());
					outResult.setMsg(outDTO.getMsg());
					if(!"0".equals(outDTO.getStatus())) {
						return outResult;
					}
				}else {
					outResult.setStatus("1");
					outResult.setMsg("unknown mistake!");
				}
			}else {
				outResult.setStatus(result.getStatus());
				outResult.setMsg(result.getMsg());
			}
		}else {
			outResult.setStatus(out.getStatus());
			outResult.setMsg(out.getMsg());
		}
		return outResult;
	}
}
