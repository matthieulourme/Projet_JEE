package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.CreerGroupeValidationForm;
import domain.DAOContact;

public class CreerGroupeAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final CreerGroupeValidationForm lForm=(CreerGroupeValidationForm) pForm;
		final int id= lForm.getId();
		final String nom= lForm.getNom();

		final DAOContact lDAOContact = new DAOContact();
		final String lError= lDAOContact.addGroup(nom);
		
		if(lError == null) {
			// if no exception is raised,  forward "menu"
			return pMapping.findForward("menu");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}

	}
}
