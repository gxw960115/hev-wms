package com.haier.openplatform.showcase.utils;

import java.util.Properties;

/**
 * 读取env.properties配置文件中的配置项
 * @author WangXuzheng
 *
 */
public final class Env {
	public static final String APP_NAME = "app.name";
	public static final String LOGIN_AFTER_JUMP_URL  = "login.after.jump.url";
	public static final String FILESUPLOAD_NAME  = "filesUpload.name";
	private static Properties props;
	public static synchronized void init(Properties properties){
		props = properties;
	}
	/**
	 * 读取配置项
	 * @param key
	 * @return
	 */
	public static final String getProperty(String key){
		return props.getProperty(key);
	}
}
