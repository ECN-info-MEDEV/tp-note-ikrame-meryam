/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.projet.objet.tpnote;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Cette classe définit les modalités du jeu 
 * @author Meryam
 */
public class Jeu {
    public int[][] plateau;
    public Joueur joueur1;
    public Joueur joueur2;
    
    
    /**
     * Cette méthode permet de 
     * @param nom1
     * @param nom2
     * @param combinaison 
     */
    public Jeu(String nom1,String nom2){
        this.plateau = new int[12][4];
        for(int[] row : plateau) {
            Arrays.fill(row, 0);
}
        this.joueur1 = new Joueur(nom1,0);
        this.joueur2 = new Joueur(nom2,1);
        
    }
    
    /**
     * Cette méthode permet au décodeur de deviner la combinaison
     * @return 
     */
    public int[] guess(){
        Scanner scanner = new Scanner(System.in);
        int[] guess = new int[4];
        for(int i=0 ; i<4 ; i++){
            System.out.println("choisir un pion");
            guess[i] = scanner.nextInt();
        }
        return guess;
    }
    
    /**
     * Cette méthode permet au codeur de donner les indications au décodeur
     * @param combinaison
     * @param guess
     * @return 
     */
    public int[] indications(int[] combinaison,int[] guess){
        
        // nous allons 
        //indications pour les pions ayant meme couleur et meme position
        // petit pion noir représenté par 1
        int c1=0;
        int c2=0;
        for(int i=0;i<4;i++){
        
            if(combinaison[i]==guess[i]){
                c1=c1+1;
            }
        }
        //indication pour les pions ayants des couleurs qui existent dans la combinaison
        //petit pion blanc représenté par 0
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(combinaison[i]==guess[j]){
                    c2=c2+1;
                }
            }
        }
        int[] indications = new int[c1+c2];
        Arrays.fill(indications, 0);
        for(int i=0;i<c1;i++){
            indications[i]=1;
        }
        return indications;
    }
    
    /**
     * Cette méthode permet de vérifier la combinaison du décodeur 
     * @param combinaison
     * @param guess
     * @return 
     */
    public boolean checkguess(int[] combinaison,int[] guess){
        return Arrays.equals(combinaison, guess);
    }
    
    /**
     * Cette méthode permet de lancer un tour de jeu 
     * @param combinaison
     * @param codeur
     * @param decodeur 
     */
    public void tourDeJeu(int[] combinaison, Joueur codeur, Joueur decodeur){
        
        int iter = 1;
        while(iter<13){
            int[] guess = guess();
            int[] indications = indications(combinaison,guess);
            if(checkguess(combinaison,guess)){
                codeur.score= codeur.score + iter;
                System.out.println("manche terminée");
                break;
            }
            iter = iter+1;
        }
        if(iter==13){
            System.out.println("manche terminée");
            codeur.score= codeur.score + 12;
        }
        
    }
    
    public void manche(int nbtour){
        
        int n=0;
        
        while(n<nbtour){
            
        Scanner scanner1 = new Scanner(System.in);
        
        System.out.println("le codeur "+joueur1.nom+" doit choisir une combinaison");
        
        int[] combinaison = new int [4];
        for(int i=0 ; i<4 ; i++){
            System.out.println("choisir un pion");
            combinaison[i] = scanner1.nextInt();
        }
        
        System.out.println("le decodeur "+joueur2.nom+" doit deviner");
        
        tourDeJeu(combinaison, joueur1, joueur2);
        
        Scanner scanner2 = new Scanner(System.in);
        
        System.out.println("le codeur "+joueur2.nom+" doit choisir une combinaison");
        
        int[] combinaison1 = new int [4];
        for(int i=0 ; i<4 ; i++){
            System.out.println("choisir un pion");
            combinaison1[i] = scanner1.nextInt();
        }
        System.out.println("le decodeur "+joueur1.nom+" doit deviner");
        tourDeJeu(combinaison1, joueur2, joueur1);
        
        n = n + 1;
        
    }
        System.out.println("manche terminée, le score de "+ joueur1.nom + "est : " + joueur1.score + 
                "le score de "+ joueur2.nom + "est : " + joueur2.score);
        
    
}}

