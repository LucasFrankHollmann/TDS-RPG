package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
    
    private static String nomeDoBd = "RPGDB";
    private static String SenhaBD = "zdq12eac78wsx";
    private static String UserBD = "postgres";
    
    private static final String URL
            = "jdbc:postgresql://localhost:5432/"+nomeDoBd;
    
        private static Connection conn;
        
        public static Connection getConnection()
            throws SQLException {
            if (conn == null) {
                conn = DriverManager.getConnection(
                    URL, UserBD, SenhaBD);//url, usuario,senha
            }
            return conn;
        
        }
}
