package com.haier.hevwms.security.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haier.openplatform.hfs.client.dto.FileRequest;
import com.haier.openplatform.hfs.client.dto.FileResult;
import com.haier.openplatform.hfs.client.service.FileServiceClient;
import com.haier.hevwms.security.service.FileServiceClientAdapter;

public class FileServiceClientAdapterImpl implements FileServiceClientAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(FileServiceClientAdapterImpl.class);
    private FileServiceClient fileServiceClient;
    private String appName;
    private String storeSystemAddress;
    private String appid;
    private String testid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getTestid() {
        return testid;
    }

    public void setTestid(String testid) {
        this.testid = testid;
    }

    @Override
    public FileResult saveFile(File file, String fileName) {
        FileResult result = null;
        FileInputStream input = null;
        try {
            FileRequest request = generalCommonRequest(appName, storeSystemAddress);
            byte[] bytes = new byte[(int) file.length()];
            input = new FileInputStream(file);
            input.read(bytes, 0, bytes.length);
            request.setBytes(bytes);
            request.setFileName(fileName);
            result = fileServiceClient.saveFile(request);
        } catch (Exception e) {
            LOG.error("saveFile error,fileName=" + fileName, e);
            result = new FileResult();
            result.setSuccess(false);
            result.setMsg(e.toString());
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                LOG.error("input.close():" + e.getMessage());
            }
        }
        return result;
    }

    @Override
    public FileResult findFile(String uuid) {
        FileResult result = null;
        try {
            FileRequest request = generalCommonRequest(appName, storeSystemAddress);
            request.setFileId(uuid);
            result = fileServiceClient.findFileByUUID(request);
        } catch (Exception e) {
            LOG.error("findFile error,uuid=" + uuid, e);
            result = new FileResult();
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public FileResult deleteFile(String uuid) {
        FileResult result = null;
        try {
            FileRequest request = generalCommonRequest(appName, storeSystemAddress);
            request.setFileId(uuid);
            result = fileServiceClient.deleteFileByUID(request);
        } catch (Exception e) {
            LOG.error("deleteFile error,uuid=" + uuid, e);
            result = new FileResult();
            result.setSuccess(false);
        }
        return result;
    }

    public FileRequest generalCommonRequest(String appName, String storeSystemAddress) {
        FileRequest request = new FileRequest();
        request.setAppName(appName);
        request.setStoreSystemAddress(storeSystemAddress);
        return request;
    }

    public FileRequest generalCommonRequestTest(String appName, String storeSystemAddress) {
        FileRequest request = new FileRequest();
        request.setAppName(appName);
        request.setStoreSystemAddress(storeSystemAddress);
        request.setFileId(appName);
        request.setFlag1(appName);
        request.setFlag2(appName);
        if (request.getFlag1().equals(request.getFlag2())) {
            request.getAppName();
            request.getStoreSystemAddress();
            request.getFileId();
            request.getFlag1();
            request.getFlag2();
        }
        return request;
    }

    public FileRequest general(String appName, String storeSystemAddress, String flag) {
        FileRequest request = new FileRequest();
        request.setAppName(appName);
        request.setStoreSystemAddress(storeSystemAddress);
        request.setFileId(appName);
        request.setFlag1(appName);
        request.setFlag2(appName);
        if (request.getFlag1().equals(request.getFlag2())) {
            request.getAppName();
            request.getStoreSystemAddress();
            request.getFileId();
            request.getFlag1();
            request.getFlag2();
        }
        return request;
    }

    public void setFileServiceClient(FileServiceClient fileServiceClient) {
        this.fileServiceClient = fileServiceClient;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setStoreSystemAddress(String storeSystemAddress) {
        this.storeSystemAddress = storeSystemAddress;
    }
}
