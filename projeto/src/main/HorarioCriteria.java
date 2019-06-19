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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class HorarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final CollectionExpression dias;
	
	public HorarioCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		dias = new CollectionExpression("ORM_Dias", this);
	}
	
	public HorarioCriteria(PersistentSession session) {
		this(session.createCriteria(Horario.class));
	}
	
	public HorarioCriteria() throws PersistentException {
		this(TrustPetPersistentManager.instance().getSession());
	}
	
	public DiaCriteria createDiasCriteria() {
		return new DiaCriteria(createCriteria("ORM_Dias"));
	}
	
	public Horario uniqueHorario() {
		return (Horario) super.uniqueResult();
	}
	
	public Horario[] listHorario() {
		java.util.List list = super.list();
		return (Horario[]) list.toArray(new Horario[list.size()]);
	}
}

