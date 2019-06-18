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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class UtilizadorCriteria extends AbstractORMCriteria {
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
	
	public UtilizadorCriteria(Criteria criteria) {
		super(criteria);
		email = new StringExpression("email", this);
		password = new StringExpression("password", this);
		nome = new StringExpression("nome", this);
		avatar = new StringExpression("avatar", this);
		dataNasc = new StringExpression("dataNasc", this);
		contacto = new StringExpression("contacto", this);
		jardim = new BooleanExpression("jardim", this);
		morada = new StringExpression("morada", this);
		ativo = new BooleanExpression("ativo", this);
		concelho = new StringExpression("concelho", this);
		distrito = new StringExpression("distrito", this);
		avaliacaoMedia = new FloatExpression("avaliacaoMedia", this);
		nrAvaliacoes = new IntegerExpression("nrAvaliacoes", this);
	}
	
	public UtilizadorCriteria(PersistentSession session) {
		this(session.createCriteria(Utilizador.class));
	}
	
	public UtilizadorCriteria() throws PersistentException {
		this(TrustPetPersistentManager.instance().getSession());
	}
	
	public Utilizador uniqueUtilizador() {
		return (Utilizador) super.uniqueResult();
	}
	
	public Utilizador[] listUtilizador() {
		java.util.List list = super.list();
		return (Utilizador[]) list.toArray(new Utilizador[list.size()]);
	}
}

