package com.haier.openplatform.wms.order.impl;

import com.haier.hevwms.so.service.StgDnDownService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import com.haier.openplatform.wms.so.impl.StgDnDownServiceClientImpl;
import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.InvocationTargetException;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * dn实现测试类
 * @项目名称otcwms-service-impl
 * @类名称StgDnDownServiceClientImplTest
 * @类描述
 * @返回值类型TODO
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserUtil.class)
public class StgDnDownServiceClientImplTest {
	private StgDnDownServiceClientImpl clientImplMock = new StgDnDownServiceClientImpl();
	private StgDnDownService stgDnDownServiceMock;

	@Before
	public void init() {
		stgDnDownServiceMock = EasyMock.createMock(StgDnDownService.class);
		clientImplMock.setStgDnDownService(stgDnDownServiceMock);
	}

	/**
	* @Title: testGetStgDnDownService
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 上午9:52:55
	 */
	@Test
	public void testGetStgDnDownService() {
		clientImplMock.getStgDnDownService();
	}

	/**
	* @Title: testSearchStgDnDown
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 上午9:53:00
	 */
	@Test
	public void testSearchStgDnDown() {
		clientImplMock.searchStgDnDown(new Pager<StgDnDownDTO>(), new StgDnDownDTO());
	}

	/**
	* @Title: testDownStgDnDown
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 上午9:53:07
	 */
	@Test
	public void testDownStgDnDown() {
		mockStatic(UserUtil.class);
		BaseUser name = new BaseUser();
		name.setName("test");
		when(UserUtil.getCurrentUser()).thenReturn(name);

		try {

//			clientImplMock.downStgDnDown("dn", "09877325", "2018-04-23", "2018-01-23", "32543254", "0010");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title: testDownStgDnDown1
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午2:28:29
	 */
	@Test
	public void testDownStgDnDown1() {
		mockStatic(UserUtil.class);
		BaseUser name = new BaseUser();
		name.setName("test");
		when(UserUtil.getCurrentUser()).thenReturn(name);

		try {

//			clientImplMock.downStgDnDown("po", "09877325", "2018-04-23", "2018-01-23", "32543254", "0010");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title: testDownStgDnDown2
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午2:28:55
	 */
	@Test
	public void testDownStgDnDown2() {
		mockStatic(UserUtil.class);
		BaseUser name = new BaseUser();
		name.setName("test");
		when(UserUtil.getCurrentUser()).thenReturn(name);

		try {

//			clientImplMock.downStgDnDown("sto", "09877325", "2018-04-23", "2018-01-23", "32543254", "0010");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title: testDownStgDnDown3
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午2:29:37
	 */
	@Test
	public void testDownStgDnDown3() {
		mockStatic(UserUtil.class);
		BaseUser name = new BaseUser();
		name.setName("test");
		when(UserUtil.getCurrentUser()).thenReturn(name);

		try {

//			clientImplMock.downStgDnDown("inb", "", "2018-04-23", "2018-01-23", "32543254", "0010");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	* @Title: testGetStgDnDownsByParam
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 上午9:53:36
	 */
	@Test
	public void testGetStgDnDownsByParam() {
		clientImplMock.getStgDnDownsByParam(new StgDnDownDTO());
	}

	/**
	* @Title: testPostDn
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午2:06:52
	 */
	@Test
	public void testPostDn() {

	}

	/**
	* @Title: testGetExportAmount
	* @Description:
	* @return void
	* @throws
	* @version: v1.0.0
	* @author: Administrator
	* @date: 2018-5-4 下午2:06:59
	 */
	@Test
	public void testGetExportAmount() {
		clientImplMock.getExportAmount(new StgDnDownDTO());
	}@Test

	public void directDispatch() throws InvocationTargetException, IllegalAccessException {
		clientImplMock.directDispatch("13", "asdfas", "asdfas");
	}

}
