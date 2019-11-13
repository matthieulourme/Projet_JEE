package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.SupprimerContactGroupeValidationForm;
import domain.DAOContact;

public class SupprimerContactGroupeAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final SupprimerContactGroupeValidationForm lForm=(SupprimerContactGroupeValidationForm) pForm;
		final int contactid = lForm.getContactID();
		final int groupeid = lForm.getGroupeID();

		final DAOContact lDAOContact = new DAOContact();
		final String lError= lDAOContact.deleteContactGroup(contactid, groupeid);
		
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
