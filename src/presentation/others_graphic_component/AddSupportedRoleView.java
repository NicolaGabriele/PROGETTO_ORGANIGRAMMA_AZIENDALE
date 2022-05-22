package presentation.others_graphic_component;

import logical_unit.organizzation_charts.Role;

import javax.swing.*;
import java.awt.*;

public class AddSupportedRoleView extends JFrame {

    private static final Dimension default_size = new Dimension(350,250);
    private JTextField roleName, rolePriority;
    private JLabel rn, rp;
    private JPanel p1,p2,p3,p4,principale;
    private JButton submit;
    private Role r;
    public AddSupportedRoleView(){
        config();
        r = null;
    }

    private void config(){
        setTitle("inserisci i dati del ruolo da aggiungere");
        setSize(default_size);
        setResizable(false);
        add(principale = new JPanel());
        principale.setLayout(new GridLayout(4,1));
        principale.add(p1 = new JPanel());
        principale.add(p2 = new JPanel());
        principale.add(p3 = new JPanel());
        principale.add(p4 = new JPanel());
        p1.add(new JLabel("Inserisci i dati del ruolo da aggiungere"));
        p2.add(rn = new JLabel("Nome del ruolo:"));
        p2.add(roleName = new JTextField());
        roleName.setColumns(20);
        p3.add(rp = new JLabel("priorita:"));
        p3.add(rolePriority = new JTextField());
        rolePriority.setColumns(20);
        p4.add(submit = new JButton("SUBMIT"));
        submit.addActionListener((e)->{
            try{
                String role = roleName.getText().trim();
                if(role.equals(""))
                    JOptionPane.showMessageDialog(this, "il nome è obbligatorio");
                int prior = Integer.parseInt(rolePriority.getText().trim());
                if(!role.equals("") && prior > 0)
                    r = new Role(role,prior);
            }catch(NumberFormatException er){
                JOptionPane.showMessageDialog(this, "la priorità deve essere un numero");
            }
        });
        setVisible(true);
    }

    public Role getRole(){
        return r;
    }
    public static void main(String...args){
        new AddSupportedRoleView().config();
    }
}
