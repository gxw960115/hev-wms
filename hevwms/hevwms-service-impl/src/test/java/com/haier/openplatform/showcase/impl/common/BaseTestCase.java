package com.haier.openplatform.showcase.impl.common;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.haier.openplatform.test.dbunit.BaseHopTestCase;

/**
 * @author WangXuzheng
 * 
 */
@ContextConfiguration(locations = {
		"classpath*:/spring_service_test/spring-datasource.xml",
		"classpath*:/spring/spring-transaction.xml",
		"classpath*:/spring/spring-config-toolkit.xml",
		"classpath*:/spring_service/**/spring-*.xml"})
@Ignore
@Transactional
public class BaseTestCase extends BaseHopTestCase {

}
