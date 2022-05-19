package logical_unit.commands;

import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;

public class CreateNewOrganizzationChartPane implements Command{

    JTabbedPane pane;

    public CreateNewOrganizzationChartPane(JTabbedPane pane){
        this.pane = pane;
    }
    @Override
    public void execute() {
        String name = JOptionPane.showInputDialog(pane.getParent(),"inserisci il nome del file");
        pane.addTab(name,new JScrollPane(new RappresentationPanel()));
    }
}//CreateNewOrganizzationChartPane
