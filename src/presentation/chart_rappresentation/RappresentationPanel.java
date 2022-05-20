package presentation.chart_rappresentation;

import logical_unit.commands.AddChartCommand;
import presentation.listeners.RappresentationPaneMouseListener;
import presentation.others_graphic_component.MyMenuItem;

import javax.swing.*;
import java.awt.*;

public class RappresentationPanel extends JPanel{

    private JPopupMenu menu;

    public RappresentationPanel(){
        setBackground(Color.WHITE);
        add( menu = new JPopupMenu());
        menu.add(new MyMenuItem("add",new AddChartCommand(this)));
        addMouseListener(new RappresentationPaneMouseListener(this));
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

}//Rappresentation
