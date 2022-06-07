package com.haier.openplatform.wms.portal.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;

/**
 * @Company 青鸟软通
 * @Title:portal页面
 * @Package com.haier.openplatform.wms.portal.service;
 * @author liyun
 * @date 2015/11/27
 * @version V1.0
 */
public interface PortalServiceClient {
    /**
     * 
    * @Title: getNoticeData
    * @Description: portal页面notice数据
    * @param @return
    * @return List
    * @throws
     */
    @Export
    public List<NoticeInfoDTO> getNoticeData();
    /**
     * 
    * @Title: getToDoChartsData
    * @Description: portal页面todo柱状图数据
    * @param @return
    * @return String
    * @throws
     */
    @Export
    public List getToDoChartsData();
    
    /**
     * 
    * @Title: getInventoryPieData
    * @Description: portal页面inventory饼状图数据
    * @param @return
    * @return String
    * @throws
     */
    @Export
    public List<OdsInventoryInfoDtlDTO> getInventoryPieData();

    /** 
    * @Title: saveSystemNotice 
    * @Description: TODO(这里用一句话描述这个方法的作用) 
    * @param @param notice
    * @param @return    设定文件 
    * @author SJK
    * @date 2019年3月18日
    * @return String    返回类型 
    * @throws 
    */
    @Export(paramNames = {"notice"})
	public String saveSystemNotice(NoticeInfoDTO notice);
}
