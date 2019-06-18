package beans;

public interface PetsitterBeanLocal {

	/**
	 * 
	 * @param emailPetsitter
	 * @param tipos
	 */
	boolean registarTiposAnimais(string emailPetsitter, List<Integer> tipos);

	/**
	 * 
	 * @param emailPetsitter
	 * @param servicos
	 */
	boolean registarServicos(string emailPetsitter, Map<Integer, Float> servicos);

	/**
	 * 
	 * @param emailPetsitter
	 * @param horario
	 */
	boolean registarHorario(string emailPetsitter, Map<String, List<Integer>> horario);

	/**
	 * 
	 * @param filtro
	 */
	List<Petsitter> consultarPetsitters(string filtro);

}