package livraison;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Demo
{
	public static void main(String[] args)
	{	/*Grille grille1 = new Grille(10);
	    Grille grille2 = new Grille(10);
	Joueur j1 = new Joueur("joueur1",grille1);
	Joueur j2 = new Joueur("joueur2",grille2);
	j1.navires.get(0).setCaseDeDepart(1,1);
	j1.placerBateau(j1.navires.get(0),true,'B');
	JFrame fen = new JFrame("Convertisseur");
    JPanel grille = new GrillePanel(j1.getGrille());
	grille.repaint();
    fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    fen.getContentPane().add(grille);
    fen.setSize(900,600);
    fen.setVisible(true);
	j1.getGrille().afficherPlateau();*/

		Scanner scanner = new Scanner(System.in);
		int choix;
		do {
				// Affichage du menu avec bordures et effets
				System.out.println("+-------------------------------------+");
				System.out.println("|           BATAILLE NAVALE           |");
				System.out.println("+-------------------------------------+");
				System.out.println("|                                     |");
				System.out.println("| 1. Jouer contre l'IA                |");
				System.out.println("| 2. Jouer contre un joueur physique  |");
				System.out.println("| 3. Règles du jeu                    |");
				System.out.println("| 4. Quitter                          |");
				System.out.println("|                                     |");
				System.out.println("+-------------------------------------+");
				System.out.print("Choix : ");

				// Récupération du choix de l'utilisateur
				choix = scanner.nextInt();

				switch (choix) {
						case 1:
								System.out.println("Vous avez choisi de jouer contre l'IA.");
								// Code pour jouer contre l'IA
								break;
						case 2:
								System.out.println("Vous avez choisi de jouer contre un joueur physique.");
								jouerContreJoueur();
								// Code pour jouer contre un joueur physique
								break;
						case 3:
								System.out.println("Voici les règles du jeu...");
								// Code pour afficher les règles du jeu
								break;
						case 4:
								System.out.println("Au revoir !");
								break;
						default:
								System.out.println("Choix invalide.");
								break;
				}
		} while (choix != 4);




  	//j1.tire(ob, grille, 2, 4);




}

public static void ajouterElement(Joueur j1,int e){
	boolean vertical=false;
	Scanner scanner = new Scanner(System.in);
	int verti,x=-1,y=-1;
	char c;
	boolean bateauPlacee=false;



	    while(!bateauPlacee){
	        System.out.println("Veuillez entrer la coordonnée x du bateau numéro "+(e+1));
	        x=scanner.nextInt();
	        if(x<11 && x>=1){
	            while(!bateauPlacee){
	                System.out.println("Veuillez entrer la coordonnée y du bateau numéro "+(e+1) );
	                y=scanner.nextInt();
	                if(y<11 && y>=1){
	                    while(!bateauPlacee){
	                        System.out.println("Entrez la direction depuis la case de départ (Ex: 'H' : bas 'G': gauche etc...)\n");
	                        c=scanner.next().charAt(0);
	                        if(c=='H' || c=='B' || c=='G' || c=='D'){
	                                vertical=true;
	                                System.out.println("Entrez 1 pour un vertical et 0 pour horizontal: ");
	                               verti = scanner.nextInt();
																 j1.navires.get(e).setCaseDeDepart(x,y);
	                                if(verti==0 && (c=='G'||c=='D')){
			                                vertical=false;
	                                    if(j1.placableCase(j1.navires.get(e),c,vertical,j1.getGrille())){
		                                    j1.placerBateau(j1.navires.get(e),vertical,c);
																				j1.getGrille().afficherPlateau();
																				bateauPlacee=true;
																			}else {
																				j1.placerBateau(j1.navires.get(e),vertical,c);

																				j1.getGrille().afficherPlateau();

																			}
																		}
																			else if(verti==1 && (c=='H'||c=='B')){
																			vertical = true;
		                                    if(j1.placableCase(j1.navires.get(e),c,vertical,j1.getGrille())){
			                                    j1.placerBateau(j1.navires.get(e),vertical,c);
																					j1.getGrille().afficherPlateau();
																					bateauPlacee=true;
																				}else {

																						j1.placerBateau(j1.navires.get(e),vertical,c);
																						j1.getGrille().afficherPlateau();
																				}
	                                		}

	                        else {System.out.println("Entrez 'H 1' Haus Vertical ou '1 B' Bas Vertical \n'G 0' Gauche Horizontal 'D 0' Droit Horizontal");}

	                }
	                else {System.out.println("Erreur dans la direction entre 'H' haut 'D' droit 'B' bas 'G' gauche");}
	            }
	        }else {System.out.println("Erreur dans y entre un entier entre 1 et 10 inclus");}

	    }
		       }else {System.out.println("Erreur dans x entre un entier entre 1 et 10 inclus");}
			  }
	}




public static void jouerContreJoueur() {


	Grille grille1 = new Grille(10);
	Grille grille2 = new Grille(10);
	Scanner scanner = new Scanner(System.in);
	Joueur j1 = new Joueur("joueur1",grille1);
	Joueur j2 = new Joueur("joueur2",grille2);
	boolean partieTerminee = false;
	int x=-1,y=-1;
	Obus ob =new Obus();


	//System.out.println("nb Coord Navires : "+j1.coordTotal+" "+j2.coordTotal);

	/*j1.navires.get(0).setCaseDeDepart(1,1);
	j1.placerBateau(j1.navires.get(0),false,'D');


	j2.navires.get(0).setCaseDeDepart(1,1);
	j2.placerBateau(j2.navires.get(0),true,'B');



	j1.tirer(j2.getGrille(),j2,ob,1,1);
	j1.tirer(j2.getGrille(),j2,ob,2,1);
	j1.tirer(j2.getGrille(),j2,ob,3,1);
	j1.tirer(j2.getGrille(),j2,ob,4,1);
	j1.tirer(j2.getGrille(),j2,ob,5,1);

	j2.tirer(j1.getGrille(),j1,ob,1,1);
	j2.tirer(j1.getGrille(),j1,ob,1,2);
	j2.tirer(j1.getGrille(),j1,ob,1,3);
	j2.tirer(j1.getGrille(),j1,ob,1,4);

	j1.getGrille().afficherPlateau();
	j2.getGrille().afficherPlateau();*/

	System.out.println("joueur 1 : "+j1.coordTotal+"joueur 2: "+j2.coordTotal);
	if(j1.coordTotal<=0)
	//	System.out.println("\n***** PARTIE TERMINEE *****\n");
		System.out.println("\n***** VAINQUEUR : "+j1.getNom()+" *****\n");
		else if(j2.coordTotal<=0)
		System.out.println("\n***** VAINQUEUR : "+j2.getNom()+" *****\n");


	System.out.println("\n***** MODE DE JEU : JOUER CONTRE UN JOUEUR PHYSIQUE *****\n");




	for(int i=0 ;i<2;i++)
		for(int e=0 ;e<j1.nbNavires;e++)
			if(i==0) {System.out.println("Le joueur "+(i+1)+" place ses bateaux.");ajouterElement(j1,e);}
			else if(i==1){System.out.println("Le joueur "+(i+1)+" place ses bateaux."); ajouterElement(j2,e);}
	Joueur joueurCourant = j1;
	Grille grilleCourante = j1.getGrille();
	Joueur autreJoueur = j2;
	Grille autreGrille = j2.getGrille();


	while(true){
		if(autreJoueur.coordTotal<=0){
		//	System.out.println("\n***** PARTIE TERMINEE *****\n");
			System.out.println("\n***** VAINQUEUR : "+joueurCourant.getNom()+" *****\n");break;}
		if(joueurCourant.coordTotal<=0){
			System.out.println("\n***** VAINQUEUR : "+autreJoueur.getNom()+" *****\n");
			break;}


		System.out.println("C'est au tour de " + joueurCourant.getNom() + " de jouer");
		System.out.println("Viser sur une case Entrez x: ");
		x=scanner.nextInt();
		if(x<11 && x>=1){
			System.out.println("Entrez y :");
			y=scanner.nextInt();
			if(y<11 && y>=1){
				if(!autreGrille.dejaTirer(x,y)){
					System.out.println(joueurCourant.nbNavires+" "+autreJoueur.nbNavires);
					joueurCourant.tirer(autreGrille,autreJoueur,ob,x,y);
					autreGrille = autreJoueur.getGrille();
					autreGrille.afficherPlateau();
					if(autreGrille.estToucher(x,y))
						continue;
				}else	{System.out.println("Viser sur une case jamais touchée");continue;}

			}else	{System.out.println("Y entre [1--10]");continue;}
		}else {System.out.println("X entre [1--10]");}

			if(joueurCourant==j1){
				joueurCourant=j2;
				autreJoueur=j1;
				grilleCourante=j2.getGrille();
				autreGrille=j1.getGrille();
			}else {
				joueurCourant=j1;
				autreJoueur=j2;
				grilleCourante=j1.getGrille();
				autreGrille=j2.getGrille();
			}}

	}
	//for(int i=0; i<j1.navires.get(0).getCoordBateau().length;i++)

}
