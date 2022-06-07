package com.haier.openplatform.wms.security.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.security.service.ResourceService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;
import com.haier.openplatform.wms.security.service.ResourceServiceClient;

/**
 * 
 * @author ZhangYing@jbinfo.cn
 *
 */
@Path("ResourceServiceClientImpl")
@Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 参数类型
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 返回值类型
public class ResourceServiceClientImpl implements ResourceServiceClient {
	
	private ResourceService resourceService;
	
	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-4
	 */
    @Override
	public Pager<ResourceDTO> searchResource(long page, long rows,
			ResourceDTO resource) {
		
    	Pager<ResourceDTO> pager=new Pager<ResourceDTO>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        Pager<ResourceDTO> pagerDTO = new Pager<ResourceDTO>();
        Pager<ResourceDTO> temp=resourceService.searchResources(pager,resource);
        long totalSize=temp.getTotalRecords();
        List<ResourceDTO> listInfo = temp.getRecords();
        List<ResourceDTO> list = new ArrayList<ResourceDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(ResourceDTO info : listInfo){
        	ResourceDTO dto = new ResourceDTO();
            try {
            	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);
                BeanUtils.copyProperties(dto,info);
                if(String.valueOf(info.getType()).equals("0")){
            		dto.setTypeDesc("URL Resource");
            	}else{
            		if(String.valueOf(info.getType()).equals("1")){
                		dto.setTypeDesc("Module Resource");
                	}
            	}
                if(String.valueOf(info.getStatus()).equals("0")){
            		dto.setStatusDesc("No");
            	}else{
            		if(String.valueOf(info.getStatus()).equals("1")||info.getStatus()==null){
                		dto.setStatusDesc("Yes");
                	}
            	}
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
     * 删除资源信息
	 *ZhangYing@jbinfo.cn
	 * 2015-12-4
	 */
    @Override
	public String deleteResourceMessage(String id) {
		
    	try {
			ExecuteResult<ResourceDTO> result=resourceService.deleteResource(Long.valueOf(id));
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";
	}

	public ResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * 创建资源信息
	 *ZhangYing@jbinfo.cn
	 * 2015-12-11
	 */
	@Override
	public String createResource(ResourceDTO resource) {
		
		try {
			ExecuteResult<ResourceDTO> result=resourceService.createResource(resource);
			if (!result.isSuccess()){
			    return result.getErrorMessages().get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "success";

	}

	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-11
	 */
	@Override
	public List<ResourceDTO> selectResourceTree(Integer status) {
	    ResourceDTO resource=new ResourceDTO();
        resource.setStatus(status);
		return resourceService.selectResourceTree(resource);
	}

	/**
	 *ZhangYing@jbinfo.cn
	 * 2015-12-14
	 */
	@Override
	public String updateResource(ResourceDTO resource) {
		
		ExecuteResult<ResourceDTO> result = resourceService.updateResource(resource);
		if(!result.isSuccess()){
			return result.getErrorMessages().get(0);
		}
		return "success";
	}
	
	/**
	 * 
	* <p>Title: getParentResource</p>
	* <p>Description: combobox 得到父级module</p>
	* @return
	* @see com.haier.openplatform.wms.security.service.ResourceServiceClient#getParentResource()
	 */
    @Override
    public List<ResourceDTO> getParentResource(Integer status) {
        ResourceDTO resource=new ResourceDTO();
        resource.setStatus(status);
        return resourceService.getParentResource(resource);
    }
	
 }
