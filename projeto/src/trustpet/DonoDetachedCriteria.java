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

public class DonoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final BooleanExpression ativo;
	public final StringExpression nome;
	public final StringExpression photo;
	public final StringExpression email;
	public final StringExpression contacto;
	public final StringExpression residencia;
	public final BooleanExpression jardim;
	public final StringExpression morada;
	public final StringExpression password;
	public final CollectionExpression animais;
	
	public DonoDetachedCriteria() {
		super(trustpet.Dono.class, trustpet.DonoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		photo = new StringExpression("photo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		residencia = new StringExpression("residencia", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
	}
	
	public DonoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, trustpet.DonoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		photo = new StringExpression("photo", this.getDetachedCriteria());
		email = new StringExpression("email", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		residencia = new StringExpression("residencia", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
	}
	
	public AnimalDetachedCriteria createAnimaisCriteria() {
		return new AnimalDetachedCriteria(createCriteria("ORM_Animais"));
	}
	
	public Dono uniqueDono(PersistentSession session) {
		return (Dono) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Dono[] listDono(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Dono[]) list.toArray(new Dono[list.size()]);
	}
}

