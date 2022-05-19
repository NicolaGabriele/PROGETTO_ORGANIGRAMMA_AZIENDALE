package presentation;

import logical_unit.commands.CreateNewOrganizzationChartPane;
import logical_unit.organizzation_charts.BasicOrganizzationChart;
import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.MyMenuItem;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JMenuBar barraMenu;
    private JMenu file, view;
    private  JTabbedPane tabs;
    private static final Dimension DEFAULT_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public MainFrame(){
        super("gestore organigrammi aziendali");
        setPreferredSize(DEFAULT_SIZE);
        setSize(DEFAULT_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setJMenuBar(barraMenu = new JMenuBar());
        barraMenu.add(file = new JMenu("file"));
        barraMenu.add(view = new JMenu("view"));
        add(tabs = new JTabbedPane());
        file.add(new MyMenuItem("new",new CreateNewOrganizzationChartPane(tabs)));
        JPanel  opt = new JPanel();
        opt.setBackground(Color.WHITE);
        add(opt,BorderLayout.EAST);
        setVisible(true);
    }
}
