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

public class Preco_Petsitter_Servico {
	public Preco_Petsitter_Servico() {
	}
	
	private int id;
	
	private float preco;
	
	public void setPreco(float value) {
		this.preco = value;
	}
	
	public float getPreco() {
		return preco;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
