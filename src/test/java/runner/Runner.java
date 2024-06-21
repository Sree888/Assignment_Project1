package runner;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src\\test\\resources\\features"},
		glue={"steps"},
		plugin={"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@tag20",
		// plugin = { "me.jvt.cucumber.report.PrettyReports:target/cucumber" },
		monochrome = true
		)
public class Runner {
	
	@BeforeClass
	public static void dhdh(){
		System.out.println("djdjffjeju");
	}


}
