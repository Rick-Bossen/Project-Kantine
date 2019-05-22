package src.kantinesimulatie.utility;

public class Datum {

	private final int MIN_JAAR = 1900;
	private final int MAX_JAAR = 2100;

	private int dag;
	private int maand;
	private int jaar;

	  /**
	   * Constructor
	   */

	public Datum() {
		dag = 0;
		maand = 0;
		jaar = 0;
	}

	public Datum(int dag, int maand, int jaar) {
		this();
		if (bestaatDatum(dag,maand,jaar)) {
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean bestaatDatum(int dag, int maand, int jaar){

		if(jaar < MIN_JAAR || jaar > MAX_JAAR || maand < 1 || maand > 12 || dag < 1){
			return false;
		}

		int dagen = 31;

		switch(maand) {
			case 2:
				if(jaar % 4 == 0 && (jaar % 100 != 0 || jaar % 400 == 0)){
					dagen = 29;
				}else{
					dagen = 28;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				dagen = 30;
				break;
		}

		return dag <= dagen;
	}
	
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		if(bestaatDatum(dag, maand, jaar)){
			return String.format("%d-%d-%d", dag, maand, jaar);
		}
		return "Onbekend";
		}
}
