package beans;

import org.orm.PersistentSession;

import javax.ejb.Local;

@Local
public interface AutenticarBeanLocal2 {

	/**
	 *
	 * @param email
	 * @param password
	 */
	boolean autenticar(String email, String password, PersistentSession session);

}