/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bernardo(Universidade do Minho)
 * License Type: Academic
 */
package main;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DonoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final StringExpression email;
	public final StringExpression password;
	public final StringExpression nome;
	public final StringExpression avatar;
	public final StringExpression dataNasc;
	public final StringExpression contacto;
	public final BooleanExpression jardim;
	public final StringExpression morada;
	public final BooleanExpression ativo;
	public final StringExpression concelho;
	public final StringExpression distrito;
	public final FloatExpression avaliacaoMedia;
	public final IntegerExpression nrAvaliacoes;
	public final StringExpression token;
	public final CollectionExpression animais;
	
	public DonoDetachedCriteria() {
		super(main.Dono.class, main.DonoCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		dataNasc = new StringExpression("dataNasc", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		concelho = new StringExpression("concelho", this.getDetachedCriteria());
		distrito = new StringExpression("distrito", this.getDetachedCriteria());
		avaliacaoMedia = new FloatExpression("avaliacaoMedia", this.getDetachedCriteria());
		nrAvaliacoes = new IntegerExpression("nrAvaliacoes", this.getDetachedCriteria());
		token = new StringExpression("token", this.getDetachedCriteria());
		animais = new CollectionExpression("ORM_Animais", this.getDetachedCriteria());
	}
	
	public DonoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.DonoCriteria.class);
		email = new StringExpression("email", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		avatar = new StringExpression("avatar", this.getDetachedCriteria());
		dataNasc = new StringExpression("dataNasc", this.getDetachedCriteria());
		contacto = new StringExpression("contacto", this.getDetachedCriteria());
		jardim = new BooleanExpression("jardim", this.getDetachedCriteria());
		morada = new StringExpression("morada", this.getDetachedCriteria());
		ativo = new BooleanExpression("ativo", this.getDetachedCriteria());
		concelho = new StringExpression("concelho", this.getDetachedCriteria());
		distrito = new StringExpression("distrito", this.getDetachedCriteria());
		avaliacaoMedia = new FloatExpression("avaliacaoMedia", this.getDetachedCriteria());
		nrAvaliacoes = new IntegerExpression("nrAvaliacoes", this.getDetachedCriteria());
		token = new StringExpression("token", this.getDetachedCriteria());
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

