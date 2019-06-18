package beans;

@javax.ejb.Stateless(name="Autenticar")
@javax.ejb.Remote(Autenticar.class)
@javax.ejb.Local(AutenticarLocal.class)
public class AutenticarBean implements AutenticarBeanLocal, Autenticar, AutenticarLocal {
}