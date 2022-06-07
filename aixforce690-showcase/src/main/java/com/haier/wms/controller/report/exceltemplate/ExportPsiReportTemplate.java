package com.haier.wms.controller.report.exceltemplate;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.report.dto.PsiReportDTO;

public class ExportPsiReportTemplate extends
AbstractExcelExportTemplate<PsiReportDTO> {
	private List<PsiReportDTO> list;

	public ExportPsiReportTemplate(List<PsiReportDTO> list) {
		this.list = list;
		this.columnWidth = 4000;
	}

	@Override
	public String[] getSheetNames() {

		return new String[] { "PSI Report" };
	}

	@Override
	public String[][] getTitles() {
		return new String[][] { { "WareHouse", "Location",
				"Division", "Material No", "Customer Model", "Material Description",
				"Color","Opening Qty", "InWarehouseQty", "OutWarehouse Qty", "WMS Qty" } };
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
		final int size = list.size();
		int startIndex = this.getBodyStartIndex(sheetIndex);

		for (int i = 0; i < size; i++) {
			Row row = sheet.createRow(i + startIndex);
			row.setHeight((short) 300);
			int index = 0;
			PsiReportDTO cx = list.get(i);
			createStyledCell(row, index++, cx.getWarehouseName(),
					this.bodyRowStyle);
			createStyledCell(row, index++, cx.getLocation(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getDivision(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getCustomerModel(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getColor(), this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatNumber(cx.getOpeningQty()), this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatNumber(cx.getInWarehouseQty()),
					this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatNumber(cx.getOutWarehouseQty()),
					this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatNumber(cx.getWmsQty()),
					this.bodyRowStyle);
		}

	}
}
