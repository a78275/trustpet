package beans;

import main.Pedido;
import main.Petsitter;
import main.Servico;
import main.TipoAnimal;
import org.orm.PersistentSession;

import javax.ejb.Local;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Local
public interface PedidoBeanLocal {

	/**
	 *
	 * @param emailDono
	 * @param dataInicio
	 * @param dataFim
	 */
	int registarPedido(String emailDono, Date dataInicio, Date dataFim);
	/**
	 *
	 * @param emailPetsitter
	 * @param idPedido
	 */
	boolean concluirPedido(String emailPetsitter, int idPedido);

	/**
	 *
	 * @param idPedido
	 * @param animalServicos
	 */
	List<Petsitter> getPetsittersPedido(int idPedido, Map<Integer, List<Integer>> animalServicos);

	/**
	 *
	 * @param idPedido
	 */
	boolean cancelarPedido(int idPedido);

	/**
	 *
	 * @param email
	 */
	List<Pedido> consultarPedidos(String email);

	/**
	 *
	 * @param tiposAnimal
	 */
	Map<TipoAnimal,List<Servico>> getServicosPedido(List<TipoAnimal> tiposAnimal);

	/**
	 *
	 * @param animalServicos
	 */
	boolean registarServicosPedido(Map<Integer,List<Integer>> animalServicos);
}