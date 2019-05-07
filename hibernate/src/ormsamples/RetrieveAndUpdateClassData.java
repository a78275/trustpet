/**
 * Licensee: Joana(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateClassData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = trustpet.ClassPersistentManager.instance().getSession().beginTransaction();
		try {
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
			trustpet.Tipo_Animal ltrustpetTipo_Animal = trustpet.Tipo_AnimalDAO.loadTipo_AnimalByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.Tipo_AnimalDAO.save(ltrustpetTipo_Animal);
			trustpet.Mensagem ltrustpetMensagem = trustpet.MensagemDAO.loadMensagemByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.MensagemDAO.save(ltrustpetMensagem);
			trustpet.Horario ltrustpetHorario = trustpet.HorarioDAO.loadHorarioByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.HorarioDAO.save(ltrustpetHorario);
			trustpet.Dia ltrustpetDia = trustpet.DiaDAO.loadDiaByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.DiaDAO.save(ltrustpetDia);
			trustpet.Hora ltrustpetHora = trustpet.HoraDAO.loadHoraByQuery(null, null);
			// Update the properties of the persistent object
			trustpet.HoraDAO.save(ltrustpetHora);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Dono by DonoCriteria");
		trustpet.DonoCriteria ltrustpetDonoCriteria = new trustpet.DonoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetDonoCriteria.id.eq();
		System.out.println(ltrustpetDonoCriteria.uniqueDono());
		
		System.out.println("Retrieving Petsitter by PetsitterCriteria");
		trustpet.PetsitterCriteria ltrustpetPetsitterCriteria = new trustpet.PetsitterCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetPetsitterCriteria.id.eq();
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
		
		System.out.println("Retrieving Tipo_Animal by Tipo_AnimalCriteria");
		trustpet.Tipo_AnimalCriteria ltrustpetTipo_AnimalCriteria = new trustpet.Tipo_AnimalCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetTipo_AnimalCriteria.id.eq();
		System.out.println(ltrustpetTipo_AnimalCriteria.uniqueTipo_Animal());
		
		System.out.println("Retrieving Mensagem by MensagemCriteria");
		trustpet.MensagemCriteria ltrustpetMensagemCriteria = new trustpet.MensagemCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetMensagemCriteria.id.eq();
		System.out.println(ltrustpetMensagemCriteria.uniqueMensagem());
		
		System.out.println("Retrieving Horario by HorarioCriteria");
		trustpet.HorarioCriteria ltrustpetHorarioCriteria = new trustpet.HorarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetHorarioCriteria.id.eq();
		System.out.println(ltrustpetHorarioCriteria.uniqueHorario());
		
		System.out.println("Retrieving Dia by DiaCriteria");
		trustpet.DiaCriteria ltrustpetDiaCriteria = new trustpet.DiaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetDiaCriteria.id.eq();
		System.out.println(ltrustpetDiaCriteria.uniqueDia());
		
		System.out.println("Retrieving Hora by HoraCriteria");
		trustpet.HoraCriteria ltrustpetHoraCriteria = new trustpet.HoraCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//ltrustpetHoraCriteria.id.eq();
		System.out.println(ltrustpetHoraCriteria.uniqueHora());
		
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
