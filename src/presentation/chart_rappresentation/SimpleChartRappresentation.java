package presentation.chart_rappresentation;

import logical_unit.commands.AddEmployess;
import logical_unit.commands.AddRole;
import logical_unit.commands.ViewSupportedRolesCmd;
import logical_unit.commands.ViewUsersDetails;
import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.listeners.SimpleRappresentationMouseListener;
import presentation.others_graphic_component.MyMenuItem;
import presentation.others_graphic_component.SupportedRoleView;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;;
import java.awt.event.MouseMotionListener;


public class SimpleChartRappresentation extends Rappresentation implements MouseMotionListener{

    private int height,width;
    private static final int maxCaratteri = 22;
    private JPopupMenu popupMenu;
    private UsersDetails details;
    private SupportedRoleView srv;
    public SimpleChartRappresentation(OrganizzationChart subject, UsersDetails details, SupportedRoleView srv){
        super(subject);
        height = 50;
        width = 200;
        setPreferredSize(new Dimension(width+10,height+10));
        addMouseMotionListener(this);
        this.details = details;
        this.srv = srv;
        configPopUp();

    }

    private void configPopUp(){
        add(popupMenu = new JPopupMenu());
        addMouseListener(new SimpleRappresentationMouseListener(this));
        popupMenu.add(new MyMenuItem("nuovo dipendente",new AddEmployess(subject)));
        popupMenu.add(new MyMenuItem("dettagli dipendenti",new ViewUsersDetails(subject, details)));
        popupMenu.add(new MyMenuItem("aggiungi ruolo",new AddRole(subject)));
        popupMenu.add(new MyMenuItem("dettagli ruoli", new ViewSupportedRolesCmd(subject,srv)));
    }

    public void showMenu(){
        popupMenu.show(this,getMousePosition().x,getMousePosition().y);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("none",Font.BOLD,15));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(1,0,width,height);
        g2d.drawString(subject.getName(),2,15);
    }



    @Override
    public void mouseDragged(MouseEvent e) {
            Point p = getParent().getMousePosition();
            if (p != null && movable) {
                setLocation(p);
                setPosition(p);
            }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public String toString(){
        return subject.getName();
    }



}//SimpleChartRappresentation
