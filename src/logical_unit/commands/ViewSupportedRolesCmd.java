package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.others_graphic_component.SupportedRoleView;

public class ViewSupportedRolesCmd implements Command{

    private  OrganizzationChart o;
    private  SupportedRoleView srv;

    public ViewSupportedRolesCmd(OrganizzationChart o, SupportedRoleView srv){
        this.o = o;
        this.srv = srv;
    }

    @Override
    public void execute() {
        srv.config(o.getSupportedRoles());
    }
}
