package beans;

import javax.ejb.Local;

@Local
public interface AutenticarBeanLocal {

	/**
	 * 
	 * @param email
	 * @param password
	 */
	void autenticar(String email, String password);

}