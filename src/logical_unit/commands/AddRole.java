package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;
import presentation.others_graphic_component.AddSupportedRoleView;

import javax.swing.*;

public class AddRole implements Command{

    private  OrganizzationChart o;
    public AddRole(OrganizzationChart o){
        this.o = o;
    }
    @Override
    public void execute() {
        new Executor().start();
    }

    private final class Executor extends Thread{

        public void run(){
            AddSupportedRoleView ar = new AddSupportedRoleView();
            while(ar.getRole() == null) {
                try {
                    sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            o.addRole(ar.getRole());
            JOptionPane.showMessageDialog(ar, "operazione completata con successo");
            ar.setVisible(false);

        }
    }
}
