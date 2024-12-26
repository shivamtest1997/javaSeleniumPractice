package selenium_practice_set;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.text.Style;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    //create variable at once and use wherever required
    public static FileInputStream fis;
    public static FileOutputStream fos;
    public static XSSFWorkbook workbook;
    public  static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static CellStyle style;

    /**
     * this method will return row counts.
     * @param xlFilePath
     * @param xlsheet
     * @return
     * @throws IOException
     * This method is static so that it can be called directly without creating object.
     */
    public static int getRowCount(String xlFilePath,String xlsheet) throws IOException {

        fis=new FileInputStream(xlFilePath);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(xlsheet);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    /**
     * This method will return cell numbers
     * @param xlFilePath
     * @param xlsheet
     * @param rowNo
     * @return
     * @throws IOException
     */
    public static int getCellCount(String xlFilePath,String xlsheet,int rowNo) throws IOException {

        fis=new FileInputStream(xlFilePath);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(xlsheet);
        int cellCount = sheet.getRow(rowNo).getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    /**
     * This method will read data from cell.
     * @param xlfile
     * @param xlsheet
     * @param rowNo
     * @param colNo
     * @return data
     * @throws IOException
     */
    public static String getCellData(String xlFilePath,String xlsheet,int rowNo,int colNo) throws IOException {
        fis=new FileInputStream(xlFilePath);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(xlsheet);
        row=sheet.getRow(rowNo);
        cell=row.getCell(colNo);
        String data ;
        // Note : if data not present in cell it may throw exception DataNotFoundException to handle this use tryCatch
        try {
           // data=cell.toString();
           // or
            DataFormatter formatter=new DataFormatter();
            data=formatter.formatCellValue(cell);// Return the formatted cell value as String regardless of cell type.
        }catch (Exception e)
        {
            data=""; // make data value empty
        }
        workbook.close();
        fis.close();
        return  data;
    }

    /**
     * This method is used to write data in sheet.
     * @param xlfile
     * @param xlsheet
     * @param rowNo
     * @param cellNo
     * @param data
     * @throws IOException
     */
    public static void setCellData(String xlfile,String xlsheet,int rowNo,int cellNo,String data) throws IOException {
        //read data
        fis=new FileInputStream(xlfile);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(xlsheet);
        row=sheet.getRow(rowNo);

        //write data in same sheet
        cell=row.createCell(cellNo);
        cell.setCellValue(data);
        fos=new FileOutputStream(xlfile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }

    /**
     * This method will fill green colour
     * @param xlfile
     * @param xlsheet
     * @param rowNo
     * @param cellNo
     * @throws IOException
     */
    public static void fillGreenColour(String xlfile,String xlsheet,int rowNo,int cellNo) throws IOException {

        fis=new FileInputStream(xlfile);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(xlsheet);
        row=sheet.getRow(rowNo);
        cell=row.getCell(cellNo);

        style=workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fos=new FileOutputStream(xlfile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();

    }
    /**
     * This method will fill red  colour
     * @param xlfile
     * @param xlsheet
     * @param rowNo
     * @param cellNo
     * @throws IOException
     */
    public static void fillRedColour(String xlfile,String xlsheet,int rowNo,int cellNo) throws IOException {

        fis=new FileInputStream(xlfile);
        workbook=new XSSFWorkbook(fis);
        sheet=workbook.getSheet(xlsheet);
        row=sheet.getRow(rowNo);
        cell=row.getCell(cellNo);

        style=workbook.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        fos=new FileOutputStream(xlfile);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();

    }


}
