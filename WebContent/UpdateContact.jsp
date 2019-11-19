<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_update_contact_titre"/></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
</head>
<body>

	
   <logic:present name="infoContact">
	<logic:iterate id="contact" name="infoContact">
		<html:form action="/UpdateContact">
		<html:errors/>
			<input type="hidden" name="id" value="<bean:write name="contact" property="id"/>" />
			<label><bean:message key="tab_nom"/></label> <input type="text" name="nom" value="<bean:write name="contact" property="nom"/>"><br>
			<label><bean:message key="tab_prenom"/></label> <input type="text" name="prenom" value="<bean:write name="contact" property="prenom"/>"><br>
			<label><bean:message key="tab_email"/></label> <input type="email" name="email" value="<bean:write name="contact" property="email"/>"><br>
			<label><bean:message key="tab_tel"/></label><input type="text" name="telephone" value="<bean:write name="contact" property="telephone"/>"><br>
			<label><bean:message key="tab_adr"/></label><input type="text" name="adresse" value="<bean:write name="contact" property="adresse"/>"><br>
			<html:submit><bean:message key="form_envoyer"/></html:submit>
		</html:form>
	</logic:iterate>
	</logic:present>
</body>
</html:html>