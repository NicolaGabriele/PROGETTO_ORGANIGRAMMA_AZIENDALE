package logical_unit.commands;

import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;

public class CreateNewOrganizzationChartPane implements Command{

    private JTabbedPane pane;
    private UsersDetails p;
    public CreateNewOrganizzationChartPane(JTabbedPane pane, UsersDetails p){
        this.pane = pane;
        this.p = p;
    }
    @Override
    public void execute() {
        String name = JOptionPane.showInputDialog(pane.getParent(),"inserisci il nome del file");
        pane.addTab(name,new JScrollPane(new RappresentationPanel(p)));
    }
}//CreateNewOrganizzationChartPane
