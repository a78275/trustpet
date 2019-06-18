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
import org.orm.criteria.StringExpression;

import java.util.List;

public class DiaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression dia;
	public final CollectionExpression horas;
	
	public DiaDetachedCriteria() {
		super(main.Dia.class, main.DiaCriteria.class);
		dia = new StringExpression("dia", this.getDetachedCriteria());
		horas = new CollectionExpression("ORM_Horas", this.getDetachedCriteria());
	}
	
	public DiaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.DiaCriteria.class);
		dia = new StringExpression("dia", this.getDetachedCriteria());
		horas = new CollectionExpression("ORM_Horas", this.getDetachedCriteria());
	}
	
	public HoraDetachedCriteria createHorasCriteria() {
		return new HoraDetachedCriteria(createCriteria("ORM_Horas"));
	}
	
	public Dia uniqueDia(PersistentSession session) {
		return (Dia) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Dia[] listDia(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Dia[]) list.toArray(new Dia[list.size()]);
	}
}

