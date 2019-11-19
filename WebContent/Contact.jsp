<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_contact_titre"/></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/cyborg/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
  
</head>
<body>
	<logic:iterate id="contact" name="infoContact">
		<h2><bean:write name="contact" property="nom"/> <bean:write name="contact" property="prenom"/></h2>
		<br><bean:write name="contact" property="email"/><br>
		<br><bean:write name="contact" property="telephone"/><br>
		<br><bean:write name="contact" property="adresse"/><br>
		<html:form action="/SupprimerContact">
			<html:errors/>
			<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
			<input type="hidden" name="email" value="<bean:write name="contact" property="email"/>" />
			<a href="menu.jsp" onclick="parentNode.submit();"><bean:message key="supp_contact"/></a>
		</html:form>
		<a href="UpdateContact.do?userId=<bean:write name="contact" property="id"/>"><bean:message key="update_contact"/></a>
		<a href="CreerContactGroupe.do?userId=<bean:write name="contact" property="id"/>"><bean:message key="contact_groupe"/></a>
		<a href="menu.jsp" ><bean:message key="retour_menu"/></a>
	</logic:iterate>
</body>
</html:html>