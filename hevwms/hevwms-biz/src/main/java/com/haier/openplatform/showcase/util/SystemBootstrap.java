package com.haier.openplatform.showcase.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import mx4j.tools.adaptor.http.HttpAdaptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.AbstractEnvironment;

import com.haier.openplatform.SysException;
import com.haier.openplatform.session.listener.MaxSessionUtil;
import com.haier.openplatform.util.Env;

/**
 * @author WangXuzheng
 *
 */
public class SystemBootstrap implements InitializingBean {
	/**
	 * CONFIG_FILE_PATH 系统变量配置文件路径
	 */
	private static final String CONFIG_FILE_PATH = "/env.properties";
	private static final Log LOG = LogFactory.getLog(SystemBootstrap.class);
	
	private HttpAdaptor httpAdaptor;

	public static void  init() {
		InputStream inputStream = null;
		Properties properties = new Properties();
		try{
			inputStream = SystemBootstrap.class.getResourceAsStream(CONFIG_FILE_PATH);
			properties.load(inputStream);
			LOG.info("系统配置项:"+properties);
		}catch (Exception e) {
			LOG.error("读取系统配置文件时发生错误：",e);
			throw new SysException(e);
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
					LOG.error("关闭文件输入流失败：",e);
				}
			}
		}
		Env.init(properties);
//		AuditInfoCollector.setAppNM(Env.getProperty(Env.KEY_SERVER_NAME));
//		HOPConstant.setAppName(Env.getProperty(Env.KEY_SERVER_NAME));
		//设置一些全局参数
		MaxSessionUtil.setMaxSessionKey(Env.getProperty(Env.KEY_SERVER_NAME)+"_MAX_SESSION_KEYS");
		//使用spring的profile
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, Env.getProperty(Env.ENV_TYPE));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		httpAdaptor.start();
	}

	public void setHttpAdaptor(HttpAdaptor httpAdaptor) {
		this.httpAdaptor = httpAdaptor;
	}
}
