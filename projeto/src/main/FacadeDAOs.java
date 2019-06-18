package main;

import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.Arrays;
import java.util.List;

public class FacadeDAOs {

	public static Review createReview() {
		return ReviewDAO.createReview();
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public static List<Review> listReviews(PersistentSession session, String condition, String orderBy) throws PersistentException {
		if(session == null) {
            return Arrays.asList(ReviewDAO.listReviewByQuery(condition, orderBy));
        }
        else {
            return Arrays.asList(ReviewDAO.listReviewByQuery(session, condition, orderBy));
        }
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
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public static List<Petsitter> listPetsitters(PersistentSession session, String condition, String orderBy) throws PersistentException {
        if(session == null) {
            return Arrays.asList(PetsitterDAO.listPetsitterByQuery(condition, orderBy));
        }
        else {
            return Arrays.asList(PetsitterDAO.listPetsitterByQuery(session, condition, orderBy));
        }
	}

	/**
	 * 
	 * @param session
	 * @param email
	 */
	public static Petsitter getPetsitter(PersistentSession session, String email) throws PersistentException {
        if(session == null) {
            return PetsitterDAO.getPetsitterByORMID(email);
        }
        else {
            return PetsitterDAO.getPetsitterByORMID(session, email);
        }
	}

	public static Petsitter createPetsitter() {
		return PetsitterDAO.createPetsitter();
	}

	public static Dono createDono() {
        return DonoDAO.createDono();
	}

	/**
	 * 
	 * @param session
	 * @param email
	 */
	public static Dono getDono(PersistentSession session, String email) throws PersistentException {
        if(session == null) {
            return DonoDAO.getDonoByORMID(email);
        }
        else {
            return DonoDAO.getDonoByORMID(session, email);
        }
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
	 * @param session
	 * @param id
	 */
	public static PrecoPetsitterServico getPrecoPetsitterServico(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return PrecoPetsitterServicoDAO.getPrecoPetsitterServicoByORMID(id);
        }
        else {
            return PrecoPetsitterServicoDAO.getPrecoPetsitterServicoByORMID(session, id);
        }
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
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public static List<PrecoPetsitterServico> listPrecoPetsitterServico(PersistentSession session, String condition, String orderBy) throws PersistentException {
        if(session == null) {
            return Arrays.asList(PrecoPetsitterServicoDAO.listPrecoPetsitterServicoByQuery(condition, orderBy));
        }
        else {
            return Arrays.asList(PrecoPetsitterServicoDAO.listPrecoPetsitterServicoByQuery(session, condition, orderBy));
        }
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
	 * @param session
	 * @param id
	 */
	public static Horario getHorario(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return HorarioDAO.getHorarioByORMID(id);
        }
        else {
            return HorarioDAO.getHorarioByORMID(session, id);
        }
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
	 * @param session
	 * @param id
	 */
	public static Animal getAnimal(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return AnimalDAO.getAnimalByORMID(id);
        }
        else {
            return AnimalDAO.getAnimalByORMID(session, id);
        }
	}

	public static Animal createAnimal() {
		return AnimalDAO.createAnimal();
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public static List<Animal> listAnimal(PersistentSession session, String condition, String orderBy) throws PersistentException {
        if(session == null) {
            return Arrays.asList(AnimalDAO.listAnimalByQuery(condition, orderBy));
        }
        else {
            return Arrays.asList(AnimalDAO.listAnimalByQuery(session, condition, orderBy));
        }
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
	 * @param session
	 * @param id
	 */
	public static Pedido getPedido(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return PedidoDAO.getPedidoByORMID(id);
        }
        else {
            return PedidoDAO.getPedidoByORMID(session, id);
        }
	}

	public static Pedido createPedido() {
		return PedidoDAO.createPedido();
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public static List<Pedido> listPedido(PersistentSession session, String condition, String orderBy) throws PersistentException {
        if(session == null) {
            return Arrays.asList(PedidoDAO.listPedidoByQuery(condition, orderBy));
        }
        else {
            return Arrays.asList(PedidoDAO.listPedidoByQuery(session, condition, orderBy));
        }
	}

	/**
	 * 
	 * @param session
	 * @param email
	 */
	public static Administrador getAdministrador(PersistentSession session, String email) throws PersistentException {
        if(session == null) {
            return AdministradorDAO.getAdministradorByORMID(email);
        }
        else {
            return AdministradorDAO.getAdministradorByORMID(session, email);
        }
	}

}