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

public class Dono extends main.Utilizador {
	public Dono() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DONO_ANIMAIS) {
			return ORM_animais;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private java.util.Set ORM_animais = new java.util.HashSet();
	
	private void setORM_Animais(java.util.Set value) {
		this.ORM_animais = value;
	}
	
	private java.util.Set getORM_Animais() {
		return ORM_animais;
	}
	
	public final main.AnimalSetCollection animais = new main.AnimalSetCollection(this, _ormAdapter, ORMConstants.KEY_DONO_ANIMAIS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
