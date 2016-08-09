/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.unittest;

import co.edu.uelbosque.sistemas.swii.marte.ui.Juego;
import static co.edu.uelbosque.sistemas.swii.marte.util.Constantes.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Jorge Eliécer Gantiva Ochoa
 */
@Test
public class ProbarJuego {
    
    @Test
    public void archivoExiste() {
        Assert.assertTrue(Juego.cargarArchivoEntrada(RUTA_ARCHIVO_INVALIDO));
    }
    
    @Test
    public void archivoNoExiste() {
        Assert.assertTrue(!Juego.cargarArchivoEntrada("reglas-no-existe.txt"));
    }
    
    @Test
    public void archivoCompleto() {
        Assert.assertTrue(Juego.cargarArchivoEntrada(RUTA_ARCHIVO));
    }
    
    @Test
    public void archivoIncompleto() {
        Assert.assertTrue(!Juego.cargarArchivoEntrada(RUTA_ARCHIVO_INCOMPLETO));
    }
   
    @Test
    public void dimensionarMarteValido() {
        Assert.assertTrue(Juego.dimensionarMarte("30 40"));
    }
    
    @Test
    public void dimensionarMarteFormatoInvalido() {        
        Assert.assertTrue(!Juego.dimensionarMarte(" 3  4 N "));
    }
    
    @Test
    public void dimensionarMarteConCeroV1() {
        Assert.assertTrue(!Juego.dimensionarMarte("0  4"));
    }
    
    @Test
    public void dimensionarMarteConCeroV2() {
        Assert.assertTrue(!Juego.dimensionarMarte("5  0"));
    }
    
    @Test
    public void dimensionarMarteNegativoV1() {
        Assert.assertTrue(!Juego.dimensionarMarte("-5  4"));
    }
    
    @Test
    public void dimensionarMarteNegativoV2() {
        Assert.assertTrue(!Juego.dimensionarMarte("5  -4"));
    }
    
    @Test
    public void posicionExploradorValida() { 
        Juego.dimensionarMarte("30 40");
        Assert.assertTrue(Juego.posicionarNuevoExplorador("1 2 N"));
    }
    
    @Test
    public void posicionExploradorFormatoInvalido() { 
        Juego.dimensionarMarte("3 4");
        Assert.assertTrue(!Juego.posicionarNuevoExplorador(" 1 2 N T "));
    }
    
    @Test
    public void posicionExploradorNegativaV1() {
        Juego.dimensionarMarte("3 4");
        Assert.assertTrue(!Juego.posicionarNuevoExplorador("-1 2 N"));
    }
    
    @Test
    public void posicionExploradorNegativaV2() { 
        Juego.dimensionarMarte("3 4");
        Assert.assertTrue(!Juego.posicionarNuevoExplorador("1 -2 N"));
    }
    
    @Test
    public void posicionExploradorDireccionInvalida() {
        Juego.dimensionarMarte("3 4");
        Assert.assertTrue(!Juego.posicionarNuevoExplorador("1 2 Y"));
    }
    
    @Test
    public void posicionExploradorFueraDeMarteV1() {
        Juego.dimensionarMarte("3 4");
        Assert.assertTrue(!Juego.posicionarNuevoExplorador("3 1 N"));
    }
    
    @Test
    public void posicionExploradorFueraDeMarteV2(){
        Juego.dimensionarMarte("3 4");
        Assert.assertTrue(!Juego.posicionarNuevoExplorador("2 4 N"));
    }
    
    @Test
    public void moverExploradorValido(){
        Juego.dimensionarMarte("5 5");
        Juego.posicionarNuevoExplorador("1 2 N");
        Assert.assertEquals(Juego.moverUltimoExploradorMarte("IAIAIAIAA"), "1 3 N");
    }
    
    @Test
    public void moverExploradorValidoV2(){
        Juego.dimensionarMarte("5 5");
        Juego.posicionarNuevoExplorador("3 3 E");
        Assert.assertEquals(Juego.moverUltimoExploradorMarte("AADAADADDA"), "4 1 E");
    }
    
    @Test
    public void moverExploradorInvalido(){
        Juego.dimensionarMarte("5 5");
        Juego.posicionarNuevoExplorador("3 3 E");
        Assert.assertEquals(Juego.moverUltimoExploradorMarte("AATDAIADADDA"), null);
    }
    
    @Test
    public void moverExploradorInvalidoV2(){
        Juego.dimensionarMarte("5 5");
        Juego.posicionarNuevoExplorador("3 3 E");
        Assert.assertEquals(Juego.moverUltimoExploradorMarte(" AADAADADDA "), null);
    }
}