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
    private static final int DEFAULT_SIZE = 10;
    public UsersDetails(MainFrame p){
        this.p = p;
    }
    public void config(Map<User, Role> users){
        if(users ==null)
            throw new IllegalArgumentException();
        setLayout(new BorderLayout());
        add(new JLabel(" id    nome    cognome    ruolo"),BorderLayout.NORTH);
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
