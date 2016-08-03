/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.ui;

import co.edu.uelbosque.sistemas.swii.marte.logic.Explorador;
import co.edu.uelbosque.sistemas.swii.marte.logic.Tablero;
import co.edu.uelbosque.sistemas.swii.marte.util.ManejadorArchivo;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class Juego {
   
    private static String strTableroSize;
    private static ArrayList<String> strExploradoresComandos;
    private static Tablero tablero;
    
    public static void main(String args[]) throws FileNotFoundException{
        leerConfiguracion();
        
        int tableroTamanoX = Integer.parseInt(strTableroSize.split(" ")[0]);
        int tableroTamanoY = Integer.parseInt(strTableroSize.split(" ")[0]);
        
        try {
            tablero = new Tablero(tableroTamanoX, tableroTamanoY);
        
            for(String exploradorComando: strExploradoresComandos) {
                String posicionInicial = exploradorComando.split("|")[0];
                String movimientos = exploradorComando.split("|")[1];

                Explorador explorador = new Explorador(
                        Integer.parseInt(posicionInicial.split(" ")[0]), 
                        Integer.parseInt(posicionInicial.split(" ")[1]),
                        (posicionInicial.split(" ")[2]).toCharArray()[0]
                );

                tablero.agregarExplorador(explorador);
            
                for(char comandoMovimiento: movimientos.toCharArray()) {
                    explorador.mover(comandoMovimiento);
                }
            }
        }
        catch(Exception ex) {
            
        }
    }
    
    public static boolean leerConfiguracion(){
        
        ManejadorArchivo manejadorArchivo;
         
        try{
            manejadorArchivo = new ManejadorArchivo("src/main/resources/reglas.txt");
        }
        catch(FileNotFoundException ex){
            
            return false;
        }
       
        String lineaArchivo;
        int numeroLineas = 0;
        String tmpPosicionExplorador = "";
     
        try{
            while((lineaArchivo=manejadorArchivo.leerLinea()) !=  null)
            {
                numeroLineas++;

                if(numeroLineas==1){
                    validarLineaTamanoMundo(lineaArchivo);
                    strTableroSize = lineaArchivo;
                }
                else if(numeroLineas % 2 == 0) //Posicion Explorador
                {
                    validarLineaPosicionExplorador(lineaArchivo);
                    tmpPosicionExplorador = lineaArchivo;
                }
                else if(numeroLineas % 2 == 1) //Movimientos Explorador
                {
                    validarLineaMovimientosExplorador(lineaArchivo);

                    strExploradoresComandos.add(tmpPosicionExplorador + "|" + lineaArchivo);
                    tmpPosicionExplorador = "";
                }
            }
        }
        catch(IOException ex){
         
            return false;
        }
        
        return true;
    }
    
    public static void validarLineaTamanoMundo(String linea){
        
    }
    
    public static void validarLineaPosicionExplorador(String linea){
        
    }
    
    public static void validarLineaMovimientosExplorador(String linea){
        
    }
}