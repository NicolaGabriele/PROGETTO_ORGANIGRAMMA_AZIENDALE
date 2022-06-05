package exceptions;

public class RoleNotSupportedException extends RuntimeException{

    public RoleNotSupportedException(){
        super("ruolo non supportato");
    }
}
