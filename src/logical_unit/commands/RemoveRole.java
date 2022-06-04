package logical_unit.commands;

import logical_unit.organizzation_charts.Role;
import logical_unit.users.User;
import presentation.chart_rappresentation.Rappresentation;
import presentation.others_graphic_component.SelectionFromList;

import javax.swing.*;
import java.util.Map;


public class RemoveRole implements Command{

    private Rappresentation target;

    public RemoveRole(Rappresentation target) {
        this.target = target;
    }

    @Override
    public void execute() {
        SelectionFromList<Role> s = new SelectionFromList<>();
        s.config(target.getSubject().getSupportedRoles().toArray(),"inserisci il ruolo da rimuovere");
        s.createDialog("scegli il ruolo da rimuovere").setVisible(true);
        Role selected = s.getSelected();
        if(selected == null)
            return;
        for(Map.Entry<User, Role> entry: target.getSubject().getEmployees().entrySet())
            if(selected.equals(entry.getValue())){
                JOptionPane.showMessageDialog(target,"non è possibile rimuovere un ruolo se \n" +
                                                             "ci sono ancora dei dipendenti che lo ricoprono");
                return;
            }
        target.getSubject().removeRole(selected);
        JOptionPane.showMessageDialog(target,"rimozione avvenuta con successo");
    }
}
