<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
		<html:form action="/SupprimerGroupe">
		<html:errors/>
		<label>Nom</label>
			<select name="nom">
			<logic:iterate id="groupe" name="allGroupe">
					<option value="<bean:write name="groupe" property="nom"/>"><bean:write name="groupe" property="nom"/></option>
			</logic:iterate>
			</select><br>
			<html:submit>Envoyer</html:submit>
		</html:form>
</body>
</html:html>