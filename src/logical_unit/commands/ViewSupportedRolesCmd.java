package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.MainFrame;
import presentation.others_graphic_component.SupportedRoleView;

import java.awt.*;

public class ViewSupportedRolesCmd implements Command{

    private  OrganizzationChart o;
    private  MainFrame srv;

    public ViewSupportedRolesCmd(OrganizzationChart o, MainFrame srv){
        this.o = o;
        this.srv = srv;
    }

    @Override
    public void execute() {

        for(Component cmp: srv.getPannelloPrincipale().getComponents())
            if(cmp instanceof SupportedRoleView) {
                srv.getPannelloPrincipale().remove(cmp);
                srv.getLayoutManager().removeLayoutComponent(cmp);
            }
        SupportedRoleView n = new SupportedRoleView(srv);
        n.config(o.getSupportedRoles());
        srv.getPannelloPrincipale().add(n);
        srv.getLayoutManager().addLayoutComponent(
                n,"roles details"
        );
        srv.getLayoutManager().show(srv.getPannelloPrincipale(),"roles details");
    }
}
