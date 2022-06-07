package com.haier.hevwms.sto.dao;

import com.haier.hevwms.remoting.rf.domain.order.WmsOrderDeleteIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpIn;
import com.haier.hevwms.remoting.rf.domain.order.WmsOrderIgpOut;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderDeleteOutDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import com.haier.openplatform.wms.sto.dto.OdsStoCustScanInfoDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Title:  OdsStoCustScanInfoDAO.java
 * @Description:TODO(用一句话描述该文件做什么)
 * @author: zhangll
 * @date:   2018年12月18日
 * @version V1.0
 */
public interface OdsStoCustScanInfoDAO extends CommonDAO<OdsStoCustScanInfoDTO, Long> {

    
    public List<OdsStoCustScanInfoDTO> searchOdsStoCustScanInfoByPage(@Param("pager")
                                                                      Pager<OdsStoCustScanInfoDTO> pager, @Param("odsStoCustScanInfo") OdsStoCustScanInfoDTO dto);
    
    /**
     * @title: searchOdsStoCustScanInfoCount
     * @description: 条件统计数量 
     * @author: ZhangLL
     * @param dto
     * @return: Long
     */
    public Long searchOdsStoCustScanInfoCount(@Param("odsStoCustScanInfo") OdsStoCustScanInfoDTO dto);
    
    /**
     * @title: getListByParam
     * @description: 条件查询
     * @author: ZhangLL
     * @param dto
     * @return: List<OdsStoCustScanInfoDTO>
     */
    public List<OdsStoCustScanInfoDTO> getListByParam(@Param("odsStoCustScanInfo") OdsStoCustScanInfoDTO dto);
    
    public void updateStodnInfo(@Param("odsStoCustScanInfo") OdsStoCustScanInfoDTO dto);

    /**
     * @Title: getListByParams
     * @Description: 手持查询详细列表
     * @author: ZhangLL
     * @param odsCustomerScanInfo
     * @return List<OdsStoCustScanInfoDTO>
     * @throws
     */
    public List<OdsStoCustScanInfoDTO> getListByParams(@Param("odsStoScanInfoDTO") OdsStoCustScanInfoDTO odsStoCustScanInfoDTO);

    /**
     * @Title: orderScan
     * @Description: 手持扫描
     * @author: ZhangLL
     * @param inpara
     * @param result void
     * @throws
     */
    public void orderScanIn(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);
    /**
     * @Title: orderScan
     * @Description: 手持扫描
     * @author: ZhangLL
     * @param inpara
     * @param result void
     * @throws
     */
    public void orderScanOut(@Param("inpara") OrderUploadInDTO inpara, @Param("result") OrderUploadOutDTO result);

    /**
     * @Title: deleteCustomerByBarcode
     * @Description: 手持根据条码删除
     * @author: ZhangLL
     * @param inpara
     * @param result void
     * @throws
     */
    public void deleteScanInfoByBarcode(@Param("in") WmsOrderDeleteIn in, @Param("out") OrderDeleteOutDTO out);

    /**
     * @Title: orderOgp
     * @Description: 出库
     * @author: ZhangLL
     * @param in
     * @param out void
     * @throws
     */
    public void orderOgp(@Param("in") WmsOrderIgpIn in, @Param("out") WmsOrderIgpOut out);
}