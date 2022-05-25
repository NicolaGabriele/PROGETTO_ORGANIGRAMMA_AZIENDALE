package logical_unit.organizzation_charts;


import presentation.chart_rappresentation.Rappresentation;

import java.io.Serializable;

public class Connection implements Serializable {

    private int startX, startY, endX,endY;
    private Rappresentation parent,child;

    public Connection(Rappresentation parent, Rappresentation child) {
        this.parent = parent;
        this.child = child;
        this.startX = (int)(parent.getPosition().getX()+parent.getWidth()/2);
        this.startY = (int)(parent.getPosition().getY()+parent.getHeight()-10);
        this.endX = (int)(child.getPosition().getX()+child.getWidth()/2);
        this.endY = (int)child.getPosition().getY();
    }

    public Connection(Rappresentation parent, Rappresentation child, int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.parent = parent;
        this.child = child;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getEndX() {
        return endX;
    }

    public int getEndY() {
        return endY;
    }

    public Rappresentation getHead(){
        return parent;
    }

    public Rappresentation getTail(){
        return child;
    }
}
