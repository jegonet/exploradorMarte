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
public abstract class Personaje  {
    int posicionCoordenadaX;
    int posicionCoordenadaY;
    int direccionGrados = 0;
    Marte mundoActual;
    
    protected abstract int getPosicionCoordenadaX();
    
    protected abstract int getPosicionCoordenadaY();
    
    protected abstract void setMundoActual(Marte mundoActual);
    
    protected abstract void setDireccion(char direccion);
    
    protected abstract char getCharDireccion();
    
    public abstract void mover(char comandoMovimiento);
    
    protected abstract void girarDerecha();
    
    protected abstract void girarIzquierda();
    
    protected abstract void darPaso();
    
    public abstract String getPosicionFinal();
    
    public abstract Personaje clonar();
}