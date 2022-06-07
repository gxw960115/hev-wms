package com.haier.hevwms.basic.service.impl;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.haier.hevwms.basic.dao.CdLocInfoDAO;
import com.haier.hevwms.basic.dao.CdWhInfoDAO;
import com.haier.hevwms.basic.service.CdWhInfoService;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

public class CdWhInfoServiceImpl implements CdWhInfoService {
    Logger logger = Logger.getLogger(CdWhInfoServiceImpl.class);
	private CdWhInfoDAO cdWhInfoDAO;
	private CdLocInfoDAO cdLocInfoDAO;
	private UserDAO userDAO;

    String flag = "true";
	
    @Override
	public String createCdWhInfo(CdWhInfoDTO cdWhInfo) {
	    try{
            flag = "true";
            
            String name = UserUtil.getCurrentUser().getName();
            Date date = new Date();
            cdWhInfo.setCreateBy(name);
			cdWhInfo.setCreateDate(date);
			cdWhInfo.setModifyBy(name);
			cdWhInfo.setModifyDate(date);
            cdWhInfoDAO.save(cdWhInfo);
            
            Long rowId =  cdWhInfoDAO.getMaxRowId() ;
            cdWhInfo.setRowId(rowId);
            
            cdLocInfoDAO.updateParentId(cdWhInfo.getRowId(), cdWhInfo.getChildren());
        }
        catch (Exception e) {
            return flag="false";
        }
        return flag;
	}
    //修改仓库 
    @Override
	public String updateCdWhInfo(CdWhInfoDTO cdWhInfo) {
	    flag="true";
        Date date =new Date();
        SimpleDateFormat ss=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String da=ss.format(date);
        try {
            date=ss.parse(da);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(UserUtil.getCurrentUser()!=null){
            cdWhInfo.setModifyBy(UserUtil.getCurrentUser().getName());
        }
        cdWhInfo.setModifyDate(date);
        cdWhInfoDAO.update(cdWhInfo);
        
        List<CdLocInfoDTO> list = cdLocInfoDAO
				.getCdLocInfosByParentIdNotnull(cdWhInfo.getRowId(),"");//父id不为空的仓库地点
		String[] array = new String[list.size()];
		for (CdLocInfoDTO cdLocInfo : list) {
			array[list.indexOf(cdLocInfo)] = cdLocInfo.getRowId().toString();
		}
		/*  Long[] array = new Long[list.size()];
		for (CdLocInfoDTO cdLocInfo : list) {
			array[list.indexOf(cdLocInfo)] = cdLocInfo.getRowId();
		}
		//将数组转成list
		List<Long> list2 = new ArrayList<Long>(array.length);
		for (Long s : array) {
		    list2.add(s);
		}
		if(list2.size()==0){
			list2=null;
		}*/
		if(array.length==0){
			array = new String[]{""};
		}
		
		// 先把以前置成 空
//		cdLocInfoDAO.updateParentId22(null, list2);
		cdLocInfoDAO.updateParentId(null, array);
		cdLocInfoDAO.updateParentId(cdWhInfo.getRowId(), cdWhInfo.getChildren());
        return flag;
	}
	
	@Override
	public String deleteCdWhInfo(Long cdWhInfoId) {
//		ExecuteResult<CdWhInfoDTO> executeResult = new ExecuteResult<CdWhInfoDTO>();
		cdWhInfoDAO.delete(cdWhInfoId);
		List<CdLocInfoDTO> list = cdLocInfoDAO
				.getCdLocInfosByParentIdNotnull(cdWhInfoId,"");
		String[] array = new String[list.size()];
		for (CdLocInfoDTO cdLocInfo : list) {
			array[list.indexOf(cdLocInfo)] = cdLocInfo.getRowId().toString();
		}
		// 先把以前置成 空
		cdLocInfoDAO.updateParentId(null, array);
		return "true";
	}
	
	@Override
	public String deleteCdWhInfoAll(List<Long> idList) {
	    try{
	        cdWhInfoDAO.deleteAll(idList);
        }catch (Exception e) {
            return flag="false";
        }
        return flag;
	}
	
	@Override
	public Pager<CdWhInfoDTO> searchCdWhInfos(Pager<CdWhInfoDTO> pager,
			CdWhInfoDTO cdWhInfo) {
		List<CdWhInfoDTO> cdWhInfos = cdWhInfoDAO.searchCdWhInfos(pager, cdWhInfo);
		long size = cdWhInfoDAO.searchCdWhInfosCount(cdWhInfo);
		return Pager.cloneFromPager(pager, size, cdWhInfos);
		
	}
	
	@Override
	public CdWhInfoDTO getCdWhInfoById(Long cdWhInfoId) {
		CdWhInfoDTO cdWhInfo = cdWhInfoDAO.get(cdWhInfoId);
		return cdWhInfo;
	}
	
	@Override
	public void saveOrUpdate(CdWhInfoDTO dto){
		CdWhInfoDTO cdWhInfo = cdWhInfoDAO.get(dto.getRowId());
		if(cdWhInfo!=null){
			cdWhInfo.setCode(dto.getCode());
			cdWhInfo.setName(dto.getName());
			cdWhInfo.setRemark(dto.getRemark());
			cdWhInfo.setChildren(dto.getChildren());
			cdWhInfo.setFlag(dto.getFlag());
			cdWhInfo.setLocations(dto.getLocations());
			cdWhInfo.setModifyBy(UserUtil.getCurrentUser().getName());
			cdWhInfo.setModifyDate(new Date());
			cdWhInfo.setName(dto.getName());
			cdWhInfo.setRemark(dto.getRemark());
			cdWhInfo.setVersion(dto.getVersion());
			cdWhInfoDAO.update(cdWhInfo);
		}else{
			dto.setCreateBy(UserUtil.getCurrentUser().getName());
			dto.setCreateDate(new Date());
			cdWhInfoDAO.save(dto);
		}
		
	}
	
	@Override
	public List<CdWhInfoDTO> getCdWhInfos() {
		return cdWhInfoDAO.getAll();
	}


	@Override
	public HashMap<String, String> findUserWhLoc(String userType, Long userId) {
		HashMap<String, String> userWhLoc = new HashMap<String, String>();
		List<Long> list = cdWhInfoDAO.findCdUserWh(userType, userId);
		if(list.size()>0){
		    for (Long locId : list) {
	            userWhLoc.put(locId.toString(), locId.toString());
	        }
		}
		return userWhLoc;
	}

	@Override
	public List<Long> findCdUserLoc(String userType, Long userId) {
		return cdWhInfoDAO.findCdUserLoc(userType, userId);
	}

	/** 
	* (non-Javadoc)  
	* @Title: findWhLocTree  
	* @Description: 
	* @param userType
	* @param userId
	* @return  
	* @see com.haier.hevwms.basic.service.CdWhInfoService#findWhLocTree(java.lang.String, java.lang.Long)  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年4月27日 下午4:38:51
	*/  
	@Override
	public List findWhLocTree(String userType, Long userId) {
	    logger.debug("Entering findWhLocTree, User_Type: " + userType + ", User_Id: " + userId);
        JSONArray arr=new JSONArray();
        List<Long> userLoc = cdWhInfoDAO.findCdUserLoc(userType, userId);
        
        List<CdLocInfoDTO> locnList = cdLocInfoDAO.getAll();
        JSONArray locnArray = JSONArray.fromObject(locnList);
        
        HashMap<String, JSONArray> map = new HashMap<String, JSONArray>();
//        HashMap<String, String> userWh = this.findUserWhLoc(userType,
//                userId);
        
        if(CollectionUtils.isNotEmpty(locnArray)){
            JSONArray res = null;
            JSONArray res1=new JSONArray();
            for(int i=0;i<locnArray.size();i++){
                JSONObject oo=locnArray.getJSONObject(i);
                if(StringUtils.isEmpty(oo.getString("parentId"))||StringUtils.isEmpty(oo.getString("whName"))){
                    logger.debug("Without Parent ID...");
                    oo.put("id", oo.getLong("rowId"));
                    oo.put("text", oo.getString("nameFat"));
                    oo.put("name", oo.getString("nameFat"));
                    logger.debug("Name = " + oo.getString("nameFat"));
                    oo.put("Type", "2");
                    if (userLoc.size()>0 && userLoc.contains(oo.getLong("rowId"))) {
                        oo.put("checked", true);
                    } else {
                        oo.put("checked", false);
                    }
                    res1.add(oo);
                }else{
                    logger.debug("With Parent ID...");
                    if(map.containsKey(oo.getString("parentId")+"_"+oo.getString("whName"))){
                        res=map.get(oo.getString("parentId")+"_"+oo.getString("whName"));
                        oo.put("id", oo.getLong("rowId"));
                        oo.put("text", oo.getString("nameFat"));
                        oo.put("name", oo.getString("nameFat"));
                        logger.debug("Name = " + oo.getString("nameFat"));
                        
                        oo.put("Type", "3");
                        if (userLoc.size()>0
                                && userLoc.contains(oo.getLong("rowId"))) {
                            oo.put("checked", true);
                        } else {
                            oo.put("checked", false);
                        }
                        res.add(oo);
                    }else{
                        res=new JSONArray();
                        oo.put("id", oo.getLong("rowId"));
                        oo.put("text", oo.getString("nameFat"));
                        oo.put("name", oo.getString("nameFat"));
                        logger.debug("Name = " + oo.getString("nameFat"));
                        oo.put("Type", "3");
                        if (userLoc.size()>0 && userLoc.contains(oo.getLong("rowId"))) {
                            oo.put("checked", true);
                        } else {
                            oo.put("checked", false);
                        }
                        res.add(oo);
                        map.put(oo.getString("parentId")+"_"+oo.getString("whName"), res);
                    }
                }
            }
//           Set<String> set= map.keySet();
           JSONObject json=new JSONObject();
//           for(String lid:set){
//              json=new JSONObject();
//              json.put("id", lid.split("_")[0]);
//              json.put("state", "closed");
//              json.put("text", lid.split("_")[1]);
//              json.put("children", map.get(lid));
//              arr.add(json);
//           }
           
           Set<Entry<String, JSONArray>> set = map.entrySet();
           Iterator<Entry<String, JSONArray>> it = set.iterator();
           while (it.hasNext()){
        	   Entry<String, JSONArray> entry = it.next();  
        	   json.put("id", entry.getKey().split("_")[0]);
        	   json.put("state", "closed");
        	   json.put("text", entry.getKey().split("_")[1]);
        	   json.put("children", entry.getValue());
        	   arr.add(json);
           }
           arr.addAll(res1);
        }
       
        return arr;
		/*List<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
		JSONArray arr=new JSONArray();
		try {
			HashMap<String, String> userLoc = this.findCdUserLoc(userType,
					userId);
			if ("2".equals(userType)) {
				HashMap<String, String> userWh = this.findUserWhLoc(userType,
						userId);
				List<CdWhInfoDTO> whList = cdWhInfoDAO.getAll();
				for (CdWhInfoDTO cdWhInfo : whList) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					JSONObject json=new JSONObject();
					json.put("id", cdWhInfo.getRowId());
					json.put("text", cdWhInfo.getNameFat());
					json.put("code", cdWhInfo.getCode());
					if (userWh != null
							&& userWh.get(cdWhInfo.getRowId().toString()) != null) {
					    json.put("checked", true);
					} else {
					    json.put("checked", false);
					}
					arr.add(json);
//					rows.add(map);
				}
			} else if ("3".equals(userType)) {
				List<CdWhInfoDTO> whList = cdWhInfoDAO.getAll();
				for (CdWhInfoDTO cdWhInfo : whList) {
				    JSONObject json=new JSONObject();
					HashMap<String, Object> map = new HashMap<String, Object>();
					json.put("id", "wh_" + cdWhInfo.getRowId());
					json.put("text", cdWhInfo.getNameFat());
					json.put("code", cdWhInfo.getCode());
					json.put("state", "closed");
					json.put("Type", "2");
					json.put("chkDisabled", false);
					arr.add(json);
				}
				List<CdLocInfoDTO> locList = cdLocInfoDAO.getAll();
				for (CdLocInfoDTO cdLocInfo : locList) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					 JSONObject json=new JSONObject();
					 json.put("id", cdLocInfo.getRowId());
					 json.put("text", cdLocInfo.getNameFat());
					 json.put("code", cdLocInfo.getCode());
					 json.put("cityCode", cdLocInfo.getCityCode());
					 json.put("cityName", cdLocInfo.getCityName());
					 json.put("Type", "3");
					 json.put("pId", "wh_" + cdLocInfo.getParentId());
					if (userLoc != null
							&& userLoc.get(cdLocInfo.getRowId().toString()) != null) {
					    json.put("checked", true);
					} else {
					    json.put("checked", false);
					}
					arr.add(json);
				}
			}
			return arr;
		} catch (Exception e) {
			throw new HOPException("test" + CdWhInfoServiceImpl.class, e);
		}*/

	}

	/** 
	* (non-Javadoc)  
	* @Title: findCdWhInfoByUserId  
	* @Description: 
	* @param userType
	* @param userId
	* @return  
	* @see com.haier.hevwms.basic.service.CdWhInfoService#findCdWhInfoByUserId(java.lang.String, java.lang.Long)  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年4月27日 下午4:38:41
	*/  
	@Override
	public List<CdWhInfoDTO> findCdWhInfoByUserId(String userType, Long userId) {
		HashMap<String, String> userWhLoc = this
				.findUserWhLoc(userType, userId);
		List<CdWhInfoDTO> whLists = new ArrayList<CdWhInfoDTO>();
		List<CdWhInfoDTO> whList = cdWhInfoDAO.getAll();
		for (CdWhInfoDTO cdWhInfo : whList) {
			if (userWhLoc != null
					&& userWhLoc.get(cdWhInfo.getRowId().toString()) != null) {
				whLists.add(cdWhInfo);
			}
		}
		return whLists;
	}
	
	/** 
	* (non-Javadoc)  
	* @Title: searchCdWhInfosByConditions  
	* @Description: 查询仓库信息
	* @param page
	* @param rows
	* @param cdWhInfo
	* @return  
	* @see com.haier.hevwms.basic.service.CdWhInfoService#searchCdWhInfosByConditions(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.basicdata.dto.CdWhInfoDTO)  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年4月27日 下午4:38:31
	*/  
	@Override
	public Pager<CdWhInfoDTO> searchCdWhInfosByConditions(Long page, Long rows,
			CdWhInfoDTO cdWhInfo) {
		 Pager<CdWhInfoDTO> pager = new Pager<CdWhInfoDTO>();
		 pager.setCurrentPage(page);
		 pager.setPageSize(rows);
		 List<CdWhInfoDTO> list = cdWhInfoDAO.searchCdWhInfos(pager, cdWhInfo);

         long size = cdWhInfoDAO.searchCdWhInfosCount(cdWhInfo);

         return Pager.cloneFromPager(pager, size, list);
	}

	/** 
	* (non-Javadoc)  
	* @Title: saveOrUpdate2  
	* @Description: 导入
	* @param list
	* @param user
	* @return  
	* @see com.haier.hevwms.basic.service.CdWhInfoService#saveOrUpdate2(java.util.List, io.terminus.pampas.common.BaseUser)  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年4月27日 下午4:38:14
	*/  
	@Override
	public String saveOrUpdate2(List<CdWhInfoDTO> list, BaseUser user) {
		int addSize =0;
		int updateSize=0;
		int failSize=0;
		for(CdWhInfoDTO obj :list){
			
			CdWhInfoDTO cdWhInfo = cdWhInfoDAO.searchCdWhByCode(obj);
			try {
				if(cdWhInfo != null){
					cdWhInfo.setCode(obj.getCode());
					cdWhInfo.setName(obj.getName());
					cdWhInfo.setRemark(obj.getRemark());
					cdWhInfoDAO.update(cdWhInfo);
					updateSize++;
				}else{
					obj.setCreateBy(user.getName());
					obj.setCreateDate(new Date());
					cdWhInfoDAO.save(obj);
					addSize++;
					
				}
			} catch (Exception e) {
				failSize++;
				e.printStackTrace();
			}
		}
		 return "Import Success;Total Size:" + list.size() + ",Add Size:"
         + addSize + ",Update Size:" + updateSize + "Failure Size:"
         + failSize;
	}

	/** 
	* (non-Javadoc)  
	* @Title: updateWhFlag  
	* @Description: 更新有效标志
	* @param idList
	* @return  
	* @see com.haier.hevwms.basic.service.CdWhInfoService#updateWhFlag(java.util.List)  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年4月27日 下午4:37:36
	*/  
	@Override
	public String updateWhFlag(List<Long> idList) {
		try{
	        cdWhInfoDAO.updateWhFlag(idList);
        }catch (Exception e) {
            return flag="false";
        }
        return flag;
	}
	/**
	 * 查询所有实体库位
	 */
	@Override
	public List<CdWhInfoDTO> getPhysicalWhInfos() {
		// TODO Auto-generated method stub
		return cdWhInfoDAO.getAllPhysicalWh();
	}
	
	/**
	 * 获取可见的仓库信息
	 * @param userId
	 * @return
	 */
	@Override
	public List<CdWhInfoDTO> findAvailableWhInfos(Long userId) {
		UserDTO user = userDAO.get(userId);
		if ("3".equals(user.getDutyType())){
			return cdWhInfoDAO.findAvailableWhInfos(userId);
		} else {
			return cdWhInfoDAO.getAll();
		}
	}
	
	/**
	 * 获取可见的物理仓库信息
	 * @param userId
	 * @return
	 */
	@Override
	public List<CdWhInfoDTO> findAvailablePhyWhInfos(Long userId) {
		UserDTO user = userDAO.get(userId);
		if ("3".equals(user.getDutyType())){
			return cdWhInfoDAO.findAvailablePhyWhInfos(userId);
		} else {
			return cdWhInfoDAO.getAllPhysicalWh();
		}
	}
	
	/**
	 * getters & setters
	 */
	public CdWhInfoDAO getCdWhInfoDAO() {
        return cdWhInfoDAO;
    }
	public void setCdWhInfoDAO(CdWhInfoDAO cdWhInfoDAO) {
        this.cdWhInfoDAO = cdWhInfoDAO;
    }
    public CdLocInfoDAO getCdLocInfoDAO() {
        return cdLocInfoDAO;
    }

    public void setCdLocInfoDAO(CdLocInfoDAO cdLocInfoDAO) {
        this.cdLocInfoDAO = cdLocInfoDAO;
    }
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
    
}
