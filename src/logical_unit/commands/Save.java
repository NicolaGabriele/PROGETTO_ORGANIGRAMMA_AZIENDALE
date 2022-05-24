package logical_unit.commands;

import persistence.PersistenceUnit;
import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;

public class Save implements Command{

    JTabbedPane tab ;

    public Save(JTabbedPane tab) {
        this.tab = tab;
    }

    @Override
    public void execute() {
        JScrollPane scrollPane = (JScrollPane) tab.getSelectedComponent();
        PersistenceUnit.MANAGER.save((RappresentationPanel) scrollPane.getViewport().getView());
        JOptionPane.showMessageDialog(null,"salvataggio effettuato");

    }
}
