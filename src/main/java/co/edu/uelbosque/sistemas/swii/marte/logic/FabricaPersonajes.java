/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class FabricaPersonajes {
    
    public static Personaje crearPersonaje(int posicionInicialCoordenadaX, int posicionInicialCoordenadaY, 
            char direccionInicial){
        
        //Se puede agregar la lógica para tener varios tipos de personajes y no solamente exploradores
        
        return new Explorador(posicionInicialCoordenadaX, posicionInicialCoordenadaY, direccionInicial);
    }
}