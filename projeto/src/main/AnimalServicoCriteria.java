/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bernardo(Universidade do Minho)
 * License Type: Academic
 */
package main;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AnimalServicoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression servicoId;
	public final AssociationExpression servico;
	public final IntegerExpression animalId;
	public final AssociationExpression animal;
	
	public AnimalServicoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		servicoId = new IntegerExpression("servico.id", this);
		servico = new AssociationExpression("servico", this);
		animalId = new IntegerExpression("animal.id", this);
		animal = new AssociationExpression("animal", this);
	}
	
	public AnimalServicoCriteria(PersistentSession session) {
		this(session.createCriteria(AnimalServico.class));
	}
	
	public AnimalServicoCriteria() throws PersistentException {
		this(TrustPetPersistentManager.instance().getSession());
	}
	
	public ServicoCriteria createServicoCriteria() {
		return new ServicoCriteria(createCriteria("servico"));
	}
	
	public AnimalCriteria createAnimalCriteria() {
		return new AnimalCriteria(createCriteria("animal"));
	}
	
	public AnimalServico uniqueAnimalServico() {
		return (AnimalServico) super.uniqueResult();
	}
	
	public AnimalServico[] listAnimalServico() {
		java.util.List list = super.list();
		return (AnimalServico[]) list.toArray(new AnimalServico[list.size()]);
	}
}

