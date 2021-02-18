package kz.iitu.assihnment1.demo;

import org.springframework.stereotype.Component;

@Component("services")
public class BankServices {

    public BankServices() {
    }

    public void checkBalance(Account account){
        System.out.println("Your current balance: " + account.getBalance());
    }

    public void withdraw(Account account, double amount){
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance()-amount);
            System.out.println("WithDraw: " + amount + ", remaining money on the card: " + account.getBalance());
        }
        else{
            System.out.println("You don't have enough money!");
        }
    }

    public void topUp(Account account, double amount){
        account.setBalance(account.getBalance()+amount);
        System.out.println("Top Up: " + amount + ", money on the card: " + account.getBalance());
    }
}
