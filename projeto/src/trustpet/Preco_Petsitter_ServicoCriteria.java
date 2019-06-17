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

public class Preco_Petsitter_ServicoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final FloatExpression preco;
	
	public Preco_Petsitter_ServicoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		preco = new FloatExpression("preco", this);
	}
	
	public Preco_Petsitter_ServicoCriteria(PersistentSession session) {
		this(session.createCriteria(Preco_Petsitter_Servico.class));
	}
	
	public Preco_Petsitter_ServicoCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public Preco_Petsitter_Servico uniquePreco_Petsitter_Servico() {
		return (Preco_Petsitter_Servico) super.uniqueResult();
	}
	
	public Preco_Petsitter_Servico[] listPreco_Petsitter_Servico() {
		java.util.List list = super.list();
		return (Preco_Petsitter_Servico[]) list.toArray(new Preco_Petsitter_Servico[list.size()]);
	}
}

