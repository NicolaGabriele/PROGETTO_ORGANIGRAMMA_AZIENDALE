package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.AddSupportedRoleView;

import javax.swing.*;

public class AddRole implements Command{

    private  SimpleChartRappresentation rap;
    public AddRole(SimpleChartRappresentation rap){
        this.rap = rap;
    }
    @Override
    public void execute() {
        AddSupportedRoleView as = new AddSupportedRoleView();
        as.createDialog("dettagli ruolo").setVisible(true);
        Role newRole = as.getRole();
        if(newRole != null)
            rap.getSubject().addRole(newRole);
    }

}
