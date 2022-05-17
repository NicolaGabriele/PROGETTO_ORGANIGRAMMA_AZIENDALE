package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;

import java.sql.SQLException;
import java.util.Collection;

public interface DBMSPersistence {

    Collection<Role> getSuppoertedRoles(OrganizzationChart organizzationChart) throws SQLException;
    Collection<OrganizzationChart> getChildren(OrganizzationChart organizzationChart)throws SQLException;

}
