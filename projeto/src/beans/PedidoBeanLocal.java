package beans;

import main.*;
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
	Map<Petsitter,Double> getPetsittersPedido(int idPedido, Map<Integer, List<Integer>> animalServicos);

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
	 * @param idAnimal
	 */
	Map<Animal, List<Servico>> getServicosPedido(List<Integer> idAnimal);

	/**
	 *
	 * @param idPedido
	 * @param animalServicos
	 */
	boolean registarServicosPedido(int idPedido, Map<Integer,List<Integer>> animalServicos);

	/**
	 *
	 * @param idPedido
	 * @param dataInicio
	 * @param dataFim
	 */
	int editarPedido(int idPedido, Date dataInicio, Date dataFim);
}