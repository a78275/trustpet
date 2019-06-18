package beans;

import main.Animal;
import main.Dono;
import main.FacadeDAOs;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Local(DonoBeanLocal.class)
@Stateless(name="Dono")
public class DonoBean implements DonoBeanLocal {

    @Override
    public boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, PersistentSession session) {
        Animal animal = FacadeDAOs.createAnimal();
        animal.setNome(nome);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setAlergias(alergias);
        animal.setDoenças(doencas);
        animal.setComportamento(comportamento);
        animal.setVacinas(vacinas);
        animal.setDesparasitacao(desparasitacao);
        animal.setEsterilizacao(esterilizacao);
        animal.setRaca(raca);
        animal.setAvatar(avatar);
        animal.setAtivo(true);

        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session,emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (dono!=null) {
            dono.animais.add(animal);
            try {
                FacadeDAOs.saveDono(dono);
            } catch (PersistentException e) {
                e.printStackTrace();
                //Erro ao guardar dono
                return false;
            }
            return true;
        }
        else {
            //Dono não existe
            return false;
        }
    }

    @Override
    public List<Animal> consultarAnimais(String emailDono, PersistentSession session) {
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session,emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (dono!=null) {
            List<Animal> animais = Arrays.asList(dono.animais.toArray());
            List<Animal> animaisAtivos = new ArrayList<>();
            for(Animal a : animais) {
                if(a.getAtivo()) {
                    animaisAtivos.add(a);
                }
            }
            return animaisAtivos;
        }
        else {
            //Dono não existe
            return null;
        }
    }

    @Override
    public boolean editarAnimal(int id, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, boolean ativo, PersistentSession session) {
        Animal animal = null;
        try {
            animal= FacadeDAOs.getAnimal(session,id);
        } catch (PersistentException e) {
            e.printStackTrace();
            //Animal não existe
            return false;
        }
        animal.setNome(nome);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setAlergias(alergias);
        animal.setDoenças(doencas);
        animal.setComportamento(comportamento);
        animal.setVacinas(vacinas);
        animal.setDesparasitacao(desparasitacao);
        animal.setEsterilizacao(esterilizacao);
        animal.setRaca(raca);
        animal.setAvatar(avatar);
        animal.setAtivo(ativo);
        try {
            FacadeDAOs.saveAnimal(animal);
        } catch (PersistentException e) {
            e.printStackTrace();
            //Erro ao guardar animal
            return false;
        }
        return true;
    }
}