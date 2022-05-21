package logical_unit.commands;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;
import logical_unit.users.Employee;
import presentation.others_graphic_component.AddEmployeeFrame;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class AddEmployess implements Command{

    private OrganizzationChart o;
    public AddEmployess(OrganizzationChart organizzationChart) {
        this.o = organizzationChart;
    }
    @Override
    public void execute() {
        new Executor(o).start();

    }

    private static class Executor extends Thread {

        private OrganizzationChart o;
        public Executor(OrganizzationChart o) {
            this.o = o;
        }

        @Override
        public void run() {
            AddEmployeeFrame ap = new AddEmployeeFrame();
            ap.config();
            while (!ap.finish()) {
                try {
                    sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Employee emp = ap.getEmployee();
            Role role = ap.getRole();
            if (emp == null || role == null)
                JOptionPane.showMessageDialog(null, "parametri non corretti");
            else if (!o.getSupportedRoles().contains(role))
                JOptionPane.showMessageDialog(null, "ruolo inserito non supportato");
            else {
                o.addMember(emp, role);
                JOptionPane.showMessageDialog(null, "operazione completata");
            }
            System.out.println(emp+" "+role);
        }
    }
}
