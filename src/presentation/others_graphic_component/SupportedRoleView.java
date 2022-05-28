package presentation.others_graphic_component;

import logical_unit.organizzation_charts.Role;
import presentation.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class SupportedRoleView extends JPanel {

    private MainFrame p;
    private JButton back;
    public SupportedRoleView(MainFrame p){
        this.p = p;
    }

    public void config(Collection<Role> roles){
        if(roles == null)
            return;
        System.out.println("roles size: "+roles.size());
        setLayout(new BorderLayout());
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(2,1));
        add(pan,BorderLayout.NORTH);
        JPanel panButton = new JPanel();
        panButton.setLayout(new BorderLayout());
        panButton.add(back = new JButton("<-"), BorderLayout.WEST);
        pan.add(panButton);
        pan.add(new JLabel(" nome     priorita"),BorderLayout.NORTH);
        back.addActionListener((e)->{p.show("pannello tabs");});
        Record[] rec = new Record[roles.size()];
        int i = 0;
        for(Role r: roles){
            rec[i] = new Record(r);
            i++;
        }
        add(new JScrollPane(new JList<Record>(rec)));
        p.show("roles details");
    }

    private static class Record{
        String role, priority;
        public Record(Role r){
            this.role = r.getName();
            this.priority = String.valueOf(r.getPriority());
        }
        public String toString(){
            return role+"    "+priority;
        }
    }
}
