package presentation.chart_rappresentation;

import logical_unit.commands.AddChartCommand;
import logical_unit.commands.AddConnectionCommand;
import logical_unit.commands.ClosePanel;
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

    private JPopupMenu menu;
    private UsersDetails p;
    private java.util.List<Connection> connections;
    private MainFrame mainFrame;
    private String fileName;
    public RappresentationPanel(MainFrame mainFrame,String name){
        setBackground(Color.WHITE);
        this.mainFrame = mainFrame;
        add( menu = new JPopupMenu());
        addMouseListener(new RappresentationPaneMouseListener(this));
        setPreferredSize(MainFrame.DEFAULT_SIZE);
        this.p = p;
        connections = new LinkedList<Connection>();
        configPopUp();
        this.fileName = name;
    }


    public void configPopUp(){
        menu.add(new MyMenuItem("add",new AddChartCommand(this)));
        menu.add(new MyMenuItem("aggiungi connessione", new AddConnectionCommand(this, mainFrame)));
        menu.add(new MyMenuItem("rimuovi connessione", new RemoveConnection(this,mainFrame)));
        menu.add(new MyMenuItem("chiudi", new ClosePanel(this)));
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
            Connection ci = l;
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

    public void removeChart(Rappresentation r){
        remove(r);
        Iterator<Connection> it = connections.iterator();
        while (it.hasNext()){
            Connection c = it.next();
            if(c.getHead() == r || c.getTail() == r)
                it.remove();
        }
    }

    public String getFileName(){
        return fileName;
    }

    public void setFileName(String s){
        fileName = s;
    }

    public java.util.List<Connection> getConnections(){
        return connections;
    }
}//Rappresentation
