package logical_unit.commands;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.chart_rappresentation.SimpleChartRappresentation;

import javax.swing.*;

public class AddChartCommand implements Command{

    private RappresentationPanel target;
    public AddChartCommand(RappresentationPanel target){
        this.target = target;
    }

    @Override
    public void execute() {
        String s = JOptionPane.showInputDialog(target,"inserisci il nome dell'organo");
        if(s != null){
            target.add(new SimpleChartRappresentation(new BasicOrganizzationChart(s)));
        }

    }
}
