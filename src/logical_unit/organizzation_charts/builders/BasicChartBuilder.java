package logical_unit.organizzation_charts.builders;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.users.User;

import java.util.Collection;

//TODO
public class BasicChartBuilder implements ChartBuilder{
    @Override
    public ChartBuilder steDescription(String description) {
        return null;
    }

    @Override
    public ChartBuilder setName(String name) {
        return null;
    }

    @Override
    public ChartBuilder setMembers(Collection<User> members) {
        return null;
    }

    @Override
    public ChartBuilder addComponent(OrganizzationChart newOrganizzation) {
        return null;
    }

    @Override
    public OrganizzationChart getChart() {
        return null;
    }
}
