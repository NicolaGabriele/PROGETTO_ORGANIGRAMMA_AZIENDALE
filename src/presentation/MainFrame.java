package presentation;

import logical_unit.commands.CreateNewOrganizzationChartPane;
import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.Role;
import logical_unit.users.User;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.MyMenuItem;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class MainFrame extends JFrame {

    private CardLayout c;
    private JMenuBar barraMenu;
    private JMenu file, view;
    private  JTabbedPane tabs;
    private JPanel pannelloPrincipale,pannelloTabs;
    private UsersDetails usersDetails;
    private static final Dimension DEFAULT_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public MainFrame(){
        super("gestore organigrammi aziendali");
    }

    public void config(){
        setPreferredSize(DEFAULT_SIZE);
        setSize(DEFAULT_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(barraMenu = new JMenuBar());
        barraMenu.add(file = new JMenu("file"));
        barraMenu.add(view = new JMenu("view"));
        usersDetails  = new UsersDetails(this);
        configLayout();
        pannelloTabsConfig();
        file.add(new MyMenuItem("new",new CreateNewOrganizzationChartPane(tabs, usersDetails)));
        c.show(pannelloPrincipale,"pannello tabs");
        setVisible(true);
    }

    private void configLayout(){
        pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(c = new CardLayout());
        pannelloPrincipale.add(pannelloTabs = new JPanel());
        pannelloPrincipale.add(usersDetails);
        c.addLayoutComponent(usersDetails,"users details");
        add(pannelloPrincipale);
    }

    private void pannelloTabsConfig(){
        pannelloTabs.setLayout(new BorderLayout());
        pannelloTabs.add(tabs = new JTabbedPane());
        c.addLayoutComponent(pannelloTabs,"pannello tabs");
    }

    public void show(String s){
        c.show(pannelloPrincipale,s);
    }

    public UsersDetails getUserDetailsPanel(){
        return (UsersDetails) usersDetails;
    }

}
