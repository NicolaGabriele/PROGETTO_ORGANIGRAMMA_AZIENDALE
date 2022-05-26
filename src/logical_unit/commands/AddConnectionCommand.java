package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;

import javax.swing.*;
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

            try {
                padre.getSubject().add(figlio.getSubject());
            }catch(UnsupportedOperationException e){
                JOptionPane.showMessageDialog(panel.getMainFrame(),"organizzazioni semplici non possono avere organizzazioni sottoposte");
                panel.getMainFrame().show("pannello tabs");
                return;
            }
            panel.getMainFrame().show("pannello tabs");
            Connection c = new Connection(padre,figlio);
            target.addConnection(c);
            padre.setMovable(false);
            figlio.setMovable(false);
            target.repaint();

        }
    }
}
