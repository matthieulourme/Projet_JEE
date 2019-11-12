package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CreerContactGroupeValidationForm extends ActionForm {
	private int contactID=0;
	private int groupeID=0;
	private String nom=null;
	
	public int getContactID() {
		return contactID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public int getGroupeID() {
		return groupeID;
	}

	public void setGroupeID(int groupeID) {
		this.groupeID = groupeID;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String string) {
		nom=string;	
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.contactID=0;
		this.groupeID=0;
		this.nom=null;
	}
	
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors= new ActionErrors();
		if(getNom()==null || getNom().length()<1) {
			errors.add("nom", new ActionMessage("Nom pas correct"));
		}
		return errors;
	}
}
