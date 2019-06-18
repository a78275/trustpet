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

public class ServicoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final StringExpression designacao;
	
	public ServicoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		designacao = new StringExpression("designacao", this);
	}
	
	public ServicoCriteria(PersistentSession session) {
		this(session.createCriteria(Servico.class));
	}
	
	public ServicoCriteria() throws PersistentException {
		this(TrustPetPersistentManager.instance().getSession());
	}
	
	public Servico uniqueServico() {
		return (Servico) super.uniqueResult();
	}
	
	public Servico[] listServico() {
		java.util.List list = super.list();
		return (Servico[]) list.toArray(new Servico[list.size()]);
	}
}

