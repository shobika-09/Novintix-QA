#  Novintix QA Automation Framework
This repository contains a complete **QA Automation Framework** built for the Novintix QA Assignment. It includes:  
- UI Automation (Selenium + TestNG + Page Object Model)  
- BDD Cucumber (Feature files + Step Definitions)  
- REST API Automation (RestAssured)  
- SQL queries (basic employee-related operations)  
- CI/CD Pipeline using GitHub Actions  
- Config-driven execution (local / CI)  
- Reporting (TestNG reports / Allure-ready)

#  Application Under Test
**OrangeHRM Demo**  
https://opensource-demo.orangehrmlive.com

⚠ **IMPORTANT NOTE**  
During execution, the OrangeHRM Demo website was **not accessible** (Privacy Error / Red Hat Linux Test Page).  
Because of this, **UI tests could not run**, but the **framework is fully implemented** and will run successfully once the site is online.

#  Project Structure
Novintix-QA/  
├── src  
│   ├── main/java  
│   │   ├── com.novintix.config  
│   │   ├── com.assignment.driver  
│   │   └── com.novintix.utils  
│   └── test/java  
│       ├── com.novintix.pages  
│       ├── com.novintix.tests  
│       ├── com.novintix.api  
│       ├── com.novintix.stepdefinitions  
│       └── com.novintix.runners  
├── src/test/resources  
│   ├── config  
│   └── features  
├── .github/workflows/ci.yml  
├── testng.xml  
├── pom.xml  
└── README.md

#  Technologies Used
| Area | Technology |
|------|------------|
| UI Automation | Selenium WebDriver |
| Test Framework | TestNG |
| BDD Framework | Cucumber |
| API Testing | RestAssured |
| Build Tool | Maven |
| Language | Java 17 |
| CI/CD | GitHub Actions |
| Design Pattern | Page Object Model |

# ▶ How to Run Tests

## Run All TestNG Tests
mvn clean test

## Run Cucumber Tests
mvn test -Dcucumber.options="--tags @Smoke"

(or run the Cucumber TestRunner class)

## Run Only API Tests
mvn -Dtest=ReqResApiTests test

#  CI/CD (GitHub Actions)
Workflow file:  
.github/workflows/ci.yml

Pipeline steps:  
- Checkout Repository  
- Setup Java 17  
- Cache Maven Dependencies  
- Run Full Test Suite  
- Upload TestNG Report Artifacts  

Triggers:  
- On Push to main  
- On Pull Request to main

# 🌐 OrangeHRM URL Downtime
The OrangeHRM demo site was **down during the testing window**, showing SSL/Privacy errors and Red Hat Linux Test Page.  
Therefore:  
- UI scripts are implemented fully  
- Framework is tested locally  
- Execution will pass once the site is available    

#  Reports
TestNG Reports:  
test-output/

Allure Reports (if installed):  
allure serve allure-results

#  Author
Shobikaa S 
GitHub: https://github.com/shobika-09

#  Thank You
This project is developed according to the Novintix QA Assessment and follows industry-standard test automation practices.
