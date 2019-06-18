package beans;

import trustpet.Petsitter;

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
	boolean registarServicos(String emailPetsitter, Map<Integer, Float> servicos);

	/**
	 *
	 * @param emailPetsitter
	 * @param horario
	 */
	boolean editarHorario(String emailPetsitter, Map<String, List<Integer>> horario);

	/**
	 *
	 * @param filtro
	 */
	List<Petsitter> consultarPetsitters(String filtro);

	/**
	 *
	 * @param emailPetsitter
	 * @param servicos
	 */
	boolean editarServicos(String emailPetsitter, Map<Integer, Float> servicos);

}