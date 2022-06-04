package logical_unit.commands;

import logical_unit.users.Employee;
import logical_unit.users.User;
import presentation.chart_rappresentation.Rappresentation;
import presentation.others_graphic_component.SelectionFromList;

import javax.swing.JOptionPane;


public class RemoveEmployee implements Command{

    private Rappresentation target;

    public RemoveEmployee(Rappresentation target) {
        this.target = target;
    }

    @Override
    public void execute() {
        SelectionFromList<Employee> s = new SelectionFromList<>();
        s.config(target.getSubject().getEmployees().keySet().toArray(),"seleziona un dipendente");
        s.createDialog("seleziona un dipendente").setVisible(true);
        User u = s.getSelected();
        if(u == null)
            return;
        target.getSubject().removeMember(u);
        JOptionPane.showMessageDialog(target, "rimozione effettuata");
    }
}
