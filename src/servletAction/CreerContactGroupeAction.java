package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.CreerContactGroupeValidationForm;
import actionForm.CreerContactValidationForm;
import domain.DAOContact;
import domain.DAOGroupe;

public class CreerContactGroupeAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final CreerContactGroupeValidationForm lForm=(CreerContactGroupeValidationForm) pForm;
		final int contactid = lForm.getContactID();
		final int groupeid = lForm.getGroupeID();

		final DAOGroupe lDAOGroupe = new DAOGroupe();
		final String lError= lDAOGroupe.addContactGroup(contactid, groupeid);
		
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
