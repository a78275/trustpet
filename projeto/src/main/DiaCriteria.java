/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bernardo(Universidade do Minho)
 * License Type: Academic
 */
package main;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DiaCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression dia;
	public final CollectionExpression horas;
	
	public DiaCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		dia = new IntegerExpression("dia", this);
		horas = new CollectionExpression("ORM_Horas", this);
	}
	
	public DiaCriteria(PersistentSession session) {
		this(session.createCriteria(Dia.class));
	}
	
	public DiaCriteria() throws PersistentException {
		this(TrustPetPersistentManager.instance().getSession());
	}
	
	public HoraCriteria createHorasCriteria() {
		return new HoraCriteria(createCriteria("ORM_Horas"));
	}
	
	public Dia uniqueDia() {
		return (Dia) super.uniqueResult();
	}
	
	public Dia[] listDia() {
		java.util.List list = super.list();
		return (Dia[]) list.toArray(new Dia[list.size()]);
	}
}

