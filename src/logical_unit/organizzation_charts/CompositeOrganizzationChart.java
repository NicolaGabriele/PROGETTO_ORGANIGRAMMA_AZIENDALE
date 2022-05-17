package logical_unit.organizzation_charts;

import logical_unit.users.User;

import java.util.Collection;
import java.util.TreeSet;


//TODO
public class CompositeOrganizzationChart implements OrganizzationChart{

    private String name, description;
    private TreeSet<OrganizzationChart> children;
    @Override
    public boolean add(OrganizzationChart organizzationChart) {
        return false;
    }

    @Override
    public boolean remove(OrganizzationChart organizzationChart) {
        return false;
    }

    @Override
    public boolean contain(OrganizzationChart organizzationChart) {
        return false;
    }

    @Override
    public boolean isSupported(Role role) {
        return false;
    }

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
        return null;
    }
}
