package sig.org.classe;

import java.util.ArrayList;
import java.util.List;

import sig.org.enumeration.Cotation;

public class CotationClasse {
	
	
	public  List<Cotation> listCotation(){
		
		List<Cotation> listCotations = new ArrayList<>();
		
		 listCotations.add(Cotation.cotation1);
		 listCotations.add(Cotation.cotation2);
		 listCotations.add(Cotation.cotation3);
		 listCotations.add(Cotation.cotation4);
		 listCotations.add(Cotation.cotation5a);
		 
		
		return  listCotations;
		
		
	}
		

}
