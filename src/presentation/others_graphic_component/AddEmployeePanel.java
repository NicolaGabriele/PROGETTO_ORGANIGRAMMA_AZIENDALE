package presentation.others_graphic_component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeePanel extends JPanel implements ActionListener {

    private JTextField id,name,surname,city, cap, street, roleName, rolePriority;
    private JButton submit;
    public void config(){
        setLayout(new GridLayout(10,1));
        JPanel label = new JPanel();
        label.add(new JLabel("DATI DIPENDENTE"));
        add(label);
        insert("id:",id);
        insert("name:",name);
        insert("surname:",surname);
        insert("città:",city);
        insert("cap",cap);
        insert("via:",street);
        insert("ruolo:",roleName);
        insert("priorità:",rolePriority);
        JPanel bp = new JPanel();
        bp.add(submit = new JButton("SUBMIT"));
        add(bp);
    }
    public void insert(String name, JTextField field){
        JPanel p = new JPanel();
        p.add(new JLabel(name));
        p.add(field = new JTextField());
        field.setColumns(20);
        add(p);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String...args){
        JFrame f = new JFrame();
        f.setSize(300,400);
        AddEmployeePanel a = new AddEmployeePanel();
        a.config();
        f.add(a);
        f.setVisible(true);
    }
}
