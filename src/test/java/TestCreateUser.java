import APIHooks.APIHook;
import CreateUserSteps.createUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class TestCreateUser  extends APIHook {

    @Test
    @DisplayName(value = "Создаем пользователя")
    public void createTest() throws IOException {
        createUser.createU();
    }


}
