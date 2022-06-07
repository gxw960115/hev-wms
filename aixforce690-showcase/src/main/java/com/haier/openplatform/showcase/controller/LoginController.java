package com.haier.openplatform.showcase.controller;

import io.terminus.common.utils.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.showcase.domain.LoginResult;
import com.haier.openplatform.showcase.utils.Env;

import java.util.Date;
import java.util.List;

import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.CdLocInfoDTO;
import com.haier.openplatform.wms.basicdata.service.CdLocInfoServiceClient;
import com.haier.wms.util.PageBean;
import com.haier.wms.util.PageUtil;
import io.terminus.common.utils.JsonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haier.openplatform.security.SessionSecurityConstants;
import com.haier.openplatform.showcase.domain.LoginResult;
import com.haier.openplatform.showcase.utils.Env;

import static javax.print.attribute.standard.MediaSizeName.D;


@Controller
public class LoginController {

    @Resource
    private CdLocInfoServiceClient cdLocInfoServiceClient;

    @RequestMapping(value = "/user/login", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        LoginResult loginResult = new LoginResult();
        /////
        loginResult.setResult("true");
        loginResult.setMsg("登录认证成功");
        Object targetUrl = request.getSession().getAttribute(SessionSecurityConstants.KEY_LAST_VISIT_URL);
        loginResult.setTargetUrl(targetUrl == null ? Env.getProperty(Env.LOGIN_AFTER_JUMP_URL) : (String) targetUrl);
        ////
//		if(result.isSuccess()){
//			request.getSession().setAttribute(SessionSecurityConstants.KEY_USER_NAME, userCode);
//			// 其他一些session的信息在这里设置
//			request.getSession().setAttribute(SessionSecurityConstants.KEY_USER_NICK_NAME, userCode);
//			request.getSession().setAttribute(SessionSecurityConstants.KEY_USER_ID, result.getResult().getUserId());
//			loginResult.setResult("true");
//			loginResult.setMsg("登录认证成功");
//			Object targetUrl = request.getSession().getAttribute(SessionSecurityConstants.KEY_LAST_VISIT_URL);
//			loginResult.setTargetUrl(targetUrl == null ? Env.getProperty(Env.LOGIN_AFTER_JUMP_URL) : (String)targetUrl);
//		}else{
//			loginResult.setResult("false");
//			loginResult.setMsg(result.getErrorMessages().size() > 0 ? result.getErrorMessages().get(0) : "用户名或密码错误");
//		}
        return JsonMapper.JSON_NON_EMPTY_MAPPER.toJson(loginResult);
    }

    @RequestMapping(value = "/aliveCheck", method = RequestMethod.GET)
    @ResponseBody
    public String aliveCheck() {
        String now = new Date().toString();
        return now;
    }

    @RequestMapping(value = "/aliveHeart", method = RequestMethod.GET)
    @ResponseBody
    public String getAllLocInfo() {
        List<CdLocInfoDTO> list = cdLocInfoServiceClient.searchCdLocInfoByConditionBc();
        return JsonMapper.JSON_NON_DEFAULT_MAPPER.toJson(list);
    }

}
