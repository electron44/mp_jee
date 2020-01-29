package dao;

import beans.Administrateur;

public class AdminDAO {
	public AdminDAO() {
		
	}
	public boolean connectAdmin(Administrateur admin) {
	    boolean authorized = (admin.getUsername().equals("admin") && admin.getPassword().equals("passer"))? true : false ;
	    return authorized;
	}
}
