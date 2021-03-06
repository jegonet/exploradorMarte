/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
public class ManejadorArchivo {
    
    private File archivoReglas;
    
    public ManejadorArchivo(String ruta) throws FileNotFoundException {
        archivoReglas=new File(ruta);
        if((!archivoReglas.exists()))
          throw new FileNotFoundException("El Archivo del juego no existe");
    }

    public ArrayList<String> leerLineas() throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        
        FileReader fr=new FileReader(archivoReglas);
        BufferedReader br=new BufferedReader(fr);
        String linea = null;
        
        while((linea = br.readLine()) != null){
            lineas.add(linea);
        }
        
        fr.close();
        
        return lineas;
    }
}