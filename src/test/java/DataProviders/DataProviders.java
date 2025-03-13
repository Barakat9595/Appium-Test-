package DataProviders;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.annotations.DataProvider;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "hardCoded")
    public static Object[][] testData() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out."},
                {"standard_user", "", "Password is required"},
                {"", "secret_sauce", "Username is required"}
        };
    }

    @DataProvider(name = "credentials")
    public static Object[][] credentials()
    {
        return new Object[][]
                {
                        {"standard_user", "secret_sauce"}
                };
    }


    @DataProvider(name = "csvData")
    public static Object[][] readCSV() throws IOException, CsvValidationException {
        String filePath = "D:\\DATA\\appiumTotest3aseer\\Book(Sheet1).csv"; // Path to CSV file
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<Object[]> testData = new ArrayList<>();

        String[] nextLine;
        boolean skipHeader = true; // Skip the first line (header)
        while ((nextLine = reader.readNext()) != null) {
            if (skipHeader) {
                skipHeader = false;
                continue;
            }
            if (nextLine.length >= 3) { // Ensure at least 3 columns exist
                testData.add(new Object[]{nextLine[0], nextLine[1], nextLine[2]});
            }
        }
        reader.close();
        return testData.toArray(new Object[0][]);
    }
}
