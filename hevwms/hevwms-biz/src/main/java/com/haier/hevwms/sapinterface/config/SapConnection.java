package com.haier.hevwms.sapinterface.config;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.ext.DestinationDataProvider;


public class SapConnection {
	
	private static final Log log = LogFactory.getLog("SapConnection");
	private static final String ABAP_AS ="ABAP_AS_WITHOUT_POOL";
	public static final String ABAP_AS_POOLED = "ABAP_AS_WITH_POOL";
	public static final String ABAP_MS = "ABAP_MS_WITHOUT_POOL";
	private static JCoDestination destination;

	public static void initSapConn() throws IOException {
		createDataFile(ABAP_MS, "jcoDestination");
	}
	
	public static void createDataFile(String name, String suffix) throws IOException {
		File cfg = new File(name + "." + suffix);
	
		if (!cfg.exists()) {
			log.debug("ABAP_MS_WITHOUT_POOL config file not exist, create new one...");
			FileOutputStream fos = new FileOutputStream(cfg, false);
	
			HEVWMSSAPConfig hevwmsSapConfig = new HEVWMSSAPConfig();

			String sapHost = hevwmsSapConfig.getSap_host(); // SAP IP 地址
			String sapClient = hevwmsSapConfig.getSap_client(); // SAP 端口号
			String sapUser = hevwmsSapConfig.getSap_user(); // SAP 用户
			String sapPasswd = hevwmsSapConfig.getSap_passwd();// SAP 密码
			String sapLang = hevwmsSapConfig.getSap_lang(); // SAP 语言
			String sapSysnr = hevwmsSapConfig.getSap_sysnr(); // SAP 系统编号
			String sapGroup = hevwmsSapConfig.getSap_group(); // SAP 系统组
			String sapR3name = hevwmsSapConfig.getSap_r3name(); // SAP 系统组
			String sapFlag = hevwmsSapConfig.getSap_flag(); //是否组连接 
	
			Properties connectProperties = new Properties();
			if ("0".equals(sapFlag)){
				//ip
				connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, sapHost);
				connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, sapClient);
				connectProperties.setProperty(DestinationDataProvider.JCO_USER, sapUser);
				connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, sapPasswd);
				connectProperties.setProperty(DestinationDataProvider.JCO_LANG, sapLang);
				connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR, sapSysnr);
			} else {
				//组
				connectProperties.setProperty(DestinationDataProvider.JCO_MSHOST, sapHost);
				connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, sapClient);
				connectProperties.setProperty(DestinationDataProvider.JCO_USER, sapUser);
				connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, sapPasswd);
				connectProperties.setProperty(DestinationDataProvider.JCO_GROUP, sapGroup);
				connectProperties.setProperty(DestinationDataProvider.JCO_R3NAME, sapR3name);
				connectProperties.setProperty(DestinationDataProvider.JCO_LANG, sapLang);
			}
	
			//added time out setting. 20170810
//			connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "1000");
//			connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT, "1000");
//			connectProperties.setProperty(DestinationDataProvider.JCO_MAX_GET_TIME, "1");
	
			connectProperties.store(fos, "for tests only !");
			fos.close();
		} else {
			log.debug("ABAP_MS_WITHOUT_POOL existed...");
		}
		log.debug(">> The file path: " + cfg.getAbsolutePath());
	}
	
	public static void stepOneConnect() throws JCoException {
		log.info("Entering step1Connect...");
		try {
			//改为组登录的方式
			destination = JCoDestinationManager.getDestination(ABAP_MS);
			log.info("Attributes:");
			log.info(destination.getAttributes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
