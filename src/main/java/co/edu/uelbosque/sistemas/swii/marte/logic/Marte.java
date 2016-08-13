/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

/**
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class Marte extends Mundo {

    protected Marte() { 
        super();
    }
       
    @Override
    public void agregarNuevoExplorador(Personaje personaje){
       
        personaje.setMundoActual(this);
        personajes.add(personaje);
    }
    
    @Override
    public void moverUltimoExplorador(char movimiento){
        personajes.get(personajes.size()-1).mover(movimiento);
    }
}