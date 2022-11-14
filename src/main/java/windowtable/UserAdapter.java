package windowtable;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import domain.ApustuAnitza;
import domain.Apustua;
import domain.Registered;

public class UserAdapter extends AbstractTableModel {

	private final List<ApustuAnitza> apustuak;
	private Registered register;
	private String[] colNames = new String[] { "Event", "Question", "Event Date", "Bet (€)" };

	public UserAdapter(Registered r) {
		// copy the HashMap data to a sequential data structure
		apustuak = new ArrayList<ApustuAnitza>(r.getApustuAnitzak());
		this.register = r;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vector<Apustua> bektorea = new Vector<Apustua>();
		for (int i = 0; i < register.getApustuAnitzak().size(); i++) {
			for (int j = 0; j < register.getApustuAnitzak().get(i).getApustuak().size(); j++)
				bektorea.add(register.getApustuAnitzak().get(i).getApustuak().get(j));
		}
		switch (columnIndex) {
		case 0:
			return ((Object) bektorea.get(rowIndex).getKuota().getQuestion().getEvent());
		case 1:
			return ((Object) bektorea.get(rowIndex).getKuota().getQuestion());
		case 2:
			return ((Object) bektorea.get(rowIndex).getKuota().getQuestion().getEvent().getEventDate());
		case 3:
			return ((Object) bektorea.get(rowIndex).getApustuAnitza().getBalioa());
		}
		return null;
	}

	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return apustuak.size();
	}
}
