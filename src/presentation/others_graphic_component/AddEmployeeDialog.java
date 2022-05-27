package presentation.others_graphic_component;

import logical_unit.organizzation_charts.Role;
import logical_unit.users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeDialog extends JOptionPane {

    private JTextField name,surname,city, cap, street, roleName, rolePrior;
    private JButton submit;
    private Font myFont;
    private Employee.Builder employee;
    private Role role;
    public AddEmployeeDialog(){
        super();
        removeAll();
        myFont = new Font("Times Romans",Font.BOLD, 12);
        setLayout(new GridLayout(7,2));
        name = new JTextField(20);
        surname = new JTextField(20);
        city = new JTextField(20);
        cap = new JTextField(20);
        street = new JTextField(20);
        roleName = new JTextField(20);
        rolePrior = new JTextField(20);
        insert("nome", name);
        insert("cognome", surname);
        insert("citta'", city);
        insert("cap", street);
        insert("roulo", roleName);
        insert("priorita'",rolePrior);
        JPanel submitPanel = new JPanel();
        submitPanel.add(submit = new JButton("SUBMIT"));
        add(submitPanel);
        submit.addActionListener(new SubmitListener());
        employee = null;
        role = null;
    }

    public void insert(String label, JTextField field){
        JPanel p = new JPanel();
        JLabel l = new JLabel(label);
        l.setFont(myFont);
        p.add(l);
        p.add(field);
        add(p);
    }

    public Employee getEmployee(){
        if(employee == null)
            return null;
        return employee.build();
    }

    public Role getRole(){
        return role;
    }

    private class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            Container d = AddEmployeeDialog.this.getParent();
            while(!(d instanceof JDialog))
                d = d.getParent();
            JDialog dialog = (JDialog)d;
            String name = AddEmployeeDialog.this.name.getText().trim();
            String surname = AddEmployeeDialog.this.surname.getText().trim();
            if( name == null || name.equals("") || surname == null || surname.equals("")){
                JOptionPane.showMessageDialog(AddEmployeeDialog.this.getParent(), "nome e cognome sono obbligatori");
                dialog.setVisible(false);
                return;
            }
            String role = AddEmployeeDialog.this.roleName.getText().trim();
            String city = AddEmployeeDialog.this.city.getText().trim();
            String cap = AddEmployeeDialog.this.cap.getText().trim();
            String street = AddEmployeeDialog.this.street.getText().trim();
            int rolePrior = -1;
            try {
                rolePrior = Integer.parseInt(AddEmployeeDialog.this.rolePrior.getText().trim());
            }catch(NumberFormatException err){
                JOptionPane.showMessageDialog(AddEmployeeDialog.this.getParent(),
                        "la priorità deve essere un numero");
                dialog.setVisible(false);
            }
            if(rolePrior <= 0){
                JOptionPane.showMessageDialog(AddEmployeeDialog.this.getParent(),
                                              "la priorità deve essere un numero positivo ");
                dialog.setVisible(false);
                return;
            }
            AddEmployeeDialog.this.employee = new Employee.Builder(name,surname).city(city).cap(cap).street(street);
            AddEmployeeDialog.this.role = new Role(role,rolePrior);
            dialog.setVisible(false);

        }
    }

}
