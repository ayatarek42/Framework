package data.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

// Registration data

    static FileInputStream registerFile = null;
    public FileInputStream getFileInputStreamReg(){
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/excel/registrationData.xlsx";
        File srcFile = new File(filePath);
        try {
            registerFile = new FileInputStream(srcFile);
        }
        catch(FileNotFoundException e){
            System.out.println("Error occured :" + e.getMessage());
            System.exit(0);
        }
        return  registerFile;
    }

    //Email sheet
    public Object[][] getExcelDataRegistrationEmail() throws IOException {
        registerFile = getFileInputStreamReg();
        XSSFWorkbook wb = new XSSFWorkbook( registerFile);
        DataFormatter fmt = new DataFormatter();
        XSSFSheet email = wb.getSheetAt(0);
        int totalNoOfRows = email.getLastRowNum()+1;
        int totalNoOfColumns = 1;
        String [][] excelData = new String[totalNoOfRows][totalNoOfColumns];
        for (int i=0; i< totalNoOfRows; i++) {
            for (int j = 0; j < totalNoOfColumns; j++) {
                XSSFRow row = email.getRow(i);
                Cell cell = row.getCell(j);
                excelData[i][j] = fmt.formatCellValue(cell);
            }
        }

        wb.close();
        return excelData;
    }

    //Name
    public Object[][] getExcelDataRegistrationName() throws IOException {
        registerFile = getFileInputStreamReg();
        XSSFWorkbook wb = new XSSFWorkbook( registerFile);
        DataFormatter fmt = new DataFormatter();
        XSSFSheet sheet = wb.getSheetAt(1);
        int totalNoOfRows = sheet.getLastRowNum()+1;
        int totalNoOfColumns = 2;
        String [][] excelData = new String[totalNoOfRows][totalNoOfColumns];
        for (int i=0; i< totalNoOfRows; i++) {
            for (int j = 0; j < totalNoOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                excelData[i][j] = fmt.formatCellValue(cell);

            }
        }

        wb.close();
        return excelData;
    }

    //Password
    public Object[][] getExcelDataRegistrationPassword() throws IOException {
        registerFile = getFileInputStreamReg();
        XSSFWorkbook wb = new XSSFWorkbook( registerFile);
        DataFormatter fmt = new DataFormatter();
        XSSFSheet sheet = wb.getSheetAt(2);
        int totalNoOfRows = sheet.getLastRowNum()+1;
        int totalNoOfColumns = 1;
        String [][] excelData = new String[totalNoOfRows][totalNoOfColumns];
        for (int i=0; i< totalNoOfRows; i++) {
            for (int j = 0; j < totalNoOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                excelData[i][j] = fmt.formatCellValue(cell);
            }
        }

        wb.close();
        return excelData;
    }

    //Date of birth
    public Object[][] getExcelDataRegistrationDateOfBirth() throws IOException {
        registerFile = getFileInputStreamReg();
        XSSFWorkbook wb = new XSSFWorkbook( registerFile);
        DataFormatter fmt = new DataFormatter();
        XSSFSheet sheet = wb.getSheetAt(3);
        int totalNoOfRows = sheet.getLastRowNum()+1;
        int totalNoOfColumns = 3;
        String [][] excelData = new String[totalNoOfRows][totalNoOfColumns];
        for (int i=0; i< totalNoOfRows; i++) {
            for (int j = 0; j < totalNoOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                excelData[i][j] = fmt.formatCellValue(cell);
            }
        }

        wb.close();
        return excelData;
    }

    //Address
    public Object[][] getExcelDataRegistrationAddress() throws IOException {
        registerFile = getFileInputStreamReg();
        XSSFWorkbook wb = new XSSFWorkbook( registerFile);
        DataFormatter fmt = new DataFormatter();
        XSSFSheet sheet = wb.getSheetAt(4);
        int totalNoOfRows = sheet.getLastRowNum()+1;
        int totalNoOfColumns = 5;
        String [][] excelData = new String[totalNoOfRows][totalNoOfColumns];
        for (int i=0; i< totalNoOfRows; i++) {
            for (int j = 0; j < totalNoOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                excelData[i][j] = fmt.formatCellValue(cell);

            }
        }

        wb.close();
        return excelData;
    }
}
