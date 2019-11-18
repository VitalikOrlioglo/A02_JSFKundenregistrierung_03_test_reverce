package dao;

import model.Kunde;

public class KundeDummyDAO implements KundeDAO {

	@Override
	public Kunde findKunde(String usr, String pwd) {
		Kunde kunde = new Kunde(1, "Kaban", "Kabanovici", "Kabanovici@web.de", "kab", "123");
		if (kunde.getUsername().equals(usr) && kunde.getPasswort().equals(pwd)) {
			return kunde;
		}
		return new Kunde();
//		return null;
	}

	@Override
	public boolean storeNewKunde(Kunde newKunde) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
