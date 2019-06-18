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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class HorarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final CollectionExpression horas;
	
	public HorarioDetachedCriteria() {
		super(trustpet.Horario.class, trustpet.HorarioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		horas = new CollectionExpression("ORM_Horas", this.getDetachedCriteria());
	}
	
	public HorarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.HorarioCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		horas = new CollectionExpression("ORM_Horas", this.getDetachedCriteria());
	}
	
	public HoraDetachedCriteria createHorasCriteria() {
		return new HoraDetachedCriteria(createCriteria("ORM_Horas"));
	}
	
	public Horario uniqueHorario(PersistentSession session) {
		return (Horario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Horario[] listHorario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Horario[]) list.toArray(new Horario[list.size()]);
	}
}

