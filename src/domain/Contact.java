package domain;

public class Contact {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	
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
	
	public String getTelephone() {
		return telephone;
	}

	public String getAdresse() {
		return adresse;
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
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}

