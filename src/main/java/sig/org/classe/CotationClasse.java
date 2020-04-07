package sig.org.classe;

import java.util.ArrayList;
import java.util.List;

import sig.org.enumeration.Cotation;

public class CotationClasse {
	
	
	public  List<String> listCotation(){
		
		List<String> listCotations = new ArrayList<>();
		
		 listCotations.add(Cotation.cotation1.getNom());
		 listCotations.add(Cotation.cotation2.getNom());
		 listCotations.add(Cotation.cotation3.getNom());
		 listCotations.add(Cotation.cotation4.getNom());
		 listCotations.add(Cotation.cotation5a.getNom());
		 
		
		return  listCotations;
		
		
	}
		

}
