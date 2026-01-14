# Test Automation using Java and Selenium WebDriver

**The purpose of this project is to implement end-to-end test automation.**

## Languages and Frameworks
This project uses the following languages and frameworks:

* [Java 21](https://openjdk.java.net/projects/jdk/21/) as the programming language
* [TestNG](https://testng.org/doc/) as the UnitTest framework to support the test creation
* [Selenium WebDriver](https://www.selenium.dev/) as the web browser automation framework using the Java binding
* [DataFaker](https://www.datafaker.net/) as the faker data generation strategy
* [Owner](http://owner.aeonbits.org/) to minimize the code to handle the properties file
## Test architecture

We know that any automation project starts with a good test architecture.
You will see the following items in this architecture:

* Page Objects pattern to model the web pages
* Page Factory to initialize the web elements
* BaseTest class to manage the WebDriver lifecycle
* Configuration files to manage the test environment
* Test Data Factory to generate test data using DataFaker

## Pipeline as code
I'm using GitHub Actions to run the tests in pipeline
* Workflow file is located at `.github/workflows`, it builds and execute the tests in three different browsers in parallel
    * CHROME
    * EDGE
    * FIREFOX