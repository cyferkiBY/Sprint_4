import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expectedResult;

    public AccountTest(String name, Boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Test
    @DisplayName("Check return value name to emboss")
    @Description("Check return value name to emboss with different names")
    public void checkReturnValueNameToEmboss(){
        Account account = new Account(name);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals(expectedResult, actualResult);
    }

    @Parameterized.Parameters
    public static Object[][] getAccountNameData() {
        return new Object[][] {
                {"Ivan Ivanov", true},
                {"I J", true},
                {"Ivan Abbudahmanchuk", true},
                {"Ivan Abbuhdahmanchuk", false},
                {" Ivan Ivanov", false},
                {"Ivan Ivanov ", false},
                {"Ivan Iva nov", false},
                {"Ivan  Ivanov", false},
                {"Ivan Ivanov2", false},
                {"Iv", false},
                {"Iv ", false},
                {" Iv", false},
                {"   ", false},
                {"", false},
                {null, false},
        };
    }

}