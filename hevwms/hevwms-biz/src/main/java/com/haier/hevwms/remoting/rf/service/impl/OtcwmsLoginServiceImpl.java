package com.haier.hevwms.remoting.rf.service.impl;

import java.util.Date;
import java.util.List;

import com.haier.hevwms.remoting.rf.dao.WmsLoginDAO;
import com.haier.hevwms.remoting.rf.domain.login.Location;
import com.haier.hevwms.remoting.rf.domain.login.LoginPara;
import com.haier.hevwms.remoting.rf.domain.login.LoginResult;
import com.haier.hevwms.remoting.rf.domain.login.Menu;
import com.haier.hevwms.remoting.rf.service.OtcwmsLoginService;
import com.haier.hevwms.security.dao.FileUploadDAO;
import com.haier.openplatform.showcase.util.CommonTool;
import com.haier.openplatform.util.PasswordUtil;
import com.haier.openplatform.wms.security.domain.UploadFile;
import com.haier.openplatform.wms.security.dto.UserDTO;

/** 
* @ClassName: OtcwmsLoginServiceImpl 
* @Description: (手持登录) 
* @author Song Yinglong // Nicholas
* @date 2015-11-6 上午11:25:22 
* @param 
*/ 
public class OtcwmsLoginServiceImpl implements OtcwmsLoginService {
	private WmsLoginDAO loginDAO;
	private FileUploadDAO fileUploadDAO;
	public void setLoginDAO(WmsLoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	public void setFileUploadDAO(FileUploadDAO fileUploadDAO) {
        this.fileUploadDAO = fileUploadDAO;
    }

    @Override
	public LoginResult userLogin(LoginPara loginPara,String version) {
		LoginResult loginResult = new LoginResult();
		UserDTO user;
		List<Location> location = null;
		List<Menu> menu = null;

		String pass;
		String name;
		String ip;
		String sign;

		//必输项判断
		if (CommonTool.isNull(loginPara.getUser())) {
			loginResult.setStatus("F");
			loginResult.setMsg("user is not null！");
			return loginResult;
		}
		if (CommonTool.isNull(loginPara.getPass())) {
			loginResult.setStatus("F");
			loginResult.setMsg("password is not null！");
			return loginResult;
		}
		//判断是否是最新版本
		UploadFile pdafile= fileUploadDAO.getPdaFileInfo();
		if(!pdafile.getVersions().equals(version)){
//		     loginResult.setStatus("FF");//失败
//	         loginResult.setMsg(pdafile.getVersions());
//	         return loginResult;
			loginResult.setLatestVer(pdafile.getVersions());
		}
		//解密
		//MD5加密
		try {
//	        pass = PasswordUtil.encrypt(AESUtil.decrypt(loginPara.getPass(), "KeLy8g7qjmnbgWP0"));
			pass = PasswordUtil.encrypt(loginPara.getPass());
		} catch (Exception e) {
			loginResult.setStatus("F");//失败
			loginResult.setMsg("Login failed!");
			return loginResult;
		}
		name = loginPara.getUser();
		user = loginDAO.getRfUserByName(name);
		if (null == user) {
			loginResult.setStatus("F");//失败
			loginResult.setMsg("The user does not exist!");
			return loginResult;
		}
		if (!pass.equals(user.getPassword())) {
			loginResult.setStatus("F");//失败
			loginResult.setMsg("error password!");
			return loginResult;
		}
		loginResult.setNickName(user.getNickName());
		loginResult.setName(user.getName());

		//获取IP
		ip = loginPara.getIp();
		//获取签名
		sign = PasswordUtil.encrypt(name + ip + CommonTool.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
		loginResult.setSign(sign);
		//String type=loginDAO.getUserType(user.getId());
		try {
			location = loginDAO.getUserLocation(user.getId());
			loginResult.setLocation(location);
		} catch (Exception e) {
			loginResult.setStatus("F");//失败
			loginResult.setMsg("The user search error!");
			return loginResult;
		}

		try {
			//取菜单
			menu = loginDAO.getUserMenu(user.getId());
			loginResult.setMenu(menu);
		} catch (Exception e) {
			//  Auto-generated catch block
			e.printStackTrace();
		}

		//签名上传
		user.setRfSign(sign);
		user.setCurrentLoginIp(ip);
		user.setLastLoginIp(ip);
		user.setLastLoginTime(new Date());
		if(loginDAO.update(user)>0){
		    loginResult.setStatus("S");//成功
	        loginResult.setMsg("Login success!");
		}else{
		    loginResult.setStatus("F");//失败
	        loginResult.setMsg("Network abnormal,please login again!");
		}
		return loginResult;
	}

}
