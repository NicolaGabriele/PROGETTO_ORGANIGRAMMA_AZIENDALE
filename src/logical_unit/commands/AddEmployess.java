package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;

public class AddEmployess implements Command{

    private OrganizzationChart o;
    public AddEmployess(OrganizzationChart organizzationChart){
        this.o = organizzationChart;
    }
    @Override
    public void execute() {

    }
}
