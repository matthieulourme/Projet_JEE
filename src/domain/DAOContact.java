package domain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOContact {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/jee";
	public String addContact( final String nom,final String prenom,final String email) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementCreation= lConnection.prepareStatement("INSERT INTO CONTACT(name, firstname, mail) VALUES (?, ?, ?)");
			lPreparedStatementCreation.setString(1, nom);
			lPreparedStatementCreation.setString(2, prenom);
			lPreparedStatementCreation.setString(3, email);
			lPreparedStatementCreation.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	
	
	public String deleteContact(final String mail) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementSuppression=lConnection.prepareStatement("DELETE FROM contact WHERE mail = ?");
			lPreparedStatementSuppression.setString(1, mail);
			lPreparedStatementSuppression.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
}
