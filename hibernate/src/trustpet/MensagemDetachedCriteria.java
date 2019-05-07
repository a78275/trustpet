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

public class MensagemDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression donoId;
	public final AssociationExpression dono;
	public final IntegerExpression petsitterId;
	public final AssociationExpression petsitter;
	public final StringExpression conteudo;
	public final StringExpression origem;
	public final StringExpression timestamp;
	
	public MensagemDetachedCriteria() {
		super(trustpet.Mensagem.class, trustpet.MensagemCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		donoId = new IntegerExpression("dono.id", this.getDetachedCriteria());
		dono = new AssociationExpression("dono", this.getDetachedCriteria());
		petsitterId = new IntegerExpression("petsitter.id", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		conteudo = new StringExpression("conteudo", this.getDetachedCriteria());
		origem = new StringExpression("origem", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
	}
	
	public MensagemDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.MensagemCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		donoId = new IntegerExpression("dono.id", this.getDetachedCriteria());
		dono = new AssociationExpression("dono", this.getDetachedCriteria());
		petsitterId = new IntegerExpression("petsitter.id", this.getDetachedCriteria());
		petsitter = new AssociationExpression("petsitter", this.getDetachedCriteria());
		conteudo = new StringExpression("conteudo", this.getDetachedCriteria());
		origem = new StringExpression("origem", this.getDetachedCriteria());
		timestamp = new StringExpression("timestamp", this.getDetachedCriteria());
	}
	
	public DonoDetachedCriteria createDonoCriteria() {
		return new DonoDetachedCriteria(createCriteria("dono"));
	}
	
	public PetsitterDetachedCriteria createPetsitterCriteria() {
		return new PetsitterDetachedCriteria(createCriteria("petsitter"));
	}
	
	public Mensagem uniqueMensagem(PersistentSession session) {
		return (Mensagem) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Mensagem[] listMensagem(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Mensagem[]) list.toArray(new Mensagem[list.size()]);
	}
}

