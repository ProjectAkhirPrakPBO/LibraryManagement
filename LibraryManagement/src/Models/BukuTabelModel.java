package Models;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/* @author aliad */
public class BukuTabelModel extends AbstractTableModel{
    List<BukuModel> dataBuku;
    
    public BukuTabelModel(List<BukuModel> dataBuku){
        this.dataBuku = dataBuku;
    }
    
    @Override
    public int getRowCount() {
        return dataBuku.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Judul";
            case 2:
                return "Penulis";
            case 3:
                return "Penerbit";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dataBuku.get(rowIndex).getId();
            case 1:
                return dataBuku.get(rowIndex).getJudul();
            case 2:
                return dataBuku.get(rowIndex).getPenulis();
            case 3:
                return dataBuku.get(rowIndex).getPenerbit();
            default:
                return  null;
        }
    }
    
}
