
import APIHooks.APIHook;
import JiraSteps.jiraAuth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class TestJira extends APIHook {
    @Test
    @DisplayName(value = "Логинимся в Жиру")
    public void jiraTest()  {
        jiraAuth.auth();
    }
}
