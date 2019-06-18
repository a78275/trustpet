/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteClassData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = trustpet.ClassPersistentManager.instance().getSession().beginTransaction();
		try {
			trustpet.Utilizador ltrustpetUtilizador = trustpet.UtilizadorDAO.loadUtilizadorByQuery(null, null);
			// Delete the persistent object
			trustpet.UtilizadorDAO.delete(ltrustpetUtilizador);
			trustpet.Dono ltrustpetDono = trustpet.DonoDAO.loadDonoByQuery(null, null);
			// Delete the persistent object
			trustpet.DonoDAO.delete(ltrustpetDono);
			trustpet.Petsitter ltrustpetPetsitter = trustpet.PetsitterDAO.loadPetsitterByQuery(null, null);
			// Delete the persistent object
			trustpet.PetsitterDAO.delete(ltrustpetPetsitter);
			trustpet.Pedido ltrustpetPedido = trustpet.PedidoDAO.loadPedidoByQuery(null, null);
			// Delete the persistent object
			trustpet.PedidoDAO.delete(ltrustpetPedido);
			trustpet.Servico ltrustpetServico = trustpet.ServicoDAO.loadServicoByQuery(null, null);
			// Delete the persistent object
			trustpet.ServicoDAO.delete(ltrustpetServico);
			trustpet.Animal ltrustpetAnimal = trustpet.AnimalDAO.loadAnimalByQuery(null, null);
			// Delete the persistent object
			trustpet.AnimalDAO.delete(ltrustpetAnimal);
			trustpet.Review ltrustpetReview = trustpet.ReviewDAO.loadReviewByQuery(null, null);
			// Delete the persistent object
			trustpet.ReviewDAO.delete(ltrustpetReview);
			trustpet.TipoAnimal ltrustpetTipoAnimal = trustpet.TipoAnimalDAO.loadTipoAnimalByQuery(null, null);
			// Delete the persistent object
			trustpet.TipoAnimalDAO.delete(ltrustpetTipoAnimal);
			trustpet.Horario ltrustpetHorario = trustpet.HorarioDAO.loadHorarioByQuery(null, null);
			// Delete the persistent object
			trustpet.HorarioDAO.delete(ltrustpetHorario);
			trustpet.Hora ltrustpetHora = trustpet.HoraDAO.loadHoraByQuery(null, null);
			// Delete the persistent object
			trustpet.HoraDAO.delete(ltrustpetHora);
			trustpet.Administrador ltrustpetAdministrador = trustpet.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			trustpet.AdministradorDAO.delete(ltrustpetAdministrador);
			trustpet.PrecoPetsitterServico ltrustpetPrecoPetsitterServico = trustpet.PrecoPetsitterServicoDAO.loadPrecoPetsitterServicoByQuery(null, null);
			// Delete the persistent object
			trustpet.PrecoPetsitterServicoDAO.delete(ltrustpetPrecoPetsitterServico);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteClassData deleteClassData = new DeleteClassData();
			try {
				deleteClassData.deleteTestData();
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
