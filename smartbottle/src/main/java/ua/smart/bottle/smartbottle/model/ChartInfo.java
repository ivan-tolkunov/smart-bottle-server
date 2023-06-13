package ua.smart.bottle.smartbottle.model;

public class ChartInfo {
    String time;
    double amount;

    public ChartInfo(String time, double amount) {
        this.time = time;
        this.amount = amount;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
