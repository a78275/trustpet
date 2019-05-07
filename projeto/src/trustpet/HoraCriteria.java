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

public class HoraCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression hora;
	public final BooleanExpression disponivel;
	
	public HoraCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		hora = new IntegerExpression("hora", this);
		disponivel = new BooleanExpression("disponivel", this);
	}
	
	public HoraCriteria(PersistentSession session) {
		this(session.createCriteria(Hora.class));
	}
	
	public HoraCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public Hora uniqueHora() {
		return (Hora) super.uniqueResult();
	}
	
	public Hora[] listHora() {
		java.util.List list = super.list();
		return (Hora[]) list.toArray(new Hora[list.size()]);
	}
}

