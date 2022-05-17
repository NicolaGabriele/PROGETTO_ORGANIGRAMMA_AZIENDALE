package logical_unit.organizzation_charts.builders;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.users.User;

import java.util.Collection;
public interface ChartBuilder {

    ChartBuilder steDescription(String description);
    ChartBuilder setName(String name);
    ChartBuilder setMembers(Collection<User> members);
    ChartBuilder addComponent(OrganizzationChart newOrganizzation);
    OrganizzationChart getChart();

}//ChartBuilder
