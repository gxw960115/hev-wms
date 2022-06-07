package com.haier.openplatform.wms.order.impl;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

import com.haier.hevwms.order.service.OdsTransferInventoryService;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;
import com.haier.openplatform.wms.order.service.TransferInventoryServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/**
 * 311移库
 * @author Yan Fengdan
 * @version 2017-11-10 下午2:29:17
 */
public class TransferInventoryServiceClientImpl implements TransferInventoryServiceClient {
    Logger logger = Logger.getLogger(TransferInventoryServiceClientImpl.class);
    /**  
     * @Fields field:field:{}(odsTransferInventoryService)  
     */  
    private OdsTransferInventoryService odsTransferInventoryService;
    
    /** (non-Javadoc)  
     * <p>Title: getTransferInventoryOrderNo</p>  
     * <p>Description:获取移库单号 </p>  
     * @return  
     * @see com.haier.openplatform.wms.order.service.TransferInventoryServiceClient#getTransferInventoryOrderNo()  
     */
    @POST
    @Path("getTransferInventoryOrderNo")
    @Override
    public String getTransferInventoryOrderNo() {
        String orderNo=odsTransferInventoryService.selectTransferInventoryOrderNo();
        return "T"+orderNo;
    }
    
    /** (non-Javadoc)  
     * <p>Title: addTranferInventoryOrders</p>  
     * <p>Description:增加 </p>  
     * @param odsTransferInventoryDTO
     * @param msg
     * @return  
     * @see com.haier.openplatform.wms.order.service.TransferInventoryServiceClient#addTranferInventoryOrders(com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO, java.util.List)  
     */
    @Override
    public String addTranferInventoryOrders(OdsTransferInventoryDTO odsTransferInventoryDTO,
            List<OdsTransferInventoryDTO> msg) {
        BaseUser user = UserUtil.getCurrentUser();
        String userName="";
        try {
            userName=user.getName();
        } catch (Exception e) {
            return "Cant't get user name,please login again!";
        }
        String flag="SUCCESS";
        
        int itemNo = 1;
        
        for(OdsTransferInventoryDTO mat:msg){//遍历,插入数据库中
        	OdsTransferInventoryDTO transDto=new OdsTransferInventoryDTO(); 
        	transDto.setTransOrderNo(odsTransferInventoryDTO.getTransOrderNo());
        	transDto.setWarehouseCode(odsTransferInventoryDTO.getWarehouseCode());
        	transDto.setWarehouseName(odsTransferInventoryDTO.getWarehouseName());
        	transDto.setPlant(odsTransferInventoryDTO.getPlant());
        	transDto.setGiLocation(mat.getGiLocation());
        	transDto.setGrLocation(odsTransferInventoryDTO.getGrLocation());
        	transDto.setMaterialNo(mat.getMaterialNo());
        	transDto.setMaterialDesp(mat.getMaterialDesp());
        	transDto.setCustomerModel(mat.getCustomerModel());
        	transDto.setQty(mat.getQty());
        	transDto.setUnit(mat.getBasicUnit());
        	transDto.setCreateBy(userName);
        	transDto.setCreateDate(new Date());//移库单创建时间
        	transDto.setTransItemNo(new DecimalFormat("0000").format(itemNo));
        	
        	itemNo = itemNo+1;
        	
            String result=odsTransferInventoryService.createOdsTransInventoryInfo(transDto);//新增 移库单
            if (!"SUCCESS".equals(result)){
                logger.debug("创建移库单失败：plant:"+transDto.getPlant()+",location:"+transDto.getGiLocation()
                                +",materialNo:"+transDto.getMaterialNo()+"");
                return result;
            }
        }
        return flag;
    }
    
    /** (non-Javadoc)  
     * <p>Title: searchTransInventoryOrder</p>  
     * <p>Description:查询 移库单 明细 </p>  
     * @param page
     * @param rows
     * @param odsTransferInventoryDTO
     * @return  
     * @see com.haier.openplatform.wms.order.service.TransferInventoryServiceClient#searchTransInventoryOrder(long, long, com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO)  
     */
    @Override
    public Pager<OdsTransferInventoryDTO> searchTransInventoryOrder(long page, long rows,
    		OdsTransferInventoryDTO odsTransferInventoryDTO) {
        
        Pager<OdsTransferInventoryDTO> pager = new Pager<OdsTransferInventoryDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        
        Pager<OdsTransferInventoryDTO> temp=odsTransferInventoryService.searchTransInventoryInfos(pager,odsTransferInventoryDTO);
        long totalSize=temp.getTotalRecords();
        List<OdsTransferInventoryDTO> listInfo = temp.getRecords();
        pager.setRecords(listInfo);
        pager.setTotalRecords(totalSize);
        return pager;
    }
    
	/** (non-Javadoc)  
	 * <p>Title: getOdsTransInfo</p>  
	 * <p>Description:查询 </p>  
	 * @param odsTransferInventoryDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.TransferInventoryServiceClient#getOdsTransInfo(com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO)  
	 */
	@Override
	public List<OdsTransferInventoryDTO> getOdsTransInfo(
			OdsTransferInventoryDTO odsTransferInventoryDTO) {
		return odsTransferInventoryService.getList(odsTransferInventoryDTO);
	}

	/** (non-Javadoc)  
	 * <p>Title: deleteTranferInventoryOrder</p>  
	 * <p>Description:删除 </p>  
	 * @param odsTransferInventoryDTO
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.TransferInventoryServiceClient#deleteTranferInventoryOrder(com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO)  
	 */
	@Override
	public String deleteTranferInventoryOrder(
			OdsTransferInventoryDTO odsTransferInventoryDTO) {
		BaseUser user = UserUtil.getCurrentUser();
    	if (user==null){
    		return "Update failed,Can't get The login User,Please login again";
    	}
    	if(odsTransferInventoryDTO.getCreateBy().equalsIgnoreCase(user.getName())){
            ExecuteResult<OdsTransferInventoryDTO> result=odsTransferInventoryService.deleteOrder(odsTransferInventoryDTO);
            
            if(result.isSuccess())
                return "success";
            return "error!";
        } else {
        	return "You can't delete, because this order isn't created by you!";
        }
    }
	
	/** (non-Javadoc)
	 * <p>Title: getExportAmount</p>  
	 * <p>Description:获取导出数量 </p>  
	 * @param dto
	 * @return  
	 * @see com.haier.openplatform.wms.order.service.TransferInventoryServiceClient#getExportAmount(com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO)  
	 */
	@Override
	public Long getExportAmount(OdsTransferInventoryDTO dto) {
		return odsTransferInventoryService.getExportAmount(dto);
	}
	
	/**  
	 * @Title: getOdsTransferInventoryService  
	 * @Description: (get)  
	 * @return
	 * @return OdsTransferInventoryService 
	 * @throws  
	 */  
	public OdsTransferInventoryService getOdsTransferInventoryService() {
		return odsTransferInventoryService;
	}

	/**  
	 * @Title: setOdsTransferInventoryService  
	 * @Description: (set)  
	 * @param odsTransferInventoryService
	 * @return void 
	 * @throws  
	 */  
	public void setOdsTransferInventoryService(
			OdsTransferInventoryService odsTransferInventoryService) {
		this.odsTransferInventoryService = odsTransferInventoryService;
	}
}
