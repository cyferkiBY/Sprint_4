import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        if (name == null) {
            this.name = "";
        } else {
            this.name = name;
        }
    }

    @Step("Check name {this.name} to emboss")
    public boolean checkNameToEmboss() {
        if ((name.length() < 3) | (name.length() > 19)) {
            return false;
        }
        if ((name.startsWith(" ")) | (name.endsWith(" "))) {
            return false;
        }
        if (name.split(" ").length-1 != 1) {
            return false;
        }
        if (name.isBlank()) {
            return false;
        }
        if (!name.matches("^[a-zA-Z ]+$")) {
            return false;
        }
        return true;
    }

}