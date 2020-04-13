package sig.org.classe;

import java.util.ArrayList;
import java.util.List;

import sig.org.enumeration.Longueur;



public class LongueurClasse {
	
	/**
	 * renvoie la liste de toutes les longueurs
	 * @return
	 */
	
	public  List<Longueur> listLongueur(){
		
		List<Longueur> listLongueurs = new ArrayList<>();

		 listLongueurs.add(Longueur.longueur);
		 listLongueurs.add(Longueur.longueur1);
		 listLongueurs.add(Longueur.longueur2);
		 listLongueurs.add(Longueur.longueur3);
		 listLongueurs.add(Longueur.longueur4);
		 listLongueurs.add(Longueur.longueur5);
		 listLongueurs.add(Longueur.longueur6);
		
		return  listLongueurs;
		
		
	}
		

}
