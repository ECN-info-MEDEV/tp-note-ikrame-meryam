/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.projet.objet.tpnote;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author T480
 */
public class JeuTest {
    
    public JeuTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of checkguess method, of class Jeu.
     */
    @Test
    public void testCheckguess() {
        System.out.println("Test de checkguess");
        int[] combinaison = {1, 2, 2, 1};
        int[] guess = {1, 3, 5, 1};
        Jeu jeu = new Jeu("Meryam", "Ikrame");
        boolean result = jeu.checkguess(combinaison, guess);
        assertEquals(false, result);
        
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
    /**
     * Test of indications method, of class Jeu. 
     */
    @Test
    public void testIndications(){
        System.out.println("Test de indications");
        int[] combinaison = {1, 2, 2, 1};
        int[] guess = {1, 3, 5, 1};
        Jeu jeu = new Jeu("Meryam", "Ikrame");
        int [] expect = {1,1,0,0};
        int[] result = jeu.indications(combinaison, guess);
        assertEquals(Arrays.stream(expect).sum(), Arrays.stream(result).sum());
        
    }
}    

