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

public class PrecoPetsitterServico {
	public PrecoPetsitterServico() {
	}
	
	private int id;
	
	private main.Servico servico;
	
	private main.Petsitter petsitter;
	
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
	
	public void setPetsitter(main.Petsitter value) {
		this.petsitter = value;
	}
	
	public main.Petsitter getPetsitter() {
		return petsitter;
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
