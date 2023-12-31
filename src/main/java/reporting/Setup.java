package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Setup implements ITestListener {
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        String fileName = ExtentReportingManager.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "/extent-reports/" + fileName;
        extentReports = ExtentReportingManager.createInstance(fullReportPath, "Test API Automation Report", "Test Execution Report");
    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test Name:-" + result.getTestClass().getName() + "-" + result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
            String fileName = ExtentReportingManager.getReportNameWithTimeStamp();
            String fullReportPath = System.getProperty("user.dir") + "/extent-reports/" + fileName;
            File extentReportFile = new File(fullReportPath);
            try {
                Desktop.getDesktop().browse(extentReportFile.toURI());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onTestFailure(ITestResult result) {
        ExtentReportingManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replaceAll(",", "<br>");
        String formattedTrace = "<details>\n" +
                "  <summary>Click here to see Exception Logs</summary>\n" +
                "  " + stackTrace + "\n" +
                "</details>\n";
        ExtentReportingManager.logExceptionDetails(formattedTrace);
    }

}
