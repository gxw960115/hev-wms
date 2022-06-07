package com.haier.hevwms.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.order.dto.OdsTransferInventoryDTO;

public interface OdsTransferInventoryDAO extends CommonDAO<OdsTransferInventoryDTO, Long> {

    public String selectTransferInventoryOrderNo(@Param("dateString") String dateString);
    
    //创建移库单时应该验证当前plant,location下不应该存在没删除，没结束的移库单
    public Integer quertTransCountByParam(@Param("odsTransferInventoryDTO") OdsTransferInventoryDTO odsTransferInventoryDTO);
    
    public List<OdsTransferInventoryDTO> searchTransInventoryInfos(@Param("pager") Pager<OdsTransferInventoryDTO> pager,
    		@Param("odsTransferInventoryDTO") OdsTransferInventoryDTO odsTransferInventoryDTO);
    
    public Long searchOdsTransInfosCount(@Param("odsTransferInventoryDTO") OdsTransferInventoryDTO odsTransferInventoryDTO);

	public void updateTransOrderStatus(@Param("odsTransferInventoryDTO")OdsTransferInventoryDTO odsTransferInventoryDTO);

	public List<OdsTransferInventoryDTO> getList(@Param("odsTransferInventoryDTO")OdsTransferInventoryDTO odsTransferInventoryDTO);
	
	public List<OdsTransferInventoryDTO> getListByNo(@Param("odsTransferInventoryDTO")OdsTransferInventoryDTO odsTransferInventoryDTO);
	
	//进入过账先设定过账失败
	public void updateErrorNoNotSuc(@Param("odsTransferInventoryDTO") OdsTransferInventoryDTO odsTransferInventoryDTO);

	//过账成功更新
	public void updatePostSuccess(@Param("odsTransferInventoryDTO")OdsTransferInventoryDTO odsTransferInventoryDTO);
}