package kz.iitu.assihnment1.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> listOfAccounts;
    private DBConnection db;

    public Bank(){
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDb(DBConnection db) {
        this.db = db;
    }

    public String getName() {
        return name;
    }

    public List<Account> getListOfAccounts(){
        listOfAccounts=new ArrayList<Account>();
        String sql="SELECT * FROM accounts";
        try {
            ResultSet rs = db.execSQL(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("fullname");
                long cardNumber = rs.getLong("cardNumber");
                int pin = rs.getInt("pin");
                double balance = rs.getDouble("balance");
                listOfAccounts.add(new Account(id,fullname, cardNumber, pin, balance, db));
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOfAccounts;
    }
}
