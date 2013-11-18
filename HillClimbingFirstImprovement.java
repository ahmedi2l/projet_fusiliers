import java.io.*;


public class HillClimbingFirstImprovement {

	public HillClimbingFirstImprovement(int maxNbEval) {
        
		Initialization initial = new Initialization();
		Automata automata = new Automata(25);
		int[] regles = new int[216];
		//Dossier où seront enregistrés les résultats d'exécution 
		String outfile = "/home/ahmed/workspace/projet_fusiliers/solutions_HillClimber/";
			
		//Tailles maximales résolues pour une solution s1 et une solution s2 Є V(s1)
		int maxSize1, maxSize2;

		//Choix aléatoire d'une solution s1
		int s1[] = initial.init(regles);
		
		maxSize1 = automata.f(s1,25);
		
		int nbEval = 0;
		int nbOcc[] = new int[25];
		
		while (nbEval < maxNbEval) {
			
		//Choix aléatoire d'une solution s2 Є V(s1)
		int s2[] = initial.init(regles);
		maxSize2 = automata.f(s2,25);
		
		//Compte le nombre d'occurence nbOcc[n] des solutions de taille n, n Є {2,3,4,5...25}
		for (int n=2; n<=25; n++){
			if (maxSize2 == n){
				nbOcc[n]+=1;
			}
			}
		
		if (maxSize1 <= maxSize2){
			s1=s2;
			maxSize1=maxSize2; 
			}
		nbEval+=1;
		
		}

		//Chaine des règles à sauvegarder
		String s = s1[0]+"";
		for (int i=1; i<s1.length; i++) {
			s=s+" "+s1[i];
		}
		
	    /* Tableau d'occurences de chaque taille résolue
		 * L'indice du tableau = taille
		 * la valeur = nombre d'occurence */
		String t = nbOcc[0]+"";
		for (int i=1; i<nbOcc.length; i++) {
			t=t+" "+nbOcc[i];
		}
		
		
		/* Sauvegarde dans un fichier de la meilleure solution s = s1 
		 * avec le tableau des occurences de toutes les tailles resolues */		
		try {
			PrintWriter printwriter = new PrintWriter(new BufferedWriter(new FileWriter(outfile+"/hc_regles_maxSize="+maxSize1+".dat")));
			printwriter.println(s);
			printwriter.println("nbEval = "+nbEval);
			printwriter.println("nbOcc[i] = "+t);
			printwriter.close();
		} catch (Exception e) {
			System.out.println("Impossible de sauvegarder le fichier regles_maxSize="+maxSize1+".dat"); }
			
		}

}
