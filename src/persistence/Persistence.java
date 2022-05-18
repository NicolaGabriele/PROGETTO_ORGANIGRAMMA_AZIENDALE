package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;

import java.io.File;


public interface Persistence{

    String orgChartDyrectory = "./organizzationChart";
    void save(OrganizzationChart element);
    OrganizzationChart read(File f);

}//Persistence
