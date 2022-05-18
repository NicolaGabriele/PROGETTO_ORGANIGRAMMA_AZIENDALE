package presentation.view;

import logical_unit.organizzation_charts.OrganizzationChart;

import javax.swing.*;
import java.io.Serializable;

public abstract class Rappresentation extends JComponent implements Serializable {

    protected OrganizzationChart subject;

    public Rappresentation(OrganizzationChart subject){
        this.subject = subject;
    }
}
