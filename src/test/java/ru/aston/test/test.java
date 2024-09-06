package ru.aston.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.*;
import ru.aston.data.CashHalper;
import ru.aston.data.DataHelper;
import ru.aston.page.LoginPage;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class test {

     DataHelper.Route[] routes = {new DataHelper.Route("ул. Долгобродская 43, Минск", "пер. Стахановский 2, Минск"), // короткий маршрут
            new DataHelper.Route("Тепличная 1, Минск", "Харьковская 30, Минск"), // cредний
            new DataHelper.Route("Артёма 1, Минск", "Радужная 20, Ратомка"), // длинный
            new DataHelper.Route("Радужная 1, Минск", "Ленина 10, Бобруйск")}; // очень длинный

    @Test
    void checkRate() {
        var loginPage = open("https://americantaxi-ru.andersenlab.com/index.php", LoginPage.class);
        var authInfo = DataHelper.getAuthIfoWithTestData();
        var orderPage = loginPage.validVerify(authInfo);
        var orderInfo = DataHelper.getOrderInfo(routes[3], DataHelper.generateNightTime());
        orderPage.makeOrder(orderInfo);
        $("#car-8").click();
        var costInfo = orderPage.getCostInfo();
        orderPage.findOrderMessage();
        CashHalper count = new CashHalper();
        float rateExp = count.rateExpectedBus(costInfo.getDistance(), orderInfo.getTime());
        Assertions.assertEquals(rateExp, costInfo.getCost());
    }
}
