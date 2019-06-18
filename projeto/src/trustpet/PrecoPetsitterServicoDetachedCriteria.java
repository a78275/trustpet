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

public class PrecoPetsitterServicoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression servicoId;
	public final AssociationExpression servico;
	public final StringExpression petsitterId;
	public final AssociationExpression petsitter;
	public final FloatExpression preco;
	
	public PrecoPetsitterServicoDetachedCriteria() {
		super(trustpet.PrecoPetsitterServico.class, trustpet.PrecoPetsitterServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		servicoId = new IntegerExpression("servico.id", this.getDetachedCriteria());
		servico = new AssociationExpression("servico", this.getDetachedCriteria());
		petsitterId = new StringExpression("petsitter.", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
	}
	
	public PrecoPetsitterServicoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.PrecoPetsitterServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		servicoId = new IntegerExpression("servico.id", this.getDetachedCriteria());
		servico = new AssociationExpression("servico", this.getDetachedCriteria());
		petsitterId = new StringExpression("petsitter.", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
	}
	
	public ServicoDetachedCriteria createServicoCriteria() {
		return new ServicoDetachedCriteria(createCriteria("servico"));
	}
	
	public PetsitterDetachedCriteria createPetsitterCriteria() {
		return new PetsitterDetachedCriteria(createCriteria("petsitter"));
	}
	
	public PrecoPetsitterServico uniquePrecoPetsitterServico(PersistentSession session) {
		return (PrecoPetsitterServico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public PrecoPetsitterServico[] listPrecoPetsitterServico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (PrecoPetsitterServico[]) list.toArray(new PrecoPetsitterServico[list.size()]);
	}
}

