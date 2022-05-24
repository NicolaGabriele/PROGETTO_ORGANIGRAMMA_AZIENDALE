package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;

import java.io.Serializable;

public class AddConnectionCommand implements Command{

    private  RappresentationPanel target;
    private AddConnectionPanel panel;

    public AddConnectionCommand(RappresentationPanel target,AddConnectionPanel panel) {
        this.panel = panel;
        this.target = target;
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
            target.addConnection(c);
            padre.setMovable(false);
            figlio.setMovable(false);
            target.repaint();

        }
    }
}
