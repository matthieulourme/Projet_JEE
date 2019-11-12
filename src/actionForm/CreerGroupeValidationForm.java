package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CreerGroupeValidationForm extends ActionForm {
	private int id=0;
	private String nom=null;
	
	public int getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setId(int i) {
		id=i;
	}
	
	public void setNom(String string) {
		nom=string;	
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=0;
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
