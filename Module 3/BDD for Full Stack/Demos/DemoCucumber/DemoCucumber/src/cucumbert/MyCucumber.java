package cucumbert;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"pretty","json:target"},
		features={"src/cucumbert"}
		)
public class MyCucumber {

}
