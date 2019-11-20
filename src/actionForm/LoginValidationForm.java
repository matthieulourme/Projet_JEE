package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginValidationForm extends ActionForm {
	
	private static final long serialVersionUID = 1L;
	
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
			errors.add("name", new ActionMessage("error.nom"));
		}
		if(getPassword()==null || getPassword().length()<1) {
			errors.add("password", new ActionMessage("error.mdp"));
		}
		if(getName().length()>0 && getPassword().length()>0 && !getName().equals(getPassword())) {
			errors.add("login", new ActionMessage("error.login"));
			System.out.println("hello");
		}
		System.out.println(errors.size());
		return errors;
	}
}
