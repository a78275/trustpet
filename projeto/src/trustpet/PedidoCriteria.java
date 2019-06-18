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

public class PedidoCriteria extends AbstractORMCriteria {
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
	
	public PedidoCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		petsitterId = new StringExpression("petsitter.", this);
		petsitter = new AssociationExpression("petsitter", this);
		donoId = new StringExpression("dono.", this);
		dono = new AssociationExpression("dono", this);
		data = new StringExpression("data", this);
		preco = new FloatExpression("preco", this);
		ativo = new BooleanExpression("ativo", this);
		animais = new CollectionExpression("ORM_Animais", this);
		servicos = new CollectionExpression("ORM_Servicos", this);
	}
	
	public PedidoCriteria(PersistentSession session) {
		this(session.createCriteria(Pedido.class));
	}
	
	public PedidoCriteria() throws PersistentException {
		this(TrustPetPersistentManager.instance().getSession());
	}
	
	public PetsitterCriteria createPetsitterCriteria() {
		return new PetsitterCriteria(createCriteria("petsitter"));
	}
	
	public DonoCriteria createDonoCriteria() {
		return new DonoCriteria(createCriteria("dono"));
	}
	
	public AnimalCriteria createAnimaisCriteria() {
		return new AnimalCriteria(createCriteria("ORM_Animais"));
	}
	
	public ServicoCriteria createServicosCriteria() {
		return new ServicoCriteria(createCriteria("ORM_Servicos"));
	}
	
	public Pedido uniquePedido() {
		return (Pedido) super.uniqueResult();
	}
	
	public Pedido[] listPedido() {
		java.util.List list = super.list();
		return (Pedido[]) list.toArray(new Pedido[list.size()]);
	}
}

