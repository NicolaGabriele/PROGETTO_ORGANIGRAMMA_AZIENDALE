package presentation.others_graphic_component;

import logical_unit.organizzation_charts.Role;
import logical_unit.users.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Semaphore;

public class AddEmployeeFrame extends JFrame implements ActionListener{

    private JPanel pannello;
    private JTextField name,surname,city, cap, street, roleName, rolePriority;
    private JButton submit;
    private Employee.Builder builder;
    private Role role;
    private boolean finish;
    public AddEmployeeFrame(){
        name = new JTextField();
        surname = new JTextField();
        city = new JTextField();
        cap = new JTextField();
        street = new JTextField();
        roleName = new JTextField();
        rolePriority = new JTextField();
        finish = false;
    }
    public void config(){
        setSize(300,400);
        pannello = new JPanel();
        pannello.setLayout(new GridLayout(9,1));
        JPanel label = new JPanel();
        label.add(new JLabel("DATI DIPENDENTE"));
        pannello.add(label);
        insert("name:",name);
        insert("surname:",surname);
        insert("città:",city);
        insert("cap",cap);
        insert("via:",street);
        insert("ruolo:",roleName);
        insert("priorità:",rolePriority);
        JPanel bp = new JPanel();
        bp.add(submit = new JButton("SUBMIT"));
        submit.addActionListener(this);
        pannello.add(bp);
        add(pannello);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                finish = true;
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                finish = true;
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                super.windowDeactivated(e);
                finish = true;
            }
        });
        setVisible(true);
    }

    public boolean finish(){
        return finish;
    }
    public void insert(String name, JTextField field){
        JPanel p = new JPanel();
        p.add(new JLabel(name));
        p.add(field);
        field.setColumns(20);
        pannello.add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(name.getText().equals("") || surname.getText().equals("")) )
            builder = new Employee.Builder(name.getText().trim(),surname.getText().trim())
                    .cap(cap.getText().trim())
                    .city(city.getText().trim())
                    .street(street.getText().trim());
        try {
            role = new Role(roleName.getText().trim(), Integer.parseInt(rolePriority.getText().trim()));
        }catch(NumberFormatException err){
            JOptionPane.showMessageDialog(this,"La priorità deve essere un numero");
            role = null;
        }
        setVisible(false);
        finish = true;
    }


    public Employee getEmployee(){
        return (builder != null)?builder.build():null;
    }
    public Role getRole(){
        return role;
    }



}
