package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	private Workbook workbook;

    // Constructor to initialize the Excel file
    public ExcelReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    // Method to get data from a specific cell
    public String getCellData(String sheetName, int rowNumber, int colNumber) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            return ""; // Return empty if row doesn't exist
        }
        Cell cell = row.getCell(colNumber);
        if (cell == null) {
            return ""; // Return empty if cell doesn't exist
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    // Method to get total rows in a sheet
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        return sheet.getLastRowNum() + 1; // Index starts from 0
    }

    // Method to get total columns in a specific row
    public int getColumnCount(String sheetName, int rowNumber) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist.");
        }
        Row row = sheet.getRow(rowNumber);
        if (row == null) {
            return 0;
        }
        return row.getLastCellNum(); // Total columns
    }

    // Close the workbook
    public void close() throws IOException {
        workbook.close();
    }
	}