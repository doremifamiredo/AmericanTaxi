package ru.aston.data;

import lombok.Value;

import java.util.Random;

public class DataHelper {
    private static Random random = new Random();

    public static String generateNightTime() {
        int min = random.nextInt(59);
        String minS = Integer.toString(min);
        if (min < 10) minS = "0" + minS;
        return "0" + random.nextInt(5) + minS;
    }

    public static String generateDayTime() {
        int hour = random.nextInt(23);
        if (hour < 6) hour = 6;
        int min = random.nextInt(59);
        String hourS = Integer.toString(hour);
        if (hour < 10) hourS = "0" + hourS;
        String minS = Integer.toString(min);
        if (min < 10) minS = "0" + minS;
        return hourS + minS;
    }

    public static AuthInfo getAuthIfoWithTestData() {
        return new AuthInfo("+375921591900", "4587f81a");
    }

    @Value
    public static class OrderStatus {
        String Order;
        String Status;
    }

    @Value
    public static class AuthInfo {
        String phone;
        String password;
    }

    @Value
    public static class OrderInfo {
        String start;
        String finish;
        String time;
    }


    public static OrderInfo getOrderInfo(Route route, String time) {
        return new OrderInfo(route.start, route.finish, time);
    }

    @Value
    public static class Route {
        String start;
        String finish;
    }

    @Value
    public static class CostInfo {
        int distance;
        float cost;
        float total;
    }

    public static float extractFloat(String text, String cut) {
        var finish = text.indexOf(cut);
        var value = text.substring(0, finish);
        return Float.parseFloat(value);
    }

    public static int extractInt(String text, String cut) {
        var finish = text.indexOf(cut);
        var value = text.substring(0, finish);
        float tmp = Float.parseFloat(value);
        return (int) tmp;
    }
}
