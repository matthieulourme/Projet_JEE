package servletAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import actionForm.CreerContactValidationForm;
import domain.DAOContact;

public class CreerContactAction extends Action {

	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final CreerContactValidationForm lForm=(CreerContactValidationForm) pForm;
		final int id= lForm.getId();
		final String nom= lForm.getNom();
		final String prenom= lForm.getPrenom();
		final String email= lForm.getEmail();
		
		final DAOContact lDAOContact = new DAOContact();
		final String lError= lDAOContact.addContact(nom,prenom,email);
		
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
