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

public class Preco_Petsitter_ServicoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final FloatExpression preco;
	
	public Preco_Petsitter_ServicoDetachedCriteria() {
		super(trustpet.Preco_Petsitter_Servico.class, trustpet.Preco_Petsitter_ServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
	}
	
	public Preco_Petsitter_ServicoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.Preco_Petsitter_ServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
	}
	
	public Preco_Petsitter_Servico uniquePreco_Petsitter_Servico(PersistentSession session) {
		return (Preco_Petsitter_Servico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Preco_Petsitter_Servico[] listPreco_Petsitter_Servico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Preco_Petsitter_Servico[]) list.toArray(new Preco_Petsitter_Servico[list.size()]);
	}
}

