package beans;

import main.Animal;
import org.orm.PersistentSession;

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
	 * @param desparasitacao
	 * @param esterilizacao
	 * @param raca
	 * @param avatar
	 * @param tipo
	 */
	boolean registarAnimal(String emailDono, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, int tipo);

	/**
	 *
	 * @param emailDono
	 */
	List<Animal> consultarAnimais(String emailDono);

	/**
	 *
	 * @param id
	 * @param nome
	 * @param idade
	 * @param porte
	 * @param sexo
	 * @param alergias
	 * @param doencas
	 * @param comportamento
	 * @param vacinas
	 * @param desparasitacao
	 * @param esterilizacao
	 * @param raca
	 * @param avatar
	 * @param ativo
	 */
	boolean editarAnimal(int id, String nome, int idade, String porte, String sexo, String alergias, String doencas, String comportamento, boolean vacinas, boolean desparasitacao, boolean esterilizacao, String raca, String avatar, boolean ativo);


}