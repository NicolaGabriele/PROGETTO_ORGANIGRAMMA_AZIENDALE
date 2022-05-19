package presentation.chart_rappresentation;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.OrganizzationChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;;
import java.awt.event.MouseMotionListener;


public class SimpleChartRappresentation extends Rappresentation implements MouseMotionListener{

    private int height,width;

    private static final int maxCaratteri = 22;
    public SimpleChartRappresentation(OrganizzationChart subject){
        super(subject);
        height = 50;
        width = 200;
        setPreferredSize(new Dimension(width+10,height+10));
        addMouseMotionListener(this);
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



    //test
    public static void main(String...args){
        JFrame f = new JFrame();
        OrganizzationChart c = new BasicOrganizzationChart("direzione");
        SimpleChartRappresentation s = new SimpleChartRappresentation(c);
        RappresentationPanel p = new RappresentationPanel();
        f.setSize(500,500);
        p.add(s);
        f.add(p);
        p.setBackground(Color.white);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point p = getParent().getMousePosition();
        if(p != null)
            setLocation(p);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}//SimpleChartRappresentation
