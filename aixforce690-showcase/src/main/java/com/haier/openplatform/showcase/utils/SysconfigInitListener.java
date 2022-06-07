package com.haier.openplatform.showcase.utils;

import javax.servlet.ServletContextEvent;

import com.haier.openplatform.util.SystemStartupListener;

/**
 * 加载env.properties中的配置项，将静态资源地址和动态资源地址放到application变量中
 * @author WangXuzheng
 *
 */
public class SysconfigInitListener implements SystemStartupListener {
	@Override
	public void onStartup(ServletContextEvent contextEvent) {
		SystemBootstrap.init();
	}
}
