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

public class AnimalServico {
	public AnimalServico() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ANIMALSERVICO_ANIMAL) {
			this.animal = (main.Animal) owner;
		}
		
		else if (key == ORMConstants.KEY_ANIMALSERVICO_SERVICO) {
			this.servico = (main.Servico) owner;
		}
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	private int id;
	
	private main.Servico servico;
	
	private main.Animal animal;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setAnimal(main.Animal value) {
		this.animal = value;
	}
	
	public main.Animal getAnimal() {
		return animal;
	}
	
	public void setServico(main.Servico value) {
		this.servico = value;
	}
	
	public main.Servico getServico() {
		return servico;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
