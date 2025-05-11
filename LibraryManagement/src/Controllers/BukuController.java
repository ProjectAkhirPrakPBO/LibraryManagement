package Controllers;
import DAO.BukuDAO;
import DAOImplements.BukuImplement;
import Models.*;
import Views.BukuView;
import java.util.List;

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
    
}
