package presentation.chart_rappresentation;

import logical_unit.commands.AddChartCommand;
import logical_unit.commands.AddConnectionCommand;
import presentation.listeners.RappresentationPaneMouseListener;
import presentation.others_graphic_component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class RappresentationPanel extends JPanel{

    private SupportedRoleView srv;
    private JPopupMenu menu;
    private UsersDetails p;
    public RappresentationPanel(UsersDetails p, SupportedRoleView srv, AddConnectionPanel connectionPanel){
        setBackground(Color.WHITE);
        add( menu = new JPopupMenu());
        menu.add(new MyMenuItem("add",new AddChartCommand(this)));
        menu.add(new MyMenuItem("aggiungi connessione", new AddConnectionCommand(this, connectionPanel)));
        addMouseListener(new RappresentationPaneMouseListener(this));
        this.p = p;
        this.srv = srv;
    }


    @Override
    public void paintComponent(Graphics g){
        for(Component c: getComponents())
            if(c instanceof Rappresentation && ((Rappresentation)c).getPosition() != null)
                c.setLocation(((Rappresentation)c).getPosition());
        super.paintComponent(g);
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


}//Rappresentation
