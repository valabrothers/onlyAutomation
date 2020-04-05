package commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelHelper {

	
	public static void main(String[] args) throws IOException {
		writeExcel("e:\\ALpeshVala.xlsx","TestSheet");
		readExcel("e:\\ALpeshVala.xlsx","TestSheet");
		
	
	}

	public static void writeExcel(String filepath, String sheetname) {
		XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetname);

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue((String) "Name");
        Cell cellage = row.createCell(1);
        cellage.setCellValue((String) "age");
        Cell cellcity= row.createCell(2);
        cellcity.setCellValue((String) "city");

        Row row1 = sheet.createRow(1);
        Cell cell1 = row.createCell(0);
        cell.setCellValue((String) "Alpesh");
        Cell cellage1 = row.createCell(1);
        cellage1 .setCellValue((Integer) 35);
        Cell cellcity1= row.createCell(2);
        cellcity1.setCellValue((String) "Kodinar");

        try {
            FileOutputStream outputStream = new FileOutputStream(filepath);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");

	}



	public static void readExcel(String filepath, String sheetname) throws IOException {
		 FileInputStream file = new FileInputStream(new File(filepath));
		 
         //Create Workbook instance holding reference to .xlsx file
         XSSFWorkbook workbook = new XSSFWorkbook(file);

         //Get first/desired sheet from the workbook
         XSSFSheet sheet = workbook.getSheetAt(0);

         Iterator<Row> rowIterator = sheet.iterator();
         while (rowIterator.hasNext()) 
         {
             Row row = rowIterator.next();
             //For each row, iterate through all the columns
             Iterator<Cell> cellIterator = row.cellIterator();
              
             while (cellIterator.hasNext()) 
             {
                 Cell cell = cellIterator.next();
                 //Check the cell type and format accordingly
                 
                 System.out.println("celltype = " + cell.getCellType());
                 System.out.print(cell.getStringCellValue() + "		");
               /*  switch (cell.getCellType()) 
                 {
                     case :
                         System.out.print(cell.getNumericCellValue() + "t");
                         break;
                     case Cell.CELL_TYPE_STRING:
                         System.out.print(cell.getStringCellValue() + "t");
                         break;
                 }*/
             }
             System.out.println("");
         }
         file.close();
		
	}	


}