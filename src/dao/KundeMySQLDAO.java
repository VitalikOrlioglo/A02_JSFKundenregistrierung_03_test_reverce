package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnect;
import model.Kunde;

public class KundeMySQLDAO implements KundeDAO {
	private DBConnect dbConnect = DBConnect.getInstance();
	
	@Override
	public Kunde findKunde(String usr, String pwd) {
		final String q = "SELECT * FROM kunde WHERE username=? AND passwort=?";
		
		try (PreparedStatement ps = dbConnect.getCon().prepareStatement(q)) {
			ps.setString(1, usr);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Kunde k = new Kunde(
						rs.getInt("id"),
						rs.getString("vorname"),
						rs.getString("nachname"),
						rs.getString("email"),
						rs.getString("username"),
						rs.getString("passwort")
						);
				return k;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Kunde();
	}

	@Override
	public boolean storeNewKunde(Kunde newKunde) {
		final String q = "INSERT INTO kunde (vorname, nachname, username, passwort, email) VALUES (?,?,?,?,?)";
		try (PreparedStatement ps = dbConnect.getCon().prepareStatement(q);) {
			ps.setString(1, newKunde.getVorname());
			ps.setString(2, newKunde.getNachname());
			ps.setString(3, newKunde.getUsername());
			ps.setString(4, newKunde.getPasswort());
			ps.setString(5, newKunde.getEmail());
			return 1 == ps.executeUpdate();
		} catch (SQLException e) {
			// TODO throw DAOException
			e.printStackTrace();
		}
		return false;
	}
}
