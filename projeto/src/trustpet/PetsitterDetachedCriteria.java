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
	public final IntegerExpression id;
	public final IntegerExpression horarioId;
	public final AssociationExpression horario;
	public final StringExpression photo;
	public final BooleanExpression ativo;
	public final StringExpression nome;
	public final StringExpression email;
	public final StringExpression data_nascimento;
	public final StringExpression contacto;
	public final StringExpression residencia;
	public final BooleanExpression jardim;
	public final StringExpression morada;
	public final StringExpression password;
	public final StringExpression descricao;
	public final CollectionExpression servicos;
	public final CollectionExpression animais;
	
	public PetsitterDetachedCriteria() {
		super(trustpet.Petsitter.class, trustpet.PetsitterCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		horarioId = new IntegerExpression("horario.id", this.getDetachedCriteria());
		horario = new AssociationExpression("horario", this.getDetachedCriteria());
		photo = new StringExpression("photo", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		data_nascimento = new StringExpression("data_nascimento", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		residencia = new StringExpression("residencia", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		servicos = new CollectionExpression("ORM_Servicos", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
	}
	
	public PetsitterDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.PetsitterCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		horarioId = new IntegerExpression("horario.id", this.getDetachedCriteria());
		horario = new AssociationExpression("horario", this.getDetachedCriteria());
		photo = new StringExpression("photo", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		data_nascimento = new StringExpression("data_nascimento", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		residencia = new StringExpression("residencia", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		descricao = new StringExpression("descricao", this.getDetachedCriteria());
		servicos = new CollectionExpression("ORM_Servicos", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
	}
	
	public HorarioDetachedCriteria createHorarioCriteria() {
		return new HorarioDetachedCriteria(createCriteria("horario"));
	}
	
	public ServicoDetachedCriteria createServicosCriteria() {
		return new ServicoDetachedCriteria(createCriteria("ORM_Servicos"));
	}
	
	public Tipo_AnimalDetachedCriteria createAnimaisCriteria() {
		return new Tipo_AnimalDetachedCriteria(createCriteria("ORM_Animais"));
	}
	
	public Petsitter uniquePetsitter(PersistentSession session) {
		return (Petsitter) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Petsitter[] listPetsitter(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Petsitter[]) list.toArray(new Petsitter[list.size()]);
	}
}

