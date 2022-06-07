package com.haier.openplatform.wms.stocktaking.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.inventory.service.OdsInventoryInfoService;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.hevwms.takestock.service.OdsPdDiffDtlService;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO;
import com.haier.openplatform.wms.stocktaking.service.StocktakingDiffServiceClient;

import io.terminus.pampas.common.UserUtil;

@Path("StocktakingDiffServiceClientImpl")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//参数类型
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//返回值类型
public class StocktakingDiffServiceClientImpl implements StocktakingDiffServiceClient {
   
	private OdsPdDiffDtlService odsPdDiffDtlService;
    private OdsInventoryInfoService odsInventoryInfoService;
    
    private Pager<OdsPdDiffDtl> pager;
    private OdsPdDiffDtl odsPdDiffDtl;
    private String ids;

    private Long total;
    private List<OdsPdDiffDtl> rows;
    private boolean isSuccess;
    private String msg;
    private static final Logger LOG = Logger.getLogger(StocktakingDiffServiceClientImpl.class);
    
    @Override
    public Pager<OdsPdDiffDtlDTO> searchStocktakingDiff(long page, long rows, OdsPdDiffDtlDTO odsPdDiffDtlDTO) {
        OdsPdDiffDtl odsPdDiffDtl=new OdsPdDiffDtl();//biz层实体类，对应库存盘点单 ods_pd_info
        try {
            BeanUtils.copyProperties(odsPdDiffDtl,odsPdDiffDtlDTO);//将出入的dto转成biz层使用的domain实体类
        } catch (Exception e1) {
           LOG.error("searchStocktakingDiff error:"+e1.toString());
        }
        
        Pager<OdsPdDiffDtl> pager=new Pager<OdsPdDiffDtl>();
        pager.setCurrentPage(page);
        pager.setPageSize(rows);
        
        Pager<OdsPdDiffDtlDTO> pagerDTO = new Pager<OdsPdDiffDtlDTO>();
        Pager<OdsPdDiffDtl> temp=odsPdDiffDtlService.searchOdsPdDiffDtls(pager, odsPdDiffDtl);
        long totalSize=temp.getTotalRecords();
        List<OdsPdDiffDtl> listInfo = temp.getRecords();
        List<OdsPdDiffDtlDTO> list = new ArrayList<OdsPdDiffDtlDTO>();
        //循环遍历返回的listInfo结果集合，并将OdsPdInfo实体类转成DTO实体，以集合形式返回
        for(OdsPdDiffDtl info : listInfo){
            OdsPdDiffDtlDTO dto = new OdsPdDiffDtlDTO();
            try {
                BeanUtils.copyProperties(dto,info);
                list.add(dto);
            } catch (Exception e) {
                LOG.error("searchStocktakingDiff"+e.toString());
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(totalSize);
        return pagerDTO;
    }
    
    
    @Override
    public String processDiff(String ids, String processFlag,String processReason) {
        
        OdsPdDiffDtl odsPdDiffDtl=new OdsPdDiffDtl();
        odsPdDiffDtl.setProcessFlag(processFlag);
        odsPdDiffDtl.setCreateBy(UserUtil.getCurrentUser().getName());
        odsPdDiffDtl.setProcessReason(processReason);
        ExecuteResult<OdsPdDiffDtl> executeResult = odsInventoryInfoService.updateProcessDiff(odsPdDiffDtl,ids);
        this.setSuccess(executeResult.isSuccess());
        msg = executeResult.getSuccessMessage();
        if (!executeResult.isSuccess()) {
            return msg;
        }
        return "success";
    }
    
    /**
    * <p>Title: getOdsPdDiffInfo</p>
    * <p>Description:页面导出时用到的查询 </p>
    * @param odsPdDiffDtlDTO
    * @return
    * @see com.haier.openplatform.wms.stocktaking.service.StocktakingDiffServiceClient#getOdsPdDiffInfo(com.haier.openplatform.wms.stocktaking.dto.OdsPdDiffDtlDTO)
    */
    @Override
    public List<OdsPdDiffDtlDTO> getOdsPdDiffInfo(OdsPdDiffDtlDTO odsPdDiffDtlDTO) {
        OdsPdDiffDtl dtl=new OdsPdDiffDtl();
        try {
            BeanUtils.copyProperties(dtl, odsPdDiffDtlDTO);
        } catch (Exception e) {
            LOG.error("getOdsPdDiffInfo error:"+e.toString());
        }
        List<OdsPdDiffDtl> temp=odsPdDiffDtlService.getOdsPdDiffDtl(dtl);
        List<OdsPdDiffDtlDTO> list=new ArrayList<OdsPdDiffDtlDTO>();
        for(OdsPdDiffDtl d:temp){
            OdsPdDiffDtlDTO dto= new OdsPdDiffDtlDTO();
            try {
                BeanUtils.copyProperties(dto, d);
            } catch (Exception e) {
                LOG.error("getOdsPdDiffInfo error:"+e.toString());
            }
            list.add(dto);
        }
        return list;
    }
    
    @Override
   	public Long searchOdsPdDiffDtlsCount(OdsPdDiffDtlDTO dto) {
    	OdsPdDiffDtl dtl=new OdsPdDiffDtl();
        try {
            BeanUtils.copyProperties(dtl, dto);
        } catch (Exception e) {
            LOG.error("getOdsPdDiffInfo error:"+e.toString());
        }
   		return odsPdDiffDtlService.searchOdsPdDiffDtlsCount(dtl);
   	}

    /**
     * Lock And Unlock
     * @param ids
     * @param processFlag
     * @return
     */
    @Override
    public String lockAndUnlock(String ids, String processFlag) {
        for (String id : ids.split(",")) {
            odsInventoryInfoService.updateStocktakingDiffStatus(id,processFlag);
        }
        return "SUCCESS";
    }

    public OdsPdDiffDtlService getOdsPdDiffDtlService() {
        return odsPdDiffDtlService;
    }


    public void setOdsPdDiffDtlService(OdsPdDiffDtlService odsPdDiffDtlService) {
        this.odsPdDiffDtlService = odsPdDiffDtlService;
    }


    public OdsInventoryInfoService getOdsInventoryInfoService() {
        return odsInventoryInfoService;
    }


    public void setOdsInventoryInfoService(
            OdsInventoryInfoService odsInventoryInfoService) {
        this.odsInventoryInfoService = odsInventoryInfoService;
    }

    public Pager<OdsPdDiffDtl> getPager() {
        return pager;
    }

    public void setPager(Pager<OdsPdDiffDtl> pager) {
        this.pager = pager;
    }

    public OdsPdDiffDtl getOdsPdDiffDtl() {
        return odsPdDiffDtl;
    }

    public void setOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl) {
        this.odsPdDiffDtl = odsPdDiffDtl;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<OdsPdDiffDtl> getRows() {
        return rows;
    }

    public void setRows(List<OdsPdDiffDtl> rows) {
        this.rows = rows;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
