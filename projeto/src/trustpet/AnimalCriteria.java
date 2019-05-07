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

public class AnimalCriteria extends AbstractORMCriteria {
	public final IntegerExpression id;
	public final IntegerExpression tipoId;
	public final AssociationExpression tipo;
	public final StringExpression nome;
	public final StringExpression photo;
	public final IntegerExpression idade;
	public final StringExpression porte;
	public final StringExpression sexo;
	public final StringExpression alergias;
	public final StringExpression doenças;
	public final StringExpression comportamento;
	public final BooleanExpression vacinas;
	public final BooleanExpression desparasitacao;
	public final BooleanExpression esterilizacao;
	public final StringExpression raca;
	public final StringExpression descricao;
	
	public AnimalCriteria(Criteria criteria) {
		super(criteria);
		id = new IntegerExpression("id", this);
		tipoId = new IntegerExpression("tipo.id", this);
		tipo = new AssociationExpression("tipo", this);
		nome = new StringExpression("nome", this);
		photo = new StringExpression("photo", this);
		idade = new IntegerExpression("idade", this);
		porte = new StringExpression("porte", this);
		sexo = new StringExpression("sexo", this);
		alergias = new StringExpression("alergias", this);
		doenças = new StringExpression("doenças", this);
		comportamento = new StringExpression("comportamento", this);
		vacinas = new BooleanExpression("vacinas", this);
		desparasitacao = new BooleanExpression("desparasitacao", this);
		esterilizacao = new BooleanExpression("esterilizacao", this);
		raca = new StringExpression("raca", this);
		descricao = new StringExpression("descricao", this);
	}
	
	public AnimalCriteria(PersistentSession session) {
		this(session.createCriteria(Animal.class));
	}
	
	public AnimalCriteria() throws PersistentException {
		this(ClassPersistentManager.instance().getSession());
	}
	
	public Tipo_AnimalCriteria createTipoCriteria() {
		return new Tipo_AnimalCriteria(createCriteria("tipo"));
	}
	
	public Animal uniqueAnimal() {
		return (Animal) super.uniqueResult();
	}
	
	public Animal[] listAnimal() {
		java.util.List list = super.list();
		return (Animal[]) list.toArray(new Animal[list.size()]);
	}
}

