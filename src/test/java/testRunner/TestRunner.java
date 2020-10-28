package testRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDefinition"},
        // reportType:location
        plugin = {"pretty", "html:test-output/html-report"},
        monochrome = true,
        dryRun = false
)
public class TestRunner {
}