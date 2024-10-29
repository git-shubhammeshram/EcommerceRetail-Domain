This project is a comprehensive automated testing suite for an e-commerce web application. 
Built using Selenium with Java, it follows a data-driven framework and leverages TestNG for test management. 
The project also integrates Extent Reports for detailed test results and loggers for real-time insights, ensuring efficient and robust testing.

Key Features
Selenium Automation: Automates key user flows like login, product search, add-to-cart, and checkout.
Data-Driven Testing: Parameterizes test data using external sources (e.g., Excel) to ensure wide test coverage across multiple scenarios.
TestNG Integration: Manages test execution, suite configurations, and reporting.
Extent Reporting: Generates visually rich HTML reports with screenshots and step-by-step logs for each test case.
Logger Support: Provides detailed logging for each test step, helping with debugging and tracking issues.


Project Structure
src/main: Contains framework setup, utility classes, and test data.
src/test: Houses all test cases and TestNG XML configurations.
resources: Stores the test data files and configuration files.
reports: Auto-generated Extent Reports for every test execution.

Getting Started
Clone the repo: git clone <repo-url>
Install dependencies and configure the environment.
Execute tests: Run using TestNG XML files or command-line options.
View Reports: Access detailed reports in the reports directory post-execution.


Technologies Used
Java
Selenium WebDriver
TestNG
Extent Reports
Logger
