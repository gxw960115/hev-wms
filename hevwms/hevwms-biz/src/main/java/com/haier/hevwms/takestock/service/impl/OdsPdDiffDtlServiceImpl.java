package com.haier.hevwms.takestock.service.impl;

import java.util.List;

import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.hevwms.takestock.dao.OdsPdDiffDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.hevwms.takestock.service.OdsPdDiffDtlService;

/**
* @ClassName: OdsPdDiffDtlServiceImpl
* @Description: 库存盘点 差异明细 相关功能
* @author songyinglong
* @Date 2015-10-30 下午3:18:24
*/
public class OdsPdDiffDtlServiceImpl implements OdsPdDiffDtlService{
	private OdsPdDiffDtlDAO odsPdDiffDtlDAO;//dao层接口
	
	/**
	* <p>Title: createOdsPdDiffDtl</p>
	* <p>Description: 创建 库存盘点明细差异 记录</p>
	* @param odsPdDiffDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#createOdsPdDiffDtl(com.haier.hevwms.takestock.domain.OdsPdDiffDtl)
	*/
	@Override
	public ExecuteResult<OdsPdDiffDtl> createOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl){
		ExecuteResult<OdsPdDiffDtl> executeResult = new ExecuteResult<OdsPdDiffDtl>();
		
		odsPdDiffDtlDAO.save(odsPdDiffDtl);
		executeResult.setResult(odsPdDiffDtl);
		return executeResult;
	}
	
	/**
	* <p>Title: updateOdsPdDiffDtl</p>
	* <p>Description: 更新 库存盘点 差异明细</p>
	* @param odsPdDiffDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#updateOdsPdDiffDtl(com.haier.hevwms.takestock.domain.OdsPdDiffDtl)
	*/
	public ExecuteResult<OdsPdDiffDtl> updateOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl){
		ExecuteResult<OdsPdDiffDtl> executeResult = new ExecuteResult<OdsPdDiffDtl>();
		
		odsPdDiffDtlDAO.update(odsPdDiffDtl);
		executeResult.setResult(odsPdDiffDtl);
		return executeResult;
	}
	
	/**
	* <p>Title: deleteOdsPdDiffDtl</p>
	* <p>Description: 删除 库存盘点 差异明细 记录</p>
	* @param odsPdDiffDtlId
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#deleteOdsPdDiffDtl(java.lang.Long)
	*/
	public ExecuteResult<OdsPdDiffDtl> deleteOdsPdDiffDtl(Long odsPdDiffDtlId){
		ExecuteResult<OdsPdDiffDtl> executeResult = new ExecuteResult<OdsPdDiffDtl>();
		
		odsPdDiffDtlDAO.delete(odsPdDiffDtlId);
		return executeResult;
	}
	/**
	* <p>Title: deleteOdsPdDiffDtlAll</p>
	* <p>Description:删除全部的 库存盘点 差异明细 记录 </p>
	* @param idList
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#deleteOdsPdDiffDtlAll(java.util.List)
	*/
	public ExecuteResult<OdsPdDiffDtl> deleteOdsPdDiffDtlAll(List<Long> idList){
		ExecuteResult<OdsPdDiffDtl> executeResult = new ExecuteResult<OdsPdDiffDtl>();
		
		odsPdDiffDtlDAO.deleteAll(idList);
		return executeResult;
	}
	/**
	* <p>Title: searchOdsPdDiffDtls</p>
	* <p>Description: 查询 库存盘点 差异明细</p>
	* @param pager
	* @param odsPdDiffDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#searchOdsPdDiffDtls(com.haier.openplatform.util.Pager, com.haier.hevwms.takestock.domain.OdsPdDiffDtl)
	*/
	public Pager<OdsPdDiffDtl> searchOdsPdDiffDtls(Pager<OdsPdDiffDtl> pager, OdsPdDiffDtl odsPdDiffDtl){
		List<OdsPdDiffDtl> odsPdDiffDtls = odsPdDiffDtlDAO.searchOdsPdDiffDtls(pager, odsPdDiffDtl);
		long size = odsPdDiffDtlDAO.searchOdsPdDiffDtlsCount(odsPdDiffDtl);
		return Pager.cloneFromPager(pager, size, odsPdDiffDtls);
	}
	
	@Override
	public Long searchOdsPdDiffDtlsCount(OdsPdDiffDtl dtl) {
		return odsPdDiffDtlDAO.searchOdsPdDiffDtlsCount(dtl);
	}
	
	/**
	* <p>Title: getOdsPdDiffDtl</p>
	* <p>Description: 返回 库存盘点差异明细 对象 集合</p>
	* @param odsPdDiffDtl
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#getOdsPdDiffDtl(com.haier.hevwms.takestock.domain.OdsPdDiffDtl)
	*/
	public List<OdsPdDiffDtl> getOdsPdDiffDtl(OdsPdDiffDtl odsPdDiffDtl){
		return odsPdDiffDtlDAO.getOdsPdDiffDtl(odsPdDiffDtl);
	}
	
	/**
	* <p>Title: getOdsPdDiffDtlById</p>
	* <p>Description: 返回 库存盘点差异明细 对象 </p>
	* @param odsPdDiffDtlId
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#getOdsPdDiffDtlById(java.lang.Long)
	*/
	public OdsPdDiffDtl getOdsPdDiffDtlById(Long odsPdDiffDtlId){
		return odsPdDiffDtlDAO.get(odsPdDiffDtlId);
	}
	
	/**
	* <p>Title: getOdsPdDiffDtls</p>
	* <p>Description:返回全部的 库存盘点差异明细 对象 集合 </p>
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdDiffDtlService#getOdsPdDiffDtls()
	*/
	public List<OdsPdDiffDtl> getOdsPdDiffDtls(){
		return odsPdDiffDtlDAO.getAll();
	}
	
	/**
	* @Title: setOdsPdDiffDtlDAO
	* @Description: setter 方法
	* @param @param odsPdDiffDtlDAO
	* @return void
	* @throws
	*/
	public void setOdsPdDiffDtlDAO(OdsPdDiffDtlDAO odsPdDiffDtlDAO){
		this.odsPdDiffDtlDAO = odsPdDiffDtlDAO;
	}
	/**
	* @Title: getOdsPdDiffDtlDAO
	* @Description: getter方法
	* @param @return
	* @return OdsPdDiffDtlDAO
	* @throws
	*/
	public OdsPdDiffDtlDAO getOdsPdDiffDtlDAO(){
		return odsPdDiffDtlDAO;
	}
}
