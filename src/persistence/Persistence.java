package persistence;

import presentation.chart_rappresentation.RappresentationPanel;

import java.io.File;
import java.util.List;


public interface Persistence{

    String orgChartDyrectory = "./organizzationChart";
    void save(RappresentationPanel p);
    void read(File f, List<Record> rappresentations, List<ConnectionRecord> connections);

}//Persistence
