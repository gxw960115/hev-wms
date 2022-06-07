package com.haier.openplatform.wms.remoting.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.haier.openplatform.wms.remoting.dto.LoginParaDTO;
import com.haier.openplatform.wms.remoting.dto.LoginResultDTO;
import com.haier.openplatform.wms.remoting.dto.LogoutParaDTO;
import com.haier.openplatform.wms.remoting.dto.LogoutResultDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderLoadOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListInDTO;
import com.haier.openplatform.wms.remoting.dto.WmsOrderDelListOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderIgpOutDTO;

/** 
* @ClassName: RsWsClient 
* @Description: (手持对外接口) 
* @author Song Yinglong // Nicholas
* @date 2015-11-5 下午3:05:08 
* @param 
*/ 
public interface RfWsClient {
	
	/** 
	* @Title: test 
	* @Description: (测试用) 
	* @param @param id
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/ 
//	@Export(paramNames = {"id"})
	public String test(String id);

	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException  
	* @Title: otcwmsLogin 
	* @Description: (这里用一句话描述这个方法的作用) 
	* @param @param loginParaDTO
	* @param @return    设定文件 
	* @return LoginResultDTO    返回类型 
	* @throws 
	*/ 
	//@Export(paramNames = {"loginParaDTO"})
	public LoginResultDTO otcwmsLogin(LoginParaDTO loginParaDTO,String version) 
			throws IllegalAccessException, InvocationTargetException;

	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException  
	* @Title: otcwmsLogout 
	* @Description: (手持等出) 
	* @param @param logoutParaDTO
	* @param @return    设定文件 
	* @return LogoutResult    返回类型 
	* @throws 
	*/ 
//	@Export(paramNames = {"logoutParaDTO"})
	public LogoutResultDTO otcwmsLogout(LogoutParaDTO logoutParaDTO) 
			throws IllegalAccessException, InvocationTargetException;

	/** 
	* @Title: otcwmsOrderCheck 
	* @Description: (手持输入的单据验证) 按照输入的单号，验证单号是否存在可扫
	* 				，        如果单号不存在则提示需要下载输入的单号安装输入的单号，验证单号是否存在可扫，
	* 					如果单号不存在则提示需要下载输入的单号
	* @param @param inpara
	* @param @return
	* @param @throws IllegalAccessException
	* @param @throws InvocationTargetException    设定文件 
	* @return OtcwmsOrderCheckOutDTO    返回类型 
	* @throws 
	*/ 
//	@Export(paramNames = {"inpara"})
	public OrderCheckOutDTO otcwmsOrderCheck(OrderCheckInDTO inpara,String version)
			throws IllegalAccessException, InvocationTargetException;
	/** 
	* @Title: otcwmsOrderDelete 
	* @Description: (条码删除) 
	* @param @param inpara
	* @param @return
	* @param @throws IllegalAccessException
	* @param @throws InvocationTargetException    设定文件 
	* @return OtcwmsOrderDeleteOutDTO    返回类型 
	* @throws 
	*/ 
//	@Export(paramNames = {"inpara"})
	public OrderDeleteOutDTO otcwmsOrderDelete(OrderDeleteInDTO inpara,String version)
			throws IllegalAccessException, InvocationTargetException;

	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException  
	* @Title: otcwmsOrderUpload 
	* @Description: (条码扫描) 
	* @param @param inpara
	* @param @return    设定文件 
	* @return OtcwmsOrderUploadOutDTO    返回类型 
	* @throws 
	*/ 
//	@Export(paramNames = {"inpara"})
	public OrderUploadOutDTO otcwmsOrderUpload(OrderUploadInDTO inpara,String version) 
			throws IllegalAccessException, InvocationTargetException;

	/** 
	* @Title: otcwmsOrderIgp 
	* @Description: (IGP) 
	* @param @param inpara
	* @param @return
	* @param @throws IllegalAccessException
	* @param @throws InvocationTargetException    设定文件 
	* @return OtcwmsOrderIgpOutDTO    返回类型 
	* @throws 
	*/
//	@Export(paramNames = {"inpara"})
	public OrderIgpOutDTO otcwmsOrderIgp(OrderIgpInDTO inpara,String version)
			throws IllegalAccessException, InvocationTargetException;

	/** 
	* @Title: otcwmsOrderLoad 
	* @Description: (单据下载) 
	* @param @param inpara
	* @param @return
	* @param @throws IllegalAccessException
	* @param @throws InvocationTargetException    设定文件 
	* @return OtcwmsOrderLoadOutDTO    返回类型 
	* @throws 
	*/ 
	public OrderLoadOutDTO otcwmsOrderLoad(OrderLoadInDTO inpara,String version)
			throws IllegalAccessException, InvocationTargetException;

	/** 
	* @Title: OtcwmsBarcodeList 
	* @Description: (查询条码明细) 
	* @param @param inpara
	* @param @return    设定文件 
	* @return OtcwmsOrderDelListOutDTO    返回类型 
	* @throws 
	*/ 
	public WmsOrderDelListOutDTO otcwmsBarcodeList(WmsOrderDelListInDTO inpara);
	
	/**
	* @Title: offlineScan
	* @Description: 离线扫描
	* @param @param paramsIn
	* @param @return
	* @return Map<String,String>
	* @throws
	 */
	public Map<String, String> offlineScan(List<OrderUploadInDTO > paramsIn);

}
