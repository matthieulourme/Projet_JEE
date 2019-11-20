package actionForm;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RechercheContactValidationForm extends ActionForm {
	private String mail=null;
	private String nom=null;
	private String prenom=null;
 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.mail=null;
	}
	
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors= new ActionErrors();
		if((getMail()==null || getMail().length()<1) && (getNom()==null || getNom().length()<1) && (getPrenom()==null || getPrenom().length()<1)) {
			errors.add("mail", new ActionMessage("error.recherche"));
		}
		return errors;
	}

}
