package com.haier.openplatform.showcase.service;

import com.haier.openplatform.hac.security.domain.User;
import com.haier.openplatform.util.ExecuteResult;

public interface ImportExcelService {
	public ExecuteResult<User> importExcel(byte[] fileData);
}
