package beans;

import main.*;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Local(PedidoBeanLocal.class)
@Stateless(name="Pedido")
public class PedidoBean implements PedidoBeanLocal {

    @Override
    public int registarPedido(String emailDono, Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session) {
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

        // Set da data
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy 'às' HH:mm");
        String parsedData = format.format(data);
        pedido.setData(parsedData);

        // Set dos servicos
        for(int idServico : servicos){
            Servico newServico = null;
            try {
                newServico = FacadeDAOs.getServico(session, idServico);
            } catch (PersistentException e) {
                e.printStackTrace();
                return -1;
            }
            pedido.servicos.add(newServico);
        }

        // Set dos animais
        for(int idAnimal : animais){
            Animal newAnimal = null;
            try {
                newAnimal = FacadeDAOs.getAnimal(session, idAnimal);
                pedido.animais.add(newAnimal);
            } catch (PersistentException e) {
                e.printStackTrace();
                return -1;
            }
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
        if(save){
            return pedido.getId();
        }
        else {
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

        // Set do preço
        try {
            List<PrecoPetsitterServico> precoPetsitterServicos = FacadeDAOs.listPrecoPetsitterServico(session, "petsitter = '" + petsitter.getEmail() + "'", null);
            //TODO: continuar
        } catch (PersistentException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session) {
        //TODO: fazer
        return null;
    }

    @Override
    public boolean cancelarPedido(int idPedido, PersistentSession session) {
        return false;
    }

    @Override
    public List<Pedido> consultarPedidos(String email, PersistentSession session) {
        return null;
    }
}