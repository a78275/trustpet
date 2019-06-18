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

import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.AbstractORMDetachedCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.IntegerExpression;

import java.util.List;

public class AnimalServicoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression id;
	public final IntegerExpression servicoId;
	public final AssociationExpression servico;
	public final IntegerExpression animalId;
	public final AssociationExpression animal;
	
	public AnimalServicoDetachedCriteria() {
		super(main.AnimalServico.class, main.AnimalServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		servicoId = new IntegerExpression("servico.id", this.getDetachedCriteria());
		servico = new AssociationExpression("servico", this.getDetachedCriteria());
		animalId = new IntegerExpression("animal.id", this.getDetachedCriteria());
		animal = new AssociationExpression("animal", this.getDetachedCriteria());
	}
	
	public AnimalServicoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, main.AnimalServicoCriteria.class);
		id = new IntegerExpression("id", this.getDetachedCriteria());
		servicoId = new IntegerExpression("servico.id", this.getDetachedCriteria());
		servico = new AssociationExpression("servico", this.getDetachedCriteria());
		animalId = new IntegerExpression("animal.id", this.getDetachedCriteria());
		animal = new AssociationExpression("animal", this.getDetachedCriteria());
	}
	
	public ServicoDetachedCriteria createServicoCriteria() {
		return new ServicoDetachedCriteria(createCriteria("servico"));
	}
	
	public AnimalDetachedCriteria createAnimalCriteria() {
		return new AnimalDetachedCriteria(createCriteria("animal"));
	}
	
	public AnimalServico uniqueAnimalServico(PersistentSession session) {
		return (AnimalServico) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public AnimalServico[] listAnimalServico(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (AnimalServico[]) list.toArray(new AnimalServico[list.size()]);
	}
}

