package beans;

import javax.ejb.Local;

@Local
public interface AutenticarBeanLocal {

	/**
	 * 
	 * @param email
	 * @param passowrd
	 */
	void autenticar(String email, String passowrd);

}