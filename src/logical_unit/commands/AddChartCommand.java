package logical_unit.commands;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.CompositeOrganizzationChart;
import presentation.MainFrame;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.ChartTypeSelector;

import javax.swing.*;

public class AddChartCommand implements Command{

    private RappresentationPanel target;
    public AddChartCommand(RappresentationPanel target){
        this.target = target;
    }

    @Override
    public void execute() {
        new Excecutor().start();
    }

    private class Excecutor extends Thread{

        public void run(){
            String s = JOptionPane.showInputDialog(target,"inserisci il nome dell'organo");
            ChartTypeSelector c = new ChartTypeSelector(target);
            c.config();
            ChartTypeSelector.Type selection = c.getSelection();
            while(selection == null){
                try {
                    sleep(2_000);
                    selection = c.getSelection();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(selection);
            if(s != null){
                target.add(new SimpleChartRappresentation(
                        (selection == ChartTypeSelector.Type.COMPOSITE)?
                                new CompositeOrganizzationChart(s):
                                new BasicOrganizzationChart(s),target.getUsersDetailsPane(),
                        target.getSupportedRoleView()
                ));
            }
            target.repaint();
            target.revalidate();
        }
    }


}
