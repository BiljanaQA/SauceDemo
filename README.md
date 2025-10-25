# SauceDemo Automation Tests

This project contains automated tests for the [SauceDemo](https://www.saucedemo.com/) website using **Java**, **Maven**, and the **TestNG** framework.

## Configuration

Before running the tests, you need to provide your own local paths in the `config.properties` file located at `src/test/resources/config.properties`:


### Example `config.properties` file:

```properties
chrome.driver.path=/Users/chromedriver
chrome.binary.path=/Applications/Google Chrome for Testing.app/Contents/MacOS/Google Chrome for Testing
