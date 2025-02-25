import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _19_DDT_ExcelUtils {
    public static FileInputStream fileInput;
    public static FileOutputStream fileOutput;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    public static int getRowCount(String xlFile, String xlSheet) throws IOException {
        fileInput = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(xlSheet);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fileInput.close();
        return rowCount;
    }

    public static String getCellData(String xlFile, String xlSheet, int rowNumber, int columNumber) throws IOException {
        fileInput = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(columNumber);

        String data;
        try {
//            data = cell.toString();
            DataFormatter formatter = new DataFormatter();
            data = formatter.formatCellValue(cell); // Returns formatted value as a String regardless of the cell type
        } catch (Exception e) {
            data = "";
        }

        workbook.close();
        fileInput.close();
        return data;
    }

    public static void setCellData(String xlFile, String xlSheet, int rowNumber, int columNumber, String data) throws IOException {
        fileInput = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNumber);

        cell = row.createCell(columNumber);
        cell.setCellValue(data);
        fileOutput = new FileOutputStream(xlFile);
        workbook.write(fileOutput);

        workbook.close();
        fileInput.close();
        fileOutput.close();
    }

    public static void fillColor(String xlFile, String xlSheet, int rowNumber, int columNumber, short indexedColors) throws IOException {
        fileInput = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheet(xlSheet);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(columNumber);

        style = workbook.createCellStyle();
        style.setFillForegroundColor(indexedColors);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(style);

        fileOutput = new FileOutputStream(xlFile);
        workbook.write(fileOutput);
        workbook.close();
        fileInput.close();
        fileOutput.close();
    }
}
