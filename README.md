# ECS-TechTest

This repository contains all files required to run, test and contribute to my submission for the ECS Digital tech-test. This application automatically starts the web server on both application and test run settings. In application mode the program will follow the instructions listed in the web page, which I will list below:

```
- Load the webpage
- Click on the 'RENDER THE CHALLENGE' button
- Obtain the three rows of data from the table
- perform the necessary calculations to obtain the three midpoints
- Submit the three integers found to the correct text field
- Submit my name to the final text field
- click the 'SUBMIT ANSWERS' button
- verify that the pop up has appeared with the correct text(only if ran as JUnit test suite)
- exit the program
```

## Dependencies

- Java 8
- Maven
- yarn
- npm
- JUnit core library 
- Selenium WebDriver
- Gecko-Driver

## Installation

Once you have ensured that all necessary dependencies have been installed, the application can then be run, simply open the project in your ide of choice, wait while maven installs the dependencies listed in *pom.xml* then run the application as a java application, selecting App.java as the main class. 