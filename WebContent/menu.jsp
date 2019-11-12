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
	<a href="RechercheContact.do"><bean:message key="recherche_contact"/></a>
	<a href="CreerGroupe.do"><bean:message key="creer_groupe"/></a>
	
	<br>
	<br>
	
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
			<%
				final String RESOURCE_JDBC = "java:comp/env/jdbc/jee";
				try {
					final Context lContext= new InitialContext();
					final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
					final Connection lConnection = lDataSource.getConnection();
					
					final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID");
					ResultSet rs = lPreparedStatementCreation2.executeQuery();
					while(rs.next()) {
			%>
		   <tr>
		   	   <td><%out.println(rs.getInt("id")); %></td>
		       <td><a href="Contact.jsp?userId=<%=rs.getInt("id")%>"><%out.println(rs.getString("name"));%></a></td>
		       <td><%out.println(rs.getString("firstname")); %></td>
		       <td><%out.println(rs.getString("mail")); %></td>
		       <td>
		       		<%if(rs.getString("numero")!=null){
		    	   		out.println(rs.getString("numero"));
		       		}
		    	   	else {
		    	   		out.println("vide");
		    	   	}%>
			   </td>
			   <td>
		       		<%if(rs.getString("adr")!=null){
		    	   		out.println(rs.getString("adr"));
		       		}
		    	   	else {
		    	   		out.println("vide");
		    	   	}%>
			   </td>
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