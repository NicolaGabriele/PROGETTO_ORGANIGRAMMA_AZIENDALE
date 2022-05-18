package application;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import persistence.PersistenceUnit;

public class Test {

    public static void main(String...args){
        BasicOrganizzationChart bs = new BasicOrganizzationChart("prova");
        PersistenceUnit.MANAGER.save(bs);
    }
}
