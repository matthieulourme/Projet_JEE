package domain;

public class ContactGroupe {
	private int contactId;
	private String contactNom;
	private String prenom;
	private String email;
	private int groupeId;
	private String groupNom;
	
	
	public ContactGroupe(int contactId, String contactNom, String prenom, String email, int groupeId, String groupNom) {
		super();
		this.contactId = contactId;
		this.contactNom = contactNom;
		this.prenom = prenom;
		this.email = email;
		this.groupeId = groupeId;
		this.groupNom = groupNom;
	}

	public int getContactId() {
		return contactId;
	}
	
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	
	public String getContactNom() {
		return contactNom;
	}
	
	public void setContactNom(String contactNom) {
		this.contactNom = contactNom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getGroupeId() {
		return groupeId;
	}
	
	public void setGroupeId(int groupeId) {
		this.groupeId = groupeId;
	}
	
	public String getGroupNom() {
		return groupNom;
	}
	
	public void setGroupNom(String groupNom) {
		this.groupNom = groupNom;
	}
}
