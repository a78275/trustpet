package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Local(DonoBeanLocal.class)
@Stateless(name="DonoBean")
public class DonoBean implements DonoBeanLocal {
    private PersistentSession session;

    private PersistentSession getSession() {
        if(this.session==null){
            try {
                this.session= TrustPetPersistentManager.instance().getSession();
                System.out.println("Creating new persistent session");
            } catch (PersistentException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Reusing persistent session");
        }
        return this.session;
    }

    @Override
    public boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, int tipo) {
        PersistentSession session = getSession();
        Animal animal = FacadeDAOs.createAnimal();
        animal.setNome(nome);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setAlergias(alergias);
        animal.setDoencas(doencas);
        animal.setComportamento(comportamento);
        animal.setVacinas(vacinas);
        animal.setDesparasitacao(desparasitacao);
        animal.setEsterilizacao(esterilizacao);
        animal.setRaca(raca);
        animal.setAvatar(avatar);
        animal.setPorte(porte);
        animal.setAtivo(true);

        TipoAnimal tipoAnimal = null;
        try {
            tipoAnimal=FacadeDAOs.getTipoAnimal(session,tipo);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        // Tipo de Animal não existe
        if(tipoAnimal==null) {
            return false;
        }
        animal.setTipo(tipoAnimal);

        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session,emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        // Dono não existe
        if(dono==null) {
            return false;
        }
        dono.animais.add(animal);
        try {
            FacadeDAOs.saveDono(dono);
        } catch (PersistentException e) {
            e.printStackTrace();
            // Erro ao guardar dono
            return false;
        }
        return true;
    }

    @Override
    public List<Animal> consultarAnimais(String emailDono) {
        PersistentSession session = getSession();
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session,emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        // Dono não existe
        if(dono==null) {
            return null;
        }
        List<Animal> animaisAtivos = new ArrayList<>();
        for(Animal a : dono.animais.toArray()) {
            if(a.getAtivo()) {
                animaisAtivos.add(a);
            }
        }
        return animaisAtivos;
    }

    @Override
    public boolean editarAnimal(int id, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, boolean ativo) {
        PersistentSession session = getSession();
        Animal animal = null;
        try {
            animal= FacadeDAOs.getAnimal(session,id);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        // Animal não existe
        if (animal==null) {
            return false;
        }
        animal.setNome(nome);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setAlergias(alergias);
        animal.setDoencas(doencas);
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
            // Erro ao guardar animal
            return false;
        }
        return true;
    }
}