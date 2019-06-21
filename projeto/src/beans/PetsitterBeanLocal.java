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
	 * @param session
	 */
	boolean registarTiposAnimais(String emailPetsitter, List<Integer> tipos, PersistentSession session);

	/**
	 *
	 * @param emailPetsitter
	 * @param servicos
	 * @param session
	 */
	boolean registarServicos(String emailPetsitter, Map<Integer, Double> servicos, PersistentSession session);

	/**
	 *
	 * @param emailPetsitter
	 * @param horario
	 * @param session
	 */
	boolean editarHorario(String emailPetsitter, Map<Integer, List<Integer>> horario, PersistentSession session);

	/**
	 *
	 * @param filtro
	 * @param session
	 */
	List<Petsitter> consultarPetsitters(String filtro, PersistentSession session);

	/**
	 *
	 * @param emailPetsitter
	 * @param servicos
	 * @param session
	 */
	boolean editarServicos(String emailPetsitter, Map<Integer, Double> servicos, PersistentSession session);

}