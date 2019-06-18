package beans;

import trustpet.Animal;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local(DonoBeanLocal.class)
@Stateless(name="Dono")
public class DonoBean implements DonoBeanLocal {

    @Override
    public boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar) {
        return false;
    }

    @Override
    public List<Animal> consultarAnimais(String emailDono) {
        return null;
    }

    @Override
    public boolean editarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar) {
        return false;
    }
}