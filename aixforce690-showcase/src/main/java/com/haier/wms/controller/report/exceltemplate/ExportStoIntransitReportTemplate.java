package com.haier.wms.controller.report.exceltemplate;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.report.dto.StoIntransitReportDTO;

public class ExportStoIntransitReportTemplate extends
AbstractExcelExportTemplate<StoIntransitReportDTO> {
	private List<StoIntransitReportDTO> list;

	public ExportStoIntransitReportTemplate(List<StoIntransitReportDTO> list) {
		this.list = list;
		this.columnWidth = 4000;
	}

	@Override
	public String[] getSheetNames() {

		return new String[] { "PSI Report" };
	}

	@Override
	public String[][] getTitles() {
		return new String[][] { { "STO No", "Division",
				"Material No", "Customer Model", "Material Desp", "GI Plt",
				"GI Loc","GI Date", "GR Plt", "GR Loc", "Barcode", "GI Qty", "Intrasit Qty", "Unit" } };
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
			StoIntransitReportDTO cx = list.get(i);
			createStyledCell(row, index++, cx.getStoNo(),
					this.bodyRowStyle);
			createStyledCell(row, index++, cx.getDivision(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialNo(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getCustomerModel(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialDesp(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getGiPlt(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getGiLoc(), this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatDate(cx.getGiDate()), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getGrPlt(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getGrLoc(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getBarcode(), this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatNumber(cx.getGiQty()), this.bodyRowStyle);
			createStyledCell(row, index++,
					DataFormat.formatNumber(cx.getIntrasitQty()),
					this.bodyRowStyle);
			createStyledCell(row, index++, cx.getUnit(), this.bodyRowStyle);
		}

	}
}
