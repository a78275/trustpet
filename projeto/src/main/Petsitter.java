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

public class Petsitter extends main.Utilizador {
	public Petsitter() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PETSITTER_ANIMAIS) {
			return ORM_animais;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private main.Horario horario;
	
	private java.util.Set ORM_animais = new java.util.HashSet();
	
	private void setORM_Animais(java.util.Set value) {
		this.ORM_animais = value;
	}
	
	private java.util.Set getORM_Animais() {
		return ORM_animais;
	}
	
	public final main.TipoAnimalSetCollection animais = new main.TipoAnimalSetCollection(this, _ormAdapter, ORMConstants.KEY_PETSITTER_ANIMAIS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setHorario(main.Horario value) {
		this.horario = value;
	}
	
	public main.Horario getHorario() {
		return horario;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
