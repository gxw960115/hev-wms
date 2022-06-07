package com.haier.hevwms.portal.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.po.dao.StgPoDownDAO;
import com.haier.hevwms.portal.dao.NoticeInfoDAO;
import com.haier.hevwms.portal.service.PortalService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.portal.dto.NoticeInfoDTO;

public class PortalServiceImpl implements
        PortalService {
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	private StgPoDownDAO stgPoDownDAO; 
	private NoticeInfoDAO noticeInfoDAO;

    public NoticeInfoDAO getNoticeInfoDAO() {
        return noticeInfoDAO;
    }

    public void setNoticeInfoDAO(NoticeInfoDAO noticeInfoDAO) {
        this.noticeInfoDAO = noticeInfoDAO;
    }

    @Override
    public List<NoticeInfoDTO> getNoticeData() {
        return noticeInfoDAO.getNoticeData();
    }
    
    @Override
    public List<OdsInventoryInfoDtlDTO> getInventoryPieData() {
        return odsInventoryInfoDtlDAO.getInventoryPieData();
    }

    @Override
    public List getToDoChartsData() {
        JSONArray arr=JSONArray.fromObject(stgPoDownDAO.getToDoChartsData());
        List<JSONObject> list=new ArrayList<JSONObject>(); 
        List<Long> list1=new ArrayList<Long>();
        List<Long> list2=new ArrayList<Long>();
        JSONObject json=new JSONObject();
        for(int i=0;i<arr.size()-4;i++){
            list1.add(arr.getJSONObject(i).getLong("qty"));
        }
        json.put("undo", list1);
        for(int i=4;i<arr.size();i++){
            list2.add(arr.getJSONObject(i).getLong("qty"));
        }
        json.put("postS", list2);
        list.add(json);
        return list;
    }

    public StgPoDownDAO getStgPoDownDAO() {
        return stgPoDownDAO;
    }

    public void setStgPoDownDAO(StgPoDownDAO stgPoDownDAO) {
        this.stgPoDownDAO = stgPoDownDAO;
    }
    
    public OdsInventoryInfoDtlDAO getOdsInventoryInfoDtlDAO() {
        return odsInventoryInfoDtlDAO;
    }

    public void setOdsInventoryInfoDtlDAO(
            OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO) {
        this.odsInventoryInfoDtlDAO = odsInventoryInfoDtlDAO;
    }

    /**
     * 发布公告
	 *ZhangYing@jbinfo.cn
	 * 2015-12-11
	 */
	@Override
	public ExecuteResult<NoticeInfoDTO> saveSystemNotice(NoticeInfoDTO notice) {
        ExecuteResult<NoticeInfoDTO> executeResult = new ExecuteResult<NoticeInfoDTO>();
        notice.setCreateBy(UserUtil.getCurrentUser().getName());
        notice.setCreatedTime(new Date());
        notice.setValidTime(new Date());
        notice.setInvalidTime(new Date());
        notice.setPublishedTime(new Date());
        noticeInfoDAO.save(notice);
		executeResult.setResult(notice);
		return executeResult;
	}

    @Override
    public int deleteNotice() {
        return noticeInfoDAO.deleteNotice();
    }

}
