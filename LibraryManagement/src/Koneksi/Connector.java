package Koneksi;
import com.mysql.cj.jdbc.MysqlDataSource; //Cara cara mudah mengatur koneksi ke Databaswe
import java.sql.Connection; // interfce yang mepresentaikan koneksi ke database
import java.sql.SQLException; //Untuk error function bekaitan dengan database

/* @author aliad */
public class Connector {
    static Connection conn;
    
    public static Connection connection(){
        if(conn == null){
            MysqlDataSource database = new MysqlDataSource();
            database.setDatabaseName("ambaperpus");
            database.setUser("root");
            database.setPassword("");
            
            try {
                conn = database.getConnection();
                System.out.println("Koneksi Berhasil");
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Koneksi Gagal");
            }
        }
        return conn;
    }
}
