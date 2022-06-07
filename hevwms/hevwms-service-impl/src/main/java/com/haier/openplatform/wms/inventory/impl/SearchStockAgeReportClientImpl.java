package com.haier.openplatform.wms.inventory.impl;

import io.terminus.pampas.common.UserUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.inventory.service.OdsInventoryInfoDtlService;
import com.haier.hevwms.util.BeanUtilEx;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient;

/**
 * @Company 青鸟软通
 * @Title:库存报表实现
 * @Package com.haier.openplatform.wms.inventory
 * @author sunhaoyu
 * @date 2015/10/29
 * @version V1.0
 */
public class SearchStockAgeReportClientImpl implements
        SearchStockAgeReportClient {
    private OdsInventoryInfoDtlService odsInventoryInfoDtlService;

    public OdsInventoryInfoDtlService getOdsInventoryInfoDtlService() {
        return odsInventoryInfoDtlService;
    }

    public void setOdsInventoryInfoDtlService(
            OdsInventoryInfoDtlService odsInventoryInfoDtlService) {
        this.odsInventoryInfoDtlService = odsInventoryInfoDtlService;
    }

    /**
     * Title: getStockAgeReport Description: 库存报表详情实现
     * 
     * @param pager
     * @param dto
     * @return
     */
    @Override
    public Pager<OdsInventoryInfoDtlDTO> getStockAgeReport(
            Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO dto) {

        Pager<OdsInventoryInfoDtl> page = new Pager<OdsInventoryInfoDtl>();
        OdsInventoryInfoDtl odl = new OdsInventoryInfoDtl();

        try {
            BeanUtilEx.copyProperties(page, pager);
            BeanUtilEx.copyProperties(odl, dto);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        page = odsInventoryInfoDtlService.searchOdsInventoryInfoDtls(page, odl);
        Pager<OdsInventoryInfoDtlDTO> pa = new Pager<OdsInventoryInfoDtlDTO>();
     
        List<OdsInventoryInfoDtlDTO> list=new ArrayList<OdsInventoryInfoDtlDTO>();
        List<OdsInventoryInfoDtl> li=page.getRecords();
        if(li.size()>0){
        	for(OdsInventoryInfoDtl od:li){
        		OdsInventoryInfoDtlDTO oid=new OdsInventoryInfoDtlDTO();
        		try {
        			BeanUtilEx.copyProperties(oid, od);
        			list.add(oid);
        			pa.setRecords(list);
        			pa.setTotalRecords(page.getTotalRecords());
        		} catch (InvocationTargetException e) {
        			e.printStackTrace();
        		} catch (IllegalAccessException e) {
        			e.printStackTrace();
        		}
        	}
        } 
        return pa;
    }

    /* (非 Javadoc) 
    * <p>Title: getInventoryInfoDtlByParams</p> 
    * <p>Description: </p> 
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient#getInventoryInfoDtlByParams(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
    */
    @Override
    public List<OdsInventoryInfoDtlDTO> getInventoryInfoDtlByParams(
            OdsInventoryInfoDtlDTO dto) {
        OdsInventoryInfoDtl odl = new OdsInventoryInfoDtl();
        try {
            BeanUtilEx.copyProperties(odl, dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        List<OdsInventoryInfoDtl> list = odsInventoryInfoDtlService
                .getOdsInventoryInfoDtlByParam(odl);
        List<OdsInventoryInfoDtlDTO> lists = new ArrayList<OdsInventoryInfoDtlDTO>();
        if (list.size() > 0) {
            for (OdsInventoryInfoDtl lis : list) {
                OdsInventoryInfoDtlDTO odla = new OdsInventoryInfoDtlDTO();
                try {
                    BeanUtilEx.copyProperties(odla, lis);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                lists.add(odla);
            }

        }
        return lists;
    }
    
    /* (非 Javadoc) 
    * <p>Title: sapQtyDetail</p> 
    * <p>Description: </p> 
    * @param pager
    * @param dto
    * @return 
    * @see com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient#sapQtyDetail(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
    */
    @Override
    public Pager<OdsInventoryInfoDtlDTO> sapQtyDetail(
	    Pager<OdsInventoryInfoDtlDTO> pager, OdsInventoryInfoDtlDTO dto) {
		Pager<OdsInventoryInfoDtl> dtlPager =new Pager<OdsInventoryInfoDtl>();
		OdsInventoryInfoDtl dtl=new OdsInventoryInfoDtl();
		try {
		    BeanUtilEx.copyProperties(dtlPager, pager);
		    BeanUtilEx.copyProperties(dtl, dto);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		dtlPager=odsInventoryInfoDtlService.sapQtyDetail(dtlPager, dtl);
		try {
		    BeanUtilEx.copyProperties(pager, dtlPager);
		} catch (Exception e) {
		    // TODO: handle exception
		}
		return pager;
    }
    
	/* (非 Javadoc) 
	* <p>Title: barcodeRemarkUpdate</p> 
	* <p>Description: </p> 
	* @param odsInventoryInfoDtlDTO
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient#barcodeRemarkUpdate(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	@Override
	public String barcodeRemarkUpdate(OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO) {
		OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
		try {
            BeanUtils.copyProperties(odsInventoryInfoDtl, odsInventoryInfoDtlDTO);
            odsInventoryInfoDtl.setModifyBy(UserUtil.getCurrentUser().getName());
            odsInventoryInfoDtl.setModifyDate(new Date());
        } catch (Exception e) {
            // TODO 
        } 
		ExecuteResult<OdsInventoryInfoDtl> result=odsInventoryInfoDtlService.updateBarcodeRemark(odsInventoryInfoDtl);
		if (result.isSuccess()){
			return "success";
		} else {
			return "error";
		}
	}

	/* (非 Javadoc) 
	* <p>Title: updateBarcodeStatus</p> 
	* <p>Description: </p> 
	* @param list
	* @param status 
	* @see com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient#updateBarcodeStatus(java.util.List, java.lang.String) 
	*/
	@Override
	public void updateBarcodeStatus(List<OdsInventoryInfoDtlDTO> list,String status) {
		
		if (list.size()>0) {
			for (OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO : list) {
				odsInventoryInfoDtlService.updateBarcodeStatus(odsInventoryInfoDtlDTO.getBarcode(), status);
			}
		}
	}
	
	/* (非 Javadoc) 
	* <p>Title: getExportAmount</p> 
	* <p>Description: </p> 
	* @param dto
	* @return 
	* @see com.haier.openplatform.wms.inventory.service.SearchStockAgeReportClient#getExportAmount(com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO) 
	*/
	public Long getExportAmount(OdsInventoryInfoDtlDTO dto) {
		OdsInventoryInfoDtl odsInventoryInfoDtl = new OdsInventoryInfoDtl();
		try {
            BeanUtils.copyProperties(odsInventoryInfoDtl, dto);
        } catch (Exception e) {
        }
		return odsInventoryInfoDtlService.getExportAmount(odsInventoryInfoDtl);
	}
}
