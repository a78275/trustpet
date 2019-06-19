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
package main;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DiaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression dia;
	public final CollectionExpression horas;
	
	public DiaDetachedCriteria() {
		super(main.Dia.class, main.DiaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		dia = new IntegerExpression("dia", this.getDetachedCriteria());
		horas = new CollectionExpression("ORM_Horas", this.getDetachedCriteria());
	}
	
	public DiaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.DiaCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		dia = new IntegerExpression("dia", this.getDetachedCriteria());
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

