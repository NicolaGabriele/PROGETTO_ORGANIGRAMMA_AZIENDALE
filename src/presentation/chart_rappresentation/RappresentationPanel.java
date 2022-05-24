package presentation.chart_rappresentation;

import logical_unit.commands.AddChartCommand;
import logical_unit.commands.AddConnectionCommand;
import logical_unit.commands.RemoveConnection;
import logical_unit.organizzation_charts.Connection;
import presentation.MainFrame;
import presentation.listeners.RappresentationPaneMouseListener;
import presentation.others_graphic_component.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;


public class RappresentationPanel extends JPanel{

    private SupportedRoleView srv;
    private JPopupMenu menu;
    private UsersDetails p;
    java.util.List<Connection> connections;
    public RappresentationPanel(UsersDetails p, SupportedRoleView srv, AddConnectionPanel connectionPanel){
        setBackground(Color.WHITE);
        add( menu = new JPopupMenu());
        menu.add(new MyMenuItem("add",new AddChartCommand(this)));
        menu.add(new MyMenuItem("aggiungi connessione", new AddConnectionCommand(this, connectionPanel)));
        menu.add(new MyMenuItem("rimuovi connessione", new RemoveConnection(this,connectionPanel)));
        addMouseListener(new RappresentationPaneMouseListener(this));
        setPreferredSize(MainFrame.DEFAULT_SIZE);
        this.p = p;
        this.srv = srv;
        connections = new LinkedList<Connection>();
    }


    @Override
    public void paintComponent(Graphics g){
        for(Component c: getComponents())
            if(c instanceof Rappresentation && ((Rappresentation)c).getPosition() != null)
                c.setLocation(((Rappresentation)c).getPosition());
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        for(Connection l: connections) {
            Connection ci = (Connection)l;
            g2d.drawLine(ci.getStartX(), ci.getStartY(), ci.getEndX(), ci.getEndY());
        }
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

    public void addConnection(Connection l){
        connections.add(l);
    }

    public void removeConnection(Rappresentation padre, Rappresentation figlio){
        Connection target = null;
        for(Connection c: connections)
            if(c.getHead() == padre && c.getTail() == figlio) {
                target = c;
                break;
            }
        if(target != null)
            connections.remove(target);
    }

    public int numberOfConnections(Rappresentation r){
        int count = 0;
        for(Connection c: connections)
            if(c.getHead() == r || c.getTail() == r)
                count++;
        return count;
    }

}//Rappresentation
