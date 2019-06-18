package beans;

@javax.ejb.Stateless(name="Utilizador")
@javax.ejb.Remote(Utilizador.class)
@javax.ejb.Local(UtilizadorLocal.class)
public class UtilizadorBean implements UtilizadorBeanLocal, Utilizador, UtilizadorLocal {
}