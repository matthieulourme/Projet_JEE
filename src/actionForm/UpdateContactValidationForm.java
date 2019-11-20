package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class UpdateContactValidationForm extends ActionForm {
	private int id=0;
	private String nom=null;
	private String prenom=null;
	private String email=null;
	private String telephone=null;
	private String adresse=null;
	
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

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=0;
		this.nom=null;
		this.prenom=null;
		this.email=null;
		this.telephone=null;
		this.adresse=null;
	}
	
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors= new ActionErrors();
		if(getNom()==null || getNom().length()<1) {
			errors.add("nom", new ActionMessage("error.nom"));
		}
		if(getPrenom()==null || getPrenom().length()<1) {
			errors.add("prenom", new ActionMessage("error.prenom"));
		}
		if(getEmail()==null || getEmail().length()<1) {
			errors.add("email", new ActionMessage("error.email"));
		}
		if(getTelephone()==null || getTelephone().length()<1) {
			errors.add("telephone", new ActionMessage("error.tel"));
		}
		if(getAdresse()==null || getAdresse().length()<1) {
			errors.add("adresse", new ActionMessage("error.adr"));
		}
		return errors;
	}
}
