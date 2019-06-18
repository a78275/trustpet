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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class TipoAnimalDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression tipo;
	
	public TipoAnimalDetachedCriteria() {
		super(main.TipoAnimal.class, main.TipoAnimalCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public TipoAnimalDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.TipoAnimalCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
	}
	
	public TipoAnimal uniqueTipoAnimal(PersistentSession session) {
		return (TipoAnimal) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public TipoAnimal[] listTipoAnimal(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (TipoAnimal[]) list.toArray(new TipoAnimal[list.size()]);
	}
}

