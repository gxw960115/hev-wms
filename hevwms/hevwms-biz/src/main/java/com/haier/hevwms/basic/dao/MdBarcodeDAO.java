package com.haier.hevwms.basic.dao;

import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.openplatform.dao.CommonDAO;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @param
 * @author Song Yinglong // Nicholas
 * @ClassName: MdBarcodeDAO
 * @Description:
 * @date 2015-10-26 下午4:35:58
 */
public interface MdBarcodeDAO extends CommonDAO<MdBarcode, Long> {
    /**
     * <p>Discription:分页查询手工生成条码表信息</p>
     *
     * @param pager,mdBarcode
     * @return List<MdBarcode>
     * @author:
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public List<MdBarcode> searchMdBarcodes(@Param("pager") Pager<MdBarcode> pager,
                                            @Param("mdBarcode") MdBarcode mdBarcode);

    /**
     * <p>Discription:分页查询手工生成条码表信息计数</p>
     *
     * @param mdBarcode
     * @return Long
     * @author:
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public Long searchMdBarcodesCount(@Param("mdBarcode") MdBarcode mdBarcode);

    /**
     * <p>Discription:更新多条手工生成条码表信息</p>
     *
     * @param idList
     * @return void
     * @author:
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public void update(@Param("idList") List<Long> idList, @Param("stNo") String stNo);

    /**
     * <p>Discription:[获取流水号stNo]</p>
     *
     * @return
     * @author:[张帆]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public Long searchMdBarcodesStNo();

    /**
     * <p>Discription:[查询条码累计生成数量]</p>
     *
     * @return
     * @author:[张帆]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public Integer searchMdBarcodesHisNum();

    /**
     * <p>Discription:更新条码累计生成数量</p>
     *
     * @param hisNum
     * @param sumNum
     * @return void
     * @author:
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    public Integer updateBarcodesHisNum(@Param("hisNum") String hisNum, @Param("sumNum") Integer sumNum);

    /**
     * @param userId
     * @return
     */
    public List<MdBarcode> selectByOrderId(@Param("userId") String userId);

    /**
     * 查询序列
     *
     * @return 返回类型
     * @throws
     * @Title: selectSeq
     * @Description: (查询生成code)
     */
    public String selectSeq();

    public int existBarcode(@Param("barcode") String barcode);

    public void insertBarcode(@Param("barcode") String barcode);

    /**
     * @param inpara
     * @param result void
     * @throws
     * @Title: modifyBarcodeBin
     * @Description: 修改bin
     * @author: ZhangLL
     */
    public void modifyBarcodeBin(@Param("in") OrderUploadInDTO inpara, @Param("out") OrderUploadOutDTO result);

    /**
     * @param inpara
     * @param result void
     * @throws
     * @Title: initUserPlantAndLoc
     * @Description: 初始化plant和location
     * @author: ZhangLL
     */
    public void initUserPlantAndLoc(@Param("in") OrderUploadInDTO inpara, @Param("out") OrderUploadOutDTO result);

}
