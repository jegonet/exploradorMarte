/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.unittest;

import co.edu.uelbosque.sistemas.swii.marte.util.ManejadorArchivo;
import co.edu.uelbosque.sistemas.swii.marte.logic.Tablero;
import static co.edu.uelbosque.sistemas.swii.marte.util.Constantes.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Jorge Eliecer Gantiva Ochoa
 */
@Test
public class ProbarArchivoEntrada {
    
    @Test
    public void archivoExiste() throws FileNotFoundException{
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO);
    }
    
    @Test(expectedExceptions = FileNotFoundException.class)
    public void archivoNoExiste() throws FileNotFoundException{
        ManejadorArchivo manejador=new ManejadorArchivo("reglas.txt");
    }
    
    @Test
    public void archivoCompleto() throws FileNotFoundException, IOException{
        
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();        
        
        boolean valido = (lineasArchivo.size() % 2 == 1 && lineasArchivo.size()>2);
        
        Assert.assertTrue(valido);
    }
    
    @Test
    public void archivoIncompleto() throws FileNotFoundException, IOException{
        
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO_INCOMPLETO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();        
        
        boolean valido = (lineasArchivo.size() % 2 == 1 && lineasArchivo.size()>2);
        
        Assert.assertTrue(!valido);
    }
    
    @Test
    public void lineaTamanoMundoValido() throws FileNotFoundException, IOException{

        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Pattern patron = Pattern.compile("^[1-9]\\d* [1-9]\\d*$");
        
        Assert.assertTrue(patron.matcher(lineasArchivo.get(0)).matches());        
    }
    
    @Test
    public void lineaTamanoMundoInvalido() throws FileNotFoundException, IOException{

        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO_INVALIDO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Pattern patron = Pattern.compile("^[1-9]\\d* [1-9]\\d*$");
        
        Assert.assertTrue(!patron.matcher(lineasArchivo.get(0)).matches());
    }
    
    @Test
    public void lineaTamanoMundoValidoV2() throws FileNotFoundException, IOException, Exception{
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Tablero tablero = new Tablero(
               Integer.parseInt(lineasArchivo.get(0).split(" ")[0]),
               Integer.parseInt(lineasArchivo.get(0).split(" ")[1]));
    }
    
    @Test
    public void lineasPosicionExploradoresValidas() throws FileNotFoundException, IOException{
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Pattern patron = Pattern.compile("^\\d+ \\d+ (N|S|E|O)$");
        
        for(int i=1;i<lineasArchivo.size(); i=i+2){
            if(!patron.matcher(lineasArchivo.get(i)).matches()){
                Assert.assertTrue(false);
                return;
            }
        }
        Assert.assertTrue(true);
    }
    
    @Test
    public void lineasPosicionExploradoresInvalidas() throws FileNotFoundException, IOException{
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO_INVALIDO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Pattern patron = Pattern.compile("^\\d+ \\d+ (N|S|E|O)$");
        
        for(int i=1;i<lineasArchivo.size(); i=i+2){
            if(!patron.matcher(lineasArchivo.get(i)).matches()){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertTrue(false);
    }
    
    @Test
    public void lineasMovimientosExploradoresValidos() throws FileNotFoundException, IOException{
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Pattern patron = Pattern.compile("^(A|D|I)+$");
        
        for(int i=2;i<lineasArchivo.size(); i=i+2){
            if(!patron.matcher(lineasArchivo.get(i)).matches()){
                Assert.assertTrue(false);
                return;
            }
        }
        Assert.assertTrue(true);
    }
    
    @Test
    public void lineasMovimientoExploradoresInvalidos() throws FileNotFoundException, IOException{
        ManejadorArchivo manejador=new ManejadorArchivo(RUTA_ARCHIVO_INVALIDO);
        ArrayList<String> lineasArchivo = manejador.leerLineas();
        
        Pattern patron = Pattern.compile("^(A|D|I)+$");
        
        for(int i=2;i<lineasArchivo.size(); i=i+2){
            if(!patron.matcher(lineasArchivo.get(i)).matches()){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.assertTrue(false);
    }
}