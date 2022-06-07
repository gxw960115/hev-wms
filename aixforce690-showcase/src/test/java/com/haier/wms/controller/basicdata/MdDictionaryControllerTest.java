package com.haier.wms.controller.basicdata;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.dictionary.dto.MdDictionaryDTO;
import com.haier.openplatform.wms.dictionary.service.MdDictionaryServiceClient;
import com.haier.wms.util.SessionConstants;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * @Auther: mahuansen
 * @Date: 2019/4/29 14:35
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SessionConstants.class,SessionSecurityConstants.class})
public class MdDictionaryControllerTest {

    private HttpSession session;
    private ServletContext servletContext;
    private HttpServletRequest request;
    private HttpServletResponse response ;
    private MdDictionaryServiceClient mdDictionaryServiceClient;
    private MdDictionaryController controller = new MdDictionaryController();

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Before
    public void init(){
        session = createMock(HttpSession.class);
        servletContext = createMock(ServletContext.class);
        request = createMock(HttpServletRequest.class);
        response = createMock(HttpServletResponse.class);
        mdDictionaryServiceClient = createMock(MdDictionaryServiceClient.class);
        controller.setMdDictionaryServiceClient(mdDictionaryServiceClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void findDivisions() {
        expect(mdDictionaryServiceClient.findDivisions()
        ).andReturn(new ArrayList<MdDictionaryDTO>()).times(1);
        replay(mdDictionaryServiceClient);
        controller.findDivisions();
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchAllDictionary() {
        expect(mdDictionaryServiceClient.searchAllDictionInfo(
                (String)anyObject())
        ).andReturn(new ArrayList<MdDictionaryDTO>()).times(1);
        replay(mdDictionaryServiceClient);
        controller.searchAllDictionary(request,"");
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void searchAllDictionInfo() {
        Pager<MdDictionaryDTO> pager = new Pager<MdDictionaryDTO>();
        pager.setPageSize(10L);
        pager.setCurrentPage(1L);
        expect(mdDictionaryServiceClient.getAllMdDictionarys((Long)anyObject(),(Long)anyObject(),(MdDictionaryDTO)anyObject())).andReturn(pager);
        replay(mdDictionaryServiceClient);
        String result = controller.searchAllDictionInfo(request,1L, 10L, new MdDictionaryDTO());
        assertNotNull(result);
        verify(mdDictionaryServiceClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void findAllKindType() {
        expect(mdDictionaryServiceClient.findAllKindType()).andReturn(new ArrayList<MdDictionaryDTO>());
        replay(mdDictionaryServiceClient);
        String result = controller.findAllKindType();
        assertNotNull(result);
        verify(mdDictionaryServiceClient);
    }

    /**
     * <p>Title: searchCdLocInfoByCondition</p>
     * <p>Description:查询库存地点 </p>
     * 阿达萨达
     * 阿萨德撒大
     * 打算的撒
     */
    @Test
    public void deleteDictionaryInfo() {
        expect(mdDictionaryServiceClient.deleteDictionarys((List<Long>)anyObject())).andReturn("1");
        replay(mdDictionaryServiceClient);
        String result = controller.deleteDictionaryInfo("222,222");
        assertNotNull(result);
        verify(mdDictionaryServiceClient);
    }
}