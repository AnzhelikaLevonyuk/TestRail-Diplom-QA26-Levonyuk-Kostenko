# Test Automation Project

<a href="https://www.testrail.com">    
<img src="https://beliefy.io/wp-content/uploads/2023/05/test-rail-logo.png" align="right" height="100" />
</a>

### **Overview**

TestRail is a web-based test management tool designed to help software development teams manage and streamline their testing processes. 
TestRail helps teams improve their testing efficiency, ensure quality, and manage their testing  
efforts more effectively.

### **Project Description**
This code represents a set of tests for automated testing of an application using Selenium and TestNG, including API tests. It describes various test scenarios for verifying the functionality of the application, such as logging in, creating and editing projects, creating test cases, sections, milestones and etc.

### **Clone the repository into your projects directory:**

https://github.com/AnzhelikaLevonyuk/TestRail-Diplom-QA26-Levonyuk-Kostenko.git
<img src="https://tomaytotomato.com/content/images/2021/08/idea_maven.jpg" align="right" height="150"  />

### Installation:

* IDE: IntelliJ
* Programming Language: JAVA
* Project Type: Maven

<img src="https://miro.medium.com/v2/resize:fit:900/1*6bZs3KLKyklErU7DmgvOZA.jpeg" align="right" height="200" />
<img src="https://media.licdn.com/dms/image/D4D12AQH1GCJbqMykGw/article-cover_image-shrink_600_2000/0/1691676585590?e=2147483647&v=beta&t=97tvVyzZ7IaiL8AblLtGLGdILY6o3SHMMdLYcal9g40" align="right" height="90" />

### Stack:

* 	Selenium
* 	TestNG
* 	JavaFaker
* 	Lombok
<img src="https://media.licdn.com/dms/image/C5112AQFngbBhSj3ddw/article-cover_image-shrink_600_2000/0/1563569518559?e=2147483647&v=beta&t=imIxg_tXWA2mpdHp5ZPHoA0JtpbCS4iyR5ZsKK1445E" align="right" height="100" />

* 	Log4j
* 	Jackson
* 	Rest-Assured
*   Gson

### Patterns used:

* 	Page Object
* 	Element Decorators (Wrappers)
* 	Value Object
* 	Builder
* 	Loadable Page
<img src="https://allurereport.org/assets/re_preview.289b598a.png" align="right" height="200" />

### Reporting:
*	Allure reporting

### Global Usage:

*	GitHub

### Checklist:

#### Login

* 	Verify successful login with valid credentials.
* 	Verify unsuccessful login with one empty field.
* 	Verify unsuccessful login with both fields empty.
* 	Verify unsuccessful login with incorrect data.

#### Project
* 	Verify successful project creation with valid data.
* 	Verify unsuccessful project creation with invalid data (empty required fields).
* 	Verify successful project editing with valid data.
* 	Verify unsuccessful project editing with invalid data (empty required fields).
* 	Verify successful project deletion.
* 	Verify unsuccessful project deletion with an invalid project ID.
* 	Verify successful creating a new project using the API with generated data.
* 	Verify successful deleting a project using the API.
* 	Verify successful getting project information using the API.
* 	Verify successful getting all projects using the API.

#### TestCase
* 	Verify successful test case creation with valid data.
* 	Verify unsuccessful test case creation with invalid data (empty required fields).
* 	Verify successful test case editing with valid data.
* 	Verify unsuccessful test case editing with invalid data (empty required fields).
* 	Verify successful test case deletion.
* 	Verify unsuccessful test case deletion with an invalid test case ID.
* 	Verify successful creating a new test case using the API from a JSON file with a section.

#### Section
* 	Verify successful section creation with valid data.
* 	Verify unsuccessful section creation with invalid data (empty required fields).
* 	Verify successful section editing with valid data.
* 	Verify unsuccessful section editing with invalid data (empty required fields).
* 	Verify successful section deletion.
* 	Verify unsuccessful section deletion with an invalid section ID.
* 	Verify successful creating a new section using the API with a suite.
* 	Verify successful getting all sections using the API.
* 	Verify successful updating a section using the API.
* 	Verify successful deleting a section using the API.

#### Milestone
* 	Verify successful milestone creation with valid data.
* 	Verify unsuccessful milestone creation with invalid data (empty required fields).
* 	Verify successful milestone editing with valid data.
* 	Verify unsuccessful milestone editing with invalid data (empty required fields).
* 	Verify successful milestone deletion.
* 	Verify unsuccessful milestone deletion with an invalid milestone ID.
* 	Verify successful creating a milestone using the API from a JSON file.
* 	Verify successful creating a milestone using the API with generated data.
* 	Verify successful updating a milestone using the API.
* 	Verify successful getting milestone information using the API.
* 	Verify successful deleting a milestone using the API.

#### TestRun
* 	Verify successful creating a test run using the API from a JSON file.
* 	Verify successful creating a test run using the API with generated data.
* 	Verify successful getting test run information using the API.
* 	Verify successful updating a test run using the API.
* 	Verify successful deleting a test run using the API.

#### Plan
* 	Verify successful creating and then closing a plan using the API.
* 	Verify successful deleting a plan using the API.
* 	Verify successful updating a plan using the API from a JSON file.

### Instructions for running of tests:
1. Open resources directory
2. Open config.properties file
3. Change base_url
4. Change email
5. Change password

### TestNG command for running all tests and getting report:
-mvn clean test

-allure generate target/allure-results

-allure serve target/allure-results

##### By Anzhelika Levonyuk & Marina Kostenko
























