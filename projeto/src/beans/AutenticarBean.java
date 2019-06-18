package beans;

import javax.ejb.Stateless;

@Stateless(name="Autenticar")
public class AutenticarBean implements AutenticarBeanLocal {
    @Override
    public void autenticar(String email, String passowrd) {

    }
}