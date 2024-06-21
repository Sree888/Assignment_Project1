//package hooks;
//
//import org.junit.AfterClass;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.service.ExtentService;
//
//import io.cucumber.java.After;
//import io.cucumber.java.AfterAll;
//import io.cucumber.java.AfterStep;
//import io.cucumber.java.Before;
//import io.cucumber.java.Scenario;
//import io.cucumber.plugin.event.HookTestStep;
//import io.cucumber.plugin.event.PickleStepTestStep;
//import io.cucumber.plugin.event.TestStepStarted;
//
//public class Hooks {
//	
//	
//	@Before
//	public void beforeScenario(Scenario sc){
//		System.out.println("Start");
//
//        // Create an ExtentHtmlReporter and specify the output path
//       // ExtentCucumberAdapter
//		ExtentTest t = ExtentService.getInstance().createTest(
//				com.aventstack.extentreports.gherkin.model.Feature.class, "T1");
//		//t.createNode("This is a second node");
//		t.createNode("<!DOCTYPE html> <html> <head> <style> table, th, td { border: 1px solid black; } </style> </head> <body> <h2>Table Test case1</h2> <p>Use the CSS border property to add a border to the table.</p> <table style=\"width:100%\"> <tr> <th>Firstname</th> <th>Lastname</th> <th>Age</th> </tr> <tr> <td>Jill</td> <td>Smith</td> <td>50</td> </tr> <tr> <td>Eve</td> <td>Jackson</td> <td>94</td> </tr> <tr> <td>John</td> <td>Doe</td> <td>80</td> </tr> </table> </body> </html>");
//		//t.createNode("<!DOCTYPE html> <html> <head> <style> table, th, td { border: 1px solid black; } </style> </head> <body> <h2>Table With Border</h2> <p>Use the CSS border property to add a border to the table.</p> <table style=\"width:100%\"> <tr> <th>Firstname</th> <th>Lastname</th> <th>Age</th> </tr> <tr> <td>Jill</td> <td>Smith</td> <td>50</td> </tr> <tr> <td>Eve</td> <td>Jackson</td> <td>94</td> </tr> <tr> <td>John</td> <td>Doe</td> <td>80</td> </tr> </table> </body> </html>");
//		//t.createNode("<!DOCTYPE html> <html> <head> <style> table, th, td { border: 1px solid black; } </style> </head> <body> <h2>Table With Border</h2> <p>Use the CSS border property to add a border to the table.</p> <table style=\"width:100%\"> <tr> <th>Firstname</th> <th>Lastname</th> <th>Age</th> </tr> <tr> <td>Jill</td> <td>Smith</td> <td>50</td> </tr> <tr> <td>Eve</td> <td>Jackson</td> <td>94</td> </tr> <tr> <td>John</td> <td>Doe</td> <td>80</td> </tr> </table> </body> </html>");
//		ExtentTest t2 = ExtentService.getInstance().createTest(
//				com.aventstack.extentreports.gherkin.model.Feature.class, "T2");
//		t2.createNode("<!DOCTYPE html> <html> <head> <style> table, th, td { border: 1px solid black; } </style> </head> <body> <h2>Table Test case2</h2> <p>Use the CSS border property to add a border to the table.</p> <table style=\"width:100%\"> <tr> <th>Firstname</th> <th>Lastname</th> <th>Age</th> </tr> <tr> <td>Jill</td> <td>Smith</td> <td>50</td> </tr> <tr> <td>Eve</td> <td>Jackson</td> <td>94</td> </tr> <tr> <td>John</td> <td>Doe</td> <td>80</td> </tr> </table> </body> </html>");
//	
//	}
//	
//	
//	@After
//	public void afterScenario(Scenario sc){
//		System.out.println("end");
//		//t.createNode("This is a test Nooodeeee");
//	}
//
//
//	
//}
