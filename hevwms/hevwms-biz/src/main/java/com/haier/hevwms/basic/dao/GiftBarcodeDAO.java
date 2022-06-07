package com.haier.hevwms.basic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;

/**
 * @param
 * @author Song Yinglong // Nicholas
 * @ClassName: MdBarcodeDAO
 * @Description:
 * @date 2015-10-26 下午4:35:58
 */
public interface GiftBarcodeDAO extends CommonDAO<GiftBarcodeDTO, Long> {
    /**
     * <p>Discription:分页查询手工生成条码表信息</p>
     *
     * @param pager,mdBarcode
     * @return List<MdBarcode>
     * @author:
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<GiftBarcodeDTO> searchGiftBarcodes(@Param("pager") Pager<GiftBarcodeDTO> pager,
                                            @Param("giftBarcode") GiftBarcodeDTO giftBarcode);

    /**
     * <p>Discription:分页查询手工生成条码表信息计数</p>
     *
     * @param mdBarcode
     * @return Long
     * @author:
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public Long searchGiftBarcodesCount(@Param("giftBarcode") GiftBarcodeDTO giftBarcode);
    
    public String selectSeq();
    
    public List<GiftBarcodeDTO> searchGiftBarcodeByMaterial(@Param("materialNo") String materialNo);


}
