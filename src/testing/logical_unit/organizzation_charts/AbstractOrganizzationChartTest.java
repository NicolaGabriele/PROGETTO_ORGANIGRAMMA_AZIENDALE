package logical_unit.organizzation_charts;

import logical_unit.users.Employee;
import org.junit.jupiter.api.Test;
import presentation.MainFrame;

import static org.junit.jupiter.api.Assertions.*;

class AbstractOrganizzationChartTest {

    @Test
    void isSupported() {
        CompositeOrganizzationChart c = new CompositeOrganizzationChart("test");
        c.addRole(new Role("role",2));
        assertEquals(true, c.isSupported(new Role("role", 2)));
        assertEquals(false, c.isSupported(new Role("anotherRole",3)));
    }

    @Test
    void addRole() {
        CompositeOrganizzationChart c = new CompositeOrganizzationChart("test");
        c.addRole(new Role("role",1));
        assertEquals(1, c.getSupportedRoles().size());
        c.addRole(new Role("role", 1));
        assertEquals(1, c.getSupportedRoles().size());
        c.addRole(new Role("anotherRole", 2));
        assertEquals(2, c.getSupportedRoles().size());
    }

    @Test
    void removeRole() {
        CompositeOrganizzationChart c = new CompositeOrganizzationChart("test");
        c.addRole(new Role("role",1));
        c.addRole(new Role("role2",1));
        c.removeRole(new Role("role",1));
        assertEquals(1, c.getSupportedRoles().size());
        c.removeRole(new Role("this isn't  a role",1));
        assertEquals(1, c.getSupportedRoles().size());
        c.removeRole(new Role("role2", 1));
        assertEquals(0, c.getSupportedRoles().size());
    }

    @Test
    void addMember() {
        CompositeOrganizzationChart c = new CompositeOrganizzationChart("test");
        Role aRole = new Role("roleForTest",1);
        Role anotherRole = new Role("some role", 2);
        c.addRole(aRole); c.addRole(anotherRole);
        c.addMember(new Employee("employee1", "something"), aRole);
        assertEquals(1, c.getEmployees().size());
        c.addMember(new Employee("aName", "aSurname"), anotherRole);
        assertEquals(2, c.getEmployees().size());
    }

    @Test
    void removeMember() {
        CompositeOrganizzationChart c = new CompositeOrganizzationChart("test");
        Role aRole = new Role("roleForTest",1);
        Role anotherRole = new Role("some role", 2);
        c.addRole(aRole); c.addRole(anotherRole);
        c.addMember(new Employee("employee1", "something"), aRole);
        c.addMember(new Employee("aName", "aSurname"), anotherRole);
        c.removeMember(new Employee("aName", "aSurname"));
        assertEquals(1, c.getEmployees().size());
        c.removeMember(new Employee("a not existing member", ""));
        assertEquals(1, c.getEmployees().size());
        c.removeMember(new Employee("employee1", "something"));
        assertEquals(0, c.getEmployees().size());
    }

    @Test
    void isMember() {
        CompositeOrganizzationChart c = new CompositeOrganizzationChart("test");
        Role aRole = new Role("roleForTest",1);
        Role anotherRole = new Role("some role", 2);
        c.addRole(aRole); c.addRole(anotherRole);
        c.addMember(new Employee("employee1", "something"), aRole);
        c.addMember(new Employee("aName", "aSurname"), anotherRole);
        assertEquals(true, c.isMember(new Employee("aName","aSurname")));
        assertEquals(false, c.isMember(new Employee("a not existing member","")));
        assertEquals(true, c.isMember(new Employee("employee1","something")));

    }
}