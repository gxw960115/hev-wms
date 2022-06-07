package com.haier.openplatform.wms.security.service.impl;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.basic.domain.CdFactory;
import com.haier.hevwms.basic.service.CdFactoryService;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.showcase.util.Paging;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdFactoryDTO;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.openplatform.wms.security.dto.PlantDTO;
import com.haier.openplatform.wms.security.service.PlantServiceClient;

/**
 * @ClassName: PlantServiceClientImpl
 * @Description: dubbo层处理 工厂信息管理 相关的功能
 * @author songyinglong
 * @Date 2015-10-30 下午2:54:12
 */
// @Path("PlantServiceClientImpl")
// @Consumes({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 参数类型
// @Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
// 返回值类型
public class PlantServiceClientImpl implements PlantServiceClient {
    private CdFactoryService plantService;// biz层的接口

    /**
	 * @return the plantService
	 */
	public CdFactoryService getPlantService() {
		return plantService;
	}

	 /**得到所有工厂信息并分页
     * fanrong
     * 2015-11-23
     */
    @Override
    public Pager<PlantDTO> searchPlantByParams(Long page, Long rows, PlantDTO plantDTO) {
    	return plantService.searchCdFactorysByParams(page, rows, plantDTO);
    }
	
	/**
     * <p>
     * Title: searchPlant
     * </p>
     * <p>
     * Description:查询工厂信息
     * </p>
     * 
     * @param page
     * @param rows
     * @param plantDTO
     * @return
     * @see com.haier.openplatform.wms.security.service.PlantServiceClient#searchPlant(java.lang.Long,
     *      java.lang.Long, com.haier.openplatform.wms.security.dto.PlantDTO)
     */
    @Override
    public Pager<PlantDTO> searchPlant(Long page, Long rows, PlantDTO plantDTO) {
        CdFactory cdFactory = new CdFactory();
        try {
            BeanUtils.copyProperties(cdFactory, plantDTO);// 将用于网络传输的DTO转成biz层用的实体对象
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }

        Pager<CdFactory> pager = new Pager<CdFactory>();
        pager.setCurrentPage(page);// 当前页
        pager.setPageSize(rows);// 每页的行数
        // pager.setCurrentPage(1L);
        // pager.setPageSize(20L);

        Pager<PlantDTO> pagerDTO = new Pager<PlantDTO>();

        List<CdFactory> listInfo = plantService.searchCdFactorys(pager,
                cdFactory);
        List<PlantDTO> list = new ArrayList<PlantDTO>();
        // 循环遍历biz层返回的结果集，并转成DTO集合返回
        for (CdFactory info : listInfo) {
            PlantDTO dto = new PlantDTO();
            try {
                BeanUtils.copyProperties(dto, info);
                list.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        long size = plantService.searchCdFactorysCount(cdFactory);
//        pagerDTO.setTotalRecords(Long.parseLong(String.valueOf(list.size())));
        pagerDTO.setTotalRecords(size);
        return pagerDTO;
    }

    // plant_manage用的方法
    /*
     * @Override
     * 
     * @GET
     * 
     * @Path("searchPlant") public Paging<PlantDTO> searchPlant() {
     * Paging<PlantDTO> paging = new Paging<PlantDTO>(); List<CdFactory>
     * listInfo = plantService.getCdFactorys(); List<PlantDTO> list = new
     * ArrayList<PlantDTO>(); for(CdFactory info : listInfo){ PlantDTO dto = new
     * PlantDTO(); try { BeanUtils.copyProperties(dto,info); list.add(dto); }
     * catch (IllegalAccessException e) { //  Auto-generated catch block
     * e.printStackTrace(); } catch (InvocationTargetException e) { // 
     * Auto-generated catch block e.printStackTrace(); } } paging.setData(list);
     * paging.setTotal(list.size()); return paging; }
     */

    /**
     * @Title: setPlantService
     * @Description: spring实现依赖注入的时候用到该setter方法
     * @param @param plantService
     * @return void
     * @throws
     */
    public void setPlantService(CdFactoryService plantService) {
        this.plantService = plantService;
    }

    /**
     * <p>
     * Title: searchPlantByCodeAndName
     * </p>
     * <p>
     * Description: 根据工厂编码 以及 工厂名称 进行查询
     * </p>
     * 
     * @param plantCode
     * @param plantName
     * @return
     * @see com.haier.openplatform.wms.security.service.PlantServiceClient#searchPlantByCodeAndName(java.lang.String,
     *      java.lang.String)
     */
    @Override
    @GET
    @Path("searchPlantByCodeAndName")
    public Paging<PlantDTO> searchPlantByCodeAndName(
            @DefaultValue("") @QueryParam("code") String plantCode,
            @DefaultValue("") @QueryParam("name") String plantName) {
        // 组装一个CdFactory
        CdFactory cdFactory = new CdFactory();
        cdFactory.setCode(plantCode);
        cdFactory.setName(plantName);
        // 组装一个Pager<CdFactory> ,暂时用默认的值
        Pager<CdFactory> pager = new Pager<CdFactory>();
        // 调用biz层执行查询
        List<CdFactory> listInfo = plantService.searchCdFactorys(pager,
                cdFactory);
        Long size = plantService.searchCdFactorysCount(cdFactory);
        // 将biz层返回的List进行转换后，返回给前台页面
        Paging<PlantDTO> paging = new Paging<PlantDTO>();
        List<PlantDTO> list = new ArrayList<PlantDTO>();
        for (CdFactory info : listInfo) {
            PlantDTO dto = new PlantDTO();
            try {
                BeanUtils.copyProperties(dto, info);
                list.add(dto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        paging.setData(list);
        paging.setTotal(size);
        return paging;
    }

    /**
     * <p>
     * Title: addPlant
     * </p>
     * <p>
     * Description: 新增工厂
     * </p>
     * 
     * @param plantDTO
     * @return
     * @see com.haier.openplatform.wms.security.service.PlantServiceClient#addPlant(com.haier.openplatform.wms.security.dto.PlantDTO)
     */
    @GET
    @Path("addPlant")
    @Override
    public String addPlant(@PathParam("plantDTO") PlantDTO plantDTO) {
        CdFactory cdFactory = new CdFactory();
        try {
            if(UserUtil.getCurrentUser()!=null){
            	String name = UserUtil.getCurrentUser().getName();
                plantDTO.setCreatedBy(name);
                plantDTO.setModifyBy(name);
            }
            BeanUtils.copyProperties(cdFactory, plantDTO);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        ExecuteResult<CdFactory> executeResult = plantService
                .createCdFactory(cdFactory);
        if (executeResult.isSuccess()) {
            return "success";
        }
        return "error";
    }

    /**
     * <p>
     * Title: updatePlant
     * </p>
     * <p>
     * Description:编辑工厂信息，并保存
     * </p>
     * 
     * @param plantDTO
     * @return
     * @see com.haier.openplatform.wms.security.service.PlantServiceClient#updatePlant(com.haier.openplatform.wms.security.dto.PlantDTO)
     */
    @Override
    public String updatePlant(PlantDTO plantDTO) {
        BaseUser user = UserUtil.getCurrentUser();
        CdFactory cdFactory = new CdFactory();
        plantDTO.setModifyBy(user.getName());
        try {
            BeanUtils.copyProperties(cdFactory, plantDTO);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        ExecuteResult<CdFactory> executeResult = plantService
                .updateCdFactory(cdFactory);
        if (executeResult.isSuccess()) {
            return "success";
        }
        return "error";
    }

    /**
     * <p>
     * Title: deletePlant
     * </p>
     * <p>
     * Description: 删除工厂信息
     * </p>
     * 
     * @param rowid
     * @return
     * @see com.haier.openplatform.wms.security.service.PlantServiceClient#deletePlant(java.lang.String)
     */
    @Override
    public String deletePlant(String rowid) {
        ExecuteResult<CdFactory> executeResult = plantService
                .deleteCdFactory(Long.parseLong(rowid));
        if (executeResult.isSuccess()) {
            return "success";
        }
        return "error";
    }

    @Override
    public List<CdFactoryDTO> searchAll() {

        List<CdFactory> rows = plantService.getCdFactorys();
        List<CdFactoryDTO> row = new ArrayList<CdFactoryDTO>();

        if (rows.size() > 0) {
            for (CdFactory sdf : rows) {
                CdFactoryDTO cdd = new CdFactoryDTO();
                try {
                    BeanUtilEx.copyProperties(cdd, sdf);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                row.add(cdd);
            }

        }
        for (CdFactoryDTO cfd:row){
        	cfd.setName(cfd.getName()+" ("+cfd.getCode()+")");
        }
        return row;
    }
    
    /* 删除工厂信息
     * fanrong
     * 2015-11-34
     */
    public String deletePlantsByIds(String ids){
    	List<Long> idList = new ArrayList<Long>();
        for (String id : StringUtils.split(ids, ",")) {
            if (StringUtils.isEmpty(id)) {
                continue;
            }
            idList.add(Long.valueOf(id));
        }
        ExecuteResult<CdFactory> result = plantService.deleteCdFactoryAll(idList);
        if(!result.isSuccess()){
        	return "error";
        }else{
        	
        	return "success";
        }
    }

}
