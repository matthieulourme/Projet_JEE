package domain;

public class Contact {
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	
	
	public Contact(int id, String nom, String prenom, String email,String telephone, String adresse) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone=telephone;
		this.adresse=adresse;
	}
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

