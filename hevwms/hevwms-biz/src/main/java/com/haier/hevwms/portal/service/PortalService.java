package com.haier.hevwms.portal.service;

import io.terminus.pampas.client.Export;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;

public interface PortalService {
    /**
     * 
    * @Title: getNoticeData
    * @Description:  portal页面notice数据
    * @param @return
    * @return List
    * @throws
     */
    public List<NoticeInfoDTO> getNoticeData();
    /**
     * 
    * @Title: getInventoryPieData
    * @Description: portal得到inventory饼状图数据
    * @param @return
    * @return List
    * @throws
     */
	public List<OdsInventoryInfoDtlDTO> getInventoryPieData();
	
	/**
	 * 
	* @Title: getToDoChartsData
	* @Description: portal得到todo 柱状图数据
	* @param @return
	* @return List
	* @throws
	 */
	public List getToDoChartsData();
	
	/**
	 * 发布公告
	 *ZhangYing@jbinfo.cn
	 * 2015-12-11
	 */
	public ExecuteResult<NoticeInfoDTO> saveSystemNotice(NoticeInfoDTO notice);
	 /**
     * 
    * @Title: deleteNotice
    * @Description: 删除公告
    * @param @return
    * @return int
    * @throws
     */
    @Export
    public int deleteNotice();
}
