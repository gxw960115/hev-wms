package com.haier.openplatform.wms.remoting.dto;

import java.io.Serializable;

public class OrderGoodsTransInDTO implements Serializable{

	private static final long serialVersionUID = 5492247143844728751L;
		/**
		 * @Fields user : (登陆账号)
		 */
		private String user;
		/**
		 * @Fields sign : (签名)
		 */
		private String sign;
		/**
		 * @Fields doctype : (单据类型)
		 */
		private String doctype;
		/**
		 * @Fields ordertype : (出入库类型)
		 */
		private String ordertype;
		/**
		 * @Fields orno : (单号)
		 */
		private String orno;
		
		private String version;


		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getSign() {
			return sign;
		}

		public void setSign(String sign) {
			this.sign = sign;
		}

		public String getDoctype() {
			return doctype;
		}

		public void setDoctype(String doctype) {
			this.doctype = doctype;
		}

		public String getOrdertype() {
			return ordertype;
		}

		public void setOrdertype(String ordertype) {
			this.ordertype = ordertype;
		}

		public String getOrno() {
			return orno;
		}

		public void setOrno(String orno) {
			this.orno = orno;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

}
