package kantinesimulatie.kantine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class KantineAanbod {
    private HashMap<String, ArrayList<Artikel>> aanbod;
    private HashMap<String, Integer> startVoorraad;
    private HashMap<String, BigDecimal> prijzen;
    
    /**
     * Constructor. Het eerste argument is een lijst met artikelNamen,
     * het tweede argument is een lijst met prijzen en het derde argument
     * is een lijst met hoeveelheden. Let op: de dimensies van de drie arrays
     * moeten wel gelijk zijn!
     */
    public KantineAanbod(String[] artikelnaam, BigDecimal[] prijs, int[] hoeveelheid) {
        Random random = new Random();
        aanbod= new HashMap<>();
        startVoorraad= new HashMap<>();
        prijzen= new HashMap<>();

        boolean productHeeftKorting = false;

        for(int i=0;i<artikelnaam.length;i++) 
        {
            ArrayList<Artikel> artikelen= new ArrayList<>();
            for(int j=0;j<hoeveelheid[i];j++) 
            {
                if((random.nextInt(100) + 1) <= 25){

                    artikelen.add(new Artikel(artikelnaam[i], prijs[i], getKorting(prijs[i])));

                    productHeeftKorting = true;
                }else{
                    artikelen.add(new Artikel(artikelnaam[i], prijs[i]));
                }
            }

            if(!productHeeftKorting){
                int kortingArtikel = random.nextInt(artikelen.size());
                artikelen.get(kortingArtikel).setKorting(getKorting(artikelen.get(kortingArtikel).getPrijs()));
            }
            startVoorraad.put(artikelnaam[i], hoeveelheid[i]);
            prijzen.put(artikelnaam[i], prijs[i]);
            aanbod.put(artikelnaam[i], artikelen);
        }
    }

    /**
     * @param productnaam Naam van het product om aan te vullen.
     */
    private void vulVoorraadAan(String productnaam){
    	ArrayList<Artikel> huidigeVoorraad = aanbod.get(productnaam);
    	int startHoeveelheid = startVoorraad.get(productnaam);
    	int huidigeHoeveelheid = huidigeVoorraad.size();
    	BigDecimal prijs = prijzen.get(productnaam);
        for(int j=huidigeHoeveelheid;j<startHoeveelheid;j++) 
        {
        	huidigeVoorraad.add(new Artikel(productnaam, prijs));
        }
        aanbod.put(productnaam, huidigeVoorraad);
    }
    
    /**
     * Private methode om de lijst van artikelen te krijgen op basis van de    
     * naam van het artikel. Retourneert null als artikel niet bestaat.
     */
    private ArrayList<Artikel> getArrayList(String productnaam) {
         return aanbod.get(productnaam); 
    }

    /**
     * Private methode om een src.kantinesimulatie.kantine.Artikel van de stapel artikelen af te pakken.
     * Retourneert null als de stapel leeg is.
     */
    private Artikel getArtikel(ArrayList<Artikel> stapel) {
        if (stapel==null) {
            return null;
        }
        if (stapel.size()==0)
        {
           return null;
        }
        else 
        {
            Artikel a=stapel.get(0);
            stapel.remove(0);
            if(stapel.size() <= 5){
                vulVoorraadAan(a.getNaam());
            }
            return a;
        }
    }

    /**
     * Publieke methode om een artikel via naam van de stapel te pakken.
     * Retouneert null als artikel niet bestaat of niet op voorraad is.
     * @param productnaam (van artikel)
     * @return artikel (of null)
     */
    public Artikel getArtikel(String productnaam) {
        return getArtikel(getArrayList(productnaam));
    }

    private BigDecimal getKorting(BigDecimal prijs) {
        return prijs.divide(BigDecimal.valueOf(5), RoundingMode.HALF_EVEN);
    }
}
