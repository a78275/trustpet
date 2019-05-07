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

public class ReviewCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression petsitterId;
	public final AssociationExpression petsitter;
	public final IntegerExpression donoId;
	public final AssociationExpression dono;
	public final IntegerExpression pontuacao;
	public final StringExpression comentario;
	public final StringExpression alvo;
	
	public ReviewCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		petsitterId = new IntegerExpression("petsitter.id", this);
		petsitter = new AssociationExpression("petsitter", this);
		donoId = new IntegerExpression("dono.id", this);
		dono = new AssociationExpression("dono", this);
		pontuacao = new IntegerExpression("pontuacao", this);
		comentario = new StringExpression("comentario", this);
		alvo = new StringExpression("alvo", this);
	}
	
	public ReviewCriteria(PersistentSession session) {
		this(session.createCriteria(Review.class));
	}
	
	public ReviewCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public PetsitterCriteria createPetsitterCriteria() {
		return new PetsitterCriteria(createCriteria("petsitter"));
	}
	
	public DonoCriteria createDonoCriteria() {
		return new DonoCriteria(createCriteria("dono"));
	}
	
	public Review uniqueReview() {
		return (Review) super.uniqueResult();
	}
	
	public Review[] listReview() {
		java.util.List list = super.list();
		return (Review[]) list.toArray(new Review[list.size()]);
	}
}

