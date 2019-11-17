package servletAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.ContactValidationForm;
import actionForm.GroupeValidationForm;
import domain.DAOContact;
import domain.DAOGroupe;

public class GroupeAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final GroupeValidationForm lForm= (GroupeValidationForm)pForm;
		final int id = lForm.getId();
		HttpSession session = pRequest.getSession();
		HttpSession session2 = pRequest.getSession();
		final DAOGroupe lDAOGroupe1 = new DAOGroupe();
		final List liste1 = lDAOGroupe1.allContactGroupe(id);
		final List liste2= lDAOGroupe1.infoGroupe(id);
		System.out.println("GroupAction: " +liste1);
		
		
		if(liste1 != null){
            session.setAttribute("allContactGroupe" , liste1);
        }
		if(liste2 != null){
            session.setAttribute("infoGroupe" , liste2);
        }
		
        return (pMapping.findForward("groupe"));
	}
}
