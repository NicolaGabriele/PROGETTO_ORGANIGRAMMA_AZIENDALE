package persistence;

import java.io.Serializable;

public class ConnectionRecord implements Serializable {
    private String c1,c2;
    private int startX, startY, endX, endY;

    public ConnectionRecord(String c1, String c2, int startX, int startY, int endX, int endY) {
        this.c1 = c1;
        this.c2 = c2;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
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

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }

}
