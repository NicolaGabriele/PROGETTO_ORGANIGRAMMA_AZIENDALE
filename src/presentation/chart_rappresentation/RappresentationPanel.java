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

    public void showMenu(){
        Point p = getMousePosition();
        if(p != null)
            menu.show(this,(int)p.getX(),(int)p.getY());
    }

}//Rappresentation
