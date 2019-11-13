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
	<table border="2">
		<thead>
			<tr>
				<th>#</th>
				<th>Nom</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<%
				final String RESOURCE_JDBC = "java:comp/env/jdbc/jee";
				try {
					final Context lContext= new InitialContext();
					final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
					final Connection lConnection = lDataSource.getConnection();
					
					final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM groupe");
					ResultSet rs = lPreparedStatementCreation2.executeQuery();
					while(rs.next()) {
			%>
		   <tr>
		   	   <td><%out.println(rs.getInt("id")); %></td>
		       <td><%out.println(rs.getString("nom"));%></td>
		       <td>
		       		<%final PreparedStatement lPreparedStatementCreation3 = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN groupe_contact ON contact.id = groupe_contact.contactID LEFT JOIN groupe ON groupe_contact.groupeID = groupe.id WHERE contact.id=? and groupe.id=?");
		       		lPreparedStatementCreation3.setString(1, request.getParameter("userId"));
		       		lPreparedStatementCreation3.setInt(2, rs.getInt("id"));
		       		ResultSet rs2 = lPreparedStatementCreation3.executeQuery();
		       		if(!rs2.next()) {
		       			%>	
		       			<html:form action="/CreerContactGroupe">
							<html:errors/>
								<input type="hidden" name="contactID" value="<%=request.getParameter("userId")%>" />
								<input type="hidden" name="groupeID" value="<%=rs.getInt("id")%>"/>
								<a href="menu.jsp" onclick="parentNode.submit();"><bean:message key="creer_contact_groupe"/></a>
						</html:form>
						<%
		       		}
		       		else {
		       			out.println("supprimer de ce groupe");
		       		}
		       		%>
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
</html:html>