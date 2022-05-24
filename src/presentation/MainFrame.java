package presentation;

import logical_unit.commands.CreateNewOrganizzationChartPane;
import logical_unit.commands.Open;
import logical_unit.commands.Save;
import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.Role;
import logical_unit.users.User;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.AddConnectionPanel;
import presentation.others_graphic_component.MyMenuItem;
import presentation.others_graphic_component.SupportedRoleView;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout c;
    private JMenuBar barraMenu;
    private JMenu file, view;
    private  JTabbedPane tabs;
    private JPanel pannelloPrincipale,pannelloTabs;
    private UsersDetails usersDetails;
    private SupportedRoleView supportedRoleDetails;
    private AddConnectionPanel addConnectionPanel;
    public static final Dimension DEFAULT_SIZE = new Dimension(1080,720);
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
        pannelloTabs = new JPanel();
        usersDetails  = new UsersDetails(this);
        supportedRoleDetails = new SupportedRoleView(this);
        addConnectionPanel = new AddConnectionPanel(this);
        configLayout();
        pannelloTabsConfig();
        file.add(new MyMenuItem("new",new CreateNewOrganizzationChartPane(tabs, usersDetails,supportedRoleDetails,addConnectionPanel)));
        file.add(new MyMenuItem("save",new Save(tabs)));
        file.add(new MyMenuItem("apri", new Open(tabs)));
        c.show(pannelloPrincipale,"pannello tabs");
        setVisible(true);
    }

    private void configLayout(){
        pannelloPrincipale = new JPanel();
        pannelloPrincipale.setLayout(c = new CardLayout());
        pannelloPrincipale.add(pannelloTabs);
        pannelloPrincipale.add(usersDetails);
        pannelloPrincipale.add(supportedRoleDetails);
        pannelloPrincipale.add(addConnectionPanel);
        c.addLayoutComponent(pannelloTabs,"pannello tabs");
        c.addLayoutComponent(usersDetails,"users details");
        c.addLayoutComponent(supportedRoleDetails,"roles details");
        c.addLayoutComponent(addConnectionPanel,"add connection panel");
        add(pannelloPrincipale);
    }

    private void pannelloTabsConfig(){
        pannelloTabs.setLayout(new BorderLayout());
        pannelloTabs.add(tabs = new JTabbedPane());
    }

    public void show(String s){
        c.show(pannelloPrincipale,s);
    }

    public UsersDetails getUserDetailsPanel(){
        return (UsersDetails) usersDetails;
    }

}
