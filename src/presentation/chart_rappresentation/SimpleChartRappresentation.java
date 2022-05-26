package presentation.chart_rappresentation;

import logical_unit.commands.*;
import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.listeners.SimpleRappresentationMouseListener;
import presentation.others_graphic_component.MyMenuItem;
import presentation.others_graphic_component.SupportedRoleView;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
        setPreferredSize(new Dimension(width,height));
        addMouseMotionListener(this);
        this.details = details;
        this.srv = srv;
        configPopUp();
        setBackground(Color.CYAN);

    }

    private void configPopUp(){
        add(popupMenu = new JPopupMenu());
        addMouseListener(new SimpleRappresentationMouseListener(this));
        popupMenu.add(new MyMenuItem("nuovo dipendente",new AddEmployess(subject)));
        popupMenu.add(new MyMenuItem("dettagli dipendenti",new ViewUsersDetails(subject, details)));
        popupMenu.add(new MyMenuItem("aggiungi ruolo",new AddRole(subject)));
        popupMenu.add(new MyMenuItem("dettagli ruoli", new ViewSupportedRolesCmd(subject,srv)));
        popupMenu.add(new MyMenuItem("elimina", new RemoveChart(this)));
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
        g2d.setColor(getBackground());
        g2d.fillRect(1,0,width,height);
        g2d.setColor(Color.BLACK);
        g2d.drawString(subject.getName(),2,15);
        setBorder(new LineBorder(Color.BLACK));
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
