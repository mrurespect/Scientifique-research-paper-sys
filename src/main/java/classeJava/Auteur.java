package classeJava;


public class Auteur extends Chercheur{

	private Article article;
	public Auteur(String nom, String prenom, String adresse, String domiane, String institution) {
		super(nom, prenom, adresse, domiane, institution);
		// TODO Auto-generated constructor stub
		
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}

	
}

