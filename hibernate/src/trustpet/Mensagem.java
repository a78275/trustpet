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

public class Mensagem {
	public Mensagem() {
	}
	
	private int id;
	
	private trustpet.Dono dono;
	
	private trustpet.Petsitter petsitter;
	
	private String conteudo;
	
	private String origem;
	
	private String timestamp;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setConteudo(String value) {
		this.conteudo = value;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setOrigem(String value) {
		this.origem = value;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setTimestamp(String value) {
		this.timestamp = value;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setPetsitter(trustpet.Petsitter value) {
		this.petsitter = value;
	}
	
	public trustpet.Petsitter getPetsitter() {
		return petsitter;
	}
	
	public void setDono(trustpet.Dono value) {
		this.dono = value;
	}
	
	public trustpet.Dono getDono() {
		return dono;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
