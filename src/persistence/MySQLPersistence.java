package persistence;

import logical_unit.organizzation_charts.OrganizzationChart;
import logical_unit.organizzation_charts.Role;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

public enum MySQLPersistence implements DBMSPersistence{
    DATABASE;

    private Connection connection;
    private final String user = "azienda";
    private final String password = "pass1";
    @Override
    public Collection<Role> getSuppoertedRoles(OrganizzationChart organizzationChart) throws SQLException {
        if(connection == null)
            connect();
        return null;
    }

    @Override
    public Collection<OrganizzationChart> getChildren(OrganizzationChart organizzationChart)throws SQLException {
        if(connection == null)
            connect();
        return null;
    }

     private void connect() throws SQLException{
        connection = DriverManager.getConnection("jdbc:mysql/localhost:3306/organigrammadb",user,password);
     }
}
