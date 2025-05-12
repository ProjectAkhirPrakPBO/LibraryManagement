package Controllers;
import DAO.BukuDAO;
import DAOImplements.BukuImplement;
import Models.*;
import Views.BukuView;
import java.util.List;
import javax.swing.JOptionPane;

/* @author aliad */
public class BukuController {
    BukuView bukuFrame;
    BukuImplement implementBuku;
    List<BukuModel> dataBuku;

    public BukuController(BukuView bukuFrame) {
        this.bukuFrame = bukuFrame;
        implementBuku = new BukuDAO();
        dataBuku = implementBuku.showAllBuku();
    }
    
    public void loadDataTabel(){
        dataBuku = implementBuku.showAllBuku();
        BukuTabelModel bukuTblModel = new BukuTabelModel(dataBuku);
        bukuFrame.getTabelDataBuku().setModel(bukuTblModel);
    }
    
    public void insertDataTabel(){
        BukuModel buku = new BukuModel();
        
        buku.setJudul(bukuFrame.getTxtJudul().getText());
        buku.setPenulis(bukuFrame.getTxtPenulis().getText());
        buku.setPenerbit(bukuFrame.getTxtPenerbit().getText());
        
        if ((buku.getJudul()).equals("") || (buku.getPenulis()).equals("") || (buku.getPenerbit()).equals("")) {
            JOptionPane.showMessageDialog(bukuFrame, "Isi Lengkap Data Terlebih Dahulu");
            return;
        }
        else {
            implementBuku.tambahBuku(buku);
            JOptionPane.showMessageDialog(bukuFrame, "Data Buku Berhasil Ditambahkan");
        }
    }
    
    public void updateDataTabel(){
        BukuModel buku = new BukuModel();
       
        buku.setId(Integer.parseInt(bukuFrame.getTxtID().getText()));
        buku.setJudul(bukuFrame.getTxtJudul().getText());
        buku.setPenulis(bukuFrame.getTxtPenulis().getText());
        buku.setPenerbit(bukuFrame.getTxtPenerbit().getText());
        
        if ( (buku.getId()) == 0 || (buku.getJudul()).equals("") || (buku.getPenulis()).equals("") || (buku.getPenerbit()).equals("")) {
            JOptionPane.showMessageDialog(bukuFrame, "Isi Field Data Terlebih Dahulu");
            return;
        }
        else {
            implementBuku.editBuku(buku);
            JOptionPane.showMessageDialog(bukuFrame, "Data Buku Berhasil Diedit");
        }
    }
    
    public void deleteDataTabel(){
        int idBuku = Integer.parseInt(bukuFrame.getTxtID().getText());
        
        int confirmDelete = JOptionPane.showConfirmDialog(bukuFrame, "Apakah Anda Yakin Untuk Menghapus Buku ini ? ");
       
        if (confirmDelete == JOptionPane.YES_OPTION) {
            implementBuku.hapusBuku(idBuku);
        }
    }
}
