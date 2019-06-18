package beans;

@javax.ejb.Stateless(name="Petsitter")
@javax.ejb.Remote(Petsitter.class)
@javax.ejb.Local(PetsitterLocal.class)
public class PetsitterBean implements PetsitterBeanLocal, Petsitter, PetsitterLocal {
}