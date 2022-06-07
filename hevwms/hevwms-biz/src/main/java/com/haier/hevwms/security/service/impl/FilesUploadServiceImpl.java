package com.haier.hevwms.security.service.impl;

import io.terminus.pampas.common.UserUtil;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.hevwms.security.service.FileServiceClientAdapter;
import com.haier.hevwms.security.service.FilesUploadService;
import com.haier.hevwms.util.FileConstants;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.domain.UploadFile;

/**
 * @ClassName: FilesUploadServiceImpl
 * @Description: 上传下载
 */
public class FilesUploadServiceImpl implements FilesUploadService {
    private FileUploadDAO fileUploadDAO;
    private FileConstants fileConstants;
    private FileServiceClientAdapter fileServiceClientAdapter;

    /**
     * 根据id查询要下载的文件信息
     *
     * @param id
     * @return
     * @see com.haier.hevwms.security.service.FilesUploadService#getFileInputStream(java.lang.Long)
     */
    @Override
    public UploadFile getFileInputStream(Long id) {
        UploadFile uploadFile = fileUploadDAO.get(id);
        if (uploadFile == null) {
            return null;
        } else {
            return uploadFile;
        }
    }

    /**
     * 根据id查询要下载的文件信息
     *
     * @param id
     * @return
     * @see com.haier.hevwms.security.service.FilesUploadService#getFileInputStream(java.lang.Long)
     */
    @Override
    public UploadFile getLatestApp(String name, String version) {
        UploadFile uploadFile = fileUploadDAO.getAppVersion(name, version);
        if (uploadFile == null) {
            return null;
        } else {
            return uploadFile;
        }
    }
    
    public FileUploadDAO getFileUploadDAO() {
        return fileUploadDAO;
    }

    public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
        this.fileUploadDAO = fileUploadDAO;
    }

    /**
     * ZhangYing@jbinfo.cn 2015-12-8
     */
    @Override
    public List<UploadFile> getFileByStatusAndType(UploadFile file) {
        return fileUploadDAO.getFileByStatusAndType(file);
    }

    @Override
    public ExecuteResult<String> deleteFileByIds(String ids) {
        ExecuteResult<String> result = new ExecuteResult<String>();
        if (StringUtils.isBlank(ids)) {
            result.addErrorMessage("file.not.select");
            return result;
        }
        String[] nameAndIds = ids.split(",");
        for (String nameAndId : nameAndIds) {
            String[] tmp = nameAndId.split(":");
            if (tmp == null || tmp.length != 2) {
                continue;
            }
            String msg = deleteFileById(Long.parseLong(tmp[0]));
            if (StringUtils.isNotBlank(msg)) {
                result.addErrorMessage(tmp[1] + ":" + msg);
            }
        }
        return result;
    }

    @Override
    public String deleteFileById(Long id) {
        try {
            UploadFile uf = fileUploadDAO.get(id);
            if (uf == null) {
                return "file.not.exist";
            }
            File file = new File(uf.getFilePath1() + File.separator + uf.getFileName());
            if (!file.exists()) {
                return "file.not.exist";
            }
            if (!file.delete()) {
                return "file.delete.error";
            }
            uf.setStatus(2);
            uf.setLastModifiedBy(UserUtil.getCurrentUser().getName());
            uf.setLastModifiedDt(new Date());
            fileUploadDAO.update(uf);
        } catch (Exception e) {
            return "file.delete.error";
        }
        return null;
    }

    @Override
    public List<UploadFile> getfileNameShow(Integer status) {
        return fileUploadDAO.getfileNameShow(status);
    }

    public FileConstants getFileConstants() {
        return fileConstants;
    }

    public void setFileConstants(FileConstants fileConstants) {
        this.fileConstants = fileConstants;
    }

    public FileServiceClientAdapter getFileServiceClientAdapter() {
        return fileServiceClientAdapter;
    }

    public void setFileServiceClientAdapter(FileServiceClientAdapter fileServiceClientAdapter) {
        this.fileServiceClientAdapter = fileServiceClientAdapter;
    }

    @Override
    public boolean fileUploadBySwf(UploadFile uploadFile) {
        try {
            fileUploadDAO.save(uploadFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteFileByName(UploadFile uploadFile) {
        try {
            fileUploadDAO.deleteFileByName(uploadFile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
