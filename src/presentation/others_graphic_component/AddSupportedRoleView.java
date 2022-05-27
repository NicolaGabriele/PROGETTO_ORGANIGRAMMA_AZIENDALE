package presentation.others_graphic_component;

import logical_unit.organizzation_charts.Role;

import javax.swing.*;
import java.awt.*;

public class AddSupportedRoleView extends JOptionPane {

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
        removeAll();
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
            Container c = getParent();
            while(!(c instanceof JDialog))
                c = c.getParent();
            try{
                String role = roleName.getText().trim();
                if(role == null || role.equals("")) {
                    JOptionPane.showMessageDialog(this, "il nome è obbligatorio");
                    c.setVisible(false);
                    return;
                }
                int prior = Integer.parseInt(rolePriority.getText().trim());
                if( prior < 0) {
                    JOptionPane.showMessageDialog(this, "la priorità deve essere un numero positivo");
                    c.setVisible(false);
                    return;
                }
                System.out.println("correct");
                r = new Role(role,prior);
                c.setVisible(false);
            }catch(NumberFormatException er){
                JOptionPane.showMessageDialog(this, "la priorità deve essere un numero");
                c.setVisible(false);
            }
        });
    }

    public Role getRole(){
        Role ret = r;
        r = null;
        return ret;
    }
    public static void main(String...args){
        new AddSupportedRoleView().config();
    }
}
