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

public class ServicoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression designacao;
	public final CollectionExpression preco_servico;
	
	public ServicoDetachedCriteria() {
		super(trustpet.Servico.class, trustpet.ServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		designacao = new StringExpression("designacao", this.getDetachedCriteria());
		preco_servico = new CollectionExpression("ORM_Preco_servico", this.getDetachedCriteria());
	}
	
	public ServicoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.ServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		designacao = new StringExpression("designacao", this.getDetachedCriteria());
		preco_servico = new CollectionExpression("ORM_Preco_servico", this.getDetachedCriteria());
	}
	
	public Preco_Petsitter_ServicoDetachedCriteria createPreco_servicoCriteria() {
		return new Preco_Petsitter_ServicoDetachedCriteria(createCriteria("ORM_Preco_servico"));
	}
	
	public Servico uniqueServico(PersistentSession session) {
		return (Servico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Servico[] listServico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Servico[]) list.toArray(new Servico[list.size()]);
	}
}

