package ru.aston.data;

public class CashHalper {

    public float rateExpectedLight(int distance, String time) {
        int hour = Integer.parseInt(time);
        if (hour > 600) {
            if (distance <= 10) return 0.6F;
            if (distance > 10 & distance <= 30) return 0.5F;
            if (distance > 30 & distance <= 100) return 0.4F;
            else return 0.3F;
        } else {
            if (distance <= 10) return 0.9F;
            if (distance > 10 & distance <= 30) return 0.8F;
            if (distance > 30 & distance <= 100) return 0.6F;
            else return 0.5F;
        }
    }

    public float rateExpectedMini(int distance, String time) {
        int hour = Integer.parseInt(time);
        if (hour > 600) {
            if (distance <= 10) return 0.8F;
            if (distance > 10 & distance <= 30) return 0.7F;
            if (distance > 30 & distance <= 100) return 0.6F;
            else return 0.4F;
        } else {
            if (distance <= 10) return 1.2F;
            if (distance > 10 & distance <= 30) return 1.0F;
            if (distance > 30 & distance <= 100) return 0.8F;
            else return 0.6F;
        }
    }

    public float rateExpectedBus(int distance, String time) {
        int hour = Integer.parseInt(time);
        if (hour > 600) {
            if (distance <= 10) return 1.2F;
            if (distance > 10 & distance <= 30) return 1.0F;
            if (distance > 30 & distance <= 100) return 0.8F;
            else return 0.7F;
        } else {
            if (distance <= 10) return 2.0F;
            if (distance > 10 & distance <= 30) return 1.5F;
            if (distance > 30 & distance <= 100) return 1.2F;
            else return 1.0F;
        }
    }
}
