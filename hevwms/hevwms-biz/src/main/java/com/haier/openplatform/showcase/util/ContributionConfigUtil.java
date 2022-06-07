package com.haier.openplatform.showcase.util;

import com.haier.openplatform.util.SpringApplicationContextHolder;

/**
 * 全局变量工具类
 * @author zhangxb
 *
 */
public final class ContributionConfigUtil {
	/**
	 * 常量：多语言系统
	 */
	public static final String MULTI_LANG_YES = "Y";

	/**
	 * 常量：单语言系统
	 */
	public static final String MULTI_LANG_NO = "N";

	private static ContributionConfig contribution;
	private static ContributionConfigUtil configUtil;

	private ContributionConfigUtil() {
		/*if (ContextLoaderListener.getCurrentWebApplicationContext() != null) {
			contribution = (ContributionConfig)ContextLoaderListener.getCurrentWebApplicationContext().getBean("contribution");
		} else {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-contribution.xml");
			contribution = (ContributionConfig) context.getBean("contribution");    		
		}*/
		contribution = SpringApplicationContextHolder.getBean("contribution");
	}

	/**
	 * 获取当前类实例的方法
	 * @return 返回当前工具类实例
	 */
	public static ContributionConfigUtil getInstance() {
		synchronized (ContributionConfigUtil.class) {
			if (configUtil == null) {
				configUtil = new ContributionConfigUtil();
			}
		}
		return configUtil;
	}

	/**
	 * 获取配置文件bean对象
	 * @return 返回bean对象实例
	 */
	public ContributionConfig getContributionConfig() {
		return contribution;
	}

	/**
	 * 方法：判断系统是否为多语言环境
	 * @author 王锦阳
	 * @return 返回结果（如果是多语言环境则返回true，否则返回false）
	 */
	public static boolean isMultiLanguage() {
		if (contribution == null) {
			return getInstance().getContributionConfig().getMultiLanguageFlag().equalsIgnoreCase(MULTI_LANG_YES);
		} else {
			return contribution.getMultiLanguageFlag().equalsIgnoreCase(MULTI_LANG_YES);
		}
	}

}
