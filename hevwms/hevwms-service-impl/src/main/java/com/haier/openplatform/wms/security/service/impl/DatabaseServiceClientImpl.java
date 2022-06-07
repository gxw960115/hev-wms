package com.haier.openplatform.wms.security.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haier.openplatform.showcase.util.Env;
import com.haier.openplatform.wms.security.service.DatabaseServiceClient;

/** 
* @ClassName: DatabaseServiceClientImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author A18ccms a18ccms_gmail_com 
* @date 2019年7月20日 下午1:23:54 
*  
*/
public class DatabaseServiceClientImpl implements DatabaseServiceClient{

	private static final Logger logger = LoggerFactory.getLogger(DatabaseServiceClientImpl.class);
	
	private String driver = Env.getProperty(Env.DATASOURCE_DRIVER);
	private String url = Env.getProperty(Env.DATASOURCE_URL);
	private String username = Env.getProperty(Env.DATASOURCE_NAME);
	private String password = Env.getProperty(Env.DATASOURCE_PSWD);
	
	/* (非 Javadoc) 
	* <p>Title: dbInit</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.haier.openplatform.wms.security.service.DatabaseServiceClient#dbInit() 
	*/
	@Override
	public String dbInit() {
        StringBuffer tableNames = new StringBuffer();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        PreparedStatement pstmt3 = null;
        PreparedStatement pstmt4 = null;
        logger.info("Driver=========="+driver);
        logger.info("Url=========="+url);
        logger.info("Username=========="+username);
        logger.info("Password=========="+password);
        try {
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            conn = ds.getConnection();
            if (conn == null) {
                logger.error("DB Connection is null, return!");
                return null;
            }
            logger.info("DB Connection create successfully!");
            String sql1 = "SELECT * FROM USER_TABLES ORDER BY TABLE_NAME";
            pstmt1 = conn.prepareStatement(sql1);
            rs = pstmt1.executeQuery();
            while (rs.next()){
                tableNames.append(rs.getString("TABLE_NAME")).append(",");
            }
            tableNames = tableNames.deleteCharAt(tableNames.length() - 1).append(":");
            logger.info("Table names====="+tableNames);
            String sql2 = "SELECT * FROM USER_TAB_COLS WHERE TABLE_NAME = ? ORDER BY COLUMN_ID";
            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1,tableNames.toString().split(",")[0]);
            rs = pstmt2.executeQuery();
            while (rs.next()){
                tableNames.append(rs.getString("COLUMN_NAME")+",");
            }
            tableNames = tableNames.deleteCharAt(tableNames.length() - 1).append(":");
            logger.info("Colume names====="+tableNames);
            String sql3 = "Select * From user_objects Where object_type='FUNCTION' ORDER BY OBJECT_NAME";
            pstmt3 = conn.prepareStatement(sql3);
            rs = pstmt3.executeQuery();
            while (rs.next()){
                tableNames.append(rs.getString("OBJECT_NAME")+",");
            }
            tableNames = tableNames.deleteCharAt(tableNames.length() - 1).append(":");
            logger.info("Function names====="+tableNames);
            
            String sql4 = "Select * From user_objects Where object_type='PROCEDURE' ORDER BY OBJECT_NAME";
            pstmt4 = conn.prepareStatement(sql4);
            rs = pstmt4.executeQuery();
            while (rs.next()){
                tableNames.append(rs.getString("OBJECT_NAME")+",");
            }
            tableNames = tableNames.deleteCharAt(tableNames.length() - 1);
            logger.info("Procedure names====="+tableNames);

            rs.close();
            pstmt1.close();
            pstmt2.close();
            pstmt3.close();
            pstmt4.close();
            conn.close();
        } catch (Exception e) {
            logger.error("Catch Unknown Exception: " + e.getMessage());
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (pstmt3 != null) {
                    pstmt3.close();
                }
                if (pstmt4 != null) {
                    pstmt4.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (pstmt3 != null) {
                    pstmt3.close();
                }
                if (pstmt4 != null) {
                    pstmt4.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return tableNames.toString();
	}

	/* (非 Javadoc) 
	* <p>Title: changeColumns</p> 
	* <p>Description: </p> 
	* @param tableName
	* @return 
	* @see com.haier.openplatform.wms.security.service.DatabaseServiceClient#changeColumns(java.lang.String) 
	*/
	@Override
	public String changeColumns(String tableName) {
		StringBuffer columns = new StringBuffer();
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        logger.info("Driver=========="+driver);
        logger.info("Url=========="+url);
        logger.info("Username=========="+username);
        logger.info("Password=========="+password);
        try {
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            conn = ds.getConnection();
            if (conn == null) {
                logger.error("DB Connection is null, return!");
                return null;
            }
            logger.info("DB Connection create successfully!");
            String sql = "SELECT * FROM USER_TAB_COLS WHERE TABLE_NAME = ? ORDER BY COLUMN_ID";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,tableName);
            rs = pstmt.executeQuery();
            while (rs.next()){
                columns.append(rs.getString("COLUMN_NAME")).append(",");
            }
            logger.info("Column names======"+columns);
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            logger.error("Catch Unknown Exception: " + e.getMessage());
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return columns.toString().substring(0,columns.toString().length() - 1);
	}
	
	/** 
	* @Title: pagingSQL 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sql
	* @param @param currentPage
	* @param @param pageSize
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String pagingSQL(String sql,int currentPage,int pageSize){
		logger.info("sql====="+sql);
		logger.info("currentPage====="+currentPage);
		logger.info("pageSize====="+pageSize);
        int startRow = (currentPage -1 ) * pageSize + 1;
        int maxPage = currentPage * pageSize;
        String endSql = "select * from ("+
                "select rownum row_,t.* from (" +sql + ") t"+
                " where rownum<="+maxPage+
                ") where row_>="+startRow;
        return endSql;
    }

	/** 
	* @Title: countSQL 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param sql
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	public String countSQL(String sql){
		logger.info("sql====="+sql);
        StringBuffer endSql = new StringBuffer();
        endSql.append("select COUNT(*) cou from (").append(sql).append(")");
        return endSql.toString();
    }

	/* (非 Javadoc) 
	* <p>Title: queryData</p> 
	* <p>Description: </p> 
	* @param sql
	* @param pageSize
	* @param currentPage
	* @return 
	* @see com.haier.openplatform.wms.security.service.DatabaseServiceClient#queryData(java.lang.String, int, int) 
	*/
	@Override
	public String queryData(String sql, int pageSize, int currentPage) {
		String status = "1";
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        String result = "";
        JSONObject resultObj = new JSONObject();
        JSONObject msgObj = new JSONObject();
        JSONArray infoArr = new JSONArray();
        int totalPage = 0;
        logger.info("Driver=========="+driver);
        logger.info("Url=========="+url);
        logger.info("Username=========="+username);
        logger.info("Password=========="+password);
        try {
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            conn = ds.getConnection();
            if (conn == null) {
                logger.error("DB Connection is null, return!");
                return null;
            }
            logger.info("DB Connection create successfully!");
            String countSql = countSQL(sql);
            pstmt1 = conn.prepareStatement(countSql);
            rs = pstmt1.executeQuery();
            String rowCount = "";
            while (rs.next()){
                rowCount = rs.getString("cou");
            }
            totalPage = (Integer.parseInt(rowCount) / pageSize) + 1;
            String pagingSql = pagingSQL(sql,currentPage,pageSize);
            pstmt2 = conn.prepareStatement(pagingSql);
            rs = pstmt2.executeQuery();
            //获取返回结果元数据信息
            ResultSetMetaData rsmd = rs.getMetaData();
            int colLen = rsmd.getColumnCount();
            String[][] colNameArr = new String[colLen][2];
            StringBuffer titles = new StringBuffer();
            for (int i = 0; i < colLen; i++) {
                titles.append(rsmd.getColumnName(i+1)).append(",");
                colNameArr[i][0] = rsmd.getColumnName(i+1);
                colNameArr[i][1] = rsmd.getColumnClassName(i+1);
            }
            String titless = titles.toString().substring(0,titles.length() - 1);
            msgObj.put("title",titless);
            String contents = "";
            int rows = 0;
            while (rs.next()){
                rows += 1;
                JSONObject infoObj = new JSONObject();
                for (int i = 0; i < colNameArr.length; i++) {
                    String colName = colNameArr[i][0];
                    String colType = colNameArr[i][1];
                    String colValue = "";
                    if("java.math.BigDecimal".equals(colType)){
                        colValue = rs.getString(colName)+"";
                    } else if("java.lang.String".equals(colType)){
                        colValue = rs.getString(colName);
                    } else if("java.sql.Timestamp".equals(colType)){
                        if (rs.getDate(colName) != null){
                            colValue = DateFormatUtils.format(rs.getDate(colName),"yyyy-MM-dd HH:mm:ss");
                        }
                        colValue = colValue.replace(" 00:00:00","");
                    }
                    infoObj.put(colName,colValue);
                }
                infoArr.add(infoObj);
            }
            msgObj.put("row",infoArr.toString());

            rs.close();
            pstmt1.close();
            pstmt2.close();
            conn.close();
        } catch (Exception e) {
            status = "0";
            logger.error("Catch Unknown Exception: " + e.getMessage());
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            result = e.getMessage();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt1 != null) {
                    pstmt1.close();
                }
                if (pstmt2 != null) {
                    pstmt2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if ("1".equals(status)){
            result = msgObj.toString();
        }
        resultObj.put("status",status);
        resultObj.put("info",result);
        resultObj.put("totalPage",totalPage);
        return resultObj.toString();

	}

	/* (非 Javadoc) 
	* <p>Title: modifyData</p> 
	* <p>Description: </p> 
	* @param sql
	* @return 
	* @see com.haier.openplatform.wms.security.service.DatabaseServiceClient#modifyData(java.lang.String) 
	*/
	@Override
	public String modifyData(String sql) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        logger.info("Driver=========="+driver);
        logger.info("Url=========="+url);
        logger.info("Username=========="+username);
        logger.info("Password=========="+password);
        try {
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            conn = ds.getConnection();
            if (conn == null) {
                logger.error("DB Connection is null, return!");
                return null;
            }
            logger.info("DB Connection create successfully!");
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate(sql);
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            logger.error("Catch Unknown Exception: " + e.getMessage());
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
//            e.printStackTrace();
            return e.getMessage();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "success";
	}
	
	/* (非 Javadoc) 
	* <p>Title: checkProcedure</p> 
	* <p>Description: </p> 
	* @param prcName
	* @return 
	* @see com.haier.openplatform.wms.security.service.DatabaseServiceClient#checkProcedure(java.lang.String) 
	*/
	@Override
	public List<String> checkProcedure(String prcName){
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        List<String> result = new ArrayList<String>();
        logger.info("Driver=========="+driver);
        logger.info("Url=========="+url);
        logger.info("Username=========="+username);
        logger.info("Password=========="+password);
        try {
            DruidDataSource ds = new DruidDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(username);
            ds.setPassword(password);

            conn = ds.getConnection();
            if (conn == null) {
                logger.error("DB Connection is null, return!");
                return null;
            }
            logger.info("DB Connection create successfully!");
            String sql = "SELECT * FROM USER_SOURCE WHERE NAME = ? ORDER BY LINE";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,prcName);
            rs = pstmt.executeQuery();
            while (rs.next()){
                //-----------------------------
            	result.add(rs.getString("TEXT"));
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            logger.error("Catch Unknown Exception: " + e.getMessage());
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
	}
}
