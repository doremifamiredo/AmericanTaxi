package ru.aston.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.aston.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[id=login_phone_field]");
    private SelenideElement passwordField = $("[id=login_pass_field]");
    private SelenideElement loginButton = $("[id=login_finish]");

    public OrderPage validVerify(DataHelper.AuthInfo authInfo) {
        loginField.sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.DELETE);
        loginField.setValue(authInfo.getPhone());
        passwordField.setValue(authInfo.getPassword());
        loginButton.click();
        return new OrderPage();
    }
}
