package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionDialog;

public class RemoveConnection implements Command{


    private MainFrame mainFrame;
    private RappresentationPanel target;

    public RemoveConnection(RappresentationPanel target, MainFrame mainFrame){
        this.target = target;
        this.mainFrame = mainFrame;
    }
    @Override
    public void execute() {
        AddConnectionDialog a = new AddConnectionDialog();
        a.config(target, mainFrame,"seleziona l'organo di livello superiore");
        Rappresentation parent = a.getRappresentation();
        AddConnectionDialog a2 = new AddConnectionDialog();
        a2.config(target, mainFrame,"seleziona l'organo sottoposto");
        Rappresentation child = a2.getRappresentation();
        parent.getSubject().remove(child.getSubject());
        child.getSubject().setParent(null);
        target.removeConnection(parent,child);
        if(target.numberOfConnections(parent) == 0)
            parent.setMovable(true);
        if(target.numberOfConnections(child) == 0)
            child.setMovable(true);
        target.repaint();
    }

}
