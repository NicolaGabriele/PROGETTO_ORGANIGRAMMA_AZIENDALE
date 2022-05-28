package logical_unit.commands;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.CompositeOrganizzationChart;
import presentation.MainFrame;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.ChartTypeSelector;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class AddChartCommand implements Command{

    private RappresentationPanel target;
    private static int i = 1;
    public AddChartCommand(RappresentationPanel target){
        this.target = target;
    }

    @Override
    public void execute() {

        String s = JOptionPane.showInputDialog(target,"inserisci il nome dell'organo");
        if(s == null || s.equals("")){
            JOptionPane.showMessageDialog(target, "è obbligatorio inserire il nome");
            return;
        }

        for(Component component: target.getComponents())
            if(component instanceof Rappresentation &&
                    ((Rappresentation)component).getSubject().getName().equals(s)){
                JOptionPane.showMessageDialog(target, "non è possibile avere due organi omonimi");
                return;
            }

        String[] options = {"composito","semplice"};
        String ris = (String)JOptionPane.showInputDialog(null,"scegli il tipo di organizzazione",
                "scelta organizzazione",JOptionPane.PLAIN_MESSAGE,null, options,"composito");

        if(ris == null)
            return;

        Component c = target.getParent();
        while(! (c instanceof MainFrame))
            c = c.getParent();
        SimpleChartRappresentation simp = new SimpleChartRappresentation(
                (ris.equals("semplice"))?new BasicOrganizzationChart(s):new CompositeOrganizzationChart(s),
                (MainFrame)c);
        target.add(simp);
        simp.setLocation(0,0);
        simp.setPosition(new Point(0,0));
        if(target.getComponents().length > i*10) {
            target.setPreferredSize(new Dimension(target.getPreferredSize().width * 2,
                    target.getPreferredSize().height * 2));
            i++;
        }
        target.repaint();
        target.revalidate();

    }

}
