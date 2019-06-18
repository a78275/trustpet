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

public class TipoAnimal {
	public TipoAnimal() {
	}
	
	private int id;
	
	private String tipo;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
