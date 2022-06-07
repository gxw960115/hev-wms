package com.haier.openplatform.showcase.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @author Administrator
 *	jdbc连接工具类
 */
public class JDBCFactory {
    private static Connection connection;

    /**
    * @Title: init
    * @Description: TODO init db connection
    * @param 
    * @return void
    * @throws
     */
	public static synchronized void init() {
	    String driver = Env.getProperty(Env.DATASOURCE_DRIVER);
        String url = Env.getProperty(Env.DATASOURCE_URL);
        String name = Env.getProperty(Env.DATASOURCE_NAME);
        String password = Env.getProperty(Env.DATASOURCE_PSWD);
        
        try {
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url, name, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	* @Title: getDBConnection
	* @Description: get database connection
	* @param @return
	* @return Connection
	* @throws
	 */
	public static Connection getDBConnection() {
	    if (connection == null) {
	        JDBCFactory.init();
	    }
	    return connection;
    }
	
	
}
