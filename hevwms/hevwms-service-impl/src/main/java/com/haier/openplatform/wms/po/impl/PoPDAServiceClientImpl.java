package com.haier.openplatform.wms.po.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.apache.log4j.Logger;

import com.haier.hevwms.po.service.OdsPoScanInfoService;
import com.haier.hevwms.po.service.PoPDAService;
import com.haier.hevwms.po.service.StgPoDownService;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.SpringApplicationContextHolder;
import com.haier.openplatform.wms.po.dto.OdsPoScanInfoDTO;
import com.haier.openplatform.wms.po.service.PoPDAServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDelDetialDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderGoodsTransOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 * @className: PoPDAServiceClientImpl.java
 * @description: PO 的 PDA Client
 *
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月30日 下午2:42:41
 *
 * Modification History:
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年10月30日		LJZ			v1.0.0			create
 */

public class PoPDAServiceClientImpl implements PoPDAServiceClient {

	private Logger logger = Logger.getLogger(PoPDAServiceClientImpl.class);
	@Resource
	private WebServiceContext context;
	
	private StgPoDownService stgPoDownService;
	
	private PoPDAService poPDAService;
	
	public StgPoDownService getStgPoDownService() {
		return stgPoDownService;
	}

	public void setStgPoDownService(StgPoDownService stgPoDownService) {
		this.stgPoDownService = stgPoDownService;
	}

	public PoPDAService getPoPDAService() {
		return poPDAService;
	}

	public void setPoPDAService(PoPDAService poPDAService) {
		this.poPDAService = poPDAService;
	}

	/* (非 Javadoc) 
	* <p>Title: poOrderCheck</p> 
	* <p>Description:手持PO_按照输入的单号，验证单号是否存在可扫，如果单号不存在则提示需要下载输入的单号 </p> 
	* @param dto
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.po.service.PoPDAServiceClient#poOrderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String) 
	*/
	@Override
	public OrderCheckOutDTO poOrderCheck(OrderCheckInDTO dto, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		// 检查版本号 与 用户信息
		RfLogResult rfLogResult = poPDAService.checkSign(dto.getUser(),dto.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			// 入库
			result = stgPoDownService.checkPo(dto);

		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(dto.getUser(), "PO_PDA_Check", dto.getSign(),
			context, result.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), dto, result);
	
		return result;
	}

	
	/* (非 Javadoc) 
	* <p>Title: giftPoOrderCheck</p> 
	* <p>Description: </p> 
	* @param dto
	* @param version
	* @return 
	* @see com.haier.openplatform.wms.po.service.PoPDAServiceClient#giftPoOrderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String) 
	*/
	@Override
	public OrderCheckOutDTO giftPoOrderCheck(OrderCheckInDTO dto, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		// 检查版本号 与 用户信息
		RfLogResult rfLogResult = poPDAService.checkSign(dto.getUser(),dto.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			// 入库
			result = stgPoDownService.checkGiftPo(dto);

		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(dto.getUser(), "PO_PDA_Check", dto.getSign(),
			context, result.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), dto, result);
	
		return result;
	}
	
	/**
	 * 手持PO_调用SAP接口，下载PO
	 */
	@Override
	public OrderLoadOutDTO poOrderDownload(OrderLoadInDTO inpara, String version) {
		String result = "";
		OrderLoadOutDTO outResult = new OrderLoadOutDTO();
		// 接口调用开始时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			result = stgPoDownService.downloadPo(inpara.getOrno(), null, null, inpara.getUser());
			if ("S".equals(result)){
				outResult.setStatus("S");
				outResult.setMsg("SUCCESS");
				outResult.setWlList(stgPoDownService.getPoMaterialList(inpara.getOrno()));
			} else {
				outResult.setStatus("F");
				outResult.setMsg("Sap download nothing!");
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Downoad", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持PO_删除
	 */
	@Override
	public OrderDeleteOutDTO poOrderDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    // 调用service
			outResult = poPDAService.poOrderDelete(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Delete", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}
	
	/**
	 * 手持PO_删除
	 */
	@Override
	public OrderDeleteOutDTO giftPoOrderDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    // 调用service
			outResult = poPDAService.giftPoOrderDelete(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Delete", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持PO_删除
	 */
	@Override
	public OrderDeleteOutDTO poOrdersDelete(OrderDeleteInDTO inpara, String version) {
		Date startDate = new Date();
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);

		// 调用Service
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
			String[] barcodes = inpara.getBarcode().split(",");
			for (String barcode : barcodes) {
				inpara.setBarcode(barcode);
				outResult = poPDAService.poOrderDelete(inpara);
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}

		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		Date endDate = new Date();
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Delete", inpara.getSign(),
				context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持PO_过账
	 */
	@Override
	public OrderIgpOutDTO poOrderIgp(OrderIgpInDTO inpara, String version) {
		logger.debug("Entering PoOrderIgp...");
		Date startDate = new Date();
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    logger.debug("Sign check successful...");
		    // 调用service po入库
		    outResult = poPDAService.poOrderIgp(inpara);
		    if ("0".equals(outResult.getStatus())) {
		    	String result = stgPoDownService.postPo(outResult.getOrId(), 
		    			inpara.getOrderType(), inpara.getReturnType(), "0", inpara.getUser());
				if ("1".equals(inpara.getOrderType())){
//					String result = new PostPoToSap(orderNo, sapFlag, userName).exchangeWithSap();
					if("S".equalsIgnoreCase(result)){
						outResult.setMsg("S");
						OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
						inpara.setOrno(outResult.getOrId());
						ret = stgPoDownService.poGoodsReceive(inpara);
						if ("0".equals(ret.getStatus())){
							outResult.setStatus("S");
							outResult.setMsg(ret.getMsg());
						} else {
							outResult.setStatus("F");
							outResult.setMsg(ret.getMsg());
						}
					}else {
						outResult.setStatus("F");
						outResult.setMsg("PO Posting error!");
					}
				} else {
//					String result =  new ReversePoToSap(orderNo, sapFlag , userName, returnType).exchangeWithSap();
					if("S".equalsIgnoreCase(result)){
						outResult.setMsg("S");
						OrderGoodsTransOutDTO ret = new OrderGoodsTransOutDTO();
						inpara.setOrno(outResult.getOrId());
						ret = stgPoDownService.poGoodsDelivery(inpara);
						if ("0".equals(ret.getStatus())){
							outResult.setStatus("S");
							outResult.setMsg(ret.getMsg());
						} else {
							outResult.setStatus("F");
							outResult.setMsg(ret.getMsg());
						}
					}else {
						outResult.setStatus("F");
						outResult.setMsg("PO Posting error!");
					}
				}
		    }

		} else {
		    outResult.setStatus(rfLogResult.getStatus());
		    outResult.setMsg(rfLogResult.getMsg());
		}
		
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Igp", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		logger.debug("Exiting PoOrderIgp...");
		return outResult;
	}

	/**
	 * 手持PO_过账
	 */
	@Override
	public OrderIgpOutDTO giftPoOrderIgp(OrderIgpInDTO inpara, String version) {
		logger.debug("Entering GiftPoOrderIgp...");
		Date startDate = new Date();
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(),version);
		
		// 调用Service
		OrderIgpOutDTO outResult = new OrderIgpOutDTO();
		if ("S".equals(rfLogResult.getStatus())) {
		    logger.debug("Sign check successful...");
		    // 调用service po入库
		    outResult = poPDAService.giftPoOrderIgp(inpara);
		    
		    if ("0".equals(outResult.getStatus())) {
		    	String result = stgPoDownService.postPo(outResult.getOrId(), 
		    			inpara.getOrderType(), inpara.getReturnType(), "0", inpara.getUser());
				if("S".equalsIgnoreCase(result)){
					outResult.setMsg("S");
					inpara.setOrno(outResult.getOrId());
					OrderGoodsTransOutDTO ret = stgPoDownService.giftPoGoodsReceive(inpara);
					if ("0".equals(ret.getStatus())){
						outResult.setStatus("S");
						outResult.setMsg(ret.getMsg());
					} else {
						outResult.setStatus("F");
						outResult.setMsg(ret.getMsg());
					}
				}else {
					outResult.setStatus("F");
					outResult.setMsg("PO Posting error!");
				}
			} 
		} else {
		    outResult.setStatus(rfLogResult.getStatus());
		    outResult.setMsg(rfLogResult.getMsg());
		}
		
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(inpara.getUser(), "GIFT_PO_PDA_Igp", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		logger.debug("Exiting GiftPoOrderIgp...");
		return outResult;
	}
	
	/**
	 * 手持PO_查询条码明细
	 */
	@Override
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
		OdsPoScanInfoDTO dto = new OdsPoScanInfoDTO();
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		Date startDate = new Date();
		// 权限校验
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
		// 拼装查询条件
		dto.setPoNo(inpara.getOrderNo());
		dto.setScannedBy(inpara.getUser());
		dto.setOrderType(inpara.getOrderType());
		dto.setFinishFlag("0");   //未汇总
		// 引用 OdsPoScanInfoService
		OdsPoScanInfoService service = SpringApplicationContextHolder
				.getBean("odsPoScanInfoService");
		// 按照条件查询到想要的结果
		List<OdsPoScanInfoDTO> list = service.getOdsPoScanInfos(dto);
		if (list == null) {
			return outResult;
		}
		// 把查询结果拼装成想要的列表返回
		for (OdsPoScanInfoDTO info : list) {
			OrderDelDetialDTO tempDTO = new OrderDelDetialDTO();
			tempDTO.setRowId(info.getRowId().toString());
			tempDTO.setBarcode(info.getBarcode());
			tempDTO.setQty(info.getQty().toString());
			tempDTO.setSapOrderNo(info.getPoNo());
			tempDTO.setRowId(info.getRowId().toString());
			detial.add(tempDTO);
		}
		outResult.setTotal(list.size() + "");
		outResult.setDetial(detial);

		Date endDate = new Date();
		// PDA 日志记录
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_GetDetailList",
				inpara.getSign(), context, "", CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持PO_扫描订单
	 */
	@Override
	public OrderUploadOutDTO poOrderScan(OrderUploadInDTO inpara, String version) {
		logger.debug("Entering PoPDA_OrderScan......");

		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
		if ("S".equals(rfLogResult.getStatus())) {
			outResult = poPDAService.scanPoCheck(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Upload", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}

	/**
	 * 手持PO_扫描订单
	 */
	@Override
	public OrderUploadOutDTO giftPoOrderScan(OrderUploadInDTO inpara, String version) {
		logger.debug("Entering PoPDA_OrderScan......");

		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = poPDAService.checkSign(inpara.getUser(), inpara.getSign(), version);
		if ("S".equals(rfLogResult.getStatus())) {
			outResult = poPDAService.scanGiftPoCheck(inpara);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Upload", inpara.getSign(),
			context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}



	//直发派遣直接导入po订单和形成了
	@Override
	public OrderUploadOutDTO poOrderScanExcel(OrderUploadInDTO inpara) {
		logger.debug("Entering PoPDA_OrderScan......");
		// 调用时间
		Date startDate = new Date();
		OrderUploadOutDTO outResult = poPDAService.scanPoCheck(inpara);
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		poPDAService.writeLog(inpara.getUser(), "PO_PDA_Upload", inpara.getSign(),
				context, outResult.getStatus(), CommonTool.getFormatDateToStr(startDate),
				CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}
}
