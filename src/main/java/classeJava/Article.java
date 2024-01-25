package classeJava;

import java.io.File;
import java.util.List;

public class Article {
	private int id_article;
	private int id_corr;
	private String titre;
	private byte[] centenue;
	private String type;
	private int taille;
	private String motsClef;
	private String evaluer;
	private byte[]  resume;//faisant au maximum 150 mots
	public Article(int id_article, int taille, byte[] centenue, byte[] resume, String titre, String motsClef,int id_corr,String evaluer) {
		super();
		this.id_article = id_article;
		this.titre = titre;
		this.centenue = centenue;
		this.taille = taille;
		this.motsClef = motsClef;
		this.resume = resume;
		this.id_corr = id_corr;
		this.setEvaluer(evaluer);
		if(taille<=4000) {
			type="Courts";
		}
		else {
			type="Longs";
		}
		
	}
	public int getId_article() {
		return id_article;
	}
	public void setId_article(int id_article) {
		this.id_article = id_article;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public byte[] getCentenue() {
		return centenue;
	}
	public void setCentenue(byte[] centenue) {
		this.centenue = centenue;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public String getMotsClef() {
		return motsClef;
	}
	public void setMotsClef(String motsClef) {
		this.motsClef = motsClef;
	}
	public byte[] getResume() {
		return resume;
	}
	public void setResume(byte[] resume) {
		this.resume = resume;
	}
	public int getId_corr() {
		return id_corr;
	}
	public void setId_corr(int id_corr) {
		this.id_corr = id_corr;
	}
	public String getEvaluer() {
		return evaluer;
	}
	public void setEvaluer(String evaluer) {
		this.evaluer = evaluer;
	}
	
	
	
	
	
	}

