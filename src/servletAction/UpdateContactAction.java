package servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.UpdateContactValidationForm;
import domain.DAOContact;

public class UpdateContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final UpdateContactValidationForm lForm=(UpdateContactValidationForm) pForm;
		final int id= lForm.getId();
		final String nom= lForm.getNom();
		final String prenom= lForm.getPrenom();
		final String email= lForm.getEmail();
		final String telephone = lForm.getTelephone();
		final String adresse = lForm.getAdresse();
		
		final DAOContact lDAOContact = new DAOContact();
		final String lError= lDAOContact.updateContact(id, nom, prenom, email, telephone, adresse);
		
		if(lError == null) {
			// if no exception is raised,  forward "menu"
			HttpSession session = pRequest.getSession();
			final DAOContact lDAOContact2 = new DAOContact();
			final List liste = lDAOContact2.allContact();
			session.setAttribute("allContact", liste);
			return pMapping.findForward("menu");
		}
		else {
			// If any exception, return the "error" forward
			return pMapping.findForward("error");
		}

	}
}
