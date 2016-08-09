/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

import java.util.ArrayList;

/**
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class Marte {

    private final int tamanoX;
    private final int tamanoY;
    private ArrayList<Explorador> exploradores;
    
    public Marte(int tamanoX, int tamanoY) { 
        this.tamanoX = tamanoX;
        this.tamanoY = tamanoY;
        this.exploradores = new ArrayList<>();
    }

    public int getTamanoX() {
        return tamanoX;
    }

    public int getTamanoY() {
        return tamanoY;
    }
        
    public void agregarNuevoExplorador(int posicionX, int posicionY, char direccion){
        
        Explorador explorador = new Explorador(posicionX, posicionY, direccion);
        explorador.setMundoActual(this);
        exploradores.add(explorador);
    }
    
    public void moverUltimoExplorador(char movimiento){
        exploradores.get(exploradores.size()-1).mover(movimiento);
    }

    public String getPosicionUltimoExplorador() {
        return exploradores.get(exploradores.size()-1).getPosicionFinal();
    }
}