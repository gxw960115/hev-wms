package com.haier.wms.controller.report.exceltemplate;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.haier.openplatform.excel.AbstractExcelExportTemplate;
import com.haier.openplatform.showcase.util.DataFormat;
import com.haier.openplatform.wms.report.dto.SalesReturnReportDTO;

public class ExportSalesReturnReportTemplate extends
AbstractExcelExportTemplate<SalesReturnReportDTO> {
	private List<SalesReturnReportDTO> list;

	public ExportSalesReturnReportTemplate(List<SalesReturnReportDTO> list) {
		this.list = list;
		this.columnWidth = 4000;
	}

	@Override
	public String[] getSheetNames() {

		return new String[] { "Sales Return Report" };
	}

	@Override
	public String[][] getTitles() {
		return new String[][] { { "Billing No", "Material No",
				"Customer Model", "Location", "Barcode",
				"Responsible Department","Goods Class", "CRM Complain No", "Reason", "Create Date", "Create User" } };
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
			SalesReturnReportDTO cx = list.get(i);
			createStyledCell(row, index++, cx.getDnNo(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getMaterialNo(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getCustomerModel(), this.bodyRowStyle);
//			createStyledCell(row, index++, cx.getMaterialDesp(), this.bodyRowStyle); //no need display material desc. 20160627
			createStyledCell(row, index++, cx.getLocation(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getBarcode(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getResponsibleDepartment(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getGoodsClass(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getCrmComplainNo(), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getReason(), this.bodyRowStyle);
			createStyledCell(row, index++, DataFormat.formatDate(cx.getCreateDate()), this.bodyRowStyle);
			createStyledCell(row, index++, cx.getCreateUser(), this.bodyRowStyle);
		}

	}
}
