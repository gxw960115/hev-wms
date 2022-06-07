/**
 * @Company 青鸟软通
 * @Title: ResourceServiceImpl.java
 * @Package com.haier.openplatform.showcase.security.service.impl
 * @author Lynn
 * @date 2015-10-30 下午2:02:22
 * @version V1.0
 */
package com.haier.hevwms.security.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.haier.hevwms.security.dao.ResourceDAO;
import com.haier.hevwms.security.service.ResourceService;
import com.haier.openplatform.showcase.security.domain.enu.ResourceTypeEnum;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.security.dto.ResourceDTO;

/**
 * @ClassName: ResourceServiceImpl
 * @Description: 资源管理
 */
public class ResourceServiceImpl implements ResourceService {
    Logger logger = Logger.getLogger(ResourceServiceImpl.class);

    private ResourceDAO resourceDAO;

    /**
     * @param @param resourceDAO
     * @return void
     * @throws
     * @Title: setResourceDAO
     * @Description: 资源管理数据库操作set方法
     */
    public void setResourceDAO(ResourceDAO resourceDAO) {
        this.resourceDAO = resourceDAO;
    }

    /**
     * <p>Title: createResource</p>
     * <p>Description: 创建系统资源</p>
     *
     * @param resource
     * @return
     */
    @Override
    public ExecuteResult<ResourceDTO> createResource(ResourceDTO resource) {
        resource.setName(StringUtils.trim(resource.getName()));
        resource.setCode(StringUtils.trim(resource.getCode()));

        ExecuteResult<ResourceDTO> executeResult = new ExecuteResult<ResourceDTO>();
        ResourceDTO dbResource = resourceDAO.getResourceByName(resource.getName(), resource.getParentId());
        if (dbResource != null) {
            executeResult.addErrorMessage("resource " + "[" + resource.getName() + "]" + " already.exist");
            return executeResult;
        }

        // 资源编码唯一性检查(区分父节点与子节点)
        if (StringUtils.isNotEmpty(resource.getCode())) {
            if (resourceDAO.getResourceByCode(resource.getCode()) != null) {
                executeResult.addErrorMessage("resource.code " + "[" + resource.getCode() + "]" + " already.exist");
                return executeResult;
            }
        }

        Date currentDt = new Date();
        resource.setGmtCreate(currentDt);
        resource.setGmtModified(currentDt);
        // 登录信息获取
        resource.setCreateBy(UserUtil.getCurrentUser().getName());
        resource.setLastModifiedBy(UserUtil.getCurrentUser().getName());
        /*resource.getParent() == null || resource.getParent().getId() == null*/
        if (resource.getParentId() == 0) {
            //普通资源
            resource.setParent(null);
            resourceDAO.save(resource);
            logger.debug("Create resource successfully, resource ID: " + resource.getId());
            resource.setParent(resource);
            resourceDAO.update(resource);
        } else {
            // 系统级资源/*resource.getParent().getId()*/
            ResourceDTO parent = resourceDAO.getResourceById(resource.getParentId());
            resource.setParent(parent);
            resourceDAO.save(resource);
            logger.debug("Create resource successfully, resource ID: " + resource.getId());
        }
        executeResult.setResult(resource);
        return executeResult;
    }

    /**
     * <p>Title: updateResource</p>
     * <p>Description: 保存資源信息</p>
     *
     * @param resource
     * @return
     */
    @Override
    public ExecuteResult<ResourceDTO> updateResource(ResourceDTO resource) {
        logger.debug("Entering updateResource...");
        // 去空格
        resource.setName(StringUtils.trim(resource.getName()));
        resource.setCode(StringUtils.trim(resource.getCode()));

        ExecuteResult<ResourceDTO> executeResult = new ExecuteResult<ResourceDTO>();
        ResourceDTO dbResource = resourceDAO.getResourceById(resource.getId());
        if (dbResource == null) {
            executeResult.addErrorMessage("resource" + "[" + resource.getName() + "]" + " not exist or deleted");
            return executeResult;
        }

        // 重名检查
        if (!resource.getName().equals(dbResource.getName())) {
            ResourceDTO m = resourceDAO.getResourceByName(resource.getName(), resource.getParentId());
            if (m != null) {
                executeResult.addErrorMessage("create.resource.error.resource"
                        + "[" + resource.getName() + "]" + "create.resource.error.resource.already.exist");
                return executeResult;
            }
        }

        // 资源编码唯一性检查
        if (StringUtils.isNotEmpty(resource.getCode()) && ResourceTypeEnum.toEnum(resource.getType()) == ResourceTypeEnum.COMPONENT_RESOURCE) {
            if (!dbResource.getCode().equals(resource.getCode())) {
                if (resourceDAO.getResourceByCode(resource.getCode()) == null) {
                    dbResource.setCode(resource.getCode());
                } else {
                    executeResult.addErrorMessage("create.resource.error.resource.code" + "[" + resource + "]" + "create.resource.error.resource.already.exist");
                    return executeResult;
                }
            }
        }

        // 设置父资源
        /*resource.getParent() == null || resource.getParent().getId() == null*/
        //普通资源
        if (resource.getParentId() == null) {
            dbResource.setParent(dbResource);
        } else {//系统级资源/*resource.getParent().getId()*/
            ResourceDTO parent = resourceDAO.getResourceById(resource.getParentId());
            dbResource.setParent(parent);
        }

        // 设置普通字段值
        dbResource.setName(resource.getName());
        dbResource.setCode(resource.getCode());
        dbResource.setDescription(resource.getDescription());
        // 获取登录信息
        dbResource.setLastModifiedBy(UserUtil.getCurrentUser().getName());
        dbResource.setOrderIndex(resource.getOrderIndex());
        dbResource.setConfiguration(resource.getConfiguration());
        dbResource.setStatus(resource.getStatus());
        dbResource.setUrl(resource.getUrl());
        resourceDAO.update(dbResource);
        executeResult.setResult(dbResource);
        return executeResult;
    }

    /**
     * <p>Title: deleteResource</p>
     * <p>Description: </p>
     *
     * @param resourceId
     * @return
     */
    @Override
    public ExecuteResult<ResourceDTO> deleteResource(Long resourceId) {
        logger.debug("Entering deleteResource, resourceId = " + resourceId);
        ExecuteResult<ResourceDTO> executeResult = new ExecuteResult<ResourceDTO>();
        ResourceDTO resource = resourceDAO.getResourceById(resourceId);
        if (resource == null) {
            executeResult.addWarningMessage("delete.resource.error.resource.not.exist");
            return executeResult;
        }
        // 无子资源
        List<ResourceDTO> children = resourceDAO.getChildren(resourceId);
        if (!children.isEmpty()) {
            executeResult.addErrorMessage("delete.resource.error.resource.has" + children.size() + "delete.resource.error.resource.has.child");
            return executeResult;
        }
        resourceDAO.delete(resourceId);

        logger.debug("Exiting deleteResource, resourceId = " + resourceId);
        return executeResult;
    }

    /**
     * <p>Title: getResourceById</p>
     * <p>Description: </p>
     *
     * @param resourceId
     * @return
     */
    @Override
    public ResourceDTO getResourceById(Long resourceId) {
        return resourceDAO.getResourceById(resourceId);
    }

    /**
     * <p>Title: getChilden</p>
     * <p>Description: 获取子资源</p>
     *
     * @param resourceId
     * @return
     */
    @Override
    public List<ResourceDTO> getChilden(Long resourceId) {
        return resourceDAO.getChildren(resourceId);
    }

    /**
     * <p>Title: getParentsChain</p>
     * <p>Description: 获取父资源</p>
     *
     * @param resourceId
     * @return
     */
    @Override
    public LinkedList<ResourceDTO> getParentsChain(Long resourceId) {
        LinkedList<ResourceDTO> resources = new LinkedList<ResourceDTO>();
        ResourceDTO resource = resourceDAO.getResourceById(resourceId);
        if (resource == null) {
            return resources;
        }
        ResourceDTO tmpResource = resource;
        while (tmpResource.getParent() != null && !tmpResource.getParent().getId().equals(tmpResource.getId())) {
            resources.addFirst(tmpResource.getParent());
            tmpResource = resourceDAO.getResourceById(tmpResource.getParent().getId());
        }
        resources.addLast(resource);
        return resources;
    }

    /**
     * <p>Title: getRoot</p>
     * <p>Description: </p>
     *
     * @return
     */
    @Override
    public List<ResourceDTO> getRoot() {
        return resourceDAO.getRoots();
    }

    /**
     * <p>Title: getResourceByRole</p>
     * <p>Description: </p>
     *
     * @param roleIds
     * @return
     */
    @Override
    public List<ResourceDTO> getResourceByRole(Long[] roleIds) {
        if (roleIds == null || roleIds.length == 0) {
            return new ArrayList<ResourceDTO>(0);
        }
        return resourceDAO.getResourceByRoleIds(roleIds);
    }

    /**
     * <p>Title: getAll</p>
     * <p>Description: 获取所有资源项</p>
     *
     * @return
     */
    @Override
    public List<ResourceDTO> getAll() {
        return resourceDAO.getAll();
    }

    /**
     * <p>Title: getUserDisplayedURLResources</p>
     * <p>Description: 根据用户ID获取可见的菜单</p>
     *
     * @param userId
     * @param moduleName
     * @return
     */
    @Override
    public List<ResourceDTO> getUserDisplayedURLResources(Long userId, String moduleName) {
        return resourceDAO.getUserDisplayedURLResourcesByModuleAndRoles(userId, moduleName);
    }

    /**
     * <p>Title: searchResources</p>
     * <p>Description: </p>
     *
     * @param pager
     * @param resource
     * @return
     */
    @Override
    public Pager<ResourceDTO> searchResources(Pager<ResourceDTO> pager, ResourceDTO resource) {
        logger.debug("Entering searchResources...");
        List<ResourceDTO> list = resourceDAO.searchResources(pager, resource);
        long size = resourceDAO.searchResourcesCount(pager, resource);
        return Pager.cloneFromPager(pager, size, list);
    }

    /**
     * <p>Title: getUserResourceDescendants</p>
     * <p>Description: </p>
     *
     * @param userId
     * @param codeList
     * @return
     */
    @Override
    public Map<ResourceDTO, List<ResourceDTO>> getUserResourceDescendants(Long userId, List<String> codeList) {
        Map<ResourceDTO, List<ResourceDTO>> result = new LinkedHashMap<ResourceDTO, List<ResourceDTO>>();
        for (String code : codeList) {
            List<ResourceDTO> resources = resourceDAO.getDescendants(userId, code);
            ResourceDTO parent = rebuildParent(code, resources);
            result.put(parent, resources);
        }
        return result;
    }

    /**
     * @param @param  code
     * @param @param  resources
     * @param @return
     * @return Resource
     * @throws
     * @Title: rebuildParent
     * @Description: (这里用一句话描述这个类的作用)
     */
    private ResourceDTO rebuildParent(String code, List<ResourceDTO> resources) {
        ResourceDTO parent = null;
        for (ResourceDTO resource : resources) {
            if (StringUtils.equals(code, resource.getCode())) {
                parent = resource;
                break;
            }
        }
        if (parent == null) {
            parent = resourceDAO.getResourceByCode(code);
        } else {
            resources.remove(parent);
        }
        return parent;
    }

    /**
     * <p>Title: getGroupResourceByUserId</p>
     * <p>Description: </p>
     *
     * @param userId
     * @return
     */
    @Override
    public List getGroupResourceByUserId(Long userId) {
        JSONArray arr = JSONArray.fromObject(resourceDAO.getGroupResourceByUserId(userId));
        return getTree(arr, 0);
    }


    public JSONArray getTree(JSONArray models, long ssid) {
        JSONArray trees = new JSONArray();
        for (int i = 0; i < models.size(); i++) {
            JSONObject object = models.getJSONObject(i);
            if (object.getDouble("parentId") == ssid) {
                JSONObject tree = new JSONObject();
                tree.put("id", object.getLong("id"));
                JSONArray array = getTree(models, object.getLong("id"));
                if (array.size() != 0) {
                    tree.put("children", array);
                }
                tree.put("text", object.get("name"));
                tree.put("url", object.get("url"));
                trees.add(tree);
            }
        }
        return trees;
    }

    /**
     * 查询资源信息
     * ZhangYing@jbinfo.cn
     * 2015-12-11
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ResourceDTO> selectResourceTree(ResourceDTO resource) {
        JSONArray arr1 = JSONArray.fromObject(resourceDAO.getAll(resource));
        JSONArray arr = getTree(arr1, 0);
        return arr;
    }

    @Override
    public List<ResourceDTO> getParentResource(ResourceDTO resource) {
        return resourceDAO.getParentResource(resource);
    }

}
