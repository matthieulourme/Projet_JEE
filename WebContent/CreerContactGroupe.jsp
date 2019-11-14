<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<logic:present name="groupInclusion">
		<logic:empty name="groupInclusion">
		Aucun groupe n'a été encore crée
		</logic:empty>
	</logic:present>
	
	<logic:present name="groupInclusion">
		<table border="2">
			<thead>
				<tr>
					<th>#</th>
					<th>Nom</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="groupe" name="groupInclusion">
			      <tr>
			      	<td><bean:write name="groupe" property="id"/></td>
			      	<td><bean:write name="groupe" property="nom"/></td>
			      	<td>
			      	<logic:equal name="groupe" property="contactId" value="0">
			      		<html:form action="/CreerContactGroupe">
							<html:errors/>
								<input type="hidden" name="contactID" value="<%=request.getParameter("userId")%>" />
								<input type="hidden" name="groupeID" value="<bean:write name="groupe" property="id"/>"/>
								<a href="menu.jsp" onclick="parentNode.submit();"><bean:message key="creer_contact_groupe"/></a>
						</html:form>
					</logic:equal>
					<logic:notEqual name="groupe" property="contactId" value="0">
						<html:form action="/SupprimerContactGroupe">
							<html:errors/>
								<input type="hidden" name="contactID" value="<%=request.getParameter("userId")%>" />
								<input type="hidden" name="groupeID" value="<bean:write name="groupe" property="id"/>"/>
								<a href="menu.jsp" onclick="parentNode.submit();"><bean:message key="supp_contact_groupe"/></a>
						</html:form>
					</logic:notEqual>
					</td>
		          </tr>
		        </logic:iterate>
			</tbody>
		</table>
	</logic:present>
</body>
</html:html>