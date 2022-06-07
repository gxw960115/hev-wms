package com.haier.openplatform.showcase.util;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.alibaba.dubbo.common.serialize.support.SerializationOptimizer;
import com.haier.openplatform.showcase.security.dto.UserDTO;
/**
 * 将需要序列化的类注册到dubbo,以提高序列化性能,参照UserDTO,添加到list里面
 * @author 01311917
 *
 */
public class SerializationOptimizerImpl implements SerializationOptimizer {

	@SuppressWarnings("rawtypes")
	@Override
	public Collection<Class> getSerializableClasses() {
		List<Class> classes = new LinkedList<Class>();
		classes.add(UserDTO.class);
		return classes;
	}

}
