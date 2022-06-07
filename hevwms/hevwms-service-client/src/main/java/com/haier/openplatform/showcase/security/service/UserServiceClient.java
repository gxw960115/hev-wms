package com.haier.openplatform.showcase.security.service;

import io.terminus.pampas.client.Export;

import com.haier.openplatform.showcase.security.dto.MdBarcodeDTO;
import com.haier.openplatform.showcase.security.dto.UserDTO;
import com.haier.openplatform.showcase.util.Paging;

/**
 * 供客户端调用的远程接口
 * @author 01311917
 *
 */
public interface UserServiceClient {
	
	/**
	 * get请求,一个参数的情况
	 * @param userId
	 * @return
	 */
	@Export(paramNames = {"userId"})
	public UserDTO getUserById(long userId);
	
	/**
	 * get请求,多个参数的情况
	 * @param userId
	 * @param userName
	 * @return
	 */
	@Export(paramNames = {"userId","userName"})
	public UserDTO getUserByIdAndName(long userId,String userName);
	
	/**
	 * 发布post方式的rest服务实例
	 * @param user
	 * @return
	 */
	public UserDTO getUserByIdPost(UserDTO user);
	
	/**
	 * 通过form提交的方式访问,这种情况下DTO里的属性需要加@FormParam注解
	 * @param user
	 * @return
	 */
	public UserDTO getUserByPostForm(UserDTO user);
	
	/**
	 * 通过form提交的另一种访问方式
	 * @param id
	 * @param userName
	 * @return
	 */
	public UserDTO getUserByPostForm(long id,String userName);
	
	/**
	   * @Name: confirmUser
	   * @Description: @param userId
	   * @Description: @param userName
	   * @Description: @return
	   * @Author: Nicholas
	   * @Version: V1.00 （版本号）
	   * @Create Date: 2015-10-16下午5:15:10
	   * @Parameters: UserServiceClient
	   * @Return: String
	   */
	@Export(paramNames = {"userId","userName"})
	public String confirmUser(long userId,String userName);
	/**
	   * @Name: confirmUser
	   * @Description: @param userId
	   * @Description: @param userName
	   * @Description: @return
	   * @Author: Nicholas
	   * @Version: V1.00 （版本号）
	   * @Create Date: 2015-10-16下午5:15:10
	   * @Parameters: UserServiceClient	
	   * @Return: String
	   */
	@Export(paramNames = {"size","materialNo","code"})
	public Paging<MdBarcodeDTO> searchBarcodes(String size,String materialNo,String code);
}
