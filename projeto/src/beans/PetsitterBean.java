package beans;

import main.Petsitter;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Local(PetsitterBeanLocal.class)
@Stateless(name="Petsitter")
public class PetsitterBean implements PetsitterBeanLocal {

    @Override
    public boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos, PersistentSession session) {
        return false;
    }

    @Override
    public boolean registarServicos(String emailPetsitter, Map<Integer, Float> servicos, PersistentSession session) {
        return false;
    }

    @Override
    public boolean editarHorario(String emailPetsitter, Map<String, List<Integer>> horario, PersistentSession session) {
        return false;
    }

    @Override
    public List<Petsitter> consultarPetsitters(String filtro, PersistentSession session) {
        return null;
    }

    @Override
    public boolean editarServicos(String emailPetsitter, Map<Integer, Float> servicos, PersistentSession session) {
        return false;
    }
}