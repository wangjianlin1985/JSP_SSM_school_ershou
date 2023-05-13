// 
// 
// 

package com.ldu.util;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel
{
    private String[] rowName;
    private List<Object[]> dataList;
    
    public WriteExcel(final String[] rowName, final List<Object[]> dataList) {
        this.dataList = new ArrayList<Object[]>();
        this.dataList = dataList;
        this.rowName = rowName;
    }
    
    public InputStream export() throws Exception {
        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet("sheet1");
        final HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);
        final HSSFCellStyle style = this.getStyle(workbook);
        final int columnNum = this.rowName.length;
        final HSSFRow rowRowName = sheet.createRow(0);
        for (int n = 0; n < columnNum; ++n) {
            final HSSFCell cellRowName = rowRowName.createCell(n);
            cellRowName.setCellType(1);
            final HSSFRichTextString text = new HSSFRichTextString(this.rowName[n]);
            cellRowName.setCellValue((RichTextString)text);
            cellRowName.setCellStyle(columnTopStyle);
        }
        for (int i = 0; i < this.dataList.size(); ++i) {
            final Object[] obj = this.dataList.get(i);
            final HSSFRow row = sheet.createRow(i + 1);
            for (int j = 0; j < obj.length; ++j) {
                HSSFCell cell = null;
                cell = row.createCell(j, 1);
                if (!"".equals(obj[j]) && obj[j] != null) {
                    cell.setCellValue(obj[j].toString());
                }
                cell.setCellStyle(style);
            }
        }
        for (int colNum = 0; colNum < columnNum; ++colNum) {
            int columnWidth = sheet.getColumnWidth(colNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); ++rowNum) {
                HSSFRow currentRow;
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                }
                else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(colNum) != null) {
                    final HSSFCell currentCell = currentRow.getCell(colNum);
                    if (currentCell.getCellType() == 1) {
                        final int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            if (colNum == 0) {
                sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
            }
            else {
                sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
            }
        }
        final String fileName = "Excel-" + String.valueOf(System.currentTimeMillis()).substring(4, 13) + ".xls";
        final String headStr = "attachment; filename=\"" + fileName + "\"";
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write((OutputStream)os);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        final byte[] content = os.toByteArray();
        final InputStream is = new ByteArrayInputStream(content);
        return is;
    }
    
    public HSSFCellStyle getColumnTopStyle(final HSSFWorkbook workbook) {
        final HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short)11);
        font.setBoldweight((short)700);
        font.setFontName("Courier New");
        final HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom((short)1);
        style.setBottomBorderColor((short)8);
        style.setBorderLeft((short)1);
        style.setLeftBorderColor((short)8);
        style.setBorderRight((short)1);
        style.setRightBorderColor((short)8);
        style.setBorderTop((short)1);
        style.setTopBorderColor((short)8);
        style.setFont(font);
        style.setWrapText(false);
        style.setAlignment((short)2);
        style.setVerticalAlignment((short)1);
        return style;
    }
    
    public HSSFCellStyle getStyle(final HSSFWorkbook workbook) {
        final HSSFFont font = workbook.createFont();
        font.setFontName("Courier New");
        final HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom((short)1);
        style.setBottomBorderColor((short)8);
        style.setBorderLeft((short)1);
        style.setLeftBorderColor((short)8);
        style.setBorderRight((short)1);
        style.setRightBorderColor((short)8);
        style.setBorderTop((short)1);
        style.setTopBorderColor((short)8);
        style.setFont(font);
        style.setWrapText(false);
        style.setAlignment((short)2);
        style.setVerticalAlignment((short)1);
        return style;
    }
    
    public static void main(final String[] args) throws Exception {
        final String[] rowsName = { "\u5e8f\u53f7", "\u72b6\u6001", "\u5f55\u5165\u4eba", "\u5f55\u5165\u65f6\u95f4" };
        final List<Object[]> dataList = new ArrayList<Object[]>();
        final Object[] obj1 = { "1", "ok", "hello", "wsz" };
        dataList.add(obj1);
        final Object[] obj2 = { "2", "dsa", "wolrd", "python" };
        dataList.add(obj2);
        final WriteExcel ex = new WriteExcel(rowsName, dataList);
        ex.export();
    }
}
