package com.haier.openplatform.showcase.impl.security.service.impl;

import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.hevwms.basic.service.MdBarcodeService;
import com.haier.openplatform.showcase.security.dto.UserDTO;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/7 17:25
 * @Description:
 */
public class UserServiceClientImplTest {

    private UserServiceClientImpl userServiceClient = new UserServiceClientImpl();
    private MdBarcodeService mdBarcodeService;

    @Before
    public void init(){
        mdBarcodeService = EasyMock.createMock(MdBarcodeService.class);
        userServiceClient.setMdBarcodeService(mdBarcodeService);
    }

    @Test
    public void getUserById() {
        userServiceClient.getUserById(11L);
    }

    @Test
    public void getUserByIdAndName() {
        userServiceClient.getUserByIdAndName(11L,"11");
    }

    @Test
    public void getUserByIdPost() {
        userServiceClient.getUserByIdPost(new UserDTO());
    }

    @Test
    public void getUserByPostForm() {
        userServiceClient.getUserByPostForm(new UserDTO());
    }

    @Test
    public void getUserByPostForm1() {
        userServiceClient.getUserByPostForm(1L,"11");
    }

    @Test
    public void confirmUser() {
        userServiceClient.confirmUser(11L,"11");
    }

    @Test
    public void searchBarcodes() {
        EasyMock.expect(mdBarcodeService.searchById(
                (String)EasyMock.anyObject())
        ).andReturn(new ArrayList<MdBarcode>());
        EasyMock.replay(mdBarcodeService);
        userServiceClient.searchBarcodes("11","11","11");
    }
}