package logical_unit.organizzation_charts;

import exceptions.NotRemovableRoleException;
import exceptions.RoleNotSupportedException;
import logical_unit.users.Employee;
import logical_unit.users.User;
import presentation.chart_rappresentation.Rappresentation;

import java.lang.reflect.Member;
import java.util.*;

public abstract class AbstractOrganizzationChart implements OrganizzationChart{

    private String name, description;
    private List<Role> supportedRoles;
    private Map<User,Role> employees;
    private Rappresentation parent;
    public AbstractOrganizzationChart(String name){
        if(name == null)
            throw new IllegalArgumentException("non è possibile definire diagrammi senza nome");
        this.name = name;
        this.description = "nessuna descrizione inserita";
        this.supportedRoles = new LinkedList<Role>();
        this.employees = new TreeMap<User,Role>();
        this.parent = null;
    }

    @Override
    public abstract void removeAllChildren();
    @Override
    public Rappresentation getParent(){
        return parent;
    }
    @Override
    public void setParent(Rappresentation parent){
        this.parent = parent;
    }
    @Override
    public abstract boolean add(OrganizzationChart organizzationChart);

    @Override
    public abstract boolean remove(OrganizzationChart organizzationChart);

    @Override
    public abstract boolean contain(OrganizzationChart organizzationChart);

    @Override
    public boolean isSupported(Role role) {
        return supportedRoles.contains(role);
    }//isSupportedRole

    @Override
    public void addRole(Role role) {
        if(role != null && !supportedRoles.contains(role))
            supportedRoles.add(role);
    }//addRole

    @Override
    public void removeRole(Role role) {
        for(User e: employees.keySet())
            if(employees.get(e).equals(role))
                throw new NotRemovableRoleException();
        supportedRoles.remove(role);
    }//removeRole

    @Override
    public void addMember(User member, Role role) {
        if(! supportedRoles.contains(role))
            throw new RoleNotSupportedException();
        employees.put(member,role);
    }//addMember

    @Override
    public void removeMember(User member) {
        for(User m: employees.keySet())
            if(((Employee)m).equals((Employee) member)) {
                employees.remove(m);
                break;
            }
    }//removeMember

    @Override
    public boolean isMember(User member) {
        for(User u: employees.keySet())
            if(((Employee)u).equals((Employee) member)){
                return true;
            }
        return false;
    }

    @Override
    public abstract Collection<OrganizzationChart> getChildren();

    @Override
    public Map<User, Role> getEmployees() {
        return Collections.unmodifiableMap(this.employees);
    }//getEmployees

    @Override
    public Collection<Role> getSupportedRoles() {
        return Collections.unmodifiableCollection(supportedRoles);
    }//getSupportedRoles

    @Override
    public String getName(){
        return name;
    }//getName

    public String getDescription(){
        return description;
    }//getDescription

    @Override
    public boolean equals(Object o){
        if( o == null || !(o instanceof OrganizzationChart))
            return false;
        if(o == this)
            return true;
        return ((OrganizzationChart)o).getName().equals(name);
    }//equals

    @Override
    public String toString(){
        return "OrganizzationChart{ "+name+" }";
    }//toString

    @Override
    public int compareTo(OrganizzationChart o) {
        return getName().compareTo(o.getName());
    }
}//AbstractOrganizzationChart
