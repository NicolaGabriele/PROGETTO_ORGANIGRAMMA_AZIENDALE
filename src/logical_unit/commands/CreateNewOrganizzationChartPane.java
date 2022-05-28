package logical_unit.commands;

import presentation.MainFrame;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.SupportedRoleView;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import java.awt.*;

public class CreateNewOrganizzationChartPane implements Command{

    private JTabbedPane pane;
    private MainFrame mainFrame;
    public CreateNewOrganizzationChartPane(JTabbedPane pane, MainFrame mainFrame){
        this.pane = pane;
        this.mainFrame = mainFrame;
    }
    @Override
    public void execute() {
        String name = JOptionPane.showInputDialog(pane.getParent(),"inserisci il nome del file");
        if(name != null && !name.equals("")) {
            pane.addTab(name, new JScrollPane(new RappresentationPanel(mainFrame, name)));
            Container m = pane.getParent();
            while(!(m instanceof MainFrame))
                m = m.getParent();
            ((MainFrame)m).activateAllOption();
        }else
            JOptionPane.showMessageDialog(pane, "è obbligatorio specificare il nome del file");
    }
}//CreateNewOrganizzationChartPane
