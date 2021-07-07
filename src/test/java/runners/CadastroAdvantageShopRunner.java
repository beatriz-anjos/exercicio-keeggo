package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "src/test/resources/features",
		glue = { "steps" },
		tags = {"@realizaCadastroAll"},
		monochrome = true
		)

public class CadastroAdvantageShopRunner {

}