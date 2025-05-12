package DAO;
import Koneksi.Connector;
import Models.*;
import DAOImplements.BukuImplement;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author aliad */
public class BukuDAO implements BukuImplement{
    Connection connection;
    final String selectQuery = "SELECT * FROM buku";
    final String insertQuery = "INSERT INTO buku (JudulBuku, PenulisBuku, PenerbitBuku) VALUES (?, ?, ?);";
    final String updateQuery = "UPDATE buku SET JudulBuku = ?, PenulisBuku = ?, PenerbitBuku = ? WHERE IdBuku = ?";

    public BukuDAO() {
        connection = Connector.connection();
    }
    
    @Override
    public void tambahBuku(BukuModel dataBuku) {
        PreparedStatement prepStatement = null;
        
        try {
            prepStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            prepStatement.setString(1, dataBuku.getJudul());
            prepStatement.setString(2, dataBuku.getPenulis());
            prepStatement.setString(3, dataBuku.getPenerbit());
            prepStatement.executeUpdate();
            
            ResultSet result = prepStatement.getGeneratedKeys();
            while (result.next()){
                dataBuku.setId(result.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void editBuku(BukuModel dataBuku) {
        PreparedStatement Preparedstatement = null;
        try {
            Preparedstatement = connection.prepareStatement(updateQuery);
            Preparedstatement.setString(1, dataBuku.getJudul());
            Preparedstatement.setString(2, dataBuku.getPenulis());
            Preparedstatement.setString(3, dataBuku.getPenerbit());
            Preparedstatement.setInt(4, dataBuku.getId());
            Preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                Preparedstatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void hapusBuku(int idBuku) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<BukuModel> showAllBuku() {
        List<BukuModel> dataBuku = null;
        
        try {
            dataBuku = new ArrayList<BukuModel>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectQuery);
            
            while(result.next()){
                BukuModel buku = new BukuModel();
                buku.setId(result.getInt("IdBuku"));
                buku.setJudul(result.getString("JudulBuku"));
                buku.setPenulis(result.getString("PenulisBuku"));
                buku.setPenerbit(result.getString("PenerbitBuku"));
                
                dataBuku.add(buku);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BukuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dataBuku;
    }
    
}
