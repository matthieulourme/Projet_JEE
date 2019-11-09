package domain;

public class Contact {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	public int getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(int i) {
		id=i;
	}
	
	public void setNom(String string) {
		nom=string;	
	}
	
	public void setPrenom(String string) {
		prenom=string;	
	}
	
	public void setEmail(String string) {
		email=string;	
	}
	

}
