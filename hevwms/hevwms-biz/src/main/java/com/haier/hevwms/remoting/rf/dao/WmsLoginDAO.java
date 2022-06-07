package com.haier.hevwms.remoting.rf.dao;

import com.haier.hevwms.remoting.rf.domain.login.Location;
import com.haier.hevwms.remoting.rf.domain.login.Menu;
import com.haier.hevwms.remoting.rf.domain.login.UserWarehouse;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.wms.security.dto.UserDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* @ClassName: WmsLoginDAO
* @Description: (这里用一句话描述这个类的作用)
* @author Administrator
*
*/
public interface WmsLoginDAO extends CommonDAO<Object, Long>{
	/**
	 * <p>Discription:[根据用户名获取用户信息]</p>
	 * @param name
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public UserDTO getRfUserByName(@Param("name")String name);
	/**
	 * <p>Discription:[查询用户仓库编码]</p>
	 * @param userid
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public UserWarehouse getUserWarehouse(@Param("userid")Long userid);
	/**
	 * <p>Discription:[查询用户部门]</p>
	 * @param userid
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
//	public Department getUserDepartment(@Param("userid")Long userid);
	/**
	 * <p>Discription:[查询用户仓储区域]</p>
	 * @param userid
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public List<Location> getUserLocation(@Param("userid")Long userid);
	/**
	 * <p>Discription:[查询用户仓储区域]</p>
	 * @param userid
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public List<Location> getUserLocationWH(@Param("userid")Long userid);
	/**
	 * <p>Discription:[查询用户手持菜单]</p>
	 * @param userid
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public List<Menu> getUserMenu(@Param("userid")Long userid);
	/**
	 * <p>Discription:[查询用户类别]</p>
	 * @param userid
	 * @return
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	public String getUserType(@Param("userid")Long userid);
}
