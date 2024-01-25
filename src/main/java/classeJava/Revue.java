package classeJava;



import java.util.List;

public class Revue {
	
	private String nomRevue;
	private List<Article> articleRevue;
	public Revue(String nomRevue, List<Article> articleRevue) {
		super();
		this.nomRevue = nomRevue;
		this.articleRevue = articleRevue;
	}
	public String getNomRevue() {
		return nomRevue;
	}
	public void setNomRevue(String nomRevue) {
		this.nomRevue = nomRevue;
	}
	public List<Article> getArticeRevue() {
		return articleRevue;
	}
	public void setArticeRevue(List<Article> articleRevue) {
		this.articleRevue = articleRevue;
	}
	
	

}

