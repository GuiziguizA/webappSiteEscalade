package sig.org.classe;

import java.util.ArrayList;
import java.util.List;


import sig.org.enumeration.NombreVoie;

public class NombreDeVoieClasse {
	
	/**
	 * Renvoie la liste de tous les NombreVoies
	 * @return
	 */
public  List<NombreVoie> listNombreSecteur(){
		
		List<NombreVoie>listNombreVoie = new ArrayList<>();
		listNombreVoie.add(NombreVoie.nombreVoies);
		listNombreVoie.add(NombreVoie.nombreVoies1);
		listNombreVoie.add(NombreVoie.nombreVoies2);
		listNombreVoie.add(NombreVoie.nombreVoies3);
		listNombreVoie.add(NombreVoie.nombreVoies4);
		listNombreVoie.add(NombreVoie.nombreVoies5);
		
		

			
		 
		
		return  listNombreVoie;

}
}
