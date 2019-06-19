package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.awt.print.Book;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Local(PedidoBeanLocal.class)
@Stateless(name = "Pedido")
public class PedidoBean implements PedidoBeanLocal {

    @Override
    public int registarPedido(String emailDono, Date dataInicio, Date dataFim, Map<Integer, List<Integer>> animalServicos, PersistentSession session) {
        // Criar pedido
        Pedido pedido = FacadeDAOs.createPedido();

        // Set do dono
        Dono dono = null;
        try {
            dono = FacadeDAOs.getDono(session, emailDono);
        } catch (PersistentException e) {
            e.printStackTrace();
            return -1;
        }
        pedido.setDono(dono);

        // Set das datas
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");
        String parsedDataInicio = format.format(dataInicio);
        pedido.setDataInicio(parsedDataInicio);
        String parsedDataFim = format.format(dataInicio);
        pedido.setDataFim(parsedDataFim);

        // Set dos animalServicos
        boolean sucesso = setAnimalServicos(session, pedido, animalServicos);

        if (!sucesso) {
            return -1;
        }

        // Set do estado
        pedido.setAtivo(true);

        // Save do pedido na BD
        boolean save = false;
        try {
            save = FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return -1;
        }

        // Se for bem sucedido retornar ID senão retornar -1
        if (save) {
            return pedido.getId();
        } else {
            return -1;
        }
    }

    @Override
    public boolean concluirPedido(String emailPetsitter, int idPedido, PersistentSession session) {
        // Get do pedido
        Pedido pedido = null;
        try {
            pedido = FacadeDAOs.getPedido(session, idPedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Set do petsitter
        Petsitter petsitter = null;
        try {
            petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
            pedido.setPetsitter(petsitter);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Get dos precoPetsitterServicos
        Map<Integer, Float> servicoPreco = null;
        try {
            List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico(session, "petsitter='" + petsitter.getEmail() + "'", null);
            servicoPreco = new HashMap<>();
            for (PrecoPetsitterServico precoPetsitterServico : precoPetsitterServicos) {
                servicoPreco.put(precoPetsitterServico.getServico().getId(), precoPetsitterServico.getPreco());
            }
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Set do preço
        float preco = 0;
        for (AnimalServico animalServico : pedido.animalServicos.toArray()) {
            preco += servicoPreco.get(animalServico.getServico().getId());
        }
        pedido.setPreco(preco);

        // Save do pedido na BD
        boolean save = false;
        try {
            save = FacadeDAOs.savePedido(pedido);
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        // Se for bem sucedido retornar ID senão retornar -1
        return save;
    }

    @Override
    public List<Petsitter> getPetsittersPedido(Date dataInicio, Date dataFim, Map<Integer, List<Integer>> animalServicos, PersistentSession session) {
        // Buscar Petsitters que fazem os serviços pretendidos
        Set<String> emailsPetsitters = getPetsittersServico(animalServicos, session);

        // Buscar Petsitters que trabalham neste horário
        if (emailsPetsitters != null) {
            emailsPetsitters = getPetsittersHorario(dataInicio, dataFim, session, emailsPetsitters);
        }

        // Remover Petsitters que têm pedidos neste horário
        if (emailsPetsitters != null) {
            emailsPetsitters = removePetsittersComPedidos(session, emailsPetsitters, dataInicio, dataFim);
        }

        // Buscar Petsitters
        return getPetsitters(session, emailsPetsitters);
    }

    private List<Petsitter> getPetsitters(PersistentSession session, Set<String> emailsPetsitters) {
        List<Petsitter> petsitters = new ArrayList<>();
        if (emailsPetsitters != null) {
            for (String emailPetsitter : emailsPetsitters) {
                try {
                    Petsitter petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
                    if (!petsitters.add(petsitter)) {
                        return null;
                    }
                } catch (PersistentException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        if (petsitters.isEmpty()) {
            return null;
        } else {
            return petsitters;
        }
    }

    private Set<String> removePetsittersComPedidos(PersistentSession session, Set<String> emailsPetsitters, Date dataInicio, Date dataFim) {
        try {
            List<Pedido> pedidos = FacadeDAOs.listPedido(session, null, null);
            for (Pedido pedido : pedidos) {
                if (checkPedidoNoHorario(pedido, dataInicio, dataFim)) {
                    String emailPetsitter = pedido.getPetsitter().getEmail();

                    if (!emailsPetsitters.remove(emailPetsitter)) {
                        return null;
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

    }

    private Set<String> getPetsittersHorario(Date dataInicio, Date dataFim, PersistentSession session, Set<String> emailsPetsitters) {
        Set<String> emailsPetsittersAux = new HashSet<>();
        for (String emailPetsitter : emailsPetsitters) {
            try {
                Petsitter petsitter = FacadeDAOs.getPetsitter(session, emailPetsitter);
                if (checkPetsitterHorario(petsitter, dataInicio, dataFim)) {
                    if (!emailsPetsittersAux.add(petsitter.getEmail())) {
                        return null;
                    }
                }

                if (!emailsPetsitters.retainAll(emailsPetsittersAux)) {
                    return null;
                }
            } catch (PersistentException e) {
                e.printStackTrace();
                return null;
            }
        }

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

        int fator = 3;

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
                if(dia.getDia() == dataFimDia) {
                    contar = false;
                }
                else if (dia.getDia() == dataInicioDia) {
                    contar = true;
                }

                //Verificação da disponibilidade nos dias do pedido
                if (contar) {
                    if (dia.horas.toArray().length<fator) {
                        return false;
                    }
                }

            }
            return true;
        } else {
            return false;
        }
    }

    private Set<String> getPetsittersServico(Map<Integer, List<Integer>> animalServicos, PersistentSession session) {
        Set<String> emailsPetsitters = new HashSet<>();
        boolean firstIter = true;
        for (Map.Entry<Integer, List<Integer>> e : animalServicos.entrySet()) {
            // Primeira iteração do ciclo
            if (firstIter) {
                for (int servico : e.getValue()) {
                    try {
                        // Get precoPetsitterServicos do serviço
                        List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico(session, "servico='" + servico + "'", null);
                        // Get dos petsitters que fazem esse serviço
                        for (PrecoPetsitterServico pps : precoPetsitterServicos) {
                            if (!emailsPetsitters.add(pps.getPetsitter().getEmail())) {
                                return null;
                            }
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
                        List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico(session, "servico='" + servico + "'", null);
                        Set<String> emailsPetsittersAux = new HashSet<>();
                        // Get dos petsitters que fazem esse serviço
                        for (PrecoPetsitterServico pps : precoPetsitterServicos) {
                            if (!emailsPetsittersAux.add(pps.getPetsitter().getEmail())) {
                                return null;
                            }
                        }
                        // Interseção dos dois sets
                        if (!emailsPetsitters.retainAll(emailsPetsittersAux)) {
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
    public boolean cancelarPedido(int idPedido, PersistentSession session) {
        // Get do pedido
        Pedido pedido = null;
        try {
            pedido = FacadeDAOs.getPedido(session, idPedido);
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
    public List<Pedido> consultarPedidos(String email, PersistentSession session) {
        try {
        // Get dos pedidos do utilizador
            return FacadeDAOs.listPedido(session, "dono='" + email + "' OR petsitter='" + email + "'", null);
        } catch (PersistentException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean setAnimalServicos(PersistentSession session, Pedido pedido, Map<Integer, List<Integer>> animalServicos) {
        for (Map.Entry<Integer, List<Integer>> e : animalServicos.entrySet()) {
            // Get do animal
            Animal animal = null;
            try {
                animal = FacadeDAOs.getAnimal(session, e.getKey());
            } catch (PersistentException e1) {
                e1.printStackTrace();
                return false;
            }

            // Get do servico
            Servico servico = null;
            for (int idServico : e.getValue()) {
                try {
                    servico = FacadeDAOs.getServico(session, idServico);
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
}