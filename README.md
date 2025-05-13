Orange HRM Software Testing Project
Introduction
This repository is dedicated to testing the Orange HRM (Human Resource Management) platform. The project aims to explore and implement different software testing methodologies to ensure the system's functionality, security, and performance. As we progress, we will design test cases, automate testing processes, and document findings to enhance the overall quality of the Orange HRM platform.
Group 1 Members
•	Yasmin Sayed Khalifa
•	Anan Mohamed Abdelkader
•	Menna Ashraf Mohamed
•	Hoda Hisham Mahmoud
•	Zeinap Refaat Ali
Project Scope
Our focus will be on:
•	Understanding the Orange HRM system
•	Designing and executing test cases
•	Implementing automated and manual testing approaches
•	Identifying and reporting defects
Automation Project Structure
•	src/test/java/tests: Contains all test classes.
o	BaseTest.java: Sets up and tears down the WebDriver for each test.
o	PIMTests.java: Tests related to the PIM Module.
o	AdminTests.java: Tests for the User Management module.
o	RecruitmentTests.java: Tests for the Recruitment module.
o	LeaveTests.java: Tests for the Leave module.
o	PerformanceTests.java:Tests for the Performance Module.
•	src/main/java/pages: Page Object Model (POM) classes for different pages.
•	pom.xml: Maven configuration file for managing dependencies.
Features
•	Automated login functionality.
•	Navigation and verification of the Dashboard page.
•	User Management tests, including:
o	Searching for users.
o	Filtering users by role and status.
o	Resetting filters.
o	Verifying the Add User button functionality.
Technologies Used
•	Java: Programming language for writing test scripts.
•	Selenium WebDriver: For browser automation.
•	TestNG: Test framework for organizing and running tests.
•	Maven: Build and dependency management tool.
Prerequisites
•	Java 11 or higher installed.
•	Maven installed.
•	Chrome browser installed.
•	ChromeDriver compatible with your Chrome version.
Setup Instructions
1.	Clone the repository:
2.	https://github.com/yasminsayed-dev/final_project.git
Excel xlsx File
manual final project .xlsx
Bug Report
Bug_Report.pdf
Test Summary Report
Test_Summary_Report.pdf
Presentation
Testing-OrangeHRM-Manual-and-Automated-Approaches.pdf

