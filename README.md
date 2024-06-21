# Assignment_Project1

This is a Maven-based project that demonstrates Behavior Driven Development (BDD) using Cucumber with Selenium WebDriver in Java. It includes sample feature files, step definitions, and a runner class for execution.

project-root
│
├── src/test/java
│   ├── runner
│   │   └── Runner.java       # Cucumber runner class
│   │
│   └── stepdefinitions       # Step definitions for feature files
│
└── src/test/resources
    └── features              # Feature files written in Gherkin
        └── *.feature

Runner.java: Cucumber runner class located at src/test/java/runner/Runner.java.
stepdefinitions: Package containing step definitions corresponding to feature files.
features: Directory containing .feature files written in Gherkin syntax.

Prerequisites:
Before running this project, ensure the following tools are installed:

Java Development Kit (JDK)
Maven
IDE (Eclipse, IntelliJ IDEA, etc.)


Setup Instructions

1.Clone the repository:
git clone <repository-url>
cd <project-folder>

2.Import the project into your IDE:

Open the project in your preferred IDE (Eclipse, IntelliJ IDEA, etc.) as a Maven project

3.Dependencies:

Dependencies are managed via Maven's pom.xml file. Ensure dependencies are downloaded and configured automatically by Maven.

Running Tests
Option 1: Run via Cucumber Runner
Execute the Cucumber tests using the provided runner class.

Navigate to Runner.java located at src/test/java/runner/Runner.java.
Right-click on Runner.java and select "Run" or "Debug" to execute the tests.
Option 2: Run as Maven Test
You can also run the tests using Maven directly from the command line.

Open a terminal or command prompt.

Navigate to the project directory.

Run the following command:
mvn clean test

Test Reports
Test reports are generated using ExtentReports and can be found in test-output/ExtentReports after running the tests.

