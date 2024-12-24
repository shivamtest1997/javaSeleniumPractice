package selenium_practice_set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class DataDrivenTest {

    /**
     *
     * Excel File >Workbook -->Sheets --->Rows-->Cell
     * FileInputStream(C)-->Reading file
     * FileOutputStream(C)-->writing in file
     *
     * Apache Poi classes :
     * XSSFWorkbook(C) -->workbook
     * XSSFSheet(C)    -->sheet
     * XSSFRow(C)      -->row
     * XSSFCell(C)     -->cell
     */
    public void readData() throws IOException
    {
        String filePath = System.getProperty("user.dir") + "\\test-data\\TestData.xlsx";

        FileInputStream fis=new FileInputStream(filePath); // file
        XSSFWorkbook workbook=new XSSFWorkbook(fis);      // workbook
        XSSFSheet sheet = workbook.getSheet("ReadData"); //sheet
        // or workbook.getSheetAt(0); here we need to pass index of sheet

        int lastRowNo = sheet.getLastRowNum(); // no of rows
        int totalCells = sheet.getRow(0).getLastCellNum(); // no of cells
        System.out.println("Total no of rows:"+lastRowNo);
        System.out.println("Total No of cells:"+totalCells);

        // for rows
        for (int r=0;r<=lastRowNo;r++)
        {
            XSSFRow currentRow = sheet.getRow(r); // entire current row

            for (int c=0;c<totalCells;c++)
            {
                String cellValue = currentRow.getCell(c).toString();
                System.out.print(" "+cellValue+" ");
            }
            System.out.println();
        }
        workbook.close(); // close the workbook
        fis.close();      // close file
    }

    public void writeData() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\test-data\\writeFile.xlsx";
        FileOutputStream file=new FileOutputStream(filePath);

        XSSFWorkbook workbook=new XSSFWorkbook();  //create new workbook

        XSSFSheet sheet = workbook.createSheet("Data"); //create sheet in workbook with name Data
        XSSFRow row1 = sheet.createRow(0);             //create first row in sheet
        row1.createCell(0).setCellValue("Shivam"); //create cell in first row
        row1.createCell(1).setCellValue(100);
        row1.createCell(2).setCellValue("Selenium");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Pratik");
        row2.createCell(1).setCellValue(500);
        row2.createCell(2).setCellValue("Rest Assured");

        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("Shubham");
        row3.createCell(1).setCellValue(50);
        row3.createCell(2).setCellValue("Python");

        // attach workbook with file
        workbook.write(file);
        workbook.close(); //close workbook
        file.close(); //close file
        System.out.println("New file is created with data ");
    }

    /**
     * Writing data dynamically
     * @throws FileNotFoundException
     */
    public void writeDynamicData() throws IOException {

        String filePath = System.getProperty("user.dir") + "\\test-data\\dynamicData.xlsx";
        FileOutputStream file=new FileOutputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DyanamicData");

        Scanner sc=new Scanner(System.in);
        System.out.println("Get how many rows you want");
        int  noOfRows=sc.nextInt();

        System.out.println("Get how many cells you want");
        int  noOfCells=sc.nextInt();

        for (int i=0;i<=noOfRows;i++) // rows
        {
            XSSFRow currentRow = sheet.createRow(i);
            for (int c=0;c<noOfCells;c++)
            {
                currentRow.createCell(c).setCellValue(sc.next());
            }
        }
        XSSFSheet sheet2 = workbook.createSheet("DyanamicData2"); //create another sheet in workbook
        Scanner sc1=new Scanner(System.in);
        System.out.println("Enter how many rows you want in second sheet");
        int rows=sc1.nextInt();

        System.out.println("Enter how many cells you want in row");
        int cells=sc1.nextInt();
        for (int r=0;r<=rows;r++)
        {
            XSSFRow currentRow = sheet2.createRow(r);
            for (int c=0;c<cells;c++)
            {
                System.out.println("Enter a data");
                currentRow.createCell(c).setCellValue(sc1.next()); // sc.next() because user can enter any value either int or String
            }
        }
        workbook.write(file); // attach workbook to file
        workbook.close();
        file.close();
        System.out.println("Sheet is created with dynamic data");
    }

    public static void main(String[] args) throws IOException {
        DataDrivenTest dt=new DataDrivenTest();
       // dt.readData();
       // dt.writeData();
       // dt.writeDynamicData();
    }
}
