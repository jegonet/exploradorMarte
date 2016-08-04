/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

import static co.edu.uelbosque.sistemas.swii.marte.util.Constantes.*;
import java.util.ArrayList;

/**
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class Tablero {

    private final int tamanoX;
    private final int tamanoY;
    private ArrayList<Explorador> exploradores;
    
    public Tablero(int tamanoX, int tamanoY) throws Exception {
        
        if(tamanoX<1 || tamanoY<1)
            throw new Exception(EXCEPTION_TABLERO_TAMANO_INVALIDO);
        
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
    
    public void agregarExplorador(Explorador explorador) throws Exception{
        
        if(explorador.getPosicionCoordenadaX() >= tamanoX || 
                explorador.getPosicionCoordenadaY() >= tamanoY)
            throw new Exception(EXCEPTION_EXPLORADOR_FUERA_MUNDO);
        
        explorador.setTablero(this);
        exploradores.add(explorador);
    }
}