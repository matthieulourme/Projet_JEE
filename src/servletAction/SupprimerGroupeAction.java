package servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.SupprimerGroupeValidationForm;
import domain.DAOContact;

public class SupprimerGroupeAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final SupprimerGroupeValidationForm lForm= (SupprimerGroupeValidationForm)pForm;
		final int id=lForm.getId();
		final String nom=lForm.getNom();
		
		final DAOContact lDAOContact = new DAOContact();
		final String lError= lDAOContact.deleteGroup(nom);

		if(lError == null) {
			// if no exception is raised,  forward "menu"
			HttpSession session2 = pRequest.getSession();
			final DAOContact lDAOContact2 = new DAOContact();
			final List liste2 = lDAOContact2.allGroup();
			session2.setAttribute("allGroupe", liste2);
			return pMapping.findForward("menu");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}

	}
}
