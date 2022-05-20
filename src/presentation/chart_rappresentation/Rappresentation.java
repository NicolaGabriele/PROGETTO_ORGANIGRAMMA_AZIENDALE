package presentation.chart_rappresentation;

import logical_unit.organizzation_charts.OrganizzationChart;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class Rappresentation extends JComponent implements Serializable {

    protected OrganizzationChart subject;
    private Point position;
    public Rappresentation(OrganizzationChart subject){
        this.subject = subject;
    }
    public Point getPosition(){
        return (position != null)?new Point(position.x,position.y):null;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
}
