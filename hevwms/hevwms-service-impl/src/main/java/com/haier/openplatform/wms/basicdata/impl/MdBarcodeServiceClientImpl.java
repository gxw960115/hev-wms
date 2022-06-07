package com.haier.openplatform.wms.basicdata.impl;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.hevwms.basic.service.MdBarcodeService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;
import com.haier.openplatform.wms.basicdata.dto.MdBarcodeDTO;
import com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

import org.apache.commons.beanutils.BeanUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/** 
* @ClassName: MdBarcodeServiceClientImpl 
* @Description: (这里用一句话描述这个类的作用) 
* @author Song Yinglong // Nicholas
* @date 2015-10-26 下午2:16:43 
* @param 
*/ 
@Path("MdBarcodeServiceClientImpl")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//参数类型
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//返回值类型
public class MdBarcodeServiceClientImpl implements MdBarcodeServiceClient{
	
	/**  
	 * @Fields field:field:{}(mdBarcodeService)  
	 */  
	private MdBarcodeService mdBarcodeService;
	
	/** (非 Javadoc) 
	* <p>Title: searchBarcodes</p> 
	* <p>Description: 查询条码并分页</p> 
	* @param pager
	* @param mdBarcodeDTO
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#searchBarcodes(com.haier.openplatform.util.Pager, com.haier.openplatform.showcase.security.dto.MdBarcodeDTO) 
	*/ 
	@Override
	public Pager<MdBarcodeDTO> searchBarcodes(Pager<MdBarcodeDTO> pager,
		MdBarcodeDTO mdBarcodeDTO) {
		Pager<MdBarcode> page = new Pager<MdBarcode>();
		Pager<MdBarcodeDTO> pages = new Pager<MdBarcodeDTO>();
		try {
			BeanUtils.copyProperties(page, pager);
			MdBarcode mdBarcode = new MdBarcode();
			BeanUtils.copyProperties(mdBarcode, mdBarcodeDTO);
			page =mdBarcodeService.searchMdBarcodes(page, mdBarcode);
			BeanUtils.copyProperties(pages, page);
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return pages;
	}
	
	
	/** (非 Javadoc) 
	* <p>Title: createBarcodes </p> 
	* <p>Description: 生成条码</p> 
	* @param mdBarcodeDTO 
	* @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#createBarcodes(com.haier.openplatform.showcase.security.dto.MdBarcodeDTO) 
	*/ 
	@Override
	public String createBarcodes(MdBarcodeDTO mdBarcodeDTO) throws IllegalAccessException, InvocationTargetException {
		MdBarcode mdBarcode = new MdBarcode();
		BeanUtils.copyProperties(mdBarcode, mdBarcodeDTO);
		String flag = mdBarcodeService.addNewBarcodes(mdBarcode);
		return flag;
	}

	/** 
	* @Title: setMdBarcodeService 
	* @Description: (这里用一句话描述这个方法的作用) 
	* @param @param mdBarcodeService    设定文件 
	* @return void    返回类型 
	* @throws 
	*/ 
	public void setMdBarcodeService(MdBarcodeService mdBarcodeService) {
		this.mdBarcodeService = mdBarcodeService;
	}

	
	/** (non-Javadoc)  
	 * <p>Title: create1DBarcode</p>  
	 * <p>Description:创建 </p>  
	 * @param barcode
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#create1DBarcode(java.lang.String)  
	 */
	@POST
    @Path("create1DBarcode")
    @Override
    public List<String> create1DBarcode(String barcode) {
	    List<String> url=new ArrayList<String>();
	    String barc[]=barcode.split(",");
	    for(String temp:barc){
	        String resource=mdBarcodeService.createTempDir(temp);
	        mdBarcodeService.createMdBarcode1D(resource,temp);
	        /*String[] str=resource.split("\\\\");
	        for(int i=0;i<str.length;i++){
	            if(i+1==str.length)
	                resource=str[i];
	        }
	        String[] str2=resource.split("//");*/
	        url.add("barcodeTemp"+"/"+temp+".png");
	    }
	    return url;
        /*String resource=mdBarcodeService.createTempDir();
        mdBarcodeService.createMdBarcode1D(resource,barcode);
        System.out.println("======="+resource);
        String[] str=resource.split("\\\\");
        for(int i=0;i<str.length;i++){
            if(i+1==str.length)
                resource=str[i];
        }
        String[] str2=resource.split("//");
        return str2[0]+"/"+str2[1];*/
    }
	
    /** (non-Javadoc)  
     * <p>Title: searchMdBarcode</p>  
     * <p>Description:search MdBarcode </p>  
     * @param page
     * @param rows
     * @param dto
     * @return  
     * @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#searchMdBarcode(java.lang.Long, java.lang.Long, com.haier.openplatform.wms.basicdata.dto.MdBarcodeDTO)  
     */
    @Override
    public Pager<MdBarcodeDTO> searchMdBarcode(Long page, Long rows,
            MdBarcodeDTO dto) {
        MdBarcode mdBarcode = new MdBarcode();
        try {
            BeanUtils.copyProperties(mdBarcode, dto);// 将用于网络传输的DTO转成biz层用的实体对象
        } catch (IllegalAccessException e1) {
            
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            
            e1.printStackTrace();
        }

        Pager<MdBarcode> pager = new Pager<MdBarcode>();
        pager.setCurrentPage(page);// 当前页
        pager.setPageSize(rows);// 每页的行数

        Pager<MdBarcodeDTO> pagerDTO = new Pager<MdBarcodeDTO>();
        
        Pager<MdBarcode> pagerTemp = mdBarcodeService.searchMdBarcodes(pager, mdBarcode);
        List<MdBarcode> listInfo=pagerTemp.getRecords();
        
        List<MdBarcodeDTO> list = new ArrayList<MdBarcodeDTO>();
        // 循环遍历biz层返回的结果集，并转成DTO集合返回
        for (MdBarcode info : listInfo) {
            MdBarcodeDTO d = new MdBarcodeDTO();
            try {
                BeanUtils.copyProperties(d, info);
                list.add(d);
            } catch (IllegalAccessException e) {
                
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                
                e.printStackTrace();
            }
        }
        pagerDTO.setRecords(list);
        pagerDTO.setTotalRecords(pagerTemp.getTotalRecords());
        return pagerDTO;
    }


	/** (non-Javadoc)  
	 * <p>Title: existBarcode</p>  
	 * <p>Description:检查barcode是否存在 </p>  
	 * @param barcode
	 * @return  
	 * @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#existBarcode(java.lang.String)  
	 */
	@Override
	public boolean existBarcode(String barcode) {
		return mdBarcodeService.existBarcode(barcode);
	}

	/** (non-Javadoc)  
	 * <p>Title: insert</p>  
	 * <p>Description:插入 </p>  
	 * @param barcode  
	 * @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#insert(java.lang.String)  
	 */
	@Override
	public void insert(String barcode, String userName) {
		mdBarcodeService.insert(barcode, userName);
	}

	/* (非 Javadoc) 
	* <p>Title: modifyBarcodeBin</p> 
	* <p>Description: </p> 
	* @param inpara
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#modifyBarcodeBin(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO) 
	*/
	@Override
	public OrderUploadOutDTO modifyBarcodeBin(OrderUploadInDTO inpara) {
		return mdBarcodeService.modifyBarcodeBin(inpara);
	}

	/* (非 Javadoc) 
	* <p>Title: initUserPlantAndLoc</p> 
	* <p>Description: </p> 
	* @param inpara
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#initUserPlantAndLoc(com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO) 
	*/
	@Override
	public OrderUploadOutDTO initUserPlantAndLoc(OrderUploadInDTO inpara) {
		return mdBarcodeService.initUserPlantAndLoc(inpara);
	}


	/* (非 Javadoc) 
	* <p>Title: searchGiftBarcodes</p> 
	* <p>Description: </p> 
	* @param pager
	* @param mdBarcodeDTO
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#searchGiftBarcodes(com.haier.openplatform.util.Pager, com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO) 
	*/
	@Override
	public Pager<GiftBarcodeDTO> searchGiftBarcodes(Pager<GiftBarcodeDTO> pager,
		GiftBarcodeDTO mdBarcodeDTO) {
		Pager<GiftBarcodeDTO> page = new Pager<GiftBarcodeDTO>();
		page =mdBarcodeService.searchGiftBarcodes(page, mdBarcodeDTO);

		return page;
	}

	/* (非 Javadoc) 
	* <p>Title: createGiftBarcode</p> 
	* <p>Description: </p> 
	* @param giftBarcodeDTO
	* @return
	* @throws IllegalAccessException
	* @throws InvocationTargetException 
	* @see com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient#createGiftBarcode(com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO) 
	*/
	@Override
	public String createGiftBarcode(GiftBarcodeDTO giftBarcodeDTO)
			throws IllegalAccessException, InvocationTargetException {
		String flag = mdBarcodeService.addGiftBarcode(giftBarcodeDTO);
		return flag;
	}
}
