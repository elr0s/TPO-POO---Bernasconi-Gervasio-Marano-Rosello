package exception;

import obj.Tecnico;

public class TecnicoException extends Exception {
    private  static final long serialVersionUID = 1411527931374353831L;
    public TecnicoException(String msj){
        super(msj);
    }
}
