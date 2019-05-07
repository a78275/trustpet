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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class Tipo_AnimalDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipo;
	
	public Tipo_AnimalDetachedCriteria() {
		super(trustpet.Tipo_Animal.class, trustpet.Tipo_AnimalCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public Tipo_AnimalDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.Tipo_AnimalCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public Tipo_Animal uniqueTipo_Animal(PersistentSession session) {
		return (Tipo_Animal) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Tipo_Animal[] listTipo_Animal(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Tipo_Animal[]) list.toArray(new Tipo_Animal[list.size()]);
	}
}

