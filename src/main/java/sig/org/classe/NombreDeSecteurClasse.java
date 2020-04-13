package sig.org.classe;

import java.util.ArrayList;
import java.util.List;


import sig.org.enumeration.NombreSecteur;

public class NombreDeSecteurClasse {
	
	/**
	 * renvoie la liste de tous les nombreSecteurs
	 * @return
	 */
public  List<NombreSecteur> listNombreSecteur(){
		
		List<NombreSecteur> listNombreSecteur = new ArrayList<>();
		 listNombreSecteur.add(NombreSecteur.nombreSecteur);
		 listNombreSecteur.add(NombreSecteur.nombreSecteur1);
		 listNombreSecteur.add(NombreSecteur.nombreSecteur2);
		 listNombreSecteur.add(NombreSecteur.nombreSecteur3);
		 listNombreSecteur.add(NombreSecteur.nombreSecteur4);
		 listNombreSecteur.add(NombreSecteur.nombreSecteur5);
		 listNombreSecteur.add(NombreSecteur.nombreSecteur6);

			
		 
		
		return  listNombreSecteur;
		
		
	}

}
