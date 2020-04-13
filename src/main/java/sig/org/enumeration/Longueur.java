package sig.org.enumeration;

public enum Longueur {

	longueur("null"),
	longueur1("longueur1"),
	longueur2("longueur2"),
	longueur3("longueur3"),
	longueur4("longueur4"),
	longueur5("longueur5"),
	longueur6("longueur6");

	private String nom;

	Longueur(String nom) {
		 this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
