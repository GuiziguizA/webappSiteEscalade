package sig.org.enumeration;

public enum NombreSecteur {
	nombreSecteur(""),
	nombreSecteur1("1 a 10"),
	nombreSecteur2("10 a 20"),
	nombreSecteur3("20 a 30"),
	nombreSecteur4("30 a 40"),
	nombreSecteur5("40 a 50"),
	nombreSecteur6("50 et +");
	 
	private final String nom;
	

	NombreSecteur( String nom) {
		 this.nom = nom;
	}


	public String getNom() {
		return nom;
	}

	
	
	
}
