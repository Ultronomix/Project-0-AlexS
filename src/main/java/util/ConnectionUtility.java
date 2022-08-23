package util;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
    private static final String URL ="";
    private static final String USER = "";
    private  static final String PASSWORD = "";
    private static Connection instance;

    public static Connection getInstance() throws SQLException{
        if (instance == null || instance.isClosed()){
            instance = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        return instance;
    }
    private ConnectionUtility(){}


}
