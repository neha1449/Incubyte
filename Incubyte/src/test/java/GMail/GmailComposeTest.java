package GMail;

import cucumber.api.CucumberOptions;

//@RunWith(ExtendedCucumber.class)
@cucumber.api.CucumberOptions(features = "src/test/resources/ComposeMail/ComposeMail.Feature", glue = {
		"GmailComposeStepdef" },  plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class GmailComposeTest {

}
