/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

import java.util.ArrayList;

/**
 *
 * @author Jorge Eliécer Gantiva
 */
public abstract class Mundo {
    protected int tamanoX;
    protected int tamanoY;
    protected ArrayList<Personaje> personajes;
    
    protected Mundo(){
        this.tamanoX = 0;
        this.tamanoY = 0;
        this.personajes = new ArrayList<>();
    }
    
    public void dimensionar(int tamanoX, int tamanoY){
        this.tamanoX = tamanoX;
        this.tamanoY = tamanoY;
    }

    public int getTamanoX() {
        return tamanoX;
    }

    public int getTamanoY() {
        return tamanoY;
    }
    
    public String getPosicionUltimoExplorador() {
        return personajes.get(personajes.size()-1).getPosicionFinal();
    }
        
    public abstract void agregarNuevoExplorador(Personaje personaje);
    
    public abstract void moverUltimoExplorador(char movimiento);
}