package classeJava;



public class Evaluateur extends Chercheur{

	private String remarque,avis;
	
	public Evaluateur(String nom, String prenom, String adresse, String domiane, String institution,String remarque,String avis) {
		super(nom, prenom, adresse, domiane, institution);
		// TODO Auto-generated constructor stub
		this.avis=avis;
		this.remarque=remarque;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	@Override
	public String toString() {
		return "Evaluateur [remarque=" + remarque + ", avis=" + avis + "]";
	}
	
	

}

