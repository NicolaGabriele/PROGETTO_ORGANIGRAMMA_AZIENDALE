package presentation.listeners;

import presentation.chart_rappresentation.SimpleChartRappresentation;
import presentation.others_graphic_component.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimpleRappresentationMouseListener implements MouseListener {

    private SimpleChartRappresentation target;

    public SimpleRappresentationMouseListener(SimpleChartRappresentation target) {
        this.target = target;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON3)
            target.showMenu();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
