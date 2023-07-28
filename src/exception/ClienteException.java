package exception;

public class ClienteException extends Exception {
    private  static final long serialVersionUID = 1411527931374353831L;
    public  ClienteException (String msj){
        super(msj);
    }
}
