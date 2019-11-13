package actionForm;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ContactValidationForm extends ActionForm {
	private int id=0;
	
	public int getId() {
		return id;
	}
	
	public void setId(int i) {
		id=i;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.id=0;
	}
	
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors= new ActionErrors();
		if(getId()==0) {
			errors.add("id", new ActionMessage("id pas correct"));
		}
		return errors;
	}
}
