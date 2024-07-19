Test Automation using **Selenium**, **Cucumber**, **JUnit**, **Maven**, and **Java 17** with **Page Object Model**
---
---

## How to Create?

#### 1. Java 17
* [Download](https://www.oracle.com/technetwork/java/javase/downloads/index.html) and [install](https://docs.oracle.com/javase/10/install/installation-jdk-and-jre-macos.htm#JSJIG-GUID-F575EB4A-70D3-4AB4-A20E-DBE95171AB5F) JDK
* Setting the system variables
    * Set the Java paths in your .bash_profile file
        ```
        export JAVA_HOME=/Library/Java/JavaVirtualMachines/{JDK_VERSION_FOLDER}/Contents/Home
        export PATH=$PATH:$JAVA_HOME/bin
        ```
    * Save and exit your .bash_profile
* Type `java -version` in your Terminal to verify installation and find out your java version

#### 2. ChromeDriver
* Use the classic local path /drivers to download your current Chromedriver. The version depends of your local Chrome version.

#### 3. Maven
* [Download](https://maven.apache.org/download.cgi) [Maven](https://maven.apache.org/) as your build tools
* Extract downloaded maven into your current or random directory
* Adding maven to the environment path
* Add path variable to .bash_profile file
    ```
    export HOME=/{YOUR_DIRECTORY}/apache-maven-{YOURVERSION}
    export PATH=$PATH:$HOME/bin
    ```
* Verify your maven installation using `mvn -version` in your Terminal

#### 4. Intellij IDEA
* Download and install your IDE using [Intellij IDEA](https://www.jetbrains.com/idea/download/) or etc.
* Open your IDE that installed
* Create new project using Maven Project
    * Select File, New, Project...
    * [New Project] window opened
    * Select Maven, Select Project SDK using dropdown list, Next
    * Fill the field in Group Id, Artifact Id, Version, then Next
    * Edit some field if needed, Finish
    * Default Maven Project 
---

## How to Execute?

#### 1. Run the Test
* You are ready to automate the test in [Parabank.com](https://parabank.parasoft.com/parabank/index.htm) sign up
* Run your test using `mvn install` or `mvn verify` from Terminal

#### 2. Test Result
* See the result inside `target/cucumber-reports/advanced-reports/cucumber-html-reports` or `target/cucumber-reports/cucumber-pretty` folders that automatically generated after finished the test execution
* Open html file in your browser
* Or you can create your result view using json file inside  `target/cucumber-reports`