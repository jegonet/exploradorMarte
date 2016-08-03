/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.c1.marte.unittest;

import co.edu.uelbosque.sistemas.swii.marte.util.ManejadorArchivo;
import co.edu.uelbosque.sistemas.swii.marte.logic.Tablero;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alejandro
 */
public class ProbarManejadorDeArchivo {
    
    @Test(expectedExceptions = FileNotFoundException.class)
    public void elArchivoNoExiste() throws FileNotFoundException{
        ManejadorArchivo manejador=new ManejadorArchivo();
        manejador.setRutaArchivo("reglas.txt");
    }
    
    @Test
    public void elArchivoExiste() throws FileNotFoundException{
        ManejadorArchivo manejador=new ManejadorArchivo();
        manejador.setRutaArchivo("src/main/resources/reglas.txt");
    }
    
    @Test
    public void laPrimerLineaDelArchivoEsCorrecta() throws FileNotFoundException, IOException{
        String texperado="7 6";
        ManejadorArchivo manejador=new ManejadorArchivo();
        manejador.setRutaArchivo("src/main/resources/reglas.txt");
        String t=manejador.getPrimeraLinea();
        Assert.assertTrue(texperado.equals(t));
    }
    
    @Test
    public void laLineDeCoordenadasEsCorrecta() throws FileNotFoundException, IOException{
        String texperado="1 7 N";
        //ManejadorArchivo manejador=new ManejadorArchivo();
        //manejador.setRutaArchivo("src/main/resources/reglas.txt");
        //String t=manejador.getSegundaLinea();
        //Assert.assertTrue(texperado.equals(t));
    }
    
}
