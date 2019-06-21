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

public class TipoAnimalCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression tipo;
	
	public TipoAnimalCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipo = new StringExpression("tipo", this);
	}
	
	public TipoAnimalCriteria(PersistentSession session) {
		this(session.createCriteria(TipoAnimal.class));
	}
	
	public TipoAnimalCriteria() throws PersistentException {
		this(TrustpetPersistentManager.instance().getSession());
	}
	
	public TipoAnimal uniqueTipoAnimal() {
		return (TipoAnimal) super.uniqueResult();
	}
	
	public TipoAnimal[] listTipoAnimal() {
		java.util.List list = super.list();
		return (TipoAnimal[]) list.toArray(new TipoAnimal[list.size()]);
	}
}

