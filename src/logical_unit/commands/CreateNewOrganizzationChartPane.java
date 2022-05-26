package logical_unit.commands;

import presentation.MainFrame;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;
import presentation.others_graphic_component.SupportedRoleView;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import java.awt.*;

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
        if(name != null && !name.equals("")) {
            pane.addTab(name, new JScrollPane(new RappresentationPanel(p, srv, addcp, name)));
            Container m = pane.getParent();
            while(!(m instanceof MainFrame))
                m = m.getParent();
            ((MainFrame)m).activateAllOption();
        }else
            JOptionPane.showMessageDialog(pane, "è obbligatorio specificare il nome del file");
    }
}//CreateNewOrganizzationChartPane
