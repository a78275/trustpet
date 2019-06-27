package main;

import org.orm.PersistentException;

import java.util.Arrays;
import java.util.List;

public class FacadeDAOs {

	public static Review createReview() {
		return ReviewDAO.createReview();
	}

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<Review> listReviews(String condition, String orderBy) throws PersistentException {
		return Arrays.asList(ReviewDAO.listReviewByQuery(condition, orderBy));
	}

    /**
     *
     * @param review
     */
    public static boolean saveReview(Review review) throws PersistentException {
        return ReviewDAO.save(review);
    }

	/**
	 * 
	 * @param petsitter
	 */
	public static boolean savePetsitter(Petsitter petsitter) throws PersistentException {
        return PetsitterDAO.save(petsitter);
	}

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<Petsitter> listPetsitters(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(PetsitterDAO.listPetsitterByQuery(condition, orderBy));
	}

	/**
	 *
	 * @param email
	 */
	public static Petsitter getPetsitter(String email) throws PersistentException {
        return PetsitterDAO.getPetsitterByORMID(email);
	}

	public static Petsitter createPetsitter() {
		return PetsitterDAO.createPetsitter();
	}

	public static Dono createDono() {
        return DonoDAO.createDono();
	}

	/**
	 *
	 * @param email
	 */
	public static Dono getDono(String email) throws PersistentException {
        return DonoDAO.getDonoByORMID(email);
	}

	/**
	 * 
	 * @param dono
	 */
	public static boolean saveDono(Dono dono) throws PersistentException {
        return DonoDAO.save(dono);
	}

	/**
	 *
	 * @param id
	 */
	public static PrecoPetsitterServico getPrecoPetsitterServico(int id) throws PersistentException {
		return PrecoPetsitterServicoDAO.getPrecoPetsitterServicoByORMID(id);
	}

	/**
	 * 
	 * @param precoPetsitterServico
	 */
	public static boolean savePrecoPetsitterServico(PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
        return PrecoPetsitterServicoDAO.save(precoPetsitterServico);
	}

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<PrecoPetsitterServico> listPrecoPetsitterServico(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(PrecoPetsitterServicoDAO.listPrecoPetsitterServicoByQuery(condition, orderBy));
	}

	public static PrecoPetsitterServico createPrecoPetsitterServico() {
		return PrecoPetsitterServicoDAO.createPrecoPetsitterServico();
	}

	/**
	 * 
	 * @param precoPetsitterServico
	 */
	public static boolean deletePrecoPetsitterServico(PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
        return PrecoPetsitterServicoDAO.delete(precoPetsitterServico);
	}

	/**
	 * 
	 * @param horario
	 */
	public static boolean saveHorario(Horario horario) throws PersistentException {
        return HorarioDAO.save(horario);
	}

	/**
	 *
	 * @param id
	 */
	public static Horario getHorario(int id) throws PersistentException {
        return HorarioDAO.getHorarioByORMID(id);
	}

	public static Horario createHorario() {
		return HorarioDAO.createHorario();
	}

	/**
	 * 
	 * @param animal
	 */
	public static boolean saveAnimal(Animal animal) throws PersistentException {
        return AnimalDAO.save(animal);
	}

	/**
	 *
	 * @param id
	 */
	public static Animal getAnimal(int id) throws PersistentException {
        return AnimalDAO.getAnimalByORMID(id);
	}

	public static Animal createAnimal() {
		return AnimalDAO.createAnimal();
	}

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<Animal> listAnimal(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(AnimalDAO.listAnimalByQuery(condition, orderBy));
	}

	/**
	 * 
	 * @param pedido
	 */
	public static boolean savePedido(Pedido pedido) throws PersistentException {
        return PedidoDAO.save(pedido);
	}

	/**
	 *
	 * @param id
	 */
	public static Pedido getPedido(int id) throws PersistentException {
        return PedidoDAO.getPedidoByORMID(id);
	}

	public static Pedido createPedido() {
		return PedidoDAO.createPedido();
	}

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<Pedido> listPedido(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(PedidoDAO.listPedidoByQuery(condition, orderBy));
	}

	/**
	 *
	 * @param email
	 */
	public static Administrador getAdministrador(String email) throws PersistentException {
        return AdministradorDAO.getAdministradorByORMID(email);
	}

    /**
     *
     * @param id
     */
    public static Servico getServico(int id) throws PersistentException {
        return ServicoDAO.getServicoByORMID(id);
    }

    /**
     *
     * @param id
     */
    public static TipoAnimal getTipoAnimal(int id) throws PersistentException {
        return TipoAnimalDAO.getTipoAnimalByORMID(id);
    }

    /**
     *
     * @param animalServico
     */
    public static boolean saveAnimalServico(AnimalServico animalServico) throws PersistentException {
        return AnimalServicoDAO.save(animalServico);
    }

    public static AnimalServico createAnimalServico() {
        return AnimalServicoDAO.createAnimalServico();
    }

    /**
     *
     * @param condition
     * @param orderBy
     */
    public static List<AnimalServico> listAnimalServico(String condition, String orderBy) throws PersistentException {
        return Arrays.asList(AnimalServicoDAO.listAnimalServicoByQuery(condition, orderBy));
    }

    public static Dia createDia() {
        return DiaDAO.createDia();
    }

    /**
     *
     * @param dia
     */
    public static boolean saveDia(Dia dia) throws PersistentException {
        return DiaDAO.save(dia);
    }

    /**
     *
     * @param id
     */
    public static Hora getHora(int id) throws PersistentException {
        return HoraDAO.getHoraByORMID(id);
    }

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<Servico> listServicos(String condition, String orderBy) throws PersistentException {
		return Arrays.asList(ServicoDAO.listServicoByQuery(condition, orderBy));
	}

	/**
	 *
	 * @param email
	 */
	public static Utilizador getUtilizador(String email) throws PersistentException {
		return UtilizadorDAO.getUtilizadorByORMID(email);
	}

	/**
	 *
	 * @param condition
	 * @param orderBy
	 */
	public static List<Utilizador> listUtilizadores (String condition, String orderBy) throws PersistentException {
		return Arrays.asList(UtilizadorDAO.listUtilizadorByQuery(condition, orderBy));
	}

    /**
     *
     * @param utilizador
     */
    public static boolean saveUtilizador(Utilizador utilizador) throws PersistentException {
        return UtilizadorDAO.save(utilizador);
    }
}