package sig.org.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum Cotation {
	
	 cotation1("1"),
	 cotation2("2"),
	 cotation3("3"),
	 cotation4("4"),
	 cotation5a("5a");
	 
	private final String nom;
	

	Cotation( String nom) {
		 this.nom = nom;
	}


	public String getNom() {
		return nom;
	}




}
