
public class Main {

	public static void main(String[] args) {
		
		
		/* Les résultats d'exécution seront enregistrés dans le dossier indiqué dans la variable outfile
		 *  de les classes HillClimbingFirstImprovement et IteratedLocalSearch.  
		 */

		//Exécution de la métaheuristique HillClimbingFirstImprovement avec maxNbEval = 1000000
		new HillClimbingFirstImprovement(1000000);	
		
		//Exécution de la métaheuristique IteratedLocalSearch avec maxNbEval = 1000000
		new IteratedLocalSearch(1000000);
		

		
	}

}
