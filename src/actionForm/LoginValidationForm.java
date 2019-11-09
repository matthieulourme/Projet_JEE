package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginValidationForm extends ActionForm {
	private String name=null;
	private String password=null;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.name=null;
		this.password=null;
	}
	
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors= new ActionErrors();
		if(getName()==null || getName().length()<1) {
			errors.add("name", new ActionMessage("Username pas correct"));
		}
		if(getPassword()==null || getPassword().length()<1) {
			errors.add("password", new ActionMessage("password pas correct"));
		}
		
		return errors;
	}
}
