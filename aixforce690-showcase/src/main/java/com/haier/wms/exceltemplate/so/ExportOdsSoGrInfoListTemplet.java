package com.haier.wms.exceltemplate.so;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.so.dto.OdsSoGrInfoDTO;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

/**
 * Copyright: Copyright © 2013-2018 LiuJiazhen
 *
 * @className: ExportodsSoGrInfoListTemplet.java
 * @description:
 * @version: v1.0.0
 * @author: LiuJiazhen
 * @date 2018年10月18日 下午4:07:40
 * <p>
 * Modification History:
 * Date			Author			Version			Description
 * ---------------------------------------------------------*
 * 2018年10月18日		LJZ			v1.0.0			create
 */

public class ExportOdsSoGrInfoListTemplet extends
        AbstractExcelExportTemplate<OdsSoGrInfoDTO> {

    private List<OdsSoGrInfoDTO> odsSoGrInfoList;

    public ExportOdsSoGrInfoListTemplet(List<OdsSoGrInfoDTO> odsSoGrInfoList) {
        this.odsSoGrInfoList = odsSoGrInfoList;
        this.columnWidth = 4000;
    }

    @Override
    public String[] getSheetNames() {
        return new String[]{"SO_GR_INFO"};
    }

    /**
     * <p>Title: getTitles</p>
     * <p>Description:自定义表头 </p>
     */
    @Override
    public String[][] getTitles() {
        return new String[][]{{"OGP/IGP No", "Order Type", "DN NO", "DN Item", "MaterialNo","Material Desp",  "Scanned Qty", "Plan Qty", "Unit", "Plant", "Location", "Sap Flag", "Post By", "Post Date", "Sap Doc No", "Sap Error Msg", "CarNo", "Invoice No", "Transpoter Name"}};
    }

    @Override
    public String[] getCaptions() {
        return new String[]{"SO_GR_INFO"};
    }

    /**
     * <p>Title: buildBody</p>
     * <p>Description: 创建Excel主体</p>
     */
    @Override
    protected void buildBody(int sheetIndex) {
        Sheet sheet = getSheet(sheetIndex);
        final int size = odsSoGrInfoList.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);

        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + startIndex);
            row.setHeight((short) 300);
            int index = 0;

            OdsSoGrInfoDTO info = odsSoGrInfoList.get(i);

            createStyledCell(row, index++, info.getOrderNo(), this.bodyRowStyle);

            if (info.getOrderType() != null) {
                if ("1".equals(info.getOrderType())) {
                    createStyledCell(row, index++, "IN", this.bodyRowStyle);
                } else if ("2".equals(info.getOrderType())) {
                    createStyledCell(row, index++, "OUT", this.bodyRowStyle);
                } else {
                    createStyledCell(row, index++, info.getOrderType(), this.bodyRowStyle);
                }
            }
            createStyledCell(row, index++, info.getDnNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getDnItemNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getMaterialNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getMaterialDesp(), this.bodyRowStyle);

            if (info.getScannedQty() != null) {
                createStyledCell(row, index++, info.getScannedQty().toString(), this.bodyRowStyle);
                createStyledCell(row, index++, info.getScannedQty().toString(), this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, "0", this.bodyRowStyle);
                createStyledCell(row, index++, "0", this.bodyRowStyle);
            }
            createStyledCell(row, index++, info.getUnit(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getPlant(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getLocation(), this.bodyRowStyle);

            // SAP_FLAG
            if ("0".equals(info.getSapFlag())) {
                createStyledCell(row, index++, "generation", this.bodyRowStyle);
            } else if ("1".equals(info.getSapFlag())) {
                createStyledCell(row, index++, "posted success", this.bodyRowStyle);
            } else if ("2".equals(info.getSapFlag())) {
                createStyledCell(row, index++, "posted failed", this.bodyRowStyle);
            } else if ("3".equals(info.getSapFlag())) {
                createStyledCell(row, index++, "locked", this.bodyRowStyle);
            }
            // ModifyBy --> Post By
            if (StringUtils.isNotBlank(info.getModifyBy())) {
                createStyledCell(row, index++, info.getModifyBy(), this.bodyRowStyle);
            } else {
                createStyledCell(row, index++, info.getCreateBy(), this.bodyRowStyle);
            }
            createStyledCell(row, index++, info.getPostingDate(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getSapDocNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getSapMsg(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getCarNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getInvoiceNo(), this.bodyRowStyle);
            createStyledCell(row, index++, info.getTransporterCode(), this.bodyRowStyle);
        }
    }


    protected CellStyle getStringCellStyle() {
        Font font = workbook.createFont();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(false);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyle.setDataFormat((short) 49);
        short border = 1;
        setCellBorder(cellStyle, border, border, border, border);
        return cellStyle;
    }
}
