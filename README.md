# Banking Automation Testing
This project encompasses automated testing for banking functionalities using Selenium WebDriver with Java. It includes tests for adding customers, bank manager login, opening accounts, and searching customers. The framework integrates Extent Reports for detailed test reporting, utilizes Excel for data-driven testing, captures screenshots upon test failures, and implements logging for better traceability.
# Features
- **Automated Test Cases:**

  - **AddCustomerTest.java:** Tests the functionality of adding a new customer.
  - **BankManagerLoginTest.java:** Verifies bank manager login capabilities.
  - **OpenAccountTest.java:** Tests the process of opening a new account.
  - **SearchCustomerTest.java:** Implements data-driven testing using Excel sheets for login credentials and searches for customers.
- **Reporting:**
    - Integrated Extent Reports to generate comprehensive and visually appealing test reports.
- **Error Handling:**
    - Captures screenshots automatically upon test failures for easier debugging.
  - **Logging:**
    - Implements logging to monitor test execution and identify issues promptly.
# Technologies Used
- **Java:** Programming language for writing test scripts.
- **Selenium WebDriver:** Browser automation tool.
- **TestNG:** Testing framework for organizing and running test cases.
- **Apache POI:** Library for reading and writing Excel files, facilitating data-driven testing.
- **Extent Reports:** Reporting library for generating detailed test reports.
- **Log4j:** Logging framework to capture and record log messages.
# Prerequisites
- **Java Development Kit (JDK):** Ensure JDK 8 or higher is installed.
- **Apache Maven**: For project build and dependency management.
- **Eclipse IDE (or any preferred IDE):** For code development and execution.
- **WebDriver Executables:** Ensure the appropriate WebDriver (e.g., ChromeDriver, GeckoDriver) is available in your system's PATH.
# Setup Instructions
 - Clone the Repository:
  ```git clone https://github.com/MahimaYadowansi/Banking-Automation-Testing.git```
```cd Banking-Automation-Testing```
- Import Project into IDE:
     - Open your IDE (e.g., Eclipse).
- Import the project as a Maven project.
- Resolve Dependencies:
  -Maven will automatically download and resolve all necessary dependencies as specified in the pom.xml file.
- WebDriver Setup:
   - Download the appropriate WebDriver for your browser (e.g., ChromeDriver).
   - Ensure the WebDriver executable is in your system's PATH or specify its path in the test setup.
# Running the Tests
 - **Using TestNG:**
    - Right-click on the testng.xml file.
    - Select Run As > TestNG Suite.
- **Using Maven:**
   ```mvn clean test```
# Test Reports and Artifacts
 - **Extent Reports:**
     - Generated reports can be found in the test-output/ExtentReports directory.
     - Open the ExtentReport.html file in a web browser to view detailed test results.
- **Screenshots:**
   - Screenshots captured during test failures are stored in the screenshots directory.
- **Logs:**
    - Log files detailing test execution are located in the logs directory.
