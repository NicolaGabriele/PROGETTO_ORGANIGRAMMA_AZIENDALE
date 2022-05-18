package presentation.view;

import logical_unit.organizzation_charts.OrganizzationChart;

import javax.swing.*;
import java.awt.*;

public class RappresentationPanel extends JPanel {


    private OrganizzationChart root;

    public RappresentationPanel(OrganizzationChart root) {
        this.root = root;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        new SimpleChartRappresentation(root).paintComponent(g2d);
    }

}//Rappresentation
