package com.haier.openplatform.showcase.utils;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/17 17:33
 * @Description:
 */
public class CasUtilTest {

    private HttpServletRequest request;
    private StringBuffer stringBuffer;

    @Before
    public void init(){
        request = EasyMock.createMock(HttpServletRequest.class);
        stringBuffer = new StringBuffer();
    }

    @Test
    public void getServerName() {
        stringBuffer.append("test1212121");
        String g = "1212";
        EasyMock.expect(request.getRequestURL()).andReturn(stringBuffer).times(3);
        EasyMock.expect(request.getRequestURI()).andReturn(g);
        EasyMock.expect(stringBuffer.delete(stringBuffer.length()-stringBuffer.length(),g.length()));
        EasyMock.replay(request);
        CasUtil.getServerName(request);
    }

    @Test
    public void getDomainName() {
        CasUtil.getDomainName("test");
    }
}