package com.haier.hevwms.portal.dao;

import java.util.List;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;

public interface NoticeInfoDAO extends CommonDAO<NoticeInfoDTO, Long> {
    /**
     * 
    * @Title: getNoticeData
    * @Description: portal页面notice数据
    * @param @return
    * @return List
    * @throws
     */
    public List<NoticeInfoDTO> getNoticeData();

    /**
     * 发布公告
     *ZhangYing@jbinfo.cn
     * 2015-12-11
     */
	public void save(NoticeInfoDTO notice);
	
	public int deleteNotice();
}