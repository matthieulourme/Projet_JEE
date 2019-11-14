package domain;

public class Groupe {

	private int id;
	private String nom;
	private int contactId;
	
	public Groupe(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	public Groupe(int id, String nom, int contactId) {
		super();
		this.id = id;
		this.nom = nom;
		this.contactId = contactId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
}
