package com.haier.openplatform.wms.portal.service.impl;

import java.util.List;

import com.haier.hevwms.portal.service.PortalService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;
import com.haier.openplatform.wms.portal.service.PortalServiceClient;

/**
 * @Company 青鸟软通
 * @Title:portaldubbo实现
 * @Package com.haier.openplatform.wms.portal.service.impl;
 * @author liyun
 * @date 2015/11/27
 * @version V1.0
 */
public class PortalServiceClientImpl implements
        PortalServiceClient {
    private PortalService portalService;
    
    @Override
    public List<NoticeInfoDTO> getNoticeData() {
        return portalService.getNoticeData();
    }
    
    @Override
    public List getToDoChartsData() {
        return portalService.getToDoChartsData();
    }

    @Override
    public List<OdsInventoryInfoDtlDTO> getInventoryPieData() {
        return portalService.getInventoryPieData();
    }
    public PortalService getPortalService() {
        return portalService;
    }

    public void setPortalService(PortalService portalService) {
        this.portalService = portalService;
    }

    /**
     * 发布公告
	 *ZhangYing@jbinfo.cn
	 * 2015-12-11
	 */
	@Override
	public String saveSystemNotice(NoticeInfoDTO notice) {
	    ExecuteResult<NoticeInfoDTO> executeResult=new ExecuteResult<NoticeInfoDTO>();
		//先删除后添加
	    if(portalService.deleteNotice()>0){
	        executeResult = portalService
	                .saveSystemNotice(notice);
	    }
	    if(!executeResult.isSuccess()){
            return "failure";
        }
        return "success";
	}
   

}
