package beans;

public interface DonoBeanLocal {

	/**
	 * 
	 * @param emailDono
	 * @param nome
	 * @param idade
	 * @param porte
	 * @param sexo
	 * @param alergias
	 * @param doencas
	 * @param comportamento
	 * @param vacinas
	 * @param desparazitacao
	 * @param esterilizacao
	 * @param raca
	 * @param avatar
	 */
	boolean registarAnimal(string emailDono, string nome, int idade, string porte, string sexo, string alergias, string doencas, string comportamento, boolean vacinas, boolean desparazitacao, boolean esterilizacao, string raca, string avatar);

	/**
	 * 
	 * @param emailDono
	 */
	List<Animal> consultarAnimais(string emailDono);

}