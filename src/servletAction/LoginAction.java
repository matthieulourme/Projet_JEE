package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.LoginValidationForm;

public class LoginAction extends Action{
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final LoginValidationForm lForm= (LoginValidationForm)pForm;
		final String name=lForm.getName();
		final String password=lForm.getPassword();
		
		if(name.equals(password)) {
			return pMapping.findForward("menu");
		}
		else {
			return pMapping.findForward("index");
		}
	}

}
