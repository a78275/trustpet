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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class PrecoPetsitterServicoCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression servicoId;
	public final AssociationExpression servico;
	public final StringExpression petsitterId;
	public final AssociationExpression petsitter;
	public final FloatExpression preco;
	
	public PrecoPetsitterServicoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		servicoId = new IntegerExpression("servico.id", this);
		servico = new AssociationExpression("servico", this);
		petsitterId = new StringExpression("petsitter.", this);
		petsitter = new AssociationExpression("petsitter", this);
		preco = new FloatExpression("preco", this);
	}
	
	public PrecoPetsitterServicoCriteria(PersistentSession session) {
		this(session.createCriteria(PrecoPetsitterServico.class));
	}
	
	public PrecoPetsitterServicoCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public ServicoCriteria createServicoCriteria() {
		return new ServicoCriteria(createCriteria("servico"));
	}
	
	public PetsitterCriteria createPetsitterCriteria() {
		return new PetsitterCriteria(createCriteria("petsitter"));
	}
	
	public PrecoPetsitterServico uniquePrecoPetsitterServico() {
		return (PrecoPetsitterServico) super.uniqueResult();
	}
	
	public PrecoPetsitterServico[] listPrecoPetsitterServico() {
		java.util.List list = super.list();
		return (PrecoPetsitterServico[]) list.toArray(new PrecoPetsitterServico[list.size()]);
	}
}

