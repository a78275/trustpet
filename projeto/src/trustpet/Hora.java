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

public class Hora {
	public Hora() {
	}
	
	private int id;
	
	private int hora;
	
	private boolean disponivel;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setHora(int value) {
		this.hora = value;
	}
	
	public int getHora() {
		return hora;
	}
	
	public void setDisponivel(boolean value) {
		this.disponivel = value;
	}
	
	public boolean getDisponivel() {
		return disponivel;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
