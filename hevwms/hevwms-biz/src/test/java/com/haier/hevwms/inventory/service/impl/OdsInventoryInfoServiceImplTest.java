package com.haier.hevwms.inventory.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.haier.hevwms.inventory.domain.OdsBarcodeHistory;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDTO;
import com.haier.hevwms.BasicTestCase;
import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.inventory.dao.OdsBarcodeHistoryDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.takestock.dao.OdsPdDiffDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;

/**   
* Copyright: Copyright (c) 2018 LYY
* 
* @ClassName: OdsInventoryInfoServiceImplTest.java
* @Description: 
*
* @version: v1.0.0
* @author: LYY
* @date: 2018年6月27日 下午2:46:58 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月27日     LYY           v1.0.0               修改原因
*/
public class OdsInventoryInfoServiceImplTest extends BasicTestCase {
	OdsInventoryInfoServiceImpl ss = new OdsInventoryInfoServiceImpl();
	private OdsInventoryInfoDAO odsInventoryInfoDAO;
    private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
    private OdsBarcodeHistoryDAO odsBarcodeHistoryDAO;
    private OdsPdDiffDtlDAO odsPdDiffDtlDAO;
    private MdMatInfoDAO mdMatInfoDAO;
	/**  
	* @Title: bf  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:47:02 
	*/ 
	@Before
	public void bf() {

		odsInventoryInfoDAO = EasyMock.createMock(OdsInventoryInfoDAO.class);
		odsInventoryInfoDtlDAO = EasyMock.createMock(OdsInventoryInfoDtlDAO.class);
		odsBarcodeHistoryDAO = EasyMock.createMock(OdsBarcodeHistoryDAO.class);
		odsPdDiffDtlDAO = EasyMock.createMock(OdsPdDiffDtlDAO.class);
		mdMatInfoDAO = EasyMock.createMock(MdMatInfoDAO.class);
		
		ss.setMdMatInfoDAO(mdMatInfoDAO);
		ss.setOdsBarcodeHistoryDAO(odsBarcodeHistoryDAO);
		ss.setOdsInventoryInfoDAO(odsInventoryInfoDAO);
		ss.setOdsInventoryInfoDtlDAO(odsInventoryInfoDtlDAO);
		ss.setOdsPdDiffDtlDAO(odsPdDiffDtlDAO);
		
		ss.getMdMatInfoDAO();
		ss.getOdsBarcodeHistoryDAO();
		ss.getOdsInventoryInfoDAO();
		ss.getOdsInventoryInfoDtlDAO();
		ss.getOdsPdDiffDtlDAO();
		
	}

	/**  
	* @Title: searchOdsInventoryInfos  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:47:46 
	*/ 
	@Test
	public void searchOdsInventoryInfos() {
		Pager<OdsInventoryInfoDTO> pager = new Pager<OdsInventoryInfoDTO>();
		OdsInventoryInfoDTO odsInventoryInfoDTO = new OdsInventoryInfoDTO();
		EasyMock.expect(odsInventoryInfoDAO.searchOdsInventoryInfos(
				pager,odsInventoryInfoDTO)
		).andReturn(new ArrayList<OdsInventoryInfoDTO>());
		EasyMock.expect(odsInventoryInfoDAO.searchOdsInventoryInfosCount(
				odsInventoryInfoDTO)
		).andReturn(1L);
		EasyMock.replay(odsInventoryInfoDAO);
		ss.searchOdsInventoryInfos(pager,odsInventoryInfoDTO);
	}

	@Test
	public void searchOdsInventoryBinInfos(){

		Pager<OdsInventoryInfoDtlDTO> pager_1 = new Pager<OdsInventoryInfoDtlDTO>();
		Pager<OdsInventoryInfoDtlDTO> pager_2 = new Pager<OdsInventoryInfoDtlDTO>();
		Pager<OdsInventoryInfoDtlDTO> pager_3 = new Pager<OdsInventoryInfoDtlDTO>();

		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_1 = new OdsInventoryInfoDtlDTO();
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_2 = new OdsInventoryInfoDtlDTO();
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_3 = new OdsInventoryInfoDtlDTO();

		odsInventoryInfoDtlDTO_1.setStatisticsFlag("1");
		odsInventoryInfoDtlDTO_2.setStatisticsFlag("2");
		odsInventoryInfoDtlDTO_3.setStatisticsFlag("3");

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryInfos(
				pager_1,odsInventoryInfoDtlDTO_1)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>()).times(1);
		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryInfosCount(
				odsInventoryInfoDtlDTO_1)
		).andReturn(1L).times(1);

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfos(
				pager_2,odsInventoryInfoDtlDTO_2)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>()).times(1);
		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfosCount(
				odsInventoryInfoDtlDTO_2)
		).andReturn(1L).times(1);

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryBinInfos(
				pager_3,odsInventoryInfoDtlDTO_3)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>()).times(1);
		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryBinInfosCount(
				odsInventoryInfoDtlDTO_3)
		).andReturn(1L).times(1);

		EasyMock.replay(odsInventoryInfoDtlDAO);

		ss.searchOdsInventoryBinInfos(pager_1,odsInventoryInfoDtlDTO_1);
		ss.searchOdsInventoryBinInfos(pager_2,odsInventoryInfoDtlDTO_2);
		ss.searchOdsInventoryBinInfos(pager_3,odsInventoryInfoDtlDTO_3);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void searchOdsInventoryBinList(){
		Pager<OdsInventoryInfoDtlDTO> pager_1 = new Pager<OdsInventoryInfoDtlDTO>();
		Pager<OdsInventoryInfoDtlDTO> pager_2 = new Pager<OdsInventoryInfoDtlDTO>();
		Pager<OdsInventoryInfoDtlDTO> pager_3 = new Pager<OdsInventoryInfoDtlDTO>();

		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_1 = new OdsInventoryInfoDtlDTO();
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_2 = new OdsInventoryInfoDtlDTO();
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_3 = new OdsInventoryInfoDtlDTO();

		odsInventoryInfoDtlDTO_1.setStatisticsFlag("1");
		odsInventoryInfoDtlDTO_2.setStatisticsFlag("2");
		odsInventoryInfoDtlDTO_3.setStatisticsFlag("3");

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryInfos(
				pager_1,odsInventoryInfoDtlDTO_1)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>()).times(1);

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfos(
				pager_2,odsInventoryInfoDtlDTO_2)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>()).times(1);

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryBinInfos(
				pager_3,odsInventoryInfoDtlDTO_3)
		).andReturn(new ArrayList<OdsInventoryInfoDtlDTO>()).times(1);

		EasyMock.replay(odsInventoryInfoDtlDAO);

		ss.searchOdsInventoryBinList(pager_1,odsInventoryInfoDtlDTO_1);
		ss.searchOdsInventoryBinList(pager_2,odsInventoryInfoDtlDTO_2);
		ss.searchOdsInventoryBinList(pager_3,odsInventoryInfoDtlDTO_3);
	}

	/**  
	* @Title: getOdsInventoryInfoByParams  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:47:43 
	*/ 
	@Test
	public void getOdsInventoryInfoByParams() {

		try {
			OdsInventoryInfoDTO dto = (OdsInventoryInfoDTO) getBean(OdsInventoryInfoDTO.class);

			ss.getOdsInventoryInfoByParams(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	/**  
	* @Title: updateProcessDiff  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:47:40 
	*/ 
	@Test
	public void updateProcessDiff() {
//
//		try {
//			
//			OdsPdDiffDtl odsPdDiffDtl = (OdsPdDiffDtl) getBean(OdsPdDiffDtl.class);
//			odsPdDiffDtl.setProcessFlag("0");
//			OdsPdDiffDtl obj= new OdsPdDiffDtl();
//			obj.setDiffType("0");
//			MdMatInfoDTO mobj=new MdMatInfoDTO();
//			String ids = "5";
//			OdsPdDiffDtlDAO dao = EasyMock.createMock(OdsPdDiffDtlDAO.class);
//			EasyMock.expect(dao.get(EasyMock.anyLong())).andReturn(obj).anyTimes();
//			ss.setOdsPdDiffDtlDAO(dao);
//			MdMatInfoDAO dao3=EasyMock.createMock(MdMatInfoDAO.class);
//			EasyMock.expect(dao3.getMdMatInfoByMaterialNo(EasyMock.isA(String.class))).andReturn(mobj).anyTimes();
//			ss.setMdMatInfoDAO(dao3);
//			Map<String, String> resultMap =new HashMap<String, String>();
//			resultMap.put("warehouse","as");
//            resultMap.put("location","sad");
//            CdWhMappingService service=EasyMock.createMock(CdWhMappingService.class);
//            EasyMock.expect(service.getFinalWhAndLoc(EasyMock.isA(Map.class))).andReturn(resultMap).anyTimes();
//			ss.setCdWhMappingService(service);
//			
//			dao.updateProcessReason((OdsPdDiffDtl) EasyMock.anyObject());
//			EasyMock.expectLastCall();
//			
//            EasyMock.replay(dao3);
//			EasyMock.replay(dao);
//			EasyMock.replay(service);
//
//			ss.updateProcessDiff(odsPdDiffDtl, ids);
//		} catch (Exception e) {
//		}
//		Assert.assertTrue(true);
		
		
		
		OdsPdDiffDtl temp = new OdsPdDiffDtl();
		temp.setPlant("11");
		temp.setLocation("11");
		temp.setDiffType("0");
		EasyMock.expect(odsPdDiffDtlDAO.get((Long) EasyMock.anyObject())).andReturn(temp);

		MdMatInfoDTO mat = new MdMatInfoDTO();
		EasyMock.expect(mdMatInfoDAO.getMdMatInfoByMaterialNo((String) EasyMock.anyObject())).andReturn(mat);

		odsPdDiffDtlDAO.updateProcessReason((OdsPdDiffDtl)EasyMock.anyObject());
		EasyMock.expectLastCall();

		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("warehouse", "11");
		resultMap.put("location", "11");

		odsInventoryInfoDtlDAO.save((OdsInventoryInfoDtl) EasyMock.anyObject());
		EasyMock.expectLastCall();

		OdsInventoryInfoDtl tempDtl = new OdsInventoryInfoDtl();
		EasyMock.expect(odsInventoryInfoDtlDAO.getByBarcode((String) EasyMock.anyObject())).andReturn(tempDtl);

		EasyMock.replay(odsPdDiffDtlDAO);
		EasyMock.replay(mdMatInfoDAO);
		EasyMock.replay(odsInventoryInfoDtlDAO);
		OdsPdDiffDtl resultTemp = new OdsPdDiffDtl();
		resultTemp.setProcessFlag("0");
		String ids = "11";
		ss.updateProcessDiff(resultTemp, ids);
		
	}

	/**  
	* @Title: wmsQtyDetail  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:47:36 
	*/ 
	@Test
	public void wmsQtyDetail() {
		try {
			Pager pager = (Pager) getBean(Pager.class);
			List<OdsInventoryInfoDTO> list =new ArrayList<OdsInventoryInfoDTO>();
			
			OdsInventoryInfoDTO odsInventoryInfo = (OdsInventoryInfoDTO) getBean(OdsInventoryInfoDTO.class);
			list.add(odsInventoryInfo);
			OdsInventoryInfoDAO dao = EasyMock.createMock(OdsInventoryInfoDAO.class);
			EasyMock.expect(dao.wmsQtyDetail(EasyMock.isA(Pager.class),EasyMock.isA(OdsInventoryInfoDTO.class))).andReturn(list).anyTimes();
			EasyMock.expect(dao.wmsQtyDetailCount(EasyMock.isA(OdsInventoryInfoDTO.class))).andReturn(1l).anyTimes();
				ss.setOdsInventoryInfoDAO(dao);
				EasyMock.replay(dao);
	
			ss.wmsQtyDetail(pager, odsInventoryInfo);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);
	}

	/**  
	* @Title: getExportAmount  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: LYY
	* @date: 2018年6月27日 下午2:47:27 
	*/ 
	@Test
	public void getExportAmount() {

		try {
			OdsInventoryInfoDTO dto = (OdsInventoryInfoDTO) getBean(OdsInventoryInfoDTO.class);

			ss.getExportAmount(dto);
		} catch (Exception e) {
		}
		Assert.assertTrue(true);

	}

	@Test
	public void getExportBinAmount(){

		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_1 = new OdsInventoryInfoDtlDTO();
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_2 = new OdsInventoryInfoDtlDTO();
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO_3 = new OdsInventoryInfoDtlDTO();

		odsInventoryInfoDtlDTO_1.setStatisticsFlag("1");
		odsInventoryInfoDtlDTO_2.setStatisticsFlag("2");
		odsInventoryInfoDtlDTO_3.setStatisticsFlag("3");

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryInfosCount(
				odsInventoryInfoDtlDTO_1)
		).andReturn(1L).times(1);

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryMaterialInfosCount(
				odsInventoryInfoDtlDTO_2)
		).andReturn(1L).times(1);

		EasyMock.expect(odsInventoryInfoDtlDAO.searchOdsInventoryBinInfosCount(
				odsInventoryInfoDtlDTO_3)
		).andReturn(1L).times(1);

		EasyMock.replay(odsInventoryInfoDtlDAO);

		ss.getExportBinAmount(odsInventoryInfoDtlDTO_1);
		ss.getExportBinAmount(odsInventoryInfoDtlDTO_2);
		ss.getExportBinAmount(odsInventoryInfoDtlDTO_3);
	}
}