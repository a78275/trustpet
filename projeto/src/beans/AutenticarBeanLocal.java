package beans;

import org.orm.PersistentSession;

import javax.ejb.Local;

@Local
public interface AutenticarBeanLocal {


    /**
     *
     * @param email
     * @param password
     */
    boolean autenticar(String email, String password);

    /**
     *
     * @param token
     */
    String validarToken(String token);

    /**
     *
     * @param email
     */
    String setToken(String email);

    /**
     *
     * @param email
     * @param password
     */
    boolean autenticarAdministrador(String email, String password);
}