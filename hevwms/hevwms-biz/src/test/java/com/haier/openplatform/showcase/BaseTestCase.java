package com.haier.openplatform.showcase;

import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.haier.openplatform.security.LoginContext;
import com.haier.openplatform.security.LoginContextHolder;
import com.haier.openplatform.showcase.util.CacheNames;
import com.haier.openplatform.showcase.util.SystemBootstrap;
import com.haier.openplatform.test.dbunit.BaseHopTestCase;

/**
 * @author WangXuzheng
 * 
 */
@ContextConfiguration(locations = { 
		"classpath*:/spring/spring-common.xml",
		"classpath*:/spring/spring-datasource.xml",
		"classpath*:/spring/spring-transaction.xml",
		"classpath*:/spring/spring-dubbo.xml",
		"classpath*:/spring/spring-external.xml",
		"classpath*:/spring/spring-config-toolkit.xml",
		"classpath*:/spring/cache/spring-cache-test.xml",
		"classpath*:/spring/cache/spring-cache-security.xml",
		"classpath*:/spring/jmx/spring-jmx-mbean.xml",
		"classpath*:/spring/security/spring-*.xml",
		"classpath*:/console/dubbo/spring-external.xml"})
@Ignore
@Transactional
public class BaseTestCase extends BaseHopTestCase {
	@Resource
	protected CacheManager ehcacheManager;
	protected Cache userCache;
	protected Cache roleCache;
	protected Cache resourceCache; 
	protected Cache sessionCache;
	protected Cache moduleCache;
	@Before
	public void prepareCache(){
		userCache = ehcacheManager.getCache(CacheNames.CACHE_NAME_USER);
		roleCache = ehcacheManager.getCache(CacheNames.CACHE_NAME_ROLE);
		resourceCache = ehcacheManager.getCache(CacheNames.CACHE_NAME_RESOURCE);
		sessionCache = ehcacheManager.getCache(CacheNames.CACHE_NAME_SESSION);
		moduleCache = ehcacheManager.getCache(CacheNames.CACHE_NAME_MODULE);
	}
	@Before
	public void prepareLoginContext() {
		LoginContext context = new LoginContext();
		context.setUserId(99999999L);
		context.setUserName("UNIT_TEST");
		LoginContextHolder.put(context);
	}
	@BeforeClass
	public static void initEnv() throws Exception{
		SystemBootstrap.init();
		
	}
	@Override
	public Properties getDBunitConfigProperties() {
		Properties properties = new Properties();
		//properties.put(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, "true");//每个表前缀添加schema名
		return properties;
	}
}
