package kz.iitu.assihnment1.demo;

public class Account {
    private int id;
    private String fullName;
    private long cardNumber;
    private int pin;
    private double balance;

    public Account(int id, String fullName, long cardNumber, int pin, double balance) {
        this.id = id;
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFullName() {
        return fullName;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
