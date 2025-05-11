package DAOImplements;
import java.util.List;
import Models.*;

/* @author aliad */
public interface BukuImplement {
    public void tambahBuku(BukuModel dataBuku);
    public void editBuku(BukuModel dataBuku);
    public void hapusBuku(int idBuku);
    public List<BukuModel> showAllBuku();
}
