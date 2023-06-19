package driverscript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions (
		features = "src/test/resources/featurefiles",
		glue = "stepsdefination_demo")


public class Driverscript_saucedemo {

	private TestNGCucumberRunner testngcucumberunner = null;

	@BeforeClass(alwaysRun = true)
	public void setupclass() {
		testngcucumberunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "datapa")
	public void feature(CucumberFeatureWrapper cucumberfeature) {
		testngcucumberunner.runCucumber(cucumberfeature.getCucumberFeature());
	}

	@DataProvider(name = "datapa")
	public Object[][] features() {
		if (testngcucumberunner == null) {
			testngcucumberunner = new TestNGCucumberRunner(this.getClass());
		}
		return testngcucumberunner.provideFeatures();

	}
    @AfterClass(alwaysRun = true)
	public void terdown() {
		testngcucumberunner.finish();
	}

}
