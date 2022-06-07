package com.haier.openplatform.showcase.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取env.properties配置文件中的配置项
 * @author WangXuzheng
 *
 */
public final class Env {
    private static Properties props;

	public static final String KEY_STATIC_URL = "server.static";
	public static final String KEY_DYNAMIC_URL = "server.dynamic";
	public static final String KEY_SERVER_NAME = "server.name";
	public static final String APP_NAME = "app.name";
	public static final String APP_URL = "app.url";
	public static final String APP_EAMIL = "app.email";
	public static final String SYS_ADMIN = "system.admin";
	public static final String BARCODE_TEMP_DIR = "barcoeTempDir";
	public static final String DATASOURCE_URL = "datasource.url";
	public static final String DATASOURCE_NAME = "datasource.name";
	public static final String DATASOURCE_PSWD = "datasource.password";
	public static final String DATASOURCE_DRIVER = "datasource.driver";
	
	//for material data download interface with MDM 2016-03-14.
	public static final String ALM_ID = "alm.id";
	public static final String MASTER_TYPE = "master.type";
	public static final String TABLE_NAME = "table.name";
	
	//for interface with SAP 2016-05-17.
    public static final String SAP_FLAG = "sap_flag";
	
	public static synchronized void init() {
        Properties property = new Properties();
        InputStream inputStream = null;
        try {
            inputStream = Env.class.getResourceAsStream("/env.properties");
            props = new Properties();
            props.load(inputStream);
            System.out.println("系统配置项: " + property);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取系统配置文件时发生错误...");

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭文件输入流失败");
                }
            }
        }
	}

	/**
	 * 读取配置项
	 * @param key
	 * @return
	 */
	public static final String getProperty(String key) {
	    if (props == null || props.size() == 0) {
	        Env.init();
	    }
		return props.getProperty(key);
	}
}
