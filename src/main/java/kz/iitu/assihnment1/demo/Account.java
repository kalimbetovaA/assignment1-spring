package kz.iitu.assihnment1.demo;

import java.sql.SQLException;

public class Account {
    private int id;
    private String fullName;
    private long cardNumber;
    private int pin;
    private double balance;
    private DBConnection db;

    public Account(int id, String fullName, long cardNumber, int pin, double balance, DBConnection db) {
        this.id = id;
        this.fullName = fullName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.db = db;
    }

    public void setBalance(double balance) {
        String sql="UPDATE `accounts` SET `balance` = "+balance+" WHERE `id` = "+this.id+";";
        try {
            db.execUpdate(sql);
            this.balance = balance;
        } catch (SQLException ex) {
            System.out.println("Error in updating!");
            ex.printStackTrace();
        }
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
