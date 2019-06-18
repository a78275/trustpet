/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListClassData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Utilizador...");
		trustpet.Utilizador[] trustpetUtilizadors = trustpet.UtilizadorDAO.listUtilizadorByQuery(null, null);
		int length = Math.min(trustpetUtilizadors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetUtilizadors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Dono...");
		trustpet.Dono[] trustpetDonos = trustpet.DonoDAO.listDonoByQuery(null, null);
		length = Math.min(trustpetDonos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetDonos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Petsitter...");
		trustpet.Petsitter[] trustpetPetsitters = trustpet.PetsitterDAO.listPetsitterByQuery(null, null);
		length = Math.min(trustpetPetsitters.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetPetsitters[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Pedido...");
		trustpet.Pedido[] trustpetPedidos = trustpet.PedidoDAO.listPedidoByQuery(null, null);
		length = Math.min(trustpetPedidos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetPedidos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Servico...");
		trustpet.Servico[] trustpetServicos = trustpet.ServicoDAO.listServicoByQuery(null, null);
		length = Math.min(trustpetServicos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetServicos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Animal...");
		trustpet.Animal[] trustpetAnimals = trustpet.AnimalDAO.listAnimalByQuery(null, null);
		length = Math.min(trustpetAnimals.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetAnimals[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Review...");
		trustpet.Review[] trustpetReviews = trustpet.ReviewDAO.listReviewByQuery(null, null);
		length = Math.min(trustpetReviews.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetReviews[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing TipoAnimal...");
		trustpet.TipoAnimal[] trustpetTipoAnimals = trustpet.TipoAnimalDAO.listTipoAnimalByQuery(null, null);
		length = Math.min(trustpetTipoAnimals.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetTipoAnimals[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Horario...");
		trustpet.Horario[] trustpetHorarios = trustpet.HorarioDAO.listHorarioByQuery(null, null);
		length = Math.min(trustpetHorarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetHorarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Hora...");
		trustpet.Hora[] trustpetHoras = trustpet.HoraDAO.listHoraByQuery(null, null);
		length = Math.min(trustpetHoras.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetHoras[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		trustpet.Administrador[] trustpetAdministradors = trustpet.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(trustpetAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing PrecoPetsitterServico...");
		trustpet.PrecoPetsitterServico[] trustpetPrecoPetsitterServicos = trustpet.PrecoPetsitterServicoDAO.listPrecoPetsitterServicoByQuery(null, null);
		length = Math.min(trustpetPrecoPetsitterServicos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(trustpetPrecoPetsitterServicos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Utilizador by Criteria...");
		trustpet.UtilizadorCriteria ltrustpetUtilizadorCriteria = new trustpet.UtilizadorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetUtilizadorCriteria.email.eq();
		ltrustpetUtilizadorCriteria.setMaxResults(ROW_COUNT);
		trustpet.Utilizador[] trustpetUtilizadors = ltrustpetUtilizadorCriteria.listUtilizador();
		int length =trustpetUtilizadors== null ? 0 : Math.min(trustpetUtilizadors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetUtilizadors[i]);
		}
		System.out.println(length + " Utilizador record(s) retrieved."); 
		
		System.out.println("Listing Dono by Criteria...");
		trustpet.DonoCriteria ltrustpetDonoCriteria = new trustpet.DonoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetDonoCriteria.email.eq();
		ltrustpetDonoCriteria.setMaxResults(ROW_COUNT);
		trustpet.Dono[] trustpetDonos = ltrustpetDonoCriteria.listDono();
		length =trustpetDonos== null ? 0 : Math.min(trustpetDonos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetDonos[i]);
		}
		System.out.println(length + " Dono record(s) retrieved."); 
		
		System.out.println("Listing Petsitter by Criteria...");
		trustpet.PetsitterCriteria ltrustpetPetsitterCriteria = new trustpet.PetsitterCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetPetsitterCriteria.email.eq();
		ltrustpetPetsitterCriteria.setMaxResults(ROW_COUNT);
		trustpet.Petsitter[] trustpetPetsitters = ltrustpetPetsitterCriteria.listPetsitter();
		length =trustpetPetsitters== null ? 0 : Math.min(trustpetPetsitters.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetPetsitters[i]);
		}
		System.out.println(length + " Petsitter record(s) retrieved."); 
		
		System.out.println("Listing Pedido by Criteria...");
		trustpet.PedidoCriteria ltrustpetPedidoCriteria = new trustpet.PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetPedidoCriteria.id.eq();
		ltrustpetPedidoCriteria.setMaxResults(ROW_COUNT);
		trustpet.Pedido[] trustpetPedidos = ltrustpetPedidoCriteria.listPedido();
		length =trustpetPedidos== null ? 0 : Math.min(trustpetPedidos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetPedidos[i]);
		}
		System.out.println(length + " Pedido record(s) retrieved."); 
		
		System.out.println("Listing Servico by Criteria...");
		trustpet.ServicoCriteria ltrustpetServicoCriteria = new trustpet.ServicoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetServicoCriteria.id.eq();
		ltrustpetServicoCriteria.setMaxResults(ROW_COUNT);
		trustpet.Servico[] trustpetServicos = ltrustpetServicoCriteria.listServico();
		length =trustpetServicos== null ? 0 : Math.min(trustpetServicos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetServicos[i]);
		}
		System.out.println(length + " Servico record(s) retrieved."); 
		
		System.out.println("Listing Animal by Criteria...");
		trustpet.AnimalCriteria ltrustpetAnimalCriteria = new trustpet.AnimalCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetAnimalCriteria.id.eq();
		ltrustpetAnimalCriteria.setMaxResults(ROW_COUNT);
		trustpet.Animal[] trustpetAnimals = ltrustpetAnimalCriteria.listAnimal();
		length =trustpetAnimals== null ? 0 : Math.min(trustpetAnimals.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetAnimals[i]);
		}
		System.out.println(length + " Animal record(s) retrieved."); 
		
		System.out.println("Listing Review by Criteria...");
		trustpet.ReviewCriteria ltrustpetReviewCriteria = new trustpet.ReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetReviewCriteria.id.eq();
		ltrustpetReviewCriteria.setMaxResults(ROW_COUNT);
		trustpet.Review[] trustpetReviews = ltrustpetReviewCriteria.listReview();
		length =trustpetReviews== null ? 0 : Math.min(trustpetReviews.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetReviews[i]);
		}
		System.out.println(length + " Review record(s) retrieved."); 
		
		System.out.println("Listing TipoAnimal by Criteria...");
		trustpet.TipoAnimalCriteria ltrustpetTipoAnimalCriteria = new trustpet.TipoAnimalCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetTipoAnimalCriteria.id.eq();
		ltrustpetTipoAnimalCriteria.setMaxResults(ROW_COUNT);
		trustpet.TipoAnimal[] trustpetTipoAnimals = ltrustpetTipoAnimalCriteria.listTipoAnimal();
		length =trustpetTipoAnimals== null ? 0 : Math.min(trustpetTipoAnimals.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetTipoAnimals[i]);
		}
		System.out.println(length + " TipoAnimal record(s) retrieved."); 
		
		System.out.println("Listing Horario by Criteria...");
		trustpet.HorarioCriteria ltrustpetHorarioCriteria = new trustpet.HorarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetHorarioCriteria.id.eq();
		ltrustpetHorarioCriteria.setMaxResults(ROW_COUNT);
		trustpet.Horario[] trustpetHorarios = ltrustpetHorarioCriteria.listHorario();
		length =trustpetHorarios== null ? 0 : Math.min(trustpetHorarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetHorarios[i]);
		}
		System.out.println(length + " Horario record(s) retrieved."); 
		
		System.out.println("Listing Hora by Criteria...");
		trustpet.HoraCriteria ltrustpetHoraCriteria = new trustpet.HoraCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetHoraCriteria.hora.eq();
		ltrustpetHoraCriteria.setMaxResults(ROW_COUNT);
		trustpet.Hora[] trustpetHoras = ltrustpetHoraCriteria.listHora();
		length =trustpetHoras== null ? 0 : Math.min(trustpetHoras.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetHoras[i]);
		}
		System.out.println(length + " Hora record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		trustpet.AdministradorCriteria ltrustpetAdministradorCriteria = new trustpet.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetAdministradorCriteria.email.eq();
		ltrustpetAdministradorCriteria.setMaxResults(ROW_COUNT);
		trustpet.Administrador[] trustpetAdministradors = ltrustpetAdministradorCriteria.listAdministrador();
		length =trustpetAdministradors== null ? 0 : Math.min(trustpetAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing PrecoPetsitterServico by Criteria...");
		trustpet.PrecoPetsitterServicoCriteria ltrustpetPrecoPetsitterServicoCriteria = new trustpet.PrecoPetsitterServicoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//ltrustpetPrecoPetsitterServicoCriteria.id.eq();
		ltrustpetPrecoPetsitterServicoCriteria.setMaxResults(ROW_COUNT);
		trustpet.PrecoPetsitterServico[] trustpetPrecoPetsitterServicos = ltrustpetPrecoPetsitterServicoCriteria.listPrecoPetsitterServico();
		length =trustpetPrecoPetsitterServicos== null ? 0 : Math.min(trustpetPrecoPetsitterServicos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(trustpetPrecoPetsitterServicos[i]);
		}
		System.out.println(length + " PrecoPetsitterServico record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListClassData listClassData = new ListClassData();
			try {
				listClassData.listTestData();
				//listClassData.listByCriteria();
			}
			finally {
				trustpet.ClassPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
