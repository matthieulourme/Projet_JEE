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
import domain.DAOGroupe;

public class ContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final ContactValidationForm lForm= (ContactValidationForm)pForm;
		final int id = lForm.getId();
		HttpSession session = pRequest.getSession();
		final DAOContact lDAOContact1 = new DAOContact();
		final List liste1 = lDAOContact1.infoContact(id);
		
		HttpSession session2 = pRequest.getSession();
		final DAOGroupe lDAOGroupe = new DAOGroupe();
		final List liste2 = lDAOGroupe.groupInclusion(id);
		
		if(liste1 != null){
            session.setAttribute("infoContact" , liste1);
        }
		if(liste2 != null){
            session.setAttribute("groupInclusion" , liste2);
        }
        return (pMapping.findForward("contact"));
	}
}
