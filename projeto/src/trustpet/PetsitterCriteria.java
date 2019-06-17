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
	
	public PetsitterCriteria(Criteria criteria) {
		super(criteria);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		nome = new StringExpression("nome", this);
		avatar = new StringExpression("avatar", this);
		data_nasc = new StringExpression("data_nasc", this);
		contacto = new StringExpression("contacto", this);
		jardim = new BooleanExpression("jardim", this);
		morada = new StringExpression("morada", this);
		ativo = new BooleanExpression("ativo", this);
		concelho = new StringExpression("concelho", this);
		distrito = new StringExpression("distrito", this);
		horarioId = new IntegerExpression("horario.id", this);
		horario = new AssociationExpression("horario", this);
		animais = new CollectionExpression("ORM_Animais", this);
		preco_servico = new CollectionExpression("ORM_Preco_servico", this);
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
	
	public Tipo_AnimalCriteria createAnimaisCriteria() {
		return new Tipo_AnimalCriteria(createCriteria("ORM_Animais"));
	}
	
	public Preco_Petsitter_ServicoCriteria createPreco_servicoCriteria() {
		return new Preco_Petsitter_ServicoCriteria(createCriteria("ORM_Preco_servico"));
	}
	
	public Petsitter uniquePetsitter() {
		return (Petsitter) super.uniqueResult();
	}
	
	public Petsitter[] listPetsitter() {
		java.util.List list = super.list();
		return (Petsitter[]) list.toArray(new Petsitter[list.size()]);
	}
}

