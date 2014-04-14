
package uia.proyectofinal.Conecciones;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLDB {
    
   
    static final String DB_URL = "jdbc:mysql://localhost:3306/proyecto";
    static final String USER = "root";
    static final String PASS ="admin";
    private Connection con = null;
    private CallableStatement cstmt;
    private Statement stmt;

    public MySQLDB() {
    }
    
    public ResultSet executeQuery(String sql) throws SQLException{
        
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        cstmt = con.prepareCall(sql);
        ResultSet res = cstmt.executeQuery();
        return res;
    }
    
     public void execute(String sql) throws SQLException{
        con = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = con.createStatement();
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
    }
    
    public void closeExecute() throws SQLException{
        stmt.close();
        con.close();
    }
    
    public void closeExecuteQuery() throws SQLException{
        cstmt.close();
        con.close();
    }
}
