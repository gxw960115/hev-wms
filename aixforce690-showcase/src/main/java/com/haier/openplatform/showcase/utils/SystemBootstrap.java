package com.haier.openplatform.showcase.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.haier.openplatform.SysException;
import com.haier.openplatform.util.HOPConstant;

/**
 * @author WangXuzheng
 *
 */
public class SystemBootstrap{
	/**
	 * CONFIG_FILE_PATH 系统变量配置文件路径
	 */
	private static final String CONFIG_FILE_PATH = "/app.properties";
	private static final Log LOG = LogFactory.getLog(SystemBootstrap.class);

	public static void  init() {
		InputStream inputStream = null;
		Properties properties = new Properties();
		try{
			inputStream = SysconfigInitListener.class.getResourceAsStream(CONFIG_FILE_PATH);
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
		HOPConstant.setAppName(Env.getProperty(Env.APP_NAME));
		//设置一些全局参数
		//MaxSessionUtil.setMaxSessionKey(Env.getProperty(Env.SERVER_NAME)+"_MAX_SESSION_KEYS");
	}
}
