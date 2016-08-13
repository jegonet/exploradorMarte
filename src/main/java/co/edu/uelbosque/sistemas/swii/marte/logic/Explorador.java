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
public class Explorador extends Personaje {
    
    /*int posicionCoordenadaX;
    int posicionCoordenadaY;
    int direccionGrados = 0;
    Marte mundoActual;*/
    
    public Explorador(int posicionInicialCoordenadaX, int posicionInicialCoordenadaY, 
            char direccionInicial){
        
        this.posicionCoordenadaX = posicionInicialCoordenadaX;
        this.posicionCoordenadaY = posicionInicialCoordenadaY;
        setDireccion(direccionInicial);
    }

    @Override
    protected int getPosicionCoordenadaX() {
        return posicionCoordenadaX;
    }
    
    @Override
    protected int getPosicionCoordenadaY() {
        return posicionCoordenadaY;
    }
    
    @Override
    protected void setMundoActual(Marte mundoActual){
        this.mundoActual = mundoActual;
    }
    
    @Override
    protected void setDireccion(char direccion) {
        
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
        }
    }
    
    @Override
    protected char getCharDireccion(){
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
    @Override
    public void mover(char comandoMovimiento) {
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
        }
    }
    
    @Override
    protected void girarDerecha(){
        direccionGrados -= 90;
        if(direccionGrados==-90) direccionGrados = 270;
    }
    
    @Override
    protected void girarIzquierda(){
        direccionGrados += 90;
        if(direccionGrados==360) direccionGrados=0;
    }
    
    @Override
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
                if(posicionCoordenadaY<mundoActual.getTamanoY()-1)
                    posicionCoordenadaY++;
                break;
            default:
                //por defecto es E, es decir 0 grados, por lo que no se asigna valor
                if(posicionCoordenadaX<mundoActual.getTamanoX()-1)
                    posicionCoordenadaX++;
                break;
        }
    }
    
    @Override
    public String getPosicionFinal(){
        
        return (String.valueOf(posicionCoordenadaX) + " " 
                + String.valueOf(posicionCoordenadaY) + " "
                + getCharDireccion());
    }
    
    @Override
    public Personaje clonar(){
        return new Explorador(this.posicionCoordenadaX, this.posicionCoordenadaY, 
                this.getCharDireccion());
    }
}