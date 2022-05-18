package logical_unit.organizzation_charts;

import java.util.Collection;

public class BasicOrganizzationChart extends AbstractOrganizzationChart {

    public BasicOrganizzationChart(String name){
        super(name);
    }
    @Override
    public boolean add(OrganizzationChart organizzationChart) {
        throw new UnsupportedOperationException("elementi basilari possono essere solo foglie");
    }

    @Override
    public boolean remove(OrganizzationChart organizzationChart) {
        throw new UnsupportedOperationException("elementi basilari possono essere solo foglie");
    }

    @Override
    public boolean contain(OrganizzationChart organizzationChart) {
        throw new UnsupportedOperationException("elementi basilari possono essere solo foglie");
    }

    @Override
    public Collection<OrganizzationChart> getChildren() {
        throw new UnsupportedOperationException("elementi basilari possono essere solo foglie");
    }
}//BasicOrganizzationChart
