package com.haier.openplatform.showcase.impl.common;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DubboStartUtil {

	/**
	 * 该单元测试用作本地启动dubbo服务，可debug dubbo服务
	 */
	@Test
//	@Ignore
	public void testStartDubbo(){
		ClassPathXmlApplicationContext providerContext = new ClassPathXmlApplicationContext(
				"classpath*:/console/audit/console-audit.xml",
				"classpath*:/console/dubbo/spring-dubbo.xml",
				"classpath*:/console/dubbo/spring-external.xml",
				"classpath*:/console/message/console-message-provider.xml",
				"classpath*:/spring/jmx/spring-jmx-mbean.xml",
				"classpath*:/spring/spring-common.xml",
				"classpath*:/spring/spring-monitor.xml",
				"classpath*:/spring/spring-external.xml",
				"classpath*:/spring/spring-datasource.xml",
				"classpath*:/spring/spring-transaction.xml",
				"classpath*:/spring/spring-config-toolkit.xml",
				"classpath*:/spring/cache/spring-*.xml",
				"classpath*:/spring/security/spring-*.xml",
				"classpath*:/spring_service/**/spring-*.xml",
				"classpath*:/spring-auth/spring-config.xml"
				);
		providerContext.start();
		while(true){}
	}
}
