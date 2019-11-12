<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>

<html:html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<html:form action="/UpdateContact">
	<html:errors/>
		<input type="hidden" name="id" value="<%=request.getParameter("userId")%>" />
		<%
		final String RESOURCE_JDBC = "java:comp/env/jdbc/jee";
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.id=?");
			lPreparedStatementCreation2.setString(1, request.getParameter("userId"));
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			while(rs.next()) {
		%>
		<label>Noms</label> <input type="text" name="nom" value="<%=rs.getString("name")%>" ><br>
		<label>Prénom</label> <input type="text" name="prenom" value="<%=rs.getString("firstname")%>"><br>
		<label>Email</label> <input type="email" name="email" value="<%=rs.getString("mail")%>"><br>
		<label>Téléphone</label><input type="text" name="telephone" value="<%=rs.getString("numero")%>"><br>
		<label>Adresse</label><input type="text" name="adresse" value="<%=rs.getString("adr")%>"><br>
		<html:submit>Envoyer</html:submit>
	   	<%
			}
		} catch (NamingException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		%>
	</html:form>
</body>
</html:html>