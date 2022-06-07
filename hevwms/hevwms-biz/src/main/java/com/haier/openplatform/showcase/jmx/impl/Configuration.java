package com.haier.openplatform.showcase.jmx.impl;

import com.haier.openplatform.showcase.jmx.ExposeMethodInterface;

/**
 * 运行期管理系统接口实现,可根据需要添加,也可重新实现
 * @author 01311917
 *
 */
public class Configuration implements ExposeMethodInterface {

	@Override
	public String say(){
		return "Hello";
	}
}
