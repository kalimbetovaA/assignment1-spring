package kz.iitu.assihnment1.demo;

import java.util.List;

public class Bank {
    private String name;
    private List<Account> listOfAccounts;

    public Bank(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListOfAccounts(List<Account> listOfAccounts) {
        this.listOfAccounts = listOfAccounts;
    }

    public String getName() {
        return name;
    }

    public List<Account> getListOfAccounts() {
        return listOfAccounts;
    }
}
