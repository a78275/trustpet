package beans;

public interface PedidoBeanLocal {

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	int registarPedido(Date data, List<Integer> servicos, List<Integer> animais);

	/**
	 * 
	 * @param emailPetsitter
	 * @param idPedido
	 */
	boolean selPetsitter(string emailPetsitter, int idPedido);

	/**
	 * 
	 * @param data
	 * @param servicos
	 * @param animais
	 */
	List<Petsitter> getPetsittersPedido(Date data, List<Integer> servicos, List<Integer> animais);

	/**
	 * 
	 * @param idPedido
	 */
	boolean cancelarPedido(int idPedido);

	/**
	 * 
	 * @param email
	 */
	List<Pedido> consultarPedidos(string email);

}