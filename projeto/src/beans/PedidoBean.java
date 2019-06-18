package beans;

import org.orm.PersistentSession;
import trustpet.Pedido;
import trustpet.Petsitter;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

@Local(PedidoBeanLocal.class)
@Stateless(name="Pedido")
public class PedidoBean implements PedidoBeanLocal {

    @Override
    public int registarPedido(Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session) {
        return 0;
    }

    @Override
    public boolean selPetsitter(String emailPetsitter, int idPedido, PersistentSession session) {
        return false;
    }

    @Override
    public List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais, PersistentSession session) {
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