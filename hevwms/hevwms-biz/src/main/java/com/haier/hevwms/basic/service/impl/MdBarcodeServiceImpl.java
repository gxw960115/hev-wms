package com.haier.hevwms.basic.service.impl;

import com.haier.hevwms.basic.dao.GiftBarcodeDAO;
import com.haier.hevwms.basic.dao.MdBarcodeDAO;
import com.haier.hevwms.basic.dao.MdMatInfoDAO;
import com.haier.hevwms.basic.domain.MdBarcode;
import com.haier.hevwms.basic.service.MdBarcodeService;
import com.haier.openplatform.showcase.util.Env;
import com.haier.openplatform.util.ExecuteResult;
import com.haier.openplatform.util.Pager;
import com.haier.openplatform.wms.basicdata.dto.GiftBarcodeDTO;
import com.haier.openplatform.wms.basicdata.dto.MdMatInfoDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadInDTO;
import com.haier.openplatform.wms.remoting.dto.OrderUploadOutDTO;

import org.apache.log4j.Logger;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Calendar;
import java.util.List;

/**
 * @author liujiazhen
 * @description 增加类注释
 */

public class MdBarcodeServiceImpl implements MdBarcodeService {
    Logger logger = Logger.getLogger(MdBarcodeServiceImpl.class);
    private MdBarcodeDAO mdBarcodeDAO;
    private MdMatInfoDAO mdMatInfoDAO;
    private GiftBarcodeDAO giftBarcodeDAO;

    /**
     * <p>Discription:[创建条码]</p>
     *
     * @param mdBarcodeList
     * @return
     * @author:[zh-fan]
     * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
     */
    @Override
    public ExecuteResult<MdBarcode> createMdBarcode(List<MdBarcode> mdBarcodeList) {
        ExecuteResult<MdBarcode> executeResult = new ExecuteResult<MdBarcode>();
        //保存
        for (MdBarcode mdBar : mdBarcodeList) {
            mdBarcodeDAO.save(mdBar);
        }
        return executeResult;
    }

    /**
     * <p>Discription:[查询条码累计生成数量]</p>
     *
     * @return
     * @author:[张帆]
     */
    @Override
    public Integer searchMdBarcodesHisNum() {
        return mdBarcodeDAO.searchMdBarcodesHisNum();
    }

    /**
     * <p>Discription:更新条码累计生成数量</p>
     *
     * @param hisNum
     * @param sumNum
     * @return void
     */
    @Override
    public Integer updateBarcodesHisNum(Integer hisNum, Integer sumNum) {
        //更新历史生成数量
        return mdBarcodeDAO.updateBarcodesHisNum(hisNum.toString(), sumNum);
    }

    /**
     * <p>Discription:[更新条码流水号]</p>
     *
     * @param idList
     * @param stNo
     * @return
     * @author:[zh-fan]
     */
    @Override
    public ExecuteResult<MdBarcode> updateMdBarcode(List<Long> idList, String stNo) {
        ExecuteResult<MdBarcode> executeResult = new ExecuteResult<MdBarcode>();
        mdBarcodeDAO.update(idList, stNo);
        return executeResult;
    }

    @Override
    public Pager<MdBarcode> searchMdBarcodes(Pager<MdBarcode> pager, MdBarcode mdBarcode) {
        List<MdBarcode> mdBarcodes = mdBarcodeDAO.searchMdBarcodes(pager, mdBarcode);
        long size = mdBarcodeDAO.searchMdBarcodesCount(mdBarcode);
        return Pager.cloneFromPager(pager, size, mdBarcodes);
    }

    @Override
    public List<MdBarcode> searchById(String userId) {
        List<MdBarcode> list = mdBarcodeDAO.selectByOrderId(userId);
        return list;
    }

    /**
     * <p>Discription:[获取流水号stNo]</p>
     *
     * @return
     * @author:[张帆]
     */
    @Override
    public Long searchMdBarcodesStNo() {
        return mdBarcodeDAO.searchMdBarcodesStNo();
    }

    @Override
    public String addNewBarcodes(MdBarcode mdBarcode) {
        String flag = "S";
        BarParameters para = new BarParameters();
        String batch = mdBarcodeDAO.selectSeq();
        String materialNo = mdBarcode.getMaterialNo();
        String productLine = mdBarcode.getProductLine();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        String yearCode = (String) para.getYearCode().get(year);
        String monthCode = (String) para.getMonthCode().get(month);
        String dayCode = (String) para.getDayCode().get(day);

        for (int i = 0; i < mdBarcode.getBarcodeNum(); i++) {
            String bar = "";
            String code = mdBarcodeDAO.selectSeq();
            if (materialNo == null || "".equals(materialNo)) {
                continue;
            } else {
                bar = materialNo + "00" + productLine + yearCode + monthCode + dayCode + "00000";
                bar = bar.substring(0, 16).toUpperCase();
                code = "000" + code;
                code = code.substring(code.length() - 4, code.length());
            }
            String barcode = bar + code;
            MdBarcode mdinfo = new MdBarcode();
            mdinfo.setBarcode(barcode);
            mdinfo.setMaterialNo(materialNo);
            mdinfo.setMaterialDesp(mdBarcode.getMaterialDesp());
            mdinfo.setStNo(batch);
            mdinfo.setCreateBy(mdBarcode.getCreateBy());
            mdBarcodeDAO.save(mdinfo);
        }
        return flag;
    }

    public void setMdBarcodeDAO(MdBarcodeDAO mdBarcodeDAO) {
        this.mdBarcodeDAO = mdBarcodeDAO;
    }

    public MdBarcodeDAO getMdBarcodeDAO() {
        return mdBarcodeDAO;
    }

    /**
     * Code128 编码
     */
    @Override
    public String createMdBarcode1D(String resource, String barcode) {
        logger.debug("Entering createMdBarcode1D, resource: " + resource + ", barcode: " + barcode);
        Code128Bean bean = new Code128Bean();

        int dpi = 300;
        Double width = UnitConv.in2mm(3.0f / dpi);
        int height = 10;

        //Configure the barcode generator
        bean.setModuleWidth(width); //makes the narrow bar 
        //width exactly one pixel
        bean.setHeight(height);
        bean.doQuietZone(true);
        bean.setQuietZone(1);//两边空白区
        bean.setVerticalQuietZone(10);

        logger.debug("The width/height of image: " + width + " / " + height);

        //human readable
//        bean.setFontName("Adelphoe");
//        bean.setFontSize(3);
//        bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);

        //Open output file
        File outputFile = new File(resource);
        OutputStream out = null;
        try {
            out = new FileOutputStream(outputFile);
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, true, 0);
            bean.setMsgPosition(HumanReadablePlacement.HRP_TOP);
            bean.setFontSize(2);
            bean.setVerticalQuietZone(3);
            //Generate the barcode
            bean.generateBarcode(canvas, barcode);

            //Signal end of generation
            canvas.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resource;
    }
    //Code39 编码
    /*public String createMdBarcode1D(String resource,String barcode) {
        Code39Bean bean = new Code39Bean();

        final int dpi = 150;

        //Configure the barcode generator
        bean.setModuleWidth(UnitConv.in2mm(1.0f / dpi)); //makes the narrow bar
                                                         //width exactly one pixel
        bean.setWideFactor(3);
        bean.doQuietZone(false);

        //Open output file
        File outputFile = new File(resource);
        OutputStream out=null;
        try {
            out = new FileOutputStream(outputFile);
        } catch (FileNotFoundException e) {
            //  Auto-generated catch block
            e.printStackTrace();
        }
        try {
            //Set up the canvas provider for monochrome PNG output
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(
                    out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

            //Generate the barcode
            bean.generateBarcode(canvas, barcode);

            //Signal end of generation
            try {
                canvas.finish();
            } catch (IOException e) {
                //  Auto-generated catch block
                e.printStackTrace();
            }
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                //  Auto-generated catch block
                e.printStackTrace();
            }
        }
        return resource;
    }*/

    @Override
    public String createTempDir(String fileName) {
//        String separator = File.separator;        
        String directory = Env.getProperty(Env.BARCODE_TEMP_DIR);
        fileName += ".png";
        File f = new File(directory, fileName);
        if (f.exists()) {
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
            System.out.println(f.length());
        } else {
            Boolean flag = f.getParentFile().mkdirs();
            if (flag) {
                try {
                    // 创建新文件               
                    f.createNewFile();
                } catch (IOException e) {
                    System.out.println("创建新文件时出现了错误。。。");
                    e.printStackTrace();
                }
            }
        }
        return directory + "//" + fileName;
    }

    @Override
    public boolean existBarcode(String barcode) {
        int sum = mdBarcodeDAO.existBarcode(barcode);
        return sum > 0;
    }

    @Override
    public void insert(String barcode, String userName) {
        MdBarcode mdinfo = new MdBarcode();
        String materialNo = barcode.substring(0, 9);
        MdMatInfoDTO mat = mdMatInfoDAO.getMdMatInfoByMaterialNo(materialNo);
        mdinfo.setBarcode(barcode);
        mdinfo.setMaterialNo(materialNo);
        mdinfo.setCreateBy(userName);
        if (mat != null) {
            mdinfo.setMaterialDesp(mat.getMaterialDesp());
        }
        mdBarcodeDAO.save(mdinfo);
    }

    @Override
    public OrderUploadOutDTO modifyBarcodeBin(OrderUploadInDTO inpara) {
        OrderUploadOutDTO result = new OrderUploadOutDTO();
        mdBarcodeDAO.modifyBarcodeBin(inpara, result);
        return result;
    }

    @Override
    public OrderUploadOutDTO initUserPlantAndLoc(OrderUploadInDTO inpara) {
        OrderUploadOutDTO result = new OrderUploadOutDTO();
        mdBarcodeDAO.initUserPlantAndLoc(inpara, result);
        return result;
    }

    public MdMatInfoDAO getMdMatInfoDAO() {
        return mdMatInfoDAO;
    }

    public void setMdMatInfoDAO(MdMatInfoDAO mdMatInfoDAO) {
        this.mdMatInfoDAO = mdMatInfoDAO;
    }

	public GiftBarcodeDAO getGiftBarcodeDAO() {
		return giftBarcodeDAO;
	}

	public void setGiftBarcodeDAO(GiftBarcodeDAO giftBarcodeDAO) {
		this.giftBarcodeDAO = giftBarcodeDAO;
	}

	@Override
	public Pager<GiftBarcodeDTO> searchGiftBarcodes(
			Pager<GiftBarcodeDTO> pager, GiftBarcodeDTO mdBarcode) {
		List<GiftBarcodeDTO> mdBarcodes = giftBarcodeDAO.searchGiftBarcodes(pager, mdBarcode);
        long size = giftBarcodeDAO.searchGiftBarcodesCount(mdBarcode);
        return Pager.cloneFromPager(pager, size, mdBarcodes);
	}

	@Override
	public String addGiftBarcode(GiftBarcodeDTO giftBarcode) {
		String flag = "S";
        BarParameters para = new BarParameters();
        String batch = giftBarcodeDAO.selectSeq();
        String materialNo = giftBarcode.getMaterialNo();
        
        List<GiftBarcodeDTO> list = giftBarcodeDAO.searchGiftBarcodeByMaterial(materialNo);
        if (list != null && list.size()>0){
        	return "R";
        }
        
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        String yearCode = (String) para.getYearCode().get(year);
        String monthCode = (String) para.getMonthCode().get(month);
        String dayCode = (String) para.getDayCode().get(day);

        String bar = "";
        String code = giftBarcodeDAO.selectSeq();
        if (materialNo == null || "".equals(materialNo)) {
            return "F";
        } else {
            bar = materialNo + "00GI" + yearCode + monthCode + dayCode + "00000";
            bar = bar.substring(0, 16).toUpperCase();
            code = "000" + code;
            code = code.substring(code.length() - 4, code.length());
        }
        String barcode = bar + code;
        GiftBarcodeDTO mdinfo = new GiftBarcodeDTO();
        mdinfo.setBarcode(barcode);
        mdinfo.setMaterialNo(materialNo);
        mdinfo.setMaterialDesp(giftBarcode.getMaterialDesp());
        mdinfo.setStNo(batch);
        mdinfo.setCreateBy(giftBarcode.getCreateBy());
        giftBarcodeDAO.save(mdinfo);
        
        return flag;
	}

}
