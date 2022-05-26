package logical_unit.commands;

import presentation.MainFrame;
import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;
import java.awt.*;

public class ClosePanel implements Command{

    private RappresentationPanel target;

    public ClosePanel(RappresentationPanel target) {
        this.target = target;
    }

    @Override
    public void execute() {
        Container m = target.getParent();
        while(!(m instanceof MainFrame))
            m = m.getParent();
        MainFrame mainFrame = (MainFrame) m;
        int save = JOptionPane.showConfirmDialog(mainFrame, "salvare?");

        if(save == JOptionPane.OK_OPTION)
            new Save(mainFrame.tab()).execute();

        mainFrame.tab().removeTabAt(mainFrame.tab().getSelectedIndex());

    }
}
