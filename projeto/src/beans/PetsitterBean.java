package beans;

import main.*;
import org.orm.PersistentException;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Local(PetsitterBeanLocal.class)
@Stateless(name="PetsitterBean")
public class PetsitterBean implements PetsitterBeanLocal {
    @Override
    public boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos) {
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Apagar tipos antigos
        if(!petsitter.animais.isEmpty()) {
            TipoAnimal[] tiposAntigos = petsitter.animais.toArray();

            for(TipoAnimal tipo : tiposAntigos) {
                if(!tipos.contains(tipo.getId())) {
                    petsitter.animais.remove(tipo);
                }
                else {
                    tipos.remove((Integer) tipo.getId());
                }
            }
        }

        if(tipos.size()==0) {
            return true;
        }
        else {
            // Set dos animais
            for(int idTipo : tipos) {
                TipoAnimal animal = null;
                try {
                    animal = FacadeDAOs.getTipoAnimal(idTipo);
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
    }

    @Override
    public boolean registarServicos(String emailPetsitter, Map<Integer, Double> servicos) {
        
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Create e save dos precoPetsitterServicos
        return createPrecoPetsitterServicos(servicos, petsitter);
    }

    private boolean createPrecoPetsitterServicos(Map<Integer, Double> servicos, Petsitter petsitter) {
        for (Map.Entry<Integer, Double> e : servicos.entrySet()) {
            Servico servico = null;
            try {
                servico = FacadeDAOs.getServico(e.getKey());
            } catch (PersistentException e1) {
                e1.printStackTrace();
                // Não existe serviço
                return false;
            }
            if(servico!=null) {
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
            else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean editarHorario(String emailPetsitter, Map<Integer, List<Integer>> horario) {
        
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Create horario
        Horario newHorario = null;
        newHorario = FacadeDAOs.createHorario();

        // Set horario
        boolean successo = setHorario(horario, newHorario);
        if (!successo){
            return false;
        }

        // Save horario
        boolean save = false;
        try {
            petsitter.setHorario(newHorario);
            save = FacadeDAOs.saveHorario(newHorario);
            save = save && FacadeDAOs.savePetsitter(petsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        return save;
    }

    private boolean setHorario(Map<Integer, List<Integer>> horario, Horario newHorario) {
        for(Map.Entry<Integer, List<Integer>> e : horario.entrySet()){
            // Create e set do dia
            Dia dia = FacadeDAOs.createDia();
            dia.setDia(e.getKey());

            // Set das horas
            for(Integer h : e.getValue()){
                // Get da hora
                Hora hora = null;
                try {
                    hora = FacadeDAOs.getHora(h);
                } catch (PersistentException e1) {
                    e1.printStackTrace();
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
        
        try {
            // Get dos Petsitters
            return FacadeDAOs.listPetsitters(filtro, ordem);
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean editarServicos(String emailPetsitter, Map<Integer, Double> servicos) {
        
        // Get do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Delete dos antigos
        try {
            List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico("petsitterutilizadoremail='" + emailPetsitter + "'", null);
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
        return createPrecoPetsitterServicos(servicos, petsitter);
    }

    @Override
    public Map<String, Double> getServicosPetsitter(String email) {
        try {
            List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico("petsitterutilizadoremail='" + email + "'", null);
            Map<String, Double> servicos = new HashMap<>();
            for (PrecoPetsitterServico ps : precoPetsitterServicos){
                servicos.put(ps.getServico().getDesignacao(), ps.getPreco());
            }

            return servicos;
        } catch (PersistentException e) {
            return null;
        }
    }
}