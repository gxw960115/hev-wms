package com.haier.openplatform.wms.basicdata.impl;
import java.util.Calendar;
import java.util.List;

import com.haier.openplatform.wms.remoting.dto.InterfaceOutDTO;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.hevwms.basic.service.MdMatInfoService;
import com.haier.hevwms.sapinterface.DownMaterialFromSap;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.basicdata.service.MdmathInfoServiceClient;

import io.terminus.pampas.common.BaseUser;

/**
* @ClassName: MdmathInfoServiceClientImpl
* @Description:物料基础数据的相关方法
*
*/
public class MdmathInfoServiceClientImpl implements MdmathInfoServiceClient {
	
	private static final Logger logger = LoggerFactory.getLogger(MdmathInfoServiceClientImpl.class);
	
	private MdMatInfoService mdMatInfoService;
	
	/**  
	 * @Title: getMdMatInfoService  
	 * @Description: (get)  
	 * @return
	 * @return MdMatInfoService 
	 * @throws  
	 */  
	public MdMatInfoService getMdMatInfoService() {
		return mdMatInfoService;
	}

	/**  
	 * @Title: setMdMatInfoService  
	 * @Description: (set)  
	 * @param mdMatInfoService
	 * @return void 
	 * @throws  
	 */  
	public void setMdMatInfoService(MdMatInfoService mdMatInfoService) {
		this.mdMatInfoService = mdMatInfoService;
	}
	
	/**
	* <p>Title: SearchMdmaInfo</p>
	* <p>Description:物料数据查询 </p>
	* @param pager
	* @param mdMathInfoDTO
	* @return
	*/
	@Override
	public Pager<MdMatInfoDTO> searchMdmaInfo(Pager<MdMatInfoDTO> pager,
			MdMatInfoDTO mdMathInfoDTO) {
	    
		return mdMatInfoService.searchMdMatInfos(pager, mdMathInfoDTO);
	}
	
    /**
    * <p>Title: createMdmatInfos</p>
    * <p>Description:物料增加 </p>
    * @param mdMathInfoDTO
    * @return
    */
    @Override
    public String createMdmatInfos(MdMatInfoDTO mdMathInfoDTO) {
    	String flag=mdMatInfoService.createMdMatInfo(mdMathInfoDTO);
        return flag;
    }

    /**
    * <p>Title: deleteMdmatInfo</p>
    * <p>Description:删除物料信息 </p>
    * @param idList
    * @return
    */
    @Override
    public String deleteMdmatInfo(List<Long> idList) {
      String flag= mdMatInfoService.deleteMdMatInfoAll(idList);
      return flag;
    }

    /**
    * <p>Title: updateMdmatInfo</p>
    * <p>Description:物料更新</p>
    * @param mdMathInfoDTO
    * @return
    */
    @Override
    public String updateMdmatInfo(MdMatInfoDTO mdMathInfoDTO) {
        String flag=mdMatInfoService.updateMdMatInfo(mdMathInfoDTO);
        return flag;
    }

    /** (non-Javadoc)  
     * <p>Title: getMdMatInfoByParam</p>  
     * <p>Description:dispatchPlanInfo export </p>  
     * @param dto
     * @return  
     */
    @Override
    public List<MdMatInfoDTO> getMdMatInfoByParam(MdMatInfoDTO dto) {
        return mdMatInfoService.getMdMatInfoByParam(dto);
    }

	/** (non-Javadoc)  
	 * <p>Title: importMaterialInfo</p>  
	 * <p>Description:导入物料 </p>  
	 * @param obj
	 * @param user
	 * @return  
	 */
	@Override
	public String importMaterialInfo(List<MdMatInfoDTO> obj, BaseUser user) {
		 return mdMatInfoService.saveOrUpdate(obj, user);
	}

	/* (非 Javadoc) 
	* <p>Title: downloadData</p> 
	* <p>Description: </p> 
	* @param user
	* @param materialNo
	* @return 
	* @see com.haier.openplatform.wms.basicdata.service.MdmathInfoServiceClient#downloadData(io.terminus.pampas.common.BaseUser, java.lang.String) 
	*/
	@Override
	public InterfaceOutDTO downloadData(BaseUser user, String materialNo) {
		
		Calendar cal = Calendar.getInstance();
		// 下载的结束日期
		String now = DateFormatUtils.format(cal, "yyyyMMdd");
		
		DownMaterialFromSap downSAP = new DownMaterialFromSap(materialNo, "20190101", now, "20190101", now, user.getName());
		return downSAP.exchangeWithSap();
	}

}
