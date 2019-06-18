package beans;

@javax.ejb.Stateless(name="Pedido")
@javax.ejb.Remote(Pedido.class)
@javax.ejb.Local(PedidoLocal.class)
public class PedidoBean implements PedidoBeanLocal, Pedido, PedidoLocal {
}