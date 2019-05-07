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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PetsitterCriteria extends AbstractORMCriteria {
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
	
	public PetsitterCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		horarioId = new IntegerExpression("horario.id", this);
		horario = new AssociationExpression("horario", this);
		photo = new StringExpression("photo", this);
		ativo = new BooleanExpression("ativo", this);
		nome = new StringExpression("nome", this);
		email = new StringExpression("email", this);
		data_nascimento = new StringExpression("data_nascimento", this);
		contacto = new StringExpression("contacto", this);
		residencia = new StringExpression("residencia", this);
		jardim = new BooleanExpression("jardim", this);
		morada = new StringExpression("morada", this);
		password = new StringExpression("password", this);
		descricao = new StringExpression("descricao", this);
		servicos = new CollectionExpression("ORM_Servicos", this);
		animais = new CollectionExpression("ORM_Animais", this);
	}
	
	public PetsitterCriteria(PersistentSession session) {
		this(session.createCriteria(Petsitter.class));
	}
	
	public PetsitterCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public HorarioCriteria createHorarioCriteria() {
		return new HorarioCriteria(createCriteria("horario"));
	}
	
	public ServicoCriteria createServicosCriteria() {
		return new ServicoCriteria(createCriteria("ORM_Servicos"));
	}
	
	public Tipo_AnimalCriteria createAnimaisCriteria() {
		return new Tipo_AnimalCriteria(createCriteria("ORM_Animais"));
	}
	
	public Petsitter uniquePetsitter() {
		return (Petsitter) super.uniqueResult();
	}
	
	public Petsitter[] listPetsitter() {
		java.util.List list = super.list();
		return (Petsitter[]) list.toArray(new Petsitter[list.size()]);
	}
}

