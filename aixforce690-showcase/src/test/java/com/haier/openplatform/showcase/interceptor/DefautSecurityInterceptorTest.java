package com.haier.openplatform.showcase.interceptor;

import com.haier.openplatform.hac.dto.HacResourceDTO;
import com.haier.openplatform.security.Authentication;
import com.haier.openplatform.showcase.service.ResourceServiceClientAdapter;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/17 17:44
 * @Description:
 */
public class DefautSecurityInterceptorTest {

    private ResourceServiceClientAdapter resourceServiceClientAdapter;
    private HttpServletRequest request;
    private DefautSecurityInterceptor defautSecurityInterceptor = new DefautSecurityInterceptor();
    @Before
    public void init(){
        request = EasyMock.createMock(HttpServletRequest.class);
        resourceServiceClientAdapter = EasyMock.createMock(ResourceServiceClientAdapter.class);
        defautSecurityInterceptor.setResourceServiceClientAdapter(resourceServiceClientAdapter);
    }

    @Test
    public void getAuthentication() {
        List<HacResourceDTO> list = new ArrayList<HacResourceDTO>();
        HacResourceDTO hacResourceDTO=new HacResourceDTO();
        hacResourceDTO.setAppCode("11");
        list.add(hacResourceDTO);
        EasyMock.expect(resourceServiceClientAdapter.getResource(
                "11","zh_CN")
        ).andReturn(list);
        EasyMock.replay(resourceServiceClientAdapter);
        defautSecurityInterceptor.getAuthentication("11",request);
    }

    @Test
    public void getAuthenticator() {
        defautSecurityInterceptor.getAuthenticator(new Authentication());
    }
}