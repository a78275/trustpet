package beans;

import trustpet.Pedido;
import trustpet.Petsitter;

import javax.ejb.Stateless;
import java.util.Date;
import java.util.List;

@Stateless(name="Pedido")
public class PedidoBean implements PedidoBeanLocal {

    @Override
    public int registarPedido(Date data, List<Integer> servicos, List<Integer> animais) {
        return 0;
    }

    @Override
    public boolean selPetsitter(String emailPetsitter, int idPedido) {
        return false;
    }

    @Override
    public List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais) {
        return null;
    }

    @Override
    public boolean cancelarPedido(int idPedido) {
        return false;
    }

    @Override
    public List<Pedido> consultarPedidos(String email) {
        return null;
    }
}