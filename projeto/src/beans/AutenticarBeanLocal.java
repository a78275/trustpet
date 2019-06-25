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
    boolean autenticar(String email, String password, PersistentSession session);

    /**
     *
     * @param token
     * @param session
     */
    String validarToken(String token, PersistentSession session);

    /**
     *
     * @param email
     * @param session
     */
    String setToken(String email, PersistentSession session);

    /**
     *
     * @param email
     * @param password
     * @param session
     */
    boolean autenticarAdministrador(String email, String password, PersistentSession session);
}