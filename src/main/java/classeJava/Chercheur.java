package classeJava;


public class Chercheur {
	
	private String nom,prenom,adresse,domiane,institution;

	public Chercheur(String nom, String prenom, String adresse, String domiane, String institution) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.domiane = domiane;
		this.institution = institution;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getDomiane() {
		return domiane;
	}

	public void setDomiane(String domiane) {
		this.domiane = domiane;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "Chercheur [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", domiane=" + domiane
				+ ", institution=" + institution + "]";
	}
	
	

}

