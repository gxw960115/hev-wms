package com.haier.openplatform.wms.stocktaking.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.remoting.rf.domain.RfLogResult;
import com.haier.hevwms.remoting.rf.service.RfWsService;
import com.haier.hevwms.takestock.domain.OdsPdInfo;
import com.haier.hevwms.takestock.service.OdsPdInfoService;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

/**
* @ClassName: StocktakingServiceClientImpl
* @Description: 库存盘点单 新增、修改orderStatus状态、导出功能
* @author linzongxiao
* @Date 2015-10-30 下午2:14:30
*/
//@Path("StocktakingServiceClientImpl")
//@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//参数类型
//@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//返回值类型
public class StocktakingServiceClientImpl implements StocktakingServiceClient {
   
	Logger logger = Logger.getLogger(StocktakingServiceClientImpl.class);
	@Resource
	private WebServiceContext context;
	private RfWsService rfWsService;
	
	private OdsPdInfoService odsPdInfoService;//处理具体的业务逻辑 biz层的类
    
    /**
    * @Title: getOdsPdInfoService
    * @Description: getter方法
    * @param @return
    * @return OdsPdInfoService
    * @throws
    */
    public OdsPdInfoService getOdsPdInfoService() {
        return odsPdInfoService;
    }
    /**
    * @Title: setOdsPdInfoService
    * @Description: setter方法
    * @param @param odsPdInfoService
    * @return void
    * @throws
    */
    public void setOdsPdInfoService(OdsPdInfoService odsPdInfoService) {
        this.odsPdInfoService = odsPdInfoService;
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
	/**
    * <p>Title: addStocktakingOrder</p>
    * <p>Description:新增 库存盘点单  </p>
    * @param odsPdInfoDTO
    * @return
    * @see com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient#addStocktakingOrder(com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO)
    */
    
    public String addStocktakingOrder(OdsPdInfoDTO dto) {
       /* OdsPdInfo odsPdInfo=new OdsPdInfo();//biz层实体类，对应库存盘点单 ods_pd_info
        try {
            BeanUtils.copyProperties(odsPdInfo,dto);//将出入的dto转成biz层使用的domain实体类
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        ExecuteResult<OdsPdInfo> result=odsPdInfoService.createOdsPdInfo(odsPdInfo);//新增 库存盘点单
*/      /*  if (!result.isSuccess()){
        	logger.debug("创建盘点失败：plant:"+odsPdInfo.getPlant()+",location:"+odsPdInfo.getLocation()
        					+",materialNo:"+odsPdInfo.getMaterialNo()+",msg:"
        							+result.getErrorMessages()+"可能当前位置有未完成的盘点单，不允许创建");
            return "plant:"+odsPdInfo.getPlant()+",location:"+odsPdInfo.getLocation()
				+",materialNo:"+odsPdInfo.getMaterialNo()+" "+"fail;";
        }*/
        return "SUCCESS";
    }
    
    /**
    * <p>Title: searchStocktakingOrder</p>
    * <p>Description:查询 库存盘点单 明细 </p>
    * @param page
    * @param rows
    * @param odsPdInfoDTO
    * @return
    * @see com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient#searchStocktakingOrder(long, long, com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO)
    */
    @Override
    public Pager<OdsPdInfoDTO> searchStocktakingOrder(long page, long rows,
            OdsPdInfoDTO odsPdInfoDTO) {
        OdsPdInfo odsPdInfo=new OdsPdInfo();//biz层实体类，对应库存盘点单 ods_pd_info
        try {
            BeanUtils.copyProperties(odsPdInfo,odsPdInfoDTO);//将出入的dto转成biz层使用的domain实体类
        } catch (IllegalAccessException e1) {
            
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            
            e1.printStackTrace();
        }
        
        Pager<OdsPdInfo> pager=new Pager<OdsPdInfo>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        
        Pager<OdsPdInfoDTO> pagerDTO = new Pager<OdsPdInfoDTO>();
        Pager<OdsPdInfo> temp=odsPdInfoService.searchOdsPdInfos(pager,odsPdInfo);
        long totalSize=temp.getTotalRecords();
        List<OdsPdInfo> listInfo = temp.getRecords();
        List<OdsPdInfoDTO> list = new ArrayList<OdsPdInfoDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(OdsPdInfo info : listInfo){
            OdsPdInfoDTO dto = new OdsPdInfoDTO();
            try {
                BeanUtils.copyProperties(dto,info);
                list.add(dto);
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
    }
    
    /**
    * <p>Title: openStocktakingOrder</p>
    * <p>Description: 库存盘点单 打开，将orderStatus状态置成1</p>
    * @param odsPdInfoDTO
    * @return
    * @see com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient#openStocktakingOrder(com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO)
    */
    @POST
    @Path("updateStocktakingOrder")
    @Override
    public String updateStocktakingOrder(OdsPdInfoDTO odsPdInfoDTO) {
        logger.debug("Entering updateStocktakingOrder...");
        OdsPdInfo odsPdInfo=new OdsPdInfo();
        try {
            BeanUtils.copyProperties(odsPdInfo, odsPdInfoDTO);//将出入的dto转成biz层使用的domain实体类
            odsPdInfo.setModifyBy(UserUtil.getCurrentUser().getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        ExecuteResult<OdsPdInfo> result=odsPdInfoService.updateOrderStatus(odsPdInfo);
        if(result.isSuccess()) {
        	return "success";
        }
        return "error!";
    }
    
    @Override
    public List<OdsPdInfoDTO> getOdsPdInfo(OdsPdInfoDTO odsPdInfoDTO) {
        OdsPdInfo odsPdInfo = new OdsPdInfo();
        try {
            BeanUtils.copyProperties(odsPdInfo, odsPdInfoDTO);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        List<OdsPdInfo> temp=odsPdInfoService.getOdsPdInfo(odsPdInfo);
        List<OdsPdInfoDTO> list=new ArrayList<OdsPdInfoDTO>();
        for(OdsPdInfo dtl:temp){
            OdsPdInfoDTO dto=new OdsPdInfoDTO();
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
    @POST
    @Path("getStocktakingOrderNo")
    @Override
    public String getStocktakingOrderNo() {
        String orderNo=odsPdInfoService.selectStocktakingOrderNo();
        return "P"+orderNo;
    }
    /**
    * <p>Title: addStocktakingOrders</p>
    * <p>Description:StocktakingOrder页面的Add功能，save方法 </p>
    * @param odsPdInfoDTO
    * @param pds
    * @see com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient#addStocktakingOrders(com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO, java.util.List)
    */
    @Override
    public String addStocktakingOrders(OdsPdInfoDTO odsPdInfoDTO,
            List<OdsPdInfoDTO> pds) {
        BaseUser user = UserUtil.getCurrentUser();
        String userName="";
        try {
            userName=user.getName();
        } catch (Exception e) {
            return "cant't get user name,please login again!";
        }
        String msg="SUCCESS";
        for(OdsPdInfoDTO mat:pds){//遍历,插入数据库中
            OdsPdInfoDTO des=new OdsPdInfoDTO(); 
            des.setOrderNo(odsPdInfoDTO.getOrderNo());
//            des.setWarehouseCode(odsPdInfoDTO.getWarehouseCode());
//            des.setWarehouseName(odsPdInfoDTO.getWarehouseName());
            des.setPlant(odsPdInfoDTO.getPlant());
            des.setLocation(mat.getLocation());
            des.setMaterialNo(mat.getMaterialNo());
            des.setBin(mat.getCode());
//            des.setCustomerModel(mat.getCustomerModel());
            des.setUnit(mat.getBasicUnit());
            des.setMaterialDesp(mat.getMaterialDesp());
            des.setCreateBy(userName);
            des.setCreateDate(odsPdInfoDTO.getCreateDate());
            des.setOrderStatus("0");
            des.setUnit(mat.getBasicUnit());
            Date now = new Date();
            des.setBeginDate(now);
            des.setEndDate(now);
            des.setModifyDate(now);
            
            OdsPdInfo odsPdInfo=new OdsPdInfo();//biz层实体类，对应库存盘点单 ods_pd_info
            try {
                BeanUtils.copyProperties(odsPdInfo,des);//将出入的dto转成biz层使用的domain实体类
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (InvocationTargetException e1) {
                e1.printStackTrace();
            }
            String result=odsPdInfoService.createOdsPdInfo(odsPdInfo);//新增 库存盘点单
            if (!"SUCCESS".equals(result)){
                logger.debug("创建盘点失败：plant:"+odsPdInfo.getPlant()+",location:"+odsPdInfo.getLocation()
                                +",materialNo:"+odsPdInfo.getMaterialNo()+",msg:"+"可能当前位置有未完成的盘点单，不允许创建");
                return result;
            }
           /* msg=addStocktakingOrder(des);
            if (!"SUCCESS".equals(msg)) {
				return msg;
			}*/
        }
        return msg;
    }
    /**
     * 
    * <p>Title: deleteStocktakingOrder</p>
    * <p>Description: </p>
    * @param odsPdInfoDTO
    * @return
    * @see com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient#deleteStocktakingOrder(com.haier.openplatform.wms.stocktaking.dto.OdsPdInfoDTO)
     */
    @Override
    public String deleteStocktakingOrder(OdsPdInfoDTO odsPdInfoDTO) {
    	BaseUser user = UserUtil.getCurrentUser();
    	if (user==null){
    		return "Update failed,Can't get The login User,Please login again";
    	}
    	if(odsPdInfoDTO.getCreateBy().equalsIgnoreCase(user.getName())){
    		OdsPdInfo odsPdInfo=new OdsPdInfo();
            try {
                BeanUtilEx.copyProperties(odsPdInfo, odsPdInfoDTO);//将出入的dto转成biz层使用的domain实体类
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                
                e.printStackTrace();
            }
            ExecuteResult<OdsPdInfo> result=odsPdInfoService.deleteOrder(odsPdInfo);
            if(result.isSuccess())
                return "success";
            return "error!";
        } else {
        	return "You Can't delete,Because This StockingOrder Is Not Create by You!";
        }
    }
    
	@Override
	public Long searchOdsPdInfosCount(OdsPdInfoDTO dto) {
		OdsPdInfo odsPdInfo=new OdsPdInfo();//biz层实体类，对应库存盘点单 ods_pd_info
        try {
            BeanUtils.copyProperties(odsPdInfo,dto);//将出入的dto转成biz层使用的domain实体类
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
		return odsPdInfoService.searchOdsPdInfosCount(odsPdInfo);
	}
	
	/* (non-Javadoc)
	 * @see com.haier.openplatform.wms.stocktaking.service.StocktakingServiceClient#orderCheck(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO, java.lang.String)
	 */
	@Override
	public OrderCheckOutDTO orderCheck(OrderCheckInDTO inpara, String version) {
		OrderCheckOutDTO result = new OrderCheckOutDTO();
		Date startDate = new Date();
		RfLogResult rfLogResult = rfWsService.checkSign(inpara.getUser(),inpara.getSign(),version);
		if ("S".equals(rfLogResult.getStatus())) {
			if("PD".equals(inpara.getDoctype())) {
				result = odsPdInfoService.checkPdInfo(inpara);
			} 
		} else {
		    result.setStatus(rfLogResult.getStatus());
		    result.setMsg(rfLogResult.getMsg());
		}
		// 返回时间
		Date endDate = new Date();
		// RF日志记录，记录：登陆账号、签名、IP地址、操作状态、入参内容、出参内容、调用时间、返回时间
		rfWsService.writeLog(inpara.getUser(), "StockTaking_Order_Check", inpara.getSign(),
			context, result.getStatus(),
			CommonTool.getFormatDateToStr(startDate),
			CommonTool.getFormatDateToStr(endDate), inpara, result);
	
		return result;
	}
}
