import APIHooks.APIHook;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions

        (
                features = "src/test/resources/features/",
                glue = {"/APIHooks", "/stepDefinition", "/APISteps1"},
                plugin = {"pretty", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
                snippets = CucumberOptions.SnippetType.CAMELCASE
        )

public class  RunnerTest extends APIHook {


}
