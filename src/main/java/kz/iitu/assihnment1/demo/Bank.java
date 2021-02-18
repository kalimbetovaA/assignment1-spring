package kz.iitu.assihnment1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("bank")
public class Bank {
    @Value("${bank.name}")
    private String name;
    private DBConnection db;

    public Bank(){
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void setDb(DBConnection db) {
        this.db = db;
    }

    public String getName() {
        return name;
    }

    public List<Account> getListOfAccounts(){
        List<Account> listOfAccounts=new ArrayList<Account>();
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
