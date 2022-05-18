package logical_unit.organizzation_charts;

import java.io.Serializable;

public class Role implements Comparable<Role>, Serializable {

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
    public boolean equals(Object o){
        if(o == null || !(o instanceof Role))
            return false;
        if( o == this)return true;
        return ((Role)o).getName().equals(name);
    }

    @Override
    public int compareTo(Role o) {
        int comp = o.getPriority();
        return (priority > comp)?1:
                (priority<comp)?-1:0;
    }

}
