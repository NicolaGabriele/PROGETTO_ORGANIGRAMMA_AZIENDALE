package exceptions;

public class NotRemovableRoleException extends RuntimeException {

    public NotRemovableRoleException(){
        super("Questo ruolo non può essere rimosso in quanto " +
                "potrebbero esserci ancora dipendenti che ricoprono il ruolo nell'organizzazione");
    }
}//NotRemovableRoleEception
