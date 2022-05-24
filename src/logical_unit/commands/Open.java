package logical_unit.commands;

import persistence.PersistenceUnit;
import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;
import java.io.File;

public class Open implements Command{


    private JTabbedPane tab;

    public Open(JTabbedPane tab) {
        this.tab = tab;
    }

    @Override
    public void execute() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("scegli il file");
        fileChooser.showDialog(null,"select");
        File f = fileChooser.getSelectedFile();
        RappresentationPanel target = PersistenceUnit.MANAGER.read(f);
        tab.addTab(f.getName(),new JScrollPane(target));
    }
}
