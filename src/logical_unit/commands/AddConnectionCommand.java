package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionDialog;

import javax.swing.*;
import java.io.Serializable;

public class AddConnectionCommand implements Command{

    private  RappresentationPanel target;
    private MainFrame mainFrame;

    public AddConnectionCommand(RappresentationPanel target, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.target = target;
    }

    @Override
    public void execute() {
        AddConnectionDialog a = new AddConnectionDialog();
        a.config(target, mainFrame,"seleziona l'organo di livello superiore");
        Rappresentation parent = a.getRappresentation();
        AddConnectionDialog a2 = new AddConnectionDialog();
        a2.config(target, mainFrame,"seleziona l'organo sottoposto");
        Rappresentation child = a2.getRappresentation();
        try {
            parent.getSubject().add(child.getSubject());
        }catch(UnsupportedOperationException e){
            JOptionPane.showMessageDialog(mainFrame,"organizzazioni semplici non possono avere organizzazioni sottoposte");
            mainFrame.show("pannello tabs");
            return;
        }
        mainFrame.show("pannello tabs");
        Connection c = new Connection(parent,child);
        target.addConnection(c);
        parent.setMovable(false);
        child.setMovable(false);
        target.repaint();
    }

}
