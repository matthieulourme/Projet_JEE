package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SupprimerContactValidationForm extends ActionForm{
	private String mail=null;

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
		if(getMail()==null || getMail().length()<1) {
			errors.add("mail", new ActionMessage("Email pas correct"));
		}
		return errors;
	}

}
