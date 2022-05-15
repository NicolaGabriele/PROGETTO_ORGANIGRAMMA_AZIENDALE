package logical_unit.organizzation_charts;

public class Role implements Comparable<Role>{

    private String name;
    private int priority;

    public Role(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Role o) {
        int comp = o.getPriority();
        return (priority > comp)?1:
                (priority<comp)?-1:0;
    }

}
