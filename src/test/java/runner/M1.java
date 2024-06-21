package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class M1 {
    public static void main(String[] args) {
        // Initialize ExtentReports
        ExtentReports extent = new ExtentReports();

        // Create an ExtentHtmlReporter and specify the output path
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("target/ExtentReport.html");
        extent.attachReporter(htmlReporter);

        // Create a test and log a passing event
        ExtentTest test = extent.createTest("MyFirstTest");
        test.log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");

        // Flush the report (write to the HTML file)
        extent.flush();
        
    }
}
