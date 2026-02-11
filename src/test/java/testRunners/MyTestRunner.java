package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

public class MyTestRunner {
	@CucumberOptions(features = "src/test/resources/features",
			glue = { "stepDefinition", "AppHooks"},
			plugin= {"pretty"}

	)
	public class TestNGRunner extends AbstractTestNGCucumberTests {
		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}
}
