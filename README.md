# WalletHubTest
Simulation of basic Selenium concepts integrated into a single framework design using Page Object modeling approach.

# Contents:

Source Folder having below packages:

main:
  -base package: Base of the whole project
  -config package: For configuration required to setup the project
  -drivers package: Contains necessary drivers required to run the scripts
  -pages package: Application pages covered during the simulation
  -Utilities package: Consists of all the common functions required
  
test:
  -tests package: Consists of all the test cases to be executed
 
# Tools Required:
Eclipse IDE
Integrated Maven
testNG

# How to Run...?
1. Pull the code to local machine
2. Import into Eclipse Workspace
3. Edit the Config file and provide the source folder path 
4. Update the configuration file path into the Utils.java class under utilities package
5. Run the testNG.xml runner file 

or 

Run the Maven POM.xml file and build the project.


# Reports
1. Validate the testNG reports from test-Output folder using index.html file.


