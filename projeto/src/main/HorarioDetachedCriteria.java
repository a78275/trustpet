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
package main;

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class HorarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final CollectionExpression dias;
	
	public HorarioDetachedCriteria() {
		super(main.Horario.class, main.HorarioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		dias = new CollectionExpression("ORM_Dias", this.getDetachedCriteria());
	}
	
	public HorarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.HorarioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		dias = new CollectionExpression("ORM_Dias", this.getDetachedCriteria());
	}
	
	public DiaDetachedCriteria createDiasCriteria() {
		return new DiaDetachedCriteria(createCriteria("ORM_Dias"));
	}
	
	public Horario uniqueHorario(PersistentSession session) {
		return (Horario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Horario[] listHorario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Horario[]) list.toArray(new Horario[list.size()]);
	}
}

