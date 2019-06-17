/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Joana(Universidade do Minho)
 * License Type: Academic
 */
package trustpet;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PetsitterDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final StringExpression avatar;
	public final StringExpression data_nasc;
	public final StringExpression contacto;
	public final BooleanExpression jardim;
	public final StringExpression morada;
	public final BooleanExpression ativo;
	public final StringExpression concelho;
	public final StringExpression distrito;
	public final IntegerExpression horarioId;
	public final AssociationExpression horario;
	public final CollectionExpression animais;
	public final CollectionExpression preco_servico;
	
	public PetsitterDetachedCriteria() {
		super(trustpet.Petsitter.class, trustpet.PetsitterCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		data_nasc = new StringExpression("data_nasc", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		concelho = new StringExpression("concelho", this.getDetachedCriteria());
		distrito = new StringExpression("distrito", this.getDetachedCriteria());
		horarioId = new IntegerExpression("horario.id", this.getDetachedCriteria());
		horario = new AssociationExpression("horario", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
		preco_servico = new CollectionExpression("ORM_Preco_servico", this.getDetachedCriteria());
	}
	
	public PetsitterDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.PetsitterCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		data_nasc = new StringExpression("data_nasc", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		concelho = new StringExpression("concelho", this.getDetachedCriteria());
		distrito = new StringExpression("distrito", this.getDetachedCriteria());
		horarioId = new IntegerExpression("horario.id", this.getDetachedCriteria());
		horario = new AssociationExpression("horario", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
		preco_servico = new CollectionExpression("ORM_Preco_servico", this.getDetachedCriteria());
	}
	
	public HorarioDetachedCriteria createHorarioCriteria() {
		return new HorarioDetachedCriteria(createCriteria("horario"));
	}
	
	public Tipo_AnimalDetachedCriteria createAnimaisCriteria() {
		return new Tipo_AnimalDetachedCriteria(createCriteria("ORM_Animais"));
	}
	
	public Preco_Petsitter_ServicoDetachedCriteria createPreco_servicoCriteria() {
		return new Preco_Petsitter_ServicoDetachedCriteria(createCriteria("ORM_Preco_servico"));
	}
	
	public Petsitter uniquePetsitter(PersistentSession session) {
		return (Petsitter) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Petsitter[] listPetsitter(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Petsitter[]) list.toArray(new Petsitter[list.size()]);
	}
}

