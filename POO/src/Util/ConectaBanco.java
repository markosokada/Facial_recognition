
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConectaBanco {

    public Statement stm;
    public ResultSet rs;
    public Connection conn;

    private final String driver = "org.mysql.Driver";
    private final String root = "jdbc:mysql://127.0.0.1/facial_recognition";
    private final String user = "root";
    private final String pass = "";

    public void conexao() {
        try {

            System.setProperty("jbdc.Driver", driver);
            conn = DriverManager.getConnection(root, user, pass);
            System.out.println("SuccessFull");

        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
    }
    public void executaSQL(String SQL){
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(SQL);
            
        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
    public static void main(String[] args){
        
        ConectaBanco conecta = new ConectaBanco();
        conecta.conexao();
    }
}
