package logical_unit.organizzation_charts;

import logical_unit.users.User;
import persistence.Persistence;

import java.util.Collection;

//TODO
public class BasicChart implements OrganizzationChart {

    private String name, description;
    private Persistence persistence;

    public BasicChart(String name){
        if(name == null)
            throw new IllegalArgumentException("non è possibile definire diagrammi senza nome");
        this.name = name;
        this.description = "nessuna descrizione inserita";
    }

    @Override
    public boolean add(OrganizzationChart organizzationChart) {
        throw new UnsupportedOperationException("gli elementi basilari non hanno figli");
    }

    @Override
    public boolean remove(OrganizzationChart organizzationChart) {
        throw new UnsupportedOperationException("gli elementi basilari non hanno figli");
    }

    @Override
    public boolean contain(OrganizzationChart organizzationChart) {
        throw new UnsupportedOperationException("gli elementi basilari non hanno figli");
    }

    @Override
    public boolean isSupported(Role role) {
        return false;
    }//isSupported

    @Override
    public void addRole(Role role) {

    }

    @Override
    public void removeRole(Role role) {

    }

    @Override
    public void addMember(User member) {

    }

    @Override
    public void removeMember(User member) {

    }

    @Override
    public boolean isMember(User member) {
        return false;
    }

    @Override
    public Collection<OrganizzationChart> getChildren() {
        throw new UnsupportedOperationException("gli elementi basilari non hanno figli");
    }
}
