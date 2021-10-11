package tuto;


import java.util.Random;
import java.util.Scanner;

public class Tuto {
	
	public static void Grille(char[] tableau){
		
		System.out.println("[" + tableau[0] + '|' + tableau[1] + '|' + tableau[2] + "]");
		System.out.println("[" + tableau[3] + '|' + tableau[4] + '|' + tableau[5] + "]");				
		System.out.println("[" + tableau[6] + '|' + tableau[7] + '|' + tableau[8] + "]");
	}
	
	public static void win(char[] tableau, char joueurActif){
		Grille(tableau);
		System.out.println("Félicitation !! Le joueur "+ joueurActif + " remporte cette partie.");
	}

	public static void main(String[] args) {
		
//CREATION GRILLE
		
		
		
			char[] tableau = {
				'1','2','3',
				'4','5','6',
				'7','8','9'
			};
		
			char p1 = '\u25c9'; 
			char p2 = '\u2717'; 
			
			char joueurActif = p1;
			
			Scanner scan = new Scanner(System.in);
			String entree;
			boolean win = false;
			int nbDeCoup = 0;
			
			
			
			
// NOM DES JOUEURS
			
			Scanner player1 = new Scanner(System.in);
			String player;
			
			System.out.println("Joueur 1 rentrez votre prénom.");
			player = player1.nextLine();
			
			Scanner player2 = new Scanner(System.in);
			String prenom;
			
			System.out.println("════════════════════════════════");
			System.out.println("Joueur 2 rentrez votre prénom");
			prenom = player2.nextLine();
			
			
// JOUEURS ALEATOIRE
			String[]array = new String[] {player, prenom};
					Random rand = new Random();
					   
						System.out.println("══════════════════════════════");
						System.out.println(array [rand.nextInt(array.length)]+" vous commencez la partie, votre symbole est " + joueurActif);
						

						
// DEBUT DE LA PARTIE							
						Scanner lancement = new Scanner(System.in);
						String jeu;					
						System.out.println("═════════════════════════════════════════════════════");
						
						System.out.println("Le premier qui aligne 3 symboles remporte la partie.\n ############### C'EST PARTI !!!!!! ###############");
						jeu = lancement.nextLine();
			
// BOUCLE DU JEU
		
		while(true) {
	
// AFFICHE GRILLE
	
		Grille(tableau);
				
//DEMANDE LA CASE AU JOUEUR
	
	int c; 
	while (true) {
		
		nbDeCoup++;
		
		
		System.out.println("Choisis une case de 1 à 9");
		
		entree = scan.nextLine();
		
		try {
			c = Integer.parseInt(entree);
			if(1 <= c && c <= 9
					&& tableau [c -1] != p1
					&& tableau [c -1] != p2) {
				
				break;
			}
		 } catch (Exception e) {
			}
		}
	
// PLACER LE PION
	
	tableau[c - 1]= joueurActif;
	
// QUAND LE JOUEUR GAGNE
		

	for(int i = 0; i < 3; i++) {
			
		if(tableau[i * 3 ] == joueurActif && tableau[i * 3 + 1] == joueurActif && tableau[i * 3 + 2] == joueurActif) 
			win = true;   
		} 
			if (win) {
			win(tableau,joueurActif);
			break;
		}
		
		for(int i = 0; i < 3; i++) {
			
			if(tableau[i] == joueurActif && tableau[i + 3] == joueurActif && tableau[i + 6] == joueurActif) 
			win = true;
		}
			if (win) {
		   win(tableau,joueurActif);
			break;
		}
			
			
// DIAGONAL			
			
			if(tableau[0] == joueurActif && tableau[4] == joueurActif && tableau[8] == joueurActif) {
			win(tableau, joueurActif);
		    break;
		    }
			
			if(tableau[2] == joueurActif && tableau[4] == joueurActif && tableau[6] == joueurActif) {
			win(tableau, joueurActif);
			break;
			}
//EGALITE
			if(nbDeCoup > 8) {
				Grille(tableau);
				System.out.println("═════════");
				System.out.println("Egalité !!");
			break;
			}

// CHANGER DE JOUEUR
			
			if(joueurActif == p1)
				joueurActif = p2;
			else
				joueurActif = p1;
}
		
	

	
	scan.close();
	player1.close();
	player2.close();
	lancement.close();

	
}
	
}




