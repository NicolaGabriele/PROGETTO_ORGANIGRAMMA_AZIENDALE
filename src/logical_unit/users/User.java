package logical_unit.users;

import java.io.Serializable;

public interface User extends Serializable, Comparable<User> {

    int getID();
    String getName();
    String getSurname();
}//User
