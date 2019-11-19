package servletAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.RechercheContactValidationForm;
import domain.DAOContact;

public class RechercheContactAction extends Action  {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm,final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		final RechercheContactValidationForm lForm= (RechercheContactValidationForm)pForm;
		final String mail=lForm.getMail();
		final String nom=lForm.getNom();
		final String prenom=lForm.getPrenom();
		HttpSession session = pRequest.getSession();
		final DAOContact lDAOContact = new DAOContact();
		final ArrayList lError= lDAOContact.researchContact(mail,nom,prenom);
		System.out.println("Mail:"+mail+"nom:"+nom+"prenom:"+prenom);
		if(lError  != null){
			session.setAttribute("infoContact" , lError);
        }
        return (pMapping.findForward("recherche"));

	}

}
