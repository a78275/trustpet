package trustpet;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import trustpet.*;

import java.util.Arrays;
import java.util.List;

public class FacadeDAOs {

	public Review createReview() {
		return ReviewDAO.createReview();
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public List<Review> listReviews(PersistentSession session, String condition, String orderBy) throws PersistentException {
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
	public boolean savePetsitter(Petsitter petsitter) throws PersistentException {
        return PetsitterDAO.save(petsitter);
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public List<Petsitter> listPetsitters(PersistentSession session, String condition, String orderBy) throws PersistentException {
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
	public Petsitter getPetsitter(PersistentSession session, String email) throws PersistentException {
        if(session == null) {
            return PetsitterDAO.getPetsitterByORMID(email);
        }
        else {
            return PetsitterDAO.getPetsitterByORMID(session, email);
        }
	}

	public Petsitter createPetsitter() {
		return PetsitterDAO.createPetsitter();
	}

	public Dono createDono() {
        return DonoDAO.createDono();
	}

	/**
	 * 
	 * @param session
	 * @param email
	 */
	public Dono getDono(PersistentSession session, String email) throws PersistentException {
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
	public boolean saveDono(Dono dono) throws PersistentException {
        return DonoDAO.save(dono);
	}

	/**
	 * 
	 * @param session
	 * @param id
	 */
	public PrecoPetsitterServico getPrecoPetsitterServico(PersistentSession session, int id) throws PersistentException {
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
	public boolean savePrecoPetsitterServico(PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
        return PrecoPetsitterServicoDAO.save(precoPetsitterServico);
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public List<PrecoPetsitterServico> listPrecoPetsitterServico(PersistentSession session, String condition, String orderBy) throws PersistentException {
        if(session == null) {
            return Arrays.asList(PrecoPetsitterServicoDAO.listPrecoPetsitterServicoByQuery(condition, orderBy));
        }
        else {
            return Arrays.asList(PrecoPetsitterServicoDAO.listPrecoPetsitterServicoByQuery(session, condition, orderBy));
        }
	}

	public PrecoPetsitterServico createPrecoPetsitterServico() {
		return PrecoPetsitterServicoDAO.createPrecoPetsitterServico();
	}

	/**
	 * 
	 * @param precoPetsitterServico
	 */
	public boolean deletePrecoPetsitterServico(PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
        return PrecoPetsitterServicoDAO.delete(precoPetsitterServico);
	}

	/**
	 * 
	 * @param horario
	 */
	public boolean saveHorario(Horario horario) throws PersistentException {
        return HorarioDAO.save(horario);
	}

	/**
	 * 
	 * @param session
	 * @param id
	 */
	public Horario getHorario(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return HorarioDAO.getHorarioByORMID(id);
        }
        else {
            return HorarioDAO.getHorarioByORMID(session, id);
        }
	}

	public Horario createHorario() {
		return HorarioDAO.createHorario();
	}

	/**
	 * 
	 * @param animal
	 */
	public boolean saveAnimal(Animal animal) throws PersistentException {
        return AnimalDAO.save(animal);
	}

	/**
	 * 
	 * @param session
	 * @param id
	 */
	public Animal getAnimal(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return AnimalDAO.getAnimalByORMID(id);
        }
        else {
            return AnimalDAO.getAnimalByORMID(session, id);
        }
	}

	public Animal createAnimal() {
		return AnimalDAO.createAnimal();
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public List<Animal> listAnimal(PersistentSession session, String condition, String orderBy) throws PersistentException {
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
	public boolean savePedido(Pedido pedido) throws PersistentException {
        return PedidoDAO.save(pedido);
	}

	/**
	 * 
	 * @param session
	 * @param id
	 */
	public Pedido getPedido(PersistentSession session, int id) throws PersistentException {
        if(session == null) {
            return PedidoDAO.getPedidoByORMID(id);
        }
        else {
            return PedidoDAO.getPedidoByORMID(session, id);
        }
	}

	public Pedido createPedido() {
		return PedidoDAO.createPedido();
	}

	/**
	 * 
	 * @param session
	 * @param condition
	 * @param orderBy
	 */
	public List<Pedido> listPedido(PersistentSession session, String condition, String orderBy) throws PersistentException {
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
	public Administrador getAdministrador(PersistentSession session, String email) throws PersistentException {
        if(session == null) {
            return AdministradorDAO.getAdministradorByORMID(email);
        }
        else {
            return AdministradorDAO.getAdministradorByORMID(session, email);
        }
	}

}