/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swii.marte.util;

/**
 *
 * @author jorgegantiva
 */
public class Mensaje {
    
    public static void mostarError(String mensaje){
        System.out.println("ERROR: " + mensaje);
    }
    
    public static void mostarInformacion(String mensaje){
        System.out.println(mensaje);
    }
}