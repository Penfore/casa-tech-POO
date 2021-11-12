package src.Exception;

import java.net.Authenticator;

public class AuthException extends Exception{
    private static final long serialVersionUID = 1L;

    public AuthException() {
        super("Login ou Senha não encontrados");
    }
}
