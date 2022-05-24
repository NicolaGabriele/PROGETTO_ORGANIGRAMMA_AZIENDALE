package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;

public class RemoveConnection implements Command{


    private AddConnectionPanel panel;
    private RappresentationPanel target;

    public RemoveConnection(RappresentationPanel target, AddConnectionPanel panel){
        this.target = target;
        this.panel = panel;
    }
    @Override
    public void execute() {
        new Executor().start();
    }


    private class Executor extends Thread{

        public void run(){
            panel.config(target, "seleziona l'elemento padre");
            Rappresentation padre = panel.getSelection();
            while(padre == null) {
                try {
                    Thread.sleep(2_000);
                    padre = panel.getSelection();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            panel.config(target, "seleziona l'elemento figlio");
            Rappresentation figlio = panel.getSelection();
            while(figlio == null) {
                try {
                    Thread.sleep(2_000);
                    figlio = panel.getSelection();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            padre.getSubject().add(figlio.getSubject());
            panel.getMainFrame().show("pannello tabs");
            Connection c = new Connection(padre,figlio);
            target.removeConnection(padre,figlio);
            if(target.numberOfConnections(padre) == 0)
                padre.setMovable(true);
            if(target.numberOfConnections(figlio) == 0)
                figlio.setMovable(true);
            target.repaint();

        }
    }
}
