package com.haier.openplatform.showcase.service.impl;

import com.haier.openplatform.hfs.client.dto.FileRequest;
import com.haier.openplatform.hfs.client.dto.FileResult;
import com.haier.openplatform.hfs.client.service.FileServiceClient;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/17 18:11
 * @Description:
 */
public class FileServiceClientAdapterImplTest {

    private FileServiceClient fileServiceClient;
    private FileServiceClientAdapterImpl fileServiceClientAdapter = new FileServiceClientAdapterImpl();

    @Before
    public void init(){
        fileServiceClient = EasyMock.createMock(FileServiceClient.class);
        fileServiceClientAdapter.setFileServiceClient(fileServiceClient);
    }

    @Test
    public void saveFile() {
        EasyMock.expect(fileServiceClient.saveFile(
                (FileRequest)EasyMock.anyObject())
        ).andReturn(new FileResult());
        EasyMock.replay(fileServiceClient);
        fileServiceClientAdapter.saveFile("",new byte[11],"11");
    }

    @Test
    public void saveFileToFtp() {

    }

    @Test
    public void findFile() {
        EasyMock.expect(fileServiceClient.findFileByUUID(
                (FileRequest)EasyMock.anyObject())
        ).andReturn(new FileResult());
        EasyMock.replay(fileServiceClient);
        fileServiceClientAdapter.findFile("","11");
    }

    @Test
    public void findFileFromFtp() {
        fileServiceClientAdapter.findFileFromFtp("1","11","11","11","11");
    }

    @Test
    public void deleteFile() {
        EasyMock.expect(fileServiceClient.deleteFileByUID(
                (FileRequest)EasyMock.anyObject())
        ).andReturn(new FileResult());
        EasyMock.replay(fileServiceClient);
        fileServiceClientAdapter.deleteFile("11","11");
    }

    @Test
    public void deleteFileFromFtp() {
        fileServiceClientAdapter.deleteFileFromFtp("11","11","11","11","11");
    }
}