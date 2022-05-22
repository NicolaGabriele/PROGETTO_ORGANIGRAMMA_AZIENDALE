package presentation.others_graphic_component;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;
import logical_unit.users.Employee;
import logical_unit.users.User;
import presentation.MainFrame;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class UsersDetails extends JPanel {

    private MainFrame p;
    private JButton back;
    public UsersDetails(MainFrame p){
        this.p = p;
    }
    public void config(Map<User, Role> users){
        if(users ==null)
            throw new IllegalArgumentException();
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
        Record[] us = new Record[users.size()+1];
        int i = 0;
        for(User u: users.keySet()){
            us[i] = new Record(u,users.get(u));
            i++;
        }
        JList<Record> lista = new JList<Record>(us);
        add(new JScrollPane(lista));
        p.show("users details");
    }


    private static class Record{

        private int id;
        private String name,surname,role;
        public Record(User u, Role r) {
            this.id = u.getID();
            this.name = u.getName();
            this.surname = u.getSurname();
            this.role = r.toString();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getRole() {
            return role;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            return sb.append(" "+id).append("    ").append(name).append("    ").append(surname)
                    .append("    ").append(role).toString();
        }
    }//Record
}
