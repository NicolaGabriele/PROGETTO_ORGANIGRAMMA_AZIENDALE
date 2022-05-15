package logical_unit.users;

public class Employee implements User{

    private static int ID = 0;
    private int id;
    public Employee(){
        this.id = ID;
        ID++;
    }
    @Override
    public int getID() {
        return id;
    }

    public boolean equals(Object o){
        if(o == null || ! (o instanceof User))
            return false;
        if(o == this)
            return true;
        return ((User)o).getID() == id;
    }//equals
}//Employee
