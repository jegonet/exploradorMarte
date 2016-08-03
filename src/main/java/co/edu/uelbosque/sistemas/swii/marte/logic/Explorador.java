/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.logic;

import static co.edu.uelbosque.sistemas.swii.marte.util.Constantes.*;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class Explorador {
    
    int posicionCoordenadaX;
    int posicionCoordenadaY;
    int direccionGrados = 0;
    Tablero tablero;
    
    public Explorador(int posicionInicialCoordenadaX, int posicionInicialCoordenadaY, 
            char direccionInicial) throws Exception{
        
        if(posicionInicialCoordenadaX<0 || posicionInicialCoordenadaY<0)
            throw new Exception(EXCEPTION_EXPLORADOR_COORDENADAS_INVALIDAS);
        
        this.posicionCoordenadaX = posicionInicialCoordenadaX;
        this.posicionCoordenadaY = posicionInicialCoordenadaY;
        
        setDireccion(direccionInicial);
    }

    protected int getPosicionCoordenadaX() {
        return posicionCoordenadaX;
    }

    protected int getPosicionCoordenadaY() {
        return posicionCoordenadaY;
    }
    
    protected void setTablero(Tablero tablero){
        this.tablero = tablero;
    }
    
    private void setDireccion(char direccion) throws Exception{
        
        switch (direccion) {
            case 'S':
                direccionGrados = 270;
                break;
            case 'O':
                direccionGrados = 180;
                break;
            case 'N':
                direccionGrados = 90;
                break;
            case 'E':
                direccionGrados = 0;
                break;    
            default:
                throw new Exception(EXCEPTION_DIRECCION_NO_SOPORTADA);
        }
    }
    
    private char getCharDireccion(){
        char direccion = 'E';
        
        switch (direccionGrados) {
            case 270:
                direccion = 'S';
                break;
            case 180:
                direccion = 'O';
                break;
            case 90:
                direccion = 'N';
                break;
            default:
                //por defecto es E, es decir 0 grados, por lo que no se asigna valor
                break;
        }
        return direccion;
    }
    
    /**
     * 
     * @param comandoMovimiento Comando permitidos-> D: Giro a la Derecha, I: Giro a la Izquierda, 
     * A: Adelantar o dar paso
     */
    public void mover(char comandoMovimiento) throws Exception {
        switch (comandoMovimiento) {
            case 'D':
                girarDerecha();
                break;
            case 'I':
                girarIzquierda();
                break;
            case 'A':
                darPaso();
                break;
            default:
                throw new Exception(EXCEPTION_EXPLORADOR_COMANDO_MOVIMIENTO_INVALIDO);
        }
    }
    
    protected void girarDerecha(){
        direccionGrados -= 90;
        if(direccionGrados==-90) direccionGrados = 270;
    }
    
    protected void girarIzquierda(){
        direccionGrados += 90;
        if(direccionGrados==360) direccionGrados=0;
    }
    
    protected void darPaso(){
        switch (direccionGrados) {
            case 270:
                if(posicionCoordenadaY>0)
                    posicionCoordenadaY--;
                break;
            case 180:
                if(posicionCoordenadaX>0)
                    posicionCoordenadaX--;
                break;
            case 90:
                if(posicionCoordenadaY<tablero.getTamanoY()-1)
                    posicionCoordenadaY++;
                break;
            default:
                //por defecto es E, es decir 0 grados, por lo que no se asigna valor
                if(posicionCoordenadaX<tablero.getTamanoX()-1)
                    posicionCoordenadaX++;
                break;
        }
    }
    
    public String getPosicionFinal(){
        
        return (String.valueOf(posicionCoordenadaX) + " " 
                + String.valueOf(posicionCoordenadaY) + " "
                + getCharDireccion());
    }
}