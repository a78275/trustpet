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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.CollectionExpression;
import org.orm.criteria.IntegerExpression;
import org.orm.criteria.StringExpression;

import java.util.List;

public class ServicoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression designacao;
	public final CollectionExpression tipoAnimais;
	
	public ServicoDetachedCriteria() {
		super(main.Servico.class, main.ServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		designacao = new StringExpression("designacao", this.getDetachedCriteria());
		tipoAnimais = new CollectionExpression("ORM_TipoAnimais", this.getDetachedCriteria());
	}
	
	public ServicoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.ServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		designacao = new StringExpression("designacao", this.getDetachedCriteria());
		tipoAnimais = new CollectionExpression("ORM_TipoAnimais", this.getDetachedCriteria());
	}
	
	public TipoAnimalDetachedCriteria createTipoAnimaisCriteria() {
		return new TipoAnimalDetachedCriteria(createCriteria("ORM_TipoAnimais"));
	}
	
	public Servico uniqueServico(PersistentSession session) {
		return (Servico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Servico[] listServico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Servico[]) list.toArray(new Servico[list.size()]);
	}
}

