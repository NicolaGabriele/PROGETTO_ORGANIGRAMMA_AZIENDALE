package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;
import presentation.chart_rappresentation.RappresentationPanel;

import javax.swing.*;
import java.io.File;


public interface Persistence{

    String orgChartDyrectory = "./organizzationChart";
    void save(RappresentationPanel element);
    RappresentationPanel read(File f);

}//Persistence
