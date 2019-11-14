package servletAction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.LoginValidationForm;
import domain.DAOContact;

public class LoginAction extends Action{
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final LoginValidationForm lForm= (LoginValidationForm)pForm;
		final String name=lForm.getName();
		final String password=lForm.getPassword();
		
		if(name.equals(password)) {
			HttpSession session1 = pRequest.getSession();
			final DAOContact lDAOContact1 = new DAOContact();
			final List liste1 = lDAOContact1.allContact();
			session1.setAttribute("allContact", liste1);
			
			HttpSession session2 = pRequest.getSession();
			final DAOContact lDAOContact2 = new DAOContact();
			final List liste2 = lDAOContact2.allGroup();
			session2.setAttribute("allGroupe", liste2);
			
			return pMapping.findForward("menu");
		}
		else {
			return pMapping.findForward("index");
		}
	}

}
