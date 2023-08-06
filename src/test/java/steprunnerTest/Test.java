package steprunnerTest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"html: target/cucumber.html"},
		features="use_cases",
		glue="steprunnerTest")
public class Test {

}
