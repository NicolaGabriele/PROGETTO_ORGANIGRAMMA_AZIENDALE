package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.others_graphic_component.UsersDetails;

public class ViewUsersDetails implements Command{

    private UsersDetails panel;
    private OrganizzationChart o;
    public ViewUsersDetails(OrganizzationChart o, UsersDetails panel){
        this.panel = panel;
        this.o = o;
    }
    @Override
    public void execute() {
        panel.config(o.getEmployees());
    }
}
