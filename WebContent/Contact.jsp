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
    <h2><%out.println(rs.getString("name"));%> <%out.println(rs.getString("firstname")); %></h2><br>
    <%out.println(rs.getString("mail")); %><br>
	  		<%if(rs.getString("numero")!=null){
	   		out.println(rs.getString("numero"));
	  		}
	  	   	else {
	  	   		out.println("");
	  	   	}%><br>
      		<%if(rs.getString("adr")!=null){
   	   		out.println(rs.getString("adr"));
      		}
	   	   	else {
	   	   		out.println("");
	   	   	}%>
	<br>
	<html:form action="/SupprimerContact">
	<html:errors/>
		<input type="hidden" name="id" value="<%=request.getParameter("userId")%>" />
		<input type="hidden" name="email" value="<%=rs.getString("mail")%>" />
		<a href="menu.jsp" onclick="parentNode.submit();"><bean:message key="supp_contact"/></a>
	</html:form>
	<br>
   	<%
			}
		} catch (NamingException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
	%>
	<a href="UpdateContact.do?userId=<%=request.getParameter("userId")%>"><bean:message key="update_contact"/></a>
</body>
</html:html>