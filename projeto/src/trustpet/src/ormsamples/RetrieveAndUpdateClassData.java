/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateClassData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = trustpet.ClassPersistentManager.instance().getSession().beginTransaction();
		try {
			trustpet.Utilizador ltrustpetUtilizador = trustpet.UtilizadorDAO.loadUtilizadorByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.UtilizadorDAO.save(ltrustpetUtilizador);
			trustpet.Dono ltrustpetDono = trustpet.DonoDAO.loadDonoByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.DonoDAO.save(ltrustpetDono);
			trustpet.Petsitter ltrustpetPetsitter = trustpet.PetsitterDAO.loadPetsitterByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.PetsitterDAO.save(ltrustpetPetsitter);
			trustpet.Pedido ltrustpetPedido = trustpet.PedidoDAO.loadPedidoByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.PedidoDAO.save(ltrustpetPedido);
			trustpet.Servico ltrustpetServico = trustpet.ServicoDAO.loadServicoByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.ServicoDAO.save(ltrustpetServico);
			trustpet.Animal ltrustpetAnimal = trustpet.AnimalDAO.loadAnimalByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.AnimalDAO.save(ltrustpetAnimal);
			trustpet.Review ltrustpetReview = trustpet.ReviewDAO.loadReviewByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.ReviewDAO.save(ltrustpetReview);
			trustpet.TipoAnimal ltrustpetTipoAnimal = trustpet.TipoAnimalDAO.loadTipoAnimalByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.TipoAnimalDAO.save(ltrustpetTipoAnimal);
			trustpet.Horario ltrustpetHorario = trustpet.HorarioDAO.loadHorarioByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.HorarioDAO.save(ltrustpetHorario);
			trustpet.Hora ltrustpetHora = trustpet.HoraDAO.loadHoraByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.HoraDAO.save(ltrustpetHora);
			trustpet.Administrador ltrustpetAdministrador = trustpet.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.AdministradorDAO.save(ltrustpetAdministrador);
			trustpet.PrecoPetsitterServico ltrustpetPrecoPetsitterServico = trustpet.PrecoPetsitterServicoDAO.loadPrecoPetsitterServicoByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.PrecoPetsitterServicoDAO.save(ltrustpetPrecoPetsitterServico);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Utilizador by UtilizadorCriteria");
		trustpet.UtilizadorCriteria ltrustpetUtilizadorCriteria = new trustpet.UtilizadorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetUtilizadorCriteria.email.eq();
		System.out.println(ltrustpetUtilizadorCriteria.uniqueUtilizador());
		
		System.out.println("Retrieving Dono by DonoCriteria");
		trustpet.DonoCriteria ltrustpetDonoCriteria = new trustpet.DonoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetDonoCriteria.email.eq();
		System.out.println(ltrustpetDonoCriteria.uniqueDono());
		
		System.out.println("Retrieving Petsitter by PetsitterCriteria");
		trustpet.PetsitterCriteria ltrustpetPetsitterCriteria = new trustpet.PetsitterCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetPetsitterCriteria.email.eq();
		System.out.println(ltrustpetPetsitterCriteria.uniquePetsitter());
		
		System.out.println("Retrieving Pedido by PedidoCriteria");
		trustpet.PedidoCriteria ltrustpetPedidoCriteria = new trustpet.PedidoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetPedidoCriteria.id.eq();
		System.out.println(ltrustpetPedidoCriteria.uniquePedido());
		
		System.out.println("Retrieving Servico by ServicoCriteria");
		trustpet.ServicoCriteria ltrustpetServicoCriteria = new trustpet.ServicoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetServicoCriteria.id.eq();
		System.out.println(ltrustpetServicoCriteria.uniqueServico());
		
		System.out.println("Retrieving Animal by AnimalCriteria");
		trustpet.AnimalCriteria ltrustpetAnimalCriteria = new trustpet.AnimalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetAnimalCriteria.id.eq();
		System.out.println(ltrustpetAnimalCriteria.uniqueAnimal());
		
		System.out.println("Retrieving Review by ReviewCriteria");
		trustpet.ReviewCriteria ltrustpetReviewCriteria = new trustpet.ReviewCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetReviewCriteria.id.eq();
		System.out.println(ltrustpetReviewCriteria.uniqueReview());
		
		System.out.println("Retrieving TipoAnimal by TipoAnimalCriteria");
		trustpet.TipoAnimalCriteria ltrustpetTipoAnimalCriteria = new trustpet.TipoAnimalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetTipoAnimalCriteria.id.eq();
		System.out.println(ltrustpetTipoAnimalCriteria.uniqueTipoAnimal());
		
		System.out.println("Retrieving Horario by HorarioCriteria");
		trustpet.HorarioCriteria ltrustpetHorarioCriteria = new trustpet.HorarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetHorarioCriteria.id.eq();
		System.out.println(ltrustpetHorarioCriteria.uniqueHorario());
		
		System.out.println("Retrieving Hora by HoraCriteria");
		trustpet.HoraCriteria ltrustpetHoraCriteria = new trustpet.HoraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetHoraCriteria.hora.eq();
		System.out.println(ltrustpetHoraCriteria.uniqueHora());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		trustpet.AdministradorCriteria ltrustpetAdministradorCriteria = new trustpet.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetAdministradorCriteria.email.eq();
		System.out.println(ltrustpetAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving PrecoPetsitterServico by PrecoPetsitterServicoCriteria");
		trustpet.PrecoPetsitterServicoCriteria ltrustpetPrecoPetsitterServicoCriteria = new trustpet.PrecoPetsitterServicoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetPrecoPetsitterServicoCriteria.id.eq();
		System.out.println(ltrustpetPrecoPetsitterServicoCriteria.uniquePrecoPetsitterServico());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateClassData retrieveAndUpdateClassData = new RetrieveAndUpdateClassData();
			try {
				retrieveAndUpdateClassData.retrieveAndUpdateTestData();
				//retrieveAndUpdateClassData.retrieveByCriteria();
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
