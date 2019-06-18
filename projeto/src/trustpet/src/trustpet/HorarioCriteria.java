/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package trustpet;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class HorarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final CollectionExpression horas;
	
	public HorarioCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		horas = new CollectionExpression("ORM_Horas", this);
	}
	
	public HorarioCriteria(PersistentSession session) {
		this(session.createCriteria(Horario.class));
	}
	
	public HorarioCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public HoraCriteria createHorasCriteria() {
		return new HoraCriteria(createCriteria("ORM_Horas"));
	}
	
	public Horario uniqueHorario() {
		return (Horario) super.uniqueResult();
	}
	
	public Horario[] listHorario() {
		java.util.List list = super.list();
		return (Horario[]) list.toArray(new Horario[list.size()]);
	}
}

