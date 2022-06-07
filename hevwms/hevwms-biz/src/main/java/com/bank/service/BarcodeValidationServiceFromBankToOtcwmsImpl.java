package com.bank.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.alibaba.druid.pool.DruidDataSource;
import com.haier.openplatform.util.SpringApplicationContextHolder;

@WebService
public class BarcodeValidationServiceFromBankToOtcwmsImpl implements BarcodeValidationServiceFromBankToOtcwms {
	Logger logger = Logger.getLogger(BarcodeValidationServiceFromBankToOtcwmsImpl.class);
	private DruidDataSource dataSource;
	@WebMethod
	public String barcodeCheckFromBankToOtcwms(@WebParam(name = "barcode" , targetNamespace = "http://sevice.bank.com")String barcode) {
		logger.debug("Entering barcodeCheckFromBankToOtcwms...............barcode" + barcode+"......................");
		    Connection conn = null;
		    ResultSet rs = null;
		    String msg = "No";
		    PreparedStatement pstmt= null;
		    try {
		        DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
		        conn = datasource.getConnection();
		        if (conn == null) {
		            logger.error("DB Connection is null, return!");
		            return null;
		        }
		        String sql = "select a.* from ( "
		        		+ " select BARCODE , SAP_ORDER_NO ,DOC_TYPE , ORDER_TYPE,PLANT,ORDER_NO "
		        		+ " from ods_order_info_dtl t "
		        		+ " where barcode = ? "
		        		+ " ORDER BY CREATE_DATE DESC LIMIT 1  )"
		        		+ " where doc_type = 'DN' AND order_type = '2' ";
		        pstmt =conn.prepareStatement(sql);
		        pstmt.setString(1, barcode);
		        rs=pstmt.executeQuery();
		        if (rs.next()) {
					msg= "yes";
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
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
		        try {
	                if (pstmt != null) {
	                	pstmt.close();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
		        try {
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
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
		        try {
	                if (pstmt != null) {
	                	pstmt.close();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
		        try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        }
		    logger.debug("Exiting barcodeCheckFromBankToOtcwms...............barcode" + barcode+"......................");
		    return msg;
	}

	@WebMethod
	public List barcodesCheckFromBankToOtcwms(@WebParam(name = "barcodes" , targetNamespace = "http://sevice.bank.com")List barcodes) {
		logger.debug("Entering barcodeCheckFromBankToOtcwms...............list......................");
	    Connection conn = null;
	    ResultSet rs = null;
	    List  list = null;
	    PreparedStatement pstmt= null;
	    try {
	        DruidDataSource datasource = SpringApplicationContextHolder.getBean("dataSource");
	        conn = datasource.getConnection();
	        if (conn == null) {
	            logger.error("DB Connection is null, return!");
	            return null;
	        }
	        StringBuffer paramStr = new StringBuffer("'0'");
	        if (barcodes!=null) {
				for (int i = 0; i < barcodes.size(); i++) {
					String barcode = (String)barcodes.get(i);
					paramStr.append(",'").append(barcode).append("'");
					 
				}
			}
	        String sql = "select a.* from ( "
	        		+ " select BARCODE , SAP_ORDER_NO ,DOC_TYPE , ORDER_TYPE,PLANT,ORDER_NO "
	        		+ " from ods_order_info_dtl t "
	        		+ " where barcode in ( ?"
	        		+ " ) ORDER BY CREATE_DATE DESC LIMIT 1  )"
	        		+ " where doc_type = 'DN' AND order_type = '2' ";
	        pstmt =conn.prepareStatement(sql);
	        pstmt.setString(1, paramStr.toString());
	        rs=pstmt.executeQuery();
	        if (rs!= null) {
	        	list = new ArrayList();
	        	for (;rs.next();) {	
	        		String barcode = rs.getString("BARCODE");
					list.add(barcode);
				}
	        	
				 
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	        try {
                if (pstmt != null) {
                	pstmt.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	        try {
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	        try {
                if (pstmt != null) {
                	pstmt.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
	        try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
	    logger.debug("Exiting barcodeCheckFromBankToOtcwms...............list......................");
	    return list;
	}

}
