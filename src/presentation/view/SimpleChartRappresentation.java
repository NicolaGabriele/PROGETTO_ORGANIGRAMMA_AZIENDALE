package presentation.view;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.OrganizzationChart;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import java.util.LinkedList;

public class SimpleChartRappresentation extends Rappresentation {

    private int height,width;

    private static final int maxCaratteri = 22;
    public SimpleChartRappresentation(OrganizzationChart subject){
        super(subject);
        height = 50;
        width = 200;
        setPreferredSize(new Dimension(width+10,height+10));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("none",Font.BOLD,15));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(1,0,width,height);
        g2d.drawString(subject.getName(),2,15);
        Collection<OrganizzationChart> coll = subject.getChildren();
        if(coll == null || coll.size() == 0)return;
        LinkedList<OrganizzationChart> stack = new LinkedList<>();
        for(OrganizzationChart o: coll)
            stack.addLast(o);

    }



    //test
    public static void main(String...args){
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        OrganizzationChart c = new BasicOrganizzationChart("direzione");
        f.setSize(500,500);
        SimpleChartRappresentation s = new SimpleChartRappresentation(c);
        p.add(s);
        f.add(p);
        p.setBackground(Color.white);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}//SimpleChartRappresentation
