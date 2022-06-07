package com.haier.wms.controller.basicdata;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdBarcodeDTO;
import com.haier.openplatform.wms.basicdata.service.MdBarcodeServiceClient;
import com.haier.openplatform.wms.report.service.PsiReportServiceClient;
import com.haier.wms.util.SessionConstants;

/**   
* Copyright: Copyright (c) 2018 SJK
* 
* @ClassName: MdBarcodeControllerTest.java
* @Description: 
*
* @version: v1.0.0
* @author: SJK
* @date: 2018年9月4日 上午10:22:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年9月4日     SJK           v1.0.0               修改原因
*/
@RunWith(PowerMockRunner.class)
@PrepareForTest({SessionConstants.class,SessionSecurityConstants.class}) 
public class MdBarcodeControllerTest {
	
	private MdBarcodeServiceClient mdBarcodeServiceClient;
    private PsiReportServiceClient psiReportServiceClient;
    private HttpSession session;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response ;
	private MdBarcodeController controller = new MdBarcodeController();
	
	/**  
	* @Title: init  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年9月4日 上午10:22:12 
	*/ 
	@Before
	public void init(){
		session = createMock(HttpSession.class);
		servletContext = createMock(ServletContext.class);
		mdBarcodeServiceClient =createMock(MdBarcodeServiceClient.class);
		psiReportServiceClient = createMock(PsiReportServiceClient.class);
		controller.setMdBarcodeServiceClient(mdBarcodeServiceClient);
		controller.setPsiReportServiceClient(psiReportServiceClient);
		request = createMock(HttpServletRequest.class);
		response = createMock(HttpServletResponse.class);
	}
	
	/**  
	* @Title: test2  
	* @Description: 
	* @throws IllegalAccessException
	* @throws InvocationTargetException 
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年9月4日 上午10:21:44 
	*/ 
	@Test
	public void addBarcodes() throws IllegalAccessException, InvocationTargetException{
		JSONObject res=new JSONObject();
        res.put(SessionSecurityConstants.KEY_USER_NAME, "TEST");
        
        mockStatic(SessionConstants.class); 
		when(SessionConstants.getSession()).thenReturn(res);
        
		expect(mdBarcodeServiceClient.createBarcodes((MdBarcodeDTO) anyObject())).andReturn("TEST");
		
		replay(mdBarcodeServiceClient);
		String result = "";
		try {
			result = controller.addBarcodes("TEST", "TESTTEST", "5", "TEST");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(result);
		verify(mdBarcodeServiceClient);
	}
	
	/**  
	* @Title: test3  
	* @Description:  
	* @return void
	* @throws  
	* @version: v1.0.0
	* @author: SJK
	* @date: 2018年9月4日 上午10:21:41 
	*/ 
	@Test
	public void searchMdBarcode(){
		Pager<MdBarcodeDTO> pager = new Pager<MdBarcodeDTO>();
        pager.setPageSize(10L);
        pager.setCurrentPage(1L);
		expect(mdBarcodeServiceClient.searchMdBarcode(
				anyLong(), anyLong(), (MdBarcodeDTO)anyObject())).andReturn(pager);
		replay(mdBarcodeServiceClient);
		String result = controller.searchMdBarcode(1L, 10L, new MdBarcodeDTO());
		assertNotNull(result);
		verify(mdBarcodeServiceClient);
	}
	
	@Test
	public void printOriginalBarcode(){
		JSONObject res=new JSONObject();
		res.put(SessionSecurityConstants.KEY_USER_NAME, "TEST");
		mockStatic(SessionConstants.class);
		when(SessionConstants.getSession()).thenReturn(res);
		expect(mdBarcodeServiceClient.existBarcode((String) anyObject())).andReturn(true);
		
		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		mdBarcodeServiceClient.insert((String)EasyMock.anyObject(),(String)EasyMock.anyObject());
		expectLastCall().times(1);
		replay(mdBarcodeServiceClient);
		replay(request);
		replay(session);
		replay(servletContext);
		
		String result = controller.printOriginalBarcode(request, response, "11");
		assertNull(result);
	}

	@Test
	public void searchBarCodes() {
		Pager<MdBarcodeDTO> pager = new Pager<MdBarcodeDTO>();
		pager.setPageSize(10L);
		pager.setCurrentPage(1L);
		expect(mdBarcodeServiceClient.searchBarcodes((Pager<MdBarcodeDTO>)anyObject(),(MdBarcodeDTO)anyObject())).andReturn(pager);
		replay(mdBarcodeServiceClient);
		String result = controller.searchBarCodes(1L, 10L, new MdBarcodeDTO());
		assertNotNull(result);
		verify(mdBarcodeServiceClient);
	}

	@Test
	public void searchGiftBarcodes() {
		Pager<GiftBarcodeDTO> pager = new Pager<GiftBarcodeDTO>();
		pager.setPageSize(10L);
		pager.setCurrentPage(1L);
		expect(mdBarcodeServiceClient.searchGiftBarcodes((Pager<GiftBarcodeDTO>)anyObject(),(GiftBarcodeDTO)anyObject())).andReturn(pager);
		replay(mdBarcodeServiceClient);
		String result = controller.searchGiftBarcodes(1L, 10L, new GiftBarcodeDTO());
		assertNotNull(result);
		verify(mdBarcodeServiceClient);
	}

	@Test
	public void modifyBarcodeBin() {
		EasyMock.expect(mdBarcodeServiceClient.modifyBarcodeBin(
				(OrderUploadInDTO)EasyMock.anyObject())
		).andReturn(new OrderUploadOutDTO()).times(1);
		EasyMock.replay(mdBarcodeServiceClient);
		controller.modifyBarcodeBin("111","111111","111","111");
	}

	@Test
	public void initUserPlantAndLoc() {
		EasyMock.expect(mdBarcodeServiceClient.initUserPlantAndLoc(
				(OrderUploadInDTO)EasyMock.anyObject())
		).andReturn(new OrderUploadOutDTO()).times(1);
		EasyMock.replay(mdBarcodeServiceClient);
		controller.initUserPlantAndLoc("1111","1111111");
	}

	@Test
	public void addGiftBarcode() throws Exception{
		JSONObject res=new JSONObject();
		res.put(SessionSecurityConstants.KEY_USER_NAME, "TEST");
		mockStatic(SessionConstants.class);
		when(SessionConstants.getSession()).thenReturn(res);
		EasyMock.expect(mdBarcodeServiceClient.createGiftBarcode(
				(GiftBarcodeDTO)EasyMock.anyObject())
		).andReturn("QQQ").times(1);
		controller.addGiftBarcode("111","111");
	}

	@Test
	public void printBarcode() {

		expect(request.getSession()).andReturn(session);
		expect(session.getServletContext()).andReturn(servletContext);
		expect(servletContext.getRealPath((String) anyObject())).andReturn("/test");
		expect(psiReportServiceClient.generatePsiReport(
				(String)anyObject(),
				(Map<String,Object>)anyObject())
		).andReturn(new byte[2048]);
		replay(psiReportServiceClient);
		replay(request);
		replay(session);
		replay(servletContext);

		String result = controller.printBarcode(request, response, "11","1");
		assertNull(result);
	}
}
