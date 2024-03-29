package domain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			
			final PreparedStatement lPreparedStatementCreation1 = lConnection.prepareStatement("INSERT INTO contact(name, firstname, mail) VALUES (?, ?, ?)");
			lPreparedStatementCreation1.setString(1, nom);
			lPreparedStatementCreation1.setString(2, prenom);
			lPreparedStatementCreation1.setString(3, email);
			lPreparedStatementCreation1.executeUpdate();
			
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT id FROM contact WHERE mail = ?");
			lPreparedStatementCreation2.setString(1, email);
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			int id;
			if (rs.next() == false) {
				System.out.println("Aucun r�sultat trouv�");
			}
			else {
				do {
					id = rs.getInt("id");
				} while(rs.next());			
				final PreparedStatement lPreparedStatementCreation3 = lConnection.prepareStatement("INSERT INTO telephone(numero, contactID) VALUES (?, ?)");
				lPreparedStatementCreation3.setString(1, telephone);
				lPreparedStatementCreation3.setInt(2, id);
				lPreparedStatementCreation3.executeUpdate();
				final PreparedStatement lPreparedStatementCreation4 = lConnection.prepareStatement("INSERT INTO adresse(adr, contactID) VALUES (?, ?)");
				lPreparedStatementCreation4.setString(1, adresse);
				lPreparedStatementCreation4.setInt(2, id);
				lPreparedStatementCreation4.executeUpdate();
			}
			lConnection.close();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	
	
	public String deleteContact(final int id, final String mail) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementSuppression=lConnection.prepareStatement("DELETE FROM contact WHERE id = ?");
			lPreparedStatementSuppression.setInt(1, id);
			lPreparedStatementSuppression.executeUpdate();
			lConnection.close();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	public ArrayList  researchContact(final String mail,final String nom, final String prenom) {
		try {
			final ArrayList resRecherche= new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
		
			if(!mail.isEmpty()&& nom.isEmpty() && prenom.isEmpty()) {
			final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.mail LIKE \'"+mail+"%\'");
			//lPreparedStatementRecherche.setString(1, mail);
			ResultSet rs = lPreparedStatementRecherche.executeQuery();
			
			if (rs.next() == false) {
				
			}
			else {
				do {
					resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
				} while(rs.next());
			}
			rs.close();
			}
			
			
			
			if(!mail.isEmpty() && nom.isEmpty() && !prenom.isEmpty()) {
				final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.mail LIKE \'"+mail+"%\' AND contact.firstname LIKE \'"+prenom+"%\'");
				//lPreparedStatementRecherche.setString(1, mail);
				ResultSet rs = lPreparedStatementRecherche.executeQuery();
				
				if (rs.next() == false) {
					
				}
				else {
					do {
						resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
					} while(rs.next());
				}
				rs.close();
				}
			
			
			
			if(!mail.isEmpty()&& !nom.isEmpty() && !prenom.isEmpty()) {
				final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.mail LIKE \'"+mail+"%\' AND contact.name LIKE \'"+nom+"%\' AND contact.firstname LIKE \'"+prenom+"%\'");
				//lPreparedStatementRecherche.setString(1, mail);
				ResultSet rs = lPreparedStatementRecherche.executeQuery();
				
				if (rs.next() == false) {
					
				}
				else {
					do {
						resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
					} while(rs.next());
				}
				rs.close();
				}
			
			
			
			if(!mail.isEmpty()&& !nom.isEmpty() && prenom.isEmpty()) {
				final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.mail LIKE \'"+mail+"%\' AND contact.name LIKE \'"+nom+"%\'");
				//lPreparedStatementRecherche.setString(1, mail);
				ResultSet rs = lPreparedStatementRecherche.executeQuery();
				
				if (rs.next() == false) {
					
				}
				else {
					do {
						resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
					} while(rs.next());
				}
				rs.close();
				}
			
			
			
			
			if(mail.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()) {
				final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.name LIKE \'"+nom+"%\' AND contact.firstname LIKE \'"+prenom+"%\'");
				//lPreparedStatementRecherche.setString(1, nom);
				//lPreparedStatementRecherche.setString(2, prenom);
				ResultSet rs = lPreparedStatementRecherche.executeQuery();
				
				if (rs.next() == false) {
					
				}
				else {
					do {
						resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
					} while(rs.next());
				}
				rs.close();
			}
			
			if(mail.isEmpty() && !nom.isEmpty() && prenom.isEmpty()) {
				final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.name LIKE \'"+nom+"%\'");
				//lPreparedStatementRecherche.setString(1, nom);
				ResultSet rs = lPreparedStatementRecherche.executeQuery();
				
				if (rs.next() == false) {
					
				}
				else {
					do {
						resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
					} while(rs.next());
				}
				rs.close();
			}
			
			if(mail.isEmpty() && nom.isEmpty() && !prenom.isEmpty()) {
				final PreparedStatement lPreparedStatementRecherche = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE  contact.firstname LIKE \'"+prenom+"%\'");
				//lPreparedStatementRecherche.setString(1, prenom);
				ResultSet rs = lPreparedStatementRecherche.executeQuery();
				
				if (rs.next() == false) {
					
				}
				else {
					do {
						resRecherche.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
					} while(rs.next());
				}
				System.out.println("Ici :"+resRecherche);
				rs.close();
			}
			
			
			lConnection.close();
			System.out.println("Resultat Recherche :"+resRecherche);
			return resRecherche;
		} catch (NamingException e) {
			e.printStackTrace();
            return null;
		} catch (SQLException e) {
			 e.printStackTrace();
	            return null;
		}

	}
	
	public String updateContact(final int id, final String nom,final String prenom,final String email,final String telephone, final String adresse ) {
		try {
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			final PreparedStatement lPreparedStatementUpdate1=lConnection.prepareStatement("UPDATE contact SET name = ?, firstname = ?, mail = ? WHERE id = ?");
			lPreparedStatementUpdate1.setString(1, nom);
			lPreparedStatementUpdate1.setString(2, prenom);
			lPreparedStatementUpdate1.setString(3, email);
			lPreparedStatementUpdate1.setInt(4, id);
			lPreparedStatementUpdate1.executeUpdate();
			
			final PreparedStatement lPreparedStatementUpdate2 = lConnection.prepareStatement("SELECT id FROM contact WHERE mail = ?");
			lPreparedStatementUpdate2.setString(1, email);		
			final PreparedStatement lPreparedStatementUpdate3 = lConnection.prepareStatement("UPDATE telephone SET numero = ? WHERE contactID = ?");
			lPreparedStatementUpdate3.setString(1, telephone);
			lPreparedStatementUpdate3.setInt(2, id);
			lPreparedStatementUpdate3.executeUpdate();
			final PreparedStatement lPreparedStatementUpdate4 = lConnection.prepareStatement("UPDATE adresse SET adr = ? WHERE contactID = ?");
			lPreparedStatementUpdate4.setString(1, adresse);
			lPreparedStatementUpdate4.setInt(2, id);
			lPreparedStatementUpdate4.executeUpdate();
			lConnection.close();
			return null;
		} catch (NamingException e) {
			return "NamingException : "+e.getMessage();
		} catch (SQLException e) {
			return "SQLException : "+e.getMessage();
		}
	}
	
	
	
	public List allContact() {
		try {
			final List allcontact = new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID");
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			if (rs.next() == false) {
				
			}
			else {
				do {
					allcontact.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
				} while(rs.next());
			}
			rs.close();
			lConnection.close();
			return allcontact;
		} catch (NamingException e) {
			e.printStackTrace();
	        return null;
		} catch (SQLException e) {
			 e.printStackTrace();
	         return null;
		}
	}
	
	public List infoContact(final int id) {
		try {
			final List infocontact = new ArrayList();
			final Context lContext= new InitialContext();
			final DataSource lDataSource= (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection = lDataSource.getConnection();
			//System.out.println(lConnection);
			
			//System.out.println("ok");
			final PreparedStatement lPreparedStatementCreation2 = lConnection.prepareStatement("SELECT * FROM contact LEFT JOIN telephone ON contact.id = telephone.contactID LEFT JOIN adresse ON contact.id = adresse.contactID WHERE contact.id=?");
			lPreparedStatementCreation2.setInt(1, id);
			System.out.println("infoContact: " + id);
			ResultSet rs = lPreparedStatementCreation2.executeQuery();
			if (rs.next() == false) {
				System.out.println("un probleme est survenu");
			}
			else {
				do {
					infocontact.add(new Contact(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(6),rs.getString(9)));
				} while(rs.next());
			}
			rs.close();
			lConnection.close();
			return infocontact;
		} catch (NamingException e) {
			e.printStackTrace();
	        return null;
		} catch (SQLException e) {
			 e.printStackTrace();
			 return null;
		}
	}
	
	
}
