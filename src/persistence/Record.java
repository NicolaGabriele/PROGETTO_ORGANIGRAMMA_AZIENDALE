package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;

import java.awt.*;
import java.io.Serializable;

public class Record implements Serializable {

    private OrganizzationChart c;
    private Point position, location;

    public Record(OrganizzationChart c, Point position, Point location) {
        this.c = c;
        this.position = position;
        this.location = location;
    }

    public OrganizzationChart getElement() {
        return c;
    }

    public Point getPosition(){
        return position;
    }

    public Point getLocation(){
        return location;
    }
}
