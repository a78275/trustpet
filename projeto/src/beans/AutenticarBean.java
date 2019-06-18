package beans;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local(AutenticarBeanLocal.class)
@Stateless(name="Autenticar")
public class AutenticarBean implements AutenticarBeanLocal {
    @Override
    public boolean autenticar(String email, String password) {

    }
}