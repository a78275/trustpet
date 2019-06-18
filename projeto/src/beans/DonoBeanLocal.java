package beans;

import trustpet.Animal;

import javax.ejb.Local;
import java.util.List;

@Local
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
	boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparazitacao, boolean esterilizacao, String raca, String avatar);

	/**
	 * 
	 * @param emailDono
	 */
	List<Animal> consultarAnimais(String emailDono);

}