package beans;

@javax.ejb.Stateless(name="Dono")
@javax.ejb.Remote(Dono.class)
@javax.ejb.Local(DonoLocal.class)
public class DonoBean implements DonoBeanLocal, Dono, DonoLocal {
}