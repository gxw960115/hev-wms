package com.haier.wms.controller.report.exceltemplate;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.report.dto.ConsignmentReportDTO;

public class ExportConsignmentReportTemplate extends AbstractExcelExportTemplate<ConsignmentReportDTO> {
	
	private List<ConsignmentReportDTO> list;

	public ExportConsignmentReportTemplate(List<ConsignmentReportDTO> list) {
		this.list = list;
		this.columnWidth = 4000;
	}

	@Override
	public String[] getSheetNames() {
		return new String[] { "Consignment Report" };
	}

	@Override
	public String[][] getTitles() {
		return new String[][] { { "Sold-to party", "Sold-to Name",
				"Ship-to Address", "Plt", "Loc", "Division","Material No","Customer Model",
				"Material Desp", "Fillup Qty", "Pickup Qty", "Issue Qty", "Stock Qty", "Unit" } };
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
			ConsignmentReportDTO cx = list.get(i);
			createStyledCell(row, index++, cx.getSoldToParty(),
					this.bodyRowStyle);
			createStyledCell(row, index++, cx.getSoldToName(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getShipToAddress(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getPlt(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getLoc(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getDivision(),this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialNo(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getCustomerModel(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialDesp(), this.bodyRowStyle);
			createStyledCell(row, index++, DataFormat.formatNumber(cx.getFillupQty()), this.bodyRowStyle);
			createStyledCell(row, index++, DataFormat.formatNumber(cx.getPickupQty()), this.bodyRowStyle);
			createStyledCell(row, index++, DataFormat.formatNumber(cx.getIssueQty()), this.bodyRowStyle);
			createStyledCell(row, index++, DataFormat.formatNumber(cx.getStockQty()), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getUnit(), this.bodyRowStyle);
		}

	}
}
