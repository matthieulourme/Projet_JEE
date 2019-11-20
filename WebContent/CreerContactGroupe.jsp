<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
<meta charset="ISO-8859-1">
<title><bean:message key="label_creer_contact_groupe_titre"/></title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<a class="navbar-brand" href="#"><bean:message key="label_creer_contact_groupe_titre"/></a>
<div class="collapse navbar-collapse" id="navbarColor02"> 
<ul class="navbar-nav mr-auto">
  	<li class="nav-item">
  	<a class="nav-link" href="menu.jsp"><strong><bean:message key="retour_menu"/></strong></a>
  	</li>
  	<li class="nav-item">
  	<a class="nav-link" href="accueil.jsp"><strong><bean:message key="label_deco"/></strong></a>
  	</li>
</ul>
</div>
</nav>
<br>
<body>
	<logic:present name="groupInclusion">
		<logic:empty name="groupInclusion">
		<bean:message key="no_groupe"/>
		</logic:empty>
	</logic:present>
	
	<logic:present name="groupInclusion">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col"><bean:message key="tab_numero"/></th>
					<th scope="col"><bean:message key="tab_nom"/></th>
					<th scope="col"><bean:message key="tab_action"/></th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="groupe" name="groupInclusion">
			      <tr class="table-primary">
			      	<td scope="row"><bean:write name="groupe" property="id"/></td>
			      	<td scope="row"><bean:write name="groupe" property="nom"/></td>
			      	<td scope="row">
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