package dao;

import model.Kunde;

public interface KundeDAO {
	public Kunde findKunde(String usr, String pwd);
	public boolean storeNewKunde(Kunde newKunde); //speichert Kundendaten
	
}
