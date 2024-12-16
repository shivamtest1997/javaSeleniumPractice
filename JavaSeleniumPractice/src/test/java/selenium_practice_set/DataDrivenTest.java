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
     * FileInputStream(C)-->Reading
     * FileOutputStream(C)-->writing
     * XSSFWorkbook(C)
     * XSSFSheet(C)
     * XSSFRow(C)
     * XSSFCell(C)
     */
    public void readData() throws IOException
    {
        String filePath = System.getProperty("user.dir") + "\\test-data\\TestData.xlsx";

        FileInputStream fis=new FileInputStream(filePath); // file
        XSSFWorkbook workbook=new XSSFWorkbook(fis);      // workbook
        XSSFSheet sheet = workbook.getSheet("ReadData"); //sheet

        int lastRowNo = sheet.getLastRowNum(); // no of rows
        int totalCells = sheet.getRow(1).getLastCellNum(); // no of cells

        for (int i=0;i<=lastRowNo;i++)
        {
            XSSFRow currentRow = sheet.getRow(i); // entire row

            for (int j=0;j<totalCells;j++)
            {
                String cellValue = currentRow.getCell(j).toString();
                System.out.print(" "+cellValue+" ");
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }

    public void writeData() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\test-data\\writeFile.xlsx";
        FileOutputStream fos=new FileOutputStream(filePath);

        //create new workbook
        XSSFWorkbook workbook=new XSSFWorkbook();
        //create sheet
        XSSFSheet sheet = workbook.createSheet("Data");
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Shivam");
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
        workbook.write(fos);
    }

    /**
     * Writing data dynamically
     * @throws FileNotFoundException
     */
    public void writeDynamicData() throws IOException {
        String filePath = System.getProperty("user.dir") + "\\test-data\\dynamicData.xlsx";
        FileOutputStream fos=new FileOutputStream(filePath);
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DyanamicData");

        Scanner sc=new Scanner(System.in);
        System.out.println("Get how many rows you want");
        int  noOfRows=sc.nextInt();

        System.out.println("Get how many cells you want");
        int  noOfCells=sc.nextInt();

        for (int i=1;i<=noOfRows;i++)
        {
            XSSFRow currentRow = sheet.createRow(i);
            for (int c=1;c<=noOfCells;c++)
            {
                currentRow.createCell(c).setCellValue(sc.next());
            }
        }
        workbook.write(fos);
        workbook.close();
        fos.close();

    }

    public static void main(String[] args) throws IOException {
        DataDrivenTest dt=new DataDrivenTest();
        dt.readData();
        dt.writeData();
        dt.writeDynamicData();
    }
}
