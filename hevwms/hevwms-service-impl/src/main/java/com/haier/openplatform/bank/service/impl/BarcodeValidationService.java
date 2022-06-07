package com.haier.openplatform.bank.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;
import com.bank.service.BarcodeValidationServiceFromBankToOtcwmsImpl;
import com.haier.openplatform.util.SpringApplicationContextHolder;



public class BarcodeValidationService implements com.haier.openflatform.wms.bank.service.BarcodeValidationServiceClient {

	Logger logger = Logger.getLogger(BarcodeValidationServiceFromBankToOtcwmsImpl.class);
//	private DruidDataSource dataSource;
 
	public boolean barcodeCheckFromBankToOtcwms( String barcode) {
		logger.debug("Entering barcodeCheckFromBankToOtcwms...............barcode" + barcode+"......................");
		    Connection conn = null;
		    ResultSet rs = null;
		    Boolean flag = false;
		    PreparedStatement pstmt= null;
		    PreparedStatement pstmt1= null;
		    try {
		        DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
		        conn = datasource.getConnection();
		        if (conn == null) {
		            logger.error("DB Connection is null, return!");
		            return false;
		        }
		        String sql = "select a.* from ( "
		        		+ " select BARCODE , SAP_ORDER_NO ,DOC_TYPE , ORDER_TYPE,PLANT,ORDER_NO "
		        		+ " from ods_order_info_dtl t "
		        		+ " where barcode = ? "
		        		+ " ORDER BY CREATE_DATE DESC LIMIT 1  ) a "
		        		+ " where doc_type = 'DN' AND order_type = '2' ";
		        pstmt =conn.prepareStatement(sql);
		        pstmt.setString(1, barcode);
		        rs=pstmt.executeQuery();
		        if (rs.next()) {
					flag = true;
				}
//		        String existSql = "select t.* from ods_inventory_info_dtl t  where barcode = '"+barcode+"'";
		        String existSql = "select t.* from ods_inventory_info_dtl t  where barcode = ?";
		        pstmt1 =conn.prepareStatement(existSql);
		        pstmt1.setString(1, barcode);
		        rs=pstmt1.executeQuery();
		        if (rs.next()) {
					flag = false;
				}	        
		        rs.close(); 
		        pstmt.close();
		        pstmt1.close();
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
	                if (pstmt1 != null) {
	                	pstmt1.close();
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
	                if (pstmt1 != null) {
	                	pstmt1.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
		    logger.debug("Exiting barcodeCheckFromBankToOtcwms...............barcode" + barcode+"......................");
		    return flag;
	}
 
	

	@Override
	public String barcodesCheckFromBankToOtcwms(String barcodes) {
		logger.debug("Entering barcodesCheckFromBankToOtcwms...............list......................");
		System.out.println(barcodes);
	   
		List barcodeList = new ArrayList<String>();
	    JSONObject js = new JSONObject();
	    if (barcodes==null) {
			return null;
		}
	    //String paramStr = "'"+barcodes.replace(",", "','")+"'";
	    String[] barcodesArray = barcodes.split(",");
	    StringBuffer paramStr = new StringBuffer("'0'");
//        if (barcodes!=null) {
			for (int i = 0; i < barcodesArray.length; i++) {
				barcodeList.add(barcodesArray[i]);
				paramStr = paramStr.append(",'").append(barcodesArray[i]).append("'");
			}
//		}
        
	    Connection conn = null;
	    ResultSet rs = null;
	    List  list = null;
	    PreparedStatement pstmt= null;
	    PreparedStatement pstmt1= null;
	    try {
	        DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
	        conn = datasource.getConnection();
	        if (conn == null) {
	            logger.error("DB Connection is null, return!");
	            return null;
	        }
	       
	        String sql = "select   BARCODE , SAP_ORDER_NO ,DOC_TYPE , ORDER_TYPE,PLANT,ORDER_NO   "
	        		+ " from ("
	        		+ " select  b.BARCODE , b.SAP_ORDER_NO ,b.DOC_TYPE , b.ORDER_TYPE,b.PLANT,b.ORDER_NO "
	        		+ " from (select barcode , max(row_id) max_row_id  from ods_order_info_dtl t  "
	        		      + " group by barcode  having barcode in (?) ) a "
	        		+ " left JOIN ods_order_info_dtl b on a.max_row_id = b .row_id "
	        		+ " ) c "
	        		+ " where doc_type = 'DN' AND order_type = '2' ";
	        		 
	        pstmt =conn.prepareStatement(sql);
	        pstmt.setString(1, paramStr.toString());
	        rs=pstmt.executeQuery();
	        for (;rs!= null&&rs.next();) {
	        	String barcode = rs.getString("BARCODE");
	        	js.put(barcode, true);
			}
	        String existSql = "select BARCODE from ods_inventory_info_dtl t  where barcode  in (?)";
	        pstmt1 =conn.prepareStatement(existSql);
	        pstmt1.setString(1, paramStr.toString());
	        rs=pstmt1.executeQuery();
	        for(;rs!=null&&rs.next();) {
	        	String barcode = rs.getString("BARCODE");
	        	js.put(barcode, false);
			}
	        for (int i = 0; i < barcodeList.size(); i++) {
				String param = (String)barcodeList.get(i);
				if (!js.containsKey(param)) {
					//js.put(param, "No");
					js.put(param, false);
				}
			}
	       
	        rs.close(); 
	        pstmt.close();
	        pstmt1.close();
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
                if (pstmt1 != null) {
                	pstmt1.close();
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
                if (pstmt1 != null) {
                	pstmt1.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
	    logger.debug("Exiting barcodeCheckFromBankToOtcwms...............list......................");
	    System.out.println(js.toString());
	    return js.toString();
	   
	}
}
