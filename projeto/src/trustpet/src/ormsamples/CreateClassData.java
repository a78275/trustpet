/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateClassData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = trustpet.ClassPersistentManager.instance().getSession().beginTransaction();
		try {
			trustpet.Utilizador ltrustpetUtilizador = trustpet.UtilizadorDAO.createUtilizador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : avaliacaoMedia, ativo, jardim, email
			trustpet.UtilizadorDAO.save(ltrustpetUtilizador);
			trustpet.Dono ltrustpetDono = trustpet.DonoDAO.createDono();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : animais
			trustpet.DonoDAO.save(ltrustpetDono);
			trustpet.Petsitter ltrustpetPetsitter = trustpet.PetsitterDAO.createPetsitter();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : animais, horario
			trustpet.PetsitterDAO.save(ltrustpetPetsitter);
			trustpet.Pedido ltrustpetPedido = trustpet.PedidoDAO.createPedido();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : servicos, animais, preco, dono, petsitter
			trustpet.PedidoDAO.save(ltrustpetPedido);
			trustpet.Servico ltrustpetServico = trustpet.ServicoDAO.createServico();
			// Initialize the properties of the persistent object here
			trustpet.ServicoDAO.save(ltrustpetServico);
			trustpet.Animal ltrustpetAnimal = trustpet.AnimalDAO.createAnimal();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : ativo, esterilizacao, desparasitacao, vacinas, idade, tipo
			trustpet.AnimalDAO.save(ltrustpetAnimal);
			trustpet.Review ltrustpetReview = trustpet.ReviewDAO.createReview();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pontuacao, dono, petsitter
			trustpet.ReviewDAO.save(ltrustpetReview);
			trustpet.TipoAnimal ltrustpetTipoAnimal = trustpet.TipoAnimalDAO.createTipoAnimal();
			// Initialize the properties of the persistent object here
			trustpet.TipoAnimalDAO.save(ltrustpetTipoAnimal);
			trustpet.Horario ltrustpetHorario = trustpet.HorarioDAO.createHorario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : horas
			trustpet.HorarioDAO.save(ltrustpetHorario);
			trustpet.Hora ltrustpetHora = trustpet.HoraDAO.createHora();
			// Initialize the properties of the persistent object here
			trustpet.HoraDAO.save(ltrustpetHora);
			trustpet.Administrador ltrustpetAdministrador = trustpet.AdministradorDAO.createAdministrador();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : email
			trustpet.AdministradorDAO.save(ltrustpetAdministrador);
			trustpet.PrecoPetsitterServico ltrustpetPrecoPetsitterServico = trustpet.PrecoPetsitterServicoDAO.createPrecoPetsitterServico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : preco, petsitter, servico
			trustpet.PrecoPetsitterServicoDAO.save(ltrustpetPrecoPetsitterServico);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateClassData createClassData = new CreateClassData();
			try {
				createClassData.createTestData();
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
