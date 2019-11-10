<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="CreerContact.do"><bean:message key="creer_contact"/></a>
	<a href="SupprimerContact.do"><bean:message key="supp_contact"/></a>
	<a href="UpdateContact.do"><bean:message key="update_contact"/></a>
	<a href="RechercheContact.do"><bean:message key="recherche_contact"/></a>
	
	<br>
	<br>
	
	<table border="2">
		<thead>
			<tr>
				<th>#</th>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<%
				final String RESOURCE_JDBC = "java:comp/env/jdbc/jee";
				try {
					final Context lContext= new InitialContext();
					final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
					final Connection lConnection = lDataSource.getConnection();
					
					final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM CONTACT");
					ResultSet rs = lPreparedStatementCreation2.executeQuery();
					while(rs.next()) {
			%>
		   <tr>
		   	   <td><%out.println(rs.getInt("id")); %></td>
		       <td><%out.println(rs.getString("name")); %></td>
		       <td><%out.println(rs.getString("firstname")); %></td>
		       <td><%out.println(rs.getString("mail")); %></td>
	       </tr>
	       <%
					}
	       %>
		</tbody>
	</table>
	<%
				} catch (NamingException e) {
					e.getMessage();
				} catch (SQLException e) {
					e.getMessage();
				}
	%>

</body>
</html>