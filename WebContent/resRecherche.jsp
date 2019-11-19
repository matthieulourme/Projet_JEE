<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title><bean:message key="label_resultat_recherche_titre"/></title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
	</head>
	<body>
	<logic:notPresent name="infoContact">
	</logic:notPresent>
	
	<logic:present name="infoContact">
		<logic:empty name ="infoContact">
			<bean:message key="no_res"/>
		</logic:empty>
	</logic:present>
	
	<logic:present name="infoContact">
		<table border="2">
		<thead>
			<tr>
				<th><bean:message key="tab_numero"/></th>
				<th><bean:message key="tab_nom"/></th>
				<th><bean:message key="tab_prenom"/></th>
				<th><bean:message key="tab_email"/></th>
				<th><bean:message key="tab_tel"/></th>
				<th><bean:message key="tab_adr"/></th>
			</tr>
		</thead>
		<tbody>
			<logic:iterate id="contact" name="infoContact">
			<tr>
				<td> <bean:write name="contact" property="id"/></td>
				<td> <html:form action="/Contact">
							<html:errors/>
							<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
							<a href="Contact.jsp" onclick="parentNode.submit();"><bean:write name="contact" property="nom"/></a>
						</html:form></td>
				<td> <bean:write name="contact" property="prenom"/></td>
				<td> <bean:write name="contact" property="email"/></td>
				<td> <bean:write name="contact" property="telephone"/></td>
				<td> <bean:write name="contact" property="adresse"/></td>
			</tr>
			</logic:iterate>
			
		</tbody>
		</table>
	</logic:present>
				
		<a href="menu.jsp" ><bean:message key="retour_menu"/></a>
	</body>
</html:html>