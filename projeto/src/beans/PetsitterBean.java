package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Map;

@Local(PetsitterBeanLocal.class)
@Stateless(name="PetsitterBean")
public class PetsitterBean implements PetsitterBeanLocal {
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
    public boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos) {
        PersistentSession session = getSession();
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Set dos animais
        for(int idTipo : tipos) {
            TipoAnimal animal = null;
            try {
                animal = FacadeDAOs.getTipoAnimal(session, idTipo);
            } catch (PersistentException e) {
                e.printStackTrace();
                return false;
            }

            petsitter.animais.add(animal);
        }

        // Save do petsitter
        boolean save = false;
        try {
            save = FacadeDAOs.savePetsitter(petsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        return save;

    }

    @Override
    public boolean registarServicos(String emailPetsitter, Map<Integer, Double> servicos) {
        PersistentSession session = getSession();
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Create e save dos precoPetsitterServicos
        return createPrecoPetsitterServicos(servicos, session, petsitter);
    }

    private boolean createPrecoPetsitterServicos(Map<Integer, Double> servicos, PersistentSession session, Petsitter petsitter) {
        //TODO É preciso ser uma transação esta inserção de serviços?
        for (Map.Entry<Integer, Double> e : servicos.entrySet()) {
            Servico servico = null;
            try {
                servico = FacadeDAOs.getServico(session, e.getKey());
            } catch (PersistentException e1) {
                e1.printStackTrace();
                // Não existe serviço
                return false;
            }
            PrecoPetsitterServico precoPetsitterServico = FacadeDAOs.createPrecoPetsitterServico();
            precoPetsitterServico.setServico(servico);
            precoPetsitterServico.setPetsitter(petsitter);
            precoPetsitterServico.setPreco(e.getValue());

            try {
                FacadeDAOs.savePrecoPetsitterServico(precoPetsitterServico);
            } catch (PersistentException e1) {
                // Erro ao guardar PreçoPetsitterServico
                e1.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean editarHorario(String emailPetsitter, Map<Integer, List<Integer>> horario) {
        PersistentSession session = getSession();
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Create horario
        Horario newHorario = null;
        newHorario = FacadeDAOs.createHorario();

        // Set horario
        boolean successo = setHorario(horario, session, newHorario);
        if (successo){
            return true;
        }

        // Save horario
        boolean save = false;
        try {
            save = FacadeDAOs.saveHorario(newHorario);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        return save;
    }

    private boolean setHorario(Map<Integer, List<Integer>> horario, PersistentSession session, Horario newHorario) {
        for(Map.Entry<Integer, List<Integer>> e : horario.entrySet()){

            // Create e set do dia
            Dia dia = FacadeDAOs.createDia();
            dia.setDia(e.getKey());

            // Set das horas
            for(Integer h : e.getValue()){
                // Get da hora
                Hora hora = null;
                try {
                    hora = FacadeDAOs.getHora(session, h);
                } catch (PersistentException e1) {
                    e1.printStackTrace();
                    return false;
                }

                // Add hora
                dia.horas.add(hora);
            }

            // Save do dia
            try {
                boolean save = FacadeDAOs.saveDia(dia);

                if(!save){
                    return false;
                }
            } catch (PersistentException e1) {
                e1.printStackTrace();
                return false;
            }

            // Add dia
            newHorario.dias.add(dia);
        }
        return true;
    }

    @Override
    public List<Petsitter> consultarPetsitters(String filtro, String ordem) {
        PersistentSession session = getSession();
        try {
            // Get dos Petsitters
            return FacadeDAOs.listPetsitters(session, filtro, ordem);
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean editarServicos(String emailPetsitter, Map<Integer, Double> servicos) {
        PersistentSession session = getSession();
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Delete dos antigos
        try {
            List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico(session, "petsitter='" + emailPetsitter + "'", null);
            for(PrecoPetsitterServico p : precoPetsitterServicos){
                boolean delete = FacadeDAOs.deletePrecoPetsitterServico(p);

                if(!delete){
                    return false;
                }

            }
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Create e save dos precoPetsitterServicos
        return createPrecoPetsitterServicos(servicos, session, petsitter);
    }
}