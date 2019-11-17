package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DAOGroupe {
	private final static String RESOURCE_JDBC = "java:comp/env/jdbc/jee";

	public String addGroup(final String nom) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation1 = lConnection.prepareStatement("INSERT INTO GROUPE(nom) VALUES (?)");
			lPreparedStatementCreation1.setString(1, nom);
			lPreparedStatementCreation1.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	public String deleteGroup(final String nom) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementSuppression=lConnection.prepareStatement("DELETE FROM groupe WHERE nom = ?");
			lPreparedStatementSuppression.setString(1, nom);
			lPreparedStatementSuppression.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	public String addContactGroup(final int contactID, final int groupeID) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementCreation1 = lConnection.prepareStatement("INSERT INTO GROUPE_CONTACT(contactID, groupeID) VALUES (?, ?)");
			lPreparedStatementCreation1.setInt(1, contactID);
			lPreparedStatementCreation1.setInt(2, groupeID);
			lPreparedStatementCreation1.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	public String deleteContactGroup(final int contactID, final int groupeID) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementCreation1 = lConnection.prepareStatement("DELETE FROM groupe_contact WHERE contactID = ? and groupeID = ?");
			lPreparedStatementCreation1.setInt(1, contactID);
			lPreparedStatementCreation1.setInt(2, groupeID);
			lPreparedStatementCreation1.executeUpdate();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	public List allGroup() {
		try {
			final List allgroup = new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM groupe");
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			if (rs.next() == false) {
				
			}
			else {
				do {
					allgroup.add(new Groupe(rs.getInt(1),rs.getString(2)));
				} while(rs.next());
			}
			rs.close();
			return allgroup;
		} catch (NamingException e) {
			e.printStackTrace();
	        return null;
		} catch (SQLException e) {
			 e.printStackTrace();
	         return null;
		}
	}
	
	public List groupInclusion(final int id) {
		try {
			final List groupinclusion = new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM groupe");
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			PreparedStatement lPreparedStatementCreation3;
			
			if (rs.next() == false) {
				
			}
			else {
				do {
					lPreparedStatementCreation3 = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN groupe_contact ON contact.id = groupe_contact.contactID LEFT JOIN groupe ON groupe_contact.groupeID = groupe.id WHERE contact.id=? and groupe.id=?");
		       		lPreparedStatementCreation3.setInt(1, id);
		       		lPreparedStatementCreation3.setInt(2, rs.getInt("id"));
		       		ResultSet rs2 = lPreparedStatementCreation3.executeQuery();
		       		//System.out.println("groupe se fait bien");
		       		if(!rs2.next()) {
		       			groupinclusion.add(new Groupe(rs.getInt(1), rs.getString(2), 0));
		       		}
		       		else {
		       			groupinclusion.add(new Groupe(rs.getInt(1), rs.getString(2), rs2.getInt(6)));
		       		}
		       		rs2.close();
				} while(rs.next());
			}
			rs.close();
			lConnection.close();
			return groupinclusion;
		} catch (NamingException e) {
			e.printStackTrace();
	        return null;
		} catch (SQLException e) {
			 e.printStackTrace();
	         return null;
		}
	}

	public List allContactGroupe(int id) {
		try {
			final List allContactGroupe = new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementGroupe = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID LEFT JOIN groupe_contact ON contact.id=groupe_contact.contactID WHERE groupe_contact.groupeID=?;");
			lPreparedStatementGroupe.setInt(1, id);
			ResultSet rs = lPreparedStatementGroupe.executeQuery();
			if (rs.next() == false) {
				
			}
			else {
				do {
					allContactGroupe.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
				} while(rs.next());
			}
			System.out.println("On est ici"+allContactGroupe);
			rs.close();
			return allContactGroupe;
		} catch (NamingException e) {
			e.printStackTrace();
	        return null;
		} catch (SQLException e) {
			 e.printStackTrace();
	         return null;
		}
	}
	
	public List infoGroupe(int id) {
		try {
			final List infoGroupe = new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementGroupe = lConnection.prepareStatement("SELECT * FROM groupe WHERE id=?");
			lPreparedStatementGroupe.setInt(1, id);
			ResultSet rs = lPreparedStatementGroupe.executeQuery();
			if (rs.next() == false) {
				
			}
			else {
				do {
					infoGroupe.add(new Groupe(rs.getInt(1),rs.getString(2)));
				} while(rs.next());
			}
			rs.close();
			return infoGroupe;
		} catch (NamingException e) {
			e.printStackTrace();
	        return null;
		} catch (SQLException e) {
			 e.printStackTrace();
	         return null;
		}
	}
	
	
}
