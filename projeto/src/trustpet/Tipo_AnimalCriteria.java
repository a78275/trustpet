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

public class Tipo_AnimalCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression tipo;
	
	public Tipo_AnimalCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipo = new StringExpression("tipo", this);
	}
	
	public Tipo_AnimalCriteria(PersistentSession session) {
		this(session.createCriteria(Tipo_Animal.class));
	}
	
	public Tipo_AnimalCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public Tipo_Animal uniqueTipo_Animal() {
		return (Tipo_Animal) super.uniqueResult();
	}
	
	public Tipo_Animal[] listTipo_Animal() {
		java.util.List list = super.list();
		return (Tipo_Animal[]) list.toArray(new Tipo_Animal[list.size()]);
	}
}

