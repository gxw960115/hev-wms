package com.haier.hevwms.basic.service.impl;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.hevwms.basic.domain.MdMatInfo;
import com.haier.openplatform.excel.AbstractExcelExportTemplate;

/**
 * @Company 青鸟软通
 * @Title:物料导出报表
 * @Package com.haier.hevwms.basic.service.impl
 * @author sunhaoyu
 * @date 2015/10/28
 * @version V1.0
 */
public class ExportMdMatInfoListTemplet extends
        AbstractExcelExportTemplate<MdMatInfo> {

    private List<MdMatInfo> mdMatInfoList;

    public ExportMdMatInfoListTemplet(List<MdMatInfo> mdMatInfoList) {
        this.mdMatInfoList = mdMatInfoList;
        this.columnWidth = 4000;
    }

    /**
     * Title: getSheetNames
     * Description:Sheet页名字
     * @return
     * @see com.haier.openplatform.excel.ExcelExportTemplate#getSheetNames()
     */
    @Override
    public String[] getSheetNames() {
        return new String[] { "MATERIAL" };
    }

    /**
     * 
     * Title: getTitles
     * Description:获得标题
     * @return
     * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()
     */
    @Override
    public String[][] getTitles() {
        return new String[][] { { "Material Code", "CUSTOMER_MODEL ",
                "Material Description", "Plant", "Color", "Gross weight",
                "Net Weight", "Size Dimension", "Basic unit ", "Lock Status",
                "Division", "IDU/ODU", "Modify Date", "Version", "Valid State ",
                "Created By ", "Created Date", "Modify By", "Remark ",
                "In or out ", "SKU/CBU", "Produce Model" } };
    }

    /**
     * Title: buildBody
     * Description:构建表内容
     * @param sheetIndex
     * @see com.haier.openplatform.excel.AbstractExcelExportTemplate#buildBody(int)
     */
    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);
        final int size = mdMatInfoList.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);

        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + startIndex);
            row.setHeight((short) 300);
            int index = 0;

            MdMatInfo mdMatInfo = mdMatInfoList.get(i);

            // 物料号
            createStyledCell(row, index++, mdMatInfo.getMaterialNo(),
                    this.bodyRowStyle);
            // 客户类型
            createStyledCell(row, index++, mdMatInfo.getCustomerModel(),
                    this.bodyRowStyle);
            // 物料描述
            createStyledCell(row, index++, mdMatInfo.getMaterialDesp(),
                    this.bodyRowStyle);
            // 工厂
            createStyledCell(row, index++, mdMatInfo.getPlant(),
                    this.bodyRowStyle);
            // 颜色
            createStyledCell(row, index++, mdMatInfo.getExternalMatGroup(),
                    this.bodyRowStyle);
            // 毛重
            if (mdMatInfo.getGrossWeight() == null
                    || "".equals(mdMatInfo.getGrossWeight())) {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, mdMatInfo.getGrossWeight()
                        .toString(), this.bodyRowStyle);
            }
            // 净重
            if (mdMatInfo.getNetWeight() == null
                    || "".equals(mdMatInfo.getNetWeight())) {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, mdMatInfo.getNetWeight()
                        .toString(), this.bodyRowStyle);
            }
            // cbm
            /*
             * if(mdMatInfo.getCbm()==null||"".equals(mdMatInfo.getCbm())){
             * createStyledCell(row,index++,"0",this.bodyRowStyle); }else{
             * createStyledCell
             * (row,index++,mdMatInfo.getCbm().toString(),this.bodyRowStyle); }
             */
            // 尺寸
            createStyledCell(row, index++, mdMatInfo.getSizeDimension(),
                    this.bodyRowStyle);
            // 单位
            createStyledCell(row, index++, mdMatInfo.getBasicUnit(),
                    this.bodyRowStyle);
            // 状态
            createStyledCell(row, index++, mdMatInfo.getPlantStatus(),
                    this.bodyRowStyle);
            // 大类
            createStyledCell(row, index++, mdMatInfo.getDivision(),
                    this.bodyRowStyle);
            // 区分空调内外机
            createStyledCell(row, index++, mdMatInfo.getProduceAttribute(),
                    this.bodyRowStyle);
            createStyledCell(row, index++, mdMatInfo.getLength().toString(),
                    this.bodyRowStyle);
            createStyledCell(row, index++, mdMatInfo.getHigth().toString(),
                    this.bodyRowStyle);
            createStyledCell(row, index++, mdMatInfo.getWidth().toString(),
                    this.bodyRowStyle);
            // 修改日期
            if (mdMatInfo.getModifyDate() == null) {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, mdMatInfo.getModifyDate()
                        .toString(), this.bodyRowStyle);
            }

            // 修改次数
            createStyledCell(row, index++, mdMatInfo.getProduceAttribute(),
                    this.bodyRowStyle);
            // 有效状态
            if (mdMatInfo.getVersion() == null) {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, mdMatInfo.getVersion()
                        .toString(), this.bodyRowStyle);
            }

            // 创建人
            createStyledCell(row, index++, mdMatInfo.getCreatedBy(),
                    this.bodyRowStyle);
            // 创建日期
            if (mdMatInfo.getCreatedDate() == null) {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, mdMatInfo.getCreatedDate()
                        .toString(), this.bodyRowStyle);
            }
            // 修改人
            createStyledCell(row, index++, mdMatInfo.getModifyBy(),
                    this.bodyRowStyle);
            // 备注
            createStyledCell(row, index++, mdMatInfo.getRemark(),
                    this.bodyRowStyle);
            // 出入标记
            createStyledCell(row, index++, mdMatInfo.getInOut(),
                    this.bodyRowStyle);

            createStyledCell(row, index++, mdMatInfo.getMatScanType(),
                    this.bodyRowStyle);

            createStyledCell(row, index++, mdMatInfo.getProduceModel(),
                    this.bodyRowStyle);

        }
    }

}
