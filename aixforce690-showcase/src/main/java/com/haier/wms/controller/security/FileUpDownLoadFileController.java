package com.haier.wms.controller.security;

import io.terminus.common.utils.JsonMapper;
import io.terminus.pampas.common.UserUtil;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.haier.openplatform.showcase.utils.Env;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.service.FileUploadServiceClient;

/**  
 * @ClassName: FileUpDownLoadFileController  
 * @Description: (这里用一句话描述这个类的作用)  
 * @author SJK  
 * @date 2015-4-20  
 */ 
@Controller
public class FileUpDownLoadFileController {
//    int ch = 0;
	Logger logger = Logger.getLogger(FileUpDownLoadFileController.class);
    private static final int BUFFERED_SIZE = 4 * 1024;
    Logger log = Logger.getLogger(this.getClass());

    /**  
     * @Fields field:field:{}(dubbo接口)  
     */  
    @Resource
    FileUploadServiceClient fileUploadServiceClient;

    /**  
     * @Title: download  
     * @Description: (下载)  
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/security/download",
            produces = MediaType.TEXT_HTML_VALUE)
    public String download(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {
        Long id=Long.valueOf(request.getParameter("id"));
        UploadFile path = fileUploadServiceClient.getFileInputStreams(id);
        if(path!=null){
            String name=path.getFileName();
            String mimetype = "application/x-msdownload";
            response.setContentType(mimetype);
            String inlineType = "attachment"; 
            response.setHeader("Content-Disposition", inlineType + ";fileName=\""
                    + name + "\"");
            InputStream is = new FileInputStream(new File(path.getFilePath1()+ File.separator + name));
            ServletOutputStream os = response.getOutputStream();
            try {
                IOUtils.copy(is, os);
            } catch (Exception e) {
               
            } finally {
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(os);
            }
        }else{
            response.getWriter().write("The File is Not Found!");
        }
       
        return null;

    }
    
    /**  
     * @Title: searchFileUploadBySwf  
     * @Description: (查询)  
     * @return
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/security/searchFileUploadBySwf",
    method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody 
	public String searchFileUploadBySwf() {
    	UploadFile file = new UploadFile();
    	file.setStatus(Integer.parseInt("1"));
    	file.setType(Integer.parseInt("1"));
    	List<UploadFile> list = fileUploadServiceClient.searchFileUploadBySwf(file);
    	return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
	}
    
    /**  
     * @Title: fileUploadBySwf  
     * @Description: (上传)  
     * @param fileInput
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @return String 
     * @throws  
     */  
    @RequestMapping(value = "/security/fileUploadBySwf",
            method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody 
    public String fileUploadBySwf(MultipartFile fileInput,HttpServletRequest request, HttpServletResponse response) throws IOException{
          ExecuteResult<UploadFile> result = new ExecuteResult<UploadFile>();
          //文件操作
          String savePath=Env.getProperty(Env.FILESUPLOAD_NAME);
          String fileName=fileInput.getOriginalFilename();
          File file = new File(savePath);
          //判断上传文件的保存目录是否存在
          if (!file.exists()) {
              //创建目录
              if(!file.mkdirs()){
                  result.addErrorMessage("file.dir.create.fail.");
                  return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
              }
          }
          //如果文件已存在，则进行删除
          File outFile=new File(savePath + "/" + fileName);
          if(outFile.exists()){
              boolean b = outFile.delete();
              logger.info(b);
          }
          InputStream in = null;
          OutputStream out = null;
          FileOutputStream fileOut = null;
          try {
              in = fileInput.getInputStream();
              fileOut = new FileOutputStream(outFile);
              out = new BufferedOutputStream(fileOut, BUFFERED_SIZE);
              byte[] bs = new byte[BUFFERED_SIZE];
              int i;
              while ((i = in.read(bs)) > 0) {
                      out.write(bs, 0, i);
              }
          } catch (FileNotFoundException e) {
              log.error("file not found.",e);
              result.addErrorMessage("file not found.");
              return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
          } catch (IOException e) {
              log.error("io exception.",e);
              result.addErrorMessage("io exception.");
              return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
          } finally {
              try {
                  if (in != null){
                      in.close();
                  }
                  if (out != null){
                      out.close();
                  }
                  if (fileOut != null){
                	  fileOut.close();
                  }
              } catch (IOException e) {
                  log.error("close file error.",e);
                  result.addErrorMessage("close file error.");
//                  return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
              }
          }
          
          //数据库操作
          UploadFile uploadFile=new UploadFile();
          uploadFile.setFileName(fileName);
          uploadFile.setSaveFileName(fileName);
          uploadFile.setFilePath1(savePath);
          uploadFile.setStatus(1);
          uploadFile.setLastModifiedBy(UserUtil.getCurrentUser().getName());
          uploadFile.setLastModifiedDt(new Date());
          uploadFile.setCreateBy(UserUtil.getCurrentUser().getName());
          uploadFile.setCreateDt(new Date());
          uploadFile.setType(1);
          fileUploadServiceClient.deleteFileByName(uploadFile);
          if(!fileUploadServiceClient.fileUploadBySwf(uploadFile)){
              result.addErrorMessage("file.save.error.");
              return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
          }
          result.setResult(uploadFile);
          return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(result);
    }
    
    /**  
     * @Title: getFileUploadServiceClient  
     * @Description: (get)  
     * @return
     * @return FileUploadServiceClient 
     * @throws  
     */  
    public FileUploadServiceClient getFileUploadServiceClient() {
        return fileUploadServiceClient;
    }

    /**  
     * @Title: setFileUploadServiceClient  
     * @Description: (set)  
     * @param fileUploadServiceClient
     * @return void 
     * @throws  
     */  
    public void setFileUploadServiceClient(
            FileUploadServiceClient fileUploadServiceClient) {
        this.fileUploadServiceClient = fileUploadServiceClient;
    }

}
