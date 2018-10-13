# ECS-TechTest

This repository contains all files required to run, test and contribute to my submission for the ECS Digital tech-test. This application automatically starts the web server on both application and test run settings. While the server automatically starts, the bash window it runs in must manually be closed using the command *Ctrl + c* due to problems closing the window using the created Java Process. In application mode the program will follow the instructions listed in the web page, which I will list below:

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

**Important:** this application is designed to work with the ECS Digital tech test repository, and must be placed in the correct folder - */s2e/* in order for the scripts to run. I have not included any ECS source files with this project however as I do not have permission to share those.

## Dependencies

- Java 8
- Maven
- yarn
- npm
- Selenium WebDriver
- Gecko-Driver
- Bash(windows) Xcode developer tools(Mac)

## Installation

Once you have ensured that all necessary dependencies have been installed, the application can then be run, simply open the project in your ide of choice, wait while maven installs the dependencies listed in *pom.xml* then run the application as a java application, selecting App.java as the main class. This will then launch the frontend server, allowing for the automated tests to run.

## Testing

The testing for this application is written using the JUnit framework, as this is listed as a maven dependency it should install automatically but if it does not more detailed installation instructions can be found [here](https://github.com/junit-team/junit4/wiki/Download-and-Install).

To run the testing suite simply run the application as a JUnit test suite, this will then automatically start the server before any tests are run, as well as opening and closing an automated browser for each test. 

## Credits
- ECS Digital: original project idea.
