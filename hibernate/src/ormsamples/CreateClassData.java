/**
 * Licensee: Joana(Universidade do Minho)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateClassData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = trustpet.ClassPersistentManager.instance().getSession().beginTransaction();
		try {
			trustpet.Dono ltrustpetDono = trustpet.DonoDAO.createDono();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : animais, ativo
			trustpet.DonoDAO.save(ltrustpetDono);
			trustpet.Petsitter ltrustpetPetsitter = trustpet.PetsitterDAO.createPetsitter();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : animais, servicos, jardim, ativo, horario
			trustpet.PetsitterDAO.save(ltrustpetPetsitter);
			trustpet.Pedido ltrustpetPedido = trustpet.PedidoDAO.createPedido();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : servicos, preco, dono, petsitter
			trustpet.PedidoDAO.save(ltrustpetPedido);
			trustpet.Servico ltrustpetServico = trustpet.ServicoDAO.createServico();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : preço
			trustpet.ServicoDAO.save(ltrustpetServico);
			trustpet.Animal ltrustpetAnimal = trustpet.AnimalDAO.createAnimal();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : esterilizacao, desparasitacao, vacinas, idade, tipo
			trustpet.AnimalDAO.save(ltrustpetAnimal);
			trustpet.Review ltrustpetReview = trustpet.ReviewDAO.createReview();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : pontuacao, dono, petsitter
			trustpet.ReviewDAO.save(ltrustpetReview);
			trustpet.Tipo_Animal ltrustpetTipo_Animal = trustpet.Tipo_AnimalDAO.createTipo_Animal();
			// Initialize the properties of the persistent object here
			trustpet.Tipo_AnimalDAO.save(ltrustpetTipo_Animal);
			trustpet.Mensagem ltrustpetMensagem = trustpet.MensagemDAO.createMensagem();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : petsitter, dono
			trustpet.MensagemDAO.save(ltrustpetMensagem);
			trustpet.Horario ltrustpetHorario = trustpet.HorarioDAO.createHorario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : dias
			trustpet.HorarioDAO.save(ltrustpetHorario);
			trustpet.Dia ltrustpetDia = trustpet.DiaDAO.createDia();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : horas
			trustpet.DiaDAO.save(ltrustpetDia);
			trustpet.Hora ltrustpetHora = trustpet.HoraDAO.createHora();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : disponivel, hora
			trustpet.HoraDAO.save(ltrustpetHora);
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
