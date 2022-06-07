package com.haier.wms.controller.inventory;

import static org.easymock.EasyMock.*;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import com.haier.openplatform.wms.inventory.service.OdsInventoryInfoDtlServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import com.haier.wms.util.SessionConstants;

/**
 * Copyright: Copyright © 2018 LiuJiazhen
 * @ClassName: SelectOdsInventoryInfoDtlControllerTest.java
 * @Description: 
 *
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2018年9月6日 上午9:19:32
 *
 * Modification History
 * Date			Author			Version			Description
 *---------------------------------------------------------*
 * 2018年9月6日		LJZ			v1.0.0			create
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {PageUtil.class,SessionConstants.class})
public class SelectOdsInventoryInfoDtlControllerTest {

	/**
	 * @title: testSearchOdsInventoryInfoDtl
	 * @description:
	 * @author: LJZ
	 * @version: v1.0.0
	 * @date: 2018年9月11日 上午10:26:06 
	 * @return: void
	 */
	@Test
	public void testSearchOdsInventoryInfoDtl() {
		PowerMockito.mockStatic(PageUtil.class,SessionConstants.class);
		PowerMockito.when(PageUtil.setPager(new Pager<Object>())).thenReturn(new PageBean());
		JSONObject res = new JSONObject();
		res.put("_user_name", "11");
		res.put("user_duty_type", "11");
		res.put("_user_id", "11");
		PowerMockito.when(SessionConstants.getSession()).thenReturn(res);
		
		OdsInventoryInfoDtlServiceClient odsInventoryInfoDtlServiceClient = createMock(OdsInventoryInfoDtlServiceClient.class);
		HttpServletRequest request = createMock(HttpServletRequest.class);
		
		SelectOdsInventoryInfoDtlController target = new SelectOdsInventoryInfoDtlController();
		target.setOdsInventoryInfoDtlClient(odsInventoryInfoDtlServiceClient);
		
		target.searchOdsInventoryInfoDtl(request, 11L, 11L, new OdsInventoryInfoDtlDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void addInventory(){
		OdsInventoryInfoDtlDTO odsInventoryInfoDtlDTO = new OdsInventoryInfoDtlDTO();
		SelectOdsInventoryInfoDtlController target = new SelectOdsInventoryInfoDtlController();
		OdsInventoryInfoDtlServiceClient odsInventoryInfoDtlServiceClient = createMock(OdsInventoryInfoDtlServiceClient.class);
		target.setOdsInventoryInfoDtlClient(odsInventoryInfoDtlServiceClient);
		EasyMock.expect(odsInventoryInfoDtlServiceClient.addInventory(
				(OdsInventoryInfoDtlDTO)EasyMock.anyObject())
		).andReturn("111");
		target.addInventory(odsInventoryInfoDtlDTO);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 * 阿达萨达
	 * 阿萨德撒大
	 * 打算的撒
	 */
	@Test
	public void deleteInventory(){
		SelectOdsInventoryInfoDtlController target = new SelectOdsInventoryInfoDtlController();
		OdsInventoryInfoDtlServiceClient odsInventoryInfoDtlServiceClient = createMock(OdsInventoryInfoDtlServiceClient.class);
		target.setOdsInventoryInfoDtlClient(odsInventoryInfoDtlServiceClient);
		EasyMock.expect(odsInventoryInfoDtlServiceClient.deleteInventory((String)EasyMock.anyObject())).andReturn("11");
		EasyMock.replay(odsInventoryInfoDtlServiceClient);
		target.deleteInventory("11111111111111111111");
	}
}
