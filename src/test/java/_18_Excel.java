import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class _18_Excel {
    public static void main(String[] args) throws IOException {
//        // Reading Excel
//        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\data.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet1 = workbook.getSheet("Sheet1"); //    or XSSFSheet sheet1 = workbook.getSheetAt(0);
//        int totalRows = sheet1.getLastRowNum();                         // rows cont from 0
//        int totalCells = sheet1.getRow(0).getLastCellNum();     // cells count from 1
//        System.out.println(totalRows);
//        System.out.println(totalCells);
//
//        for (int r = 0; r <= totalRows; r++) {          // <=
//            XSSFRow row = sheet1.getRow(r);
//            for (int c = 0; c < totalCells; c++) {      //  < in java cells start form 0
//                XSSFCell cell = row.getCell(c);
//                System.out.print(cell.toString() + "    |    ");
//            }
//            System.out.println();
//        }
//        workbook.close();
//        file.close();



//            // Writing to Excel
//        XSSFWorkbook workbookW = new XSSFWorkbook();
//        XSSFSheet sheetW = workbookW.createSheet("data");
//
//        XSSFRow rowW0 = sheetW.createRow(0);
//        rowW0.createCell(0).setCellValue("Java");
//        rowW0.createCell(1).setCellValue(1234);
//        rowW0.createCell(2).setCellValue("Automation");
//
//        XSSFRow rowW1 = sheetW.createRow(1);
//        rowW1.createCell(0).setCellValue("Python");
//        rowW1.createCell(1).setCellValue(5678);
//        rowW1.createCell(2).setCellValue("Automation");
//
//        XSSFRow rowW2 = sheetW.createRow(2);
//        rowW2.createCell(0).setCellValue("C#");
//        rowW2.createCell(1).setCellValue(90);
//        rowW2.createCell(2).setCellValue("Programming");
//
//        FileOutputStream fileW = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\write.xlsx");
//        workbookW.write(fileW);
//        workbookW.close();
//        fileW.close();
//        System.out.println("File created");



        // Writing to Excel Dynamically
        XSSFWorkbook workbookD = new XSSFWorkbook();
        XSSFSheet sheetD = workbookD.createSheet("data");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int nrOfRows = scanner.nextInt();
        System.out.println("Enter number of cells:");
        int nrOfCells = scanner.nextInt();
        for(int r = 0; r < nrOfRows; r++) {
            XSSFRow row = sheetD.createRow(r);
            for(int c = 0; c < nrOfCells; c++) {
                XSSFCell cell = row.createCell(c);
                System.out.println("Enter cell value:");
                cell.setCellValue(scanner.next());
            }
            System.out.println("Row ended");
        }

        FileOutputStream fileD = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\writeDynamic.xlsx");
        workbookD.write(fileD);
        workbookD.close();
        fileD.close();
        System.out.println("File created");

    }
}
