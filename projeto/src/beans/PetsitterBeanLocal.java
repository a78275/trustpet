package beans;

import main.Petsitter;
import org.orm.PersistentSession;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

@Local
public interface PetsitterBeanLocal {

	/**
	 *
	 * @param emailPetsitter
	 * @param tipos
	 */
	boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos);

	/**
	 *
	 * @param emailPetsitter
	 * @param servicos
	 */
	boolean registarServicos(String emailPetsitter, Map<Integer, Double> servicos);

	/**
	 *
	 * @param emailPetsitter
	 * @param horario
	 */
	boolean editarHorario(String emailPetsitter, Map<Integer, List<Integer>> horario);

	/**
	 *
	 * @param filtro
	 * @param ordem
	 */
	List<Petsitter> consultarPetsitters(String filtro, String ordem);

	/**
	 *
	 * @param email
	 */
	Map<String, Double> getServicosPetsitter(String email);
}