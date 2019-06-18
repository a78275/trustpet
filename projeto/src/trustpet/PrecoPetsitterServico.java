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

public class PrecoPetsitterServico {
	public PrecoPetsitterServico() {
	}
	
	private int id;
	
	private trustpet.Servico servico;
	
	private trustpet.Petsitter petsitter;
	
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
	
	public void setPetsitter(trustpet.Petsitter value) {
		this.petsitter = value;
	}
	
	public trustpet.Petsitter getPetsitter() {
		return petsitter;
	}
	
	public void setServico(trustpet.Servico value) {
		this.servico = value;
	}
	
	public trustpet.Servico getServico() {
		return servico;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
