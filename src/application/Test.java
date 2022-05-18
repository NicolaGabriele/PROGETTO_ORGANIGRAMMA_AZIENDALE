package application;

import logical_unit.organizzation_charts.BasicOrganizzationChart;
import logical_unit.organizzation_charts.CompositeOrganizzationChart;
import logical_unit.organizzation_charts.OrganizzationChart;
import persistence.PersistenceUnit;

import javax.swing.*;
import java.io.File;

public class Test {

    public static void main(String...args){
        CompositeOrganizzationChart bs = new CompositeOrganizzationChart("root");
        bs.add(new BasicOrganizzationChart("ciao"));
        bs.add(new BasicOrganizzationChart("ciao1"));
        bs.add(new BasicOrganizzationChart("ciao2"));
        bs.add(new CompositeOrganizzationChart("ciao33"));
        PersistenceUnit.MANAGER.save(bs);
        JFileChooser jfc = new JFileChooser();
        jfc.showDialog(null,"select");
        File f = jfc.getSelectedFile();
        CompositeOrganizzationChart compositeOrganizzationChart = (CompositeOrganizzationChart)PersistenceUnit.MANAGER.read(f);
        for(OrganizzationChart o : compositeOrganizzationChart.getChildren())
            System.out.println(o);
    }
}
