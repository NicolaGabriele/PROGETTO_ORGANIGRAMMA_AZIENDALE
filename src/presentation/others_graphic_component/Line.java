package presentation.others_graphic_component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

public class Line extends JComponent {


    private final int w,h;
    private  Point tail;
    private  Point head;

    public Line(Point head, Point tail){
        this.head = head;
        this.tail = tail;
        w = (int)(Math.abs(head.x - tail.x));
        h = (int)(Math.abs(head.y - tail.x));
        setSize(w,h);
        setPreferredSize(new Dimension(w,h));
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                setLocation(getParent().getMousePosition());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(0,0, (int) tail.getX(), (int) tail.getY());

    }

    public void setTail(Point tail) {
        this.tail = tail;
    }
    public void setTail(int x, int y){
        tail = new Point(x,y);
    }


}
