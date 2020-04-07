package sig.org.classe;

import java.util.ArrayList;
import java.util.List;

import sig.org.enumeration.Longueur;



public class LongueurClasse {
	
	
	
	public  List<String> listLongueur(){
		
		List<String> listLongueurs = new ArrayList<>();
		
		 listLongueurs.add(Longueur.longueur1.getNom());
		 listLongueurs.add(Longueur.longueur2.getNom());
		 listLongueurs.add(Longueur.longueur3.getNom());
		 listLongueurs.add(Longueur.longueur4.getNom());
		 listLongueurs.add(Longueur.longueur5.getNom());
		 listLongueurs.add(Longueur.longueur6.getNom());
		
		return  listLongueurs;
		
		
	}
		

}
