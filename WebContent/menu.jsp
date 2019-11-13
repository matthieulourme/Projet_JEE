<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="CreerContact.do"><bean:message key="creer_contact"/></a>
	<a href="RechercheContact.do"><bean:message key="recherche_contact"/></a>
	<a href="CreerGroupe.do"><bean:message key="creer_groupe"/></a>
	<a href="SupprimerGroupe.do"><bean:message key="supp_groupe"/></a>
	
	<br>
	<br>
	
	<logic:present name="allContact">
		<logic:empty name="allContact">
		Vous n'avez aucun contact
		</logic:empty>
	</logic:present>
	
	<logic:present name="allContact">
		<h4><bean:message key="titre_contact"/></h4>
		<table border="2">
			<thead>
				<tr>
					<th>#</th>
					<th><bean:message key="tab_nom"/></th>
					<th><bean:message key="tab_prenom"/></th>
					<th><bean:message key="tab_email"/></th>
					<th><bean:message key="tab_tel"/></th>
					<th><bean:message key="tab_adr"/></th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="contact" name="allContact">
					<tr>
						<td> <bean:write name="contact" property="id"/></td>
						<td>
						<html:form action="/Contact">
							<html:errors/>
							<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
							<a href="Contact.jsp" onclick="parentNode.submit();"><bean:write name="contact" property="nom"/></a>
						</html:form>
						</td>
						<td> <bean:write name="contact" property="prenom"/></td>
						<td> <bean:write name="contact" property="email"/></td>
						<td> <bean:write name="contact" property="telephone"/></td>
						<td> <bean:write name="contact" property="adresse"/></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
	</logic:present>

</body>
</html:html>