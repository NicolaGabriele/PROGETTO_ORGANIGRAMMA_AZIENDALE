package presentation.chart_rappresentation;

import logical_unit.commands.AddChartCommand;
import logical_unit.commands.AddConnectionCommand;
import presentation.MainFrame;
import presentation.listeners.RappresentationPaneMouseListener;
import presentation.others_graphic_component.*;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;


public class RappresentationPanel extends JPanel{

    private SupportedRoleView srv;
    private JPopupMenu menu;
    private UsersDetails p;
    java.util.List<Line> connections;
    public RappresentationPanel(UsersDetails p, SupportedRoleView srv, AddConnectionPanel connectionPanel){
        setBackground(Color.WHITE);
        add( menu = new JPopupMenu());
        menu.add(new MyMenuItem("add",new AddChartCommand(this)));
        menu.add(new MyMenuItem("aggiungi connessione", new AddConnectionCommand(this, connectionPanel)));
        addMouseListener(new RappresentationPaneMouseListener(this));
        setPreferredSize(MainFrame.DEFAULT_SIZE);
        this.p = p;
        this.srv = srv;
        connections = new LinkedList<Line>();
    }


    @Override
    public void paintComponent(Graphics g){
        for(Component c: getComponents())
            if(c instanceof Rappresentation && ((Rappresentation)c).getPosition() != null)
                c.setLocation(((Rappresentation)c).getPosition());
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        for(Line l: connections)
            g2d.drawLine(l.getStartX(),l.getStartY(),l.getEndX(),l.getEndY());
    }
    public void showMenu(){
        Point p = getMousePosition();
        if(p != null)
            menu.show(this,(int)p.getX(),(int)p.getY());
    }

    public UsersDetails getUsersDetailsPane(){
        return p;
    }

    public SupportedRoleView getSupportedRoleView(){
        return srv;
    }

    public void addConnection(Line l){
        connections.add(l);
    }

}//Rappresentation
