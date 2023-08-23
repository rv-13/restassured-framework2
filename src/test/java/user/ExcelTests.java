package user;

import utils.ExcelUtils;

import java.io.IOException;

public class ExcelTests {
    public static void main(String[] args) throws IOException {
        System.out.println(ExcelUtils.getExcelDataAsListOfMap("TestData_restassured2", "userTestsData"));

    }
}
