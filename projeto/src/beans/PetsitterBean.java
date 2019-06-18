package beans;

import trustpet.Petsitter;

import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Stateless(name="Petsitter")
public class PetsitterBean implements PetsitterBeanLocal {

    @Override
    public boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos) {
        return false;
    }

    @Override
    public boolean registarServicos(String emailPetsitter, Map<Integer, Float> servicos) {
        return false;
    }

    @Override
    public boolean editarHorario(String emailPetsitter, Map<String, List<Integer>> horario) {
        return false;
    }

    @Override
    public List<Petsitter> consultarPetsitters(String filtro) {
        return null;
    }

    @Override
    public boolean editarServicos(String emailPetsitter, Map<Integer, Float> servicos) {
        return false;
    }
}