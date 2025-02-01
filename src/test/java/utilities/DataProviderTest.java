package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	@DataProvider(name = "addCustomer")
	 
    public Object[][] getLoginData() throws IOException {
	// Use relative path to locate the file
        String filePath = "src/test/resources/excelSheet/testdata.xlsx";
        ExcelReader excelReader = new ExcelReader(filePath);
        String sheetName = "Sheet1";
        int rowCount = excelReader.getRowCount(sheetName);
        int colCount = excelReader.getColumnCount(sheetName, 0);

        Object[][] data = new Object[rowCount - 1][colCount]; // Skip the header row

        for (int i = 1; i < rowCount; i++) { // Start from row 1 to skip the header
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = excelReader.getCellData(sheetName, i, j);
            }
        }

        excelReader.close(); // Release resources
        return data;

}
}

