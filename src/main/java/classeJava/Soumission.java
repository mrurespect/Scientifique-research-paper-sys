package classeJava;

import java.util.Date;

public class Soumission {

	private Correspondant correspondants;
	private Editeur editeur;
	private Date dateSoumission;
	public Soumission(Correspondant correspondants, Editeur editeur) {
		this.correspondants = correspondants;
		this.editeur = editeur;
	}
	public Correspondant getCorrespondants() {
		return correspondants;
	}
	public void setCorrespondants(Correspondant correspondants) {
		this.correspondants = correspondants;
	}
	public Editeur getEditeur() {
		return editeur;
	}
	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}
	public Date getDateSoumission() {
		return dateSoumission;
	}
	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}
}
