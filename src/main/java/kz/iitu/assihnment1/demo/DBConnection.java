package kz.iitu.assihnment1.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;

@Component("db")
public class DBConnection {
    @Value("${db.driver}")
    private String driver;
    @Value("${db.dbUrl}")
    private String dbUrl;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    private Connection conn = null;
    private Statement stmt = null;

    public DBConnection(){}

    public DBConnection(String driver, String dbUrl, String user, String password) {
        this.driver = driver;
        this.dbUrl = dbUrl;
        this.user = user;
        this.password = password;
    }

    @PostConstruct
    public void init() {
        this.createDbConnection();
    }

    public void createDbConnection() {
        try {
            Class.forName(driver);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(dbUrl, user,password);
            stmt = conn.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        this.closeConnections();
    }

    public void closeConnections() {
        System.out.println("Closing connection...");
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet execSQL(String sql) throws SQLException {
        ResultSet rs = stmt.executeQuery(sql);
        return rs;
    }

    public int execUpdate(String sql) throws SQLException {
        int rs = stmt.executeUpdate(sql);
        return rs;
    }
}
