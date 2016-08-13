/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.ui;

import co.edu.uelbosque.sistemas.swii.marte.logic.*;
import static co.edu.uelbosque.sistemas.swii.marte.util.Constantes.*;
import co.edu.uelbosque.sistemas.swii.marte.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public abstract class Juego {
   
    private static ArrayList<String> strLineasArchivo;
    private static Mundo mundoActual;
    
    public static void main(String args[]) {
        
        if(cargarArchivoEntrada(RUTA_ARCHIVO))
            leerLineasJuego();
        System.exit(0);
    }
    
    public static boolean cargarArchivoEntrada(String RUTA_ARCHIVO) {
        
        try{
            ManejadorArchivo manejadorArchivo = new ManejadorArchivo(RUTA_ARCHIVO);
            strLineasArchivo = manejadorArchivo.leerLineas();
            
            if(strLineasArchivo.size() % 2 == 0 || strLineasArchivo.size()<3){
                Mensaje.mostarError("Archivo de juego incompleto");
                return false;
            }
        }
        catch(FileNotFoundException ex){
            Mensaje.mostarError("Archivo de juego no encontrado. " + ex.getMessage());
            return false;
        }
        catch(IOException ex){
         
            Mensaje.mostarError("Archivo de juego encontrado pero no se puede leer. " + 
                    ex.getMessage());
            return false;
        }
        
        return true;
    }
    
    public static boolean leerLineasJuego(){
        int numeroLineas = 0;

        for(String lineaArchivo: strLineasArchivo){
            numeroLineas++;

            if(numeroLineas==1){                    
                if(!dimensionarMarte(lineaArchivo))
                    return false;
            }
            else if(numeroLineas % 2 == 0) {
                if(!posicionarNuevoExplorador(lineaArchivo))
                    return false;
            }
            else if(numeroLineas % 2 == 1) {
                String posicionFinal = moverUltimoExploradorMarte(lineaArchivo);
                
                if(posicionFinal!=null)
                     Mensaje.mostarInformacion(posicionFinal);
                else
                    return false;
            }
        }
        return true;
    }
    
    public static boolean dimensionarMarte(String strDimension) {
        
        if(validarTamanoMarte(strDimension)){
            try{
                int tableroTamanoX = Integer.parseInt(strDimension.split(" ")[0]);
                int tableroTamanoY = Integer.parseInt(strDimension.split(" ")[1]);

                mundoActual = FabricaMundos.getMundoActual(FabricaMundos.TipoMundo.Marte);
                mundoActual.dimensionar(tableroTamanoX, tableroTamanoY); 
                return true;
            }
            catch(NumberFormatException ex){
                Mensaje.mostarError("Marte no puede tomar dimensiones no numéricas: '" + strDimension + "'. " +
                        ex.getMessage());
            }
        }
   
        return false;
    }
        
    public static boolean posicionarNuevoExplorador(String strPosicion) {
        
        if(validarPosicionExplorador(strPosicion)){
            mundoActual.agregarNuevoExplorador(
                    (new FabricaPersonajes()).construirExploradorDesdePrototipo(strPosicion));
            return true;
        }
        return false;
    }
    
    /**
     * Realiza los movimientos del último explorador en Marte
     * @param strMovimientos Cadena de texto con los comandos de movimiento a realizar del último explorador en Marte
     * @return Cadena de texto con la posicion final del explorador. En caso de error se retorna NULL
     */
    public static String moverUltimoExploradorMarte(String strMovimientos) {
        
        if(validarLineaMovimientosExplorador(strMovimientos)){

            for(char movimiento : strMovimientos.toCharArray()) {
                mundoActual.moverUltimoExplorador(movimiento);
            }
            return mundoActual.getPosicionUltimoExplorador();
        }
        return null;
    }
    
    private static boolean validarTamanoMarte(String linea){
        Pattern patron = Pattern.compile("^[1-9]\\d* [1-9]\\d*$");        
        boolean valido = patron.matcher(linea).matches();
        
        if(!valido)
            Mensaje.mostarError("Marte no puede tomar la dimensión indicada: '" + linea + "'");
        
        return valido;
    }
    
    private static boolean validarPosicionExplorador(String linea){
        
        Pattern patron = Pattern.compile("^\\d+ \\d+ (N|S|E|O)$");    
        boolean valido = patron.matcher(linea).matches();
        
        if(!valido)
            Mensaje.mostarError("La posición del Explorador no es válida: '" + linea + "'");
        else{ 
            int posicionX = Integer.parseInt(linea.split("\\s")[0]);
            int posicionY = Integer.parseInt(linea.split("\\s")[1]);

            if (mundoActual.getTamanoX()<=posicionX || mundoActual.getTamanoY()<=posicionY){
                Mensaje.mostarError("La posición del Explorador no es válida según el tamaño de Marte: '" 
                        + linea + "'");
                valido = false;
            }
        }
        return valido;
    }
   
    private static boolean validarLineaMovimientosExplorador(String linea) {
        Pattern patron = Pattern.compile("^(A|D|I)+$");    
        boolean valido = patron.matcher(linea).matches();
        
        if(!valido)
            Mensaje.mostarError("Se encontraron movimientos inválidos para el explorador: '" + linea + "'");
        
        return valido;
    } 
}