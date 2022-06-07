package com.haier.openplatform.wms.basicdata.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.hevwms.basic.service.MdBarcodeService;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdBarcodeDTO;

/**
 * <p>Title: searchCdLocInfoByCondition</p>
 * <p>Description:查询库存地点 </p>
 * @param rows
 * @param page
 * @param cdLocInfo
 */
public class MdBarcodeServiceClientImplTest {
	private MdBarcodeServiceClientImpl clientImplMock = new MdBarcodeServiceClientImpl();
	private MdBarcodeService mdBarcodeServiceMock;
	
	@Before
	public void init() {
		mdBarcodeServiceMock = EasyMock.createMock(MdBarcodeService.class);
		clientImplMock.setMdBarcodeService(mdBarcodeServiceMock);
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchBarcodes() {
		EasyMock.expect(mdBarcodeServiceMock.searchMdBarcodes((Pager<MdBarcode>)EasyMock.anyObject()
				,(MdBarcode)EasyMock.anyObject())).andReturn(new Pager<MdBarcode>()).times(1);
		EasyMock.replay(mdBarcodeServiceMock);
		
		clientImplMock.searchBarcodes(new Pager<MdBarcodeDTO>(), new MdBarcodeDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testCreateBarcodes() throws IllegalAccessException, InvocationTargetException {
		EasyMock.expect(mdBarcodeServiceMock.addNewBarcodes((MdBarcode)EasyMock.anyObject())).andReturn("1").times(1);
		EasyMock.replay(mdBarcodeServiceMock);
		
		clientImplMock.createBarcodes(new MdBarcodeDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testCreate1DBarcode() {
		EasyMock.expect(mdBarcodeServiceMock.createTempDir((String)EasyMock.anyObject())).andReturn("1").times(1);
		EasyMock.expect(mdBarcodeServiceMock.createMdBarcode1D((String)EasyMock.anyObject()
				,(String)EasyMock.anyObject())).andReturn("1").times(1);
		EasyMock.replay(mdBarcodeServiceMock);
		
		clientImplMock.create1DBarcode("BBS89Y98000000000001");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testSearchMdBarcode() {
		Pager<MdBarcode> pagerTemp = new Pager<MdBarcode>();
		List<MdBarcode> list = new ArrayList<MdBarcode>();
		list.add(new MdBarcode());
		pagerTemp.setRecords(list);
		
		EasyMock.expect(mdBarcodeServiceMock.searchMdBarcodes((Pager<MdBarcode>)EasyMock.anyObject()
				,(MdBarcode)EasyMock.anyObject())).andReturn(pagerTemp).times(1);
		EasyMock.replay(mdBarcodeServiceMock);
		clientImplMock.searchMdBarcode(1L, 10L, new MdBarcodeDTO());
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testExistBarcode() {
		clientImplMock.existBarcode("");
	}

	/**
	 * <p>Title: searchCdLocInfoByCondition</p>
	 * <p>Description:查询库存地点 </p>
	 */
	@Test
	public void testInsert() {
		clientImplMock.insert("","");
		
	}

}
