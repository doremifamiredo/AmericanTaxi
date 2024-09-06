package ru.aston.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.aston.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static ru.aston.data.DataHelper.CostInfo;

public class OrderPage {
    private SelenideElement start = $("#start");
    private SelenideElement finish = $("#end");
    private SelenideElement date = $("#date");
    private SelenideElement time = $("#time");
    private SelenideElement orderButton = $("#order_button");
    private SelenideElement orderMessage = $(".popup-text");

    public void makeOrder(DataHelper.OrderInfo orderInfo) {
        start.setValue(orderInfo.getStart());
        $(".pac-item").click();
        finish.setValue(orderInfo.getFinish());
        $(".pac-item").click();
        date.sendKeys(Keys.ENTER, Keys.TAB);
        time.sendKeys(Keys.HOME);
        time.setValue(orderInfo.getTime());
    }

    public CostInfo getCostInfo() {
        $("#cost-block").shouldBe(Condition.visible, Duration.ofSeconds(10));
        String distStr = $("#result-distance").getText();
        String rateStr = $("#rate-block-result").getText();
        String coStr = $("#cost-block").getText();
        int distance = DataHelper.extractInt(distStr, " км");
        float rate = DataHelper.extractFloat(rateStr, " копеек за км") / 100;
        float cost = DataHelper.extractFloat(coStr, " $");
        String pngFileName = screenshot("my_file_name");
        orderButton.click();
        return new DataHelper.CostInfo(distance, rate, cost);
    }

    public void findOrderMessage() {
        orderMessage.shouldHave(Condition.text("Ваш заказ успешно отправлен!"), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
        $("#popup .close").click();
    }
}
