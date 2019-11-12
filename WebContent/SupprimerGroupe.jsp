<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<html:form action="/SupprimerGroupe">
	<html:errors/>
	<label>Nom</label>
	<select name="nom">
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
			<option value="<%=rs.getString("nom")%>"><%out.println(rs.getString("nom"));%></option>
			<%
					}
				} catch (NamingException e) {
					e.getMessage();
				} catch (SQLException e) {
					e.getMessage();
				}
			%>
		</select><br>
		<html:submit>Envoyer</html:submit>
	</html:form>
</body>
</html:html>