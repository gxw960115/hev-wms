package com.haier.hevwms;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Before;

import io.terminus.pampas.common.BaseUser;
import io.terminus.pampas.common.UserUtil;

public class BasicTestCase {
	
	@Before
	public void initVal(){ 
		BaseUser user = (BaseUser) getBean(BaseUser.class);
		UserUtil.putCurrentUser(user);
	}
	
	/**
	 * @param c
	 * @return 构造一个类，并且填充上属性
	 */
	public Object getBean(Class c) {
		Object obj = new Object();
		try {
			obj = c.newInstance();// 通过Class类的实例获得UserInfo的实例
			Field[] field = c.getDeclaredFields();
			for (int j = 0; j < field.length; j++) { // 遍历所有属性
				String name = field[j].getName(); // 获取属性的名字
				name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
				String type = field[j].getGenericType().toString(); // 获取属性的类型
				if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class
																// "，后面跟类名
					try {
						Method m = c.getMethod("set" + name, String.class);
						m.invoke(obj, "12");
					} catch (Exception e) {
					}

				}
				if (type.equals("class java.lang.Integer") || type.equals("int")) {
					try {
						Method m = c.getMethod("set" + name, Integer.class);
						m.invoke(obj, 1);
					} catch (Exception e) {
					}
				}
				if (type.equals("class java.lang.Long") || type.equals("long")) {
					try {
						Method m = c.getMethod("set" + name, Long.class);
						m.invoke(obj, 2l);
					} catch (Exception e) {
					}
				}
				if (type.equals("class java.lang.Float") || type.equals("float")) {
					try {
						Method m = c.getMethod("set" + name, Float.class);
						m.invoke(obj, 2.1f);
					} catch (Exception e) {
					}
				}
				if (type.equals("class java.lang.Double") || type.equals("double")) {
					try {
						Method m = c.getMethod("set" + name, Double.class);
						m.invoke(obj, 2.1d);
					} catch (Exception e) {
					}
				}

				if (type.equals("class java.lang.Boolean")) {
					try {
						Method m = c.getMethod("set" + name, Boolean.class);
						m.invoke(obj, false);
					} catch (Exception e) {
					}
				}
				if (type.equals("class java.util.Date")) {
					try {
						Method m = c.getMethod("set" + name, Date.class);
						m.invoke(obj, new Date());
					} catch (Exception e) {
					}
				}
			}

		} catch (Exception e) {
		}
		return obj;
	}
}
