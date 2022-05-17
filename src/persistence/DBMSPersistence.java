package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;

import java.util.Collection;

public interface DBMSPersistence {

    Collection<Role> getSuppoertedRoles(OrganizzationChart organizzationChart);
    Collection<OrganizzationChart> getChildren(OrganizzationChart organizzationChart);
    boolean config(String username);

}
