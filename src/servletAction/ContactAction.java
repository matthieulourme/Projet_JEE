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

import actionForm.ContactValidationForm;
import domain.DAOContact;

public class ContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final ContactValidationForm lForm= (ContactValidationForm)pForm;
		final int id = lForm.getId();
		HttpSession session = pRequest.getSession();
		final DAOContact lDAOContact = new DAOContact();
		final List liste= lDAOContact.infoContact(id);
		
		if(liste != null){
            session.setAttribute("infoContact" , liste);
        }
        return (pMapping.findForward("contact"));
	}
}
