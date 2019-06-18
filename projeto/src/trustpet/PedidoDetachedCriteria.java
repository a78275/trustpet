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

public class PedidoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression petsitterId;
	public final AssociationExpression petsitter;
	public final StringExpression donoId;
	public final AssociationExpression dono;
	public final StringExpression data;
	public final FloatExpression preco;
	public final BooleanExpression ativo;
	public final CollectionExpression animais;
	public final CollectionExpression servicos;
	
	public PedidoDetachedCriteria() {
		super(trustpet.Pedido.class, trustpet.PedidoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		petsitterId = new StringExpression("petsitter.", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		donoId = new StringExpression("dono.", this.getDetachedCriteria());
		dono = new AssociationExpression("dono", this.getDetachedCriteria());
		data = new StringExpression("data", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
		servicos = new CollectionExpression("ORM_Servicos", this.getDetachedCriteria());
	}
	
	public PedidoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.PedidoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		petsitterId = new StringExpression("petsitter.", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		donoId = new StringExpression("dono.", this.getDetachedCriteria());
		dono = new AssociationExpression("dono", this.getDetachedCriteria());
		data = new StringExpression("data", this.getDetachedCriteria());
		preco = new FloatExpression("preco", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
		servicos = new CollectionExpression("ORM_Servicos", this.getDetachedCriteria());
	}
	
	public PetsitterDetachedCriteria createPetsitterCriteria() {
		return new PetsitterDetachedCriteria(createCriteria("petsitter"));
	}
	
	public DonoDetachedCriteria createDonoCriteria() {
		return new DonoDetachedCriteria(createCriteria("dono"));
	}
	
	public AnimalDetachedCriteria createAnimaisCriteria() {
		return new AnimalDetachedCriteria(createCriteria("ORM_Animais"));
	}
	
	public ServicoDetachedCriteria createServicosCriteria() {
		return new ServicoDetachedCriteria(createCriteria("ORM_Servicos"));
	}
	
	public Pedido uniquePedido(PersistentSession session) {
		return (Pedido) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Pedido[] listPedido(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Pedido[]) list.toArray(new Pedido[list.size()]);
	}
}

