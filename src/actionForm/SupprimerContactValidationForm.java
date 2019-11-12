package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class SupprimerContactValidationForm extends ActionForm{
	private int id=0;
	private String email=null;
	
	public int getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(int i) {
		id=i;
	}
	
	public void setEmail(String string) {
		email=string;	
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=0;
		this.email=null;
	}
	
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors= new ActionErrors();
		if(getEmail()==null || getEmail().length()<1) {
			errors.add("email", new ActionMessage("Email pas correct"));
		}
		return errors;
	}

}
