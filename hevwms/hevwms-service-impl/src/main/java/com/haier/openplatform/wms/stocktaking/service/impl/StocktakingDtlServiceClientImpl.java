package com.haier.openplatform.wms.stocktaking.service.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.hevwms.takestock.service.OdsPdInfoDtlService;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingDtlServiceClient;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.ws.WebServiceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Path("StocktakingDtlServiceClientImpl")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//参数类型
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//返回值类型
public class StocktakingDtlServiceClientImpl implements StocktakingDtlServiceClient {
	
	/**  
	 * @Fields log: 用一句话描述该文件做什么
	 */
	private static final Logger log = LoggerFactory.getLogger(StocktakingDtlServiceClientImpl.class);
	
	@Resource
	private WebServiceContext context;
	private RfWsService rfWsService;
    private OdsPdInfoDtlService odsPdInfoDtlService;

    public OdsPdInfoDtlService getOdsPdInfoDtlService() {
        return odsPdInfoDtlService;
    }

    public void setOdsPdInfoDtlService(OdsPdInfoDtlService odsPdInfoDtlService) {
        this.odsPdInfoDtlService = odsPdInfoDtlService;
    }

    public WebServiceContext getContext() {
		return context;
	}

	public void setContext(WebServiceContext context) {
		this.context = context;
	}

	public RfWsService getRfWsService() {
		return rfWsService;
	}

	public void setRfWsService(RfWsService rfWsService) {
		this.rfWsService = rfWsService;
	}

	@Override
    public Pager<OdsPdInfoDtlDTO> searchStocktakingOrderDtl(long page,long rows, OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
        OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
        try {
            BeanUtils.copyProperties(odsPdInfoDtl, odsPdInfoDtlDTO);
        } catch (IllegalAccessException e) {
            
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            
            e.printStackTrace();
        }
        // 组装分页信息，作为查询条件
        Pager<OdsPdInfoDtl> pager = new Pager<OdsPdInfoDtl>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);

        Pager<OdsPdInfoDtlDTO> pagerDTO = new Pager<OdsPdInfoDtlDTO>();// 方法 返回的
                                                                       // 结果集

        Pager<OdsPdInfoDtl> temp = odsPdInfoDtlService.searchOdsPdInfoDtls(pager, odsPdInfoDtl);
        long totalSize = temp.getTotalRecords();// 查询结果集 总条数
        List<OdsPdInfoDtl> listInfo = temp.getRecords();// 得到List<OdsPdInfoDtl>结果集
        // 循环遍历并转型
        List<OdsPdInfoDtlDTO> list = new ArrayList<OdsPdInfoDtlDTO>();
        
        for (OdsPdInfoDtl dtl : listInfo) {
            OdsPdInfoDtlDTO dto = new OdsPdInfoDtlDTO();
            try {
                BeanUtils.copyProperties(dto, dtl);
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                
                e.printStackTrace();
            }
            list.add(dto);
        }

        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);

        return pagerDTO;
    }

    @Override
    public List<OdsPdInfoDtlDTO> getOdsPdInfoDtls(
            OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
        OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
        try {
            BeanUtils.copyProperties(odsPdInfoDtl, odsPdInfoDtlDTO);
        } catch (IllegalAccessException e) {
            
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            
            e.printStackTrace();
        }
        List<OdsPdInfoDtl> temp=odsPdInfoDtlService.getOdsPdInfoDtls(odsPdInfoDtl);
        List<OdsPdInfoDtlDTO> list=new ArrayList<OdsPdInfoDtlDTO>();
        for(OdsPdInfoDtl dtl:temp){
            OdsPdInfoDtlDTO dto=new OdsPdInfoDtlDTO();
            try {
                BeanUtils.copyProperties(dto, dtl);
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                
                e.printStackTrace();
            }
            list.add(dto);
        }
        return list;
    }

    @Override
    public Pager<OdsPdInfoDtlDTO> searchStocktakingOrderDtlSum(long page,
            long rows, OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
        // 组装分页信息，作为查询条件
        Pager<OdsPdInfoDtl> pager = new Pager<OdsPdInfoDtl>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        //调用biz层执行查询
        OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
        try {
            BeanUtils.copyProperties(odsPdInfoDtl, odsPdInfoDtlDTO);
        } catch (IllegalAccessException e) {
            
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            
            e.printStackTrace();
        }
        Pager<OdsPdInfoDtl> temp=odsPdInfoDtlService.searchOdsPdInfoDtlsBySum(pager, odsPdInfoDtl);
        long totalSize = temp.getTotalRecords();// 查询结果集 总条数
        List<OdsPdInfoDtl> listInfo = temp.getRecords();// 得到List<OdsPdInfoDtl>结果集
        // 循环遍历并转型
        List<OdsPdInfoDtlDTO> list = new ArrayList<OdsPdInfoDtlDTO>();
        for (OdsPdInfoDtl dtl : listInfo) {
            OdsPdInfoDtlDTO dto = new OdsPdInfoDtlDTO();
            try {
                BeanUtils.copyProperties(dto, dtl);
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                
                e.printStackTrace();
            }
            list.add(dto);
        }
        Pager<OdsPdInfoDtlDTO> pagerDTO = new Pager<OdsPdInfoDtlDTO>();
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
    }

	@Override
	public List<OdsPdInfoDtlDTO> searchStocktakingOrderDtlSumList(
			OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
		OdsPdInfoDtl dtl =new OdsPdInfoDtl();
		try {
			BeanUtilEx.copyProperties(dtl, odsPdInfoDtlDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<OdsPdInfoDtl> dtls=odsPdInfoDtlService.searchOdsPdInfoDtlsBySum2(dtl);
		List<OdsPdInfoDtlDTO> dtos=new ArrayList<OdsPdInfoDtlDTO>();
		for (OdsPdInfoDtl dtl2 : dtls) {
			OdsPdInfoDtlDTO dto=new OdsPdInfoDtlDTO();
			try {
				BeanUtilEx.copyProperties(dto, dtl2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public Pager<OdsPdInfoDtlDTO> getPdQtyDetail(Long page, Long rows,
		OdsPdInfoDtlDTO odsPdInfoDtlDTO) {
	    Pager<OdsPdInfoDtl> pager = new Pager<OdsPdInfoDtl>();
//	        pager.setCurrentPage(page);
//	        pager.setPageSize(rows);
	        //调用biz层执行查询
	        OdsPdInfoDtl odsPdInfoDtl = new OdsPdInfoDtl();
	        try {
	            BeanUtils.copyProperties(odsPdInfoDtl, odsPdInfoDtlDTO);
	        } catch (IllegalAccessException e) {
	            
	            e.printStackTrace();
	        } catch (InvocationTargetException e) {
	            
	            e.printStackTrace();
	        }
	        Pager<OdsPdInfoDtl> temp=odsPdInfoDtlService.pdQtyDetail(pager, odsPdInfoDtl);
	        long totalSize = temp.getTotalRecords();// 查询结果集 总条数
	        List<OdsPdInfoDtl> listInfo = temp.getRecords();// 得到List<OdsPdInfoDtl>结果集
	        // 循环遍历并转型
	        List<OdsPdInfoDtlDTO> list = new ArrayList<OdsPdInfoDtlDTO>();
	        for (OdsPdInfoDtl dtl : listInfo) {
	            OdsPdInfoDtlDTO dto = new OdsPdInfoDtlDTO();
	            try {
	                BeanUtils.copyProperties(dto, dtl);
	            } catch (IllegalAccessException e) {
	                
	                e.printStackTrace();
	            } catch (InvocationTargetException e) {
	                
	                e.printStackTrace();
	            }
	            list.add(dto);
	        }
	        Pager<OdsPdInfoDtlDTO> pagerDTO = new Pager<OdsPdInfoDtlDTO>();
	        pagerDTO.setRecords(list);
	        pagerDTO.setTotalRecords(totalSize);
	        return pagerDTO;
	}
	
	@Override
	public Long getPdExportAmount(OdsPdInfoDtlDTO dto) {
		OdsPdInfoDtl dtl =new OdsPdInfoDtl();
		try {
			BeanUtilEx.copyProperties(dtl, dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return odsPdInfoDtlService.getPdExportAmount(dtl);
	}
	
	@Override
	public Long searchOdsPdInfoDtlsCountBySum(OdsPdInfoDtlDTO dto) {
		OdsPdInfoDtl dtl =new OdsPdInfoDtl();
		try {
			BeanUtilEx.copyProperties(dtl, dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return odsPdInfoDtlService.searchOdsPdInfoDtlsCountBySum(dtl);
	}

	@Override
	public OrderDeleteOutDTO orderDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		WmsOrderDeleteIn in = new WmsOrderDeleteIn();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		BeanUtils.copyProperties(in, inpara);
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(),in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
		    // 调用service
			outResult = odsPdInfoDtlService.orderDelete(in);
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(in.getUser(), "StockTaking_Order_Delete", in.getSign(),
			context, outResult.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), in, outResult);
		return outResult;
	}
	@Override
	public OrderDeleteOutDTO ordersDelete(OrderDeleteInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		WmsOrderDeleteIn in = new WmsOrderDeleteIn();
		OrderDeleteOutDTO outResult = new OrderDeleteOutDTO();
		BeanUtils.copyProperties(in, inpara);
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(in.getUser(),in.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			String[] barcodes = inpara.getBarcode().split(",");
			for (int i = 0; i <barcodes.length; i++) {
				in.setBarcode(barcodes[i]);
				// 调用service
				outResult = odsPdInfoDtlService.orderDelete(in);
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(in.getUser(), "StockTaking_Order_Delete", in.getSign(),
			context, outResult.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), in, outResult);
		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.stocktaking.service.StocktakingDtlServiceClient#orderScan(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO, java.lang.String)
	 */
	@Override
	public OrderUploadOutDTO orderScan(OrderUploadInDTO inpara, String version) throws IllegalAccessException, InvocationTargetException {
		log.debug("Entering StockTaking Order Scan......");
		OrderUploadOutDTO outResult = new OrderUploadOutDTO();
		// 调用时间
		Date startDate = new Date();
	
		// 权限校验
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if ("PD".equals(inpara.getDoctype())) {
				outResult = odsPdInfoDtlService.scanStockTaking(inpara);
			}
		} else {
			outResult.setStatus(rfLogResult.getStatus());
			outResult.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		BeanUtils.copyProperties(outResult, outResult);
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "StockTaking_Order_Upload", inpara.getSign(),
			context, outResult.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
	
		return outResult;
	}

	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.stocktaking.service.StocktakingDtlServiceClient#barcodeList(com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO)
	 */
	@Override
	public WmsOrderDelListOutDTO barcodeList(WmsOrderDelListInDTO inpara) {
		WmsOrderDelListOutDTO outResult = new WmsOrderDelListOutDTO();
		// 调用时间
		Date startDate = new Date();
		// 权限校验
		List<OrderDelDetialDTO> detial = new ArrayList<OrderDelDetialDTO>();
	    if ("PD".equals(inpara.getDocType())) {
	    	OdsPdInfoDtl dtl = new OdsPdInfoDtl();
			dtl.setOrderNo(inpara.getOrderNo());
			dtl.setCreateBy(inpara.getUser());
			List<OdsPdInfoDtl> list = odsPdInfoDtlService.getOdsPdInfoDtls(dtl);
			if (list == null) {
			    return outResult;
			}
			for (OdsPdInfoDtl odsPdInfoDtl : list) {
			    OrderDelDetialDTO dto = new OrderDelDetialDTO();
			    dto.setBarcode(odsPdInfoDtl.getBarcode());
			    dto.setQty(odsPdInfoDtl.getQty().toString());
			    dto.setSapOrderNo(odsPdInfoDtl.getOrderNo());
			    dto.setRowId(odsPdInfoDtl.getRowId().toString());
			    dto.setLocation(odsPdInfoDtl.getLocation());
			    dto.setBin(odsPdInfoDtl.getBin());
			    detial.add(dto);
			}
			outResult.setTotal(list.size() + "");
		}
	    outResult.setDetial(detial);
		// 调用时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "Customer_Order_GetCarlist",
			inpara.getSign(), context, "",
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, outResult);
		return outResult;
	}
}
