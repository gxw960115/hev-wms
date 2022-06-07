package com.haier.openplatform.showcase.impl.security.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.hevwms.basic.service.MdBarcodeService;
import com.haier.openplatform.showcase.security.dto.MdBarcodeDTO;
import com.haier.openplatform.showcase.security.dto.UserDTO;
import com.haier.openplatform.showcase.security.service.UserServiceClient;
import com.haier.openplatform.showcase.util.Paging;

@Path("user")
@Consumes({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//参数类型
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})//返回值类型
public class UserServiceClientImpl implements UserServiceClient{
	
	private MdBarcodeService mdBarcodeService;

	@GET
	@Path("{userId : \\d+}")
	@Override
	public UserDTO getUserById(@PathParam("userId")long userId) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(123456L);
		userDTO.setName("test-测试-get");
		if(userId != 0){
			userDTO.setId(userId);
		}
		return userDTO;
	}
	
	@GET
	@Path("getUserByIdAndName")
	@Override
	public UserDTO getUserByIdAndName(@DefaultValue("0") @QueryParam("user_id")long userId,@DefaultValue("") @QueryParam("user_name")String userName) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(123456L);
		userDTO.setName("test-测试-get-mutil-param");
		if(userId != 0){
			userDTO.setId(userId);
		}
		if(!"".equals(userName)){
			userDTO.setName(userName);
		}
		return userDTO;
	}

	@POST
	@Path("getUser")
	@Override
	public UserDTO getUserByIdPost(UserDTO user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(123456L);
		userDTO.setName("test-测试-post");
		return userDTO;
	}
	
	@POST
	@Path("getUserByPostFrom")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public UserDTO getUserByPostForm(@BeanParam UserDTO user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(123456L);
		userDTO.setName("test-测试-post");
		if(user.getId() != 0){
			userDTO.setId(user.getId());
		}
		if(!"".equals(user.getName())){
			userDTO.setName(user.getName());
		}
		return userDTO;
	}
	
	@POST
	@Path("getUserByPostFrom1")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Override
	public UserDTO getUserByPostForm(@FormParam("id") long id,@FormParam("user_name") String userName) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(123456L);
		userDTO.setName("test-测试-post");
		if(id != 0){
			userDTO.setId(id);
		}
		if(!"".equals(userName)){
			userDTO.setName(userName);
		}
		return userDTO;
	}
	
	@GET
	@Path("confirmUser")
	@Override
	public String confirmUser(@DefaultValue("0") @QueryParam("user_id")long userId,@DefaultValue("") @QueryParam("user_name")String userName){
		String ss = userId+"";
		ss = ss + userName;
		return ss;
	}
	
	
	@GET
	@Path("searchBarcode")
	@Override
	public Paging<MdBarcodeDTO> searchBarcodes(@DefaultValue("") @QueryParam("size")String size,@DefaultValue("") @QueryParam("materialNo")String materialNo,@DefaultValue("") @QueryParam("code")String code){
		Paging<MdBarcodeDTO> paging = new Paging<MdBarcodeDTO>();
		List<MdBarcode> listInfo = mdBarcodeService.searchById(code);
		List<MdBarcodeDTO> list = new ArrayList<MdBarcodeDTO>();
		for(MdBarcode info : listInfo){
			MdBarcodeDTO dto = new MdBarcodeDTO();
			try {
				BeanUtils.copyProperties(dto,info);
				list.add(dto);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		paging.setData(list);
		paging.setTotal(list.size());
		return paging;
	}

	public void setMdBarcodeService(MdBarcodeService mdBarcodeService) {
		this.mdBarcodeService = mdBarcodeService;
	}
	
	

}