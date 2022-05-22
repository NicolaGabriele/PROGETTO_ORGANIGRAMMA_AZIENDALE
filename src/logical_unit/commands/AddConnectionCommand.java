package logical_unit.commands;

import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;
import presentation.others_graphic_component.Line;

import java.awt.*;

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

            Point a = padre.getPosition();
            Point b = figlio.getPosition();
            Point head = new Point(
                    (int)(a.getX()+padre.getWidth()/2),
                    (int)(a.getY()+padre.getHeight())
            );

            Point tail = new Point(
                    (int)(b.getX()+figlio.getWidth()/2),
                    (int)b.getY()
            );
            Line l = new Line(head,tail);
            target.add(l);
            l.setLocation(b);
            target.repaint();
            target.revalidate();
            padre.getSubject().add(figlio.getSubject());
            panel.getMainFrame().show("pannello tabs");
        }
    }
}
