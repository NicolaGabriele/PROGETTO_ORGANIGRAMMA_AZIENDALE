package presentation.chart_rappresentation;

import logical_unit.commands.AddChartCommand;
import presentation.listeners.RappresentationPaneMouseListener;
import presentation.others_graphic_component.MyMenuItem;
import presentation.others_graphic_component.UsersDetails;

import javax.swing.*;
import java.awt.*;

public class RappresentationPanel extends JPanel{

    private JPopupMenu menu;
    private UsersDetails p;
    public RappresentationPanel(UsersDetails p){
        setBackground(Color.WHITE);
        add( menu = new JPopupMenu());
        menu.add(new MyMenuItem("add",new AddChartCommand(this)));
        addMouseListener(new RappresentationPaneMouseListener(this));
        this.p = p;
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

}//Rappresentation
