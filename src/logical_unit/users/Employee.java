package logical_unit.users;

public class Employee implements User{

    private static int ID = 0;
    private int id;
    private String name, surname, city, cap, street;
    public Employee(String name, String surname){
        this.id = ID;
        ID++;
        if(name == null || surname == null)
            throw new IllegalArgumentException("nome e cognome sono obbligatori");
        this.name = name;
        this.surname = surname;
        //default values
        city = "";
        cap = "";
        street = "";
    }
    @Override
    public int getID() {
        return id;
    }

    public boolean equals(Object o){
        if(o == null || ! (o instanceof Employee))
            return false;
        if(o == this)
            return true;
        Employee e = (Employee) o;
        return e.name.equals(name) && e.surname.equals(surname);
    }//equals

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("      ").append(id).append("      ").append(name)
                .append("       ").append(surname).toString();
    }

    @Override
    public int compareTo(User o) {
        return (o.getID() > id)?-1:(o.getID() < id)?1:0;
    }

    public static class Builder{

        Employee result;

        public Builder(String name, String surname){
            result = new Employee(name,surname);
        }

        public Builder city(String city){
            result.setCity(city);
            return this;
        }

        public Builder cap(String cap){
            result.setCap(cap);
            return this;
        }

        public Builder street(String street){
            result.setStreet(street);
            return this;
        }

        public Employee build(){
            return result;
        }
    }//Builder
}//Employee
