package logical_unit.commands;

import presentation.chart_rappresentation.Rappresentation;
import presentation.chart_rappresentation.RappresentationPanel;


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
