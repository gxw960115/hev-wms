package com.haier.wms.controller.inventory.exceltemplate;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.inventory.dto.OdsInventoryInfoDtlDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public class ExportOdsInventoryBinInfoTemplet extends AbstractExcelExportTemplate<OdsInventoryInfoDtlDTO> {

    private List<OdsInventoryInfoDtlDTO> inventoryBinList;

    public ExportOdsInventoryBinInfoTemplet(List<OdsInventoryInfoDtlDTO> inventoryBinList) {
        this.inventoryBinList = inventoryBinList;
        this.columnWidth = 4000;
    }

    @Override
    public String[] getSheetNames() {
        return new String[] { "inventoryBin" };
    }
    /** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
    @Override
    public String[][] getTitles() {
        return new String[][] { { "Plant", "Location ", "Bin", "Material No", "Material Description","Qty","Use Qty","Unit"}};
    }

    @Override
    public String[] getCaptions() {
        return new String[] { "Inventory Bin" };
    }
    /** (non-Javadoc)  
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 * @param sheetIndex  
	 * @see AbstractExcelExportTemplate#buildBody(int)  
	 */
    @Override
    protected void buildBody(int sheetIndex) {

        Sheet sheet = getSheet(sheetIndex);
        final int size = inventoryBinList.size();
        int startIndex = this.getBodyStartIndex(sheetIndex);

        for (int i = 0; i < size; i++) {
            Row row = sheet.createRow(i + startIndex);
            row.setHeight((short) 300);
            int index = 0;

            OdsInventoryInfoDtlDTO info = inventoryBinList.get(i);

            createStyledCell(row, index++, info.getPlant(),this.bodyRowStyle);
            createStyledCell(row, index++, info.getLocation(),this.bodyRowStyle);
            createStyledCell(row, index++, info.getBin(),this.bodyRowStyle);
            createStyledCell(row, index++, info.getMaterialNo(),this.bodyRowStyle);
            createStyledCell(row, index++, info.getMaterialDesp(),this.bodyRowStyle);
            createStyledCell(row, index++, info.getQty() == null ? "0":info.getQty()+"",this.bodyRowStyle);
            createStyledCell(row, index++, info.getUseQty() == null ? "0":info.getUseQty()+"",this.bodyRowStyle);
            createStyledCell(row, index++, info.getUnit(),this.bodyRowStyle);

        }
    }

    protected CellStyle getStringCellStyle(){
        Font font = workbook.createFont();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setWrapText(false);
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyle.setDataFormat((short) 49);
        short border = 1;
        setCellBorder(cellStyle,border,border,border,border);
        return cellStyle;
    }

}
