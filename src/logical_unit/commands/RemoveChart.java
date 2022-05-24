package logical_unit.commands;

import logical_unit.organizzation_charts.Connection;
import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;
import presentation.others_graphic_component.AddConnectionPanel;

public class RemoveChart implements Command{

    private Rappresentation target;

    public RemoveChart(Rappresentation target) {
        this.target = target;
    }

    @Override
    public void execute() {
        RappresentationPanel rap = (RappresentationPanel)target.getParent();
        rap.removeChart(target);
        rap.repaint();
    }

}
