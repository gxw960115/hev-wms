package com.haier.openplatform.showcase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.dbunit.DatabaseUnitException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.haier.openplatform.test.dbunit.DbunitManager;

/**
 * 工具类，快速生成xml测试准备数据模板
 * @author WangXuzheng
 *
 */
public class ExportDb2Xml {
	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, DatabaseUnitException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-datasource.xml");
		DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);
		DbunitManager dbunitManager = new DbunitManager(dataSource);
		Map<String,String> sqlMap = new HashMap<String, String>();
		sqlMap.put("USER_INFO", "select * from USER_INFO where rownum <2");
//		dbunitManager.exportDB2Xml(sqlMap, FileUploadServiceImplTest_DeleteFileById.class);
	}
}
