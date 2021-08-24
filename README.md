### RestAssured Framework with Cucumber, TestNg

Features

1. BDD using Cucumber
2. Maven based framework
3. RestAssured lib used for API interactions. 
4. Builder pattern for request, response mapping
5. Config.properties file for managing properties like browser
6. Log4j enabled for logging
7. Cli supports handling baseUrl
8. Parallel execution support using Testng
9. Report Generation (cucumber-reporting)

### Understanding is the basic code:
####Add the Feature file
Add the feature file under `test\resources\features\featurefile.feature`

#### Create the Runner

Add the Test runner at `test\java\testRunner\`
```java
@CucumberOptions(features = { "src/test/resources/features" }, 
        glue = {"stepdefinition",},
        plugin = { "pretty", "json:target/SearchFeatureRunner.json" })
public class TestRunner extends AbstractTestNGCucumberTests {
}
``` 

Add Response DTO for service under test inside domain/dto
```
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CryptoCurrencyInfoResDTO {
    private StatusDto status;
    private Map<String, DataDto> data = new LinkedHashMap<>();
}
```
Using lombok for reducing boilerplate code for model/data objects

Assign endpoints under EndPointsEnums as enum
```
PRICECONVERSIONS("tools/price-conversion"),
```
Where: -
features: represent the location of feature files from the compiled build
plugin: html,json report properties
glue: where the hooks and step definition is defined

#### Use the testng.xml file to run the test cases

### Project Execution

#### To clean and compile the build

`mvn clean install -DskipTests`

#### To run the project use this command

`mvn clean test`

#### Cucumber Report

Pretty Cucumber-Html Report
`C:\Users\S730737\Documents\Sumit\target\cucumber-report\cucumber-html-reports\overview-feature.html`

##### Command to run on chrome in headless mode
`mvn clean test -DbaseUrl=<test-url>`

