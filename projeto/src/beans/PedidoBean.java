package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Local(PedidoBeanLocal.class)
@Stateless(name = "PedidoBean")
public class PedidoBean implements PedidoBeanLocal {

    @Override
    public Map<Animal, List<Servico>> getServicosPedido(List<Integer> idAnimal) {
        List<Servico> servicos = null;
        try {
            servicos = FacadeDAOs.listServicos(null, null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if(servicos!=null) {
            Map<Animal, List<Servico>> servicosAnimais = new HashMap<>();
            for (Integer id : idAnimal) {
                Animal animal = null;
                try {
                    animal = FacadeDAOs.getAnimal(id);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
                if (animal != null) {
                    List<Servico> servicosAnimal = new ArrayList<>();

                    for (Servico s : servicos) {
                        if (s.tipoAnimais.contains(animal.getTipo())) {
                            servicosAnimal.add(s);
                        }
                    }
                    servicosAnimais.put(animal,servicosAnimal);
                }
            }
            return servicosAnimais;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean registarServicosPedido(int idPedido, Map<Integer, List<Integer>> animalServicos) {
        
        Pedido pedido = null;
        try {
            pedido=FacadeDAOs.getPedido(idPedido);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if(pedido!=null) {
            // Remover serviços antigos
            if(!pedido.animalServicos.isEmpty()) {
                AnimalServicoSetCollection servicoSet = pedido.animalServicos;
                List<AnimalServico> servicosAntigos = null;
                try {
                    servicosAntigos = FacadeDAOs.listAnimalServico("pedidoid = '" + idPedido + "'",null);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
                if(servicosAntigos!=null) {
                    for (AnimalServico servicoAntigo : servicosAntigos) {
                        servicoSet.remove(servicoAntigo);
                    }
                }
            }

            // Adicionar serviços novos
            for(Map.Entry<Integer, List<Integer>> e : animalServicos.entrySet()){
                for(int s : e.getValue()) {
                    registarAnimalServico(e.getKey(),s,pedido);
                }
            }

            // Gravar pedido
            try {
                FacadeDAOs.savePedido(pedido);
            } catch (PersistentException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }

    private AnimalServico registarAnimalServico (int idAnimal, int idServico, Pedido pedido) {
        AnimalServico animalServico = FacadeDAOs.createAnimalServico();
        Animal animal = null;
        Servico servico = null;
        try {
            animal = FacadeDAOs.getAnimal(idAnimal);
            servico = FacadeDAOs.getServico(idServico);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(animal!=null && servico!=null) {
            animalServico.setAnimal(animal);
            animalServico.setServico(servico);
            pedido.animalServicos.add(animalServico);
            try {
                FacadeDAOs.saveAnimalServico(animalServico);
            } catch (PersistentException e) {
                e.printStackTrace();
            }
            return animalServico;
        }
        else {
            return null;
        }
    }

    @Override
    public int registarPedido(String emailDono, Date dataInicio, Date dataFim) {
        // Criar pedido
        Pedido pedido = FacadeDAOs.createPedido();

        // Set do dono
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if (dono == null) {
            // Retornar -1 em caso de falha
            return -1;
        }
        pedido.setDono(dono);

        // Set das datas
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String parsedDataInicio = format.format(dataInicio);
        pedido.setDataInicio(parsedDataInicio);
        String parsedDataFim = format.format(dataFim);
        pedido.setDataFim(parsedDataFim);

        //TODO Tirar
        pedido.setAtivo(true);

        // Save do pedido na BD
        try {
            FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            // Retornar -1 em caso de falha
            return -1;
        }

        // Se for bem sucedido retornar ID
        return pedido.getId();
    }

    @Override
    public boolean concluirPedido(String emailPetsitter, int idPedido) {
        // Get do pedido
        Pedido pedido = null;
        try {
            pedido = FacadeDAOs.getPedido(idPedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Set do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
            pedido.setPetsitter(petsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        double preco = calcularPreco(pedido,petsitter);
        pedido.setPreco(preco);
        pedido.setAtivo(true);

        List<AnimalServico> animalServicos=null;
        try {
            animalServicos = FacadeDAOs.listAnimalServico("pedidoid='" + idPedido + "'",null);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(animalServicos!=null) {
            for(AnimalServico animalServico : animalServicos) {
                int idServico = animalServico.getServico().getId();
                PrecoPetsitterServico precoPetsitterServico=null;
                try {
                    precoPetsitterServico = FacadeDAOs.listPrecoPetsitterServico("petsitterutilizadoremail='" + emailPetsitter + "' and servicoid='" + idServico + "'",null).get(0);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }
                if(precoPetsitterServico!=null) {
                    pedido.servicos.add(precoPetsitterServico);
                }
                else {
                    return false;
                }
            }
        }
        else {
            return false;
        }

        // Save do pedido na BD
        boolean save = false;
        try {
            save = FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        return save;
    }

    private double calcularPreco (Pedido pedido, Petsitter petsitter) {
        // Get dos precoPetsitterServicos
        Map<Integer, Double> servicoPreco = null;
        try {
            List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico("petsitterutilizadoremail='" + petsitter.getEmail() + "'",null);
            servicoPreco = new HashMap<>();
            for (PrecoPetsitterServico precoPetsitterServico : precoPetsitterServicos) {
                servicoPreco.put(precoPetsitterServico.getServico().getId(), precoPetsitterServico.getPreco());
            }
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        if(servicoPreco!=null) {
            // Set do preço
            double preco = 0;
            for (AnimalServico animalServico : pedido.animalServicos.toArray()) {
                preco += servicoPreco.get(animalServico.getServico().getId());
            }
            return preco;
        }
        else {
            return 0;
        }
    }

    @Override
    public Map<Petsitter,Double> getPetsittersPedido(int idPedido, Map<Integer, List<Integer>> animalServicos) {
        Pedido pedido = null;
        try {
            pedido = FacadeDAOs.getPedido(idPedido);
        } catch (PersistentException e) {
            e.printStackTrace();
        }
        // Pedido não existe
        if (pedido == null) {
            return null;
        }
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dataInicio = null;
        Date dataFim = null;
        try {
            dataInicio = format.parse(pedido.getDataInicio());
            dataFim = format.parse(pedido.getDataFim());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Buscar Petsitters que fazem os serviços pretendidos
        Set<String> emailsPetsitters = getPetsittersServico(animalServicos);

        // Buscar Petsitters que trabalham neste horário
        if (emailsPetsitters != null) {
            emailsPetsitters = getPetsittersHorario(dataInicio, dataFim, emailsPetsitters);
        }

        // Remover Petsitters que têm pedidos neste horário
        if (emailsPetsitters != null) {
            emailsPetsitters = removerPetsittersComPedidos(emailsPetsitters, dataInicio, dataFim);
        }

        // Buscar Petsitters
        return getPetsitters(emailsPetsitters, pedido);
    }

    private Map<Petsitter,Double> getPetsitters(Set<String> emailsPetsitters, Pedido pedido) {

        Map<Petsitter,Double> petsitters = new HashMap<>();
        if (emailsPetsitters != null) {
            for (String emailPetsitter : emailsPetsitters) {
                try {
                    Petsitter petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
                    double preco = calcularPreco(pedido,petsitter);
                    petsitters.put(petsitter,preco);
                } catch (PersistentException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return petsitters;
    }

    private Set<String> removerPetsittersComPedidos(Set<String> emailsPetsitters, Date dataInicio, Date dataFim) {
        try {
            List<Pedido> pedidos = FacadeDAOs.listPedido(null, null);
            for (Pedido pedido : pedidos) {
                if (checkPedidoNoHorario(pedido, dataInicio, dataFim)) {
                    Petsitter petsitter = pedido.getPetsitter();
                    if(petsitter != null) {
                        String emailPetsitter = petsitter.getEmail();
                        emailsPetsitters.remove(emailPetsitter);
                    }
                }
            }
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        }

        return emailsPetsitters;
    }

    private boolean checkPedidoNoHorario(Pedido pedido, Date dataInicio, Date dataFim) {
        // Get das datas de inicio e fim do pedido
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date pedidoDataInicio = null;
        Date pedidoDataFim = null;
        try {
            pedidoDataInicio = format.parse(pedido.getDataInicio());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        try {
            pedidoDataFim = format.parse(pedido.getDataFim());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        // Cálculo da interseção entre datas
        if (pedidoDataInicio != null && pedidoDataFim != null) {
            return (pedidoDataFim.after(dataInicio) && pedidoDataFim.before(dataFim)) ||
                    (pedidoDataInicio.after(dataInicio) && pedidoDataInicio.before(dataFim)) ||
                    (dataInicio.after(pedidoDataInicio) && dataFim.before(pedidoDataFim)) ||
                    (dataInicio.equals(pedidoDataInicio) && dataFim.equals(pedidoDataFim));
        }

        return false;
    }

    private Set<String> getPetsittersHorario(Date dataInicio, Date dataFim, Set<String> emailsPetsitters) {
        Set<String> emailsPetsittersAux = new HashSet<>();
        for (String emailPetsitter : emailsPetsitters) {
            try {
                Petsitter petsitter = FacadeDAOs.getPetsitter(emailPetsitter);
                if (checkPetsitterHorario(petsitter, dataInicio, dataFim)) {
                    emailsPetsittersAux.add(petsitter.getEmail());
                }
            } catch (PersistentException e) {
                e.printStackTrace();
                return null;
            }
        }
        emailsPetsitters.retainAll(emailsPetsittersAux);
        return emailsPetsitters;
    }

    private boolean checkPetsitterHorario(Petsitter petsitter, Date dataInicio, Date dataFim) {
        //TODO Garantir que isto está correto
        //TODO Garantir que as horas são medidas em 24horas (e não AM/PM)
        DateFormat horaformat = new SimpleDateFormat("HH");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInicio);
        int dataInicioDia = calendar.get(Calendar.DAY_OF_WEEK);
        int dataInicioHora = Integer.parseInt(horaformat.format(dataInicio));

        calendar.setTime(dataFim);
        int dataFimDia = calendar.get(Calendar.DAY_OF_WEEK);
        int dataFimHora = Integer.parseInt(horaformat.format(dataFim));

        //TODO Mudar fator?
        int fator = 3;
        int diferenca;

        if (dataInicioDia > dataFimDia) {
            diferenca = (7 - dataInicioDia + 1) + dataFimDia;
        } else {
            diferenca = dataFimDia - dataInicioDia + 1;
        }

        Horario horario = petsitter.getHorario();
        if (horario != null) {
            Dia[] dias = horario.dias.toArray();
            Arrays.sort(dias, new Comparator<Dia>() {
                @Override
                public int compare(Dia d1, Dia d2) {
                    return Integer.compare(d1.getDia(), d2.getDia());
                }
            });

            boolean contar = false;
            if (dataInicioDia > dataFimDia) {
                contar = true;
            }

            for (Dia dia : dias) {
                //Pedido no mesmo dia
                if (dia.getDia() == dataInicioDia && dia.getDia() == dataFimDia) {
                    Hora[] horas = dia.horas.toArray();
                    Arrays.sort(horas, new Comparator<Hora>() {
                        @Override
                        public int compare(Hora h1, Hora h2) {
                            return Integer.compare(h1.getHora(), h2.getHora());
                        }
                    });
                    int horasTotais = dataFimHora - dataInicioHora;
                    for (Hora hora : horas) {
                        if (hora.getHora() >= dataInicioHora && hora.getHora() <= dataFimHora) {
                            horasTotais -= 1;
                        }
                    }
                    if (horasTotais <= 0) {
                        return true;
                    } else {
                        return false;
                    }
                }

                //Dia inicial e final
                if (dia.getDia() == dataFimDia) {
                    contar = false;
                    if (dia.horas.toArray().length < fator) {
                        return false;
                    }
                    diferenca -= 1;
                } else if (dia.getDia() == dataInicioDia) {
                    contar = true;
                }

                //Verificação da disponibilidade nos dias do pedido
                if (contar) {
                    if (dia.horas.toArray().length < fator) {
                        return false;
                    }
                    diferenca -= 1;
                }

            }

            if (diferenca == 0) {
                //Disponivel em todos os dias de um pedido com vários dias
                return true;
            } else {
                //Não está disponivel em todos os dias de um pedido com vários dias
                return false;
            }
        } else {
            //Petsitter não tem horário
            return false;
        }
    }

    private Set<String> getPetsittersServico(Map<Integer, List<Integer>> animalServicos) {
        Set<String> emailsPetsitters = new HashSet<>();
        boolean firstIter = true;
        for (Map.Entry<Integer, List<Integer>> e : animalServicos.entrySet()) {
            // Primeira iteração do ciclo
            if (firstIter) {
                for (int servico : e.getValue()) {
                    try {
                        // Get precoPetsitterServicos do serviço
                        List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico("servicoid='" + servico + "'",null);
                        // Get dos petsitters que fazem esse serviço
                        for (PrecoPetsitterServico pps : precoPetsitterServicos) {
                            emailsPetsitters.add(pps.getPetsitter().getEmail());
                        }
                    } catch (PersistentException e1) {
                        e1.printStackTrace();
                        return null;
                    }
                    firstIter = false;
                }
            }
            // Próximas iterações
            else {
                for (int servico : e.getValue()) {
                    try {
                        // Get precoPetsitterServicos do serviço
                        List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico("servicoid='" + servico + "'",null);
                        Set<String> emailsPetsittersAux = new HashSet<>();
                        // Get dos petsitters que fazem esse serviço
                        for (PrecoPetsitterServico pps : precoPetsitterServicos) {
                            emailsPetsittersAux.add(pps.getPetsitter().getEmail());
                        }
                        // Interseção dos dois sets
                        emailsPetsitters.retainAll(emailsPetsittersAux);
                        if (emailsPetsitters.size()==0) {
                            return null;
                        }
                    } catch (PersistentException e1) {
                        e1.printStackTrace();
                        return null;
                    }
                }

            }
        }
        return emailsPetsitters;
    }

    @Override
    public boolean cancelarPedido(int idPedido) {
        
        // Get do pedido
        Pedido pedido = null;
        try {
            pedido = FacadeDAOs.getPedido(idPedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Tornar o pedido inativo
        pedido.setAtivo(false);

        // Save do pedido
        try {
            FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public List<Pedido> consultarPedidos(String email) {
        
        try {
            // Get dos pedidos do utilizador
            return FacadeDAOs.listPedido("donoutilizadoremail='" + email + "' OR petsitterutilizadoremail='" + email + "' AND ativo='" + true + "'", "dataInicio");
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean setAnimalServicos(Pedido pedido, Map<Integer, List<Integer>> animalServicos) {
        for (Map.Entry<Integer, List<Integer>> e : animalServicos.entrySet()) {
            // Get do animal
            Animal animal = null;
            try {
                animal = FacadeDAOs.getAnimal(e.getKey());
            } catch (PersistentException e1) {
                e1.printStackTrace();
                return false;
            }

            // Get do servico
            Servico servico = null;
            for (int idServico : e.getValue()) {
                try {
                    servico = FacadeDAOs.getServico(idServico);
                } catch (PersistentException e1) {
                    e1.printStackTrace();
                    return false;
                }
            }

            // Create do animalServico
            AnimalServico animalServico = FacadeDAOs.createAnimalServico();
            animalServico.setAnimal(animal);
            animalServico.setServico(servico);

            // Save do animalServico
            try {
                boolean save = FacadeDAOs.saveAnimalServico(animalServico);

                if (!save) {
                    return false;
                }
            } catch (PersistentException e1) {
                e1.printStackTrace();
                return false;
            }

            // Add do animalServico aos animalServicos do Pedido
            pedido.animalServicos.add(animalServico);
        }

        return true;
    }

    @Override
    public int editarPedido(int idPedido, Date dataInicio, Date dataFim) {
        
        // Get do pedido
        Pedido pedido = null;
        try {
            pedido = FacadeDAOs.getPedido(idPedido);
        } catch (PersistentException e) {
            e.printStackTrace();
        }

        if(pedido == null) {
            return -1;
        }

        // Set das datas
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String parsedDataInicio = format.format(dataInicio);
        pedido.setDataInicio(parsedDataInicio);
        String parsedDataFim = format.format(dataFim);
        pedido.setDataFim(parsedDataFim);

        // Set do estado
        pedido.setAtivo(true);

        // Save do pedido na BD
        try {
            FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            // Retornar -1 em caso de falha
            return -1;
        }

        // Se for bem sucedido retornar ID
        return pedido.getId();
    }
}