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

public class MensagemCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression donoId;
	public final AssociationExpression dono;
	public final IntegerExpression petsitterId;
	public final AssociationExpression petsitter;
	public final StringExpression conteudo;
	public final StringExpression origem;
	public final StringExpression timestamp;
	
	public MensagemCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		donoId = new IntegerExpression("dono.id", this);
		dono = new AssociationExpression("dono", this);
		petsitterId = new IntegerExpression("petsitter.id", this);
		petsitter = new AssociationExpression("petsitter", this);
		conteudo = new StringExpression("conteudo", this);
		origem = new StringExpression("origem", this);
		timestamp = new StringExpression("timestamp", this);
	}
	
	public MensagemCriteria(PersistentSession session) {
		this(session.createCriteria(Mensagem.class));
	}
	
	public MensagemCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public DonoCriteria createDonoCriteria() {
		return new DonoCriteria(createCriteria("dono"));
	}
	
	public PetsitterCriteria createPetsitterCriteria() {
		return new PetsitterCriteria(createCriteria("petsitter"));
	}
	
	public Mensagem uniqueMensagem() {
		return (Mensagem) super.uniqueResult();
	}
	
	public Mensagem[] listMensagem() {
		java.util.List list = super.list();
		return (Mensagem[]) list.toArray(new Mensagem[list.size()]);
	}
}

