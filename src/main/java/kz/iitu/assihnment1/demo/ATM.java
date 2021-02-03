package kz.iitu.assihnment1.demo;

import java.util.List;
import java.util.Scanner;

public class ATM {
    private Bank bank;
    private BankServices services;

    public ATM(){}

    public ATM(Bank bank, BankServices services) {
        this.bank = bank;
        this.services = services;
    }

    public boolean identify(Account account, int pin){
        if(account.getPin()==pin){
            return true;
        }
        return false;
    }

    public Account chooseAccount(){
        List<Account> accounts=bank.getListOfAccounts();
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose card number to get access:");
        for (Account a : accounts) {
            System.out.println(a.getId()+") "+a.getCardNumber());
        }
        return accounts.get(sc.nextInt()-1);

    }

    public void showMenu(Account account){
        Scanner sc=new Scanner(System.in);
        while (true){
            System.out.println("What do you want to do: ");
            System.out.println("1 - withdraw\n"+
                    "2 - top up\n"+
                    "3 - check your balance\n"+
                    "0 - exit");
            int choice = sc.nextInt();
            int amount;
            switch (choice){
                case 1:
                    System.out.println("Enter amount:");
                    amount= sc.nextInt();
                    services.withdraw(account, amount);
                    break;
                case 2:
                    System.out.println("Enter amount:");
                    amount= sc.nextInt();
                    services.topUp(account, amount);
                    break;
                case 3:
                    services.checkBalance(account);
                    break;
            }
            if(choice==0){
                break;
            }
        }
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setServices(BankServices services) {
        this.services = services;
    }
}
