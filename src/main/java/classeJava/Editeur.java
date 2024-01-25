package classeJava;



import java.util.List;
import java.util.Map;

public class Editeur {

	private Chercheur editeur;
	private List<String> motCle;
	private Revue revue;
	private Map<Article,Boolean> listArticle;
	
	public Editeur(Chercheur editeur, List<String> motCle, Revue revue) {
		super();
		this.editeur = editeur;
		this.motCle = motCle;
		this.revue = revue;
	}
	
	public Chercheur getEditeur() {
		return editeur;
	}
	
	public void setEditeur(Chercheur editeur) {
		this.editeur = editeur;
	}
	public List<String> getMotCle() {
		return motCle;
	}
	
	public void setMotCle(List<String> motCle) {
		this.motCle = motCle;
	}
	
	public Revue getRevue() {
		return revue;
	}
	public void setRevue(Revue revue) {
		this.revue = revue;
	}
	public Map<Article, Boolean> getListArticle() {
		return listArticle;
	}
	
	public void setListArticle(Map<Article, Boolean> listArticle) {
		this.listArticle = listArticle;
	}
	
	
}

