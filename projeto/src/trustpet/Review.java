/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package trustpet;

public class Review {
	public Review() {
	}
	
	private int id;
	
	private trustpet.Petsitter petsitter;
	
	private trustpet.Dono dono;
	
	private int pontuacao;
	
	private String comentario;
	
	private String alvo;
	
	private String data;
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPontuacao(int value) {
		this.pontuacao = value;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setComentario(String value) {
		this.comentario = value;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setAlvo(String value) {
		this.alvo = value;
	}
	
	public String getAlvo() {
		return alvo;
	}
	
	public void setData(String value) {
		this.data = value;
	}
	
	public String getData() {
		return data;
	}
	
	public void setDono(trustpet.Dono value) {
		this.dono = value;
	}
	
	public trustpet.Dono getDono() {
		return dono;
	}
	
	public void setPetsitter(trustpet.Petsitter value) {
		this.petsitter = value;
	}
	
	public trustpet.Petsitter getPetsitter() {
		return petsitter;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
