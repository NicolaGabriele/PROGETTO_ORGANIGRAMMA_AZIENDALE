package logical_unit.commands;

import logical_unit.organizzation_charts.Role;
import logical_unit.users.Employee;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.AddEmployeeDialog;

import javax.swing.*;

public class AddEmployess implements Command {

    private SimpleChartRappresentation rap;
    public AddEmployess(SimpleChartRappresentation rap) {
        this.rap = rap;
    }
    @Override
    public void execute() {
        AddEmployeeDialog a = new AddEmployeeDialog();
        a.createDialog("inserire i dati del dipendente").setVisible(true);
        Employee newEmp = a.getEmployee();
        Role newRole = a.getRole();
        if(newEmp == null || newRole == null )
            JOptionPane.showMessageDialog(rap, "parametri non corretti");
        else
            if(!rap.getSubject().getSupportedRoles().contains(newRole))
                JOptionPane.showMessageDialog(rap.getParent(), "il ruolo inserito non è compatibile con l'organo selezionato");
            else{
                rap.getSubject().addMember(newEmp, newRole);
                JOptionPane.showMessageDialog(rap, "operazione completata con successo");
            }

    }

}
