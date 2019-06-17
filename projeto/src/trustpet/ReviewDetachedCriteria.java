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

public class ReviewDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final StringExpression petsitterId;
	public final AssociationExpression petsitter;
	public final StringExpression donoId;
	public final AssociationExpression dono;
	public final IntegerExpression pontuacao;
	public final StringExpression comentario;
	public final StringExpression alvo;
	public final StringExpression data;
	
	public ReviewDetachedCriteria() {
		super(trustpet.Review.class, trustpet.ReviewCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		petsitterId = new StringExpression("petsitter.email", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		donoId = new StringExpression("dono.email", this.getDetachedCriteria());
		dono = new AssociationExpression("dono", this.getDetachedCriteria());
		pontuacao = new IntegerExpression("pontuacao", this.getDetachedCriteria());
		comentario = new StringExpression("comentario", this.getDetachedCriteria());
		alvo = new StringExpression("alvo", this.getDetachedCriteria());
		data = new StringExpression("data", this.getDetachedCriteria());
	}
	
	public ReviewDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.ReviewCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		petsitterId = new StringExpression("petsitter.email", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		donoId = new StringExpression("dono.email", this.getDetachedCriteria());
		dono = new AssociationExpression("dono", this.getDetachedCriteria());
		pontuacao = new IntegerExpression("pontuacao", this.getDetachedCriteria());
		comentario = new StringExpression("comentario", this.getDetachedCriteria());
		alvo = new StringExpression("alvo", this.getDetachedCriteria());
		data = new StringExpression("data", this.getDetachedCriteria());
	}
	
	public PetsitterDetachedCriteria createPetsitterCriteria() {
		return new PetsitterDetachedCriteria(createCriteria("petsitter"));
	}
	
	public DonoDetachedCriteria createDonoCriteria() {
		return new DonoDetachedCriteria(createCriteria("dono"));
	}
	
	public Review uniqueReview(PersistentSession session) {
		return (Review) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Review[] listReview(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Review[]) list.toArray(new Review[list.size()]);
	}
}

