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

//import daos.String;

public class DAOContact {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/jee";
	public String addContact( final String nom,final String prenom,final String email,final String telephone, final String adresse) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation1 = lConnection.prepareStatement("INSERT INTO CONTACT(name, firstname, mail) VALUES (?, ?, ?)");
			lPreparedStatementCreation1.setString(1, nom);
			lPreparedStatementCreation1.setString(2, prenom);
			lPreparedStatementCreation1.setString(3, email);
			lPreparedStatementCreation1.executeUpdate();
			
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT id FROM CONTACT WHERE mail = ?");
			lPreparedStatementCreation2.setString(1, email);
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			int id;
			if (rs.next() == false) {
				System.out.println("Aucun résultat trouvé");
			}
			else {
				do {
					id = rs.getInt("id");
				} while(rs.next());			
				final PreparedStatement lPreparedStatementCreation3 = lConnection.prepareStatement("INSERT INTO TELEPHONE(numero, contactID) VALUES (?, ?)");
				lPreparedStatementCreation3.setString(1, telephone);
				lPreparedStatementCreation3.setInt(2, id);
				lPreparedStatementCreation3.executeUpdate();
				final PreparedStatement lPreparedStatementCreation4 = lConnection.prepareStatement("INSERT INTO ADRESSE(adr, contactID) VALUES (?, ?)");
				lPreparedStatementCreation4.setString(1, adresse);
				lPreparedStatementCreation4.setInt(2, id);
				lPreparedStatementCreation4.executeUpdate();
			}
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
	
	/*public String updateContact(String id, String nom, String prenom, String email) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementSuppression=lConnection.prepareStatement("Update contact SET name = ?, firstname = ?, mail = ?, ");
			lPreparedStatementSuppression.setString(1, mail);
			lPreparedStatementSuppression.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}*/
	
}
