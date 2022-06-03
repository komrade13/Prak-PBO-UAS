package Controller;

import javax.swing.JTable;
import View.ViewHistory;
import Model.ModelMain;

public class ConViewHistory {
    ViewHistory viewHistory;
    ModelMain model;

    public ConViewHistory(ViewHistory viewHistory, ModelMain model) {
        this.viewHistory = viewHistory;
        this.model = model;

        String dataTransc[][] = model.readTransc();
        viewHistory.table.setModel((new JTable(dataTransc, viewHistory.columnName)).getModel());
    }
}
