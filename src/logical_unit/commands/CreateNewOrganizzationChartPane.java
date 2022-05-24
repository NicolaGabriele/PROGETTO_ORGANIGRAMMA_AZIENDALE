package logical_unit.commands;

import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;
import presentation.others_graphic_component.SupportedRoleView;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;

public class CreateNewOrganizzationChartPane implements Command{

    private  SupportedRoleView srv;
    private JTabbedPane pane;
    private UsersDetails p;
    private AddConnectionPanel addcp;
    public CreateNewOrganizzationChartPane(JTabbedPane pane, UsersDetails p, SupportedRoleView srv, AddConnectionPanel addcp){
        this.pane = pane;
        this.p = p;
        this.srv = srv;
        this.addcp = addcp;
    }
    @Override
    public void execute() {
        String name = JOptionPane.showInputDialog(pane.getParent(),"inserisci il nome del file");
        pane.addTab(name,new JScrollPane(new RappresentationPanel(p,srv,addcp, name)));
    }
}//CreateNewOrganizzationChartPane
