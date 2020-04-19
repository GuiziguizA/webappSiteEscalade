package sig.org.enumeration;

public enum NombreVoie {
	
	
	nombreVoies(""),
	nombreVoies1("1 a 50"),
	nombreVoies2("50 a 100"),
	nombreVoies3("100 a 200"),
	nombreVoies4("200 a 300"),
	nombreVoies5("300 +");
	
	 
	private final String nom;
	

	NombreVoie( String nom) {
		 this.nom = nom;
	}


	public String getNom() {
		return nom;
	}

}
