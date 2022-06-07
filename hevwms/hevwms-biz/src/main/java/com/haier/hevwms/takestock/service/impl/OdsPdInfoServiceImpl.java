package com.haier.hevwms.takestock.service.impl;

import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.inventory.dao.OdsInventoryInfoDtlDAO;
import com.haier.hevwms.inventory.domain.OdsInventoryInfoDtl;
import com.haier.hevwms.remoting.rf.dao.OtcwmsOrderCheckDAO;
import com.haier.hevwms.security.dao.UserDAO;
import com.haier.hevwms.takestock.dao.OdsPdDiffDtlDAO;
import com.haier.hevwms.takestock.dao.OdsPdInfoDAO;
import com.haier.hevwms.takestock.dao.OdsPdInfoDtlDAO;
import com.haier.hevwms.takestock.domain.OdsPdDiffDtl;
import com.haier.hevwms.takestock.domain.OdsPdInfo;
import com.haier.hevwms.takestock.domain.OdsPdInfoDtl;
import com.haier.hevwms.takestock.service.OdsPdInfoService;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderCheckOutDTO;
import com.haier.openplatform.wms.security.dto.UserDTO;

import io.terminus.pampas.common.UserUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
* @ClassName: OdsPdInfoServiceImpl
* @Description: 通过调用dao层，处理 库存盘点单相关 具体业务逻辑
* @author linzongxiao
* @Date 2015-10-30 下午2:41:05
*/
public class OdsPdInfoServiceImpl implements OdsPdInfoService {
	
    private Logger logger = Logger.getLogger(OdsPdInfoServiceImpl.class);
	private OdsPdInfoDAO odsPdInfoDAO;
	private OdsPdInfoDtlDAO odsPdInfoDtlDAO;
	private OdsPdDiffDtlDAO odsPdDiffDtlDAO;
	private OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO;
	private UserDAO userDAO;
	private MdMatInfoDAO mdMatInfoDAO;
	private OtcwmsOrderCheckDAO otcwmsOrderCheckDAO;
	
	
	public OtcwmsOrderCheckDAO getOtcwmsOrderCheckDAO() {
		return otcwmsOrderCheckDAO;
	}
	public void setOtcwmsOrderCheckDAO(OtcwmsOrderCheckDAO otcwmsOrderCheckDAO) {
		this.otcwmsOrderCheckDAO = otcwmsOrderCheckDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public MdMatInfoDAO getMdMatInfoDAO() {
		return mdMatInfoDAO;
	}
	public void setMdMatInfoDAO(MdMatInfoDAO mdMatInfoDAO) {
		this.mdMatInfoDAO = mdMatInfoDAO;
	}
	/**
	* <p>Title: createOdsPdInfo</p>
	* <p>Description: 新增库存盘点单</p>
	* @param odsPdInfo
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#createOdsPdInfo(com.haier.hevwms.takestock.domain.OdsPdInfo)
	*/
	@Override
	public String createOdsPdInfo(OdsPdInfo odsPdInfo) {
		OdsPdInfo pdInfo=new OdsPdInfo();
		pdInfo.setPlant(odsPdInfo.getPlant());
		pdInfo.setLocation(odsPdInfo.getLocation());
		pdInfo.setMaterialNo(odsPdInfo.getMaterialNo());
		pdInfo.setBin(odsPdInfo.getBin());
		int pdNum=odsPdInfoDAO.quertPdCountByParam(pdInfo);
		if (pdNum>0) {
			return "there has existed stocking order at :"+pdInfo.getPlant()
                    +","+pdInfo.getLocation()+","+pdInfo.getMaterialNo();
		}
		odsPdInfoDAO.save(odsPdInfo);
		return "SUCCESS";
	}

	/**
	* <p>Title: updateOdsPdInfo</p>
	* <p>Description: 编辑库存盘点信息</p>
	* @param odsPdInfo
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#updateOdsPdInfo(com.haier.hevwms.takestock.domain.OdsPdInfo)
	*/
	public ExecuteResult<OdsPdInfo> updateOdsPdInfo(OdsPdInfo odsPdInfo) {
		ExecuteResult<OdsPdInfo> executeResult = new ExecuteResult<OdsPdInfo>();

		odsPdInfoDAO.update(odsPdInfo);
		executeResult.setResult(odsPdInfo);
		return executeResult;
	}

	/**
	* <p>Title: deleteOdsPdInfo</p>
	* <p>Description: 按库存盘点单单号，进行删除p>
	* @param odsPdInfoId
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#deleteOdsPdInfo(java.lang.Long)
	*/
	public ExecuteResult<OdsPdInfo> deleteOdsPdInfo(Long odsPdInfoId) {
		ExecuteResult<OdsPdInfo> executeResult = new ExecuteResult<OdsPdInfo>();

		odsPdInfoDAO.delete(odsPdInfoId);
		return executeResult;
	}

	/**
	* <p>Title: deleteOdsPdInfoAll</p>
	* <p>Description: 删除所有的库存盘点单</p>
	* @param idList
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#deleteOdsPdInfoAll(java.util.List)
	*/
	public ExecuteResult<OdsPdInfo> deleteOdsPdInfoAll(List<Long> idList) {
		ExecuteResult<OdsPdInfo> executeResult = new ExecuteResult<OdsPdInfo>();
		odsPdInfoDAO.deleteAll(idList);
		return executeResult;
	}

	/**
	* <p>Title: searchOdsPdInfos</p>
	* <p>Description: 查询库存盘点单</p>
	* @param pager 分页相关的信息，主要是rows:每页的记录数   page:当前页
	* @param odsPdInfo
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#searchOdsPdInfos(com.haier.openplatform.util.Pager, com.haier.hevwms.takestock.domain.OdsPdInfo)
	*/
	public Pager<OdsPdInfo> searchOdsPdInfos(Pager<OdsPdInfo> pager,
			OdsPdInfo odsPdInfo) {
		List<OdsPdInfo> odsPdInfos = odsPdInfoDAO.searchOdsPdInfos(pager,
				odsPdInfo);
		long size = odsPdInfoDAO.searchOdsPdInfosCount(odsPdInfo);
		return Pager.cloneFromPager(pager, size, odsPdInfos);
	}

	/**
	* <p>Title: getOdsPdInfoById</p>
	* <p>Description: 根据 库存盘点单单号 ，返回库存盘点单 实体对象</p>
	* @param odsPdInfoId
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#getOdsPdInfoById(java.lang.Long)
	*/
	public OdsPdInfo getOdsPdInfoById(Long odsPdInfoId) {
		return odsPdInfoDAO.get(odsPdInfoId);
	}

	/**
	* <p>Title: getOdsPdInfos</p>
	* <p>Description: 返回库存盘点单 实体对象  集合</p>
	* @param odsPdInfo
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#getOdsPdInfos(com.haier.hevwms.takestock.domain.OdsPdInfo)
	*/
	public List<OdsPdInfo> getOdsPdInfos(OdsPdInfo odsPdInfo) {
	    logger.debug("Entering getOdsPdInfos...");
		return odsPdInfoDAO.getListByParams(odsPdInfo);
	}

	/**
	* @Title: setOdsPdInfoDAO
	* @Description: setter方法
	* @param @param odsPdInfoDAO
	* @return void
	* @throws
	*/
	public void setOdsPdInfoDAO(OdsPdInfoDAO odsPdInfoDAO) {
		this.odsPdInfoDAO = odsPdInfoDAO;
	}

	/**
	* @Title: getOdsPdInfoDAO
	* @Description: getter方法
	* @param @return
	* @return OdsPdInfoDAO
	* @throws
	*/
	public OdsPdInfoDAO getOdsPdInfoDAO() {
		return odsPdInfoDAO;
	}

	/**
	* <p>Title: findPdNo</p>
	* <p>Description:返回 库存盘点单 单号 </p>
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#findPdNo()
	*/
	@Override
	public String findPdNo() {
		String dataFat = DataFormat.formatDate(new Date(), "yyMMdd");
		OdsPdInfo temp = new OdsPdInfo();
		temp.setOrderNo(dataFat);
		temp.setFlag("0");
		List<OdsPdInfo> list = odsPdInfoDAO.getListByParams(temp);
		if (list.size() <= 0) {
			return dataFat + "0001";
		} else {
			String planNo = list.get(0).getOrderNo();
			int no = Integer.parseInt(planNo.substring(6, 10)) + 1;
			// 0 代表前面补充0
			// 3 代表长度为3
			// d 代表参数为正数型
			String str = String.format("%04d", no);
			return dataFat + str;
		}
	}

	/**
	* <p>Title: saveOdsPds</p>
	* <p>Description: 新增库存盘点单并保存</p>
	* @param odsPdInfo
	* @param odsPdInfos
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#saveOdsPds(com.haier.hevwms.takestock.domain.OdsPdInfo, java.util.List)
	*/
	@Override
	public ExecuteResult<OdsPdInfo> saveOdsPds(OdsPdInfo odsPdInfo,
			List<OdsPdInfo> odsPdInfos) {
		ExecuteResult<OdsPdInfo> executeResult = new ExecuteResult<OdsPdInfo>();
		for (OdsPdInfo temp : odsPdInfos) {
			temp.setOrderNo(odsPdInfo.getOrderNo());
			temp.setWarehouseCode(odsPdInfo.getWarehouseCode());
			temp.setWarehouseName(odsPdInfo.getWarehouseName());
			temp.setPlant(odsPdInfo.getPlant());
			temp.setCreateBy(odsPdInfo.getCreateBy());
			temp.setCreateDate(new Date());
			temp.setOrderStatus("0");
			odsPdInfoDAO.save(temp);
		}
		executeResult.setResult(odsPdInfo);
		return executeResult;
	}
	
	
	@Override
    public List<OdsPdInfo> getOdsPdInfo(OdsPdInfo odsPdInfo) {
	    return odsPdInfoDAO.getListByParams(odsPdInfo);
    }
	
	@Transactional(rollbackFor=Exception.class)
	@Override
    public ExecuteResult<OdsPdInfo> deleteOrder(OdsPdInfo odsPdInfo){
		logger.debug("盘点单删除Start[逻辑删]，先删除盘点单，order_status置为4，pd_no:"+odsPdInfo.getOrderNo()
						+",order_status:"+odsPdInfo.getOrderStatus()+",时间："+new Date());
	    ExecuteResult<OdsPdInfo> executeResult = new ExecuteResult<OdsPdInfo>();
        odsPdInfo.setModifyDate(new Date());
        odsPdInfo.setModifyBy(UserUtil.getCurrentUser().getName());
        Integer delPDNum=odsPdInfoDAO.updateOrderStatus(odsPdInfo);//对 盘点单 进行逻辑删除
        logger.debug("盘点单成功删除"+delPDNum+"个，开是删除盘点明细【逻辑删】,时间："+new Date());
        OdsPdInfoDtl odsPdInfoDtl=new OdsPdInfoDtl();
        odsPdInfoDtl.setModifyBy(UserUtil.getCurrentUser().getName());
        odsPdInfoDtl.setModifyDate(new Date());
        odsPdInfoDtl.setStatus("1");
        odsPdInfoDtl.setOrderNo(odsPdInfo.getOrderNo());
        Integer delPDDelNum=odsPdInfoDtlDAO.updateStatus(odsPdInfoDtl);//对 盘点明细 进行逻辑删除
        executeResult.setSuccessMessage("success");
        logger.debug("盘点明细成功删除"+delPDDelNum+"个,盘点单删除End，时间："+new Date());
        executeResult.setResult(odsPdInfo);
        return executeResult;
    }
	
	/**
	* <p>Title: updateOrderStatus</p>
	* <p>Description:更新 库存盘点单 的 orderStatus字段 </p>
	* @param odsPdInfo
	* @return
	* @see com.haier.hevwms.takestock.service.OdsPdInfoService#updateOrderStatus(com.haier.hevwms.takestock.domain.OdsPdInfo)
	*/
	@Override
	public ExecuteResult<OdsPdInfo> updateOrderStatus(OdsPdInfo odsPdInfo) {
	    logger.debug("Entering updateOrderStatus...");
		ExecuteResult<OdsPdInfo> executeResult = new ExecuteResult<OdsPdInfo>();
		odsPdInfo.setModifyDate(new Date());
		odsPdInfoDAO.updateOrderStatus(odsPdInfo);
		
		// 如果是完成状态 生成差异信息表
		if ("2".equals(odsPdInfo.getOrderStatus())) {
		    logger.debug("Order status is 2, close order " + odsPdInfo.getOrderNo());
			// 清空差异信息表
			odsPdDiffDtlDAO.deleteByPdNo(odsPdInfo.getOrderNo());
			OdsPdInfo temp = new OdsPdInfo();
			temp.setOrderNo(odsPdInfo.getOrderNo());
			// 获取盘点单明细
			List<OdsPdInfo> pdInfos = getOdsPdInfos(temp);
			logger.debug("The size of pdInfos: " + pdInfos.size());
			String matScanType = "CBU";
			for (OdsPdInfo pd : pdInfos) {
				List<OdsPdInfoDtl> pdDtls = odsPdInfoDtlDAO.getDiff(pd);
				logger.debug("The size of pdDtls: " + pdDtls.size());
				if (!"ALL".equals(pd.getMaterialNo())) {
					MdMatInfoDTO mat = mdMatInfoDAO.getMdMatInfoByMaterialNo(pd.getMaterialNo());
					if (mat != null){
						matScanType = mat.getMatScanType();
					}
				}
				if (!"SKU".equalsIgnoreCase(matScanType)){
					String binList = pd.getBin();
					for (OdsPdInfoDtl odsPdInfoDtl : pdDtls) {
						String pdBin = odsPdInfoDtl.getPdBin();
						String inveBin = odsPdInfoDtl.getInveBin();
						/**
						 * inveBin和pdBin有4种情况(不会同时为空,数据库字段Bin已做非空校验)
						 * pdBin不为空,inveBin为空  盘盈==>>状态0
						 * pdBin不为空,inveBin不为空,但两个库位不同,库位不对==>>状态2
						 * pdBin为空,inveBin不为空,盘亏==>>状态1
						 * pdBin不为空, inveBin不为空,两个库位相同,不做处理
						 */
						if (StringUtils.isNotBlank(pdBin)) {
							if(!pdBin.equals(inveBin)){
								//盘盈
								OdsPdInfoDtl pdDtl = odsPdInfoDtlDAO.get(odsPdInfoDtl.getRowId());
								OdsPdDiffDtl diff = new OdsPdDiffDtl();
								diff.setBarcode(pdDtl.getBarcode());
								diff.setCreateBy(odsPdInfo.getModifyBy());
								diff.setCreateDate(new Date());
								if (StringUtils.isBlank(inveBin)) {
									diff.setDiffType("0");//盘盈
								} else {
									diff.setDiffType("2");//库位不等
								}
								diff.setLocation(pdDtl.getLocation());
								diff.setMaterialDesp(pdDtl.getMaterialDesp());
								diff.setMaterialNo(pdDtl.getMaterialNo());
								diff.setOrderNo(pdDtl.getOrderNo());
								diff.setPlant(pdDtl.getPlant());
								diff.setProcessFlag("0");
								diff.setQty(pdDtl.getQty() - odsPdInfoDtl.getInveQty());
								diff.setUnit(pdDtl.getUnit());
								diff.setInoutDate(new Date());
								diff.setModifyDate(new Date());
								odsPdDiffDtlDAO.save(diff);
							}
						} else {
							if (StringUtils.isNotBlank(inveBin) && ("ALL".equalsIgnoreCase(binList) || binList.indexOf(inveBin) != -1)) {
								// 盘亏
								OdsInventoryInfoDtl inve = odsInventoryInfoDtlDAO.get(odsPdInfoDtl.getInveRowId());
								OdsPdDiffDtl diff = new OdsPdDiffDtl();
								diff.setBarcode(inve.getBarcode());
								diff.setCreateBy(odsPdInfo.getModifyBy());
								diff.setCreateDate(new Date());
								diff.setDiffType("1");
								diff.setLocation(inve.getLocation());
								diff.setMaterialDesp(inve.getMaterialDesp());
								diff.setMaterialNo(inve.getMaterialNo());
								diff.setOrderNo(odsPdInfo.getOrderNo());
								diff.setPlant(inve.getPlant());
								diff.setProcessFlag("0");
								diff.setQty(inve.getQty() - odsPdInfoDtl.getQty());
								diff.setUnit(inve.getUnit());
								diff.setInoutDate(inve.getCreateDate());
								diff.setModifyDate(new Date());
								odsPdDiffDtlDAO.save(diff);
							}
						} 
					}
				} else {
					for (OdsPdInfoDtl odsPdInfoDtl : pdDtls) {
						Long qty = odsPdInfoDtl.getQty();
						Long inveQty = odsPdInfoDtl.getInveQty();
						/**
						 * 礼物bin统一为GIFT，只有3种情况
						 * 扫描数量>库存数量  盘盈==>>状态0
						 * 扫描数量<库存数量 盘亏==>>状态1
						 * 扫描数量=库存数量 不做处理
						 */
						if (qty > inveQty){
							//盘盈
							OdsPdInfoDtl pdDtl = odsPdInfoDtlDAO.get(odsPdInfoDtl.getRowId());
							OdsPdDiffDtl diff = new OdsPdDiffDtl();
							diff.setBarcode(pdDtl.getBarcode());
							diff.setCreateBy(odsPdInfo.getModifyBy());
							diff.setCreateDate(new Date());
							diff.setDiffType("0");
							diff.setLocation(pdDtl.getLocation());
							diff.setMaterialDesp(pdDtl.getMaterialDesp());
							diff.setMaterialNo(pdDtl.getMaterialNo());
							diff.setOrderNo(pdDtl.getOrderNo());
							diff.setPlant(pdDtl.getPlant());
							diff.setProcessFlag("0");
							diff.setQty(qty - inveQty);
							diff.setUnit(pdDtl.getUnit());
							diff.setInoutDate(new Date());
							diff.setModifyDate(new Date());
							odsPdDiffDtlDAO.save(diff);
						} else if (qty < inveQty){
							//盘亏
							OdsInventoryInfoDtl inve = odsInventoryInfoDtlDAO.get(odsPdInfoDtl.getInveRowId());
							OdsPdDiffDtl diff = new OdsPdDiffDtl();
							diff.setBarcode(inve.getBarcode());
							diff.setCreateBy(odsPdInfo.getModifyBy());
							diff.setCreateDate(new Date());
							diff.setDiffType("1");
							diff.setLocation(inve.getLocation());
							diff.setMaterialDesp(inve.getMaterialDesp());
							diff.setMaterialNo(inve.getMaterialNo());
							diff.setOrderNo(odsPdInfo.getOrderNo());
							diff.setPlant(inve.getPlant());
							diff.setProcessFlag("0");
							diff.setQty(inveQty - qty);
							diff.setUnit(inve.getUnit());
							diff.setInoutDate(inve.getCreateDate());
							diff.setModifyDate(new Date());
							odsPdDiffDtlDAO.save(diff);
						}
					}
				}
			}
		}
		executeResult.setResult(odsPdInfo);
		logger.debug("Exiting updateOrderStatus...");
		return executeResult;
	}

	/**
	* @Title: getOdsPdInfoDtlDAO
	* @Description: getter方法
	* @param @return
	* @return OdsPdInfoDtlDAO
	* @throws
	*/
	public OdsPdInfoDtlDAO getOdsPdInfoDtlDAO() {
		return odsPdInfoDtlDAO;
	}

	/**
	* @Title: setOdsPdInfoDtlDAO
	* @Description: setter方法
	* @param @param odsPdInfoDtlDAO
	* @return void
	* @throws
	*/
	public void setOdsPdInfoDtlDAO(OdsPdInfoDtlDAO odsPdInfoDtlDAO) {
		this.odsPdInfoDtlDAO = odsPdInfoDtlDAO;
	}

	public OdsPdDiffDtlDAO getOdsPdDiffDtlDAO() {
		return odsPdDiffDtlDAO;
	}

	public void setOdsPdDiffDtlDAO(OdsPdDiffDtlDAO odsPdDiffDtlDAO) {
		this.odsPdDiffDtlDAO = odsPdDiffDtlDAO;
	}

	public OdsInventoryInfoDtlDAO getOdsInventoryInfoDtlDAO() {
		return odsInventoryInfoDtlDAO;
	}

	public void setOdsInventoryInfoDtlDAO(
			OdsInventoryInfoDtlDAO odsInventoryInfoDtlDAO) {
		this.odsInventoryInfoDtlDAO = odsInventoryInfoDtlDAO;
	}
	
	/**
    * <p>Title: getStocktakingOrderNo</p>
    * <p>Description:获取stocktakingOrderNo length=10 ，从1开始自增 ，左侧 零 补位</p>
    * @return
    * @see com.haier.hevwms.takestock.service.OdsPdInfoService#getStocktakingOrderNo()
    */
    @Override
    public String selectStocktakingOrderNo() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");
        String dateString = formatter.format(currentTime);
        String sequence=odsPdInfoDAO.selectStocktakingOrderNo("");
        return dateString+sequence;//当前天+sequence eg.151112001
    }

	@Override
	public Long searchOdsPdInfosCount(OdsPdInfo odsPdInfo) {
		return odsPdInfoDAO.searchOdsPdInfosCount(odsPdInfo);
	}

	@Override
	public OrderCheckOutDTO checkPdInfo(OrderCheckInDTO dto) {
		OrderCheckOutDTO out = new OrderCheckOutDTO();
		String msg = "";
		String status = "F";
		UserDTO user = userDAO.getUserByName(dto.getUser());
		String result = odsPdInfoDAO.checkPdNoExist(dto);
		Map<String, String> wlMap = new HashMap<String, String>();
		if ("Y".equals(result)) {
			if ("3".equals(user.getDutyType())){
				result = odsPdInfoDAO.checkPdLoc(dto, user.getId());
				if (!"Y".equals(result)){
					msg = "User has no authority to scan this order!";
				}
			}
			if (StringUtils.isBlank(msg)) {
				List<String> locations=otcwmsOrderCheckDAO.getProcessPdLocation(dto.getOrno());
				StringBuffer location = new StringBuffer();
				for (int i=0;i<locations.size();i++) {
					location.append(locations.get(i));
					if(i!=(locations.size()-1)){
						location.append(",");
					}
				}
				msg = location.toString();
				status = "S";
				
				//查询库位对应的物料,库位和物料对应关系返回到前台进行验收条码的前9位是不是物料号  2018/1/19 by yanfd
				List<String> listWl = new ArrayList<String>();
				for (int i=0;i<locations.size();i++) {
					listWl = otcwmsOrderCheckDAO.getPdMat(dto.getOrno(), locations.get(i));
					StringBuffer mats = new StringBuffer();
					for (int j=0; j<listWl.size(); j++) {
						mats.append(listWl.get(j)).append(",");
					}
					wlMap.put(locations.get(i), mats.toString());
				}
				out.setWlMap(wlMap);
			}
            
		}else {
			msg = "Order doens't exist!";
		}
		out.setStatus(status);
		out.setMsg(msg);
		return out;
	}

}
