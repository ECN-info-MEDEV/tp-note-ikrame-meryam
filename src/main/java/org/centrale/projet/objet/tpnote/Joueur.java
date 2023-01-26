/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.projet.objet.tpnote;

/**
 * Cette classe définit le joueur (nom, role et score) 
 * @author Meryam
 */
public class Joueur {
    
    public String nom;
    public int role; //Codeur ou décodeur 
    public int score; 
    
    public Joueur(String nom,int role){
        this.nom = nom;
        this.role = role;
        this.score = 0;
    }
}
