package logical_unit.organizzation_charts;

import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;


public class CompositeOrganizzationChart extends AbstractOrganizzationChart{


    private TreeSet<OrganizzationChart> children;

    public CompositeOrganizzationChart(String name){
        super(name);
        this.children = new TreeSet<OrganizzationChart>();
    }

    @Override
    public boolean add(OrganizzationChart organizzationChart) {
        return children.add(organizzationChart);
    }//add

    @Override
    public boolean remove(OrganizzationChart organizzationChart) {
        return children.remove(organizzationChart);
    }//remove

    @Override
    public boolean contain(OrganizzationChart organizzationChart) {
        return children.contains(organizzationChart);
    }//contain

    @Override
    public Collection<OrganizzationChart> getChildren() {
        return Collections.unmodifiableCollection(children);
    }//getChildren

}//CompositeOrganizzationChart
