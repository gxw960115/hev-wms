package com.haier.hevwms.so.service.impl;

import com.haier.hevwms.sapinterface.*;

import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.so.dao.SoPDADAO;
import com.haier.hevwms.so.dao.StgDnDownDAO;
import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.*;
import com.haier.openplatform.wms.security.dto.UserDTO;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import org.apache.log4j.Logger;

import java.util.List;

public class StgDnDownServiceImpl implements StgDnDownService {
    /**
     * Logger
     */
    private Logger logger = Logger.getLogger(StgDnDownServiceImpl.class);

    private StgDnDownDAO stgDnDownDAO;
    
    private UserDAO userDAO;

    private SoPDADAO soPDADAO;

    public SoPDADAO getSoPDADAO() {
        return soPDADAO;
    }

    public void setSoPDADAO(SoPDADAO soPDADAO) {
        this.soPDADAO = soPDADAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setStgDnDownDAO(StgDnDownDAO stgDnDownDAO) {
        this.stgDnDownDAO = stgDnDownDAO;
    }

    public StgDnDownDAO getStgDnDownDAO() {
        return stgDnDownDAO;
    }

    /* (非 Javadoc) 
    * <p>Title: searchStgDnDowns</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#searchStgDnDowns(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
    */
    @Override
    public Pager<StgDnDownDTO> searchStgDnDowns(Pager<StgDnDownDTO> pager, StgDnDownDTO dto) {
        long size = stgDnDownDAO.searchStgDnDownsCount(dto);
        List<StgDnDownDTO> stgDnDowns = stgDnDownDAO.searchStgDnDownListByPage(pager, dto);
        return Pager.cloneFromPager(pager, size, stgDnDowns);
    }

    /* (非 Javadoc) 
    * <p>Title: searchStgDnReverse</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#searchStgDnReverse(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
    */
    @Override
    public Pager<StgDnDownDTO> searchStgDnReverse(Pager<StgDnDownDTO> pager, StgDnDownDTO dto) {
        long size = stgDnDownDAO.searchStgDnDownsCount(dto);
        List<StgDnDownDTO> stgDnDowns = stgDnDownDAO.searchStgDnReverse(pager, dto);
        return Pager.cloneFromPager(pager, size, stgDnDowns);
    }

    /* (非 Javadoc) 
    * <p>Title: getStgDnDownsByParam</p> 
    * <p>Description: </p> 
    * @param stgDnDown
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#getStgDnDownsByParam(com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
    */
    @Override
    public List<StgDnDownDTO> getStgDnDownsByParam(StgDnDownDTO stgDnDown) {
        return stgDnDownDAO.getStgDnDownListByParam(stgDnDown);
    }

    /** 
    * @Title: getStgDnDownById 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param stgDnDownId
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return StgDnDownDTO    返回类型 
    * @throws 
    */
    public StgDnDownDTO getStgDnDownById(Long stgDnDownId) {
        return stgDnDownDAO.get(stgDnDownId);
    }

    /** 
    * @Title: getStgDnDowns 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年4月30日
    * @return List<StgDnDownDTO>    返回类型 
    * @throws 
    */
    public List<StgDnDownDTO> getStgDnDowns() {
        return stgDnDownDAO.getAll();
    }

    /* (非 Javadoc) 
    * <p>Title: getExportAmount</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#getExportAmount(com.haier.openplatform.wms.so.dto.StgDnDownDTO) 
    */
    @Override
    public Long getExportAmount(StgDnDownDTO dto) {
        return stgDnDownDAO.searchStgDnDownsCount(dto);
    }
    
    /* (非 Javadoc) 
    * <p>Title: checkSo</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#checkSo(com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO) 
    */
    @Override
    public OrderCheckOutDTO checkSo(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String errorMsg = "";
		// 获取是否是正常订单 正常订单SELL_ORDER_TYPE ！= VLF
		String result = stgDnDownDAO.checkSoExist(dto);
		if ("Close".equals(result)){
			errorMsg = "Order has been closed!";
		} else if ("Not Support".equals(result)){
		    errorMsg = "Wms doesn't support this dn type!";
		} else if (result == null||"".equals(result)){
			errorMsg = "Order doens't exist!";
		} else if (!result.equalsIgnoreCase(dto.getDnType())){
			errorMsg = "Please scan the order in "+result+" page!";
		} else {
			// 根据用户名获取用户信息
			UserDTO user = userDAO.getUserByName(dto.getUser());
			// 判定用户类型
			if ("3".equals(user.getDutyType())){
				result = stgDnDownDAO.checkSoLoc(dto, user.getId());
				if (!"Y".equals(result)){
					errorMsg = "User has no authority to scan this order!";
				}
			}
		}
		if ("".equals(errorMsg)){
			out.setStatus("S");
			out.setMsg("Order has been download, please scan!");
            List<OrderMatListDTO> soMaterialList = stgDnDownDAO.getSoMaterialListByFIFO(dto.getOrno());
            out.setWlList(soMaterialList);
		} else {
			out.setStatus("F");
			out.setMsg(errorMsg);
		}
		return out;
    }

    /* (非 Javadoc) 
    * <p>Title: downloadDnFromSAP</p> 
    * <p>Description: </p> 
    * @param soNo
    * @param beginTime
    * @param endTime
    * @param userName
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#downloadDnFromSAP(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
    */
    @Override
    public InterfaceOutDTO downloadDnFromSAP(String soNo, String beginTime, String endTime, String userName) {
        logger.info("Download PO start with orderNo: " + soNo + ", begin: " + beginTime + ", end: " + endTime + ", user: " + userName);
        InterfaceOutDTO result = new InterfaceOutDTO();
//        logger.info("Start TMS SO download...");
//        result = new DownloadSoDnFromTMS(soNo, beginTime, endTime, userName).exchangeWithTMS();
//        if("E".equals(result.getStatus())) {
//            logger.info("TMS download failed! Download in SAP");
            result = new DownloadDnFromSap(soNo, beginTime, endTime, userName).exchangeWithSap();
//        }
        logger.info("Download SO:" + result.toString());
        return result;    }

    /* (非 Javadoc) 
    * <p>Title: postDn</p> 
    * <p>Description: </p> 
    * @param orderNo
    * @param orderType
    * @param sapFlag
    * @param userName
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#postDn(java.lang.String, java.lang.String, java.lang.String, java.lang.String) 
    */
    @Override
    public InterfaceOutDTO postDn(String orderNo, String orderType, String sapFlag, String userName) {
        logger.info("Post DN start with orderNo: " + orderNo + ", orderType: " + orderType + ", sapFlag: " + sapFlag + ", userName: " + userName);
        InterfaceOutDTO result = null;
        //查询DN来源
        String[] arr = orderNo.split(",");
        for(int i = 0; i < arr.length; i++) {
            String comeFromTMS = stgDnDownDAO.getComeFromTMS(arr[i]);
            if("TMS".equals(comeFromTMS)) {
                logger.info("Post DN start To TMS");
                result = new PostDnToTMS(orderNo, sapFlag,userName).exchangeWithTMS();
                result.setIsCome("TMS");
                logger.info("Post DN Result: " + result.toString());
            }else {
                logger.info("Post DN start To SAP");
                result = new PostDnToSap(orderNo, sapFlag,userName).exchangeWithSap();
                result.setIsCome("SAP");
                logger.info("Post DN Result: " + result.toString());
            }
        }
        return result;
    }

    /* (非 Javadoc) 
    * <p>Title: getSoMaterialList</p> 
    * <p>Description: </p> 
    * @param orno
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#getSoMaterialList(java.lang.String) 
    */
    @Override
    public List<OrderMatListDTO> getSoMaterialList(String orno) {
        return stgDnDownDAO.getSoMaterialList(orno);
    }

    /* (非 Javadoc) 
    * <p>Title: soGoodsReceive</p> 
    * <p>Description: </p> 
    * @param inpara
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#soGoodsReceive(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO) 
    */
    @Override
    public OrderGoodsTransOutDTO soGoodsReceive(OrderIgpInDTO inpara) {
        OrderGoodsTransOutDTO dto = new OrderGoodsTransOutDTO();
        soPDADAO.soGoodsReceive(inpara,dto);
        return dto;
    }

    /* (非 Javadoc) 
    * <p>Title: soGoodsDelivery</p> 
    * <p>Description: </p> 
    * @param inpara
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#soGoodsDelivery(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO) 
    */
    @Override
    public OrderGoodsTransOutDTO soGoodsDelivery(OrderIgpInDTO inpara) {
        OrderGoodsTransOutDTO dto = new OrderGoodsTransOutDTO();
        soPDADAO.soGoodsDelivery(inpara,dto);
        return dto;
    }
    
    /* (非 Javadoc) 
    * <p>Title: giftSoGoodsDelivery</p> 
    * <p>Description: </p> 
    * @param inpara
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#giftSoGoodsDelivery(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO) 
    */
    @Override
    public OrderGoodsTransOutDTO giftSoGoodsDelivery(OrderIgpInDTO inpara) {
        OrderGoodsTransOutDTO dto = new OrderGoodsTransOutDTO();
        soPDADAO.giftSoGoodsDelivery(inpara,dto);
        return dto;
    }

    /* (非 Javadoc) 
    * <p>Title: getLocationNameByDnNo</p> 
    * <p>Description: </p> 
    * @param dnNo
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#getLocationNameByDnNo(java.lang.String) 
    */
    @Override
    public List<String> getLocationNameByDnNo(String dnNo) {
        return stgDnDownDAO.getLocationNameListByDnNo(dnNo);
    }

    /* (非 Javadoc) 
    * <p>Title: getFifoList</p> 
    * <p>Description: </p> 
    * @param inpara
    * @param location
    * @param materialNo
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#getFifoList(com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO, java.lang.String, java.lang.String) 
    */
    @Override
    public WmsOrderDelListOutDTO getFifoList(WmsOrderDelListInDTO inpara,String location, String materialNo) {
        WmsOrderDelListOutDTO dto = new WmsOrderDelListOutDTO();
        List<OrderDelDetialDTO> list = stgDnDownDAO.getFifoList(location,materialNo);
        dto.setTotal(list.size()+"");
        dto.setDetial(list);
        return dto;
    }

    /* (非 Javadoc) 
    * <p>Title: dnReverse</p> 
    * <p>Description: </p> 
    * @param inpara
    * @return 
    * @see com.haier.hevwms.so.service.StgDnDownService#dnReverse(com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO) 
    */
    @Override
    public OrderIgpOutDTO dnReverse(OrderIgpInDTO inpara) {
        OrderIgpOutDTO outResult = new OrderIgpOutDTO();
        stgDnDownDAO.dnReverse(inpara,outResult);
        return outResult;
    }


    /* (非 Javadoc)
     * <p>Title: searchDirectDispatchDn</p>
     * <p>Description: </p>
     * @param pager
     * @param stgDnDown
     * @return
     * @see com.haier.otcwms.order.service.StgDnDownService#searchDirectDispatchDn(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.order.dto.StgDnDownDTO)
     */
    public Pager<StgDnDownDTO> searchDirectDispatchDn(Pager<StgDnDownDTO> pager,
                                                      StgDnDownDTO stgDnDown) {
        long a = System.currentTimeMillis();
        List<StgDnDownDTO> stgDnDowns = stgDnDownDAO.searchDirectDispatchDn(pager, stgDnDown);
        long c = System.currentTimeMillis();
        long size = stgDnDownDAO.searchDirectDispatchDnCount(stgDnDown);
        long b = System.currentTimeMillis();
        logger.info("Dn Query===>Service===>data query:"+pager.getPageSize()+" ,take time:"+(c-a)+"ms");
        logger.info("Dn Query===>Service===>data count:"+size+" ,take time:"+(b-c)+"ms");
        return Pager.cloneFromPager(pager, size, stgDnDowns);
    }
}
