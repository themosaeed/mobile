


# Technologies

* JDK-21
* [Maven](https://maven.apache.org/) as a build tool.
* [TestNG](https://testng.org/) as a unit test framework.
* [SHAFT_ENGINE](https://github.com/MohabMohie/SHAFT_ENGINE) which is a Test Automation Engine that provides a unified high-level interface to any of the underlying test automation frameworks.
* [Appium ](https://appium.io/) for GUI testing.
* [Allure Report Framework](https://docs.qameta.io/allure/) for generating test execution report.



# Run the Test

Prerequisites:
- jdk-21 and maven should be installed
- emulator or real device connected


### Run the Test locally

* Run the following command
```
mvn clean test 
```
* The report will be generated automatically after running the test and will be in the allure-report folder
