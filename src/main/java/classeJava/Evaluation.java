package classeJava;

import java.util.Date;

public class Evaluation {

	
		private Article article;
		private Evaluateur[] evaluateurs; 
		private Date dateEvaluation ;
		public Evaluation(Article article, Evaluateur[] evaluateurs) {
			this.article = article;
			this.evaluateurs = evaluateurs;
			
		}

		public Article getArticle() {
			return article;
		}
		public void setArticle(Article article) {
			this.article = article;
		}
		public Evaluateur[] getEvaluateurs() {
			return evaluateurs;
		}
		public void setEvaluateurs(Evaluateur[] evaluateurs) {
			this.evaluateurs = evaluateurs;
		}
		public Date getDateEvaluation() {
			return dateEvaluation;
		}
		public void setDateEvaluation(Date dateEvaluation) {
			this.dateEvaluation = dateEvaluation;
		}

	
}
