// 
// 
// 

package com.ldu.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.InputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadExcel
{
    private static boolean isMergedRegion(final Sheet sheet, final int row, final int column) {
        for (int sheetMergeCount = sheet.getNumMergedRegions(), i = 0; i < sheetMergeCount; ++i) {
            final CellRangeAddress range = sheet.getMergedRegion(i);
            final int firstColumn = range.getFirstColumn();
            final int lastColumn = range.getLastColumn();
            final int firstRow = range.getFirstRow();
            final int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn) {
                return true;
            }
        }
        return false;
    }
    
    public static CellRegion getMergedRegionValue(final Sheet sheet, final int row, final int column) {
        final CellRegion r = new CellRegion();
        for (int sheetMergeCount = sheet.getNumMergedRegions(), i = 0; i < sheetMergeCount; ++i) {
            final CellRangeAddress ca = sheet.getMergedRegion(i);
            final int firstColumn = ca.getFirstColumn();
            final int lastColumn = ca.getLastColumn();
            final int firstRow = ca.getFirstRow();
            final int lastRow = ca.getLastRow();
            if (row >= firstRow && row <= lastRow && column >= firstColumn && column <= lastColumn) {
                final Row fRow = sheet.getRow(firstRow);
                final Cell fCell = fRow.getCell(firstColumn);
                r.startrownum = firstRow;
                r.endrownum = lastRow;
                r.value = getCellValue(fCell);
                return r;
            }
        }
        return null;
    }
    
    public static String getCellValue(final Cell cell) {
        if (cell == null) {
            return "";
        }
        if (cell.getCellType() == 1) {
            return cell.getStringCellValue();
        }
        if (cell.getCellType() == 4) {
            return String.valueOf(cell.getBooleanCellValue());
        }
        if (cell.getCellType() == 2) {
            return String.valueOf(cell.getNumericCellValue());
        }
        if (cell.getCellType() == 0) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return "";
    }
    
    public static int getheight(final Sheet sheet, final int rownum, final int colnum) {
        if (isMergedRegion(sheet, rownum, colnum)) {
            final CellRegion r = getMergedRegionValue(sheet, rownum, colnum);
            return r.endrownum - r.startrownum + 1;
        }
        return 1;
    }
    
    public static String getvalue(final Sheet sheet, final int rownum, final int colnum) {
        if (isMergedRegion(sheet, rownum, colnum)) {
            final CellRegion c = getMergedRegionValue(sheet, rownum, colnum);
            return c.value;
        }
        final Row row = sheet.getRow(rownum);
        final Cell cell = row.getCell(colnum);
        return getCellValue(cell);
    }
    
    public static void main(final String[] args) {
        HSSFWorkbook wb = null;
        POIFSFileSystem fs = null;
        try {
            fs = new POIFSFileSystem((InputStream)new FileInputStream("d:\\table.xls"));
            wb = new HSSFWorkbook(fs);
            final HSSFSheet sheet = wb.getSheetAt(0);
            final HSSFRow row = sheet.getRow(6);
            final CellRegion r = new CellRegion();
            System.out.print(String.valueOf(r.value) + "  ");
            System.out.println(getvalue((Sheet)sheet, 6, 1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
