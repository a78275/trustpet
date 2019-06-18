package beans;

import org.orm.PersistentSession;
import trustpet.Animal;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local(DonoBeanLocal.class)
@Stateless(name="Dono")
public class DonoBean implements DonoBeanLocal {

    @Override
    public boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, PersistentSession session) {
        return false;
    }

    @Override
    public List<Animal> consultarAnimais(String emailDono, PersistentSession session) {
        return null;
    }

    @Override
    public boolean editarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, PersistentSession session) {
        return false;
    }
}