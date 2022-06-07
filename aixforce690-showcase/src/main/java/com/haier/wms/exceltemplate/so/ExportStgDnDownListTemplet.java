package com.haier.wms.exceltemplate.so;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.wms.so.dto.StgDnDownDTO;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.List;

public class ExportStgDnDownListTemplet extends AbstractExcelExportTemplate<StgDnDownDTO>{
	
	private List<StgDnDownDTO> stgDnDownList;
	
	public ExportStgDnDownListTemplet(List<StgDnDownDTO> stgDnDownList){
		this.stgDnDownList=stgDnDownList;
		this.columnWidth=4000;
	}
	
	
	@Override
	public String[] getSheetNames() {
		return new String[] {"BILLING_ORDER"};
	}	
	/** (non-Javadoc)  
	 * <p>Title: getTitles</p>  
	 * <p>Description:自定义表头 </p>  
	 * @return  
	 * @see com.haier.openplatform.excel.ExcelExportTemplate#getTitles()  
	 */
	@Override
	public String[][] getTitles() {
		return new String[][]{{"DN NO","DN Item","Sale Type","Material No ","Material Description","Qty","Finish Qty","Unit","Plant","Location","Picking Date","Vendor Code","Vendor Name","SoldTo Code","SoldTo Name","ShipTo Code","ShipTo Name","Planned GI","Customer PO","ShipTo Address"}};
	}
	
	
	@Override
	public String[] getCaptions() {
		return new String[]{"BILLING_ORDER"};
	}
	/** (non-Javadoc)  
	 * <p>Title: buildBody</p>  
	 * <p>Description: 创建Excel主体</p>  
	 * @param sheetIndex  
	 * @see com.haier.openplatform.excel.AbstractExcelExportTemplate#buildBody(int)  
	 */
	@Override
	protected void buildBody(int sheetIndex) {

		Sheet sheet = getSheet(sheetIndex);
		final int size = stgDnDownList.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);
		
		for(int i = 0; i < size; i++){
			Row row = sheet.createRow(i+startIndex); 
			row.setHeight((short)300);
			int index = 0;
			StgDnDownDTO info = stgDnDownList.get(i);
			
			createStyledCell(row,index++,info.getDnNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getDnItemNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getSellOrderType(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getMaterialDesp(),this.bodyRowStyle);
			if(info.getQty()!=null){
				createStyledCell(row,index++,info.getQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			if(info.getFinishQty()!=null){
				createStyledCell(row,index++,info.getFinishQty()+"",this.bodyRowStyle);
			}else{
				createStyledCell(row,index++,"0",this.bodyRowStyle);
			}
			createStyledCell(row,index++,info.getUnit(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getPlant(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getLocation(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getPickingDate(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getVendorCode(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getVendorName(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getCustomerNo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getCustomerName(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getDeliveryCode(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getDeliveryName(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getDeliveryDate(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getCustomerPo(),this.bodyRowStyle);
			createStyledCell(row,index++,info.getDeliveryAddress(),this.bodyRowStyle);
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
